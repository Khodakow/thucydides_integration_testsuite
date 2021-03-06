package cityads.ca_thucydides_new_design.WebmasterStory.office;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.ExchangeSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.CarcasSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.sql.Connection;


@Story(TestSuite.WebMaster.Exchange.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class ExchangeStoryTest extends Constants {

    public Connection con;
    public String wmName;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public ExchangeSteps steps;

    @Steps
    public CarcasSteps carcas;

    @After
    public void shut_down_driver_process(){
        steps.close_browser();
    }

    @Test @WithTagValuesOf({"block:Office","role:Webmaster"})
    public  void exchange_test() throws Exception{


        wmName = steps.get_wm_name();
        steps.wm_login(wmName);
        carcas.go_to_exchange();

        steps.click_exchange_tab(wmExchangeTab1);
        steps.check_fatal_errors();


        steps.click_exchange_tab(wmExchangeTab2);
        steps.wait_for_all_spinners_dissapears(50);
        steps.check_fatal_errors();


        steps.click_exchange_tab(wmExchangeTab3);
        steps.check_fatal_errors();


        steps.click_exchange_tab(wmExchangeTab4);
        steps.wait_for_all_spinners_dissapears(50);
        steps.check_fatal_errors();


        steps.click_exchange_tab(wmExchangeTab5);
        steps.wait_for_all_spinners_dissapears(50);
        steps.check_fatal_errors();


        steps.click_exchange_tab(wmExchangeTab6);
        steps.wait_for_all_spinners_dissapears(50);
        steps.check_fatal_errors();


        steps.click_exchange_tab(wmExchangeTab7);
        steps.wait_for_all_spinners_dissapears(50);
        steps.check_fatal_errors();



        steps.close_browser();

    }





} 