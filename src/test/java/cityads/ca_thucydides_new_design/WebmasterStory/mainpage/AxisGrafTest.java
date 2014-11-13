package cityads.ca_thucydides_new_design.WebmasterStory.mainpage;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.BaseSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.SvodnayaSteps;
import cityads.ca_thucydides_new_design.steps.MainSiteSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.OfferListSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.StatisticSteps;
import java.sql.Connection;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTagValuesOf;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.pages.WebElementFacade;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


@Story(TestSuite.WebMaster.Svodnaya.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="corporate site")
public class AxisGrafTest extends Constants {

    public Connection con;
    public String wmName;
    int heightIncome;
    int heightCpl;
    int widthCpl;
    int widthIncome;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @After
    public void shut_down_driver_process(){
        steps.close_browser();
    }
    
    @Steps
    public StatisticSteps steps;
    @Steps
    public OfferListSteps offerSteps;
    
    @Test @Pending
    public void test_graf_axis_for_changes() throws Exception{
        
        wmName = steps.get_wm_name();
        steps.wm_login(wmName);
        steps.wait_for_all_spinners_dissapears(60);
        String axisText = steps.get_axis_text();
        steps.click_by_week();
        steps.wait_for_all_spinners_dissapears(90);
   
        String newAxisText = steps.get_axis_text();
        steps.check_string_has_changed(axisText, newAxisText);
        steps.close_browser();
        
        
        
    }
 
} 