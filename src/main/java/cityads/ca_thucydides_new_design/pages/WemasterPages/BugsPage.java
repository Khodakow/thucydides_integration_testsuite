/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.pages.WemasterPages;

import cityads.ca_thucydides_new_design.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author s.lugovskiy
 */
public class BugsPage  extends MainPage{

    public BugsPage(WebDriver driver) {
        super(driver);
    }
    
    @FindBy(xpath="(//table[contains(@class,'blue_table')]/tbody/tr/td)[1]")
    public WebElement currencyDate;
    
     @FindBy(id="id_el_td___id_action_id_1")
    public WebElement stat_offer_first_id_blue_table;
    
     @FindBy(xpath="(//div[@class='kupon-describer']/div)[1]")
     public WebElement first_coupon_name;
     
   @FindBy(xpath="//div[@class='_selected_filters _hasFilters']")
   public WebElement filter_result;
     
      @FindBy(id="pager_settings_menu")
       public WebElement pager_settings_menu;
      
      @FindBy(css="div.select-choose.pointer")
      public WebElement pager_settings_count;
      
      @FindBy(id="pager_setting_menu_submit")
      public WebElement page_applay;
      
      @FindBy(linkText="5")
      public WebElement five_count;
      
      @FindBy(id="id_el_th_a273_67_date")
      public WebElement title_date;
      
      @FindBy(id="d_el_th_a270_67_value")
      public WebElement title_value;
      
      @FindBy(css="body > div.all > div.section.content.with-shadow > div > div.page-content > div > div.float-right > ul > li.pages-navigation > div.pager-page")
      public WebElement count_page;
      
      @FindBy(xpath="//span[@format='num']")
      public WebElement couponsCount;
      
}
