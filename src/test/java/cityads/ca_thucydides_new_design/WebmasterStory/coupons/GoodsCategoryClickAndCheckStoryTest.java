/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.WebmasterStory.coupons;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.BaseSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.CarcasSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FrontSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.After;
import org.junit.Before;
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
public class GoodsCategoryClickAndCheckStoryTest{
    
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
    CarcasSteps carcas;
    @Steps
    BaseSteps steps;
    @Steps
    FrontSteps front;

    @Before
    public void setUp(){
        front.login();
    }

    @Test
    @Screenshots(onlyOnFailures = false)
    @Title("Тест на категории в Товарах и купонах с помощью клика на ссылку 53462")
    public void test_53462_byclick_link()throws Exception{
        carcas.go_to_goods_categoty();
        front.clickCategotyLinks();
        front.checkCategotyFilterResult();


    }
}
