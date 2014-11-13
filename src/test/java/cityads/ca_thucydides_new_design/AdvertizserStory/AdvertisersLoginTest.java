package cityads.ca_thucydides_new_design.AdvertizserStory;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.BaseSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.CarcasSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.ConsoleSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FrontSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.Advertiser.Login.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Advertiser Tests")
public class AdvertisersLoginTest {

    public String wmName;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public BaseSteps steps;
    @Steps
    public CarcasSteps carcas;
    @Steps
    public ConsoleSteps console;


    @Steps
    FrontSteps front;

    @Before
    public void setUp(){
        front.loginAdv();
    }


    @Test
    public void advertiserLoginTest() throws Exception{
        steps.check_fatal_errors();
    }
    

    

    
} 