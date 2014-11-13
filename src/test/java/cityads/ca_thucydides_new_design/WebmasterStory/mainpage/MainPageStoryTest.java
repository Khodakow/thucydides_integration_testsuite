package cityads.ca_thucydides_new_design.WebmasterStory.mainpage;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.SvodnayaSteps;
import cityads.ca_thucydides_new_design.steps.MainSiteSteps;
import java.sql.Connection;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTagValuesOf;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.CorporateSite.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="corporate site")
public class MainPageStoryTest extends Constants {

    public Connection con;
    public String wmName;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @After
    public void shut_down_driver_process(){
        steps.close_browser();
    }
    
    @Steps
    public MainSiteSteps steps;
    
    @Test
    public void test_main_site_control_panel() throws Exception{
 
        steps.open_main_page();
        steps.select_ru_language();
        steps.waitABit(3000);
        steps.check_fatal_errors();
        steps.waitABit(3000);
        steps.check_home_big_banner_is_present();
        steps.waitABit(3000);
        steps.click_colntrol_panel_link();
        steps.check_fatal_errors();
       
        steps.click_platform_link();
        steps.waitABit(3000);
        steps.check_links_are_present_in_platform_page();
        steps.waitABit(3000);
        steps.click_colntrol_panel_link();
        //steps.check_fatal_errors();
        steps.waitABit(3000);
        steps.close_browser();
        
        
    }
    
    @Test 
    public void test_main_site_analitics() throws Exception{
 
        steps.open_main_page();
        steps.select_ru_language();
       
        steps.check_home_big_banner_is_present();
        
        steps.click_analitic_link();
       
        steps.check_fatal_errors();
       
       
        
        steps.click_platform_link();
       
        steps.check_links_are_present_in_platform_page();
        steps.click_analitic_link();
       
        steps.check_fatal_errors();
       
       
        steps.close_browser();
        
        
    }
    
    @Test 
    public void test_live_product_base() throws Exception{
 
        steps.open_main_page();
        steps.select_ru_language();
       
        steps.check_home_big_banner_is_present();
        
        steps.click_live_product_base_link();
        steps.check_fatal_errors();
       
       
        
        steps.click_platform_link();
       
        steps.check_links_are_present_in_platform_page();
        steps.click_live_product_base_link();
       
        steps.check_fatal_errors();
       
       
        steps.close_browser();
        
        
    }
    
    @Test 
    public void test_recommend_system() throws Exception{
 
        steps.open_main_page();
        steps.select_ru_language();
       
        steps.check_home_big_banner_is_present();
        
        steps.click_recommend_system_link();
       
        steps.check_fatal_errors();
       
       
        
        steps.click_recommend_system_link();
       
        steps.check_links_are_present_in_platform_page();
        steps.click_recommend_system_link();
       
        steps.check_fatal_errors();
       
       
        steps.close_browser();
        
        
    }
    
    @Test 
    public void test_data_Management() throws Exception{
 
        steps.open_main_page();
        steps.select_ru_language();
       
        steps.check_home_big_banner_is_present();
        
        steps.click_data_management_link();
       
        steps.check_fatal_errors();
       
       
        
        steps.click_data_management_link();
        steps.check_links_are_present_in_platform_page();
        steps.click_data_management_link();
       
        steps.check_fatal_errors();
       
       
        steps.close_browser();
        
        
    }
    
   @Test 
    public void test_dimamic_optimisation() throws Exception{
 
        steps.open_main_page();
        steps.select_ru_language();
       
        steps.check_home_big_banner_is_present();
        
        steps.click_dinamic_optimization_link();
       
        steps.check_fatal_errors();
       
       
        
        steps.click_dinamic_optimization_link();
       
        steps.check_links_are_present_in_platform_page();
       
        steps.click_dinamic_optimization_link();
        //steps.waitForAjax();
        steps.check_fatal_errors();
       
       
        steps.close_browser();
        
        
    }
    
    @Test 
    public void test_email_platform() throws Exception{
 
        steps.open_main_page();
        steps.select_ru_language();
       
        steps.check_home_big_banner_is_present();
        
        steps.click_email_platform_link();
       
        steps.check_fatal_errors();
       
       
        
        steps.click_email_platform_link();
       
        steps.check_links_are_present_in_platform_page();
        steps.click_email_platform_link();
       
        steps.check_fatal_errors();
       
       
        steps.close_browser();
        
        
    }
    

    @Test 
    public void test_main_page_for_fatal_errors() throws Exception{
 
        steps.open_main_page();
        int n = steps.get_conversion_on_main_page();    
        steps.check_value_gteater_then_min(n, 0);
        steps.check_home_big_banner_is_present();
        steps.check_fatal_errors();
        steps.close_browser();
        
        
    }
   


} 