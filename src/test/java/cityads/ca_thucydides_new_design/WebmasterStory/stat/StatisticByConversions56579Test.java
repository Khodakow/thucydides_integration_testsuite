package cityads.ca_thucydides_new_design.WebmasterStory.stat;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.SetupSteps;
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

import java.util.ArrayList;
import java.util.Date;


@Story(TestSuite.WebMaster.Statistic.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class StatisticByConversions56579Test {

    public String wmName;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    SetupSteps steps;
    @Steps
    FrontSteps front;
    @Steps
    StatisticsSteps stat;
    @Steps
    CarcasSteps carcas;
    @Steps
    TableSteps table;
    @Steps
    BugsSteps bugs;




    @Before
    public void setUp(){
        front.login();
        carcas.go_to_statistic_by_conversion_by_action_byConversion();
        bugs.set_date_to_calendar("'01.12.2014 - 24.12.2014'");
        table.setup_number_of_records(100);

    }



    @Test
    @Title("Проверка корректоности дат кликов в отчете по конверсиям 56579")
    public void statisticByConversionsClickDateTest() throws Exception{

        steps.wait_for_all_spinners_dissapears();
        ArrayList<String> clickDates = table.get_conversions_click_dates();
        ArrayList<Date> dates = steps.convert_string_to_dates(clickDates);
        steps.check_years_in_dates_list(dates);

    }

    @Test
    @Title("Проверка корректоности дат лидов в отчете по конверсиям 56579")
    public void statisticByConversionsDateTest() throws Exception{

        steps.wait_for_all_spinners_dissapears();
        ArrayList<String> clickDates = table.get_conversions_dates();
        ArrayList<Date> dates = steps.convert_string_to_dates(clickDates);
        steps.check_years_in_dates_list(dates);

    }
    

    
} 