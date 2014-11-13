/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.steps.refactor_steps;

import cityads.ca_thucydides_new_design.pages.refactor.ApiDocs;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

/**
 *
 * @author s.lugovskiy
 */
public class ApiDocsSteps extends ScenarioSteps {

    public ApiDocs page;


    public ApiDocsSteps(Pages pages) {
        super(pages);
    }

    @Step
    public void change_api_docs_lang_to_en(){
        page.switchlangToEng();
    }

    @Step
    public void go_to_authorization(){
        page.clickAuthorization();
    }

    @Step
    public void go_to_soap(){
        page.clickSoap();
    }


    @Step
    public void go_to_rest(){
        page.clickRest();
    }

    @Step
    public void go_to_qouting() {
        page.clickQuoting();
    }

    @Step
    public void go_to_goods(){
        page.clickGoods();
    }

    @Step
    public void go_to_lib(){
        page.clickLib();
    }

    @Step
    public void go_to_lang(){
        page.clickLang();
    }

    @Step
    public void go_to_list(){
        page.clickList();
    }

    @Step
    public void go_to_offers(){
        page.clickOffers();
    }

    @Step
    public void go_to_stat(){
        page.clickStat();
    }

    @Step
    public void go_to_tools(){
        page.clickTools();
    }

    @Step
    public void go_to_user(){
        page.clickUser();
    }



}
    

