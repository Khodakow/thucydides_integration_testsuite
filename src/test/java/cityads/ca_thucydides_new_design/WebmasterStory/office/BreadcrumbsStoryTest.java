package cityads.ca_thucydides_new_design.WebmasterStory.office;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.BaseSteps;
import cityads.ca_thucydides_new_design.steps.SetupSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.CarcasSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FilterSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FrontSteps;
import junit.framework.Assert;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.OfferList.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class BreadcrumbsStoryTest {


    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public FrontSteps front;

    @Steps
    public CarcasSteps carcas;

    @Steps
    public FilterSteps filterSteps;

    @Steps
    public BaseSteps steps;

    @Before
    public void setUp() {
        front.login();

    }

    @Test
    @Screenshots(onlyOnFailures = false)
    @Title("Проверка перехода по хлебным крошкам в разделе Офферы/Веб")
    public void breadCrumbsWebStoryTest() throws Exception{
        carcas.go_to_web_offers();
        String filterWeb = filterSteps.get_filter_breadcrumbs();
        carcas.click_first_breadcrumbs_link();
        String filterWeb2 = filterSteps.get_filter_breadcrumbs();
        steps.check_values_are_equals(filterWeb, filterWeb2);
    }

    @Test
    @Screenshots(onlyOnFailures = false)
    @Title("Проверка перехода по хлебным крошкам в разделе Офферы/Моб")
    public void breadCrumbMobStoryTest() throws Exception{
        carcas.go_to_mob_offers();
        String filterMob = filterSteps.get_filter_breadcrumbs();
        carcas.click_first_breadcrumbs_link();
        carcas.go_to_mob_offers();
        String filterMob2 = filterSteps.get_filter_breadcrumbs();
        steps.check_values_are_equals(filterMob, filterMob2);
    }
}