package cityads.ca_thucydides_new_design.WebmasterStory.registration;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.RegistrationSteps;
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
public class WmLoginVKTest extends Constants {

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
    
    @Test
    public void test_login_vk() throws Exception{
 
        String loginvk = steps.get_wm_name_vk();
        String passwordvk = steps.get_wm_vk_password();
        
        
        steps.open_main_page();
        steps.select_ru_language();
        String host;
        host = steps.get_curent_domain_name();

        String handle = steps.getDriver().getWindowHandle();
        
        steps.click_login_button();
        steps.click_vk_link();
          
        steps.switch_to_last_window();
        steps.fill_vk_form(loginvk, passwordvk);
        steps.click_submit_vk();
        
        steps.waitAjax(15000);
        steps.getDriver().switchTo().window(handle);
        //steps.wait_for_all_spinners_dissapears(60);
        steps.wait_for_blue_table_appears(60);
        String newhost = steps.get_curent_domain_name();
        steps.check_values_are_equals(host, newhost);
        
    
        
        steps.close_browser();
        
        
    }
   
} 