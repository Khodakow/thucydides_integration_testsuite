package cityads.ca_thucydides_new_design.WebmasterStory.tools;

import cityads.ca_thucydides_new_design.pages.refactor.DataGenerator;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.BannerTestSteps;
import cityads.ca_thucydides_new_design.steps.MainSiteSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.*;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.BannersRotator.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class BannerRotatorClickTest {

    public String wmName;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public MainSiteSteps steps;

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
    public void bannerRotatorClickTest() throws Exception{

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
        test.check_banner(code);
        steps.close_browser();


    }
    
 
    

    
} 