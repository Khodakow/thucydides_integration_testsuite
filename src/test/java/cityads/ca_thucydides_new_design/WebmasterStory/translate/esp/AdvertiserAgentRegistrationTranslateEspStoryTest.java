package cityads.ca_thucydides_new_design.WebmasterStory.translate.esp;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.BaseSteps;
import cityads.ca_thucydides_new_design.steps.RegistrationSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.Translate.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class AdvertiserAgentRegistrationTranslateEspStoryTest {
    

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    

    @Steps
    public RegistrationSteps steps;

    @Steps
    public BaseSteps bSteps;
    
    @Test
    @Title("Регистрация рекла Esp переводы")
    @WithTagValuesOf({"block:Traslation","role:Webmaster"})
    public void check_adv_registration_translation_es(){

        steps.open_main_page();
        steps.click_login_button();
        steps.click_start_button();
        steps.click_advertiser_circle();
        steps.select_esp_language();
        steps.submit_form();
        steps.check_lang_select();
     
    }
    
    @Test
    @Title("Регистрация агента Esp переводы")
    @WithTagValuesOf({"block:Traslation","role:Webmaster"})
    public void check_agent_registration_translation_es(){

        steps.open_main_page();
        steps.click_login_button();
        steps.click_start_button();
        steps.click_agent_circle();
        steps.select_esp_language();
        steps.submit_form();
        steps.check_lang_select();
     
    }
   
    
    
    
} 