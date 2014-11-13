/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.steps.WebmasterSteps;

import cityads.ca_thucydides_new_design.pages.MainPage;
import cityads.ca_thucydides_new_design.pages.WemasterPages.BannerRotatorPage;
import cityads.ca_thucydides_new_design.pages.WemasterPages.ExchangePage;
import cityads.ca_thucydides_new_design.pages.WemasterPages.OfferListPage;
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
public class ExchangeSteps extends SetupSteps {

    
    ExchangePage page;
            
    public ExchangeSteps(Pages pages) {
        super(pages);
    }
    
    @Step
    public void click_exchange_tab(String tabName){
        page.wmExchangeTabs.findElement(By.linkText(tabName)).click();
        
     }
}
