/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.steps.refactor_steps;

import cityads.ca_thucydides_new_design.pages.refactor.*;
import cityads.ca_thucydides_new_design.steps.BaseSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;

import java.util.Set;

import static org.junit.Assert.assertFalse;

/**
 *
 * @author s.lugovskiy
 */
public class StatisticsSteps extends BaseSteps {

    public Front front;
    public Welcome welcome;
    public Statistic statistic;
    public Popup popup;
    public BaseSteps check;
    public BasePage page;

    public StatisticsSteps(Pages pages) {
        super(pages);
    }

    @Step("Клик по дате загрузки")
    public void click_by_load_date(){
        statistic.clickByLoadDate();
        this.waitABit(5000);
    }

    @Step
    public void check_spinner_not_displayed(){
        assertFalse(statistic.isSpinnerDisplayed());
    }

    @Step
    public void click_by_interval_graf(){
        statistic.clickByIntervalGraf();
    }

    @Step
    public void check_summary(){
        String text1 =  statistic.getTextSummaryByNumber(0);
        String text2 = statistic.getTextSummaryByNumber(1);
        String text3 = statistic.getTextSummaryByNumber(2);
        String text4 = statistic.getTextSummaryByNumber(3);
        String text5 = statistic.getTextSummaryByNumber(4);
        String text6 = statistic.getTextSummaryByNumber(5);
        String text7 = statistic.getTextSummaryByNumber(6);
        String text8 = statistic.getTextSummaryByNumber(7);
        String text9 = statistic.getTextSummaryByNumber(8);
        check_values_are_equals(text1,"Показы");
        check_values_are_equals(text2,"Хиты");
        check_values_are_equals(text3,"Клики");
        check_values_are_equals(text4,"Лиды");
        check_values_are_equals(text5,"Продажи");
        check_values_are_equals(text6,"Открытая комиссия");
        check_values_are_equals(text7,"Подтвержденная комиссия");
        check_values_are_equals(text8,"eCPC");
        check_values_are_equals(text9,"eCPM");
    }

    @Step("Выгрузка в эксель")
    public void export_xls(){
        page.export();
    }

    @Step("Индикатор выгрузки должен исчезнуть за 60 секунд")
    public void export_spinner_not_visible(){
        waitABit(60000);
        page.exportSpinerNotVisible();
    }

    @Step("клик ПО МЕСЯЦАМ над таблицей")
    public void click_by_month(){
        page.clickByMonth();
    }

    @Step("записываем все месяцы из таблицы в HashSet. Его размер должен быть больше 1")
    public Set<String> get_all_months(){
        return page.getMonths();
    }
}
    

