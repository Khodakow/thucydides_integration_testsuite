package cityads.ca_thucydides_new_design.WebmasterStory.registration;

import cityads.ca_thucydides_new_design.WebmasterStory.mainpage.*;
import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.SvodnayaSteps;
import cityads.ca_thucydides_new_design.steps.MainSiteSteps;
import cityads.ca_thucydides_new_design.steps.RegistrationSteps;
import java.sql.Connection;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTagValuesOf;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.Registration.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="registration")
public class WmLoginFbTest extends Constants {

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
    public void test_login_fb() throws Exception{
 
        String loginfb = steps.get_wm_name_fb();
        String passwordfb = steps.get_wm_fb_password();
        
        
        steps.open_main_page();
        steps.select_ru_language();
        String host;
        host = steps.get_curent_domain_name();

        String handle = steps.getDriver().getWindowHandle();
        
        steps.click_login_button();
        steps.click_fb_link();
          
        steps.switch_to_last_window();
        steps.fill_fb_form(loginfb, passwordfb);
        steps.click_submit_fb();
//        steps.click_submit_confirm_fb();
        steps.waitAjax(2000);
        steps.getDriver().switchTo().window(handle);
        steps.wait_for_all_spinners_dissapears(60);
        steps.wait_for_blue_table_appears(60);
        String newhost = steps.get_curent_domain_name();
        steps.check_values_are_equals(host, newhost);
        
    
        
        steps.close_browser();
        
        
    }
   
} 