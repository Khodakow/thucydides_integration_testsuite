package cityads.ca_thucydides_new_design.WebmasterStory.office;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.OperationHistorySteps;
import java.sql.Connection;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTagValuesOf;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.OperationHistory.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class OperationHistoryStoryTest extends Constants {

     public Connection con;
     public String wmName;


    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;
    
    @Steps
    public OperationHistorySteps steps;
    
 
    @Test @WithTagValuesOf({"block:Office", "role:Webmaster"})
    public  void operation_history_test() throws Exception{

        
        wmName = steps.get_wm_name();
        steps.wm_login(wmName);
        steps.click_finances_link();
        steps.click_operation_history_link();
        steps.waitAjax(8000);
        steps.wait_for_h1_title_appears("История операций", 60);
        steps.check_fatal_errors();
       
       
        steps.check_blue_table_is_visible();
        steps.check_blue_table_has_lines();
//        steps.click_all_th_in_blue_table();
//        steps.fill_go_to_page_field("2");
//        steps.click_go_to_page_arrow();
        steps.check_fatal_errors();
        steps.check_blue_table_is_visible();
        steps.check_blue_table_has_lines();
        
        steps.close_browser();
        
    }
    
 
    

    
} 