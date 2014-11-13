/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.steps.WebmasterSteps;

import cityads.ca_thucydides_new_design.pages.WemasterPages.StatisticTopFilterPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

/**
 *
 * @author s.lugovskiy
 */
public class StatisticTopFilterSteps extends ScenarioSteps {

    StatisticTopFilterPage page;

    public StatisticTopFilterSteps(Pages pages) {
        super(pages);
    }

    @Step
    public void fill_top_filter_simple_and_choose_any(String text, int one, int two){
        page.fillTopFilterSimpleInclude(text, one, two);
    }

    @Step
    public void fill_top_filter_simple_and_choose_any_by_enter(String text, int one, int two){
        page.fillTopFilterSimpleIncludeENTER(text, one, two);
    }

    @Step
    public void fill_top_filter_simple_and_choose_exclude(String text, int one, int two){
        page.fillTopFilterSimpleExclude(text, one, two);
    }

    @Step
    public void fill_top_filter_simple_and_choose_auto_list_elements(String text, int one, int two){
        page.fillTopFilterAutoItems(text, one, two);
    }
}
