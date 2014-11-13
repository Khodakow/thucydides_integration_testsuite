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
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.Refactored.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class StatisticByLandingsTest {

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

    @Test 
    public void statisticByTraficSourseByLandingsTest() throws Exception{

        front.login();
        carcas.go_to_statistic_by_soursetraffic_byEntryPoints_byLanding();
        table.setup_number_of_records(100);
        table.waitABit(5000);
        table.check_stat_column_sort_ascend(4, "Показы");
        table.check_stat_column_sort_ascend(5, "Хиты");
        table.check_stat_column_sort_ascend(6, "Клики");
        table.check_stat_column_sort_ascend(8, "Открытая");
        table.check_stat_column_sort_ascend(9, "Отклонена");
        table.check_stat_column_sort_ascend(10, "Одобрена");
        table.check_stat_column_sort_ascend(11, "Открытая(Продажи)");
        table.check_stat_column_sort_ascend(12, "Отклонена(Продажи)");
        table.check_stat_column_sort_ascend(13, "Одобрена(Продажи)");



        steps.close_browser();

    }
    
 
    

    
} 