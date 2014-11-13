/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.steps.WebmasterSteps;

import cityads.ca_thucydides_new_design.pages.MainPage;
import cityads.ca_thucydides_new_design.pages.WemasterPages.BannerRotatorPage;
import cityads.ca_thucydides_new_design.pages.highload.BannerstestPage;
import cityads.ca_thucydides_new_design.steps.SetupSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.hamcrest.CoreMatchers.containsString;

/**
 *
 * @author s.lugovskiy
 */
public class BannerRotatorSteps extends SetupSteps {

    MainPage mainPage;
    BannerRotatorPage page;
    BannerstestPage testpage;
            
    public BannerRotatorSteps(Pages pages) {
        super(pages);
    }
    
    
    @Step("Выбрать тип промо: все")
    public void select_all_promo_type(){
        page.bannerRotatorPromoTypeAll.click();
    }
    
    @Step("Выбрать тип промо: img")
    public void select_image_promo_type(){
        page.bannerRotatorImageType.click();
    }
     
    @Step("Выбрать тип промо: флеш")
    public void select_flash_promo_type(){
        page.bannerRotatorFlashType.click();
    }
    
   
    
    @Step
    public void click_popup_list_button(){
        page.bannerRotatorPopupListButton.click();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException ex) {

        }
    }
    
    @Step
     public WebElement getPopupListFirstItem(){
            return page.popupList.findElement(By.tagName("li")).findElement(By.tagName("a"));
    }
    
  
    
    @Step
    public void choose_some_items_in_size_popup_list(){
        click_popup_list_button();
        check_popup_list_is_displayed();
        getPopupListFirstItem().getText();
        click_popup_list_first_item();
        click_popup_list_button();
        check_popup_list_is_displayed();
        getPopupListFirstItem().getText();
        click_popup_list_first_item();
        click_popup_list_button();
        check_popup_list_is_displayed();
        click_popup_list_first_item();
        clickApplyPopupButton();
        check_fatal_errors();
    }

    public void click_actions_popup_list_button() {
        page.bannerRotatorPopupSizeListButton.click();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException ex) {
            Logger.getLogger(BannerRotatorSteps.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public void click_actions_popup_list_first_item(){
        page.popupActionsList.findElement(By.tagName("li")).findElement(By.tagName("a")).click();
    }
    
    @Step
    public void select_offer_in_popup_list(String offerForRotator){

        getDriver().findElement(By.cssSelector("input._searching._has_autocomplete")).clear();
        getDriver().findElement(By.cssSelector("input._searching._has_autocomplete")).sendKeys(offerForRotator);
        try {Thread.sleep(2000);} catch (InterruptedException ex) {};
        getDriver().findElement(By.xpath("//span[@class='_auto_items pointer' and contains(text(),'"+offerForRotator+"')]")).click();

    }
    
    @StepGroup
     public void click_offer_in_popup_list(String offerForRotator){

         click_small_popup_button();
         check_autocomplete_is_displayed();
         select_offer_in_popup_list(offerForRotator);
         click_popup_apply_button();
             
     }
     
   
    @Step("Нажимаем кнопку Обновить")
    public void click_update_button(){
        page.bannerRotatorUpdateButton.click();
    }
    
    @Step("Получаем асинхронный код")
    public String get_ajs_code_from_textarea(){
        return page.getTextareaCodeWithCode();
    }
    
    @Step("Получаем код")
    public String get_js_code_from_textarea(){
         //System.out.println(page.codeAreaJS.getAttribute("innerHTML"));
         return page.getTextareaCodeWithCode();
    }
  
    @Step("Получаем код выгрузки ХМЛ")
    public String get_xml_code_from_textarea(){
        return page.getTextareaCodeWithCode();
    }
    
    @Step
    public String get_offers_in_multiselect(){
        return page.getOffersFromMultiselect();
    }

    @Step("Получаем имя оффера с формы ротатора")
    public String get_offer_name_in_rotataor_params() {
        return page.offerLinkInRotatorParams.getText();
    }
    
    @Step("кликаем по офферу в форме ротатора")
    public void click_offer_name_in_rotataor_params() {
         page.offerLinkInRotatorParams.click();
    }
    
    @Step("Проверяем что в превью баннера <img>")
    public void check_banner_preview_has_only_IMG_tag(){
        if(!page.preview.getAttribute("innerHTML").contains("Нет подходящих")){
            Assert.assertThat(page.preview.getAttribute("innerHTML"), containsString("<img"));  
        }
    }
    
    @Step("Проверяем что в превью баннера <object>")
    public void check_banner_preview_has_only_FLASH_tag(){
        if(!getDriver().getPageSource().contains("Нет подходящих")){
            Assert.assertThat(page.preview.getAttribute("innerHTML"), containsString("<object"));  
        }
    }
    
    @Step
    public void wait_for_offer_params_page_appears(int timeout) {
                WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
                wait.until(ExpectedConditions.visibilityOf(page.offerLinkInRotatorParams));
    }

    @Step
    public void scroll_to_select() {
        scroll(page.selectChoose);
    }

    @Step
    public void click_go_to_overwiew() {
        page.bannerParamsGoToOverwiew.click();
    }




    
}
