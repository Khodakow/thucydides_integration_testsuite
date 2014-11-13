/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.WebmasterStory.tools;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.PricePlatformSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FilterSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.sql.Connection;
import java.util.Set;

/**
 *
 * @author s.lugovskiy
 */
@Story(TestSuite.WebMaster.PricePlatform.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class PricePlatformStoryTest extends Constants {
    
    public Connection con;
    public String wmName;
    private int goodsCardCount;
    

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;
    
    @After
    public void close(){
        steps.close_browser();
    }

    @Steps
    PricePlatformSteps steps;

    @Steps
    FilterSteps filter;
    
    @Test @WithTagValuesOf({"block:Goods And Coupons", "role:Webmaster"})   
    public void test_price_platform()throws Exception{
        String offerName;
        Set<String> handleList;
        String lastHandle;
        
        
        wmName = steps.get_wm_name();
        steps.wm_login(wmName);
        steps.click_goods_and_coupons_link();
       
        steps.waitAjax(25000);
        steps.click_goods_link();
       
        steps.click_price_platform_link();
       
        steps.check_fatal_errors();
       ;
       
        
        //coupon count
        goodsCardCount = steps.get_goods_cards_count();
        steps.check_goods_card_count(20, goodsCardCount);
        
        //filters
        steps.check_filters_are_visible();
        filter.click_checkbox_in_filter(1,1);
        filter.click_checkbox_in_filter(2,1);
        filter.click_checkbox_in_filter(3,1);
        filter.click_checkbox_in_filter(4,1);
        steps.click_apply_right_filter();
        steps.check_fatal_errors();
       
        goodsCardCount = steps.get_goods_cards_count();
        steps.check_goods_card_count(2, goodsCardCount);     
        
        //check offer link
            
            
        offerName = steps.get_offer_link_name_in_first_coupon_card();
            
        steps.click_offer_link_in_first_coupon(offerName);
            
        
        //switch to tab
        handleList = steps.get_window_handles();
        lastHandle = steps.get_last_window_handle(handleList);
        steps.switch_to_last_window(lastHandle);
//        steps.check_footer_is_displayed();   когда поправят баг
//       
//       ;

        steps.close_browser();
        
    }
    
    
    
}
