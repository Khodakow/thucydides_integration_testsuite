package cityads.ca_thucydides_new_design.WebmasterStory.translate.br;

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
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.sql.Connection;


@Story(TestSuite.WebMaster.Translate.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class TextShiftCreateToolTranslateStoryTest{

    public Connection con;
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
    public SetupSteps ss;
    @Steps
    public CarcasSteps carcas;
    @Steps
    public FrontSteps front;
    @Steps
    public FormSteps form;

    @Steps
    public TextShiftSteps textShift;



    @Test
    @Title("создание текстшифта переводы")
    public void checkToolsCreationTextshiftTranslation(){

        front.login("/webmaster_pro/tools/feeds/text_shift_434161042.0.htm?id=434161042.0");
        bs.change_lang_to_br();
        form.create_form();
        bs.wait_for_all_spinners_dissapears(30);
        bs.check_lang_select();

    }

    @Test
    @Title("Тест на перводы Text Shift в части popup из таблицы")
    public void checkToolsCreatedTextshiftTranslation(){
        String name = DataGenerator.getRandomNameWithDate();
        String subacc = DataGenerator.getRandomNameWithDate();

        front.login("/webmaster_pro/tools/feeds/text_shift_434161042.0.htm?id=434161042.0");
        bs.change_lang_to_br();
        form.create_form();
        bs.wait_for_all_spinners_dissapears();
        textShift.create_text_shift(name, subacc);
        bs.wait_for_all_spinners_dissapears();
        bs.refresh_page();
        bs.wait_for_all_spinners_dissapears();
        textShift.get_text_shift_code_from_table_java_script();
        bs.check_lang_select();

    }

    @Test
    public void checkToolsCreatedExtensionCodePopupTextshiftTranslation(){
        String name = DataGenerator.getRandomNameWithDate();
        String subacc = DataGenerator.getRandomNameWithDate();

        front.login("/webmaster_pro/tools/feeds/text_shift_434161042.0.htm?id=434161042.0");
        bs.change_lang_to_br();
        form.create_form();
        textShift.create_text_shift(name, subacc);
        bs.wait_for_all_spinners_dissapears();
        bs.refresh_page();
        bs.wait_for_all_spinners_dissapears();
        textShift.get_text_shift_code_from_table_extensions();
        bs.check_lang_select();
    }



} 