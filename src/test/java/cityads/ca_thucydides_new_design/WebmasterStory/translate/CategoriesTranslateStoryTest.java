package cityads.ca_thucydides_new_design.WebmasterStory.translate;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.GoodsCatalogSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.Translate.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class CategoriesTranslateStoryTest extends Constants {

    public String wmName;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;


    @Steps
    GoodsCatalogSteps steps;

    
    @Test
    @Title("Категории купонов переводы")
    @WithTagValuesOf({"block:Traslation","role:Webmaster"})
    public void check_categories_translation(){
        
        wmName = steps.get_wm_name();
        steps.wm_login(wmName);
        steps.click_goods_and_coupons_link();
        steps.wait_for_all_spinners_dissapears(30);
        steps.click_goods_link();
        steps.wait_for_all_spinners_dissapears(30);
        steps.click_categories_link(); 
        steps.wait_for_all_spinners_dissapears(60);
        steps.change_lang_to_br();
        steps.wait_for_all_spinners_dissapears(60);
        steps.click_all_closed_categories();
        steps.check_lang_select();
        
    }


    
   
} 