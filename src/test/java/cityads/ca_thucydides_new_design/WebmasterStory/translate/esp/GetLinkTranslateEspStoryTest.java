package cityads.ca_thucydides_new_design.WebmasterStory.translate.esp;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.SetupSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.BugsSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.CarcasSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FormSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FrontSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.GetLinkSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.Translate.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class GetLinkTranslateEspStoryTest {



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

    @Steps
    public GetLinkSteps getLink;

    @Steps
    public SetupSteps steps;

    @Steps
    public FormSteps form;

    @Before
    public void setUp(){
        front.login();
        carcas.go_to_getlink();
        steps.change_lang_to_es();
    }


    @Test
    @WithTagValuesOf({"block:Traslation","role:Webmaster"})
    @Title("Гетлинк переводы esp попап")
    public void getLinkPopupEspTranslation(){
        form.create_form();
        getLink.click_parameters_in_retarget();
        steps.check_lang_select();
    }

    @Test
    @WithTagValuesOf({"block:Traslation","role:Webmaster"})
    @Title("Гетлинк переводы esp создание")
    public void getLinkCreateEspTranslation(){
        form.create_form();
        steps.executeScript("$('table[id=\"backurlTable\"]>tbody>tr>td[data-name=\"actionName\"]').remove()");
        steps.executeScript("$('table[id=\"retargetTable\"]>tbody>tr>td[data-name=\"actionName\"]').remove()");
        steps.check_lang_select();
    }

    @Test
    @WithTagValuesOf({"block:Traslation","role:Webmaster"})
    @Title("Гетлинк переводы esp таблица")
    public void getLinkEspTranslation(){
        steps.check_lang_select();
    }

} 