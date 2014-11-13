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
public class StatisticAllTopFilterTest {

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
        carcas.go_to_statistic_by_conversion_by_offers();
        steps.check_fatal_errors();
        steps.executeScript("$('span[class*=\"_clear_ext_filter\"]').click();");

    }


    @Test
    public void statistic_top_filter_auto_items_test() throws Exception{

        steps.wait_highchart_displayed(30);
        steps.check_fatal_errors();
        steps.waitABit(10000);

        steps.click_first_list_additional_parametr_to_blue_table();
        String searchparametr = "Страны";
        steps.fill_first_list_additional_par_search_input(searchparametr);
        steps.click_first_list_additional_par_second_visible_item(searchparametr);
        steps.waitABit(5000);
        steps.wait_for_all_spinners_dissapears(250);
        String filterName = steps.get_text_from_first_element_in_blue_table_additional_parametr();
        topSteps.fill_top_filter_simple_and_choose_auto_list_elements(filterName,2,5);
        steps.wait_for_all_spinners_dissapears(120);
        steps.check_all_additional_parametr_in_blue_table(filterName);

    }

    @Test
    public void statistic_top_filter_enter_test() throws Exception{



        steps.click_first_list_additional_parametr_to_blue_table();
        String searchparametr = "Страны";
        steps.fill_first_list_additional_par_search_input(searchparametr);
        steps.click_first_list_additional_par_second_visible_item(searchparametr);
        steps.waitABit(5000);
        steps.wait_for_all_spinners_dissapears(120);
        String filterName = steps.get_text_from_first_element_in_blue_table_additional_parametr();

        topSteps.fill_top_filter_simple_and_choose_any_by_enter(filterName,2,5);
        steps.wait_for_all_spinners_dissapears(120);
        steps.check_all_additional_parametr_in_blue_table(filterName);

    }

    @Test
    public void statistic_top_filter_simple_exist_test() throws Exception{




        steps.click_first_list_additional_parametr_to_blue_table();
        String searchparametr = "Страны";
        steps.fill_first_list_additional_par_search_input(searchparametr);
        steps.click_first_list_additional_par_second_visible_item(searchparametr);
        steps.waitABit(5000);
        steps.wait_for_all_spinners_dissapears(120);
        String filterName = steps.get_text_from_first_element_in_blue_table_additional_parametr();
        topSteps.fill_top_filter_simple_and_choose_any(filterName,2,5);
        steps.wait_for_all_spinners_dissapears(120);
        steps.check_all_additional_parametr_in_blue_table(filterName);
        steps.close_browser();



    }

    @Test
    public void statistic_top_filter_simple_not_exist_test() throws Exception{



        steps.click_first_list_additional_parametr_to_blue_table();
        String searchparametr = "Страны";
        steps.fill_first_list_additional_par_search_input(searchparametr);
        steps.click_first_list_additional_par_second_visible_item(searchparametr);
        steps.waitABit(5000);
        steps.wait_for_all_spinners_dissapears(120);
        String filterName = steps.get_text_from_first_element_in_blue_table_additional_parametr();
        topSteps.fill_top_filter_simple_and_choose_exclude(filterName, 2, 5);
        steps.wait_for_all_spinners_dissapears(120);
        steps.check_all_additional_parametr_in_blue_table_not_equals(filterName);


    }

    @Test
    public void statistic_top_filter_simple_invalid_filter_test() throws Exception{


        steps.click_first_list_additional_parametr_to_blue_table();
        String searchparametr = "Страны";
        steps.fill_first_list_additional_par_search_input(searchparametr);
        steps.click_first_list_additional_par_second_visible_item(searchparametr);
        steps.waitABit(5000);
        steps.wait_for_all_spinners_dissapears(120);
        String filterName = "asdasd214213easdf34eedfsdcfxcz";
        topSteps.fill_top_filter_simple_and_choose_any(filterName,2,5);
        steps.wait_for_all_spinners_dissapears(120);
        steps.check_blue_table_has_no_data();

    }

} 