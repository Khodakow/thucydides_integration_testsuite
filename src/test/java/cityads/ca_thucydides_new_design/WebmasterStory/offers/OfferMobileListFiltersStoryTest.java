package cityads.ca_thucydides_new_design.WebmasterStory.offers;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.OfferListSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FilterSteps;
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
public class OfferMobileListFiltersStoryTest extends Constants {

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
    public FilterSteps filter;
    
 
    @Test @WithTagValuesOf({"block:Offers", "role:Webmaster"})
    public  void offer_mobile_list_filter_test() throws Exception{

        
        wmName = steps.get_wm_name();
        steps.wm_login(wmName);
        steps.click_offer_link();
        steps.wait_for_all_spinners_dissapears(90);
        steps.click_mobile_offers();
        steps.wait_for_all_spinners_dissapears(90);
        steps.wait_for_blue_table_appears(15);
        steps.click_reset_filter_button();
        steps.wait_for_all_spinners_dissapears(120);
        steps.check_fatal_errors();
        steps.click_all_th_in_blue_table();
        
        //filters
        filter.click_checkbox_in_filter(1,1);
        filter.submit_filter();
        steps.wait_for_all_spinners_dissapears(60);
        steps.check_fatal_errors();


        filter.click_checkbox_in_filter(2,1);
        filter.submit_filter();
        steps.wait_for_all_spinners_dissapears(60);
        steps.check_fatal_errors();


        steps.click_i_checkboxes_in_i_offer_filter(1, 1);
        filter.submit_filter();
        steps.wait_for_all_spinners_dissapears(60);
        steps.check_fatal_errors();


        filter.click_checkbox_in_filter(3,1);
        filter.submit_filter();
        steps.wait_for_all_spinners_dissapears(60);
        steps.check_fatal_errors();


        filter.click_checkbox_in_filter(4,1);
        filter.submit_filter();
        steps.check_fatal_errors();
        steps.check_filter_breadcrumbs_is_displayed();


        filter.click_checkbox_in_filter(5,1);
        filter.submit_filter();
        steps.wait_for_all_spinners_dissapears(60);
        steps.check_fatal_errors();



        
        steps.close_browser();
        
    }
  
    
 
    

    
} 