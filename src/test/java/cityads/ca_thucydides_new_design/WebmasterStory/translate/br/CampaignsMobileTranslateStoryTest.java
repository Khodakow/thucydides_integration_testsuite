package cityads.ca_thucydides_new_design.WebmasterStory.translate.br;

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
public class CampaignsMobileTranslateStoryTest{

     public Connection con;
     public String wmName;
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
   @Title("Мобильные офферы переводы")
   @WithTagValuesOf({"block:Traslation","role:Webmaster"})
    public void checkMobileCampaignsTranslation(){
    String wmName = ss.get_wm_name();
    os.wm_login(wmName);
    os.change_lang_to_br();

        os.click_offer_link();
        os.wait_for_all_spinners_dissapears();
        os.click_mobile_offers();
        os.wait_for_all_spinners_dissapears();
        os.executeScript("$('button[type=\"submit\"]').empty();");
        os.executeScript("$('td[class=\"name\"]').text('')");
        os.check_lang_select();
    os.close_browser();
   }
  
} 