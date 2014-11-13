package cityads.ca_thucydides_new_design.WebmasterStory.tools;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.pages.MainPage;
import cityads.ca_thucydides_new_design.pages.WemasterPages.LinksRotatorPage;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.BannerRotatorSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.LinksRotatorSteps;
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




@Story(TestSuite.WebMaster.LinksRotator.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class LinksRotatorStoryTest extends Constants { 

     private Connection con;
     private String wmName;
     private String linksRotatorName = getCurrentDate();
     private String linksRotatorSubaccountName = linksRotatorName + " SUBACCOUNT LINKS ROTATOR";
     private String linksRotatorNameNew = getRandomIntNumber();
     private String linksRotatorSubaccountNameNew = linksRotatorNameNew + " NEW SUBACCOUNT LINKS ROTATOR";
     private int feedItemCount;
     
     
     
    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;
    LinksRotatorPage Page;

    @Steps
    public LinksRotatorSteps steps;
    
    

    
    
    @Test
    @WithTagValuesOf({"block:Instruments", "role:Webmaster"})
    public void links_rotator_test() throws Exception{
       
        
        wmName = steps.get_wm_name();
        steps.wm_login(wmName);
        steps.click_instruments_link();
        steps.click_rotators_link();
        steps.click_links_rotator_link();
       
       ;
        steps.check_fatal_errors();
        steps.click_create_button();
        steps.check_fatal_errors();
        steps.check_add_form_is_displayed();
        
        //form fill
        steps.fill_name_input(linksRotatorName);
        steps.fill_subaccount_input(linksRotatorSubaccountName);
        steps.check_banner_type_checkboxes_are_visible();
        steps.click_img_type_banner_checkbox();
        
        //multiselects
        steps.click_i_multiselect_button(0);
        steps.click_some_elements_in_popup_list(0);
        
        steps.click_i_multiselect_button(1);
        steps.click_some_elements_in_popup_list(1);
        
        steps.click_i_multiselect_button(2);
        steps.click_some_elements_in_popup_list(2);
        
        steps.click_i_multiselect_button(4);
        steps.click_some_elements_in_popup_list(4);
   
        steps.fill_max_banners_size(wmLinksRotatorMaxBanners);
        steps.fill_max_offers_size(wmLinksRotatorMaxOffers);
        steps.submit_form();  
       
        
        //editor
       
        steps.waitAjax(8000);
        steps.click_icon_in_blue_table_first_line(0);
       
       
       
        steps.click_select_choose();
        steps.click_select_rotator_links_link(linksRotatorName);
       
        steps.check_param_table_is_visible();
        steps.check_subaccount_name_is_present_in_params_table(linksRotatorSubaccountName);
        steps.check_maxoffers_is_present_in_params_table(wmLinksRotatorMaxOffers);
        steps.check_maxbanners_name_is_present_in_params_table(wmLinksRotatorMaxBanners);
        feedItemCount = steps.get_feed_count();
        steps.check_feed_count_equals_offers_count(feedItemCount,wmLinksRotatorMaxOffers);
        
        //change form
        steps.click_change_button();
        steps.fill_name_input(linksRotatorNameNew);
        steps.fill_subaccount_input(linksRotatorSubaccountNameNew);
        steps.submit_form();  
       
        steps.click_instruments_link();
        steps.click_links_rotator_link();
        steps.click_icon_in_blue_table_first_line(0);
       
       
       ;
        steps.click_select_choose();
        steps.click_select_rotator_links_link(linksRotatorNameNew);
       
        steps.check_param_table_is_visible();
        steps.check_subaccount_name_is_present_in_params_table(linksRotatorSubaccountNameNew);
        
        //delete all
        steps.click_instruments_link();
        steps.click_links_rotator_link();
        steps.delete_all_from_blue_table();
        steps.close_browser();
        
        steps.close_browser();
        
    }
//    
//    @Test
//    @WithTagValuesOf({"block:Instruments", "page:Links Rotator Preview", "role:Webmaster"})
//    public void test_text_links_rotator_preview() throws Exception{
//        Constants cons = new Constants();
//        String linksRotatorPreviewTestName = cons.getRandomIntNumber();
//        
//        
//        
//        wmName = steps.get_wm_name(con);
//        steps.wm_login(wmName);
//        steps.click_instruments_link();
//        steps.click_rotators_link();
//        steps.click_links_rotator_link();
//        steps.click_create_button();
//        steps.check_fatal_errors();
//        steps.check_add_form_is_displayed();
//        //form fill
//        steps.fill_name_input(linksRotatorPreviewTestName);
//        steps.fill_subaccount_input(linksRotatorPreviewTestName);
//        steps.check_banner_type_checkboxes_are_visible();
//        steps.click_img_type_banner_checkbox();
//        //multiselects
//        steps.click_i_multiselect_button(0);
//        steps.click_some_elements_in_popup_list(0);
//        steps.click_i_multiselect_button(1);
//        steps.click_some_elements_in_popup_list(1);
//        steps.fill_max_banners_size(wmLinksRotatorMaxBanners);
//        steps.fill_max_offers_size(wmLinksRotatorMaxOffers);
//        steps.submit_form();  
//        steps.waitForAjax(2000);
//        steps.sort_blue_table_by_id();
//        
//        //check_preview
//        steps.check_preview_is_visible();
//        steps.check_feed_count_equals_offers_count(feedItemCount, feedItemCount);
//        steps.close_browser();
//    }
//   
//    @Test
//    @WithTagValuesOf({"block:Instruments", "page:Links Rotator Get Code", "role:Webmaster"})
//    public void test_links_rotator_get_code() throws Exception{
//         Constants cons = new Constants();
//        String linksRotatorPreviewTestName = cons.getRandomIntNumber();
//        String code;
//        
//        
//        wmName = steps.get_wm_name(con);
//        steps.wm_login(wmName);
//        steps.click_instruments_link();
//        steps.click_rotators_link();
//        steps.click_links_rotator_link();
//        steps.click_create_button();
//        steps.check_fatal_errors();
//        steps.check_add_form_is_displayed();
//        //form fill
//        steps.fill_name_input(linksRotatorPreviewTestName);
//        steps.fill_subaccount_input(linksRotatorPreviewTestName);
//        steps.check_banner_type_checkboxes_are_visible();
//        steps.click_img_type_banner_checkbox();
//        //multiselects
//        steps.click_i_multiselect_button(0);
//        steps.click_some_elements_in_popup_list(0);
//        steps.click_i_multiselect_button(1);
//        steps.click_some_elements_in_popup_list(1);
//        steps.fill_max_banners_size(wmLinksRotatorMaxBanners);
//        steps.fill_max_offers_size(wmLinksRotatorMaxOffers);
//        steps.submit_form();  
//        steps.waitForAjax(2000);
//        steps.check_blue_table_has_lines();
//        steps.sort_blue_table_by_id();
//        steps.click_icon_in_blue_table_first_line(1);
//        steps.waitForAjax(2000);
//        //get code
//        //js
//        code = steps.get_code();
//        steps.check_code(code);
//        steps.click_select_choose();
//        steps.select_javascript_code();
//        steps.check_code(code);
//        //xml
//        steps.click_select_choose();
//        steps.select_xml_code();
//        code = steps.get_code();
//        steps.check_xml_code(code);
//        //ajs
//        steps.click_select_choose();
//        steps.select_ajs_code();
//        code = steps.get_code();
//        steps.check_code(code);        
//        
//        steps.close_browser();
//}
        
    

 
    

    
} 