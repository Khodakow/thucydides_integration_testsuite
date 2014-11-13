package cityads.ca_thucydides_new_design.WebmasterStory.offers;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.OfferListSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.sql.Connection;


@Story(TestSuite.WebMaster.NewLocalOffers.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class NewLocalOffresStoryTest extends Constants {

     public Connection con;
     public String wmName;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;
    
    @Steps
    public OfferListSteps steps;
    
 
    @Test @WithTagValuesOf({"block:Offers", "role:Webmaster"})
    public  void wm_local_offers_test() throws Exception{

        
        wmName = steps.get_wm_name();
        steps.wm_login(wmName);
        steps.wait_for_all_spinners_dissapears();
        steps.click_new_local_offers();
        steps.waitAjax(3000);
        steps.check_fatal_errors();
        steps.click_new_recomend_offers();
        steps.waitAjax(3000);
        steps.check_fatal_errors();
//        String offerName = steps.get_first_offer_name();
//        steps.click_first_offer();
//        steps.waitAjax(2000);
//        steps.check_h1_page_title(offerName);
//        
        
        
        
        steps.close_browser();
        
    }
  
    
 
    

    
} 