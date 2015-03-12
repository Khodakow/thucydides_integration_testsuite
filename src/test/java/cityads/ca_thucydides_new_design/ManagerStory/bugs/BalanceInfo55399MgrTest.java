package cityads.ca_thucydides_new_design.ManagerStory.bugs;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.ManagerSteps.CarcasStepsMgr;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.StatisticSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.*;
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
public class BalanceInfo55399MgrTest {

    public String wmName;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;
    @Steps
    public CarcasSteps carcaswm;
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


    @Test@Title("Тест на првоерку скрытого поля в истории операций под судо")
    public void balanceInfo55399ManagerTest() throws Exception{
        if(steps.getDriver().getCurrentUrl().contains("cityads"))
        {
            front.openBaseUrl("/manager_pro/users/publishers_844045.54.htm?sudo=1&id=844045.54");
        }
        else{front.openBaseUrl("/manager_pro/users/publishers_436321191.0.htm?sudo=1&id=894.54");

        carcaswm.go_to_operation();
        front.clickHistoryOperationAndCHeckmanagerServiceInfo();



    }
    

    
} }