package cityads.ca_thucydides_new_design.WebmasterStory.translate.br;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.BaseSteps;
import cityads.ca_thucydides_new_design.steps.SetupSteps;
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
public class WelcomePageTranslateStoryTest{

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
   @Title("Велкомпейдж переводы")
   @WithTagValuesOf({"block:Traslation","role:Webmaster"})
    public void check_welcomepage_translate(){
        String wmName = ssteps.get_wm_name();  
        steps.wm_login(wmName);
        steps.change_lang_to_br();
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