/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.pages.WemasterPages;

import cityads.ca_thucydides_new_design.pages.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author s.lugovskiy
 */
public class PricePlatformPage extends GoodsCatalogPage {

    public PricePlatformPage(WebDriver driver) {
        super(driver);
    }
    
    public WebElement getOfferLinkFromFirstCard(){
        //System.out.println(goodsCard.getAttribute("innerHTML"));
        return goodsCard.findElements(By.tagName("a")).get(2);
    }
    
    @FindBy(linkText="Создать инструмент")
    public WebElement createInstrumentLink;
    
    public WebElement getPopupSaveFilterInput(){
        return popup.findElement(By.tagName("input"));
    }

 
    
    
    
    
}
