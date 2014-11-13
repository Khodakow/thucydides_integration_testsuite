/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.steps.WebmasterSteps;

import cityads.ca_thucydides_new_design.pages.MainPage;
import cityads.ca_thucydides_new_design.pages.WemasterPages.BannerRotatorPage;
import cityads.ca_thucydides_new_design.pages.WemasterPages.TeaserIssueBlockSettignsPage;
import cityads.ca_thucydides_new_design.pages.WemasterPages.TeaserIssuePage;
import cityads.ca_thucydides_new_design.steps.SetupSteps;
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
public class TeaserIssueBlockSettingsSteps extends TeaserIssueSteps {

    MainPage mainPage;
    TeaserIssueBlockSettignsPage page;
            
    public TeaserIssueBlockSettingsSteps(Pages pages) {
        super(pages);
    }
   
    @Step
    public void click_teaser_issue_block_settings(){
        page.teaserIssueBlockSettings.click();
        
    }
    
    @Step
    public void fill_block_number_horizontal(int i){
        page.teaserIssueBlockNumberHorizontal.clear();
        page.teaserIssueBlockNumberHorizontal.sendKeys(String.valueOf(i));
    }
    
    @Step
    public void fill_block_number_vertical(int i){
        page.teaserIssueBlockNumberVertical.clear();
        page.teaserIssueBlockNumberVertical.sendKeys(String.valueOf(i));
    }
    
    @Step
     public void check_number_of_teasers_in_preview(int vertical, int horizontal, int multiply){
            int expectedNumberOfTeasers = multiply;
            int realNumberOfTeasers = page.getTeasersCountInPreview();
            Assert.assertEquals(expectedNumberOfTeasers, realNumberOfTeasers);
    }
    
    @Step
    public void fill_background_color_input(String hexColor){
        page.backrountdColorInput.clear();
        page.backrountdColorInput.sendKeys(hexColor);
        
    }
   
   @Step
    public void fill_background_color_onhover_input(String hexColor){
        page.backgroundColorOnhoverInput.clear();
        page.backgroundColorOnhoverInput.sendKeys(hexColor);
        
    }
    
}
