package cityads.ca_thucydides_new_design.WebmasterStory.mainpage;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.SetupSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FrontSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.PopupSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.Svodnaya.class)
@RunWith(ThucydidesRunner.class)
public class PopUpLogOutStoryTest {


    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public FrontSteps front;

    @Steps
    public SetupSteps steps;

    @Steps
    public PopupSteps popup;

    @Before
    public void setUp() {
        front.login();
    }

    @Test@Pending
    @Screenshots(onlyOnFailures = false)
    @Title("Проверка popup окна при окончании сессии (Logout)")
    public void popUpLogOutStoryTest() throws Exception{

        steps.execute_javascript_logoff();
        popup.check_logout_popup_and_close();
        String url =  steps.get_current_url();
        steps.check_string_contains_text(url,"/ru/login");

    }

} 