package cityads.ca_thucydides_new_design.steps;

import cityads.ca_thucydides_new_design.pages.WemasterPages.RegistrationPage;
import junit.framework.Assert;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.concurrent.TimeUnit;

public class RegistrationSteps extends MainSiteSteps {
    
    RegistrationPage  page;
    
    public RegistrationSteps(Pages pages) {
        super(pages);
    }
   
    
   @Step
   public void fill_temp_mail(String mail) {
         page.tempMailInput.click();
         page.tempMailInput.clear();
         page.tempMailInput.sendKeys(mail);
         page.getTempMailSubmitButton().click();
         //Assert.assertTrue(getDriver().getPageSource().contains("Inbox for"));
    }
   
   @Step
   public void wait_for_activation_email(int timeout){
       FluentWait<WebDriver> wait = new FluentWait<WebDriver>(getDriver()).
                withTimeout(timeout, TimeUnit.SECONDS).
                pollingEvery(500, TimeUnit.MILLISECONDS).
                ignoring(NoSuchElementException.class); 

       //WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
        wait.until(ExpectedConditions.visibilityOf(page.cityadsLetterSubject));
        
   }
   
   @Step
   public void login_into_temp_mail(String mail){
            waitABit(5000);
         page.tempMailInput.sendKeys(mail);
         page.getTempMailSubmitButton().click();
         Assert.assertTrue(getDriver().getPageSource().contains("Inbox for"));
   }
   
   @Step
   public void open_activation_letter(){
       page.cityadsLetterSubject.click();
      
   }
   
   @Step
   public void click_activation_link(){
        String url = get_activation_link();
        open_url(url);
   }
   
   @Step
   public String get_activation_link(){
            String url = null;
            url = getDriver().findElement(By.xpath("/html/body/div/div/div/div/font/p[3]/a/font")).getText();
            return url;
        }
    
   @Step
   public void check_activation_complete(String mail){
       Assert.assertTrue(page.activationMessageBlock.getText().contains("была успешно активирована"));
       Assert.assertTrue(page.activationMessageBlock.getText().contains(mail));
   }
   
   @Step
   public void check_error_is_not_displayed(){
       Assert.assertFalse(page.errorContainer.isCurrentlyVisible());
   }
   
   
   @Step
   public void click_action_letter_title(){
       page.cityadsLetterSubject.click();
   }
   
   @Step
   public void switch_to_mailinator_iframe(){
       getDriver().switchTo().frame(page.mailinatorIframe);
   }
   
   @Step
    public void check_temp_mail_has_letter(String subject) {
        org.junit.Assert.assertTrue(page.find(By.xpath("//div[@class='content']")).getAttribute("innerHTML").contains(subject));
    }
   
   @Step
    public void click_start_button(){
        
        getDriver().findElement(By.className("register-now")).findElement(By.tagName("a")).click();
        
    }
    
    @Step
    public void fill_registration_form(String name, String ICQ, String phone, String skype, String password,String email ){

        page.regName.sendKeys(name);
        page.regPassword.sendKeys(password);
        page.regPasswordConfirm.sendKeys(password);
        page.regSkype.sendKeys(skype);
        page.regPhone.clear();
        page.regPhone.click();
        page.regPhone.sendKeys(phone);
        page.regEmail.sendKeys(email);
    }
    
    @Step
    public void click_agree_checkbox(){
        if(!page.agreeCheckbox.getAttribute("class").contains("checked")){
            page.getAgreeCheckbox().click();}
        if(!page.agreeCheckbox2.getAttribute("class").contains("checked")){
            page.getAgreeCheckbox2().click();}
    }

    @Step
    public void click_forgot_password_link(){
        page.forgotPasswordLink.click();
    }
    
    @Step
    public void check_registration_form_is_displayed() {
        Assert.assertTrue(page.regForm.isDisplayed());
    }

    @Step
    public void check_url_has_success1() {
        Assert.assertTrue(getDriver().getCurrentUrl().contains("webmasters?success=1"));
    }
    
    @Step
    public void check_page_has_success() {
        Assert.assertTrue(getDriver().getPageSource().contains("webmasters?success=1"));
    }
    
    @Step
    public void check_success_message_is_displayed(){
        Assert.assertTrue(getDriver().getPageSource().contains("Регистрация прошла успешно. На указанный Вами e-mail отправлено письмо с информацией по активации аккаунта."));
    }
    
    @Step
    public void check_error_is_present(){
        scroll(page.errors);
        Assert.assertTrue(page.errors.isDisplayed());
    }
    
       
    @Step
    public void click_search_button(){
        page.searchButton.click();
    }
    
    
       @Step
   public void click_vk_link(){
        page.loginVkButton.click();
   }
    
           @Step
   public void click_fb_link(){
        page.loginFbButton.click();
   }
    
           
   @Step
   public String get_wm_name_vk(){
              String wm_name_vk = System.getProperty("userVk");  
              return wm_name_vk;
}

      @Step
   public String get_wm_name_fb(){
              String wm_name_fb = System.getProperty("userFb");  
              return wm_name_fb;
}
   
   
   @Step     
   public void fill_vk_form (String login , String password) {
              page.vkLoginInput.sendKeys(login);
              page.vkPasswordInput.sendKeys(password);
   } 
   
   
     @Step     
   public void fill_fb_form (String login , String password) {
              page.FbLoginInput.sendKeys(login);
              page.FbPasswordInput.sendKeys(password);
   }
           
   @Step
   public void click_submit_vk(){        
         page.find(By.id("install_allow")).click();
   }
   
   @Step
   public void click_submit_fb(){        
         page.find(By.name("login")).click();
   }
   public String get_wm_vk_password (){
           String wm_pass_vk = System.getProperty("passwordVk");  
              return wm_pass_vk;
   }
   public String get_wm_fb_password (){
           String wm_pass_fb = System.getProperty("passwordFb");  
              return wm_pass_fb;
   }
   @Step
   public void click_submit_confirm_fb(){        
         page.find(By.name("__CONFIRM__")).click();
   }

    @Step
    public void ckick_start_work() {
        page.startWorkLink.click();
    }

    @Step
    public void click_advertiser_circle() {
        page.advertiserCircle.click();
    }
    
    @Step
    public void click_agent_circle() {
        page.agentCircle.click();
        this.waitABit(5000);
    }

    @Step
    public void check_reg_form_displayed() {
        mainPage.submitOk.shouldBeCurrentlyVisible();
    }
}