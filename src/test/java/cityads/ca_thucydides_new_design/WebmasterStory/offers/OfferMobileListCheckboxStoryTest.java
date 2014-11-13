package cityads.ca_thucydides_new_design.WebmasterStory.offers;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.OfferListSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.sql.Connection;


@Story(TestSuite.WebMaster.OfferList.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class OfferMobileListCheckboxStoryTest extends Constants {

     public Connection con;
     public String wmName;
     private String offerName;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;
    
    @Steps
    public OfferListSteps steps;
    
 
//    @Test @WithTagValuesOf({"block:Offers", "role:Webmaster"})@Pending
//    public  void wm_mobile_offer_list_count_categories_test() throws Exception{
//
//        
//        wmName = steps.get_wm_name();
//        steps.wm_login(wmName);
//        steps.click_offer_link();
//        steps.wait_for_all_spinners_dissapears(60);
//        steps.wait_for_spinner_dissapear(60);
//        steps.wait_for_opacity_spinner_dissapear(25); 
//        steps.click_mobile_offers();
//        steps.wait_for_all_spinners_dissapears(60);
//        steps.wait_for_offers_table_appears(25);
//        
//        
//        
//        
//    
//        steps.wait_for_all_spinners_dissapears(60);
//        steps.wait_for_offers_table_appears(25);
//        steps.waitAjax(5000);
//        int categoriesNumber = steps.get_offers_count_in_filter();
//        
//        steps.check_value_gteater_then_min(categoriesNumber, 50);
//        
//
//        
//        steps.close_browser();
//        
//    }
    
/*    @Test @WithTagValuesOf({"block:Offers", "role:Webmaster"})
    public  void wm_mobile_offer_list_count_regions_test() throws Exception{
   
        wmName = steps.get_wm_name();
        steps.wm_login(wmName);
        steps.click_offer_link();
        steps.wait_for_all_spinners_dissapears(60);
        steps.wait_for_spinner_dissapear(60);
        steps.wait_for_opacity_spinner_dissapear(25); 
        steps.click_mobile_offers();
        steps.wait_for_all_spinners_dissapears(60);
        steps.click_reset_filter_button();
        steps.wait_for_all_spinners_dissapears(120);
        steps.wait_for_blue_table_appears(25);
        steps.waitAjax(5000);
        int regionsNumber = steps.get_offers_regions_count_in_filter();
        
        steps.check_value_gteater_then_min(regionsNumber, 0);
        

        
        steps.close_browser();
        
    }*/
    
       @Test @WithTagValuesOf({"block:Offers", "role:Webmaster"})
    public  void wm_mobile_offer_list_count_traffic_test() throws Exception{
   
        wmName = steps.get_wm_name();
        steps.wm_login(wmName);
        steps.click_offer_link();
        
        steps.wait_for_all_spinners_dissapears(60);
        steps.wait_for_opacity_spinner_dissapear(25); 
        steps.click_mobile_offers();
        steps.wait_for_all_spinners_dissapears(60);
        steps.wait_for_blue_table_appears(25);
        
        int trafficNumber = steps.get_offers_traffic_count_in_filter();
        
        steps.check_value_gteater_then_min(trafficNumber, 10);
        

        
        steps.close_browser();
    } 
}