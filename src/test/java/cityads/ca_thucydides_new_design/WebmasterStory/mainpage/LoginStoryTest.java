package cityads.ca_thucydides_new_design.WebmasterStory.mainpage;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.MainSiteSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FrontSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.sql.Connection;


@Story(TestSuite.WebMaster.Svodnaya.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class LoginStoryTest extends Constants {

     public Connection con;
     public String wmName;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public MainSiteSteps steps;
    @Steps
    public FrontSteps front;


    
    @After
    public void shut_down_driver_process(){
        steps.close_browser();
    }
    
    @Test@Screenshots(onlyOnFailures = true)@Title("Авторизация вебмастера")
    public void logintest() throws Exception{

        front.login();
        steps.close_browser();
    }
    
 
    

    
} 