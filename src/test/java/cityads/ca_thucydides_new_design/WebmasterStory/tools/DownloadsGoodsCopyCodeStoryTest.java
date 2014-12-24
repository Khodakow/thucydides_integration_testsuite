package cityads.ca_thucydides_new_design.WebmasterStory.tools;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.DownloadsSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;




@Story(TestSuite.WebMaster.Downloads.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class DownloadsGoodsCopyCodeStoryTest extends Constants {


    private String wmName;
    private String offerName;


    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;


    @Steps
    public DownloadsSteps steps;



    @Test
    @Title("Тест на выгрузку товаров - скопировать код")
    @WithTagValuesOf({"block:Downloads","role:Webmaster"})
    public void downloads_goods_copy_code_test() throws Exception{


        String filterName = null;


        wmName = steps.get_wm_name();
        steps.wm_login(wmName);
        steps.click_goods_and_coupons_link();
        steps.wait_for_all_spinners_dissapears(30);
        steps.click_goods_link();
        steps.wait_for_all_spinners_dissapears(30);
        steps.click_goods_catalog();
        steps.wait_for_all_spinners_dissapears(30);
        steps.check_fatal_errors();


        filterName = getCurrentDate()+" "+getRandomIntNumber();
        steps.wait_for_all_spinners_dissapears(30);
        steps.scroll_to_bottom();
        steps.uncheck_filters_move_checkbox();
        steps.save_filter();  //КНПОКА ВЕБДРАЙВЕРОМ НЕ ЖМЕТСЯ,  ВЫЗЫВАЮ С КОНСОЛИ
        steps.wait_for_popup_appears(5);
        steps.fill_filter_name_in_popup(filterName);
        steps.click_popup_filter_save_button();
        steps.wait_for_all_spinners_dissapears(90);
        steps.check_fatal_errors();
        steps.scroll_to_top();
        steps.check_filter_breadcrumbs_is_displayed();
        steps.waitAjax(10000);
//        //переход в инструменты - выгрузки
        steps.click_goods_filter_create_tool_link();
        steps.wait_for_all_spinners_dissapears(30);
        steps.check_h1_page_title("Добавление фида");
        String feedFilterName   =   steps.get_coupons_feed_filter_name();
        steps.check_values_are_equals(filterName,feedFilterName );
        steps.wait_for_all_spinners_dissapears(30);
//        
        //создание выгрузки
        String downloadName = getCurrentDate()+" "+getRandomIntNumber();
        String subaccountName = getCurrentDate()+" "+getRandomIntNumber();
        steps.fill_name_input(downloadName);
        steps.fill_subaccount_input(subaccountName);
        steps.submit_form();
        steps.waitABit(15000);
        steps.wait_for_all_spinners_dissapears(190);
        steps.check_blue_table_has_text(downloadName);
       
        steps.wait_for_all_spinners_dissapears(30);

        //Первый раз кликает
        WebElement string = steps.get_blue_table_string_with_text(downloadName);
        steps.click_icon_in_blue_table_line(1, string);

        steps.wait_for_popup_appears(2);
        String url = steps.get_feed_code();
        steps.wait_for_all_spinners_dissapears(30);
        steps.click_downloads_popup_copy_url_button();
        steps.wait_for_all_spinners_dissapears(30);
        steps.check_text_is_not_displayed(url);
        //Второй раз кликает
        steps.click_icon_in_blue_table_line(1, string);

        steps.wait_for_popup_appears(2);
        steps.wait_for_all_spinners_dissapears(30);
        url = steps.get_feed_code();
        steps.click_downloads_popup_copy_url_button();
        steps.wait_for_all_spinners_dissapears(30);
        steps.check_text_is_not_displayed(url);

        steps.close_browser();





    }






} 