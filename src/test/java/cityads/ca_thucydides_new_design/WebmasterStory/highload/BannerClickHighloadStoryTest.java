package cityads.ca_thucydides_new_design.WebmasterStory.highload;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.BannerTestSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.BannerRotatorSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.OfferCardSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.TableSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.BannersRotator.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class BannerClickHighloadStoryTest extends Constants {


    private String rotatorName = getCurrentDate()+" "+getRandomIntNumber();
    private String AJSCode;
    private String JSCode;
    private String offerSite;
    private String wmName;
    private String offerName;
    private String offerNameInMultiselect;
     
    

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public OfferCardSteps steps;

    @Steps
    public BannerRotatorSteps bannerSteps;

    @Steps
    public BannerTestSteps btestSteps;

    @Steps
    public TableSteps table;

    
    @Test
    @WithTagValuesOf({"block:Instruments","role:Webmaster"})
    public void banner_rotator_jscode_one_offer_click_test() throws Exception{

        wmName = steps.get_wm_name();
        steps.wm_login(wmName);
        steps.click_offer_link();
        steps.wait_for_all_spinners_dissapears(60);
        steps.click_web_offers();
        steps.wait_for_all_spinners_dissapears(60);
        steps.waitAjax(10000);
        steps.check_fatal_errors();
        steps.click_reset_filter_button();
        steps.wait_for_all_spinners_dissapears(60);

        table.click_first_aviable_offer();

        steps.wait_for_all_spinners_dissapears(60);
        steps.wait_for_start_offer_button_is_visible(15);




        offerSite = steps.get_offer_site().trim().replace("http://","").replace("www.","");


        steps.click_offer_instruments_tab();

        steps.check_links_table_is_present();
        steps.click_create_rotator_icon();
        steps.wait_for_all_spinners_dissapears(90);


        steps.switch_to_last_window();
        steps.wait_for_all_spinners_dissapears(90);

        offerNameInMultiselect = bannerSteps.get_offers_in_multiselect();

        steps.fill_name_input(rotatorName);
        steps.submit_form();
        steps.wait_for_all_spinners_dissapears(90);
        steps.click_icon_in_blue_table_line_with_text(0,rotatorName);
        steps.wait_for_all_spinners_dissapears(90);

        //get code
        steps.waitAjax(2000);
        bannerSteps.scroll_to_select();
        steps.click_select_choose_toggle();
        steps.select_javascript_code();
        steps.check_fatal_errors();
        JSCode = bannerSteps.get_js_code_from_textarea();

        //test script
        steps.open_url("http://test_result.tester.sagl/check_all_offers_codeigniter/index.php?page=banner");
        btestSteps.submit_banner_to_test_form((JSCode));
        btestSteps.click_banner();
        steps.switch_to_last_window();
        String host = steps.getUrlHost(steps.getCurrentUrl().replace("www.",""));
        steps.check_values_are_equals(host,offerSite);







        steps.close_browser();
        
        
    }

    @Test
    @WithTagValuesOf({"block:Instruments","role:Webmaster"})
    public void banner_rotator_async_jscode_one_offer_click_test() throws Exception{

        wmName = steps.get_wm_name();
        steps.wm_login(wmName);
        steps.click_offer_link();
        steps.wait_for_all_spinners_dissapears(60);
        steps.click_web_offers();
        steps.wait_for_all_spinners_dissapears(60);
        steps.waitAjax(10000);
        steps.check_fatal_errors();
        steps.click_reset_filter_button();
        steps.wait_for_all_spinners_dissapears(60);

        table.click_first_aviable_offer();

        steps.wait_for_all_spinners_dissapears(60);
        steps.wait_for_start_offer_button_is_visible(15);




        offerSite = steps.get_offer_site().trim().replace("http://","").replace("www.","");


        steps.click_offer_instruments_tab();

        steps.check_links_table_is_present();
        steps.click_create_rotator_icon();
        steps.wait_for_all_spinners_dissapears(90);


        steps.switch_to_last_window();
        steps.wait_for_all_spinners_dissapears(90);

        offerNameInMultiselect = bannerSteps.get_offers_in_multiselect();

        steps.fill_name_input(rotatorName);
        steps.submit_form();
        steps.wait_for_all_spinners_dissapears(90);
        steps.click_icon_in_blue_table_line_with_text(0,rotatorName);
        steps.wait_for_all_spinners_dissapears(90);

        //get code
        steps.waitAjax(2000);
        bannerSteps.scroll_to_select();
        steps.click_select_choose_toggle();
        steps.select_ajs_code();
        steps.check_fatal_errors();
        JSCode = bannerSteps.get_ajs_code_from_textarea();

        //test script
        steps.open_url("http://test_result.tester.sagl/check_all_offers_codeigniter/index.php?page=banner");
        btestSteps.submit_banner_to_test_form((JSCode));
        btestSteps.click_banner();
        steps.switch_to_last_window();
        String host = steps.getUrlHost(steps.getCurrentUrl().replace("www.",""));
        steps.check_values_are_equals(host,offerSite);







        steps.close_browser();


    }

} 