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
public class StatisticAllReports1Test {

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
    public void statisticByAuditoryByBehaviorTest() throws Exception{

        carcas.go_to_statistic_by_auditory_by_behavior_byNewandReturned();
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
    public void statisticByAuditoryByBrowserTest() throws Exception{

        carcas.go_to_statistic_by_auditory_by_technology_byBrowser();
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
    public void statisticByConversionsByCategoryOfPromoTest() throws Exception{

        carcas.go_to_statistic_by_conversion_by_tools_byCategoryOfPromo();
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
    public void statisticByAuditoryByDevicesTypeTest() throws Exception{

        carcas.go_to_statistic_by_auditory_by_devices_byTypes();
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
    public void statisticByConversionsByFormatCodeTest() throws Exception{

        carcas.go_to_statistic_by_conversion_by_tools_byFormatCode();
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
    public void statisticByAuditoryByGeografyTest() throws Exception{


        carcas.go_to_statistic_by_auditory_by_countries_byGeografy();
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
    public void statisticByTraficSourseByGoodsTest() throws Exception{

        carcas.go_to_statistic_by_soursetraffic_byEntryPoints_byGoods();
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
    public void statisticByTraficSourseByKeywordsTest() throws Exception{

        carcas.go_to_statistic_by_SourseTraffic_by_sourses_by_kewywords();
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
    public void statisticByTraficSourseByLandingsTest() throws Exception{

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

    @Test
    public void statisticByAuditoryByLanguageTest() throws Exception{

        carcas.go_to_statistic_by_auditory_by_countries_byLanguage();
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
    public void statisticByConversionsByLinkTypeTest() throws Exception{

        carcas.go_to_statistic_by_conversion_by_tools_byLinktype();
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
    public void statisticByAuditoryByOCTest() throws Exception{

        carcas.go_to_statistic_by_auditory_by_technology_byOC();
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
    public void statisticByConversionsByPaymentMethodsTest() throws Exception{

        carcas.go_to_statistic_by_conversion_by_action_byMethodspay();
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
    public void statisticByTraficSourseByPromoEventsTest() throws Exception{

        carcas.go_to_statistic_by_soursetraffic_byEntryPoints_byPromoEvents();
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
    public void statisticByTraficSourseByReferersTest() throws Exception{
        carcas.go_to_statistic_by_SourseTraffic_by_sourses_by_referers();
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

} 