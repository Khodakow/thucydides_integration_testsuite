/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.pages.WemasterPages;

import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 *
 * @author s.lugovskiy
 */
public class GoodsCatalogPage extends CouponsAndPromocodesFilterSavePage {

    public GoodsCatalogPage(WebDriver driver) {
        super(driver);
    }
    
    @FindBy(className="table-card")
    public WebElement goodsCard;
    
    @FindBy(linkText="Получить код")
    public WebElement getCodeLink;
    
    public int getGoodsItemCardsCount(){
         return getDriver().findElements(By.className("table-card")).size();
    }
    
    @FindBy(xpath="//div[contains(concat(' ', normalize-space(@class), ' '), 'popup modal') ]")
    public WebElement goodsCatalogGetCodePopup;
    
    public WebElement getPopupCodeLink(){
        return goodsCatalogGetCodePopup.findElement(By.tagName("textarea"));
    }
    
    public WebElement getPopupDeepLink(){
        return goodsCatalogGetCodePopup.findElements(By.tagName("input")).get(1);
    }
    

    public List<WebElementFacade> getAllClosedCategories(){
        List<WebElementFacade> list;
        list = this.findAll(By.xpath("//div   [      contains(@class,'item level-')  and not(contains(@class,'opened'))   and not(contains(@class, 'empty'))  and not(contains(@class, 'margin-top'))  ]/div[@class='float-left']"));
        return list;
    }
    
}
