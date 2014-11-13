package cityads.ca_thucydides_new_design.ManagerStory.bugs;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.ManagerSteps.CarcasStepsMgr;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.StatisticSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.ConsoleSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FrontSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.StatisticsSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.TableSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.Manager.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Manager Tests")
public class Advertisers43841MgrTest {

    public String wmName;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public CarcasStepsMgr carcas;
    @Steps
    public ConsoleSteps console;
    @Steps
    public StatisticSteps steps;
    @Steps
    public StatisticsSteps stat;
    @Steps
    public TableSteps table;

    @Steps
    FrontSteps front;

    @Before
    public void setUp(){
        front.loginMgr();
    }


    @Test@Pending
    public void advertisers43841ManagerTest() throws Exception{
        carcas.go_to_mgr_stat_advertisers();
        steps.add_additional_parameter("Офферы");
        steps.wait_for_all_spinners_dissapears();
        table.setup_number_of_records(100);
        table.check_additional_parameter_offers_column_for_unique_values();
        



        steps.check_fatal_errors();


    }
    
 
    

    
} 