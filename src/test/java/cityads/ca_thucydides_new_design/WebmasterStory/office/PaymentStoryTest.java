/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.WebmasterStory.office;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.OperationHistorySteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.PaymentSteps;
import java.sql.SQLException;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.WithTag;
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
public class PaymentStoryTest extends Constants {
    String wmName;
    
    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;
    
    @Steps
    public PaymentSteps steps;
    
    @Test
    public void test_payment_and_calculations(){
        wmName = steps.get_wm_name();
        steps.wm_login(wmName);
        
        steps.click_finances_link();
        steps.click_payments_link();
       
        
       ;
       
        steps.check_fatal_errors();
        steps.check_payments_freq_table_is_displayed();
        steps.check_payments_history_table_is_displayed();
        steps.check_payments_table_data();
        
        steps.close_browser();
        
    }
    
}
