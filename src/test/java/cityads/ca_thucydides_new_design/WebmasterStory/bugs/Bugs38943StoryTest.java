package cityads.ca_thucydides_new_design.WebmasterStory.bugs;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.GoodsCatalogSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.CarcasSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FrontSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.GoodsSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.TableSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.Bugs.class)
@RunWith(ThucydidesRunner.class)
public class Bugs38943StoryTest {


    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public GoodsCatalogSteps steps;
    @Steps
    public FrontSteps front;
    @Steps
    public CarcasSteps carcas;
    @Steps
    public TableSteps table;
    @Steps
    GoodsSteps goods;


    @After
    public void tearDown(){
        steps.close_browser();
    }

    @Test
    @Title("Проверка сортировки товаров по цене по убыванию, задача 38943")
    public void testBugDescSort38943() throws Exception{

        front.login();
        carcas.go_to_goods();
        goods.click_USD_checkbox();
        steps.click_apply_right_filter();
        steps.wait_for_all_spinners_dissapears(90);
        goods.sort_by_price_desc();
        goods.check_goods_price_desc_sort();
        steps.close_browser();
    }

    @Test
    @Title("Проверка сортировки товаров по цене по возрастанию, задача 38943")
    public void testBugAscSort38943() throws Exception{

        front.login();
        carcas.go_to_goods();
        goods.click_USD_checkbox();
        steps.click_apply_right_filter();
        steps.wait_for_all_spinners_dissapears(90);
        goods.sort_by_price_asc();
        goods.check_goods_price_asc_sort();
        steps.close_browser();
    }


}
