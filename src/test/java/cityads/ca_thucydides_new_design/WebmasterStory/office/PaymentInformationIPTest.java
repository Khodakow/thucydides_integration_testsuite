/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.WebmasterStory.office;

import cityads.ca_thucydides_new_design.pages.refactor.DataGenerator;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.PaymentSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.*;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author s.lugovskiy
 */

@Story(TestSuite.WebMaster.Payment.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class PaymentInformationIPTest {
    String wmName;
    
    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    private final String number = "+79999999999";
    
    @Steps
    PaymentSteps steps;
    @Steps
    CarcasSteps carcas;
    @Steps
    FrontSteps front;
    @Steps
    TableSteps table;
    @Steps
    FormSteps form;
    @Steps
    PaymentInformationSteps payment;
    @Steps
    AccountSteps account;
    @Steps
    PopupSteps popup;


    @Test @Screenshots(onlyOnFailures = false)
    @Title("Создание счета, Доп аккаунт, смс через http://onlinesim.ru/")
    @Pending
    public void test_payment_information_ip_create_wallet(){

        //данные для заполнения в профиле и в форме счета
        String name = DataGenerator.getRandomString();
        String skype = DataGenerator.getRandomString();
        String top20 = DataGenerator.getRandomString();


        //открываем сайт с временными телефонами
        steps.open_url("http://onlinesim.ru/");
        //получаем номер
        String number = payment.get_phone_temp_number().replace("+", "");

        //авторизуемся в системе и заполняем этот номер в профиле
        front.login();
        carcas.go_to_account();
        account.fill_and_submit_personal_info(name,skype,top20, number);
        form.submit_form();
        account.check_personal_info_saved(name, skype, top20, number);

        //переходим в платежную информацию и заполняем форму до смс-кода
        carcas.go_to_payment_information();
        //payment.fill_count_form_jur(walletName, fullname,company,ogrn,inn,bic,bank,bank_of,bank_adr,correspondent,inn,number,email);

        //переходим на сайт в новом окне для получения смс кода
        steps.open_onlinesim_in_new_window();
        steps.switch_to_last_window();
        payment.setup_phone_number(number); //выбираем выбранный ранее номер телефона
        String code = payment.get_sms_code();
        steps.switch_to_first_window();
        System.out.println(code);


    }



}
