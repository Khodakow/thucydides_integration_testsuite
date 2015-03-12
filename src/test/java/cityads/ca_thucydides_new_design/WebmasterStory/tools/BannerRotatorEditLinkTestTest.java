package cityads.ca_thucydides_new_design.WebmasterStory.tools;

import cityads.ca_thucydides_new_design.pages.refactor.DataGenerator;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.BannerTestSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.BannerRotatorSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.*;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.apache.commons.lang3.StringEscapeUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.BannersRotator.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class BannerRotatorEditLinkTestTest {

    public String wmName;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public BannerRotatorSteps steps;

    @Steps
    public CarcasSteps carcas;

    @Steps
    public FormSteps form;

    @Steps
    public BannerSteps banner;

    @Steps
    public TableSteps table;

    @Steps
    public PopupSteps popup;

    @Steps
    public BannerTestSteps test;

    @Steps
    public FrontSteps front;


    @Test
    public void bannerRotatorEditLinkTest() throws Exception{

        String name = DataGenerator.getRandomNameWithDate();
        String subaccount = DataGenerator.getRandomNameWithDate();

        front.login();
        carcas.go_to_banner_rotator();
        form.create_form();
        banner.fill_rotator_form(name,subaccount);
        form.submit_form();
        table.check_table_has_text(name);
        table.open_popup_with_code(name);
        String code = popup.get_textarea_code();
        steps.click_icon_in_blue_table_line_with_text(0,name);
        steps.wait_for_all_spinners_dissapears();
        String code2 = steps.get_ajs_code_from_textarea();
        steps.check_values_are_equals(StringEscapeUtils.escapeHtml4(code),StringEscapeUtils.escapeHtml4(code2));

        steps.close_browser();


    }
    
 
    

    
} 