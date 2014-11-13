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
public class Bugs48931StoryTest {



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


    
    @Test@Screenshots(onlyOnFailures = false)
    public void check48931test(){

        front.login();
        carcas.go_to_coupons();
        filter.click_checkbox_in_filter(4,1);
        filter.submit_filter();
        ArrayList<String> statuses = coupons.get_coupons_status();
        steps.check_array_elements_has_string("Активный",statuses);
        steps.close_browser();

    }
}
