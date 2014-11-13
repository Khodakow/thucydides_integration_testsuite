/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.steps.WebmasterSteps;

import cityads.ca_thucydides_new_design.pages.WemasterPages.PaymentsPage;
import cityads.ca_thucydides_new_design.steps.SetupSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import org.junit.Assert;

/**
 *
 * @author s.lugovskiy
 */
public class PaymentSteps extends SetupSteps {

    public PaymentSteps(Pages pages) {
        super(pages);
    }
    
    PaymentsPage page;
    
    @Step
    public void check_payments_freq_table_is_displayed(){
        Assert.assertTrue(page.paymentsFrequencyTable.isDisplayed());
    }
    
    @Step
    public void check_payments_history_table_is_displayed(){
        Assert.assertTrue(page.paymentsHistoryTable.isDisplayed());
    }
    
    @Step
    public void check_payments_table_data(){
        Assert.assertTrue(page.getPaymentsAviable().isCurrentlyVisible());
        Assert.assertTrue(page.getPaymentsBalance().isCurrentlyVisible());
        Assert.assertTrue(page.getPaymentsFreqTd().isCurrentlyVisible());
        Assert.assertTrue(page.getPaymentsHoldTd().isCurrentlyVisible());
        
    }

    @Step
    public void open_onlinesim_in_new_window() {
        executeScript("window.open(\"http://onlinesim.ru/\");");
    }
}
