package cityads.ca_thucydides_new_design.WebmasterStory.mainpage;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.MainSiteSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FrontSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.Manager.class)
@RunWith(ThucydidesRunner.class)
public class LoginMgrStoryTest{

    @Managed(uniqueSession = false)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public MainSiteSteps steps;
    @Steps
    public FrontSteps front;




    @Test
    @Screenshots(onlyOnFailures = false)
    @Title("Авторизация менеджера")
    public void loginMgrTest() throws Exception{

        front.loginMgr();
        steps.close_browser();

    }

    @Test
    @Screenshots(onlyOnFailures = false)
    @Title("Авторизация менеджера c неверным паролем баг 53639")
    public void loginMgrWrongPaswordTest() throws Exception{

        front.loginMgrWrongPassword();
        front.check_not_404();
        steps.close_browser();
    }



} 