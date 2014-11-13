package cityads.ca_thucydides_new_design.pages.WemasterPages;

import cityads.ca_thucydides_new_design.pages.*;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class RegistrationPage extends MainPage {
       
	
	public RegistrationPage(WebDriver driver) {
		super(driver);
	}
        

        @FindBy(xpath="//a[@class='wm-text']")
        public WebElement startWorkLink;
        
        @FindBy(id="menuId403259223")
        public WebElement startWorkButton;
        
        @FindBy(className="form")
        public WebElement regForm;
        
        @FindBy(id="id_el_text_field_email")
        public WebElement regEmail;
        
        @FindBy(id="id_el_password_field_pwd")
        public WebElement regPassword;
                
        @FindBy(xpath="(//a[contains(@href,lostpass) and @class='with-hover-underline float-right lost-pass'])[2]")
        public WebElement forgotPasswordLink;
        
        
        @FindBy(id="id_el_password_field_cpasswd")
        public WebElement regPasswordConfirm;
                               
        @FindBy(id="id_el_text_field_fname")
        public WebElement regName;
                                        
        @FindBy(id="id_el_text_field_icq")
        public WebElement regICQ;
                                                
        @FindBy(id="id_el_text_field_skype")
        public WebElement regSkype;
                                                        
        @FindBy(id="id_el_text_field_contact_phone")
        public WebElement regPhone;
        
        @FindBy(xpath="//p[contains(concat(' ', @class, ' '), ' checkbox ')]")
        public WebElement agreeCheckbox;
        
        public WebElement getAgreeCheckbox(){
            return element(agreeCheckbox).findElement(By.xpath("//input[contains(concat(' ', @id, ' '), 'agreement')]"));
        }
        
        @FindBy(className="socials")
        public WebElement socialButtons;
        
        @FindBy(className="error-container")
        public WebElement errors;
        
        public String getErrorText(){
           return element(errors).getText();
        }
       
        
        @FindBy(id="inboxfield")
        public WebElement tempMailInput;
        
        public WebElement getTempMailSubmitButton(){
            return getDriver().findElement(By.xpath("//btn[@class='btn btn-success']"));
        }
        
        @FindBy(xpath="//div[contains(text(),'SUPPORT Cityads')]")
        public WebElement cityadsLetterSubject;    
        
        @FindBy(xpath="//a[@title='Подтверждение регистрации']")
        public WebElement activationLink;
        
        
        
        
        @FindBy(xpath="//div[@class='border-block auth-block relative']")
        public WebElement activationMessageBlock;

        @FindBy(xpath="//*[@id='mailshowdivbody']/iframe")
        public WebElement mailinatorIframe;
        
        @FindBy(className="color-red")
        public WebElementFacade errorContainer;
        
        @FindBy(xpath="//a[@class='socials-vk']")
        public WebElement loginVkButton;
         
         @FindBy(name="email")
        public WebElement vkLoginInput;
         
        @FindBy(name="pass")
        public WebElement vkPasswordInput;
        
        
        
        @FindBy(xpath="//a[@class='socials-fb']")
        public WebElement loginFbButton;
        
        
         @FindBy(id="email")
        public WebElement FbLoginInput;
         
        @FindBy(id="pass")
        public WebElement FbPasswordInput;
        
        @FindBy(xpath="//a[@class='with-hover' and contains(@href,'advertisers')]")
        public WebElement advertiserCircle;
        
        @FindBy(xpath="//a[@class='with-hover' and contains(@href,'agents')]")
        public WebElement agentCircle;
        
        
    }





