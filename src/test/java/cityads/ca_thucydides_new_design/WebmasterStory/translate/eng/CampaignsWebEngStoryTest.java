package cityads.ca_thucydides_new_design.WebmasterStory.translate.eng;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.SetupSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.OfferListSteps;
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
public class CampaignsWebEngStoryTest extends Constants {

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
    public OfferListSteps os;
    
    @Steps
    public ProfileSteps profile;
    
    @Steps
    public SetupSteps ss;


   @Test
   @Title("Перевод англ веб-офферы")
   @WithTagValuesOf({"block:Traslation","role:Webmaster"})
    public void checkWebCampaignsTranslation(){
    String wmName = ss.get_wm_name();  
    os.wm_login(wmName);
    os.change_lang_to_en();
    os.check_lang_select();

        os.click_offer_link();
        os.wait_for_spinner_dissapear(30);
        os.wait_for_opacity_spinner_dissapear(25); 
        os.click_web_offers();
        os.wait_for_all_spinners_dissapears(60);
        os.executeScript("$('button[type=\"submit\"]').empty();");
        os.check_lang_select();
    os.close_browser();
   }
  
} 