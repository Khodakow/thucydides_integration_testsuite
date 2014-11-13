/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.pages.WemasterPages;

import cityads.ca_thucydides_new_design.pages.MainPage;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author s.lugovskiy
 */
public class GoodsCategoryPage extends GoodsCatalogPage {

    public GoodsCategoryPage(WebDriver driver) {
        super(driver);
    }
    
    public int getCategoriesItemsCount(){        try {

        Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(GoodsCategoryPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return getDriver().findElements(By.xpath("//div[contains(@class,'margin-bottom-micro')]")).size();
    }
    

    
}
