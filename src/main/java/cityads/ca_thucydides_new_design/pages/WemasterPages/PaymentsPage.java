/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.pages.WemasterPages;

import cityads.ca_thucydides_new_design.pages.MainPage;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author s.lugovskiy
 */
public class PaymentsPage extends MainPage {

    public PaymentsPage(WebDriver driver) {
        super(driver);
    }
    
    @FindBy(id="table_wm.payout_history")
    public WebElement paymentsHistoryTable;
    
    @FindBy(id="table_wm.payout_info")
    public WebElement paymentsFrequencyTable;

    public WebElementFacade getPaymentsFreqTd() {
        return element(paymentsFreqTd);
    }

    public WebElementFacade getPaymentsHoldTd() {
        return element(paymentsHoldTd);
    }

    public WebElementFacade getPaymentsBalance() {
        return element(paymentsBalance);
    }

    public WebElementFacade getPaymentsAviable() {
        return element(paymentsAviable);
    }
    
    @FindBy(id="id_el_td_446_67_plan_1")
    private WebElement paymentsFreqTd;
    
    @FindBy(id="id_el_td_449_67_hold_1")
    private WebElement paymentsHoldTd;
    
    @FindBy(id="id_el_td_448_67_balance_1")
    private WebElement paymentsBalance;
    
    @FindBy(id="id_el_td_447_67_balance_hold_1")
    private WebElement paymentsAviable;
}
