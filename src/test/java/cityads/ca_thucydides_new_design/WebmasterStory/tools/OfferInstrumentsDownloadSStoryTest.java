package cityads.ca_thucydides_new_design.WebmasterStory.tools;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.BannerRotatorSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.DownloadsSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.OfferCardSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.CarcasSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FilterSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FrontSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.TableSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.OfferInstruments.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class OfferInstrumentsDownloadSStoryTest extends Constants {



    @Managed(uniqueSession = false)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public OfferCardSteps steps;

    @Steps
    public BannerRotatorSteps bannerSteps;

    @Steps
    public DownloadsSteps downloadSteps;

    @Steps
    public FrontSteps front;

    @Steps
    public CarcasSteps carcas;

    @Steps
    public FilterSteps filter;

    @Steps
    public TableSteps table;





    @Test @WithTagValuesOf({"block:Instruments", "role:Webmaster"})
    public  void wm_offer_instruments_downloads_goods_test() throws Exception{
        front.login();
        String offerNameHardcore = "Aliexpress";

        carcas.go_to_web_offers();
        steps.wait_for_filters();

        steps.click_reset_filter_button();
        steps.click_apply_right_filter();
        steps.wait_for_all_spinners_dissapears(60);

        filter.click_checkbox_in_filter(4,3);
        filter.submit_filter();
        table.click_first_aviable_offer();
        steps.wait_for_all_spinners_dissapears(60);
        steps.wait_for_start_offer_button_is_visible(15);

        steps.click_offer_instruments_tab_by_id();
        steps.wait_for_all_spinners_dissapears(60);

        //steps.scroll_to_bottom();
        steps.click_create_download_goods_icon();
        steps.wait_for_all_spinners_dissapears(60);
        steps.switch_to_last_window();
        steps.wait_for_all_spinners_dissapears(60);
        steps.check_h1_page_title("Каталог товаров");
        steps.close_browser();

    }

    //@Test @WithTagValuesOf({"block:Instruments", "role:Webmaster"})
    public  void wm_offer_instruments_downloads_coupons_test() throws Exception{

        front.login();
        carcas.go_to_web_offers();
        steps.wait_for_filters();

        steps.click_reset_filter_button();
        steps.click_apply_right_filter();
        steps.wait_for_all_spinners_dissapears(60);

        filter.click_checkbox_in_filter(4,2);
        filter.submit_filter();
        table.click_first_aviable_offer();
        steps.wait_for_all_spinners_dissapears(60);
        steps.wait_for_start_offer_button_is_visible(15);

        steps.click_offer_instruments_tab_by_id();
        steps.wait_for_all_spinners_dissapears(60);

        steps.scroll_to_bottom();

        if (steps.getDriver().getCurrentUrl().contains("cityads")) {
            steps.click_create_download_coupons_icon();
            steps.wait_for_all_spinners_dissapears(60);
            steps.switch_to_last_window();
            steps.wait_for_all_spinners_dissapears(60);
            steps.check_h1_page_title("Купоны и промокоды");

        }

        steps.close_browser();
    }









} 