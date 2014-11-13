package cityads.ca_thucydides_new_design.WebmasterStory.refactor;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.MainSiteSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.CarcasSteps;
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


@Story(TestSuite.WebMaster.Statistic.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class StatisticSubaccountExcelDownloadTest {

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
    CarcasSteps carcas;
    @Steps
    TableSteps table;


    @Before
    public void setUp(){
        front.login();
    }


    @Test@Title("Проверка выгрузки в эксель из отчета по субаккаунтам")
    public void statisticSubaccountExcelDownloadTest() throws Exception{

        carcas.go_to_statistic_by_SourseTraffic_by_sourses_by_subaccount();
        stat.export_xls();
        stat.export_spinner_not_visible();
        steps.close_browser();

    }
    
 
    

    
} 