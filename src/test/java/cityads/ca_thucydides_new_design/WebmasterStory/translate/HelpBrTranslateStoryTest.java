package cityads.ca_thucydides_new_design.WebmasterStory.translate;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.SetupSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.CarcasSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.HelpDocsSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.sql.Connection;


@Story(TestSuite.WebMaster.Translate.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class HelpBrTranslateStoryTest {

    public Connection con;
    public String wmName;
    protected String AJSCode;
    protected String JSCode;



    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    Pages pages;

    @Steps
    SetupSteps setup;

    @Steps
    CarcasSteps carcas;

    @Steps
    SetupSteps ss;

    @Steps
    HelpDocsSteps help;


    @Before
    public void setUp(){
        carcas.go_to_help();
        help.change_lang_to_br();
    }


    @Test
    @Title("Хелп переводы БР Beginning your work")
    @WithTagValuesOf({"block:Traslation","role:Webmaster"})
    public void helpTranslationBr(){
        setup.check_lang_select();
    }

    @Test
    @Title("Хелп переводы БР Registration with Cityads")
    @WithTagValuesOf({"block:Traslation","role:Webmaster"})
    public void helpTranslationregBr(){
        help.go_to_registration();
        setup.check_lang_select();
    }

    @Test
    @Title("Хелп переводы БР First setting up Cityads account")
    @WithTagValuesOf({"block:Traslation","role:Webmaster"})
    public void helpTranslationAccBr(){
        help.go_to_acc();
        setup.check_lang_select();
    }

    @Test
    @Title("Хелп переводы БР Publisher's interface CityAds")
    @WithTagValuesOf({"block:Traslation","role:Webmaster"})
    public void helpTranslationPubBr(){
        help.go_to_pub();
        setup.check_lang_select();
    }

    @Test
    @Title("Хелп переводы БР Section «Offers»")
    @WithTagValuesOf({"block:Traslation","role:Webmaster"})
    public void helpTranslationOffersBr(){
        help.go_to_offers();
        setup.check_lang_select();
    }

    @Test
    @Title("Хелп переводы БР Section «Statistics»")
    @WithTagValuesOf({"block:Traslation","role:Webmaster"})
    public void helpTranslationStatBr(){
        help.go_to_stat();
        setup.check_lang_select();
    }

    @Test
    @Title("Хелп переводы БР Section «Tools»")
    @WithTagValuesOf({"block:Traslation","role:Webmaster"})
    public void helpTranslationToolsBr(){
        help.go_to_tools();
        setup.check_lang_select();
    }

    @Test
    @Title("Хелп переводы БР Section «Products and coupons»")
    @WithTagValuesOf({"block:Traslation","role:Webmaster"})
    public void helpTranslationCouponsBr(){
        help.go_to_coup();
        setup.check_lang_select();
    }

} 