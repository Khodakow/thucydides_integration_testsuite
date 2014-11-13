package cityads.ca_thucydides_new_design.pages.refactor;

import net.thucydides.core.annotations.findby.By;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class PaymentInfo extends BasePage {


    public PaymentInfo(WebDriver driver) {
        super(driver);
    }

    private Popup popup;

    @FindBy(xpath = "//button[@id='payinfoCreate']")
    private WebElementFacade create;

    @FindBy(xpath = "//input[@name='wallet_id']")
    private WebElementFacade walletId;

    @FindBy(xpath = "//input[@name='account_name']")
    private WebElementFacade name;

    @FindBy(xpath = "//input[@name='full_name']")
    private WebElementFacade fullName;

    @FindBy(xpath = "//input[@name='smscode']")
    private WebElementFacade smsCodeInput;

    @FindBy(xpath = "//input[@name='person_status' and @value='0']")
    private WebElementFacade phisycalPerson;

    @FindBy(xpath = "//a[contains(@class,'button dark submit')]")
    private WebElementFacade submit;

    @FindBy(xpath = "//a[contains(@class,'_getSmsCode')]")
    private WebElementFacade getCode;

    @FindBy(xpath = "//tr[descendant::td/div[contains(text(),'cityads')]]/td[2]")
    private WebElementFacade sms;

    @FindBy(xpath = "//table[contains(@class,'blue_table')]/tbody/tr[descendant::td[contains(text(),'Дополнительный')]]/td/a[contains(@class,'pointer icon remove')]")
    private List<WebElement> deleteIcons;

    @FindBy(xpath = "//label[descendant::input[@type='radio' and @value='1']]")
    private WebElementFacade  legalPerson;

    @FindBy(xpath = "//input[@name='company_name']")
    private WebElementFacade  companyName;

    public void fillNewCountForm(String walletName,String fullname, String walletid) {
        create.waitUntilVisible();
        create.click();
        popup.waitPopup();
        name.clear();
        name.sendKeys(walletName);
        fullName.clear();
        fullName.sendKeys(fullname);
        walletId.clear();
        walletId.sendKeys(walletid);
        getCode.click();
        waitSpinner();
    }


    public void fillNewCountFormJur(String walletName, String fullname, String walletid,String company) {
        create.waitUntilVisible();
        create.click();
        popup.waitPopup();
        legalPerson.waitUntilVisible();
        legalPerson.click();
        companyName.shouldBeCurrentlyVisible();
        companyName.clear();
        companyName.sendKeys(company);
        name.clear();
        name.sendKeys(walletName);

        fullName.clear();
        fullName.sendKeys(fullname);
        walletId.clear();
        walletId.sendKeys(walletid);
        getCode.click();
        waitSpinner();
    }

    public void editForm(String walletName,String fullname, String walletid) {
        popup.waitPopup();
        name.clear();
        name.sendKeys(walletName);
        fullName.clear();
        fullName.sendKeys(fullname);
        walletId.clear();
        walletId.sendKeys(walletid);
        getCode.click();
        waitSpinner();
    }

    public String getSms(){
        waitABit(80000);
        getDriver().navigate().refresh();
        sms.waitUntilVisible();
        return sms.getText().split(": ")[1];
    }

    public void fillSmsCode(String code){
        smsCodeInput.waitUntilVisible();
        smsCodeInput.clear();
        smsCodeInput.sendKeys(code);
    }

    public void submitForm() {
        submit.waitUntilVisible();
        submit.click();
        waitABit(5000);
        waitSpinner();
    }

    public void setphoneNumberOnlinesim(String number){
        getDriver().findElement(By.xpath("//option[contains(text(),'"+number+"')]")).click();
        getDriver().findElement(By.name("submit")).click();
    }

    public void deleteAdditionalCounts() {
        if(deleteIcons.size()>0) {
            for (WebElement elem : deleteIcons) {
                waitSpinner();
                elem.click();
                waitSpinner();
                popup.clickYes();
                waitSpinner();
            }
        }
    }

    public void checkAdditionalCountsNotPresent(){
        assertTrue(deleteIcons.size() == 0);
    }

}





