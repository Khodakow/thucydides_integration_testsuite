package cityads.ca_thucydides_new_design.ManagerStory;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.BaseSteps;
import cityads.ca_thucydides_new_design.steps.ManagerSteps.CarcasStepsMgr;
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
public class OfficesShowIntervalGrafMgrTest {

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
    public TableSteps table;

    @Steps
    public StatisticsSteps stat;
    @Steps
    FrontSteps front;

    @Before
    public void setUp(){
        front.loginMgr();
    }


    @Test
    @Title("Проверка отметики первого офиса на графике в отчете менеджера")
    public void officesShowIntervalGrafManagerTest() throws Exception{
        carcas.go_to_mgr_stat_offices();
        stat.click_by_interval_graf();
        table.tag_first_office_and_check_legend_in_interval_graf();
        steps.check_fatal_errors();
    }

    //@Test
    @Title("Проверка отметики первого вебмастера на графике в отчете менеджера")
    public void webmasterShowIntervalGrafManagerTest() throws Exception{
        carcas.go_to_mgr_stat_webmasters();
        stat.click_by_interval_graf();
        table.tag_first_webmaster_and_check_legend_in_interval_graf();
        steps.check_fatal_errors();
    }
 
    

    
} 