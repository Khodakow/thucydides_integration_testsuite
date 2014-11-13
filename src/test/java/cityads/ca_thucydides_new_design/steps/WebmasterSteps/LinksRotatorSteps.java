/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.steps.WebmasterSteps;

import cityads.ca_thucydides_new_design.pages.MainPage;
import cityads.ca_thucydides_new_design.pages.WemasterPages.LinksRotatorPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import org.junit.Assert;
import org.openqa.selenium.By;

/**
 *
 * @author s.lugovskiy
 */
public class LinksRotatorSteps extends BannerRotatorSteps {

    MainPage mainPage;
    LinksRotatorPage page;
            
    public LinksRotatorSteps(Pages pages) {
        super(pages);
    }
   
    @Step
    public void check_banner_type_checkboxes_are_visible(){
        Assert.assertTrue(page.allBannerTypeCheckbox.isDisplayed());
        Assert.assertTrue(page.flashBannerTypeCheckbox.isDisplayed());
        Assert.assertTrue(page.imgBannerTypeCheckbox.isDisplayed());
    }
    
    @Step
    public void click_img_type_banner_checkbox(){
        page.imgBannerTypeCheckbox.click();
    }

    @Step
    public void fill_max_banners_size(int maxBanners){
        page.linksRotatorMaxBannersInput.clear();
        page.linksRotatorMaxBannersInput.sendKeys(String.valueOf(maxBanners));
    }
    
    @Step
    public void fill_max_offers_size(int maxOffers){
        page.linksRotatorMaxOffersInput.clear();
        page.linksRotatorMaxOffersInput.sendKeys(String.valueOf(maxOffers));
    }
    
    @Step
    public void click_select_rotator_links_link(String name){
        getDriver().findElement(By.linkText(name)).click();
    }
    
    @Step
    public void check_subaccount_name_is_present_in_params_table(String name){
        Assert.assertEquals(name, page.linksRotatorParamsSubaccount.getText());
    }
    
    @Step
    public void check_maxoffers_is_present_in_params_table(int maxOffers){
        Assert.assertEquals(String.valueOf(maxOffers), page.linksRotatorMaxOffersParams.getText());
    }    

    @Step
    public void check_maxbanners_name_is_present_in_params_table(int maxBanners){
        Assert.assertEquals(String.valueOf(maxBanners), page.linksRotatorMaxBannersParams.getText());
    }
    
   @Step
   public int get_feed_count(){
       return page.get_feed_count_in_preview();
   }
   
   @Step
   public void check_feed_count_equals_offers_count(int feed_count, int offers_count){
       Assert.assertEquals(feed_count, offers_count);
       
   }
   
   @Step
   public String get_code(){
       return page.getCode();
   }
   
   @Step public void check_code(String code){
       Assert.assertTrue(code.contains("<script"));
       Assert.assertTrue(!code.isEmpty());
   }
   
   @Step
   public void check_xml_code(String code){
       Assert.assertTrue(code.contains("/get_xml/"));
   }
    
}
