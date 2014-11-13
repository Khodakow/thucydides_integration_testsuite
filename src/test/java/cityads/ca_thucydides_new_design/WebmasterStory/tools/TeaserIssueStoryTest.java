package cityads.ca_thucydides_new_design.WebmasterStory.tools;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.BannerRotatorSteps;
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




@Story(TestSuite.WebMaster.TeaserIssue.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class TeaserIssueStoryTest extends Constants {

     private Connection con;
     private String wmName;
     private String teaserIssueName = getCurrentDate();
     private String AJSCode;
     private String JSCode;
     private String teaserIssueAge;
     private String teaserIssueCategory;
     private String teaserIssueAgeActual;
     private String teaserIssueCtegoryActual;
     
     
    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public TeaserIssueSteps steps;
    
    
    @Test 
    @WithTagValuesOf({"block:Instruments", "role:Webmaster"})
    public void wm_teaser_issue_test() throws Exception{
       
        
        wmName = steps.get_wm_name();
        steps.wm_login(wmName);
        steps.click_instruments_link();
        steps.click_teaser_issue_link();
        steps.check_fatal_errors();
       ;
       
        steps.click_create_button();
        steps.scroll_to_preview_container();
        steps.check_fatal_errors();
        
        //form
        steps.fill_name_input(teaserIssueName);
        steps.fill_subaccount_input(teaserIssueName+" SUBACCOUNT");
        //steps.fill_teaser_issue_age("10");
        steps.click_first_select_down_arrow();
        teaserIssueCategory = steps.click_i_element_in_select_list(0);   //Номер категории
        teaserIssueCtegoryActual = steps.get_i_multiselect_text(0);  
        steps.waitAjax(1000);
        steps.check_values_are_equals(teaserIssueCategory, teaserIssueCtegoryActual);
       
        
        
        steps.click_i_multiselect_button(0);
        steps.click_some_elements_in_popup_list(0);
        
        
        steps.fill_min_price(String.valueOf(minPrice));
        steps.fill_max_price(String.valueOf(maxPrice));
        
        steps.click_apply_filter_button();
       
        steps.waitAjax(8000);
        //check prices
        steps.check_prices_in_teasers_preview(minPrice,maxPrice);

        steps.click_save_changes_button();
       
       
        //check treaser preview
        steps.check_fatal_errors();
        steps.check_blue_table_is_visible();
        steps.check_blue_table_has_lines();
        steps.sort_blue_table_by_id();
       
        steps.click_icon_in_blue_table_first_line(0);
       
        steps.check_advertisment_tabs_displaeyd();
        steps.check_fatal_errors();
        steps.scroll_to_preview_container();
        steps.check_teaser_preview_is_displayed();
        steps.check_teasers_count_in_blue_table();
        
        //pager
        steps.check_pager_is_displayed();
        steps.check_fatal_errors();
        steps.scroll_to_preview_container();
        steps.check_teaser_preview_is_displayed();
        steps.check_teasers_count_in_blue_table();        
        
        //teaser script type
        steps.click_select_code_arrow();
       
        steps.select_javascript_code();
        steps.check_fatal_errors();
        JSCode = steps.get_js_code_from_textarea();
        steps.check_script_code(JSCode);
        
        steps.click_select_code_arrow();
        steps.select_ajs_code();
        steps.check_fatal_errors();
        AJSCode = steps.get_ajs_code_from_textarea();
        steps.check_script_code(AJSCode);
        
        steps.click_select_code_arrow();
        steps.select_xml_code();
        steps.check_fatal_errors();
        
        steps.go_back();
        
        //delete all
        steps.select_all_lines_checkbox_in_blue_table();
        steps.click_delete_button();
       
        steps.check_blue_table_has_no_data();

        
        steps.close_browser();
        
    }
   
    
 
    

    
} 