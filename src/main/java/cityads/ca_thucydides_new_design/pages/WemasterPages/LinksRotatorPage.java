package cityads.ca_thucydides_new_design.pages.WemasterPages;

import cityads.ca_thucydides_new_design.pages.*;
import ch.lambdaj.function.convert.Converter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import net.thucydides.core.pages.PageObject;

import java.util.List;

import static ch.lambdaj.Lambda.convert;
import java.awt.AWTException;
import java.awt.Robot;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;


public class LinksRotatorPage extends MainPage {
       
	
	public LinksRotatorPage(WebDriver driver) {
		super(driver);
	}
         
        @FindBy(xpath="//label[contains(concat(' ', normalize-space(@for), ' '), ' banner_type_1 ')]")
        public WebElement allBannerTypeCheckbox;
        
        @FindBy(xpath="//label[contains(concat(' ', normalize-space(@for), ' '), ' banner_type_3 ')]")
        public WebElement flashBannerTypeCheckbox;
        
        @FindBy(xpath="//label[contains(concat(' ', normalize-space(@for), ' '), ' banner_type_2 ')]")
        public WebElement imgBannerTypeCheckbox;
        
        @FindBy(id="id_el_text_field_max_offers")
        public WebElement linksRotatorMaxOffersInput;
        
        @FindBy(id="id_el_text_field_max_banners")
        public WebElement linksRotatorMaxBannersInput;
                        
        @FindBy(xpath="//tr[4]/td[2]")
        public WebElement linksRotatorParamsSubaccount;
        
        @FindBy(xpath="//tr[5]/td[2]")
        public WebElement linksRotatorMaxOffersParams;
        
        @FindBy(xpath="//tr[6]/td[2]")
        public WebElement linksRotatorMaxBannersParams;
        
        @FindBy(xpath="//div[contains(concat(' ', normalize-space(@class), ' '), 'feedItem')]")
        public WebElement linksRotatorFeedItemPreview;
        
        @FindBy(id="mainFeedDiv")
        private WebElement mainFeedDiv;
        
        public int get_feed_count_in_preview(){
            int size = element(mainFeedDiv).findElements(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '), 'feedItem')]")).size();
            return size;
        }
        
        @FindBy(xpath="//div[contains(concat(' ', normalize-space(@class), ' '), 'relative')]")
        private WebElement getCodePopupWindow;
        
        public String getCode(){
            return getDriver().findElement(By.linkText("Скопировать")).getAttribute("data-clipboard-text");
        }
        
    }





