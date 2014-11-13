/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.WebmasterStory.translate;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.GoodsCatalogSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FrontSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Before;
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
public class CouponsPopUpTranslateStoryTest extends Constants {
    
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
    @Before
    public void setUp(){
        front.login();

    }
    
 
    
    @Steps
    GoodsCatalogSteps steps;
    @Steps
    FrontSteps front;


    
    @Test @WithTagValuesOf({"block:Goods And Coupons", "role:Webmaster"})    
    public void test_coupons_PopUp_regions_TranslateStoryTest()throws Exception{
        

        steps.click_goods_and_coupons_link();
        steps.wait_for_all_spinners_dissapears(60);
        steps.click_goods_link();
        steps.wait_for_all_spinners_dissapears(60);


        steps.change_lang_to_br();

        steps.executeScript("$('div.col.size-16.ib').html('')");                   //убираем описание купона
        steps.executeScript("$('div.col-evil.margin-top-small.lh-16').html('')");

        steps.executeScript("$('div[class=\"_button_place\"]>div[has_modal=1][class*=\"input-button\"]').get(0).click();");
        steps.waitABit(2000);
        steps.executeScript("$('div[class=\"col size-16 ib\"]').text('');");

        steps.check_lang_select();




        
    }
    @Test @WithTagValuesOf({"block:Goods And Coupons", "role:Webmaster"}) 
    public void test_coupons_PopUp_categories_TranslateStoryTest()throws Exception{

        steps.click_goods_and_coupons_link();
        steps.wait_for_all_spinners_dissapears(60);
        steps.click_goods_link();
        steps.wait_for_all_spinners_dissapears(60);
;


        steps.change_lang_to_br();
        steps.executeScript("$('div.col.size-16.ib').html('')");                   //убираем описание купона
        steps.executeScript("$('div.col-evil.margin-top-small.lh-16').html('')");

        steps.executeScript("$('div[class=\"_button_place\"]>div[has_modal=1][class*=\"input-button\"]').get(1).click();");
        steps.waitABit(2000);
        steps.executeScript("$('div[class=\\\"col-evil margin-top-small lh-16\\\"]').text('');");
        steps.executeScript("$('div[class=\"col size-16 ib\"]').text('');");

        steps.check_lang_select();
        
    }

    @Test @WithTagValuesOf({"block:Goods And Coupons", "role:Webmaster"}) 
    public void test_coupons_PopUp_offers_TranslateStoryTest()throws Exception{

        steps.click_goods_and_coupons_link();
        steps.wait_for_all_spinners_dissapears(60);
        steps.click_goods_link();
        steps.wait_for_all_spinners_dissapears(60);



        steps.change_lang_to_br();

        steps.executeScript("$('div.col.size-16.ib').html('')");                   //убираем описание купона
        steps.executeScript("$('div.col-evil.margin-top-small.lh-16').html('')");

        steps.executeScript("$('div[class=\"_button_place\"]>div[has_modal=1][class*=\"input-button\"]').get(2).click();");
        steps.waitABit(2000);
        steps.executeScript("$('div[class=\"col size-16 ib\"]').text('');");
        steps.executeScript("$('div[class=\\\"col-evil margin-top-small lh-16\\\"]').text('');");
        steps.check_lang_select();


        
    }

}