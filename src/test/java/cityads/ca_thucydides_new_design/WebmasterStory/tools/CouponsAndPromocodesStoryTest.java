package cityads.ca_thucydides_new_design.WebmasterStory.tools;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.CouponsAndPromocodesSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.CarcasSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FilterSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FrontSteps;
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
    @Steps
    public FrontSteps front;
    @Steps
    public CarcasSteps carcas;
    @Steps
    public FilterSteps filter;
    
    
    @Test
    @Title("Проверка раздела Купоны и промокоды")
    @WithTagValuesOf({"block:Goods And Coupons","role:Webmaster"})
    public void coupons_and_promocodes_test() throws Exception{
       
        
        front.login();
        steps.wait_for_all_spinners_dissapears(30);
        carcas.go_to_coupons();
        filter.reset_filter();
        
        offerName = steps.get_offer_name_from_coupon_card();
        steps.click_offer_in_coupon_card();
        steps.wait_for_all_spinners_dissapears(30);
        steps.check_blue_table_is_visible();
        steps.check_blue_table_has_lines();
        steps.close_browser();
      
        
    }
   
    
 
    

    
} 