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


public class NewsPage extends MainPage {
       
	
	public NewsPage(WebDriver driver) {
		super(driver);
	}
        
 
 
        
        public int get_news_count(){
            int newsCount;
            newsCount = getDriver().findElements(By.className("caption")).size();
            return newsCount;
        }
        
        @FindBy(xpath="//form/div/div[1]")
        public WebElement newsSelectContainer;
        
        //
        @FindBy(xpath="//a[contains(concat(' ', normalize-space(@class), ' '), ' col-evil underline-h size-14 ') ]")
        public WebElement firstNewsLink;
        
        @FindBy(xpath="//article/p[4]/strong[1]/a")
        public WebElement newsFirstNewsTitleLink;
        
        

    }





