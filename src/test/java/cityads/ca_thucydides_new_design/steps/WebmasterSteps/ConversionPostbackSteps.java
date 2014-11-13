/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.steps.WebmasterSteps;

import cityads.ca_thucydides_new_design.pages.MainPage;
import cityads.ca_thucydides_new_design.pages.WemasterPages.ConversionPostbackPage;
import java.util.List;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import org.junit.Assert;
import org.openqa.selenium.By;
import static org.hamcrest.Matchers.is;
import org.openqa.selenium.WebElement;
/**
 *
 * @author s.lugovskiy
 */
public class ConversionPostbackSteps extends BannerRotatorSteps {

    MainPage mainPage;
    ConversionPostbackPage page;
        
    public ConversionPostbackSteps(Pages pages) {
        super(pages);
    }
    @Step
    public void check_postback_table_is_visible() {
        Assert.assertThat((getDriver().findElement(By.tagName("table")).isDisplayed()), is(true));
    }
    @Step
    public void fill_postback_url(String url) {
        page.postbackUrl.sendKeys(url);
    }
    @Step
    public void click_save_postback_button() {
        page.savePostbackButton.click();
    }

    @Step
    public void click_save_postback_in_popup_button() {
        page.getSaveConversionButton().click();
    }
    
    @Step
    public void fill_feed_name_in_postback(String feedName) {
        page.find(By.cssSelector("div._content_place > div.grid4 > div.span3 > input.dark._name")).sendKeys(feedName);
    }                             
    
    @Step
    public void click_all_checkboxes_in_postback() {
        List <WebElement> checkboxes = page.postbackTable.findElement(By.tagName("tbody")).findElements(By.tagName("label"));
        int i = 0;
        for(WebElement box : checkboxes){
            if(i!=0) {
                box.click();//игнорируем первый чекбок
            } 
        }
    }
    @Step
    public void click_preview_postback_icon() {
        page.postbackPreviewIcon.click();
    }
    @Step
    public void click_copy_code_in_popup() {
        //button dark submit _copy_button
        page.getCopyCodeButton().click();
    }
    @Step
    public String get_code_from_postback_popup() {
        return page.popup.findElement((By.cssSelector("div._content_place > div.margin-top-micro > textarea._code._click_select"))).getText();
    }
    @Step    
    public void check_postback_get_request_has_url(String url, String code){
        Assert.assertTrue(code.contains(url));
    }
    @Step
    public void click_get_postback_checkbox() {
        page.getCheckbox.click();
    }
    
}
