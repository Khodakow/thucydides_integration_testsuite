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
import java.awt.AWTException;
import java.awt.Robot;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;


public class ExchangePage extends MainPage {
       
	
	public ExchangePage(WebDriver driver) {
		super(driver);
	}
        
        @FindBy(xpath="//div[contains(concat(' ', normalize-space(@class), ' '), ' tabs _ajax_tabs _tab inline-block ') ]")
        public WebElement wmExchangeTabs;
        
        @FindBy(id="pager_go_next")
        public WebElement next_page;
             
         }
    








