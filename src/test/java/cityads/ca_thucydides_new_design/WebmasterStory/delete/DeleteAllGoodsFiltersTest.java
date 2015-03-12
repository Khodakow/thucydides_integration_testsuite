package cityads.ca_thucydides_new_design.WebmasterStory.delete;

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
public class DeleteAllGoodsFiltersTest {

    
     private String wmName;
    
     
     
    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    
    @Steps
    public DownloadsSteps steps;

    @Steps
    public FrontSteps front;

    @Steps
    public CarcasSteps carcas;
    

    
    @Test
    @Title("Удаление всех фильтров в товарах")
    public void delete_all_goods_filters() throws Exception{

            front.login();
            carcas.go_to_goods();
            steps.delete_all_filters();
            steps.close_browser();

    }
   
 
 
    

    
} 