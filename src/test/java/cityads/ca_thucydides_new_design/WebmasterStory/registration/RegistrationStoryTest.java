package cityads.ca_thucydides_new_design.WebmasterStory.registration;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.RegistrationSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FrontSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.sql.Connection;


@Story(TestSuite.WebMaster.Registration.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="registration")
public class RegistrationStoryTest extends Constants {

    public Connection con;
    public String wmName;
    String tempEmail;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @After
    public void shut_down_driver_process(){
        steps.getDriver().quit();
    }
    
    @Steps
    public RegistrationSteps steps;
    @Steps
    public FrontSteps front;

    @Test
    public void test_registration_with_mailinator() throws Exception{
 
        //generate data
        String regIcq = getRandomIcqNumber();
        String regSkype = getRandomString();
        String randomMailName = getRandomStringForMonkey();
        String randomMailFullName = randomMailName+"@mailinator.com";
        
        steps.getDriver().manage().deleteAllCookies();
        steps.open_url(tempMailUrl);
        steps.fill_temp_mail(randomMailName);
        
        
        steps.open_main_page();
        steps.select_ru_language();
        steps.click_login_button();
        steps.click_start_button();
        
       
        steps.check_registration_form_is_displayed();
             
        //fill form
        steps.fill_registration_form(randomMailFullName, regIcq, wmProfileMobile, regSkype, regPassword, randomMailFullName);
        steps.click_agree_checkbox();
        steps.submit_form();
        steps.check_fatal_errors();


        //steps.check_url_has_success1();
        //teps.check_success_message_is_displayed();
        front.is_on_dashboard();
/*
        steps.open_url(tempMailUrl);
        steps.login_into_temp_mail(randomMailFullName);
        steps.wait_for_activation_email(300);*/

        //шаги не требуются в новой регистрации
        /*steps.click_action_letter_title();
        steps.waitAjax(5000);
        steps.switch_to_mailinator_iframe();
        steps.click_activation_link();
        steps.switch_to_last_window();
        steps.waitAjax(5000);
        steps.check_error_is_not_displayed();
        steps.check_activation_complete(randomMailFullName);*/

        steps.close_browser();
        
        //check login
        steps.wm_login(randomMailFullName, regPassword);
        steps.close_browser();
        
    }
   
} 