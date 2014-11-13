/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.steps.refactor_steps;

import cityads.ca_thucydides_new_design.pages.refactor.NewDashboard;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 *
 * @author s.lugovskiy
 */
public class NewDashboardSteps extends ScenarioSteps {
public NewDashboard newdashboadr;

    @Step
    public void clickkAllOffers(){
        newdashboadr.clickAlloffersLink();
    }
    @Step
    public void checkStructure(){
        newdashboadr.checkAllStucture();
    }

}
    

