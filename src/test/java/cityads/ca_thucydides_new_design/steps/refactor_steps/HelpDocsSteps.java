/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.steps.refactor_steps;

import cityads.ca_thucydides_new_design.pages.refactor.HelpDocs;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

/**
 *
 * @author s.lugovskiy
 */
public class HelpDocsSteps extends ScenarioSteps {

    public HelpDocs page;


    public HelpDocsSteps(Pages pages) {
        super(pages);
    }

    @Step("Поменять язык на англ")
    public void change_lang_to_en(){
        page.switchlangToEng();
    }

    @Step("Поменять язык на br")
    public void change_lang_to_br(){
        page.switchlangToBr();
    }


    @Step
    public void go_to_registration() {
        page.goToReg();
    }

    @Step
    public void go_to_acc() {
        page.goToAcc();
    }

    @Step
    public void go_to_pub() {
        page.goToPub();
    }

    @Step
    public void go_to_offers() {
        page.goToOffers();
    }

    @Step
    public void go_to_stat() {
        page.goToStat();
    }

    @Step
    public void go_to_tools() {
        page.goToTools();
    }

    @Step
    public void go_to_coup() {
        page.goToCoup();
    }
}
    

