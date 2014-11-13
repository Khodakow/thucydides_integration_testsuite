package cityads.ca_thucydides_new_design.WebmasterStory.mainpage;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.SvodnayaSteps;
import cityads.ca_thucydides_new_design.steps.MainSiteSteps;
import java.sql.Connection;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTagValuesOf;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.CorporateSite.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="corporate site")
public class MainPageCPLGraphStoryTest extends Constants {

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
    public MainSiteSteps steps;
    
    @Test
    public void test_main_site_cpl_graph() throws Exception{
 
        steps.open_main_page();
        steps.waitAjax(30000);
        heightCpl = steps.get_cpl_chart_height_with_jquery();
        widthCpl = steps.get_cpl_chart_width_with_jquery();
        steps.check_value_gteater_then_min(heightCpl, 0);
        steps.check_value_gteater_then_min(widthCpl, 200);
        steps.close_browser();

    }
    
    @Test
    public void test_main_site_income_graph() throws Exception{
 
        steps.open_main_page();
        steps.waitAjax(30000);
        heightIncome = steps.get_income_chart_height_with_jquery();
        widthIncome = steps.get_income_chart_width_with_jquery();
        steps.check_value_gteater_then_min(heightIncome, 0);
        steps.check_value_gteater_then_min(widthIncome, 200);
        
        steps.close_browser();

    }
   
} 