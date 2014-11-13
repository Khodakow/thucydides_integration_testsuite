package cityads.ca_thucydides_new_design.WebmasterStory.translate.eng;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.BaseSteps;
import cityads.ca_thucydides_new_design.steps.SetupSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.BugsSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.OfferCardSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.OfferListSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.ProfileSteps;
import java.sql.Connection;

import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.Translate.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class TooltipsOfferToolsEngStoryTest extends Constants {

    private String offerName;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;
   
    
    @Steps
    public OfferCardSteps steps;

    
   @Test@Pending
   @WithTagValuesOf({"block:Traslation","role:Webmaster"})
    public void check_offer_tool_tooltips_translate(){
    String wmName = steps.get_wm_name();  
    steps.wm_login(wmName);
    steps.click_offer_link();
    steps.wait_for_all_spinners_dissapears(60);
    
    
    
    offerName = steps.get_first_offer_name();
    steps.click_first_offer();
   steps.wait_for_all_spinners_dissapears(30);
    steps.wait_for_h1_title_appears(offerName, 160);
    steps.check_h1_page_title(offerName);



    steps.click_offer_instruments_tab_by_id();
    steps.wait_for_all_spinners_dissapears(30);
    steps.waitAjax(5000);
    steps.check_fatal_errors();
    
    
    
    steps.change_lang_to_en();
    steps.wait_for_all_spinners_dissapears(60);
    steps.wait_for_blue_table_appears(30);

    steps.check_all_tooltips_translate();

    
    
    
    
    
    
    steps.close_browser();
   }
  
} 