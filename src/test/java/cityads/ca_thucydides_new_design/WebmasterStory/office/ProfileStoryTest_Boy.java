package cityads.ca_thucydides_new_design.WebmasterStory.office;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.ProfileSteps;
import java.sql.Connection;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTagValuesOf;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.Profile.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class ProfileStoryTest_Boy extends Constants {

     public Connection con;
     public String wmName;
     private String randomIcq = getRandomIcqNumber();
     private String randomString1 = getRandomString(); 
     private String randomString2 = getRandomString(); 
     private String randomString3 = getRandomString(); 
     boolean newsState;
     boolean productState;
     boolean offerState;
     boolean techNewsState;
     boolean newsState2;
     boolean productState2;
     boolean offerState2;
     boolean techNewsState2;
     private String countValueActual;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;
    
    @Steps
    public ProfileSteps steps;
    
 
    @Test @WithTagValuesOf({"block:Office", "role:Webmaster"})  
    public  void profile_test_personal_info() throws Exception{

        
        wmName = steps.get_wm_name();

        steps.wm_login(wmName);
        steps.click_profile_link_boy();
        steps.check_fatal_errors();
       
        steps.waitAjax(8000);
        steps.fill_wm_profile_name(randomString1);
       
        steps.fill_wm_profile_phone(wmProfileMobile);
       
//      steps.fill_wm_profile_icq(randomIcq);

        steps.fill_wm_profile_top20(randomString2);
       
        steps.fill_wm_profile_skype(randomString3);
       
        steps.click_submit_ok();
        steps.waitAjax(8000);
        steps.check_fatal_errors();
        steps.check_profile_name_is_saved(randomString1);
        steps.check_profile_skype_is_saved(randomString3);
//        steps.check_profile_icq_is_saved(randomIcq);
        steps.check_profile_top20_is_saved(randomString2);
        steps.close_browser();
    }
    
    @Test @WithTagValuesOf({"block:Office", "role:Webmaster"}) 
    public void profile_test_billing_info() throws Exception{
        
        wmName = steps.get_wm_name();
        steps.wm_login(wmName);
        steps.check_fatal_errors();
        steps.click_profile_link_boy();
        steps.waitAjax(2000);
        steps.check_fatal_errors();
        steps.click_profile_billing_tab();
        steps.waitAjax(5000);
            
            
        if(!steps.check_if_second_tab_has_warning()){

            steps.check_fatal_errors();
            steps.fill_wm_profile_count_number(wmProfileTab2CountNumber);
            steps.select_currency_in_profile(wmProfileCurrency);
            steps.submit_profile_tab2();
            steps.close_browser();
           
            steps.wm_login(wmName);
            steps.check_fatal_errors();
            steps.click_profile_link_boy();
            steps.waitAjax(2000);
            steps.check_fatal_errors();
            steps.click_profile_billing_tab();
            steps.waitAjax(5000);
           
            if(!steps.check_if_second_tab_has_warning()){countValueActual = steps.get_billing_count();
            steps.check_saved_count_value(wmProfileTab2CountNumber,countValueActual);}
        }

        steps.close_browser();
    }
    
    @Test @WithTagValuesOf({"block:Office", "role:Webmaster"})  
    public void profile_test_notifications_info() throws Exception{
        
   

        
        wmName = steps.get_wm_name();
        steps.wm_login(wmName);
        steps.check_fatal_errors();
        steps.click_profile_link_boy();
        steps.check_fatal_errors();
        
        steps.click_profile_notofication_tab();
        steps.waitAjax(8000);
        steps.check_fatal_errors();
        //steps.check_your_manager_block_are_displayed();

        
       boolean checkBox1State1 = steps.get_1_checkbox_state();
       boolean checkBox2State1 = steps.get_2_checkbox_state();
       boolean checkBox3State1 = steps.get_3_checkbox_state();
       boolean checkBox4State1 = steps.get_4_checkbox_state();
       boolean checkBox5State1 = steps.get_5_checkbox_state();
       boolean checkBox6State1 = steps.get_6_checkbox_state();
       boolean checkBox7State1 = steps.get_7_checkbox_state();

        
        steps.click_all_checkboxes();
       
        steps.submit_profile_tab3();
        steps.waitAjax(8000);
       
        
        
       boolean checkBox1State2 = steps.get_1_checkbox_state();
       boolean checkBox2State2 = steps.get_2_checkbox_state();
       boolean checkBox3State2 = steps.get_3_checkbox_state();
       boolean checkBox4State2 = steps.get_4_checkbox_state();
       boolean checkBox5State2 = steps.get_5_checkbox_state();
       boolean checkBox6State2 = steps.get_6_checkbox_state();
       boolean checkBox7State2 = steps.get_7_checkbox_state();

    
        
        
        steps.check_checkbox_status_has_changed(checkBox1State1, checkBox1State2);
        steps.check_checkbox_status_has_changed(checkBox2State1, checkBox2State2);
        steps.check_checkbox_status_has_changed(checkBox3State1, checkBox3State2);
        steps.check_checkbox_status_has_changed(checkBox4State1, checkBox4State2);
        steps.check_checkbox_status_has_changed(checkBox5State1, checkBox5State2);
        steps.check_checkbox_status_has_changed(checkBox6State1, checkBox6State2);
        steps.check_checkbox_status_has_changed(checkBox7State1, checkBox7State2);
 
        
        steps.check_fatal_errors();
        steps.close_browser();
    }
    
    
    
 
    

    
} 