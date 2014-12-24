package cityads.ca_thucydides_new_design.WebmasterStory.coupons;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.CouponsAndPromocodesSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.sql.Connection;




@Story(TestSuite.WebMaster.CouponsAndPromocodes.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")

public class CouponsAndPromocodesStoryTest extends Constants {

     private Connection con;
     private String wmName;
     private String offerName;
     
     
    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    
    @Steps
    public CouponsAndPromocodesSteps steps;
    
    
    
    @Test
    @Title("Проверка раздела Купоны и промокоды")
    @WithTagValuesOf({"block:Goods And Coupons","role:Webmaster"})
    public void coupons_and_promocodes_test() throws Exception{
       
        
        wmName = steps.get_wm_name();
        steps.wm_login(wmName);
        steps.wait_for_all_spinners_dissapears(30);
        steps.click_goods_and_coupons_link();
        steps.wait_for_all_spinners_dissapears(30);
        steps.click_coupons_and_promocodes_link();
        steps.wait_for_all_spinners_dissapears(30);
        steps.wait_for_h1_title_appears("", 35);
        steps.waitABit(10000);
        steps.executeScript("$('#id_el_input_filter_reset').click()");
        steps.wait_for_all_spinners_dissapears(60);
        //steps.check_filters_are_visible();
        //steps.check_first_coupon_card();
        //steps.wait_for_all_spinners_dissapears(30);
        //steps.check_first_coupon_img();
        
        steps.waitABit(10000);
        offerName = steps.get_offer_name_from_coupon_card();
        steps.click_offer_in_coupon_card();
        steps.waitABit(10000);
        steps.wait_for_all_spinners_dissapears(30);
        steps.check_blue_table_is_visible();
        steps.check_blue_table_has_lines();
        
        
        
        steps.close_browser();
      
        
    }
   
    
 
    

    
} 