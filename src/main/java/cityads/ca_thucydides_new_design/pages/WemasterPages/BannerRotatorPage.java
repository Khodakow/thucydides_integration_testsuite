package cityads.ca_thucydides_new_design.pages.WemasterPages;

import cityads.ca_thucydides_new_design.pages.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class BannerRotatorPage extends MainPage {
       
	
	public BannerRotatorPage(WebDriver driver) {
		super(driver);
	}
        
        @FindBy(xpath="//label[@for='banner_type_1']")
        public WebElement bannerRotatorPromoTypeAll;
        
        @FindBy(xpath="//label[@for='banner_type_2']")
        public WebElement bannerRotatorImageType;
        
        @FindBy(xpath="//label[@for='banner_type_3']")
        public WebElement bannerRotatorFlashType;
        
     
        
        @FindBy(className="popup-click-list")
        public WebElement bannerRotatorPopupListButton;
        
        @FindBy(xpath="//*[@id=\"actions_column\"]/div[1]/a")
        public WebElement bannerRotatorPopupSizeListButton;
        
        
        @FindBy(id="reload_button")
        public WebElement bannerRotatorUpdateButton;
        
        @FindBy(xpath="//textarea")
        public WebElement codeAreaJS;
        
        @FindBy(xpath="//textarea")
        public WebElement codeAreaAJS;
        
        @FindBy(xpath="//textarea")
        public WebElement codeAreaXML;
        
        public String getOffersFromMultiselect()        {
            return getDriver().findElement(By.xpath("(//div[@class='chzn-container chzn-container-multi _select_name'])[2]")).getText();
        }
        
        @FindBy(xpath="//table/tbody/tr[4]/td[2]/a")
        public WebElement offerLinkInRotatorParams;
        
       @FindBy(id="go_to_overview")
       public WebElement bannerParamsGoToOverwiew;
        
    }





