package cityads.ca_thucydides_new_design.WebmasterStory.bugs;

import cityads.ca_thucydides_new_design.pages.refactor.DataGenerator;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.StatisticSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.*;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.Bugs.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class Bugs44187StoryTest {

    public String wmName;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public StatisticSteps steps;

    @Steps
    FrontSteps front;
    @Steps
    StatisticsSteps stat;
    @Steps
    CarcasSteps carcas;
    @Steps
    TableSteps table;
    @Steps
    BannerSteps banner;
    @Steps
    AccountSteps account;
    @Steps
    FormSteps form;




    @Test @Screenshots(onlyOnFailures=false)
    public void bugs44187Test() throws Exception{

        String name = DataGenerator.getRandomString();
        String skype = DataGenerator.getRandomString();
        String top20 = DataGenerator.getRandomString();
        String phone = DataGenerator.getRandomPhoneNumber();
        String country = "Россия";
        String region = "(UTC +4:00) Москва+00 - Волгоград";

        front.login();
        carcas.go_to_account();
        account.fill_and_submit_personal_info_with_timezone_withot_name(name,skype,top20,phone);
        form.submit_form();
        account.check_personal_info_saved(name, skype, top20, phone);
        steps.close_browser();

    }
    
 
    

    
} 