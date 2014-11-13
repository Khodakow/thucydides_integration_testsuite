package cityads.ca_thucydides_new_design.pages.WemasterPages;


import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class ConversionPostbackPage extends BannerRotatorPage {
               
	
	public ConversionPostbackPage(WebDriver driver) {
		super(driver);
	}
        
        
        
        @FindBy(xpath="//label[@for='request_type_1']")
        public WebElement getCheckbox;
        
        @FindBy(id="id_el_text_field_url_text")
        public WebElement postbackUrl;
        
        @FindBy(id="postback_save_button")
        public WebElement savePostbackButton;
        
        public WebElementFacade getSaveConversionButton(){
            return element(getDriver().findElements(By.xpath("//a[@class='button dark ']")).get(0));
        }
        
        @FindBy(tagName="table")
        public WebElement postbackTable;
        
        //pointer _preview_open
        @FindBy(xpath="//img[contains(concat(' ', normalize-space(@class), ' '), 'pointer _preview_open') ]")
        public WebElement postbackPreviewIcon;
        
        public WebElement getCopyCodeButton(){
            return getDriver().findElement(By.xpath("//a[contains(concat(' ', normalize-space(@class), ' '), 'button dark submit _copy_button') ]"));
        }
    }





