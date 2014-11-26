package cityads.ca_thucydides_new_design.WebmasterStory.refactor;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.StatisticSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.StatisticTopFilterSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.CarcasSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FrontSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.StatisticsSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.TableSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.Refactored.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class StatisticBySegmetOffersTest {

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
    CarcasSteps carcas;
    @Steps
    TableSteps table;
    @Steps
    public StatisticSteps steps;
    @Steps
    public StatisticTopFilterSteps topSteps;

    @Before
    public void setUp(){
        front.login();
        carcas.go_to_statistic_by_conversion_by_segments_byOffers();
        table.setup_number_of_records(100);
        steps.executeScript("$('span[class=\"button submit clear _clear_ext_filter\"]').trigger('click');");
    }

    @After
    public void clearTopFilter(){
        steps.executeScript("$('span[class=\"button submit clear _clear_ext_filter\"]').trigger('click');");
    }


    @Test
    public void statisticByConversionsBySegmetOffersTest() throws Exception{


        table.check_stat_column_sort_ascend(2, "id");
        table.check_stat_column_sort_ascend(5, "Показы");
        table.check_stat_column_sort_ascend(6, "Хиты");
        table.check_stat_column_sort_ascend(7, "Клики");
        table.check_stat_column_sort_ascend(9, "Открытая");
        table.check_stat_column_sort_ascend(10, "Отклонена");
        table.check_stat_column_sort_ascend(11, "Одобрена");
        table.check_stat_column_sort_ascend(12, "Открытая(Продажи)");
        table.check_stat_column_sort_ascend(13, "Отклонена(Продажи)");
        table.check_stat_column_sort_ascend(14, "Одобрена(Продажи)");


    }



} 