package cityads.ca_thucydides_new_design.steps;

import cityads.ca_thucydides_new_design.pages.WemasterPages.ProfilePage;
import cityads.ca_thucydides_new_design.pages.WemasterPages.WelcomePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;
public class WelcomeSteps extends BaseSteps {

 
    WelcomePage wp;
    ProfilePage pp;

    public WelcomeSteps(Pages pages) {
        super(pages);
  
        
    }
   
    
    //welcome page================================================
    @StepGroup
    public String fill_welcome_page_new(){
                String trafficCountry;
        
                wait_for_map(30);
                waitAjax(8000);
                click_dalee_welcome_page_1();
                wait_for_map(30);
                
                
                click_office_dropdown_arrow();
                click_city("Сан-Паулу, Бразилия");
                //select_moscow_timezone();
        
                try {           Thread.sleep(7000);        } catch (InterruptedException ex) {        }
                trafficCountry =  click_first_unchecked_checkbox();
               
                waitAjax(2000);
                click_dalee_welcome_page_2();
                wait_for_map(30);
                
                //click_welcome_page_agree_checkbox();
                //click_BLR_currency();
                wait_for_map(30);
                waitAjax(2000);
                click_dalee_welcome_page_3();
 
                waitABit(8000);
                return trafficCountry;
      }
    
    
    @Step
    @Override
    public void click_dalee_welcome_page_1(){
        wp.getFirstPageDaleeButton().click();
    }
    
    @Step
    @Override
    public void click_english(){
       wp.getFirstLang().click();
    }
    
    @Step
    @Override
    public void click_dalee_welcome_page_2(){
        wp.getSecondPageDaleeButton().click();
    }
    
    
    
    @Step
    @Override
    public void click_dalee_welcome_page_3(){
        wp.getThirdPageDaleeButton().click();
    }
   
    @Step
    public void wait_for_map(int timeout){
        WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
        wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.className("_map"))));
    }
    
    @Step
    public void fluent_wait_for_map(int timeout){
        WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
        wait.ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.className("_map"))));


    }
    
    @Step
    @Override
    public void wm_login(String wmName) {
       
        boolean check;
        open_main_page();
        check = getDriver().getPageSource().contains("Личный кабинет");
        
        if(check)
        {
            click_login_button();
            waitAjax(2000);
        }
        
        else
        {
            click_login_button();
            enter_login(wmName);
            enter_password();
            click_enter_button();
            waitAjax(2000);
        }
        fill_welcome_page();
        

        
    }
    
    @Step
    @Override
    public void enter_password() {
        mainPage.passwordField.sendKeys(get_wm_password_for_welcome_page());
    }
    
    @Step
    public String get_wm_name_for_welcome_page(){
              String wm_name = System.getProperty("userWelcome");  
              return wm_name;
}
   @Step
    public String get_wm_password_for_welcome_page(){
        return System.getProperty("passwordWelcome");
    }
   
   @Step
   public void click_office_dropdown_arrow(){
        wp.find(By.className("_office_select")).find(By.className("select-choose")).click();
   }
   
   @Step
   public void click_city(String city){ //"Сан-Паулу, Бразилия"
       getDriver().findElement(By.xpath("//a[@data-id='3']")).click();
   }
   
   @Step
   public void click_ru_lang(){
       wp.welcomeRuLang.click();
   }
 //xpath=(//input[@type='text'])
   @Step
    public void select_moscow_timezone() {
        getDriver().findElement(By.xpath("//div[6]/div/div/div[2]/div/div")).click();
        try {           Thread.sleep(2000);      } catch (InterruptedException ex) {            }
        getDriver().findElement(By.xpath("(//input[@type='text'])[3]")).clear();
        getDriver().findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("moscow");
        getDriver().findElement(By.xpath("//div[344]")).click();
    }

    @Step
    public String click_first_unchecked_checkbox() {
        String country = wp.getFirstUncheckedCheckbox().getText();
        wp.getFirstUncheckedCheckbox().click();
        return country;
        
    }
   
  
    @Step
    public void click_BLR_currency(){
        getDriver().findElement(By.xpath("//div[@value='7']")).click();
    }

    @Step
    public void check_timezone_has_value(String timezone) {
       Assert.assertTrue(pp.profileTimeZone.getText().contains(timezone));
    }

    @Step
    public void check_traffic_coutry_shown_in_filter_result(String trafficCOuntry) {
        Assert.assertTrue(wp.filterRusultBlock.getAttribute("innerHTML").contains(trafficCOuntry));
    }
    
    @Step
    public void check_welcome_page_translate() {
        WebElement elem = wp.popup.findElement(By.xpath("//*"));
        List<String> strings = Arrays.asList(elem.getText().split(" "));
        for (String elemnt:strings){
        if(!elemnt.contains("Русский")){   //если это не название языка
            check_strng_for_rus(elemnt);
           }
        }
        
    }
    

   
    
 
}

    
    
    
    
