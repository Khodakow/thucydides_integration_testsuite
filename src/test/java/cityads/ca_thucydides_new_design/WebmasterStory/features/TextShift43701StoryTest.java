package cityads.ca_thucydides_new_design.WebmasterStory.features;

import cityads.ca_thucydides_new_design.pages.refactor.DataGenerator;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.BaseSteps;
import cityads.ca_thucydides_new_design.steps.MainSiteSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.*;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.TextShift.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class TextShift43701StoryTest {

    public String wmName;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public BaseSteps baseSteps;

    @Steps
    public MainSiteSteps steps;

    @Steps
    public TableSteps table;

    @Steps
    public CarcasSteps carcas;

    @Steps
    public FormSteps form;

    @Steps
    public FrontSteps front;

    @Steps
    public AccountSteps account;

    @Steps
    public TextShiftSteps textShift;


    @After
    public void tearDown(){
        steps.close_browser();
    }



    @Test//@Screenshots(onlyOnFailures=false)
    public void textShiftSaveTest() throws Exception{

        String name = DataGenerator.getRandomNameWithDate();
        String subacc = DataGenerator.getRandomNameWithDate();

        front.login();
        carcas.go_to_text_shift();
        form.create_form();
        textShift.create_text_shift(name, subacc);
        table.check_table_has_text(name);
        steps.check_fatal_errors();

    }

    @Test
    public void textShiftGetCodeTest() throws Exception{

        String name = DataGenerator.getRandomNameWithDate();
        String subacc = DataGenerator.getRandomNameWithDate();

        front.login();
        carcas.go_to_text_shift();
        form.create_form();
        textShift.create_text_shift_and_check_code(name, subacc);

    }




} 