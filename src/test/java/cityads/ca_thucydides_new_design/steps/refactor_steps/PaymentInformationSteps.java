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

}
    

