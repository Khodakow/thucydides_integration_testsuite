package cityads.ca_thucydides_new_design.ManagerStory;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.MainSiteSteps;
import cityads.ca_thucydides_new_design.steps.ManagerSteps.CarcasStepsMgr;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.StatisticTopFilterSteps;
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
public class Advertisers55756GlobalFilterMainMgrTest {

    public String wmName;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    FrontSteps front;
    @Steps
    StatisticsSteps stat;
    @Steps
    StatisticTopFilterSteps topFilter;
    @Steps
    CarcasStepsMgr carcas;
    @Steps
    public MainSiteSteps steps;
    @Steps
    public TableSteps table;

    @Before
    public void setUp(){
        front.loginMgr();
    }


    @Test
    @Title("Проверка работы глобал фильтра у менеджера по реклам")
    public void advertisers55756MainManagerTest() throws Exception{
        carcas.go_to_mgr_stat_advertisers();
        String adv = table.get_first_adv_mainparam();
        topFilter.fill_top_filter_simple_and_choose_any(adv,2,2);
        steps.check_fatal_errors();
        table.check_table_has_text(adv);

    }
    
 
    

    
} 