/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.WebmasterStory.tools;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.GoodsCategorySteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FrontSteps;
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
public class GoodsCategoryStoryTest{
    
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
    @Steps
    FrontSteps front;
    

    @Test
    @Title("Проверка раздела Категории товаров на количество категорий")
    public void test_goods_category_for_fatal()throws Exception{
        

        int itemsCount;
        front.login("/webmaster/products_and_coupons/products/categories_403339272.0.htm");
        steps.click_reset_filter_button();
        steps.wait_for_all_spinners_dissapears(120);
        itemsCount = steps.get_categories_items_count();
        steps.check_categories_titles(10,itemsCount);
        steps.close_browser();
}
}
