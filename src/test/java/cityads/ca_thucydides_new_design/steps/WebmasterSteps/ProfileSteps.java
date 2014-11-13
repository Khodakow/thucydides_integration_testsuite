/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.steps.WebmasterSteps;

import cityads.ca_thucydides_new_design.pages.WemasterPages.ProfilePage;
import cityads.ca_thucydides_new_design.steps.SetupSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author s.lugovskiy
 */
public class ProfileSteps extends SetupSteps {

    ProfilePage page;
    
    public ProfileSteps(Pages pages) {
        super(pages);
    }
    
    @Step
    public void click_profile_billing_tab(){
        page.profileBillingTab.click();
    }
    
    @Step 
    public void fill_wm_profile_name(String name){
        wait_for_tab1_load();
        page.profileName.click();
        page.profileName.clear();
        page.profileName.sendKeys(name);
    }
    
    @Step
    public void click_profile_link_boy(){
        getDriver().findElement(By.id("_left_menu_id_3641921")).click();
        
        getDriver().findElement(By.id("_left_menu_id_403699272")).click();
        
    };
    
    @Step 
    public void fill_wm_profile_top20(String top20){
        page.profileTop20Nick.click();
        page.profileTop20Nick.clear();
        page.profileTop20Nick.sendKeys(top20);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ProfileSteps.class.getName()).log(Level.SEVERE, null, ex);
        }
        page.profileTop20Nick.click();
    }
    
    @Step 
    public void fill_wm_profile_phone(String phone){

        page.profilePhone.click();
        page.profilePhone.sendKeys(phone);

        
    }
    
    @Step 
    public void fill_wm_profile_skype(String skype){
        page.profileSkype.click();
        page.profileSkype.clear();
        page.profileSkype.sendKeys(skype);
    }
   
    @Step 
    public void fill_wm_profile_icq(String icq){
        try {          

             page.profileICQ.click();
             
             page.profileICQ.clear();  
             
             page.profileICQ.sendKeys(icq);
            
            
            
            Thread.sleep(1500);
        } catch (InterruptedException ex) {
            Logger.getLogger(ProfileSteps.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Step 
    public void fill_wm_profile_currency_name(String name){
        page.profileCurrencyName.click();
        page.profileCurrencyName.clear();
        page.profileCurrencyName.sendKeys(name);
    }
    
    @Step 
    public void fill_wm_profile_count_number(String number){
        page.getCountField().click();
        page.getCountField().clear();
        page.getCountField().sendKeys(number);
    }
    
    @Step
    public void select_currency_in_profile(String currencyName){
        page.profileCurrencySelectButton.click();
        page.getSelectList().findElement(By.linkText(currencyName)).click();
    }
    
    
    
    
    
    @Step
    public void check_profile_name_is_saved(String name){
        Assert.assertEquals(name, page.profileName.getAttribute("value"));
    }
    
    @Step
    public void check_profile_skype_is_saved(String name){
        Assert.assertEquals(name, page.profileSkype.getAttribute("value"));
    }
    
    @Step
    public void check_profile_icq_is_saved(String name){
        Assert.assertEquals(name, page.profileICQ.getAttribute("value"));
    }
    
    @Step
    public void check_profile_phone_is_saved(String name){
        Assert.assertEquals("+"+name, page.profilePhone.getAttribute("value"));
    }
    
    @Step
    public void check_profile_top20_is_saved(String name){
        Assert.assertEquals(name, page.profileTop20Nick.getAttribute("value"));
    }
    
    
    @Step
    public void click_profile_notofication_tab(){
        page.profileTab3Link.click();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException ex) {
            Logger.getLogger(ProfileSteps.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Step
    public void check_checkboxes_are_displayed(){
         try {
            Thread.sleep(1500);
        } catch (InterruptedException ex) {
            Logger.getLogger(ProfileSteps.class.getName()).log(Level.SEVERE, null, ex);
        }

        Assert.assertTrue(page.backToWorkCheckbox.isDisplayed());
        Assert.assertTrue(page.profileNewProductsCheckbox.isDisplayed());
        Assert.assertTrue(page.profileNewsCheckbox.isDisplayed());
    }
    
    @Step
    public void click_all_checkboxes(){
     page.click_all_checkboxes();
    }
    
    @Step
    public String get_billing_count(){
        return page.getCountFieldValue();
    }
    
    @Step
    public void check_saved_count_value(String expected, String actual){
        Assert.assertEquals(expected, actual);
    }
    
    @Step
    public boolean get_i_checkbox_state(int i){
        boolean state;
          String stt = getDriver().findElement(By.xpath("//div[@page_id='page-1']")).findElements(By.tagName("label")).get(i).getAttribute("class");
          if("checkbox  checked".equals(stt)){
              state = true;
          }
          else if("checkbox checked".equals(stt)){
              state = true;
          }
          else{
              state = false;
          }
          return state;
    }
    
    @Step
    public boolean get_1_checkbox_state(){
        boolean state;
          String stt = page.chbx1.getAttribute("class");
          if("checkbox  checked".equals(stt)){
              state = true;
          }
          else if("checkbox checked".equals(stt)){
              state = true;
          }
          else{
              state = false;
          }
          return state;
    }
    
    @Step
    public boolean get_2_checkbox_state(){
        boolean state;
          String stt = page.chbx2.getAttribute("class");
          if("checkbox  checked".equals(stt)){
              state = true;
          }
          else if("checkbox checked".equals(stt)){
              state = true;
          }
          else{
              state = false;
          }
          return state;
    }
    
    @Step
    public boolean get_3_checkbox_state(){
        boolean state;
          String stt = page.chbx3.getAttribute("class");
          if("checkbox  checked".equals(stt)){
              state = true;
          }
          else if("checkbox checked".equals(stt)){
              state = true;
          }
          else{
              state = false;
          }
          return state;
    }
    
    @Step
    public boolean get_4_checkbox_state(){
        boolean state;
          String stt = page.chbx4.getAttribute("class");
          if("checkbox  checked".equals(stt)){
              state = true;
          }
          else if("checkbox checked".equals(stt)){
              state = true;
          }
          else{
              state = false;
          }
          return state;
    }
    
    @Step
    public boolean get_5_checkbox_state(){
        boolean state;
          String stt = page.chbx5.getAttribute("class");
          if("checkbox  checked".equals(stt)){
              state = true;
          }
          else if("checkbox checked".equals(stt)){
              state = true;
          }
          else{
              state = false;
          }
          return state;
    }
    
    @Step
    public boolean get_6_checkbox_state(){
        boolean state;
          String stt = page.chbx6.getAttribute("class");
          if("checkbox  checked".equals(stt)){
              state = true;
          }
          else if("checkbox checked".equals(stt)){
              state = true;
          }
          else{
              state = false;
          }
          return state;
    }
    
    @Step
    public boolean get_7_checkbox_state(){
        boolean state;
          String stt = page.chbx7.getAttribute("class");
          if("checkbox  checked".equals(stt)){
              state = true;
          }
          else if("checkbox checked".equals(stt)){
              state = true;
          }
          else{
              state = false;
          }
          return state;
    }
    
    
    @Step
    public boolean get_checkbox_offers_news_state(){
        boolean state;
          String stt = page.profileNewsCheckbox.getAttribute("class");
          if("checkbox  checked".equals(stt)){
              state = true;
          }
          else if("checkbox checked".equals(stt)){
              state = true;
          }
          else{
              state = false;
          }
          return state;
    }
    
    @Step
    public boolean get_checkbox_tech_news_state(){
        boolean state;
          String stt = page.profileNewsCheckbox.getAttribute("class");
          if("checkbox  checked".equals(stt)){
              state = true;
          }
          else if("checkbox checked".equals(stt)){
              state = true;
          }
          else{
              state = false;
          }
          return state;
    }
    
        @Step
    public boolean get_checkbox_product_news_state(){
        boolean state;
          String stt = page.profileNewProductsCheckbox.getAttribute("class");
          if("checkbox  checked".equals(stt)){
              state = true;
          }
          else if("checkbox checked".equals(stt)){
              state = true;
          }
          else{
              state = false;
          }
          return state;
    }
    
    @Step
    public void check_news_checkbox_state_has_changed(boolean prevState){
        if(prevState==true){
            Assert.assertEquals("checkbox", page.profileNewsCheckbox.getAttribute("class"));
        }
        if(prevState==false){
            Assert.assertEquals("checkbox  checked", page.profileNewsCheckbox.getAttribute("class"));
        }
    }
    
   
    @Step
    public void submit_profile_tab3(){
        try {
            page.clickThirdSubmitProfileButton();
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ProfileSteps.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Step
    public void submit_profile_tab2(){
        try {
            page.clickThirdSubmitProfileButton();
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ProfileSteps.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Step
    public void check_product_checkbox_state_has_changed(boolean prevState){
        if(prevState==true){
            Assert.assertEquals("checkbox", page.profileNewProductsCheckbox.getAttribute("class"));
        }
        if(prevState==false){
            Assert.assertEquals("checkbox  checked", page.profileNewProductsCheckbox.getAttribute("class"));
        }
    }
    
    @Step
    public void check_tech_news_checkbox_state_has_changed(boolean prevState){
        if(prevState==true){
            Assert.assertEquals("checkbox", page.backToWorkCheckbox.getAttribute("class"));
        }
        if(prevState==false){
            Assert.assertEquals("checkbox  checked", page.backToWorkCheckbox.getAttribute("class"));
        }
    }
    
    @Step
    public void wait_for_tab1_load(){
        page.wait_to_tab_load();
    }
    
    @Step
    public void check_checkbox_status_has_changed(boolean was, boolean actual){
        String was1 = Boolean.toString(was);
        String actual1 = Boolean.toString(actual);
        Assert.assertFalse(was1.equals(actual1));
    }
    
    @Step
    public boolean check_if_second_tab_has_warning(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ProfileSteps.class.getName()).log(Level.SEVERE, null, ex);
        }
        boolean check = getDriver().getPageSource().contains("аккаунт заблокирован")||getDriver().getPageSource().contains("Безналичная выплата");
        return check;
        
    }
    @Step
    public void select_WMZ() {
        page.profileWMZSelectButton.click();
        page.profileWMZlink.click();
    }
    
   
    
    
}
