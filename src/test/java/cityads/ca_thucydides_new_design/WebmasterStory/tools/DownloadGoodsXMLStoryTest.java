package cityads.ca_thucydides_new_design.WebmasterStory.tools;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.DownloadsSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FilterSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FrontSteps;
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
public class DownloadGoodsXMLStoryTest extends Constants {


    private String wmName;
    public String offerName;
    public String offerId;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;


    @Steps
    public DownloadsSteps steps;
    @Steps
    public FilterSteps filter;
    @Steps
    public FrontSteps front;



    @Test
    @Title("Тест на выгрузку  товаров в xml")
    @WithTagValuesOf({"block:Downloads","role:Webmaster"})
    public void downloads_goods_xml_test() throws Exception{


        front.login("/webmaster/products_and_coupons/products/catalog_403319272.0.htm");

        filter.click_checkbox_in_filter(3,1);
        filter.submit_filter();
        steps.wait_for_all_spinners_dissapears();


        //получаем имя и ID первого оффера 
        offerName = steps.get_goods_name_from_goods_card();
        offerId = steps.get_goods_id_from_coupon_card();   //получение id оффера

        steps.click_add_offers_plus_button();
        steps.wait_for_popup_appears(2);
        steps.fill_coupons_popup_input_offer(offerName);
        steps.click_second_checkbox_in_offer_choose_popup();

        steps.click_coupons_filter_popup_submit();

        String filterName = getCurrentDate()+" "+getRandomIntNumber();
        String downloadName = getCurrentDate()+" "+getRandomIntNumber();
        String subaccountName = getCurrentDate()+" "+getRandomIntNumber();

        steps.wait_for_all_spinners_dissapears(30);
        steps.click_apply_right_filter();
        steps.wait_for_all_spinners_dissapears(60);
        
        int offerNumber = steps.get_offers_offers_count_in_filter();

        if (steps.getDriver().getCurrentUrl().contains("cityads")) {
            steps.check_value_gteater_then_min(offerNumber, 50);
        } else {
            steps.check_value_gteater_then_min(offerNumber, 22);
        }
        
        steps.uncheck_filters_move_checkbox();
        steps.save_filter();
        steps.wait_for_all_spinners_dissapears();
        steps.fill_filter_name_in_popup(filterName);
        steps.click_popup_filter_save_button();
        steps.wait_for_all_spinners_dissapears();
        steps.check_fatal_errors();
        steps.scroll_to_top();
        steps.check_filter_breadcrumbs_is_displayed();
        steps.search_offer_in_filters_breadcrumbs(offerName);
        //переход в инструменты - выгрузки
        steps.click_goods_filter_create_tool_link();
        steps.wait_for_all_spinners_dissapears();
        steps.check_h1_page_title("Добавление фида");
        String feedFilterName  =  steps.get_coupons_feed_filter_name();
        steps.check_values_are_equals(filterName,feedFilterName );
        steps.wait_for_all_spinners_dissapears();

        steps.fill_name_input(downloadName);
        steps.fill_subaccount_input(subaccountName);
        steps.submit_form();
        steps.wait_for_all_spinners_dissapears();
        steps.check_blue_table_has_text(downloadName);

        steps.wait_for_all_spinners_dissapears();

        WebElement string = steps.get_blue_table_string_with_text(downloadName);
        steps.click_icon_in_blue_table_line(1, string);


        steps.wait_for_all_spinners_dissapears();
        String url = steps.get_feed_code();
        steps.wait_for_all_spinners_dissapears();
        steps.check_string_contains_text(url,"goods");
        steps.open_url(url);
        steps.check_text_in_page(offerName);
        steps.close_browser();

    }






} 