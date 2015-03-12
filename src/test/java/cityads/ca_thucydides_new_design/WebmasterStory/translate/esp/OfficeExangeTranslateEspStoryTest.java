package cityads.ca_thucydides_new_design.WebmasterStory.translate.esp;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.SetupSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.BugsSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.ProfileSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.CarcasSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FrontSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.Translate.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class OfficeExangeTranslateEspStoryTest {

    public String wmName;



    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public BugsSteps bs;

    @Steps
    public ProfileSteps profile;

    @Steps
    public FrontSteps front;

    @Steps
    public SetupSteps ss;

    @Steps
    public CarcasSteps carcas;


    @Test
    @WithTagValuesOf({"block:Traslation","role:Webmaster"})
    @Title("Курс обмена esp переводы")
    public void checkOfficeExangeEspTranslation(){
        front.login();
        carcas.go_to_exchange();
        bs.change_lang_to_es();
        bs.check_lang_select();
        bs.close_browser();
    }

} 