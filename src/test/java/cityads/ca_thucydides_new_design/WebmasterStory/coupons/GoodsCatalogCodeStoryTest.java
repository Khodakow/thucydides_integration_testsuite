/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.WebmasterStory.coupons;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.GoodsCatalogSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.sql.Connection;

/**
 *
 * @author s.lugovskiy
 */
@Story(TestSuite.WebMaster.GoodsCatalogCode.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
@Concurrent
public class GoodsCatalogCodeStoryTest extends Constants {
    
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
    GoodsCatalogSteps steps;
    
      
    
    @Test @WithTagValuesOf({"block:Goods And Coupons", "role:Webmaster"}) 
    public void test_goods_catalog_get_code()throws Exception{
        String cityLink;
        String deepLink;
        
        
        wmName = steps.get_wm_name();
        steps.wm_login(wmName);
        steps.waitAjax(8000);
        steps.click_goods_and_coupons_link();
        steps.wait_for_all_spinners_dissapears(60);
        steps.click_goods_link();
        steps.wait_for_all_spinners_dissapears(60);
        steps.click_goods_catalog();
        steps.wait_for_all_spinners_dissapears(60);
        steps.click_reset_filter_button();
        
        steps.wait_for_all_spinners_dissapears(60);
        steps.waitABit(25000);
       
       
        steps.click_getcode_link();
       
        steps.check_goods_catalog_popup_get_code_is_displayed();
        steps.waitAjax(2000);
        cityLink = steps.get_popup_cityads_link();
        steps.open_url(cityLink);
        steps.waitAjax(8000);
        steps.check_landing_url();
        steps.close_browser();
        
        steps.wm_login(wmName);
        steps.click_goods_and_coupons_link();
        steps.wait_for_all_spinners_dissapears(30);
        steps.click_goods_link();
        steps.wait_for_all_spinners_dissapears(30);
        steps.click_goods_catalog();
        steps.wait_for_all_spinners_dissapears(30);
        steps.wait_for_goods_card_visible(270);
        steps.waitAjax(5000);
        steps.click_getcode_link();
        steps.waitAjax(5000);
        deepLink = steps.get_popup_cityads_link();
        steps.open_url(deepLink);
        steps.waitAjax(5000);
        steps.check_landing_url();
           
        steps.close_browser();
        
    }
    
}
