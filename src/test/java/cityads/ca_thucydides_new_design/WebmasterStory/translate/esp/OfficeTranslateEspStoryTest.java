package cityads.ca_thucydides_new_design.WebmasterStory.translate.esp;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.SetupSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.BugsSteps;
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
public class OfficeTranslateEspStoryTest {

    public String wmName;


    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public BugsSteps bs;

    @Steps
    public FrontSteps front;

    @Steps
    public SetupSteps ss;

    @Steps
    public CarcasSteps carcas;


    @Test
    @WithTagValuesOf({"block:Traslation","role:Webmaster"})
    @Title("Офис esp  переводы")
    public void checkOfficeEspTranslation(){
        front.login();
        bs.change_lang_to_es();
        bs.wait_for_all_spinners_dissapears();
        bs.check_lang_select();
        bs.close_browser();
    }

} 