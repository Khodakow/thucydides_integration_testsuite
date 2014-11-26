package cityads.ca_thucydides_new_design.WebmasterStory.refactor;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.OfferCardSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.StatisticSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FilterSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.Connection;


@Story(TestSuite.WebMaster.Statistic.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class StatisticRealtimeStoryTest extends Constants {

     public Connection con;
     public String wmName;
 

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @After
    public void shut_down_driver_process(){
        steps.close_browser();
    }
    
    
    @Steps
    public StatisticSteps steps;
    
    @Steps
    public OfferCardSteps offerSteps;

    @Steps
    public FilterSteps filter;

    @Test@Screenshots(onlyOnFailures = true)
    public void statistic_real_time_screen_test() throws Exception{
       
              
        wmName = steps.get_wm_name();
        steps.wm_login(wmName);
        
        //get link for stat test 
        offerSteps.click_offer_link();
        offerSteps.wait_for_all_spinners_dissapears(60);
        offerSteps.click_web_offers();
        
        offerSteps.wait_for_all_spinners_dissapears(60);
        offerSteps.check_fatal_errors();

        filter.reset_filter();
        filter.submit_filter();


        offerSteps.click_offer_by_name("003");
        steps.waitABit(4000);
        offerSteps.wait_for_start_offer_button_is_visible(15);
        offerSteps.check_description_is_visible();
        offerSteps.click_add_offer_link();
        steps.wait_for_all_spinners_dissapears(60);
        offerSteps.check_offercard_popup_is_displayed();
        offerSteps.click_add_link_popup_button();
        String code = offerSteps.get_code_from_popup_textarea();
       
        
        //open statistic
        steps.click_statistic_link();
        steps.check_fatal_errors();
        steps.wait_for_all_highcharts_displayed(60);   
        steps.wait_for_all_spinners_dissapears(60);
        
        WebElement chartByMin = steps.get_innerHTML_from_minutes_hightcharts();
        String parametersByMin = steps.get_graph_parameters_from_highchart(chartByMin);
        
        //open link in new window
        steps.executeScript("window.open();");
        steps.switch_to_last_window();
        steps.open_url(code);
        steps.switch_to_first_window();
       
       
        steps.waitAjax(60000);
        steps.refresh_page();
        steps.waitAjax(10000);
        WebElement chartBySecNew = steps.get_innerHTML_from_minutes_hightcharts();
        String parametersByMinNew = steps.get_graph_parameters_from_highchart(chartBySecNew);
        steps.check_chart_has_changed(parametersByMinNew, parametersByMin);
      
    }
    
 
    

    
} 