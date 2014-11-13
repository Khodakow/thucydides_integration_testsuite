package cityads.ca_thucydides_new_design.pages.WemasterPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class DownloadsPage extends CouponsAndPromocodesFilterSavePage {
      
	
	public DownloadsPage(WebDriver driver) {
		super(driver);
	}

        public void clickOfferCheckboxInFilter(String offerName){
            getDriver().findElement(By.xpath("//div[contains(text(),'"+offerName+"')]/..")).click();
        }
        
        @FindBy(xpath="//div[@class='_selected_filters _hasFilters']")
        public WebElement filterRusultBlock;
        
        @FindBy(xpath="//a[@class='_no_ajax' and @target='_blank' and contains(@id,'name')]")
        public List <WebElement> goodsOffersName;
        
        @FindBy(xpath="//a[@class='col-blue']")
        public List <WebElement> couponsOffersName;
        
        @FindBy(xpath="//input[]@class='dark _title'")
        public WebElement popupFilternameInput;
        
        public WebElement getPopupFilternameInput(){
            return popup.findElement(By.xpath("//input[@class='dark _title']"));
        }
        //getPopupFilterSaveButton
        public WebElement getPopupFilterSaveButton(){
            return popup.findElement(By.xpath("//a[@class='button dark submit _submit']"));
        }
        
        @FindBy(xpath="//div[@class='select _user_filter_select _select']")
        public WebElement filterTemplateSelector;

        @FindBy(id="_left_menu_id_417499392")
        public WebElement downloadsLink;
        
        @FindBy(id="_left_menu_id_3641948")
        public WebElement downloadsCouponsLink;
        
        @FindBy(id="_left_menu_id_417519392")
        public WebElement downloadsGoodsLink;
        
        @FindBy(xpath="//form/div[4]/div[5]/div/div[1]/div[2]/div/div[1]/div[2]/label")
        public WebElement firstOfferInFilterCoupons;
        
        @FindBy(xpath="//*[contains(@class, 'button submit create no-right')]")
        public WebElement couponsCreateToolButton;
        
        @FindBy(xpath="//*[contains(@class,'button submit create no-right')]")
        public WebElement goodsCreateToolButton;
        
        
        @FindBy(xpath="//div[@class='select-value pointer']")
        public WebElement couponsCreateFeedFilterValue;
        
        @FindBy(xpath="//a[@class='button dark submit _copy_button']")
        public WebElement couponsFeedCodeValue;
        
        
        
        @FindBy(xpath="/html/body/div[3]/div[3]/div/div[2]/div/div[4]/div[1]/div[3]/div/div[2]/div[1]/div[1]/div[3]/a[1]")
        public WebElement couponsSortByDescButton;
        
        @FindBy(xpath="//input[contains(@class,'dark')]")
        public WebElement couponsfilterPopupOffersInput;
                       
        @FindBy(xpath="//div[4]/div/div[2]/label")
        public WebElement couponsSecondCheckboxInOffersPopup;
        
         @FindBy(xpath="//a[@class='button dark  submit']")
        public WebElement couponsfilterPopupOffersSubmit;
         
        @FindBy(id="id_el_input_filter_reset")
        public WebElement couponsfilterPopupOffersReset;
        
        public WebElement getCouponsSecondCheckboxInOffersPopup(){
            System.out.println("==============>"+popup.findElements(By.tagName("label")).get(0).getAttribute("innerHTML"));
            return popup.findElements(By.tagName("label")).get(0);
            
        }
        
        @FindBy(partialLinkText="JSON")
        public WebElement couponsPopupChooseformatJson;
        
        @FindBy(xpath="//a[@class='button dark submit _copy_button']")
        public WebElement couponsPopupCopyCodeButton;


        public void clickOfferCheckboxInPopup(String id) {
            getDriver().findElement(By.xpath("//input[@at-id='"+id+"']")).click();
        }
        
        @FindBy(xpath="//input[@class='dark width-100 _name']")
        private WebElement downloadPopupInputName;

        @FindBy(xpath="//input[@placeholder='dark width-100']")
        private WebElement downloadPopupInputSubaccount;
  
        @FindBy(xpath="//a[@class='button dark  submit']")
        private WebElement downloadPopupSaveButton;
        
        public void fillDownloadPopupForm(String name,String filterName){
            downloadPopupInputName.sendKeys(name);
            popup.findElement(By.className("select-choose")).click();
            this.find(By.linkText(filterName)).click();
            downloadPopupSaveButton.click();
        }
            
            
        
}
