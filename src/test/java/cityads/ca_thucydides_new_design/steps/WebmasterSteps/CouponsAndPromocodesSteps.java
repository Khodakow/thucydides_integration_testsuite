/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.steps.WebmasterSteps;

import cityads.ca_thucydides_new_design.pages.MainPage;
import cityads.ca_thucydides_new_design.pages.WemasterPages.BannerRotatorPage;
import cityads.ca_thucydides_new_design.pages.WemasterPages.CouponsAndPromocodesPage;
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
public class CouponsAndPromocodesSteps extends BannerRotatorSteps {

    MainPage mainPage;
    CouponsAndPromocodesPage page;
            
    public CouponsAndPromocodesSteps(Pages pages) {
        super(pages);
    }
    
    @Step
    public void check_filters_are_visible(){
        Assert.assertTrue(page.filters.isDisplayed());
    }
    
    @Step
    public void check_first_coupon_card(){
        Assert.assertTrue(page.couponCard.isDisplayed());
                
    }
    
    @Step
    public void check_first_coupon_img(){
        Assert.assertTrue(page.couponImg.isDisplayed());
                
    }
    
    @Step
    public String get_offer_name_from_coupon_card(){
        return page.getFirstCouponOfferName();
        
    }
    
    
        @Step
    public String get_goods_name_from_goods_card(){
        return page.getFirstGoodOfferName();
        
    }
    
    @Step
    public void click_offer_in_coupon_card(){
        get_webelement_with_jquery("$('.kupon-describer tr:eq(3) a').get(0);").click();
    }

    public void click_coupons_link() {
        page.couponsLink.click();
    }
    
   
   
   
    
    
}
