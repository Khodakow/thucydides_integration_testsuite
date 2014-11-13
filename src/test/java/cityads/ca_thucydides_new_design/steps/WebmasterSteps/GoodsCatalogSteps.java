/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.steps.WebmasterSteps;

import cityads.ca_thucydides_new_design.pages.WemasterPages.GoodsCatalogPage;
import cityads.ca_thucydides_new_design.steps.SetupSteps;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author s.lugovskiy
 */
public class GoodsCatalogSteps extends CouponsAndPromocodesFilterSaveSteps {

    public GoodsCatalogSteps(Pages pages) {
        super(pages);
    }

    GoodsCatalogPage page;
    
        
    @Step
    public void check_goods_card_count(int minimumCount, int realCount){
        Assert.assertTrue(realCount>=minimumCount);
        
    }
    
    @Step
    public int get_goods_cards_count(){
        return page.getGoodsItemCardsCount();
    }
    
    @Step
    public void click_getcode_link(){
        page.getCodeLink.click();
    }
    
    @Step
    public void check_goods_catalog_popup_get_code_is_displayed(){
        page.goodsCatalogGetCodePopup.isDisplayed();
    }
    
    @Step
    public String get_popup_cityads_link(){
        String re1="(\\?)";	// Any Single Character 1
        String re2="(url)";	// Variable Name 1
        String re3="(=)";	// Any Single Character 2
        return page.getPopupCodeLink().getText().replaceAll(re1+re2+re3,"");
    }
    
    @Step
    public String get_deep_link(){
        String txt =  page.getCodeLink.getAttribute("href");
        String re1="((?:http|https)(?::\\/{2}[\\w]+)(?:[\\/|\\.]?)(?:[^\\s\"]*))";	// HTTP URL 1
        String href = "no url found";
            Pattern p = Pattern.compile(re1,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
            Matcher m = p.matcher(txt);
            if (m.find())
            {
            String httpurl1=m.group(1);
            href = httpurl1.replace("')", "");
            }
            return href;
            }
    

    @Step
    public void check_landing_url() {
        Assert.assertFalse(getDriver().getCurrentUrl().contains("cityads.ru"));
    }

    @Step
    public void scroll_to_coupon() {
        scroll(page.goodsCard);
    }
    
    @Step
    public void wait_for_goods_card_visible(int timeout) {
                WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
                wait.until(ExpectedConditions.visibilityOf(page.goodsCard));
    }
    
    @Step
    public void wait_for_apply_button_is_clickable(int timeout) {
                WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form/div[5]/div/div[1]/button")));
                
    }
    
    @Step
    public void wait_for_spinner(int timeout) {
        if(getDriver().getPageSource().contains("spinner-icon")){
                getDriver().manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
                WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
                wait.ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-icon")));
                getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);}
    }
   
    @Step
    public void click_all_closed_categories (){
            executeScript(" $('.level-2 > .float-left').each(function() {$( this ).click();});");
               
    }
}
