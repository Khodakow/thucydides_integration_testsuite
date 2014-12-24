package cityads.ca_thucydides_new_design.WebmasterStory.bugs;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.BaseSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.*;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.Bugs.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="bugs")
public class Bugs49704ClearGlobalFilterStoryTest {



    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public BaseSteps steps;
    @Steps
    public CarcasSteps carcas;
    @Steps
    public FrontSteps front;
    @Steps
    public FilterSteps filter;
    @Steps
    public CouponsSteps coupons;
    @Steps
    public TableSteps table;
    @Steps
    public GoodsSteps goods;
    @Steps
    public GlobalFilterSteps global;


    
    @Test@Screenshots(onlyOnFailures = false)
    @Title("ГЛОБАЛ ФИЛЬТР - ПРИ КЛИКЕ НА СБРОСИТЬ ФИЛЬТР ОЧИЩАЕТСЯ НО ДАННЫЕ НЕ МЕНЯЮТСЯ")
    public void clearFilter49704StoryTest(){

        front.login();
        carcas.go_to_statistic_by_conversion_by_offers();
        global.set_simple_condition();
        String condition = global.get_condition();
        global.reset_filter();
        String conditionNew = global.get_condition();
        steps.check_string_has_changed(condition,conditionNew);



    }
}
