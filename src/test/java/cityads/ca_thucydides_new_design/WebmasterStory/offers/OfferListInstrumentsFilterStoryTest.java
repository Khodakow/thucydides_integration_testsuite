package cityads.ca_thucydides_new_design.WebmasterStory.offers;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.DownloadsSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.OfferCardSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.OfferListSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.sql.Connection;


@Story(TestSuite.WebMaster.OfferList.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class OfferListInstrumentsFilterStoryTest extends Constants {

     public Connection con;
     public String wmName;
     private String offerName;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;
    
    @Steps
    public OfferListSteps steps;
    @Steps
    public OfferCardSteps cardSteps;
    
 
    @Test @WithTagValuesOf({"block:Offers", "role:Webmaster"})
    public  void wm_offer_list_instrument_filter_downloads_coupons_story_test() throws Exception{

        
        wmName = steps.get_wm_name();
        steps.wm_login(wmName);
        steps.click_offer_link();
        steps.wait_for_all_spinners_dissapears(90);

        steps.click_web_offers();
        steps.waitABit(1000);
        steps.wait_for_all_spinners_dissapears(90);
        steps.wait_for_offers_table_appears(25);
        steps.click_reset_filter_button();
        steps.waitABit(1000);
        steps.wait_for_all_spinners_dissapears(90);
        steps.waitABit(1000);
        steps.resize_all_filters();
        steps.click_checkbox_in_filter_with_text("Выгрузки купонов");
        steps.click_apply_right_filter();
        steps.waitABit(1000);
        steps.wait_for_all_spinners_dissapears(90);
        String offerName = steps.get_first_offer_name();
        steps.waitABit(1000);
        steps.click_first_offer();
        steps.waitABit(1000);
        steps.wait_for_all_spinners_dissapears(90);


        //offer card
        steps.wait_for_all_spinners_dissapears(60);
        steps.check_h1_page_title(offerName);
        cardSteps.click_offer_instruments_tab_by_id();
        steps.wait_for_all_spinners_dissapears(60);
        steps.scroll_to_bottom();
        
         if (steps.getDriver().getCurrentUrl().contains("cityads")){
            cardSteps.click_create_download_coupons_icon();
         }


        steps.close_browser();
        
    }

    //@Test @WithTagValuesOf({"block:Offers", "role:Webmaster"})
    public  void wm_offer_list_instrument_filter_downloads_goods_story_test() throws Exception{


        wmName = steps.get_wm_name();
        steps.wm_login(wmName);
        steps.click_offer_link();
        steps.wait_for_all_spinners_dissapears(90);

        steps.click_web_offers();
        steps.wait_for_filters();
        steps.wait_for_all_spinners_dissapears(90);
        steps.wait_for_offers_table_appears(25);
        steps.click_reset_filter_button();
        steps.wait_for_all_spinners_dissapears(90);
        steps.resize_all_filters();
        steps.click_checkbox_in_filter_with_text("Выгрузки товаров");
        steps.click_apply_right_filter();
        steps.wait_for_all_spinners_dissapears(90);
        String offerName = steps.get_first_offer_name();
        steps.click_first_offer();
        steps.wait_for_all_spinners_dissapears(90);


        //offer card
        steps.wait_for_all_spinners_dissapears(60);
        steps.check_h1_page_title(offerName);
        cardSteps.click_offer_instruments_tab_by_id();
        steps.wait_for_all_spinners_dissapears(60);
        steps.scroll_to_bottom();
        cardSteps.click_create_download_goods_icon();



        steps.close_browser();

    }
 
    

    
} 