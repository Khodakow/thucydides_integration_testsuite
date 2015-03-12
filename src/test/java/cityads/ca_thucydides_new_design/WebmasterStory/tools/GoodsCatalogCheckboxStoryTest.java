/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.WebmasterStory.tools;

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
@Story(TestSuite.WebMaster.GoodsCatalog.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
@Concurrent
public class GoodsCatalogCheckboxStoryTest extends Constants {

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
    GoodsCatalogSteps steps;

    @Test @WithTagValuesOf({"block:Goods And Coupons", "role:Webmaster"})
    @Title("Проверка колчества регионов в фильтре в разделе Товары")
    public void test_goods_catalog_region_checkboxes()throws Exception{

        wmName = steps.get_wm_name();
        steps.wm_login(wmName);
        steps.click_goods_and_coupons_link();
        steps.wait_for_all_spinners_dissapears(60);
        steps.click_goods_link();
        steps.wait_for_all_spinners_dissapears(60);
        steps.click_goods_catalog();
        steps.wait_for_all_spinners_dissapears(60);

        steps.wait_for_h1_title_appears("Каталог товаров", 34);
        steps.click_all_pluses();
        int regionsNumber = steps.get_offers_regions_count_in_filter();

        steps.check_value_gteater_then_min(regionsNumber, 50);




        steps.close_browser();

    }
    @Test @WithTagValuesOf({"block:Goods And Coupons", "role:Webmaster"})
    @Title("Проверка колчества категорий в фильтре в разделе Товары")
    public void test_goods_catalog_categories_checkboxes()throws Exception{

        wmName = steps.get_wm_name();
        steps.wm_login(wmName);
        steps.click_goods_and_coupons_link();
        steps.wait_for_all_spinners_dissapears(60);
        steps.click_goods_link();
        steps.wait_for_all_spinners_dissapears(60);
        steps.click_goods_catalog();
        steps.wait_for_all_spinners_dissapears(60);

        steps.wait_for_h1_title_appears("Каталог товаров", 1000);
        steps.click_all_pluses();
        int categoriesNumber = steps.get_offers_count_in_filter();
        if(steps.getDriver().getCurrentUrl().contains("cityads")) {
            steps.check_value_gteater_then_min(categoriesNumber, 40);
        }
        else {
            steps.check_value_gteater_then_min(categoriesNumber, 5);
        }


        steps.close_browser();

    }
    @Test @WithTagValuesOf({"block:Goods And Coupons", "role:Webmaster"})
    @Title("Проверка колчества брендов в фильтре в разделе Товары")
    public void test_goods_catalog_brands_checkboxes()throws Exception{

        wmName = steps.get_wm_name();
        steps.wm_login(wmName);
        steps.click_goods_and_coupons_link();
        steps.wait_for_all_spinners_dissapears(60);
        steps.click_goods_link();
        steps.wait_for_all_spinners_dissapears(60);
        steps.click_goods_catalog();
        steps.wait_for_all_spinners_dissapears(60);
        steps.waitAjax(10000);
        steps.click_reset_filter_button();
        steps.wait_for_all_spinners_dissapears(120);
        steps.wait_for_h1_title_appears("Каталог товаров", 35);
        int brandsNumber = steps.get_offers_brands_count_in_filter();
        steps.check_value_gteater_then_min(brandsNumber, 200);
        steps.close_browser();

    }
    @Test @WithTagValuesOf({"block:Goods And Coupons", "role:Webmaster"})
    @Title("Проверка колчества офферов в фильтре в разделе Товары")
    public void test_goods_catalog_offers_checkboxes()throws Exception{

        wmName = steps.get_wm_name();
        steps.wm_login(wmName);
        steps.click_goods_and_coupons_link();
        steps.wait_for_all_spinners_dissapears(60);
        steps.click_goods_link();
        steps.wait_for_all_spinners_dissapears(60);
        steps.click_goods_catalog();
        steps.wait_for_all_spinners_dissapears(60);

        steps.wait_for_h1_title_appears("Каталог товаров", 35);
        steps.click_all_pluses();
        int offerNumber = steps.get_offers_offers_count_in_filter();
        steps.check_value_gteater_then_min(offerNumber, 100);
        steps.close_browser();

    }
    @Test @WithTagValuesOf({"block:Goods And Coupons", "role:Webmaster"})
    @Title("Проверка колчества валют в фильтре в разделе Товары")
    public void test_goods_catalog_currensy_checkboxes()throws Exception{

        wmName = steps.get_wm_name();
        steps.wm_login(wmName);
        steps.click_goods_and_coupons_link();
        steps.wait_for_all_spinners_dissapears(60);;
        steps.click_goods_link();
        steps.wait_for_all_spinners_dissapears(60);
        steps.click_goods_catalog();
        steps.wait_for_all_spinners_dissapears(60);

        steps.wait_for_h1_title_appears("Каталог товаров", 35);
        steps.click_all_pluses();
        int currensyNumber = steps.get_offers_currensy_count_in_filter();

        if(steps.getDriver().getCurrentUrl().contains("cityads")){
            steps.check_value_gteater_then_min(currensyNumber, 15);}
        else{
            steps.check_value_gteater_then_min(currensyNumber, 15);
        }
        steps.close_browser();

    }
}
