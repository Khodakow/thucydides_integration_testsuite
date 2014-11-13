package cityads.ca_thucydides_new_design.WebmasterStory.translate.eng;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.pages.WemasterPages.MainSitePage;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.MainSiteSteps;
import cityads.ca_thucydides_new_design.steps.SetupSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.BugsSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.ProfileSteps;
import java.sql.Connection;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTagValuesOf;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.Translate.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class MainPageCareerEngStoryTest extends Constants {

    public String wmName;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;


    @Steps
    MainSiteSteps steps;
    
    @Test @Pending
    @WithTagValuesOf({"block:Traslation","role:Webmaster"})
    public void check_mainpage_career_eng_translation(){

        steps.open_main_page();
        steps.waitABit(10000);
        
        steps.click_career_link();
        steps.waitAjax(10000);
        
        steps.select_en_language();
        steps.check_lang_select();
        steps.waitAjax(10000);
        steps.remove_html_from_blue_table();
        steps.waitAjax(1000);
        steps.select_en_language();
        steps.check_lang_select();

    }
    

    
   
} 