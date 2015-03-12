package cityads.ca_thucydides_new_design.WebmasterStory.office;

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
public class ApiKeyTest {

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
    @Title("Проверка смены ключа в разделе АПИ")
    public void apiKeyTest() throws Exception{

        front.loginBr();
        carcas.go_to_api();
        String key = account.get_remote_auth();
        account.change_remote_auth();
        String newKey = account.get_remote_auth();
        steps.check_string_has_changed(key,newKey);


    }
    
 
    

    
} 