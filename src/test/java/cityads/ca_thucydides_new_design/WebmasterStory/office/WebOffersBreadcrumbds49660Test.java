package cityads.ca_thucydides_new_design.WebmasterStory.office;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.MainSiteSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.*;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.Bugs.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class WebOffersBreadcrumbds49660Test {

    public String wmName;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public MainSiteSteps steps;


    @Steps
    FrontSteps front;
    @Steps
    FilterSteps filter;
    @Steps
    StatisticsSteps stat;
    @Steps
    CarcasSteps carcas;
    @Steps
    TableSteps table;

    @Test
    public void webOffersBreadcrumbds49660Test() throws Exception{

        front.login();
        carcas.go_to_web_offers();
        String legend = filter.get_filter_breadcrumbs();
        carcas.click_first_breadcrumbs_link();
        String newLegend = filter.get_filter_breadcrumbs();
        steps.check_values_are_equals(legend,newLegend);
        steps.close_browser();

    }
    
 
    

    
} 