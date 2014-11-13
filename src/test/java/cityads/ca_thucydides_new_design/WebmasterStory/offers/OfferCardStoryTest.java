package cityads.ca_thucydides_new_design.WebmasterStory.offers;

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


@Story(TestSuite.WebMaster.OfferCard.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class OfferCardStoryTest extends Constants {

     private Connection con;
     private String wmName;
     private String offerName;
     private String code;
     

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;
    
    @Steps
    public OfferCardSteps steps;

    
    
    
    @Test @WithTagValuesOf({"block:Offers", "role:Webmaster"})
    public  void wm_offer_card_tabs_test() throws Exception{
        
        wmName = steps.get_wm_name();
        steps.wm_login(wmName);
        steps.click_offer_link();
        steps.wait_for_all_spinners_dissapears(60);
        steps.click_web_offers();
        
        steps.wait_for_all_spinners_dissapears(60);
        steps.wait_for_offers_table_appears(25);
        steps.check_fatal_errors();
       
        offerName = steps.get_first_offer_name();
        steps.click_first_offer();
       
       
        steps.wait_for_start_offer_button_is_visible(15);
        steps.check_description_is_visible();
        
        steps.check_offer_card_tab_is_visible(offerTab1);
        steps.check_offer_card_tab_is_visible(offerTab2);
        steps.check_offer_card_tab_is_visible(offerTab4);
        steps.check_offer_card_tab_is_visible(offerTab5);

        steps.waitAjax(5000);
               
        steps.click_offer_tab_card(offerTab1);
        steps.waitAjax(5000);
        steps.check_fatal_errors();


        steps.click_offer_tab_card(offerTab2);
        steps.waitAjax(5000);
        steps.check_offer_tab_h1_appers(0);
        steps.check_fatal_errors();

        
        steps.click_offer_tab_card(offerTab4);
        steps.waitAjax(5000);
        steps.check_offer_tab_h1_appers(1);
        steps.check_fatal_errors();




     
        steps.close_browser();
  }
    
 
    

    
} 