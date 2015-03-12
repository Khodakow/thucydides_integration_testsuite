package cityads.ca_thucydides_new_design.WebmasterStory.stat;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.MainSiteSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FrontSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.TableSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.Statistic.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class StatisticAcquisitionSortTest {

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
    TableSteps table;


    @Test
    @Title("Статистика по типам траффика сортировка")
    public void statisticByTraficSourseBySourseTypesTest() throws Exception{

        front.login("/webmaster/statistics/traffic_sources/sources/types_429835535.0.htm");
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
    @Title("Статистика по целевым страницам сортировка")
    public void statisticByTraficSourseByTargetPagessTest() throws Exception{

        front.login("/webmaster/statistics/traffic-sources/entry-points/target-pages_430585535.0.htm");
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
    @Title("Статистика по продуктам сортировка")
    public void statisticByTraficSourseByGoodsTest() throws Exception{

        front.login("/webmaster/statistics/traffic-sources/entry-points/types_430445535.0.htm");
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
    @Title("Статистика по Реферреры сортировка")
    public void statisticByTraficSourseByReferersTest() throws Exception{

        front.login("/webmaster/statistics/traffic_sources/sources/refererrs_419859323.0.htm");
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
    @Title("Статистика по субаккаунтам сортировка")
    public void statisticByTrafficSoursesBySubaccountSortTest() throws Exception{

        front.login("/webmaster/statistics/traffic_sources/sources/subaccounts_419879323.0.htm");
        table.check_stat_column_sort_ascend(5, "Показы");
        table.check_stat_column_sort_ascend(6, "Хиты");
        table.check_stat_column_sort_ascend(7, "Клики");
        table.check_stat_column_sort_ascend(8, "Открытая");
        table.check_stat_column_sort_ascend(9, "Отклонена");
        table.check_stat_column_sort_ascend(10, "Одобрена");

    }

    @Test
    @Title("Статистика по Ключевые слова сортировка")
    public void statisticByTraficSourseByKeywordsTest() throws Exception{

        front.login("/webmaster/statistics/traffic_sources/sources/keywords_424119552.0.htm");
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
    @Title("Статистика по Акции сортировка")
    public void statisticByTraficSourseByPromoEventsTest() throws Exception{

        front.login("/webmaster/statistics/traffic-sources/entry-points/promo-events_430725535.0.htm");
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
    @Title("Статистика по Акции сортировка")
    public void statisticByTraficSourseByTypeOfEntryPointsTest() throws Exception{

        front.login("/webmaster/statistics/traffic-sources/entry-points/types_430445535.0.htm");
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