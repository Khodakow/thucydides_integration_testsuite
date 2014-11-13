/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.steps.refactor_steps;

import cityads.ca_thucydides_new_design.pages.refactor.BannersRotator;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

/**
 *
 * @author s.lugovskiy
 */
public class BannerSteps extends ScenarioSteps {

    public BannersRotator banner;

    public BannerSteps(Pages pages) {
        super(pages);
    }

    @Step
    public void fill_rotator_form(String name,String subaccount){
        banner.fillRotatorFormImgBanner(name, subaccount);
    }

}
    

