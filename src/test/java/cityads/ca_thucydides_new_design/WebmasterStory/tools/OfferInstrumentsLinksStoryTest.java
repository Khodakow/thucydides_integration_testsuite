package cityads.ca_thucydides_new_design.WebmasterStory.tools;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.OfferCardSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.sql.Connection;


@Story(TestSuite.WebMaster.OfferInstruments.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class OfferInstrumentsLinksStoryTest extends Constants {

     private Connection con;
     private String wmName;
     private String offerName;
     private String actualOfferName;
     private String code;
     private String offerSite;
     private String actualSite;
     

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;
    
    @Steps
    public OfferCardSteps steps;
    
 
    @Test @WithTagValuesOf({"block:Instruments", "role:Webmaster"})
    public  void wm_offer_instruments_link_test() throws Exception{
        

        wmName = steps.get_wm_name();
        steps.wm_login(wmName);
        steps.wait_for_all_spinners_dissapears(60);
        steps.click_offer_link();
        steps.wait_for_all_spinners_dissapears(60);
        steps.click_web_offers();
        steps.wait_for_all_spinners_dissapears(60);
        steps.wait_for_all_spinners_dissapears(60);
        steps.click_reset_filter_button();
        steps.wait_for_all_spinners_dissapears(60);
        offerName = steps.get_first_offer_name();
        steps.click_first_offer();
        steps.wait_for_start_offer_button_is_visible(15);
        steps.wait_for_h1_title_appears(offerName, 160);
        steps.check_h1_page_title(offerName);
        offerSite = steps.get_offer_site().replaceAll("\\s+","").trim().replace("http://", "");
        
        steps.click_offer_instruments_tab();
        steps.check_links_table_is_present();
        
        steps.click_get_offer_link();
        
        steps.waitAjax(8000);
        code = steps.get_code_from_popup_textarea();
        steps.check_script_code(code);
        actualOfferName = steps.get_offer_name_from_popup();
        steps.check_offer_name_in_popoup(offerName, actualOfferName);
        steps.open_url(code);
        steps.waitAjax(5000);
        actualSite = steps.getCurrentUrl();
        steps.check_offer_site_contains_offer_domain(actualSite,offerSite);
        
        steps.close_browser();
        
    }
    
    
    
    
 
    

    
} 