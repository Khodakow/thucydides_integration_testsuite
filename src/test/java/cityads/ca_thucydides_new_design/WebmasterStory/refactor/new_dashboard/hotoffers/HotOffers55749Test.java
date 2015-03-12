package cityads.ca_thucydides_new_design.WebmasterStory.refactor.new_dashboard.hotoffers;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.BaseSteps;
import cityads.ca_thucydides_new_design.steps.HotOfferSteps;
import cityads.ca_thucydides_new_design.steps.SetupSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.OfferCardSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.*;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.Svodnaya.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class HotOffers55749Test {

    public String wmName;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    HotOfferSteps hot;

    @Steps
    FrontSteps front;

    @Steps
    SetupSteps steps;

    @Steps
    BaseSteps base;

    @Steps
    CardSteps card;

    @Steps
    PopupSteps popup;

    @Steps
    CarcasSteps carcas;

    @Steps
    OfferCardSteps offerSteps;

    @Steps
    FilterSteps filter;

    @Steps
    TableSteps table;

    @Before
    public void setUp(){
        front.login();
        hot.stop_slider();
    }


    @Test
    @Title("Проверка верстки при уменьшении размеров окна")
    public void check_window_resize(){
        hot.click_first_slider();
        steps.resize_window(2);
        hot.check_offercard_tooltip_number();
    }

    @Test
    @Title("Проверка совпадения инструментов по офферу из хотофферс и из раздела офферы")
    public void check_hotoffers_instruments(){
        hot.click_first_slider();
        String offer = hot.go_to_first_hot_offer();
        card.start_work_with_offer();
        Integer num = popup.get_tools_count();
        carcas.go_to_web_offers();
        filter.reset_filter();
        filter.submit_filter();
        filter.search_by_keyword(offer);
        filter.submit_filter();
        table.click_first_aviable_offer();
        card.start_work_with_offer();
        Integer num2 = popup.get_tools_count();
        base.check_values_are_equals(num,num2);


    }



} 