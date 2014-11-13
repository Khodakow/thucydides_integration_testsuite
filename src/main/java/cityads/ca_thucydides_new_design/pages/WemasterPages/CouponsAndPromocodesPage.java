package cityads.ca_thucydides_new_design.pages.WemasterPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CouponsAndPromocodesPage extends BannerRotatorPage {
    @FindBy(className = "_selected_filters")
    public WebElement filterBreadacRumbs;
    
       
	
	public CouponsAndPromocodesPage(WebDriver driver) {
		super(driver);
	}
 
       @FindBy(xpath="//div[contains(concat(' ', normalize-space(@class), ' '), ' table-card margin-top-small border-bottom overflow')]")
       public WebElement couponCard;                                              
       
       public WebElement getCouponCard(){
           return getDriver().findElement(By.className("table-card"));
       }
       
       @FindBy(xpath="//div[contains(concat(' ', normalize-space(@class), ' '), ' miniboxed img ')]")
       public WebElement couponImg;
       
       @FindBy(linkText="Купоны")
       public WebElement couponsLink;
       
       @FindBy(xpath="//div[@class='table-card margin-top-small border-bottom overflow']")
       public WebElement couponCardTable;
       
       public WebElement getCouponImg(){
           return getDriver().findElement(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '), ' miniboxed img ')]"));
       }
       
       @FindBy(xpath="//table/tbody/tr[4]/td[2]/a")
       public WebElement firstCouponCardOfferLink;
                        
       @FindBy(xpath="(//a[contains(@id,'id_el_lnk_name')])[1]")
       public WebElement firstGoodsCardOfferLink;
       
       @FindBy(xpath="(//a[contains(@id,'id_el_lnk_name')])[1]")
       public WebElement firstGoodsCardOfferIDLink;
       
       public String getFirstCouponOfferName(){
           String name = null;
           name = firstCouponCardOfferLink.getText();
           return name;
       }
       
       
       
           public String getFirstGoodOfferName(){
           String name = null;
           name = firstGoodsCardOfferLink.getText();
           return name;
       }
       
       public WebElement getFirstCouponOffer(){
            return couponCardTable.findElement(By.tagName("a"));
       }


       
       

}
