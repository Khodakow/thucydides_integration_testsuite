package cityads.ca_thucydides_new_design.WebmasterStory.translate;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.OfferCardSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.Translate.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class TooltipsWebOffersTranslateStoryTest extends Constants {



    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;
   
    
    @Steps
    public OfferCardSteps steps;

    
   @Test
   @Title("Подсказки веб-офферы переводы")
   @WithTagValuesOf({"block:Traslation","role:Webmaster"})
    public void check_web_offers_tooltips_translate(){
    String wmName = steps.get_wm_name();  
    steps.wm_login(wmName);
    steps.click_offer_link();
    steps.wait_for_all_spinners_dissapears(60);
    steps.change_lang_to_br();
    steps.wait_for_all_spinners_dissapears(60);
    steps.wait_for_blue_table_appears(30);
    steps.fill_in_search_filter("21321321313");
    steps.waitABit(500);
    steps.check_all_tooltips_translate();

    steps.close_browser();
   }
  
} 