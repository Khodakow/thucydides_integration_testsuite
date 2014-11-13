package cityads.ca_thucydides_new_design.WebmasterStory.office;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.NewsSteps;
import java.sql.Connection;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTagValuesOf;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.News.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class NewsStoryTest extends Constants {

     public Connection con;
     public String wmName;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;
    
    @Steps
    public NewsSteps steps;
    
    @After
    public void shut_down_driver_process(){
        steps.close_browser();
    }

    
    @Test @WithTagValuesOf({"block:Office","role:Webmaster"})  
    public  void news_test() throws Exception{

        
        
        wmName = steps.get_wm_name();
        steps.wm_login(wmName);
        steps.click_news_link();
        steps.check_fatal_errors();
       
        steps.check_news_count();
        steps.check_pager_is_displayed();
        //steps.check_news_select_categories_is_displayed();
        steps.check_footer_is_displayed();
        steps.click_first_news();
        steps.check_fatal_errors();
  

        
        steps.close_browser();
        
    }
    
 
    

    
} 