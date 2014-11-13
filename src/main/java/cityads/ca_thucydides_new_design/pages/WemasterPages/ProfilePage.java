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
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.support.ui.Select;


public class ProfilePage extends MainPage {
       
	
	public ProfilePage(WebDriver driver) {
		super(driver);
	}
        
 
        @FindBy(linkText="Профиль")
        public WebElement profileLink;
        
        @FindBy(id="id_el_text_field_fname")
        public WebElement profileName;
        
        @FindBy(id="id_el_text_field_nick_for_top")
        public WebElement profileTop20Nick;
        
        @FindBy(id="id_el_text_field_contact_phone")
        public WebElement profilePhone;
        
        @FindBy(id="id_el_text_field_skype")
        public WebElement profileSkype;
        
        @FindBy(xpath="//*[@id=\"tr_icq\"]/div[2]/input")
        public WebElement profileICQ;
        
        @FindBy(xpath="//form/div/div[6]/div[2]/input")
        public WebElement profileICQInput;
        
        @FindBy(linkText="Платежная информация")
        public WebElement profileBillingTab;
        
        @FindBy(id="id_el_text_field_name")
        public WebElement profileCurrencyName;
        
        @FindBy(xpath="id_el_text_field_value")
        public WebElement profileBillingCountNumber;
        
        @FindBy(id="currency_id_wm")
        private WebElement currencySelect;

        @FindBy(xpath="//*[@id=\"tr_currency_id_wm\"]/div[2]/div/div/div[2]")
        public WebElement profileCurrencySelectButton;
 
        @FindBy(xpath="//*[@id=\"tr_account_type_id\"]/div[2]/div/div/div[1]")
        public WebElement profileWMZSelectButton;
        
        @FindBy(xpath="//a[@data-id='4']")
        public WebElement profileWMZlink;
        
        public WebElement newsFirstNewsTitleLink;
        
        @FindBy(linkText="Настройка уведомлений")
        public WebElement profileTab3Link;
                
        @FindBy(id="chk1")
        public WebElement profileNewsCheckbox;
        
        @FindBy(id="chk2")
        public WebElement profileNewProductsCheckbox;
        
        @FindBy(id="chk3")
        public WebElement backToWorkCheckbox;
        
        @FindBy(id="chk4")
        public WebElement uluchshenieUslovijCheckbox;
        
        @FindBy(id="chk5")
        public WebElement izmenenieUslovijCheckbox;
        
        @FindBy(id="chk3")
        public WebElement noviematerialiCheckbox;
        
        @FindBy(id="chk6")
        public WebElement akciiCheckbox;
        
        public void click_all_checkboxes(){
              chbx1.click();
              chbx2.click();
              chbx3.click();
              chbx4.click();
              chbx5.click();
              chbx6.click();
              chbx7.click();
              
              
              
        }
        
        @FindBy(xpath="//form/div/div[1]/div[1]/label")
        public WebElement chbx1;
        
        @FindBy(xpath="//form/div/div[1]/div[2]/label")
        public WebElement chbx2;
        
        @FindBy(xpath="//form/div/div[1]/div[3]/label")
        public WebElement chbx3;
        
        @FindBy(xpath="//form/div/div[2]/div[1]/label")
        public WebElement chbx4;
        
        @FindBy(xpath="//form/div/div[2]/div[2]/label")
        public WebElement chbx5;
        
        @FindBy(xpath="//form/div/div[2]/div[3]/label")
        public WebElement chbx6;
        
        @FindBy(xpath="//form/div/div[3]/div/label")
        public WebElement chbx7;

        
        @FindBy(className="button")
        public WebElement submitProfile;
        
        public void clickThirdSubmitProfileButton(){
            getDriver().findElements(By.id("submit_ok")).get(1).click();
        }
        
        public void wait_to_tab_load(){
            element(profileName).waitUntilVisible();
        }
        
        @FindBy(xpath="//*[@id=\"tr_contact_phone\"]/div[2]")
        public WebElement wmProfilePhoneDiv;
        
        @FindBy(xpath="/html/body/div[3]/div[3]/div/div[2]/div[2]/div[4]/div/div[2]")
        public WebElement profileTab2ContentDiv;

    public WebElement getCountField() {
        return getDriver().findElement(By.id("profile_form_2")).findElements(By.tagName("input")).get(1);
    }
    
    public String getCountFieldValue() {
        return getDriver().findElement(By.id("profile_form_2")).findElement(By.id("id_el_text_field_value")).getAttribute("value");
    }
    

    @FindBy(xpath="//*[@id=\"tr_time_zone\"]/div[2]/div/div")
    public WebElement profileTimeZone;

}



