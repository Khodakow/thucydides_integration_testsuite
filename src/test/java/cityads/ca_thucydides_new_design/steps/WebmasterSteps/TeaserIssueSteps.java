/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.steps.WebmasterSteps;

import cityads.ca_thucydides_new_design.pages.MainPage;
import cityads.ca_thucydides_new_design.pages.WemasterPages.BannerRotatorPage;
import cityads.ca_thucydides_new_design.pages.WemasterPages.TeaserIssuePage;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author s.lugovskiy
 */
public class TeaserIssueSteps extends BannerRotatorSteps {

    MainPage mainPage;
    TeaserIssuePage page;
            
    public TeaserIssueSteps(Pages pages) {
        super(pages);
    }
   
    
    
    @Step
    public String get_teaser_issue_category_select_value(){
        return page.teaserIssueCatSelectValue.getText();
    }
    
    @Step
    public void fill_teaser_issue_age(String age){
        page.teaserIssueAge.sendKeys(age);
    }
    
    @Step
    public void select_n_items_in_actions_chosen_multiselect(int n){
        int j;
        j=0;
        click_i_multiselect_button(0);
        while(j<n){
            click_popup_small_arrow();
            click_first_item_in_popup_dropdown_list();
            j++;
        }
        clickApplyButton();
                
    }
    
    @Step
    public void check_teaser_preview_is_displayed(){
       
        Assert.assertTrue(page.teaser.isDisplayed());
    }
   
    @Step
    public void wait_until_preview_is_loaded(){
        wait_until_element_is_loaded(page.preview);
    }
    
 
    
    @Step
    public void fill_min_price(String minPrice){
        page.minPriceInput.clear();
        page.minPriceInput.sendKeys(minPrice);
    }
    
    @Step
    public void fill_max_price(String minPrice){
        page.maxPriceInput.clear();
        page.maxPriceInput.sendKeys(minPrice);
    }
    
    
   
    
    @Step
    public void check_prices_in_teasers_preview(int minPrice, int maxPrice){
        List<WebElement> prices = page.previewBlock.findElements(By.className("ca-price"));
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
    public void check_teasers_count_in_blue_table(){
            Assert.assertTrue(page.getTeasersCountFromBlurTable()>2);
        }
    
    @Step
    public void scroll_to_preview_container(){
            scroll(page.previewContainer);
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
        return page.codeAreaXMLSmartBanners().getText();
    }
    }
