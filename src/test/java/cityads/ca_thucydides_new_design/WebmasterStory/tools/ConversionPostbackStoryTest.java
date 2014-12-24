package cityads.ca_thucydides_new_design.WebmasterStory.tools;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.ConversionPostbackSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.sql.Connection;


@Story(TestSuite.WebMaster.ConversionPostback.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class ConversionPostbackStoryTest extends Constants {

     public Connection con;
     public String wmName;
     public String feedName = getCurrentDate();
     public String url = "http://"+feedName+".com";
     private String code;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public ConversionPostbackSteps steps;
    
    @Test
    @Title("Тест на сохранение конвершн постбек")
    @WithTagValuesOf({"block:Instruments","role:Webmaster"})
    public void conversion_postback_test() throws Exception{
       
        
        wmName = steps.get_wm_name();
        steps.wm_login(wmName);
        steps.click_instruments_link();
        steps.wait_for_all_spinners_dissapears(190);
        steps.click_conversion_postback_link();
        steps.wait_for_h1_title_appears(wmConversionPostbackH1Name,25);
        steps.click_create_button();
        steps.check_fatal_errors();
        steps.wait_for_h1_title_appears(wmConversionPostbackAddH1Name,25);
        steps.check_postback_table_is_visible();
        steps.check_fatal_errors();
        

        steps.click_get_postback_checkbox();
        steps.fill_postback_url(url);
        steps.click_save_postback_button();
        steps.check_fatal_errors();
        steps.wait_for_popup_appears(5);
        steps.fill_feed_name_in_postback(feedName);
        
        code = steps.get_code_from_postback_popup();
        steps.check_postback_get_request_has_url(url, code);
        steps.click_save_postback_in_popup_button();
        steps.wait_for_all_spinners_dissapears(190);
        steps.wait_for_spinner_dissapear(190);
        steps.waitABit(5000);
        steps.click_conversion_postback_link();
        steps.wait_for_all_spinners_dissapears(190);
        steps.check_blue_table_is_visible();
        steps.check_blue_table_has_text(url);
        
        steps.delete_all_from_blue_table();
        
        
        steps.close_browser();
        
        
    }
    
 
    

    
} 