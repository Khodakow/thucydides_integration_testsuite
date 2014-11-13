package cityads.ca_thucydides_new_design.pages.WemasterPages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class FinancialFeedPage extends BannerRotatorPage {
       
	
	public FinancialFeedPage(WebDriver driver) {
		super(driver);
	}
      
        @FindBy(className="finance_feed_menu_text")
        public WebElement financialFeedTab;
        
        public int get_financial_feed_tabs_count()        {
            return getDriver().findElements(By.className("finance_feed_menu_text")).size();
        }
        
        @FindBy(xpath="//td[contains(concat(' ', normalize-space(@class), ' '), 'finance_feed_menu_text') and text()='          Кредиты      ']")
        public WebElement feedCreditsTab;
        
        @FindBy(xpath="//td[contains(concat(' ', normalize-space(@class), ' '), 'finance_feed_menu_text') and text()='          Займы      ']")
        public WebElement feedLoansTab;
        
        @FindBy(xpath="//td[contains(concat(' ', normalize-space(@class), ' '), 'finance_feed_menu_text_selected') and text()='          Кредитные карты      ']")
        public WebElement feedCardsTab;
        
        @FindBy(xpath="//form/div[1]/div[2]/div[2]/div/textarea")
        public WebElement feedCodeAreaJS;
        
        @FindBy(xpath="//form/div[1]/div[2]/div[1]/div/textarea")
        public WebElement feedCodeAreaXML;

   

    public WebElement codeAreaXMLSmartBanners() {
        return getDriver().findElements(By.tagName("textarea")).get(0);
    }

    public WebElement getSmartBannerJsCode() {
        return getDriver().findElements(By.tagName("textarea")).get(1);
    }
    }





