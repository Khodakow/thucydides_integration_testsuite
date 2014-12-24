package cityads.ca_thucydides_new_design.WebmasterStory.Vulcan;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.SetupSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FrontSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.VulcanSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.sql.Connection;
import java.util.Random;


@Story(TestSuite.WebMaster.OfferList.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class VulcanStoryTest {

     public Connection con;
     public String wmName;


    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;
    
    @Steps
    public VulcanSteps steps;

    @Steps
    public SetupSteps main;

    @Steps
    public FrontSteps front;


 
    @Test @WithTagValuesOf({"block:Offers", "role:Webmaster"})
    @Screenshots(onlyOnFailures = false)
    public  void vulcanStoryTest() throws Exception{

        front.login();
        String oldbalance = front.getBalance();
        main.close_browser();



        Random rn = new Random();
/*      steps.set_proxy("80.78.245.89","3128");
        main.open_url("http://www.iplocation.net/");
        main.waitABit(10000);*/
        int i;
        int rand = rn.nextInt(10) + 1;
        for(i=0;i<rand;i++){
            main.open_url("http://188.226.228.112/");
            main.getDriver().findElement(By.id("lead")).click();
            main.waitAjax(7000);
            main.close_browser();
        }
        main.open_url("http://188.226.228.112/");
        main.getDriver().findElement(By.id("lead")).click();
        String email = steps.getEmailFromDb();
        System.out.println(email);
        steps.fillVulcanForm(email);
        main.close_browser();

        front.login();
        main.waitABit(40000);
        main.refresh_page();
        main.wait_for_all_spinners_dissapears();
        String newbalance = front.getBalance();
        main.check_string_has_changed(oldbalance,newbalance);
        main.close_browser();
        

        
    }
  
    
 
    

    
} 