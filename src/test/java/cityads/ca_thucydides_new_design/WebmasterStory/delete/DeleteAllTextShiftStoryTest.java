package cityads.ca_thucydides_new_design.WebmasterStory.delete;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.DownloadsSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.CarcasSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FrontSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.Delete.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class DeleteAllTextShiftStoryTest extends Constants {

    
     private String wmName;
    
     
     
    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    
    @Steps
    public DownloadsSteps steps;

    @Steps
    FrontSteps front;
    @Steps
    CarcasSteps carcas;
    

    
    @Test
    public void delete_all_shift() throws Exception{


            front.login();
            carcas.go_to_text_shift();
            steps.delete_all_from_blue_table();
            steps.close_browser();


    }
   
 
 
    

    
} 