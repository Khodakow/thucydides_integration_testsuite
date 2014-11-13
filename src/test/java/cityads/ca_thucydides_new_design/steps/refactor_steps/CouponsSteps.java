/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.steps.refactor_steps;

import cityads.ca_thucydides_new_design.pages.refactor.Coupons;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

/**
 *
 * @author s.lugovskiy
 */
public class CouponsSteps extends ScenarioSteps {

    public Coupons coupons;

    @Step
    public ArrayList<String> get_coupons_status(){
        ArrayList<String> statuses = new ArrayList<String>();
        for(WebElement elem : coupons.getStatuses()){
            statuses.add(elem.getText());
        }
        return statuses;
    }

    @Step
    public void reset_filter() {
        coupons.resetFilter();
    }

    @Step
    public void create_feed_without_saved_filter(String feedName){
        coupons.clickCreateTool();
        coupons.createFeed(feedName);
        coupons.isOnCouponsPage();
        assertTrue(coupons.isOnCouponsPage());
    }


}
    

