package cityads.ca_thucydides_new_design.WebmasterStory.translate.eng;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.BaseSteps;
import cityads.ca_thucydides_new_design.steps.MainSiteSteps;
import cityads.ca_thucydides_new_design.steps.RegistrationSteps;
import cityads.ca_thucydides_new_design.steps.SetupSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.BugsSteps;
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
public class RegistrationEnStoryTest extends Constants {
    

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    

    @Steps
    public RegistrationSteps steps;

    @Steps
    public BaseSteps bSteps;
    
    @Test
    @WithTagValuesOf({"block:Traslation","role:Webmaster"})
    public void check_wm_registration_translation(){

        steps.open_main_page();
        steps.click_login_button();
        steps.click_start_button();
        steps.check_registration_form_is_displayed();
        steps.select_en_language();
        steps.check_lang_select();
     
    }
    
    @Test
    @WithTagValuesOf({"block:Traslation","role:Webmaster"})
    public void check_wm_registration_translation_after_login(){
        
        String wmName = steps.get_wm_name();
        steps.wm_login(wmName);
        steps.open_main_page();
        steps.ckick_start_work();
        steps.select_en_language();
        steps.check_lang_select();
        steps.close_browser();
     
    }
   
    @Test
    @WithTagValuesOf({"block:Traslation","role:Webmaster"})
    public void check_wm_lost_password_translation(){

        steps.open_main_page();
        steps.click_login_button();
        steps.enter_login("qweqweqwe");
        steps.enter_password("213123123");
        steps.click_enter_button();
        steps.select_en_language();
        steps.click_forgot_password_link();
        steps.submit_form();
        steps.check_lang_select();
        steps.close_browser();
     
    }
    
    
    
} 