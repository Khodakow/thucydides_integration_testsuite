package cityads.ca_thucydides_new_design.WebmasterStory.tools;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.BannerRotatorSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.SmartBannersSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.TeaserIssueSteps;
import java.sql.Connection;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTagValuesOf;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.apache.commons.lang3.StringEscapeUtils;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;




@Story(TestSuite.WebMaster.SmartBanners.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class SmartBannersStoryTest extends Constants {

     private Connection con;
     private String wmName;
     private String newBanners = getCurrentDate();
     private String AJSCode;
     private String JSCode;
     private String teaserIssueAge;
     private String bannerCategory;
     private String teaserIssueAgeActual;
     private String bannerCtegoryActual;
     
     
    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public SmartBannersSteps steps;
    
    
    @Test 
    @WithTagValuesOf({"block:Instruments", "role:Webmaster"})
    public void smart_banners_test() throws Exception{
       
        
        wmName = steps.get_wm_name();
        steps.wm_login(wmName);
        steps.click_instruments_link();
       
        steps.click_smart_banners();
       
       ;
       
        steps.check_fatal_errors();
        
        //create
        steps.click_create_button();
        steps.scroll_to_preview_container();
        steps.check_fatal_errors();
        steps.check_smart_banner_preview_is_displayed();
        int count = steps.get_smartbanners_count_in_preview();   //first preview check
        steps.check_smartbanners_count_in_preview(count);
        steps.check_i_banners_in_preview_block(count);
        
        
        steps.fill_name_input(newBanners);
        steps.fill_subaccount_input(newBanners+" SUBACCOUNT");
        steps.click_first_select_down_arrow();
        bannerCategory = steps.click_i_element_in_select_list(0);   //Номер категории
        bannerCtegoryActual = steps.get_i_multiselect_text(0);   
        steps.waitAjax(8000);
        steps.check_values_are_equals(bannerCategory, bannerCtegoryActual);
        steps.click_i_multiselect_button(0);
        steps.click_some_elements_in_popup_list(0);
        steps.fill_min_price(String.valueOf(minPrice));
        steps.fill_max_price(String.valueOf(maxPrice));
        steps.click_apply_filter_button();
        steps.waitAjax(25000);
       
        
        //check prices
        //steps.check_prices_in_smart_preview(minPrice,maxPrice);
        steps.click_save_changes_button();
       
      
         //view result
        steps.sort_blue_table_by_id();
        steps.check_blue_table_is_visible();
        steps.check_blue_table_has_lines();
        steps.check_blue_table_has_text(newBanners);
        
        
        //parameters + preview
        steps.click_icon_in_blue_table_first_line(0);
        steps.check_fatal_errors();
        steps.check_smart_banner_preview_is_displayed();
        steps.check_fatal_errors();
        steps.check_smart_banner_preview_is_displayed();

        
        //script type
        steps.click_select_choose_n_arrow(2);
        steps.select_javascript_code();
        steps.check_fatal_errors();
        JSCode = steps.get_js_code_from_textarea();
        steps.check_smart_banner_code(JSCode);
        
        
        steps.click_select_choose_n_arrow(2);
        steps.select_ajs_code();
        steps.check_fatal_errors();
        AJSCode = steps.get_ajs_code_from_textarea();
        steps.check_smart_banner_code(AJSCode);
        
        steps.click_select_choose_n_arrow(2);
        steps.select_xml_code();
        steps.check_fatal_errors();
        steps.get_xml_code_from_textarea();
        
        steps.go_back();
        
        //delete all
        steps.select_all_lines_checkbox_in_blue_table();
        steps.click_delete_button();
       
        steps.waitAjax(8000);
        steps.check_blue_table_has_no_data();
        
        steps.close_browser();
            
       
        
    }
   
    
 
    

    
} 