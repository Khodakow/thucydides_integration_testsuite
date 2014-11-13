package cityads.ca_thucydides_new_design.WebmasterStory.mainpage;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.MainSiteSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.sql.Connection;


@Story(TestSuite.WebMaster.CorporateSite.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="corporate site")
public class CompainHistoryNotNullStoryTest extends Constants {

    public Connection con;
    public String wmName;

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
    public void test_main_site_compain_history_values() throws Exception{
 
        steps.open_main_page();
        steps.select_ru_language();
        steps.waitABit(3000);
        steps.check_fatal_errors();
        steps.waitABit(3000);
        steps.check_home_big_banner_is_present();
        steps.waitABit(3000);
        steps.click_compain_history();
        steps.check_all_values_in_compain_history();
        steps.close_browser();
        
        
    }


} 