/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.steps.WebmasterSteps;

import cityads.ca_thucydides_new_design.pages.WemasterPages.OfferListPage;
import cityads.ca_thucydides_new_design.pages.db.MySQLWorker;
import cityads.ca_thucydides_new_design.steps.SetupSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.assertTrue;

/**
 *
 * @author s.lugovskiy
 */
public class OfferListSteps extends SetupSteps {

    OfferListPage page;
    OfferCardSteps cardSteps;
            
    public OfferListSteps(Pages pages) {
        super(pages);
    }
    
    @Step
    public void click_offer_link(){
        page.offerListLink.click();
    }
    
    @Step
    public void click_new_local_offers(){
        page.newLocalOffersTab.click();
    }
    @Step
    public void click_new_recomend_offers(){
        page.newRecommendOffersTab.click();
    }        
    
    
    @Step
    public void click_go_to_page_arrow(){
        page.clickGoToPageArrow();
    }
    
    @Step("Клик по первому офферу в таблице")
    public void click_first_offer(){
        page.getFirstOfferInTable().click();
        
    }
    
    @Step
    public String get_first_offer_name(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String name = page.getFirstOfferInTable().getText();
        return name;
    }
    
     @Step
    public String get_second_offer_name(){
        String name = page.getFirstOfferInTable().getText();
        return name;
    }
    
    @Step
    public void check_filters(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(OfferListSteps.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertTrue(page.offerListCategoryFilter.isDisplayed());
        assertTrue(page.offerListRegionFilter.isDisplayed());
        assertTrue(page.offerListToolFilter.isDisplayed());
    }
    
    
    @Step("Проверяем что в первой строке в первом столбце присутствует замок")
    public void check_bluetable_first_line_has_lock(){
        page.checkFirstLock();
    }

    @Step("Считаем число замков с помощью скрипта $('span[class=\"icon-lock\"]').size() и проверяем что > 0")
    public void count_locks_with_jquery(){
        Integer size = page.getLocksCountWithJquery();
        //assertNotNull("проверяем что $('span[class=\"icon-lock\"]').size() не Null ",size);
        assertTrue(size > 0);
    }


    @Step("Проверяем что в первой строке в первом столбце присутствует замок")
    public boolean hasLockOffer(){
        Boolean check = page.hasLock();
        return  check;
    }

    @Step
    public void select_regions_in_filter(){
        page.offerlistRegionFilterSelectRegions();
    }
    
    @Step
    public void apply_filter(){
        page.offferlistApplyFilterButton.click();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException ex) {
            Logger.getLogger(OfferListSteps.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Step
    public void select_first_category_in_category_filter(){
        page.offerlistCategoryFilterSelectCategory();
    }

    
    @Step
    public void click_offer(List<WebElementFacade> offerList,int number){
        offerList.get(number).findBy(By.className("name")).click();
    }

    @Step
    public void scroll_top() {
        executeScript("document.body.scrollTop = document.documentElement.scrollTop = 0;");
    }

    @Step
    public void scroll_right() {
        executeScript("window.scroll(1980,1);");
    }

    @Step
    public void write_all_active_offers_to_db() {
        int pageCount = page.getPageCountInPager();
        int j;

        for(j=0;j<pageCount;j++) {                                          //for page
            List<WebElementFacade> offers = page.findAll(By.xpath("//td[contains(@class,'name')]"));
            for (WebElementFacade offer : offers) {                         //for offer
                 if(!offer.getText().isEmpty()){
                        System.out.println("Adding offer to db "+offer.getText());
                        MySQLWorker.addOffersToDB(offer.getText());
                 }
            }
            click_go_next_page();
            wait_for_all_spinners_dissapears(90);
        }
    }
    @Step
    public void click_checkbox_in_filter_with_text(String text){

        WebElement box = get_webelement_with_jquery("$('label div.ib.pointer:contains(\""+text+"\")').get(0)");
        box.click();
        //getDriver().findElement(By.xpath("//label/div[contains(text(),'"+text+"')]")).click();
    }
}
