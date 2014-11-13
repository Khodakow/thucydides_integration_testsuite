package cityads.ca_thucydides_new_design.ManagerStory;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.BaseSteps;
import cityads.ca_thucydides_new_design.steps.ManagerSteps.CarcasStepsMgr;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FrontSteps;
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
public class CategoryPromoMainParamMgrTest {

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
    public TableSteps table;



    @Steps
    FrontSteps front;

    @Before
    public void setUp(){
        front.loginMgr();
    }


    @Test
    public void categoryPromoMainParamManagerTest() throws Exception{
        carcas.go_to_mgr_stat_categorypromo();
        table.check_all_date_in_main_parametr_num_exclude();
    }

    @Test
    public void toolsTypeMainParamManagerTest() throws Exception{
        carcas.go_to_mgr_stat_tooltype();
        table.check_all_date_in_main_parametr_num_exclude();
    }

    @Test
    public void codeTypeMainParamManagerTest() throws Exception{
        carcas.go_to_mgr_stat_codetype();
        table.check_all_date_in_main_parametr_num_exclude();
    }

    @Test
    public void linkTypeMainParamManagerTest() throws Exception{
        carcas.go_to_mgr_stat_linktype();
        table.check_all_date_in_main_parametr_num_exclude();
    }

    
} 