package cityads.ca_thucydides_new_design.WebmasterStory.stat;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.BaseSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.*;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.Statistic.class)
@RunWith(ThucydidesRunner.class)
public class GlobalFilterMultipleConditionTest {



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
    @Title("Проверка работы составного условия в глобал фильтре")
    public void globalFilterMultipleConditionTest(){

        front.login();
        carcas.go_to_statistic_by_conversion_by_offers();
        String offer = global.set_complex_condition();
        table.check_all_data_in_offers_main_parametr(offer);

    }
}
