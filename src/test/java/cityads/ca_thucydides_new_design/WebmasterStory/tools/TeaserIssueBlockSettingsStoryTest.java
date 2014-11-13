package cityads.ca_thucydides_new_design.WebmasterStory.tools;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.BannerRotatorSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.TeaserIssueBlockSettingsSteps;
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




@Story(TestSuite.WebMaster.TeaserIssueBlockSettings.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class TeaserIssueBlockSettingsStoryTest extends Constants {

     private Connection con;
     private String wmName;
     private String teaserIssueName = getCurrentDate();
     private int blockNumerVertical = 2;
     private int blockNumberHorizontal = 3;
     private String teaserIssueAge;
     private String teaserIssueCategory;
     private String teaserIssueAgeActual;
     private String teaserIssueCtegoryActual;
     private String hexColor = "000000";
     
     
    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public TeaserIssueBlockSettingsSteps steps;
    
    
    @Test
    @WithTagValuesOf({"block:Instruments","role:Webmaster"})
    public void wm_teaser_issue_block_settings_test() throws Exception{
       
        
        wmName = steps.get_wm_name();
        steps.wm_login(wmName);
        steps.click_instruments_link();
        steps.click_teaser_issue_link();
        steps.check_fatal_errors();
       ;
       
        steps.click_create_button();
        steps.scroll_to_preview_container();
        steps.check_fatal_errors();
        steps.click_teaser_issue_block_settings();
       
        
        //number
        steps.fill_block_number_vertical(blockNumerVertical);
        steps.fill_block_number_horizontal(blockNumberHorizontal);

        steps.click_apply_filter_button();
       
        steps.waitAjax(8000);
        steps.check_number_of_teasers_in_preview(blockNumerVertical, blockNumberHorizontal,blockNumerVertical*blockNumberHorizontal);
        steps.check_fatal_errors();
        
        //color
        steps.fill_background_color_input(hexColor);
        steps.click_apply_filter_button();
        steps.check_fatal_errors();
        steps.fill_background_color_onhover_input(hexColor);
        steps.click_apply_filter_button();
        steps.check_fatal_errors();
        
        
        steps.close_browser();
        
    }
   
    
 
    

    
} 