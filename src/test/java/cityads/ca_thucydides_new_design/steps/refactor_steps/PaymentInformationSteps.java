/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.steps.refactor_steps;

import cityads.ca_thucydides_new_design.pages.refactor.PaymentInfo;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.findby.By;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

/**
 *
 * @author s.lugovskiy
 */
public class PaymentInformationSteps extends ScenarioSteps {

    PaymentInfo paymentInfo;

    public PaymentInformationSteps(Pages pages) {
        super(pages);
    }


    @Step
    public void fill_count_form(String name, String fullname, String id) {
        paymentInfo.fillNewCountForm(name,fullname, id);
    }

    @Step
    public void fill_count_form_jur(String name, String fullname,String company,String ogrn,String inn,String bic,String bank,String bank_office,String bankadres,String correspondent, String cc,String telephone,String email ) {
        paymentInfo.fillNewCountFormJur(name,fullname, company,ogrn,inn,bic,bank,bank_office,company,bankadres,correspondent,cc,telephone,email);
    }

    @Step
    public void fill_count_form_ip(String name, String fullname,String company,String ogrn,String inn,String bic,String bank,String bank_office,String bankadres,String correspondent, String cc,String telephone,String email ) {
        paymentInfo.fillNewCountFormIP(name,fullname, company,ogrn,inn,bic,bank,bank_office,company,bankadres,correspondent,cc,telephone,email);
    }


    @Step
    public void edit_count_form(String name, String fullname, String id) {
        paymentInfo.editForm(name,fullname, id);
    }

    @Step
    public void fill_sms_code(String code) {
        paymentInfo.fillSmsCode(code);
    }

    @Step("Получить временный номер телефона с  сайта http://onlinesim.ru/")
    public String get_phone_temp_number(){
        String number = getDriver().findElement(By.xpath("//option[@class='color']")).getText();
        return number;
    }

    @Step("Получить код из смс с сайта")
    public String get_sms_code(){
        return paymentInfo.getSms();
    }

    @Step("Отправляем форму")
    public void submit_form() {
        paymentInfo.submitForm();
    }

    @Step("Устанавливаем  на сайта выбранный ранее номер телефона")
    public void setup_phone_number(String number){
        paymentInfo.setphoneNumberOnlinesim(number);
    }


    @Step("Удаляем все дополнительные счета, если они есть")
    public void delete_additional_counts() {
        paymentInfo.deleteAdditionalCounts();
       // paymentInfo.checkAdditionalCountsNotPresent();
    }
}
    

