package cityads.ca_thucydides_new_design.WebmasterStory.refactor.combined;

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
public class StatisticAllReports2Test {

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


    @Test
    public void statisticByConversionsBySeasonsTest() throws Exception{

        carcas.go_to_statistic_by_conversion_by_intencity_bySeasons();
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



    }

    @Test
    public void statisticByConversionsBySegmetOffersTest() throws Exception{

        carcas.go_to_statistic_by_conversion_by_segments_byOffers();
        table.setup_number_of_records(100);
        table.waitABit(5000);
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
        table.check_stat_column_sort_ascend(15, "Открытая(Комиссии)");

    }

    @Test
    public void statisticByConversionsBySizeOfPromoTest() throws Exception{

        carcas.go_to_statistic_by_conversion_by_tools_bySizeofPromo();
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


    }

    @Test
    public void statisticByConversionsBySizeTypeTest() throws Exception{

        carcas.go_to_statistic_by_conversion_by_tools_bySizeType();
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


    }

    @Test
    public void statisticByTraficSourseBySourseTypesTest() throws Exception{

        carcas.go_to_statistic_by_SourseTraffic_by_sourses_by_types();
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


    }

    @Test
    public void statisticByTraficSourseByTargetPagessTest() throws Exception{

        carcas.go_to_statistic_by_soursetraffic_byEntryPoints_byTargetPages();
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



    }

    @Test
    public void statisticByConversionsByTimeDayTest() throws Exception{

        carcas.go_to_statistic_by_conversion_by_intencity_byTimeDay();
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



    }

    @Test
    public void statisticByConversionsByTimePeriodsTest() throws Exception{

        carcas.go_to_statistic_by_conversion_by_intencity_byTimePeriods();
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



    }

    @Test
    public void statisticByAuditoryByTimezonesTest() throws Exception{

        carcas.go_to_statistic_by_auditory_by_countries_byTimezones();
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



    }

    @Test
    public void statisticByConversionsByToolsTypeTest() throws Exception{

        carcas.go_to_statistic_by_conversion_by_tools_byTypes();
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


    }

    @Test
    public void statisticByConversionsByTypeofActionsSortTest() throws Exception{

        carcas.go_to_statistic_by_conversion_by_action_byTypes();
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


    }

    @Test
    public void statisticByTraficSourseByTypeOfEntryPointsTest() throws Exception{

         carcas.go_to_statistic_by_soursetraffic_byEntryPoints_byTypes();
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


    }

    @Test
    public void statisticByConversionsByTypeOffersSortTest() throws Exception{

        carcas.go_to_statistic_by_conversion_by_segments_byTypes();
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


    }

    @Test
    public void statisticByConversionsByVerticalsSortTest() throws Exception{

        carcas.go_to_statistic_by_conversion_by_segments_byVerticals();
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


    }

    @Test
    public void statisticByConversionsByWeekDaysTest() throws Exception{

        carcas.go_to_statistic_by_conversion_by_intencity_byWeekDays();
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



    }

    @Test
    public void statisticByConversionsByWeekendsAndDaysTest() throws Exception{

        carcas.go_to_statistic_by_conversion_by_intencity_byWeekdaysAndWeekends();
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


    }


    @Test @Screenshots(onlyOnFailures=false)
    public void webOffersTableSortStoryTest() throws Exception{

        carcas.go_to_web_offers();
        table.setup_number_of_records(100);
        //table.check_column_sort_ascend(2, "id");
        table.check_column_sort_ascend(7, "Cookie LTV");
        table.check_column_sort_ascend(8, "Ranking");
        table.check_column_sort_ascend(9, "7D eCPC");
        table.check_column_sort_ascend(10, "3M eCPC");


    }

} 