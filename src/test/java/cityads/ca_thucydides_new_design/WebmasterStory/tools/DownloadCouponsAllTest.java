package cityads.ca_thucydides_new_design.WebmasterStory.tools;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.DownloadsSteps;
import cityads.ca_thucydides_new_design.steps.XMLSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.CarcasSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FrontSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


@Story(TestSuite.WebMaster.Downloads.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")

public class DownloadCouponsAllTest extends Constants {


    public String offerName;
    public String offerId;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;


    @Steps
    public DownloadsSteps steps;
    @Steps
    CarcasSteps carcas;
    @Steps
    public FrontSteps front;
    @Steps
    public XMLSteps apiSteps;


    @Before
    public void setUp(){
        front.login();
        carcas.go_to_coupons();
    }



    @Test
    @WithTagValuesOf({"block:Downloads","role:Webmaster"})
    public void downloads_coupons_test() throws Exception{


        String filterName  = getCurrentDate()+"_filter";
        steps.click_reset_filter_button();
        steps.wait_for_all_spinners_dissapears(120);


        offerName =  steps.click_first_offer_in_filrer();
        steps.wait_for_all_spinners_dissapears(30);
        steps.click_apply_right_filter();
        steps.wait_for_all_spinners_dissapears(60);
        steps.check_offer_shown_in_filter_result(offerName);
        steps.scroll_to_bottom();
        steps.save_filter();  //КНПОКА ВЕБДРАЙВЕРОМ НЕ ЖМЕТСЯ,  ВЫЗЫВАЮ С КОНСОЛИ
        steps.wait_for_all_spinners_dissapears(60);
        steps.wait_for_popup_appears(5);
        steps.fill_filter_name_in_popup(filterName);
        steps.wait_for_all_spinners_dissapears(60);
        steps.click_popup_filter_save_button();
        steps.wait_for_all_spinners_dissapears(60);
        steps.wait_for_all_spinners_dissapears(60);
        steps.check_fatal_errors();
        steps.scroll_to_top();
        steps.check_filter_breadcrumbs_is_displayed();
        steps.search_offer_in_filters_breadcrumbs(offerName);

        //переход в инструменты - выгрузки
        steps.click_coupons_filter_create_tool_link();
        steps.wait_for_all_spinners_dissapears(60);
        steps.check_h1_page_title("Добавление фида");
        String feedFilterName   =   steps.get_coupons_feed_filter_name();
        steps.scroll_to_top();
        steps.check_values_are_equals(filterName,feedFilterName );
        steps.wait_for_all_spinners_dissapears(60);


        //создание выгрузки
        String downloadName = getCurrentDate()+" "+getRandomIntNumber();
        String subaccountName = getCurrentDate()+" "+getRandomIntNumber();
        steps.fill_name_input(downloadName);
        steps.fill_subaccount_input(subaccountName);
        //выбор сохраненного фильтра
        steps.click_select_choose();
        steps.select_filter_template(filterName);
        steps.submit_form();
        steps.wait_for_all_spinners_dissapears(60);
        steps.check_blue_table_has_text(downloadName);

        steps.wait_for_all_spinners_dissapears(60);

        steps.wait_for_all_spinners_dissapears(60);

        //check created download
        WebElement string = steps.get_blue_table_string_with_text(downloadName);
        steps.click_icon_in_blue_table_line(0, string);
        steps.wait_for_all_spinners_dissapears(90);
        steps.wait_for_h1_title_appears("Редактирование фида", 15);
        steps.wait_for_all_spinners_dissapears(60);
        steps.check_subaccount_input_has_text(subaccountName);
        steps.check_page_has_text(filterName);


    }

    @Test
    @WithTagValuesOf({"block:Downloads","role:Webmaster"})
    public void downloads_coupons_copy_code_test() throws Exception{


        String filterName = getCurrentDate()+" "+getRandomIntNumber();
        steps.scroll_to_bottom();
        steps.uncheck_filters_move_checkbox();
        steps.wait_for_all_spinners_dissapears(60);
        steps.save_filter();  //КНПОКА ВЕБДРАЙВЕРОМ НЕ ЖМЕТСЯ,  ВЫЗЫВАЮ С КОНСОЛИ
        steps.wait_for_all_spinners_dissapears(60);
        steps.wait_for_popup_appears(5);
        steps.fill_filter_name_in_popup(filterName);
        steps.click_popup_filter_save_button();
        steps.wait_for_all_spinners_dissapears(60);
        steps.check_fatal_errors();
        steps.scroll_to_top();
        steps.check_filter_breadcrumbs_is_displayed();


        //переход в инструменты - выгрузки
        steps.click_coupons_filter_create_tool_link();
        steps.wait_for_all_spinners_dissapears(60);

        steps.check_h1_page_title("Добавление фида");

        String feedFilterName   =   steps.get_coupons_feed_filter_name();
        steps.check_values_are_equals(filterName,feedFilterName );
        steps.wait_for_all_spinners_dissapears(60);
//
        //создание выгрузки
        String downloadName = getCurrentDate()+" "+getRandomIntNumber();
        String subaccountName = getCurrentDate()+" "+getRandomIntNumber();
        steps.fill_name_input(downloadName);
        steps.fill_subaccount_input(subaccountName);
        steps.submit_form();
        steps.wait_for_all_spinners_dissapears(60);
        steps.check_blue_table_has_text(downloadName);

        steps.wait_for_all_spinners_dissapears(60);

         steps.wait_for_all_spinners_dissapears(60);

        //Первый раз кликает
        WebElement string = steps.get_blue_table_string_with_text(downloadName);
        steps.click_icon_in_blue_table_line(1, string);

        steps.wait_for_popup_appears(2);
        String url = steps.get_feed_code();
        steps.wait_for_all_spinners_dissapears(60);
        steps.click_downloads_popup_copy_url_button();
        steps.wait_for_all_spinners_dissapears(60);
        steps.check_text_is_not_displayed(url);
        //Второй раз кликает

        steps.click_icon_in_blue_table_line(1, string);
        steps.wait_for_all_spinners_dissapears(60);
        steps.wait_for_popup_appears(2);
        url = steps.get_feed_code();
        steps.click_downloads_popup_copy_url_button();
        steps.check_text_is_not_displayed(url);
    }




} 
