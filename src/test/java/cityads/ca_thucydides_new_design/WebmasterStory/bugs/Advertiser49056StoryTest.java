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


@Story(TestSuite.Advertiser.Bugs.class)
@RunWith(ThucydidesRunner.class)
public class Advertiser49056StoryTest {

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
    public TableSteps table;


    
    @Test@Screenshots(onlyOnFailures = false)@Title("Проверяем что рекл не может открыть не свой оффер по прямой ссылке")
    public void check49056test(){

        front.loginAdv();
        carcas.go_to_offers_advertiser();
        table.click_first_aviable_offer_adv();
        steps.open_direct_offer_url("132");
        table.check_table_is_not_present();
        steps.close_browser();

    }
}
