package cityads.ca_thucydides_new_design.WebmasterStory.tools;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.GoodsCatalogSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.OfferCardSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.*;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.OfferInstruments.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class OfferCardInstrumentsDownloadStoryTest{



    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public OfferCardSteps steps;

    @Steps
    GoodsCatalogSteps gsteps;

    @Steps
    public CouponsSteps coupons;


    @Steps
    public FrontSteps front;

    @Steps
    public CarcasSteps carcas;


    @Steps
    public TableSteps table;

    @Steps
    public PopupSteps popup;

    @Steps
    public CardSteps card;

    @Steps
    public FilterSteps filter;




    @Test
    @Title("Проверка перехода на выгрузку кунопов с карточки купона из попапа")
    public  void wm_offercard_instruments_downloads_goods_test() throws Exception{
        front.login();

        carcas.go_to_web_offers();
        steps.wait_for_filters();

        steps.click_reset_filter_button();
        steps.click_apply_right_filter();
        steps.wait_for_all_spinners_dissapears(60);

        steps.fill_in_search_filter("PrintClick");
        filter.submit_filter();

        steps.executeScript("$('.blue_table>thead>tr').remove()");
        String offer = table.get_first_aviable_offer_name();
        table.click_first_aviable_offer();
        steps.wait_for_all_spinners_dissapears(60);
        steps.waitABit(5000);
        steps.wait_for_start_offer_button_is_visible(15);

        card.start_work_with_offer();
        popup.click_offercard_coupons_link();
        steps.check_h1_page_title("Купоны и промокоды");

        String filterLegend = filter.get_filter_breadcrumbs();
        //steps.check_string_contains_text(filterLegend,offer);

        gsteps.click_getcode_link();
        gsteps.check_goods_catalog_popup_get_code_is_displayed();
        gsteps.waitAjax(2000);
        String cityLink = gsteps.get_popup_cityads_link();
        steps.open_url(cityLink);
        gsteps.check_landing_url();
        steps.close_browser();

        steps.close_browser();

    }

    @Test
    @Title("Проверка фильтра офферов по чекбоксу -=выгрузка купонов=-")
    public  void wm_offercard_instruments_coupons_filter_test() throws Exception{
        front.login();

        carcas.go_to_web_offers();
        steps.wait_for_filters();

        steps.click_reset_filter_button();
        steps.click_apply_right_filter();
        steps.wait_for_all_spinners_dissapears(60);

        filter.click_checkbox_in_filter(4,2);
        filter.submit_filter();
        steps.executeScript("$('.blue_table>thead>tr').remove()");


        String offer = table.get_first_aviable_offer_name();
        table.click_first_aviable_offer();
        steps.wait_for_all_spinners_dissapears(60);
        steps.wait_for_start_offer_button_is_visible(15);

        card.start_work_with_offer();
        popup.click_offercard_coupons_link();
        steps.check_h1_page_title("Купоны и промокоды");

        steps.close_browser();

    }







} 