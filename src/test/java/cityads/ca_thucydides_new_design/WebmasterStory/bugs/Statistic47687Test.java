package cityads.ca_thucydides_new_design.WebmasterStory.bugs;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.MainSiteSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.StatisticSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.*;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.Statistic.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class Statistic47687Test {

    public String wmName;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public MainSiteSteps steps;


    @Steps
    FrontSteps front;
    @Steps
    StatisticsSteps stat;
    @Steps
    StatisticSteps ssteps;
    @Steps
    CarcasSteps carcas;
    @Steps
    TableSteps table;
    @Steps
    ConsoleSteps console;

    @Test
    public void stat47687Test() throws Exception{

        front.login();
        carcas.go_to_statistic_by_conversion_by_segments_byOffers();
        table.setup_number_of_records(100);
        ssteps.wait_for_all_spinners_dissapears();
        table.click_checkbox_left_column(1);
        ssteps.wait_for_all_spinners_dissapears();
        steps.check_fatal_errors();
        ssteps.calendar_set_90_days();
        ssteps.wait_for_all_spinners_dissapears();
        steps.check_fatal_errors();
        console.check_console_log();
        ssteps.wait_for_all_spinners_dissapears();
        table.click_checkbox_left_column(4);


        steps.close_browser();

    }
    
 
    

    
} 