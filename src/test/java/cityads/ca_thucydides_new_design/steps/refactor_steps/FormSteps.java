/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.steps.refactor_steps;

import cityads.ca_thucydides_new_design.pages.refactor.Form;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

/**
 *
 * @author s.lugovskiy
 */
public class FormSteps extends ScenarioSteps {

    public Form form;

    public FormSteps(Pages pages) {
        super(pages);
    }

    @Step("Отправляем форму")
    public void     submit_form(){
        form.submit();
        form.waitForSpinnerDissapear();

    }

    @Step("Отправляем форму со второй вкладки")
    public void submit_second_tab(){
        this.waitABit(5000);
        form.submitSecondTab();
        form.waitForSpinnerDissapear();

    }

    @Step("Нажимаем Создать")
    public void create_form(){
        form.create();
    }

}
    

