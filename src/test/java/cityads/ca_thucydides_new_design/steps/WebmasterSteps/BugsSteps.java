/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.steps.WebmasterSteps;

import cityads.ca_thucydides_new_design.pages.WemasterPages.BugsPage;
import cityads.ca_thucydides_new_design.steps.BaseSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

/**
 *
 * @author s.lugovskiy
 */
public class BugsSteps extends BaseSteps {

    public BugsSteps(Pages pages) {
        super(pages);
    }
    
    BugsPage page;
    
    @Step
    @Override
     public void check_values_are_equals(String expected , String actual){
         Assert.assertEquals(expected, actual);
     }
    
    @Step
    public String get_currency_date_value(){
        return page.currencyDate.getText();
    }
    
    @Step
    public String get_first_offer_id_stats(){
     return page.stat_offer_first_id_blue_table.getText();
    }
    
   @Step 
   public String get_first_coupon_text(){
   return page.first_coupon_name.getText();
   
   }
@Step 
    public void check_filter_results_has_russia() {
    Assert.assertTrue(page.filter_result.getAttribute("innerHTML").contains("Russian Federation")||page.filter_result.getAttribute("innerHTML").contains("Россия"));  
    }

@Step 
    public void check_filter_results_has_not_russia() {
    Assert.assertFalse(page.filter_result.getAttribute("innerHTML").contains("Russian Federation")||page.filter_result.getAttribute("innerHTML").contains("Россия"));  
    }

  @Step
 public void check_not_emptydata() {
    Assert.assertFalse(page.blueTable.getAttribute("innerHTML").contains("Элементы не найдены"));  
    }

 @Step
    public void click_table_settings(){
    page.pager_settings_menu.click();
 }
 
 @Step
  public void click_five_element_in_table(){
    page.pager_settings_count.click();
    page.five_count.click();
  }
 
 @Step
 public void applay_table_setting(){
 page.page_applay.click();
 }
 
 @Step
  public void click_date_sort(){
    page.title_date.click();
 }
 
 @Step
  public void click_value_sort(){
    page.title_value.click();
 }
 
 @Step 
 public String get_count_pages(){
 String num_pages = "";
 String s = page.count_page.getAttribute("innerHTML");
 System.out.print(getDriver().findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/div[5]/ul/li[1]/div[1]/div[2]")).getText());
 return s;
 }
 
 @Step 
 public void check_table_fifth(){
 getDriver().findElement(By.id("id_el_td_273_67_date_5"));
   }
 
 @Step
 public Integer get_number_string(){
    return  page.blueTable.findElement(By.tagName("tbody")).findElements(By.tagName("tr")).size();       
 }
 @Step
 public void delete_filter_region(){
 getDriver().findElement(By.xpath("//span[@class='ib col-blue size-16 pointer']")).click();
 }   
   
 @Step
 public void delete_filter_region_product_list_page(){
 getDriver().findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/div[3]/div[1]/div[1]/div[1]/div[2]/div/div/span")).click();
 }   
 
 @Step
 public void delete_filter_region_cupon_page(){
 getDriver().findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/div[4]/div[1]/div[1]/div[1]/div[2]/div/div/span")).click();
 }   

 @Step
    public void scroll_top() {
        executeScript("document.body.scrollTop = document.documentElement.scrollTop = 0;");
    }
    
    @Step
    public void check_acces_denied_message() {
        Assert.assertFalse(getDriver().getPageSource().contains("Access denied"));
    }
    
    @Step
    public int get_filters_number() {
        //Регионы 
        return page.findAll(By.xpath("//div[@class='ib col-evil lh-28' and contains(text(),'Регионы')]")).size();
        //return page.findAll(By.className("_selected_filters")).size();
    }
    @Step
    public void check_filter_number_is_1(int i, int filtersNumber) {
        Assert.assertEquals(i, filtersNumber);
    }
 
 
    @Step
    public String get_coupons_count(){
        return page.couponsCount.getText();
    }

    @Step
    public void set_date_to_calendar(String s) {
        getDriver().findElement(By.xpath("//input[@id='period']")).clear();
        executeScript("$('#period').val("+s+")");
        getDriver().findElement(By.xpath("//input[@id='period']")).sendKeys(Keys.RETURN);
    }

    @Step
    public String get_date_from_period() {
        return getDriver().findElement(By.xpath("//input[@id='period']")).getAttribute("value");
    }
}
