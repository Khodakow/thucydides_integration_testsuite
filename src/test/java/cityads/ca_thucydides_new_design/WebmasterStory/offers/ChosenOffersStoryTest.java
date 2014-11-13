package cityads.ca_thucydides_new_design.WebmasterStory.offers;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.ChosenOffersSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.OfferCardSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.sql.Connection;


@Story(TestSuite.WebMaster.ChosenOffers.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class ChosenOffersStoryTest extends Constants {

     public Connection con;
     public String wmName;
     private String offerName;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;
    
    @Steps
    public ChosenOffersSteps steps;
    @Steps
    public OfferCardSteps oSteps;
    
 
    @Test @WithTagValuesOf({"block:Offers","role:Webmaster"})
    public  void chosen_offers_test() throws Exception{

        
        wmName = steps.get_wm_name();
        steps.wm_login(wmName);
        steps.click_offer_link();
        steps.wait_for_all_spinners_dissapears(60);
        steps.click_web_offers();
        steps.wait_for_all_spinners_dissapears(60);
        steps.check_fatal_errors();
        steps.wait_for_offers_table_appears(60);
        
        steps.click_chosen_offers_links();
        steps.wait_for_all_spinners_dissapears(60);
        steps.uncheck_all_chosen_offers();
       
        steps.click_all_offers_tab();
        steps.wait_for_all_spinners_dissapears(50);
        oSteps.Sort_blue_table_by_first_th();
        steps.wait_for_all_spinners_dissapears(50);

        steps.click_first_star();
        steps.wait_for_all_spinners_dissapears(50);
        steps.click_chosen_offers_links();
        steps.wait_for_all_spinners_dissapears(50);
       
        boolean fisrtStarStatus2 = steps.get_first_star_status();
        steps.check_fatal_errors();
        //steps.check_blue_table_has_text(firstOfferName);
        steps.checkoffer_checked_status_is_true(fisrtStarStatus2);
        steps.uncheck_all_chosen_offers();
       
        
        
        steps.close_browser();
        
    }
    
 
    

    
} 