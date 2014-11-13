package cityads.ca_thucydides_new_design.WebmasterStory.bugs;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.StatisticSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.*;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.Bugs.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class Bugs45558StoryTest {

    public String wmName;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public StatisticSteps steps;

    @Steps
    FrontSteps front;
    @Steps
    StatisticsSteps stat;
    @Steps
    CarcasSteps carcas;
    @Steps
    TableSteps table;
    @Steps
    BannerSteps banner;




    @Test @Screenshots(onlyOnFailures=false)
    public void stat45558Test() throws Exception{

        front.login();
        carcas.go_to_statistic_by_conversion_by_action_byConversion();
        stat.click_by_load_date();
        steps.wait_for_all_spinners_dissapears();
        String axis =  steps.get_axis_text();
        steps.check_string_not_contains_text(axis,"-- --");
        steps.check_string_not_contains_text(axis,"--");
        steps.check_string_not_contains_text(axis,"00");
        steps.check_string_not_contains_text(axis,"1970");

        steps.close_browser();

    }
    
 
    

    
} 