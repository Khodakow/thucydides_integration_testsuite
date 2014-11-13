/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.WebmasterStory.coupons;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.GoodsCategorySteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
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
@Story(TestSuite.WebMaster.GoodsCategory.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class GoodsCategoryStoryTest extends Constants {
    
    public Connection con;
    public String wmName;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;
    
    @After
    public void close(){
        steps.close_browser();
    }
 
    
    @Steps
    GoodsCategorySteps steps;
    

    @Test @WithTagValuesOf({"block:Goods And Coupons","role:Webmaster"})    
    public void test_goods_category_for_fatal()throws Exception{
        
        wmName = steps.get_wm_name();
        int itemsCount;
        steps.wm_login(wmName);
        steps.click_goods_and_coupons_link();
        steps.wait_for_all_spinners_dissapears(60);
        steps.click_goods_link();
        steps.wait_for_all_spinners_dissapears(60);
        steps.click_categories_link();
        steps.wait_for_all_spinners_dissapears(60);
        steps.waitAjax(8000);
        steps.click_reset_filter_button();
        steps.wait_for_all_spinners_dissapears(120);
       
        itemsCount = steps.get_categories_items_count();
        steps.check_categories_titles(10,itemsCount);
                
        steps.close_browser();
}
}
