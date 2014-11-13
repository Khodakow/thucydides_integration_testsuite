/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.steps.WebmasterSteps;

import cityads.ca_thucydides_new_design.pages.MainPage;
import cityads.ca_thucydides_new_design.pages.WemasterPages.BannerRotatorPage;
import cityads.ca_thucydides_new_design.pages.WemasterPages.SmartBannersPage;
import cityads.ca_thucydides_new_design.pages.WemasterPages.TeaserIssuePage;
import cityads.ca_thucydides_new_design.steps.SetupSteps;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
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
public class SmartBannersSteps extends TeaserIssueSteps {

    MainPage mainPage;
    SmartBannersPage page;
            
    public SmartBannersSteps(Pages pages) {
        super(pages);
    }

    @Step
    public void check_prices_in_smart_preview(int minPrice, int maxPrice) {
         List<WebElement> prices = page.previewBlock.findElements(By.className("ca-desc"));
        int size = prices.size();
        int i = 0;
        while(i<size){
            int realPrice = Integer.valueOf(prices.get(i).getText().replaceAll("р.","").replaceAll(" ","").replaceAll("(\\[)","").replaceAll("(\\])",""));
            Assert.assertTrue(realPrice<=maxPrice);
            Assert.assertTrue(realPrice>=minPrice);
            i++;
        }
    }
    
    @Step
    public void check_smart_banner_preview_is_displayed(){
        Assert.assertTrue(page.smartBannerPreview.isDisplayed());
    }
    
    @Step 
    public int get_smartbanners_count_in_preview(){
        return page.getCountSmartBannersInPreview();
    }
    
    @Step
    public void check_smartbanners_count_in_preview(int realCount){
        Assert.assertTrue(realCount>0);
    }
    
    @Step
    public WebElement get_single_banner_from_preview_block(int i){
        return page.getSingleSmartBannerPreview(i);
    }
   
    @StepGroup
    public void check_i_banners_in_preview_block(int size){
        int j = 0;
        while(j<size){
            WebElement banner = get_single_banner_from_preview_block(j);
            check_smart_banner_image(banner);
            check_smart_banner_desc(banner);
            check_smart_banner_title(banner);
            check_smart_banner_button(banner);
            j++;
        }
    }
    
    @Step
    public void check_smart_banner_image(WebElement banner){
         Assert.assertTrue(banner.findElement(By.className("ca-image")).findElement(By.tagName("img")).isDisplayed());
    }
    
    @Step
    public void check_smart_banner_desc(WebElement banner){
         Assert.assertTrue(banner.findElement(By.className("ca-title")).findElement(By.tagName("a")).isDisplayed());
    }
    
    @Step
    public void check_smart_banner_title(WebElement banner){
         Assert.assertTrue(banner.findElement(By.className("ca-title")).findElement(By.tagName("a")).isDisplayed());
    }
    
    @Step
    public void check_smart_banner_button(WebElement banner){
         Assert.assertTrue(banner.findElement(By.className("ca-button")).isDisplayed());
    }
    
    //
    //ca-desc
    //ca-button
    @Step
    public void check_smart_banner_code(String JSCode) {
        Assert.assertTrue(!JSCode.isEmpty());
    }

    @Step
    @Override
    public String get_ajs_code_from_textarea(){
        return page.getSmartBannerAJsCode().getText();
    }
    
    @Step
    @Override
    public String get_js_code_from_textarea(){
         //System.out.println(page.codeAreaJS.getAttribute("innerHTML"));
         return page.getSmartBannerJsCode().getText();
    }
  
    @Step
    @Override
    public String get_xml_code_from_textarea(){
        return page.codeAreaXMLSmartBanners.getText();
    }
    
    }
