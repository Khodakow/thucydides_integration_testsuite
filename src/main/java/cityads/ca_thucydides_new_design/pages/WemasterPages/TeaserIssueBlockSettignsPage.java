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


public class TeaserIssueBlockSettignsPage extends TeaserIssuePage {
       
	
	public TeaserIssueBlockSettignsPage(WebDriver driver) {
		super(driver);
	}
 
        @FindBy(partialLinkText="Настройки блока")
        public WebElement teaserIssueBlockSettings;
        
        @FindBy(xpath="//*[@id=\"editor_block\"]/div/div[1]/div[2]/div[1]/div[2]/div[1]/input")
        public WebElement teaserIssueBlockNumberHorizontal;
        
        @FindBy(xpath="//*[@id=\"editor_block\"]/div/div[1]/div[2]/div[2]/div[2]/div[1]/input")
        public WebElement teaserIssueBlockNumberVertical;
        
        public int getTeasersCountInPreview(){
            int count = 0;
            count = previewBlock.findElements(By.className("ca-tizer-wrapper")).size();
            return count;
        }
        
        @FindBy(xpath="//*[@id=\"editor_block\"]/div/div[3]/div[2]/div[1]/div[2]/label/input")
        public WebElement backrountdColorInput;
        
        @FindBy(xpath="//*[@id=\"editor_block\"]/div/div[3]/div[2]/div[2]/div[2]/label/input")
        public WebElement backgroundColorOnhoverInput;
       

}
