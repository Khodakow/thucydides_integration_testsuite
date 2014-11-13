package cityads.ca_thucydides_new_design.ManagerStory;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.BaseSteps;
import cityads.ca_thucydides_new_design.steps.ManagerSteps.CarcasStepsMgr;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.StatisticSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.ConsoleSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FrontSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.StatisticsSteps;
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
public class Offices47866MgrTest {

    public String wmName;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public BaseSteps steps;
    @Steps
    public CarcasStepsMgr carcas;
    @Steps
    public ConsoleSteps console;
    @Steps
    public StatisticSteps ssteps;
    @Steps
    public StatisticsSteps stat;


    @Steps
    FrontSteps front;

    @Before
    public void setUp(){
        front.loginMgr();
    }


    @Test
    public void offices47866ManagerTest() throws Exception{
        carcas.go_to_mgr_stat_offices();
        steps.check_fatal_errors();
        steps.change_lang_to_ru();
        ssteps.add_additional_parameter("Категория промо");
        ssteps.add_dynamic_parameter(" Открытая");
        ssteps.check_blue_table_has_lines_with_data();
        ssteps.check_dinamic_spinner_not_visible();


    }
    
 
    

    
} 