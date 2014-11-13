package cityads.ca_thucydides_new_design.WebmasterStory.office;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.BannerRotatorSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.MyDomainsSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.StatisticSteps;
import java.sql.Connection;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
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


@Story(TestSuite.WebMaster.MyDomains.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class MyDomainsStoryTest extends Constants {

     public Connection con;
     public String wmName;
     public String domainName = getRandomIntNumber()+".ru";
     public String actualDomainName;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public MyDomainsSteps steps;
    
    @After
    public void shut_down_driver_process(){
        steps.close_browser();
    }
    
    @Test
    @WithTagValuesOf({"block:Office", "role:Webmaster"})
    public void my_domains_test() throws Exception{
       
        
        
        wmName = steps.get_wm_name();
        steps.wm_login(wmName);
        steps.click_Office_link();
        steps.check_fatal_errors();
        steps.click_profile_link();
        steps.click_my_domains_link();
        steps.check_fatal_errors();
       ;
       
        steps.check_blue_table_is_visible();
        steps.click_create_button();
        steps.check_fatal_errors();
        steps.check_popup_is_displayed();
        steps.fill_domain_field(domainName);
        steps.click_apply_button();
       
        steps.check_blue_table_has_lines();
        steps.Sort_blue_table_by_first_th();
        steps.check_fatal_errors();
        actualDomainName = steps.get_domain_name_in_first_record_in_blue_table();
        steps.check_first_string_in_blue_table_has_domain_name(domainName, actualDomainName);
        
        steps.close_browser();
        
        
    }
    
 
    

    
} 