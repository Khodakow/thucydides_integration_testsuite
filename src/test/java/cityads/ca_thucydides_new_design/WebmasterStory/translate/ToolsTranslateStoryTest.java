package cityads.ca_thucydides_new_design.WebmasterStory.translate;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.OfferListSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.CarcasSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.sql.Connection;


@Story(TestSuite.WebMaster.Translate.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class ToolsTranslateStoryTest extends Constants {

     public Connection con;

     
    

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public OfferListSteps steps;

    @Steps
    public CarcasSteps carcas;


   
   @Test
   @Title("Инструменты переводы")
   @WithTagValuesOf({"block:Traslation","role:Webmaster"})
    public void checkToolsTranslation(){
        String wmName = steps.get_wm_name();  
        steps.wm_login(wmName);
        steps.wait_for_all_spinners_dissapears(30);
        carcas.go_to_banner_rotator();
        steps.wait_for_all_spinners_dissapears(30);
        steps.change_lang_to_br();
        steps.check_lang_select();
        steps.close_browser();
   }

    @Test
    @Title("Текс шифт переводы")
    @WithTagValuesOf({"block:Traslation","role:Webmaster"})
    public void checkTextShiftMainPageTranslation(){
        String wmName = steps.get_wm_name();
        steps.wm_login(wmName);
        steps.wait_for_all_spinners_dissapears(30);
        steps.click_instruments_link();
        steps.wait_for_all_spinners_dissapears(30);
        steps.change_lang_to_br();
        steps.check_lang_select();
        steps.close_browser();
    }

} 