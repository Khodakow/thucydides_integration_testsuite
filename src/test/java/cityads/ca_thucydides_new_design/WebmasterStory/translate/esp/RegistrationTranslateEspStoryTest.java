package cityads.ca_thucydides_new_design.WebmasterStory.translate.esp;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
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
public class RegistrationTranslateEspStoryTest {
    

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    

    @Steps
    public RegistrationSteps steps;

    @Test
    @WithTagValuesOf({"block:Traslation","role:Webmaster"})
    @Title("Регистрация ВМ esp переводы")
    public void check_wm_registration_esp_translation(){

        steps.open_main_page();
        steps.click_login_button();
        steps.click_start_button();
        steps.check_registration_form_is_displayed();
        steps.select_esp_language();
        steps.executeScript("$('div:contains(\"Русский\")[class*=\"language\"]').remove()");
        steps.check_lang_select();
     
    }
    
    @Test
    @WithTagValuesOf({"block:Traslation","role:Webmaster"})
    @Title("Регистрация ВМ esp сообщения об ошибках переводы")
    public void check_wm_registration_esp_translation_after_login(){
        steps.open_main_page();
        steps.ckick_start_work();
        steps.select_esp_language();
        steps.check_lang_select();
        steps.close_browser();
     
    }
   
    @Test
    @Title("Забл пароль esp переводы")
    @WithTagValuesOf({"block:Traslation","role:Webmaster"})
    public void check_wm_lost_esp_password_translation(){

        steps.open_main_page();
        steps.click_login_button();
        steps.enter_login("qweqweqwe");
        steps.enter_password("213123123");
        steps.click_enter_button();
        steps.select_esp_language();
        steps.click_forgot_password_link();
        steps.submit_form();
        steps.waitABit(10000);
        steps.check_lang_select();
        steps.close_browser();
     
    }
    
    
    
} 