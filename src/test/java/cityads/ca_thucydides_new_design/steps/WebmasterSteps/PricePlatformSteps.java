/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.steps.WebmasterSteps;

import cityads.ca_thucydides_new_design.pages.WemasterPages.GoodsCatalogPage;
import cityads.ca_thucydides_new_design.pages.WemasterPages.PricePlatformPage;
import cityads.ca_thucydides_new_design.steps.SetupSteps;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 *
 * @author s.lugovskiy
 */
public class PricePlatformSteps extends GoodsCatalogSteps {
    PricePlatformPage page;
        
    public PricePlatformSteps(Pages pages) {
        super(pages);
    }

    @Step
    public String get_offer_link_name_in_first_coupon_card(){
           return page.getOfferLinkFromFirstCard().getText();
    }
    
    @Step
    public WebElement get_offer_link_in_first_coupon_card(){
        return page.getOfferLinkFromFirstCard();
    }
    
    @Step
    public void click_offer_link_in_first_coupon(String name){
       page.goodsCard.findElement(By.linkText(name)).click();
    }
    
    @Step
    public void click_create_instrument(){
        page.createInstrumentLink.click();
    }
    
    @Step
    public void fill_filter_name_in_popup(String name){
        page.getPopupSaveFilterInput().sendKeys(name);
    }
    


   
   
    
}
