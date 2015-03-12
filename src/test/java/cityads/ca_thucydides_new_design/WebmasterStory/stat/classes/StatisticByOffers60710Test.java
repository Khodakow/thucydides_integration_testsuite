package cityads.ca_thucydides_new_design.WebmasterStory.stat.classes;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.BugsSteps;
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

import java.util.Set;


@Story(TestSuite.WebMaster.Statistic.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class StatisticByOffers60710Test {

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
    StatisticsSteps steps;
    @Steps
    BugsSteps bugs;


    @Before
    public void setUp(){
        front.login();
        carcas.go_to_statistic_by_conversion_by_intencity_byTimePeriods();
        bugs.set_date_to_calendar("'28.11.2014 - 25.02.2015'");
    }


    @Test
    @Title("статистика по офферам ДУБЛИРОВАНИЕ ОСНОВНОГО ПАРАМЕТРА")
    public void statistic60710Test() throws Exception{
        steps.click_by_month();
        Set<String> months = steps.get_all_months();
        steps.check_value_gteater_then_min(months.size(),1);
    }



} 