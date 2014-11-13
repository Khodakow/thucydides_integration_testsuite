/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.WebmasterStory.coupons;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.GoodsCatalogSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FilterSteps;
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
@Story(TestSuite.WebMaster.GoodsCatalog.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
@Concurrent
public class GoodsCatalogStoryTest extends Constants {
    
    public Connection con;
    public String wmName;
    private int goodsCardCount;
    private int goodsCardCount1;
    private int goodsCardCount2;
    private int goodsCardCount3;
    private int goodsCardCount4;
    private int goodsCardCount5;

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

    @Steps
    FilterSteps filter;
    
    @Test @WithTagValuesOf({"block:Goods And Coupons", "role:Webmaster"})    
    public void test_goods_catalog()throws Exception{
        
        wmName = steps.get_wm_name();
        steps.wm_login(wmName);
        steps.click_goods_and_coupons_link();
        steps.wait_for_all_spinners_dissapears(60);;
        steps.click_goods_link();
        steps.wait_for_all_spinners_dissapears(60);
        steps.click_goods_catalog();
        steps.wait_for_all_spinners_dissapears(60);
        steps.click_reset_filter_button();
        steps.wait_for_all_spinners_dissapears(60);
      
    
        
        //goods count = 20
        goodsCardCount = steps.get_goods_cards_count();
        goodsCardCount3 = steps.get_goods_cards_count();
        goodsCardCount4 = steps.get_goods_cards_count();
        goodsCardCount5 = steps.get_goods_cards_count();
        //steps.scroll_to_coupon();
        steps.check_goods_card_count(1, goodsCardCount);

        goodsCardCount1 = steps.get_goods_cards_count();
        steps.check_goods_card_count(1, goodsCardCount1);
        steps.wait_for_all_spinners_dissapears(60);

        filter.click_checkbox_in_filter(5,4);
        steps.wait_for_all_spinners_dissapears(60);
        steps.click_apply_right_filter();
        steps.wait_for_all_spinners_dissapears(60);
        steps.wait_for_goods_card_visible(270);
        steps.check_fatal_errors();
        goodsCardCount5 = steps.get_goods_cards_count();
        steps.check_goods_card_count(1, goodsCardCount5);
               

      
        
        steps.close_browser();
        
    }

    
}
