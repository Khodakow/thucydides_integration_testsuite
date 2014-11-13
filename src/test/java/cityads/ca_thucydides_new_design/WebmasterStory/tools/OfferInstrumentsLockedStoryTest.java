package cityads.ca_thucydides_new_design.WebmasterStory.tools;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.BannerRotatorSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.OfferCardSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.sql.Connection;
import java.util.Set;


@Story(TestSuite.WebMaster.OfferInstruments.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class OfferInstrumentsLockedStoryTest extends Constants {

     private Connection con;
     private String wmName;
     private String offerName;
     private String offerNameInMultiselect;
     private String actualOfferName;
     private String code;
     private String offerSite;
     private String actualSite;
     private Set<String> handleList;
     private String lastHandle;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;
    
    @Steps
    public OfferCardSteps steps;
    
    @Steps
    public BannerRotatorSteps bannerSteps;

 
    @Test @WithTagValuesOf({"block:Instruments", "role:Webmaster"})@Title("Проверка что есть недоступные офферы")
    public  void wm_offer_instruments_locked_offer_test() throws Exception{
        

        wmName = steps.get_wm_name();
        steps.wm_login(wmName);
        steps.click_offer_link();
        steps.wait_for_all_spinners_dissapears(60);
        steps.click_web_offers();
        steps.wait_for_all_spinners_dissapears(60);
        steps.check_fatal_errors();
        steps.Sort_blue_table_by_first_th();
        steps.wait_for_all_spinners_dissapears(60);
        steps.Sort_blue_table_by_first_th(); 
        steps.wait_for_all_spinners_dissapears(60);
        steps.check_bluetable_first_line_has_lock();
        steps.click_first_offer();

        steps.wait_for_start_offer_button_is_visible(15);
        steps.check_description_is_visible();
        steps.click_add_offer_link();
        steps.check_popup_is_currently_visible();
        
//        steps.waitAjax(3000);
//        steps.check_offercard_popup_is_displayed();
//        steps.click_add_link_popup_button();
//        
//        code = steps.get_code_from_popup_textarea();
//        steps.check_script_code(code);
     
       

        
        

     
        
        steps.close_browser();
        
    }
    
    
    
    
 
    

    
} 