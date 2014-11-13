package cityads.ca_thucydides_new_design.WebmasterStory.tools;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.BannerRotatorSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.OfferCardSteps;
import java.sql.Connection;
import java.util.Set;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTagValuesOf;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.OfferInstruments.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class OfferInstrumentsDynamicRotatorsStoryTest extends Constants {

     private Connection con;
     private String wmName;
     private String offerName;
     private String offerNameInMultiselect;
     private String actualOfferName;
     private String code;
     private String offerSite;
     private String actualSite;
     private Set<String> handleList;
     private String lastHandle;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;
    
    @Steps
    public OfferCardSteps steps;
    
    @Steps
    public BannerRotatorSteps bannerSteps;

 
    @Test @WithTagValuesOf({"block:Instruments", "role:Webmaster"})
    public  void wm_offer_instruments__dynamic_rotator_test() throws Exception{
        

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
        offerName = "003.RU";
        steps.fill_in_search_filter(offerName);
        steps.click_apply_right_filter();
        steps.wait_for_all_spinners_dissapears(60);
        steps.click_offer_by_name(offerName);
        steps.wait_for_all_spinners_dissapears(60);
        steps.wait_for_start_offer_button_is_visible(15);

        

        steps.check_h1_page_title(offerName);
        offerSite = steps.get_offer_site().trim();

        steps.click_offer_instruments_tab_by_id();
        steps.wait_for_all_spinners_dissapears(30);
        steps.check_links_table_is_present();
         if (steps.getDriver().getCurrentUrl().contains("cityads")){
        steps.click_dynamic_tab();
        steps.wait_for_all_spinners_dissapears(30);
        steps.click_dynamic_preview();
        steps.waitABit(2000);
        steps.check_dynamic_prewiew_is_visible();
        steps.close_window();
        steps.click_dynamic_code_popup();
        String code = steps.get_code_from_popup_textarea();
        Assert.assertNotNull(code);
         }
        steps.close_browser();
         
    }
    
    
    
    
 
    

    
} 