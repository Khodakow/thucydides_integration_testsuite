/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.WebmasterStory.office;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.PaymentSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.CarcasSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FrontSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author s.lugovskiy
 */

@Story(TestSuite.WebMaster.Payment.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class PaymentStoryTest{
    String wmName;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public PaymentSteps steps;

    @Steps
    public FrontSteps front;

    @Steps
    public CarcasSteps carcas;

    @Test
    public void test_payment_and_calculations(){
        front.login();
        carcas.go_to_payments();
        steps.check_fatal_errors();
        steps.check_payments_freq_table_is_displayed();
        steps.check_payments_history_table_is_displayed();
        steps.check_payments_table_data();
        steps.close_browser();

    }

}
