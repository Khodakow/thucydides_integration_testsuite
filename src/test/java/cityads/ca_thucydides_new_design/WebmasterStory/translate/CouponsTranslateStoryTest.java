package cityads.ca_thucydides_new_design.WebmasterStory.translate;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.SetupSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.BugsSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.ProfileSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.sql.Connection;


@Story(TestSuite.WebMaster.Translate.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class CouponsTranslateStoryTest extends Constants {

     public Connection con;
     public String wmName;
     public String rotatorName = getCurrentDate();
     private String  bannerSize1;
     private String  bannerSize2;
     private String  bannerSize3;
     protected String AJSCode;
     protected String JSCode;
     
    

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public BugsSteps bs;

    @Steps
    public ProfileSteps profile;
    

    @Steps
    public SetupSteps ss;




  
   @Test
   @WithTagValuesOf({"block:Traslation","role:Webmaster"})
   @Title("Купоны переводы")
    public void checkCouponsTranslation(){
    String wmName = ss.get_wm_name();  
    bs.wm_login(wmName);
    bs.wait_for_all_spinners_dissapears(90);
    bs.click_goods_and_coupons_link();
    bs.wait_for_all_spinners_dissapears(90);
    bs.change_lang_to_br();
    bs.wait_for_all_spinners_dissapears(90);
    bs.executeScript("$('div.col.size-16.ib').html('')");                   //убираем описание купона
    bs.executeScript("$('div.col-evil.margin-top-small.lh-16').html('')");  //убираем описание купона
    bs.executeScript("$('button[type=\"submit\"]').empty();");
    bs.executeScript("$('div[class=\\\"col-evil margin-top-small lh-16\\\"]').text('');");
    bs.executeScript("$('div[class=\"col size-16 ib\"]').text('');");
    bs.check_lang_select();
    bs.close_browser();
   }
  
} 