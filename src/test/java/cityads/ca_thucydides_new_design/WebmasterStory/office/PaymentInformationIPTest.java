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
import org.junit.After;
import org.junit.Before;
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


    @Before
    public void setUp(){
        front.login();
        carcas.go_to_payment_information();
        payment.delete_additional_counts();
        steps.close_browser();
    }

    @Test @Screenshots(onlyOnFailures = false)
    @Title("Создание счета, ИП, Доп аккаунт, смс через http://onlinesim.ru/")
    public void test_payment_information_ip_create_wallet(){

        //данные для заполнения в профиле и в форме счета
        String name = DataGenerator.getRandomString();
        String skype = DataGenerator.getRandomString();
        String top20 = DataGenerator.getRandomString();
        String walletName = DataGenerator.getRandomString();
        String fullname = DataGenerator.getRandomString()+" "+DataGenerator.getRandomString();
        String company = DataGenerator.getRandomString();

        String ogrn = DataGenerator.getRandomIntNumber();
        String bic = DataGenerator.getRandomIntNumber();
        String inn = DataGenerator.getRandomIntNumber();
        String bank = DataGenerator.getRandomString();

        String bank_of = DataGenerator.getRandomString();
        String bank_adr = DataGenerator.getRandomString();
        String correspondent = DataGenerator.getRandomIntNumber();
        String cc2 = DataGenerator.getRandomIntNumber();
        String email = DataGenerator.getRandomString()+"@"+"mail.ry";


      /*  //открываем сайт с временными телефонами
        steps.open_url("http://onlinesim.ru/");
        //получаем номер
        String number = payment.get_phone_temp_number().replace("+", "");*/



        //авторизуемся в системе и заполняем этот номер в профиле
        front.login();
      /*  carcas.go_to_account();
        account.fill_and_submit_personal_info(name,skype,top20, number);
        form.submit_form();
        account.check_personal_info_saved(name, skype, top20, number);*/

        //переходим в платежную информацию и заполняем форму до смс-кода
        carcas.go_to_payment_information();
        payment.fill_count_form_jur(walletName, fullname,company,ogrn,inn,bic,bank,bank_of,bank_adr,correspondent,inn,number,email);

        //переходим на сайт в новом окне для получения смс кода
     /*   steps.open_onlinesim_in_new_window();
        steps.switch_to_last_window();
        payment.setup_phone_number(number); //выбираем выбранный ранее номер телефона
        //String code = payment.get_sms_code();
        steps.switch_to_first_window();*/

        //переходим обратно на заполнение формы, заполняем поле смс-код и отправляем форму
        //payment.fill_sms_code(code);
        payment.submit_form();

        //проверки
        steps.check_fatal_errors();
        table.check_table_has_text(walletName);

    }

    @Test @Screenshots(onlyOnFailures = false)
    @Title("Создание счета, ЮР лицо, Доп аккаунт, смс через http://onlinesim.ru/")
    public void test_payment_information_jur_create_wallet(){

        //данные для заполнения в профиле и в форме счета
        String name = DataGenerator.getRandomString();
        String skype = DataGenerator.getRandomString();
        String top20 = DataGenerator.getRandomString();
        String walletName = DataGenerator.getRandomString();
        String fullname = DataGenerator.getRandomString()+" "+DataGenerator.getRandomString();
        String walletId = DataGenerator.getRandomIntNumber();
        String company = DataGenerator.getRandomString();

        String ogrn = DataGenerator.getRandomIntNumber();
        String bic = DataGenerator.getRandomIntNumber();
        String inn = DataGenerator.getRandomIntNumber();
        String bank = DataGenerator.getRandomString();

        String bank_of = DataGenerator.getRandomString();
        String bank_adr = DataGenerator.getRandomString();
        String correspondent = DataGenerator.getRandomIntNumber();
        String cc2 = DataGenerator.getRandomIntNumber();
        String email = DataGenerator.getRandomString()+"@"+"mail.ry";


     /*   //открываем сайт с временными телефонами
        steps.open_url("http://onlinesim.ru/");
        //получаем номер
        String number = payment.get_phone_temp_number().replace("+", "");*/



        //авторизуемся в системе и заполняем этот номер в профиле
        front.login();
/*        carcas.go_to_account();
        account.fill_and_submit_personal_info(name,skype,top20, number);
        form.submit_form();
        account.check_personal_info_saved(name, skype, top20, number);*/

        //переходим в платежную информацию и заполняем форму до смс-кода
        carcas.go_to_payment_information();
        payment.fill_count_form_jur(walletName, fullname,company,ogrn,inn,bic,bank,bank_of,bank_adr,correspondent,inn,number,email);

        //переходим на сайт в новом окне для получения смс кода
       /* steps.open_onlinesim_in_new_window();
        steps.switch_to_last_window();
        payment.setup_phone_number(number); //выбираем выбранный ранее номер телефона
        //String code = payment.get_sms_code();
        steps.switch_to_first_window();*/

        //переходим обратно на заполнение формы, заполняем поле смс-код и отправляем форму
        //payment.fill_sms_code(code);
        payment.submit_form();

        //проверки
        steps.check_fatal_errors();
        table.check_table_has_text(walletName);

    }

    @Test @Screenshots(onlyOnFailures = false)
    @Title("Создание счета, Физ лицо, Доп аккаунт, смс через http://onlinesim.ru/")
    public void test_payment_information_create_wallet(){

        //данные для заполнения в профиле и в форме счета
        String name = DataGenerator.getRandomString();
        String skype = DataGenerator.getRandomString();
        String top20 = DataGenerator.getRandomString();
        String walletName = DataGenerator.getRandomString();
        String fullname = DataGenerator.getRandomString()+" "+DataGenerator.getRandomString();
        String walletId = DataGenerator.getRandomIntNumber();

        //открываем сайт с временными телефонами
       /* steps.open_url("http://onlinesim.ru/");
        //получаем номер
        number = payment.get_phone_temp_number().replace("+","");*/



        //авторизуемся в системе и заполняем этот номер в профиле
        front.login();
/*        carcas.go_to_account();
        account.fill_and_submit_personal_info(name,skype,top20,number);
        form.submit_form();
        account.check_personal_info_saved(name, skype, top20, number);*/

        //переходим в платежную информацию и заполняем форму до смс-кода
        carcas.go_to_payment_information();
        payment.fill_count_form(walletName,fullname,walletId);

        //переходим на сайт в новом окне для получения смс кода
        /*steps.open_onlinesim_in_new_window();
        steps.switch_to_last_window();
        payment.setup_phone_number(number); //выбираем выбранный ранее номер телефона
        //String code = payment.get_sms_code();
        steps.switch_to_first_window();*/

        //переходим обратно на заполнение формы, заполняем поле смс-код и отправляем форму
        //payment.fill_sms_code(code);
        payment.submit_form();

        //проверки
        steps.check_fatal_errors();
        popup.check_popup_is_not_displayed();
        table.check_table_has_text(walletId);
        table.check_table_has_text(walletName);

    }

    @Test @Screenshots(onlyOnFailures = false)
    @Title("Редактирование созданного счета, Физ лицо, Доп аккаунт, смс через http://onlinesim.ru/")
    public void test_payment_information_edit_wallet(){

        //данные для заполнения в профиле и в форме счета
        String name = DataGenerator.getRandomString();
        String skype = DataGenerator.getRandomString();
        String top20 = DataGenerator.getRandomString();
        String walletName = DataGenerator.getRandomString();
        String fullname = DataGenerator.getRandomString()+" "+DataGenerator.getRandomString();
        String walletId = DataGenerator.getRandomIntNumber();

        //открываем сайт с временными телефонами
        steps.open_url("http://onlinesim.ru/");
        //получаем номер
        //number = payment.get_phone_temp_number().replace("+","");


        //авторизуемся в системе и заполняем этот номер в профиле
        front.login();
        /*carcas.go_to_account();
        account.fill_and_submit_personal_info(name,skype,top20,number);
        form.submit_form();
        account.check_personal_info_saved(name, skype, top20, number);*/

        //переходим в платежную информацию и заполняем форму до смс-кода
        carcas.go_to_payment_information();
        payment.fill_count_form(walletName,fullname,walletId);

        //переходим на сайт в новом окне для получения смс кода
       /* steps.open_onlinesim_in_new_window();
        steps.switch_to_last_window();
        payment.setup_phone_number(number); //выбираем выбранный ранее номер телефона
        //String code = payment.get_sms_code();
        steps.switch_to_first_window();*/

        //переходим обратно на заполнение формы, заполняем поле смс-код и отправляем форму
        //payment.fill_sms_code(code);
        payment.submit_form();

        //проверки
        steps.check_fatal_errors();
        popup.check_popup_is_not_displayed();
        table.check_table_has_text(walletId);
        table.check_table_has_text(walletName);
        steps.close_browser();


        //редактируем созданный валлет
        front.login();
        carcas.go_to_payment_information();
        //новые данные для редактирования
        String walletName2 = DataGenerator.getRandomString();
        String fullname2 = DataGenerator.getRandomString()+" "+DataGenerator.getRandomString();
        String walletId2 = DataGenerator.getRandomIntNumber();
        table.click_edit_wallet_with_name(walletName);
        payment.edit_count_form(walletName2,fullname2,walletId2);

      /*  //переходим на сайт в новом окне для получения смс кода
        steps.open_onlinesim_in_new_window();
        steps.switch_to_last_window();
        payment.setup_phone_number(number); //выбираем выбранный ранее номер телефона
        //code = payment.get_sms_code();
        steps.switch_to_first_window();*/

        //переходим обратно на заполнение формы, заполняем поле смс-код и отправляем форму
        //payment.fill_sms_code(code);
        payment.submit_form();

        //проверки
        steps.check_fatal_errors();
        popup.check_popup_is_not_displayed();
        table.check_table_has_text(walletId2);
        table.check_table_has_text(walletName2);
        steps.close_browser();

    }

    @After
    public void tearDown(){
        payment.delete_additional_counts();
        steps.close_browser();
    }


}
