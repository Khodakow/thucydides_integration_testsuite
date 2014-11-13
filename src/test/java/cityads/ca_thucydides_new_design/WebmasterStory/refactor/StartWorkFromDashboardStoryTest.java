package cityads.ca_thucydides_new_design.WebmasterStory.refactor;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.MainSiteSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.CarcasSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.CardSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FrontSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.TableSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.Svodnaya.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class StartWorkFromDashboardStoryTest extends Constants {

    public String wmName;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public MainSiteSteps steps;
    @Steps
    TableSteps table;
    @Steps
    CarcasSteps carcas;
    @Steps
    CardSteps card;
    @Steps
    public FrontSteps front;


    @Test
    public void dashboard_start_work_with_offer_test() throws Exception{

        front.login();
        carcas.go_to_web_offers();
        table.click_first_aviable_offer();
        card.start_work_with_offer();
        card.check_offer_is_avaible();

    }
    
 
    

    
} 