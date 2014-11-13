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
public class TopOffersSteps extends SetupSteps {

    
    TopOffersPage page;
    MainPage mainPage;
            
    public TopOffersSteps(Pages pages) {
        super(pages);
    }
    
    @Step
    public void click_offer_name(String name){
       getDriver().findElement(By.linkText(name)).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(TopOffersSteps.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Step
    public void refresh_page_n_times(int i) {
      int j =0;
        while(j<=i){
        getDriver().get(getDriver().getCurrentUrl());
        j++;
      }
    }

    @Step
    public void check_values_are_equals(int i, int actualCount) {
        Assert.assertEquals(i,actualCount);
    }

  
}
