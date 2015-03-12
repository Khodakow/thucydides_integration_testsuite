/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.WebmasterStory.translate.br;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.GoodsCatalogSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.CarcasSteps;
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
public class GoodsPopUpTranslateStoryTest {
    
    public Connection con;
    public String wmName;
    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;


    @Steps
    GoodsCatalogSteps steps;
    @Steps
    FrontSteps front;
    @Steps
    CarcasSteps carcas;

    @Before
    public void setUp(){
        front.login();
        carcas.go_to_goods();
        steps.change_lang_to_br();
    }

    @Test @WithTagValuesOf({"block:Goods And Coupons", "role:Webmaster"})
    public void test_goods_PopUp_regions_TranslateStoryTest()throws Exception{


        steps.executeScript("$('div.col.size-16.ib').html('')");                   //убираем описание купона
        steps.executeScript("$('div.col-evil.margin-top-small.lh-16').html('')");
        steps.executeScript("$('div[class*=\"input-button _modal_button\"]').get(0).click()");
        steps.waitABit(2000);
        steps.executeScript("$('div[class=\"col size-16 ib\"]').text('');");
        steps.executeScript("$('div[class*=\"table-card\"]>div>div:eq(1)>div>a').text('')");
        steps.check_lang_select();
    }

    @Test @WithTagValuesOf({"block:Goods And Coupons", "role:Webmaster"}) 
    public void test_goods_PopUp_categories_TranslateStoryTest()throws Exception{
        steps.executeScript("$('div.col.size-16.ib').html('')");                   //убираем описание купона
        steps.executeScript("$('div.col-evil.margin-top-small.lh-16').html('')");
        steps.executeScript("$('div[class*=\"input-button _modal_button\"]').get(1).click()");
        steps.waitABit(2000);
        steps.executeScript("$('div[class=\\\"col-evil margin-top-small lh-16\\\"]').text('');");
        steps.executeScript("$('div[class=\"col size-16 ib\"]').text('');");
        steps.executeScript("$('div[class*=\"table-card\"]>div>div:eq(1)>div>a').text('')");
        steps.check_lang_select();
    }

    @Test @WithTagValuesOf({"block:Goods And Coupons", "role:Webmaster"})
    @Title("Купоны попапы переводы")
    public void test_goods_PopUp_offers_TranslateStoryTest()throws Exception{

        steps.executeScript("$('div.col.size-16.ib').html('')");                   //убираем описание купона
        steps.executeScript("$('div.col-evil.margin-top-small.lh-16').html('')");
        steps.executeScript("$('div[class*=\"input-button _modal_button\"]').get(2).click()");
        steps.waitABit(2000);
        steps.executeScript("$('div[class=\"col size-16 ib\"]').text('');");
        steps.executeScript("$('div[class=\\\"col-evil margin-top-small lh-16\\\"]').text('');");
        steps.executeScript("$('div[class*=\"table-card\"]>div>div:eq(1)>div>a').text('')");
        steps.check_lang_select();

    }

}
