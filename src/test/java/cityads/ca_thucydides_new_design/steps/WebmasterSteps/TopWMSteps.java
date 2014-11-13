/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.steps.WebmasterSteps;

import cityads.ca_thucydides_new_design.pages.MainPage;
import cityads.ca_thucydides_new_design.pages.WemasterPages.BannerRotatorPage;
import cityads.ca_thucydides_new_design.pages.WemasterPages.OfferListPage;
import cityads.ca_thucydides_new_design.pages.WemasterPages.TopOffersPage;
import cityads.ca_thucydides_new_design.steps.SetupSteps;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

/**
 *
 * @author s.lugovskiy
 */
public class TopWMSteps extends SetupSteps {

    
    TopOffersPage page;
    MainPage mainPage;
            
    public TopWMSteps(Pages pages) {
        super(pages);
    }
   @Step 
   public void click_top_wm(){
   mainPage.topWM.click(); 
  }
   @Step
   public void click_tab_top_wm_all(){
   mainPage.topWM_all.click(); 
  }
  
   @Step
   public void click_top_local_WM(){
   mainPage.topWM_local.click();
   }
}
