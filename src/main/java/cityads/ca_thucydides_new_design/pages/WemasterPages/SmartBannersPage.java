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
import com.google.common.base.Function;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;


public class SmartBannersPage extends TeaserIssuePage {
       
	
	public SmartBannersPage(WebDriver driver) {
		super(driver);
	}
 
        @FindBy(className="ca-block")      
        public WebElement smartBannerPreview;
        
        public int getCountSmartBannersInPreview(){
            return smartBannerPreview.findElements(By.className("ca-relative")).size();
        }
        
        public WebElement getSmartBannersBlockPreview(){
            return smartBannerPreview;
        }
        
        public WebElement getSingleSmartBannerPreview(int i){
           return getSmartBannersBlockPreview().findElements(By.className("ca-relative")).get(i);
        }

                
        @FindBy(xpath="//div[2]/div/textarea")
        public WebElement codeAreaJSSmartBanners;
        
        @FindBy(xpath="//div/textarea")
        public WebElement codeAreaAJSSmartBanners;
        
        @FindBy(xpath="//div[3]/div/textarea")
        public WebElement codeAreaXMLSmartBanners;
        
        public WebElement getSmartBannerJsCode(){
            return getDriver().findElements(By.tagName("textarea")).get(2);
        }
        
        public WebElement getSmartBannerAJsCode(){
            return getDriver().findElements(By.tagName("textarea")).get(1);
        }
}