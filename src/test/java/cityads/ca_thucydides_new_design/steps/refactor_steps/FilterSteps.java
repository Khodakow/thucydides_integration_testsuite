/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.steps.refactor_steps;

import cityads.ca_thucydides_new_design.pages.refactor.Filter;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

/**
 *
 * @author s.lugovskiy
 */
public class FilterSteps extends ScenarioSteps {

    public Filter filter;

    public FilterSteps(Pages pages) {
        super(pages);
    }


    /**
    *@param checkboxNumber - номер чекбокса в фильтре (начинается с 1 и должен быть видим без прокрутки)
    *@param filterNumber начинается с 1 (номер фильта на странице)
    *
    **/
    @Step
    public void click_checkbox_in_filter(int filterNumber, int checkboxNumber){
        filter.clickCheckboxInFilter(filterNumber,checkboxNumber);
    }

    @Step("Применяем фильтр")
    public void submit_filter(){
        filter.submitFilter();
    }


    @Step ("Берем ссылку")
    public String get_filter_breadcrumbs(){
        return filter.getSelectedFiltersText();
    }

    @Step("Сбрасываем фильтр")
    public void reset_filter() {
        filter.resetFilter();
    }

    @Step
    public void save_filter(String name) {
        filter.saveFilter(name);
    }

    @Step
    public void filter_by_keyword_retarget_getlink(String keyword) {
        filter.filterByKeywordRetarget(keyword);
    }

    @Step
    public void filter_by_keyword_noretarget_getlink(String keyword) {
        filter.filterByKeywordNoRetarget(keyword);
    }

    @Step
    public void search_by_keyword(String key) {
        filter.searchByKeyword(key);
    }
}
    

