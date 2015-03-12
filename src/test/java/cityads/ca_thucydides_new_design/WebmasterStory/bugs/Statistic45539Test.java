package cityads.ca_thucydides_new_design.WebmasterStory.bugs;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.StatisticSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.CarcasSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FrontSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.StatisticsSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.TableSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.Bugs.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class Statistic45539Test {

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

    @Test
    @Title("ВМ. СТАТИСТИКА. УСТРОЙСТВА-DEVICES TYPES. ПРИ НАЖАТИИ В ХЛЕБНЫХ КРОШКАХ, ПЕРЕКИДЫВАЕТ В ДРУГОЙ ОТЧЕТ.")
    public void stat45539Test() throws Exception{

        front.login();
        carcas.go_to_statistic_by_auditory_by_devices_byTypes();
        carcas.shoud_be_on_devicetype_page();
        steps.click_any_black_link_in_legend(1);
        steps.wait_for_all_spinners_dissapears();
        steps.check_fatal_errors();
        carcas.shoud_be_on_devicetype_page();
        steps.close_browser();

    }
    
 
    

    
} 