package cityads.ca_thucydides_new_design.WebmasterStory.office;

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
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.Profile.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class PaymentTimeTest {

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




    @Before
    public void setUp(){
        front.login();
        front.fill_welcome_page_payments_manually();
    }


    @Test
    @Title("Проверка на сохранение настройки -=частота выплат=- после изменения личной информации")
    public void payment53723TimeTest() throws Exception{

        String name = DataGenerator.getRandomString();
        String skype = DataGenerator.getRandomString();
        String top20 = DataGenerator.getRandomString();
        String phone = DataGenerator.getRandomPhoneNumber();

        carcas.go_to_payments();
        String paymentPlan = account.get_payments_plan();

        carcas.go_to_account();
        account.fill_and_submit_personal_info(name,skype,top20,phone);
        form.submit_form();


        carcas.go_to_payments();
        String paymentPlanNew = account.get_payments_plan();

        steps.check_values_are_equals(paymentPlan,paymentPlanNew);



    }
    
 
    

    
} 