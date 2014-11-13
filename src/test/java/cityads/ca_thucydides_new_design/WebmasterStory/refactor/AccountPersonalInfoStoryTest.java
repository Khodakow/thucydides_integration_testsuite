package cityads.ca_thucydides_new_design.WebmasterStory.refactor;

import cityads.ca_thucydides_new_design.pages.refactor.DataGenerator;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.MainSiteSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.AccountSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.CarcasSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FormSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FrontSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.Profile.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class AccountPersonalInfoStoryTest {

    public String wmName;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public MainSiteSteps steps;

    @Steps
    public AccountSteps account;

    @Steps
    public CarcasSteps carcas;

    @Steps
    public FormSteps form;

    @Steps
    public FrontSteps front;


    @Test
    public void personalInfoTest() throws Exception{

        String name = DataGenerator.getRandomString();
        String skype = DataGenerator.getRandomString();
        String top20 = DataGenerator.getRandomString();
        String phone = DataGenerator.getRandomPhoneNumber();


        front.login();
        carcas.go_to_account();
        account.fill_and_submit_personal_info(name,skype,top20,phone);
        form.submit_form();
        account.check_personal_info_saved(name, skype, top20, phone);



    }
    
 
    

    
} 