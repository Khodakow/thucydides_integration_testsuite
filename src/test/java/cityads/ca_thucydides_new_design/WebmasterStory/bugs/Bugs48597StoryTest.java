package cityads.ca_thucydides_new_design.WebmasterStory.bugs;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.OfferListSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.CarcasSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FilterSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FrontSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.Bugs.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="bugs")
public class Bugs48597StoryTest {



    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public OfferListSteps steps;
    @Steps
    public CarcasSteps carcas;
    @Steps
    public FrontSteps front;
    @Steps
    public FilterSteps filter;


    @Test@Screenshots(onlyOnFailures = true)@Pending
    @Title("Проверка на сохранение региона в фильтрах после обновления страницы 48597 в оферах")
    public void check_48597_offers(){
        front.login();
        carcas.go_to_web_offers();
        filter.reset_filter();
        filter.submit_filter();

        //раскрываем первые 2 региона
        steps.executeScript("$('i:contains(\"+\"):eq(0)').click();");
        steps.executeScript("$('i:contains(\"+\"):eq(2)').click();");
        steps.wait_for_all_spinners_dissapears();

        filter.click_checkbox_in_filter(1,3);
        filter.click_checkbox_in_filter(1,4);
        filter.submit_filter();
        String legend = filter.get_filter_breadcrumbs();
        steps.refresh_page();
        steps.wait_for_all_spinners_dissapears();
        String legend_new = filter.get_filter_breadcrumbs();
        steps.check_values_are_equals(legend,legend_new);

        steps.close_browser();
    }


    @Test@Pending
    @Screenshots(onlyOnFailures = true)
    @Title("Проверка на сохранение региона в фильтрах после обновления страницы 48597 в мобильных оферах")
    public void check_48597_mobile_offers(){
        front.login();
        carcas.go_to_mob_offers();
        filter.reset_filter();
        filter.submit_filter();

        //раскрываем первые 2 региона
        steps.executeScript("$('i:contains(\"+\"):eq(0)').click();");
        steps.executeScript("$('i:contains(\"+\"):eq(2)').click();");
        steps.wait_for_all_spinners_dissapears();

/*        filter.click_checkbox_in_filter(1,3);
        filter.click_checkbox_in_filter(1,4);*/
        filter.submit_filter();
        String legend = filter.get_filter_breadcrumbs();
        steps.refresh_page();
        steps.wait_for_all_spinners_dissapears();
        String legend_new = filter.get_filter_breadcrumbs();
        steps.check_values_are_equals(legend,legend_new);

        steps.close_browser();
    }


    @Test@Screenshots(onlyOnFailures = true)@Pending
    @Title("Проверка на сохранение региона в фильтрах после обновления страницы 48597 в купонаъ")
    public void check_48597_coupons(){
        front.login();
        carcas.go_to_coupons();
        filter.reset_filter();
        filter.submit_filter();

        //раскрываем первые 2 региона
        steps.executeScript("$('i:contains(\"+\"):eq(0)').click();");
        steps.executeScript("$('i:contains(\"+\"):eq(2)').click();");
        steps.wait_for_all_spinners_dissapears();

        filter.click_checkbox_in_filter(1,3);
        filter.click_checkbox_in_filter(1,4);
        filter.submit_filter();
        String legend = filter.get_filter_breadcrumbs();
        steps.refresh_page();
        steps.wait_for_all_spinners_dissapears();
        String legend_new = filter.get_filter_breadcrumbs();
        steps.check_values_are_equals(legend,legend_new);

        steps.close_browser();
    }


    @Test@Screenshots(onlyOnFailures = true)@Pending
    @Title("Проверка на сохранение региона в фильтрах после обновления страницы 48597 в товарах")
    public void check_48597_goods(){
        front.login();
        carcas.go_to_coupons();
        filter.reset_filter();
        filter.submit_filter();

        //раскрываем первые 2 региона
        steps.executeScript("$('i:contains(\"+\"):eq(0)').click();");
        steps.executeScript("$('i:contains(\"+\"):eq(2)').click();");
        steps.wait_for_all_spinners_dissapears();

        filter.click_checkbox_in_filter(1,3);
        filter.click_checkbox_in_filter(1,4);
        filter.submit_filter();
        String legend = filter.get_filter_breadcrumbs();
        steps.refresh_page();
        steps.wait_for_all_spinners_dissapears();
        String legend_new = filter.get_filter_breadcrumbs();
        steps.check_values_are_equals(legend,legend_new);

        steps.close_browser();
    }
}
