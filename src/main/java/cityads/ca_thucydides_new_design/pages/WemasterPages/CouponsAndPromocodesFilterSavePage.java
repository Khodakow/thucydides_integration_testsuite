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


public class CouponsAndPromocodesFilterSavePage extends CouponsAndPromocodesPage {
      
	
	public CouponsAndPromocodesFilterSavePage(WebDriver driver) {
		super(driver);
	}

     
        public WebElement getSaveLittleButton(){
            return getDriver().findElements(By.className("text-right")).get(2);
        }
}
