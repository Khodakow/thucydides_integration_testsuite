package cityads.ca_thucydides_new_design.WebmasterStory.stat;

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


@Story(TestSuite.WebMaster.Statistic.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class StatisticAuditorySortTest {

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
    @Title("Статистика по аудитории по языкам сортировка")
    public void statisticByAuditoryByLanguageTest() throws Exception{
        front.login("/webmaster/statistics/audience/countries/language_419919323.0.htm");
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
    @Title("Статистика по аудитории по географии сортировка")
    public void statisticByAuditoryByGeografyTest() throws Exception{
        front.login("/webmaster/statistics/audience/countries/location_419939323.0.htm");
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
    @Title("Статистика по аудитории по часовым поясам сортировка")
    public void statisticByAuditoryByTimezonesTest() throws Exception{
        front.login("/webmaster/statistics/audience/countries/timezones_429295535.0.htm");
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
    @Title("Статистика по аудитории по поведению новые и вернувшиеся сортировка")
    public void statisticByAuditoryByNewAndReturnedTest() throws Exception{
        front.login("/webmaster/statistics/audience/behaviour/new_and_returned_418479323.0.htm");
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
    @Title("Статистика по аудитории по браузерам сортировка")
    public void statisticByAuditoryByBrowsersTest() throws Exception{
        front.login("/webmaster/statistics/audience/technologies/browser_418499323.0.htm");
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
    @Title("Статистика по аудитории по OC сортировка")
    public void statisticByAuditoryByOCTest() throws Exception{
        front.login("/webmaster/statistics/audience/technologies/os_418519323.0.htm");
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
    @Title("Статистика по аудитории по сети сортировка")
    public void statisticByAuditoryByNetTest() throws Exception{
        front.login("/webmaster/statistics/advanced_reports/audience/technologies/network_434601053.0.htm");
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
    @Title("Статистика по аудитории по типу устрйоства сортировка")
    public void statisticByAuditoryByTypeDeviceTest() throws Exception{
        front.login("/webmaster/statistics/audience/devices/type_418539323.0.htm");
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
    @Title("Статистика по аудитории по мобильным устрйоствам сортировка")
    public void statisticByAuditoryByMobDeviceTest() throws Exception{
        front.login("/webmaster/statistics/audience/devices/mobile_devices_429679753.0.htm");
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