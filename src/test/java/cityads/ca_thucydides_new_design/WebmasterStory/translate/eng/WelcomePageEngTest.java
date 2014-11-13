package cityads.ca_thucydides_new_design.WebmasterStory.translate.eng;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.BaseSteps;
import cityads.ca_thucydides_new_design.steps.SetupSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.BugsSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.OfferListSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.ProfileSteps;
import java.sql.Connection;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTagValuesOf;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.Translate.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class WelcomePageEngTest extends Constants {

     public Connection con;

     
    

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public BaseSteps steps;
    
    @Steps
    public SetupSteps ssteps;
    
   
   
   @Test
   @WithTagValuesOf({"block:Traslation","role:Webmaster"})
    public void check_welcomepage_translate(){
        String wmName = ssteps.get_wm_name();  
        steps.wm_login(wmName);
        steps.wait_for_all_spinners_dissapears(30);
        steps.change_lang_to_en();
        steps.wait_for_all_spinners_dissapears(30);
        steps.executeScript("welcomToCityAds();");
        steps.wait_for_popup_appears(60);
        steps.wait_for_map(30);
        steps.check_welcomepage_translate();
        
     
        steps.click_dalee_welcome_page_1();
        steps.wait_for_all_spinners_dissapears(60);
        
        steps.check_welcomepage_translate();
      
        steps.click_dalee_welcome_page_2();
        
        steps.wait_for_all_spinners_dissapears(60);
        steps.check_welcomepage_translate();
  
        
        steps.close_browser();
   }
  
} 