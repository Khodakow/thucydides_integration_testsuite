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
public class Bugs58862StoryTest {



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

    
    @Title("НЕ ОБНОВЛЯЕТСЯ ЛЕВОЕ МЕНЮ ПРИ КЛИКЕ НА ИКОНКУ ПОМОЩИ")
    @Test
    public void check58862test(){

        front.login("/webmaster/tools/rotators/banners_rotator_416459372.0.htm");
        carcas.go_to_banner_rotator();
        carcas.go_to_api_settings();
        carcas.check_left_api_menu();
        steps.close_browser();

    }
}
