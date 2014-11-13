package cityads.ca_thucydides_new_design.WebmasterStory.bugs;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.RegistrationSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.Bugs.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="bugs")
public class Bugs48201StoryTest{



    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public RegistrationSteps steps;


    
    @Test
    public void check_48201(){

        steps.open_main_page();
        steps.click_login_button();
        steps.enter_login("qweqweqwe");
        steps.enter_password("213123123");
        steps.click_enter_button();
        steps.select_en_language();
        steps.click_forgot_password_link();
        steps.check_reg_form_displayed();
        steps.submit_form();
        steps.close_browser();
        
    }
}
