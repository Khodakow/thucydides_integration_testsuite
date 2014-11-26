package cityads.ca_thucydides_new_design.WebmasterStory.translate;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.MainSiteSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.Translate.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class MainPageTranslateStoryTest extends Constants {

    public String wmName;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    MainSiteSteps steps;
    
    @Test
    @Title("Корп сайт переводы")
    @WithTagValuesOf({"block:Traslation","role:Webmaster"})
    public void check_mainpage_translation(){

        steps.open_main_page();
        steps.select_pt_language();
        steps.waitABit(8000);
        steps.scroll_to_bottom();
        steps.remove_html_from_blue_table();  //чтобы не вылетало на прокерке имен вебмастеров на главной
        steps.check_lang_select();

    }
    
    @Test
    @Title("Корп сайт  емаил платформа переводы")
    @WithTagValuesOf({"block:Traslation","role:Webmaster"})
    public void check_email_platform_translation(){

        steps.open_main_page();
        steps.click_footer_email_platform_link();
        steps.select_pt_language();
        steps.check_lang_select();
        steps.close_browser();

    }
    
    @Test
    @Title("Корп сайт аналитика  переводы")
    @WithTagValuesOf({"block:Traslation","role:Webmaster"})
    public void check_analytics_translation(){

        steps.open_main_page();
        steps.click_footer_analytics_platform();
        steps.waitABit(5000);
        steps.select_pt_language();
        steps.check_lang_select();
        steps.close_browser();

    }
    
    
   
} 