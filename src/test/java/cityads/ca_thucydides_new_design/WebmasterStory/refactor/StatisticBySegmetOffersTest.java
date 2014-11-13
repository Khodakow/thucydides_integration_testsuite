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

    @Test
    public void statistic_add_to_chart_test() throws Exception{

        steps.click_first_list_additional_parametr_to_blue_table();
        String searchparametr = "Страны";
        steps.fill_first_list_additional_par_search_input(searchparametr);
        steps.click_first_list_additional_par_second_visible_item(searchparametr);
        steps.waitABit(5000);
        steps.wait_for_all_spinners_dissapears(120);

        String additionalparametrname = steps.get_text_from_first_element_in_blue_table_additional_parametr();
        String additionalparametrname2 = additionalparametrname.substring(0,5);
        String mainparametrname = steps.get_text_from_first_element_in_blue_table_main_parametr().replaceAll("‑","-").split(" ")[0];  //берем только первое слово если имя оффера содержит много слов


        steps.click_first_checkbox_in_blue_table();
        steps.waitABit(1000);
        steps.click_show_on_chart_icon();
        steps.wait_for_all_spinners_dissapears(120);
        steps.scroll_to_top();
        steps.waitABit(5000);
        String chartlegend = steps.get_webelement_with_jquery("$('g.highcharts-legend')[0]").getText();
        steps.check_string_contains_text(chartlegend,additionalparametrname2);
        steps.check_string_contains_text(chartlegend,mainparametrname);


    }

} 