package cityads.ca_thucydides_new_design.ManagerStory;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.MainSiteSteps;
import cityads.ca_thucydides_new_design.steps.ManagerSteps.CarcasStepsMgr;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.StatisticSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.ConsoleSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FrontSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.StatisticsSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.TableSteps;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;


@Story(TestSuite.Manager.class)
@RunWith(ThucydidesRunner.class)

public class StatisticMgrGoodsNumbersTest {

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
    CarcasStepsMgr carcas;
    @Steps
    TableSteps table;
    @Steps
    ConsoleSteps console;

    @Before
    public void setUp(){
        front.loginMgr();
        carcas.go_to_mgr_stat_goods();
        table.setup_number_of_records(100);
    }






    @Test
    public void statMgrGoodsCheckNumbersMainParameterTest() throws Exception{
        ArrayList<String> mainParams = table.get_goods_mainparam();
        table.check_column_for_numbers(mainParams);
    }

    
} 