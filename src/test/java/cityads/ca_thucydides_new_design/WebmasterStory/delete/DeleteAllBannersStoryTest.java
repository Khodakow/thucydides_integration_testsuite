package cityads.ca_thucydides_new_design.WebmasterStory.delete;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.DownloadsSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;




@Story(TestSuite.WebMaster.Delete.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class DeleteAllBannersStoryTest extends Constants {

    
     private String wmName;
    
     
     
    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    
    @Steps
    public DownloadsSteps steps;
    

    
    @Test
    public void delete_all_banners() throws Exception{
       
        wmName = steps.get_wm_name();
        steps.wm_login(wmName);
        steps.click_instruments_link();
        steps.wait_for_all_spinners_dissapears(120);
        steps.click_rotators_link();
        steps.wait_for_all_spinners_dissapears(120);
        steps.click_banners_rotator();
        steps.wait_for_all_spinners_dissapears(120);
        steps.delete_all_from_blue_table();
        steps.close_browser();

    }
   
 
 
    

    
} 