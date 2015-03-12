package cityads.ca_thucydides_new_design.WebmasterStory.translate.br;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.SetupSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.OfferListSteps;
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
public class CampaignsWebTranslateStoryTest{

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
    public SetupSteps ss;
  


   @Test
   @Title("Веб офферы переводы")
   @WithTagValuesOf({"block:Traslation","role:Webmaster"})
    public void checkCampaignsWebTranslation(){
    String wmName = ss.get_wm_name();  
    os.wm_login(wmName);
    os.change_lang_to_br();
    
        os.click_offer_link();
        os.wait_for_spinner_dissapear(30);
        os.wait_for_opacity_spinner_dissapear(25);
        os.executeScript("$('button[type=\"submit\"]').empty();");
        os.check_lang_select();
    os.close_browser();
   }

} 