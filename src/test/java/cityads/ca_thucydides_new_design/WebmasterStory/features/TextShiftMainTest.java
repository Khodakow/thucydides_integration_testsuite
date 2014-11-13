package cityads.ca_thucydides_new_design.WebmasterStory.features;

import cityads.ca_thucydides_new_design.pages.refactor.DataGenerator;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.BannerTestSteps;
import cityads.ca_thucydides_new_design.steps.SetupSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.*;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.apache.commons.lang3.StringEscapeUtils;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.TextShift.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class TextShiftMainTest {

    public String wmName;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public SetupSteps steps;
    @Steps
    public TableSteps table;
    @Steps
    public CarcasSteps carcas;
    @Steps
    public FormSteps form;
    @Steps
    public FrontSteps front;
    @Steps
    public BannerTestSteps test;
    @Steps
    public TextShiftSteps textShift;
    @Steps
    public ConsoleSteps console;


    @After
    public void tearDown(){
        steps.close_browser();
    }



    @Test@Screenshots(onlyOnFailures = false)
    public void textShiftMainTest() throws Exception{

        String name = DataGenerator.getRandomNameWithDate();
        String subacc = DataGenerator.getRandomNameWithDate();
        String code;

        front.login();
        carcas.go_to_text_shift();
        form.create_form();
        code = textShift.create_text_shift_and_check_code(name, subacc);
        test.check_shift(StringEscapeUtils.escapeHtml4(code));
        steps.waitABit(5000);
        String hostOld = steps.get_curent_domain_name();
        steps.switch_to_last_window();
        steps.waitABit(5000);
        String hostNew = steps.get_curent_domain_name();
        steps.check_string_has_changed(hostOld,hostNew);




    }




} 