/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.steps.WebmasterSteps;

import cityads.ca_thucydides_new_design.pages.MainPage;
import cityads.ca_thucydides_new_design.pages.WemasterPages.BannerRotatorPage;
import cityads.ca_thucydides_new_design.pages.WemasterPages.CouponsAndPromocodesFilterSavePage;
import cityads.ca_thucydides_new_design.pages.WemasterPages.CouponsAndPromocodesPage;
import cityads.ca_thucydides_new_design.pages.WemasterPages.TeaserIssuePage;
import cityads.ca_thucydides_new_design.steps.SetupSteps;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author s.lugovskiy
 */
public class CouponsAndPromocodesFilterSaveSteps extends CouponsAndPromocodesSteps {

    MainPage mainPage;
    CouponsAndPromocodesFilterSavePage page;
            
    public CouponsAndPromocodesFilterSaveSteps(Pages pages) {
        super(pages);
    }

    


   
   @Step
    public void click_save_little_button(){
        page.getSaveLittleButton().click();
    }
    
   @Step
    public void scroll_to_apply_coupons_button() {
        scroll(page.applyFilterRight);
    }

  
}
