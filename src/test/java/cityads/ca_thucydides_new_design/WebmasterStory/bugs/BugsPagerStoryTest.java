package cityads.ca_thucydides_new_design.WebmasterStory.bugs;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.BaseSteps;
import cityads.ca_thucydides_new_design.steps.MainSiteSteps;
import cityads.ca_thucydides_new_design.steps.SetupSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.BannerRotatorSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.BugsSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.ExchangeSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.OfferListSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.StatisticSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.TopWMSteps;
import junit.framework.Assert;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.Bugs.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="pager bugs")
public class BugsPagerStoryTest extends Constants {



    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    String dateFirstPage;
    String dateSecondPage;
    
    
    @Steps
    public BannerRotatorSteps banrot;
    
    @Steps
    public BugsSteps bs;
    
    @Steps
    public SetupSteps ss;
    
    @Steps
    public StatisticSteps stat;
    
    @Steps
    public TopWMSteps topwm;

    @Steps
    public  OfferListSteps offer;
    
   
    
    //@Test стата пейджер 
     public void check_33355_stats() throws Exception{
      String wmName = ss.get_wm_name();  
       bs.wm_login(wmName);
       bs.click_statistic_link();
       bs.wait_for_all_spinners_dissapears(60);
     
       bs.wait_for_h1_title_appears("По офферам", 25);
       String first_id = bs.get_first_offer_id_stats();
       bs.wait_for_all_spinners_dissapears(30);
       bs.click_go_next_page();
       bs.wait_for_all_spinners_dissapears(30);
       bs.check_fatal_errors();
       String second_id = bs.get_first_offer_id_stats(); 
       bs.check_string_has_changed(first_id,second_id);
       bs.close_browser();
    }
         
  
  
   @Test  // купоны пейджер
    public void check_33355_cupons(){
     
     String wmName = ss.get_wm_name();  
     bs.wm_login(wmName);
     bs.click_goods_and_coupons_link();
     bs.wait_for_all_spinners_dissapears(30);
     bs.click_coupons_and_promocodes_link();
     bs.wait_for_all_spinners_dissapears(30);
     bs.wait_for_h1_title_appears("", 30);
 
     
     
     int couponCount = Integer.parseInt(bs.get_coupons_count());
     if(couponCount > 20) {
         String first = bs.get_first_coupon_text();
         bs.click_go_next_page();
         bs.wait_for_all_spinners_dissapears(30);
         bs.scroll_top();
         bs.wait_for_all_spinners_dissapears(30);
         String second = bs.get_first_coupon_text();
         bs.check_string_has_changed(first,second); }
     bs.close_browser();
   }
  
}
