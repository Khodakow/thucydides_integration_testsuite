package cityads.ca_thucydides_new_design.WebmasterStory.offers;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.TopOffersSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.sql.Connection;


@Story(TestSuite.WebMaster.TopOffers.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class TopOffersStoryTest extends Constants {

     private Connection con;
     private String wmName;
     private String offerName;
     


    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;
    
    @Steps
    public TopOffersSteps steps;
    
    @After
    public void shut_down_driver_process(){
        steps.close_browser();
    }
  
    @Test
    @WithTagValuesOf({"block:Office", "role:Webmaster"})
    public  void wm_top_offers_test() throws Exception{

        
//        wmName = steps.get_wm_name();
//        steps.wm_login(wmName);
//        steps.check_fatal_errors();
//
//        steps.click_Office_link();
//        steps.waitAjax(5000);
//        steps.click_raitings_link();
//        steps.waitAjax(5000);
//        steps.check_fatal_errors();
//        steps.click_top_offers();
//       
////      steps.waitAjax(*);
////      steps.refresh_page_n_times(5);
//       
//        steps.waitAjax(25000);
//        steps.check_fatal_errors();
//       
//       
//        steps.check_blue_table_is_visible();
//        steps.check_blue_table_has_lines();
//        steps.click_all_th_in_blue_table();
//        
//        List<WebElementFacade> offerList = steps.get_offer_list();
//        int actualCount = offerList.size();
//        steps.check_values_are_equals(20, actualCount);
//        
//        offerName  = steps.get_column_text_in_blue_table_first_line(6);
//        steps.click_offer_name(offerName);
//        steps.wait_for_spinner_dissapear(25);
//        steps.waitAjax(5000);
//        steps.check_fatal_errors();
//        steps.check_h1_page_title(offerName);
        
        steps.close_browser();
        
    }
    
 
    

    
} 