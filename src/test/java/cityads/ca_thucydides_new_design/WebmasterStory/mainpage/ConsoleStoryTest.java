package cityads.ca_thucydides_new_design.WebmasterStory.mainpage;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.BaseSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.ConsoleSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FrontSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.TestData;
import net.thucydides.junit.runners.ThucydidesParameterizedRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.Collection;


@Story(TestSuite.WebMaster.Svodnaya.class)
@RunWith(ThucydidesParameterizedRunner.class)
@WithTag(name="Webmaster Tests")
@Concurrent(threads = "5")
public class ConsoleStoryTest {


    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    FrontSteps front;
    @Steps
    ConsoleSteps console;
    @Steps
    BaseSteps steps;

    private String url;




    @Before
    public void setUp(){
        front.login(url);
    }


    @TestData
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {"webmaster/office/dashboard"},
                {"webmaster/office/account"},
                {"webmaster/office/billing"},
                {"webmaster/office/api"},
                {"webmaster/office/payments"},
                {"webmaster/office/history"},
                {"webmaster/office/exchange"},
                {"webmaster_pro/offers/web_6635.5.htm"},


                {"webmaster/offers/web_offers_3641940.0.htm?&geo[]=186"},
                {"offers/mobile_offers_407479372.0.htm?&geo[]=186"},


                {"webmaster/tools/rotators/banners_rotator_416459372.0.htm"},
                {"webmaster/instrumentyi/push_ads/getlink_445571172.0.htm?&geo[]=186"},
                {"webmaster/tools/feeds/coupons_feed_3641948.0.htm"},
                {"webmaster/tools/feeds/goods_feed_417519392.0.htm"},
                {"webmaster/tools/back_url_446601153.0.htm"},
                {"webmaster/tools/conversion_postback_423130345.0.htm"},
                {"webmaster/tools/rotators/banners_rotator_416459372.0.htm?act=add&class=56&form=wm.rotator"},
                {"webmaster/tools/feeds/coupons_feed_3641948.0.htm?form=add"},
                {"webmaster/tools/feeds/goods_feed_417519392.0.htm?form=add"},
                {"webmaster/tools/conversion_postback_423130345.0.htm?form=add"},
                {"webmaster/tools/conversion_postback_423130345.0.htm?form=add"},
                {"webmaster/tools/back_url_446601153.0.htm?act=add&form=wm.backurl&class=8"},
                {"webmaster_pro/instrumentyi/big_data/getlink_445571172.0.htm?form=add"},


                {"webmaster/products_and_coupons/coupons/coupons_and_promocodes_3641918.0.htm?&geo[]=186&status[]=1"},
                {"webmaster/products_and_coupons/coupons/coupons_and_promocodes_3641918.0.htm?&geo[]=186&status[]=1"},
                {"webmaster/products_and_coupons/products/categories_403339272.0.htm"}

        });
    }


    public ConsoleStoryTest(String url) {
        this.url = url;
    }

    @Test
    @Title("тест на ошибки в консли ХРОМ")
    public void consoleTest() throws Exception{
        console.check_console_log();
    }

    @Test
    @Title("тест на ошибки sql")
    public void fatalErrorsTest() throws Exception{
        steps.check_fatal_errors();
    }
}

