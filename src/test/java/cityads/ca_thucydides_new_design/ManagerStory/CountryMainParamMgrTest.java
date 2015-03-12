package cityads.ca_thucydides_new_design.ManagerStory;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.BaseSteps;
import cityads.ca_thucydides_new_design.steps.ManagerSteps.CarcasStepsMgr;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.StatisticSteps;
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
public class CountryMainParamMgrTest {

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
    public StatisticSteps stat;



    @Steps
    FrontSteps front;

    @Before
    public void setUp(){
        front.loginMgr();
    }


    @Test@Title("Проверяем что нет Неизвестно в отчете по содружествам")
    public void coutryMainParamManagerTest() throws Exception{
        carcas.go_to_mgr_stat_country();
        steps.change_lang_to_ru();
        if(steps.get_curent_domain_name().contains("city")){
            table.check_all_data_in_main_parametr_not_contains("Неизвестно");
            stat.click_any_black_link_in_legend(1);
            steps.wait_for_all_spinners_dissapears();
            table.check_all_data_in_main_parametr_not_contains("Неизвестно");
        }


    }





} 