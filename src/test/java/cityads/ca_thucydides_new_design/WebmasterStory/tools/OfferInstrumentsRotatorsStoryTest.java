package cityads.ca_thucydides_new_design.WebmasterStory.tools;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.BannerRotatorSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.OfferCardSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FilterSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.TableSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.sql.Connection;
import java.util.Set;


@Story(TestSuite.WebMaster.OfferInstruments.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class OfferInstrumentsRotatorsStoryTest{

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
    @Steps
    public TableSteps table;
    @Steps
    public FilterSteps filter;

 
    @Test @WithTagValuesOf({"block:Instruments", "role:Webmaster"})
    public  void wm_offer_instruments_rotator_test() throws Exception{
        

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


        filter.click_checkbox_in_filter(4,1);
        filter.submit_filter();
        offerName = steps.get_first_offer_name();
        table.click_first_aviable_offer();
        steps.check_h1_page_title(offerName);
        offerSite = steps.get_offer_site().trim();

        steps.click_offer_instruments_tab();
       
        steps.check_links_table_is_present();
        steps.click_create_rotator_icon();
        steps.wait_for_all_spinners_dissapears(90);
       
        
        steps.switch_to_last_window();
        steps.waitABit(5000);
        steps.wait_for_all_spinners_dissapears(90);
        
        offerNameInMultiselect = bannerSteps.get_offers_in_multiselect();
        steps.check_offer_name_present_in_rotator(offerNameInMultiselect, offerName);
        
        

     
        
        steps.close_browser();
        
    }
    
    
    
    
 
    

    
} 