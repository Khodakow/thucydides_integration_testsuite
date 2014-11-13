package cityads.ca_thucydides_new_design.WebmasterStory.translate.eng;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.pages.WemasterPages.MainSitePage;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.MainSiteSteps;
import cityads.ca_thucydides_new_design.steps.SetupSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.BugsSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.GoodsCatalogSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.ProfileSteps;
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
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.Translate.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class CategoriesEngStoryTest extends Constants {

    public String wmName;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;


    @Steps
    GoodsCatalogSteps steps;

    
    @Test
    @WithTagValuesOf({"block:Traslation","role:Webmaster"})
    public void check_categories_translation(){
        
        wmName = steps.get_wm_name();
        steps.wm_login(wmName);
        steps.click_goods_and_coupons_link();
        steps.wait_for_all_spinners_dissapears(30);
        steps.click_goods_link();
        steps.wait_for_all_spinners_dissapears(30);
        steps.click_categories_link();
        steps.waitAjax(2000);
        steps.wait_for_all_spinners_dissapears(60);
        steps.change_lang_to_en();
        steps.wait_for_all_spinners_dissapears(60);
        steps.click_all_closed_categories();
        steps.check_lang_select();
        
    }


    
   
} 