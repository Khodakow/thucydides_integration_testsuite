package cityads.ca_thucydides_new_design.WebmasterStory.mainpage;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.StatisticSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.ConsoleSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FrontSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.Svodnaya.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class GremlinsStoryTest {


    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public FrontSteps front;
    @Steps
    public ConsoleSteps console;
    @Steps
    public StatisticSteps stat;


    @Before
    public void setUp(){
        front.login("/webmaster/statistics/audience/countries/location_419939323.0.htm",
                "me0i@mail.ru");
    }


    @Test
    @Screenshots(onlyOnFailures = false)
    @Title("gremlinsStoryTest вебмастера")
    public void gremlinsStoryTest() throws Exception{

        stat.check_breadcrums_by_click_in_link_blue_table_geo();
        console.unleash_gremlins(60);
        console.check_console_log();
    }
    
 
    

    
} 