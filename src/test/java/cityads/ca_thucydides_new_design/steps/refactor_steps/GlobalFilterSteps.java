/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.steps.refactor_steps;

import cityads.ca_thucydides_new_design.pages.refactor.GlobalFilter;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import static org.junit.Assert.assertTrue;


/**
 *
 * @author s.lugovskiy
 */
public class GlobalFilterSteps extends ScenarioSteps {

    public GlobalFilter globalFilter;

    public GlobalFilterSteps(Pages pages) {
        super(pages);
    }

    @Step
    public void set_simple_condition(){
        globalFilter.setSimpleCondition();
    }

    @Step("Устанавливаем условие в глобальном фильтре - офис:Бразилия")
    public void set_office_brazil(){
        globalFilter.setOfficeBrazil();
    }




    @Step
    public String get_condition(){
        return globalFilter.getCondition();
    }

    @Step
    public void reset_filter(){
        globalFilter.resetFilter();
    }


    @Step("Устанавливаем составное условие с 2 первыми офферами в списках автозаполнения фильтра и запоминаем оффер")
    public String set_complex_condition() {
        return globalFilter.setComplexCondition();
    }

    @Step("Проверяем что сообщение об ошибке не отображается")
    public void check_error_not_displayed(){
        assertTrue("Проверяем что сообщение с ошибкой не отображается ", globalFilter.errorMsgIsVisible());
    }
}
    

