/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.steps.WebmasterSteps;

import cityads.ca_thucydides_new_design.pages.WemasterPages.ChosenOffersPage;
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
public class ChosenOffersSteps extends OfferListSteps {

    
    ChosenOffersPage page;
            
    public ChosenOffersSteps(Pages pages) {
        super(pages);
    }
    
    @Step
    public void click_first_star(){
        page.getFirstLineInBlueTable().findElement(By.className("icon-favorites")).click();
    }
    
    @Step
    public boolean get_first_star_status(){
       //System.out.println("\n========="+getFirstLineInBlueTable().findElement(By.className("table-icon")).getAttribute("class"));
       return getFirstLineInBlueTable().findElement(By.className("table-icon")).getAttribute("class").contains("active");
    }
    
    @Step
    public String get_first_offer_name(){
        //waitForAjax();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ChosenOffersSteps.class.getName()).log(Level.SEVERE, null, ex);
        }
        return getFirstLineInBlueTable().findElement(By.tagName("a")).getText();
    }
  
    @Step
    public void click_chosen_offers_links(){
        page.chosenOffersLink.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ChosenOffersSteps.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Step
    public void uncheck_all_chosen_offers() {
        try{
            
            int n = 0;
            int size = getDriver().findElements(By.xpath("(//table[@id='table_wm.web_adv'])[2]/tbody/tr/td//div[contains(@id,'star') and contains(@class,'active')]")).size();

            while(n<size){
                getDriver().findElements(By.xpath("(//table[@id='table_wm.web_adv'])[2]/tbody/tr/td//div[contains(@id,'star') and contains(@class,'active')]/span")).get(0).click();
                Thread.sleep(300);
                n++;
            }
            
        }
        catch(Exception e){
            
        }
    }
    
    @Step
    public void click_all_offers_tab(){
        page.allOffersTab.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ChosenOffersSteps.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Step
    public void checkoffer_checked_status_is_true(boolean status){
        Assert.assertEquals(status,true);
    }
    
    
    
}
