package cityads.ca_thucydides_new_design.WebmasterStory.translate;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.pages.refactor.DataGenerator;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.SetupSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.BugsSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.ProfileSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.CarcasSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FormSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FrontSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.TextShiftSteps;
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
public class TextShiftCreateToolTranslateStoryTest extends Constants {

    public Connection con;
    public String wmName;
    public String rotatorName = getCurrentDate();
    private String  bannerSize1;
    private String  bannerSize2;
    private String  bannerSize3;
    protected String AJSCode;
    protected String JSCode;



    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public BugsSteps bs;

    @Steps
    public ProfileSteps profile;

    @Steps
    public SetupSteps ss;
    @Steps
    public CarcasSteps carcas;
    @Steps
    public FrontSteps front;
    @Steps
    public FormSteps form;

    @Steps
    public TextShiftSteps textShift;


    @Before
    public void setUp(){
        front.login();
        bs.change_lang_to_br();
        bs.wait_for_all_spinners_dissapears();
        carcas.go_to_text_shift();
    }




    @Test
    @Title("создание текстшифта переводы")
    @WithTagValuesOf({"block:Traslation","role:Webmaster"})
    public void checkToolsCreationTextshiftTranslation(){

        form.create_form();
        bs.wait_for_all_spinners_dissapears(30);
        bs.check_lang_select();

    }

    //@Test
    @Title("Тест на перводы Text Shift в части popup из таблицы")
    @WithTagValuesOf({"block:Traslation","role:Webmaster"})
    public void checkToolsCreatedTextshiftTranslation(){
        String name = DataGenerator.getRandomNameWithDate();
        String subacc = DataGenerator.getRandomNameWithDate();

        form.create_form();
        textShift.create_text_shift(name, subacc);
        bs.wait_for_all_spinners_dissapears();
        bs.refresh_page();
        bs.wait_for_all_spinners_dissapears();
        textShift.get_text_shift_code_from_table_java_script();
        bs.check_lang_select();

    }

    //@Test
    @WithTagValuesOf({"block:Traslation","role:Webmaster"})
    public void checkToolsCreatedExtensionCodePopupTextshiftTranslation(){
        String name = DataGenerator.getRandomNameWithDate();
        String subacc = DataGenerator.getRandomNameWithDate();

        form.create_form();
        textShift.create_text_shift(name, subacc);
        bs.wait_for_all_spinners_dissapears();
        bs.refresh_page();
        bs.wait_for_all_spinners_dissapears();
        textShift.get_text_shift_code_from_table_extensions();
        bs.check_lang_select();
    }



} 