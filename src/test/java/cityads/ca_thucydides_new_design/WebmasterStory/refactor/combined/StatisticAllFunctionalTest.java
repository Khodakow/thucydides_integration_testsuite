package cityads.ca_thucydides_new_design.WebmasterStory.refactor.combined;

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
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.Statistic.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class StatisticAllFunctionalTest {

    public String wmName;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;



    @Steps
    public StatisticSteps steps;
    @Steps
    public StatisticTopFilterSteps topSteps;
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
    public void statistic_by_conversion_by_segments_by_offeers_keywordTest() throws Exception{


        carcas.go_to_statistic_by_conversion_by_segments_byOffers();
        steps.wait_highchart_displayed(30);
        steps.check_fatal_errors();
        steps.check_blue_table_is_visible();
        steps.check_search_by_keyword(3);

    }

    //@Test
    public void statistic_by_conversion_by_segments_by_offeers_keywordAddParam_39689Test() throws Exception{

        carcas.go_to_statistic_by_conversion_by_segments_byOffers();
        steps.wait_highchart_displayed(30);
        steps.check_fatal_errors();
        steps.check_blue_table_is_visible();

        steps.click_first_list_additional_parametr_to_blue_table();
        String searchparametr = "Страны";
        steps.fill_first_list_additional_par_search_input(searchparametr);
        steps.click_first_list_additional_par_second_visible_item(searchparametr);
        steps.waitABit(5000);
        steps.wait_for_all_spinners_dissapears(120);

        steps.check_search_by_keyword(4);

    }


    @Test
    public void statistic_by_conversion_by_segments_by_offeers_legendTest() throws Exception{

        carcas.go_to_statistic_by_conversion_by_segments_byOffers();
        steps.wait_highchart_displayed(30);
        steps.check_fatal_errors();
        steps.check_blue_table_is_visible();
        steps.check_legend_in_breadcrumbs();


    }


    @Test
    public void statistic_by_conversion_by_segments_by_offeers_bluetableTest() throws Exception{

        carcas.go_to_statistic_by_conversion_by_segments_byTypes();
        steps.wait_highchart_displayed(30);
        steps.check_fatal_errors();
        steps.check_blue_table_is_visible();
        steps.check_breadcrums_by_click_in_link_blue_table();

    }


} 