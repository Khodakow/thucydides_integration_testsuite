package cityads.ca_thucydides_new_design.WebmasterStory.bugs;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.OfferListSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.*;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.Bugs.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="bugs")
public class Bugs49598StoryTest {



    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public OfferListSteps steps;
    @Steps
    public CarcasSteps carcas;
    @Steps
    public FrontSteps front;
    @Steps
    public FilterSteps filter;
    @Steps
    public CouponsSteps coupons;
    @Steps
    public TableSteps table;
    @Steps
    public GoodsSteps goods;


    
    @Test@Screenshots(onlyOnFailures = false)@Title("Проверка на то что кличество товаров не меняется при сортировка")
    public void check49598test(){

        front.login();
        carcas.go_to_goods();
        int goodsCount = goods.get_total_goods();
        goods.sort_by_price_desc();
        int goodsCountNew = goods.get_total_goods();
        steps.check_values_are_equals(goodsCount,goodsCountNew);


        steps.close_browser();

    }
}
