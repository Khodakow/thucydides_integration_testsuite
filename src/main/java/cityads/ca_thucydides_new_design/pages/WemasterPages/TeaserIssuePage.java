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


public class TeaserIssuePage extends BannerRotatorPage {
       
	
	public TeaserIssuePage(WebDriver driver) {
		super(driver);
	}
 
        @FindBy(xpath="//form/div[5]/div[2]/div/div/div")
        public WebElement teaserIssueCatSelectValue;
    
        @FindBy(className="orange_table")
        private WebElement teaserListTable;

        @FindBy(id="id_el_text_field_")
         public WebElement teaserIssueAge;
         
        @FindBy(className="ca-tizer")
        public WebElement teaser;
         
        @FindBy(id="id_el_text_field_filter_min_price")     
        public WebElement minPriceInput;
        
        @FindBy(id="id_el_text_field_filter_max_price")
        public WebElement maxPriceInput;
         
              
        public int getTeasersCountFromBlurTable(){
          return element(teaserListTable).findElements(By.tagName("tr")).size();   
        
        }

    public WebElement getSmartBannerAJsCode() {
        return getDriver().findElements(By.tagName("textarea")).get(1);
    }

    public WebElement getSmartBannerJsCode() {
        return getDriver().findElements(By.tagName("textarea")).get(2);
    }

    public WebElement codeAreaXMLSmartBanners() {
        return getDriver().findElements(By.tagName("textarea")).get(3);
    }
    
    

}
