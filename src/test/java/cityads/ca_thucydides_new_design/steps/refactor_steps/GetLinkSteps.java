/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.steps.refactor_steps;

import cityads.ca_thucydides_new_design.pages.refactor.GetLink;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author s.lugovskiy
 */
public class GetLinkSteps extends ScenarioSteps {

    public GetLink getLink;

    @Step
    public void fill_getlink_form(String name, String subacc){
        getLink.fillForm(name,subacc);
        getLink.saveAndExit();
    }

    @Step
    public String fill_getlink_form_and_get_code(String name, String subacc){
        getLink.fillForm(name,subacc);
        return getLink.saveAndGetCode();
    }


    @Step("Получаем первый оффер из таблицы Retargeting URL")
    public String get_first_retarget_offer(){
        return getLink.getFirstRetargetOffer();
    }

    @Step("Получаем первый оффер из таблицы No Retargeting URL")
    public String get_first_noretarget_offer(){
        return getLink.getFirstNoRetargetOffer();
    }


    @Step
     public void check_retarget_table_has_text(String name) {
        assertEquals("Проверяем что оффер совпадает с оффером из фильтра", getLink.getFirstRetargetOffer(), name);
    }

    @Step
    public void check_noretarget_table_has_text(String name) {
        assertTrue("Проверяем что оффер совпадает с оффером из фильтра", getLink.getFirstNoRetargetOffer().contains(name));
    }

    @Step("Клик по параметрам ссылки в ретаргет таблице")
    public void click_parameters_in_retarget() {
        getLink.clickParametersInRetarget();
    }
}
    

