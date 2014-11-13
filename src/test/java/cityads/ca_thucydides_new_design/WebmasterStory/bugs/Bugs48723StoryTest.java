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

import java.util.ArrayList;


@Story(TestSuite.WebMaster.Bugs.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="bugs")
public class Bugs48723StoryTest {



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
    public CardSteps card;

    
    @Test@Screenshots(onlyOnFailures = false)@Title("Проверка на наличие данных в карточке оффера")
    public void check48723test(){

        front.login();
        carcas.go_to_web_offers();
        table.click_first_aviable_offer();
        card.go_to_instrument_tab();

        ArrayList<String> data = card.get_instruments_tab_offer_data();
        card.check_instruments_data_has_no_text(data);

        steps.close_browser();

    }
}
