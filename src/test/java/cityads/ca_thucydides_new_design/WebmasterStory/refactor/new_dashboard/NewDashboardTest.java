package cityads.ca_thucydides_new_design.WebmasterStory.refactor.new_dashboard;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.MainSiteSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FrontSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.NewDashboardSteps;
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
public class NewDashboardTest {

    public String wmName;
    private String caseId = "212";

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public MainSiteSteps steps;


    @Steps
    FrontSteps front;
    @Steps
    NewDashboardSteps newdash;
    @Before
    public void setUp(){
        front.login();
    }

    //@Rule
    //public MethodRule rule = new TestRailRule(this.caseId);


    @Test
    public void dashboardAllOfferslinkTest() throws Exception{
        newdash.clickAllOffers();
        steps.check_h1_page_title("Веб-офферы");
    }

    @Test
    public void dashboardStructureTest() throws Exception{
        newdash.checkStructure();
    }

    
} 