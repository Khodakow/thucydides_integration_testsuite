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
public class HelpEngTranslateStoryTest {

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
        help.change_lang_to_en();
    }


    @Test
    @Title("Хелп переводы АНГЛ Beginning your work")
    @WithTagValuesOf({"block:Traslation","role:Webmaster"})
    public void helpTranslation(){
        setup.check_lang_select();
    }

    @Test
    @Title("Хелп переводы  АНГЛ  Registration with Cityads")
    @WithTagValuesOf({"block:Traslation","role:Webmaster"})
    public void helpTranslationreg(){
        help.go_to_registration();
        setup.check_lang_select();
    }

    @Test
    @Title("Хелп переводы АНГЛ First setting up Cityads account")
    @WithTagValuesOf({"block:Traslation","role:Webmaster"})
    public void helpTranslationAcc(){
        help.go_to_acc();
        setup.check_lang_select();
    }

    @Test
    @Title("Хелп переводы АНГЛ Publisher's interface CityAds")
    @WithTagValuesOf({"block:Traslation","role:Webmaster"})
    public void helpTranslationPub(){
        help.go_to_pub();
        setup.check_lang_select();
    }

    @Test
    @Title("Хелп переводы АНГЛ Section «Offers»")
    @WithTagValuesOf({"block:Traslation","role:Webmaster"})
    public void helpTranslationOffers(){
        help.go_to_offers();
        setup.check_lang_select();
    }

    @Test
    @Title("Хелп переводы АНГЛ Section «Statistics»")
    @WithTagValuesOf({"block:Traslation","role:Webmaster"})
    public void helpTranslationStat(){
        help.go_to_stat();
        setup.check_lang_select();
    }

    @Test
    @Title("Хелп переводы АНГЛ Section «Tools»")
    @WithTagValuesOf({"block:Traslation","role:Webmaster"})
    public void helpTranslationTools(){
        help.go_to_tools();
        setup.check_lang_select();
    }

    @Test
    @Title("Хелп переводы АНГЛ Section «Products and coupons»")
    @WithTagValuesOf({"block:Traslation","role:Webmaster"})
    public void helpTranslationCoupons(){
        help.go_to_coup();
        setup.check_lang_select();
    }

} 