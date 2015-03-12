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

    @FindBy(xpath = "//div[@class='absolute back-ccc pointer']")
    private WebElementFacade sideBar;

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

    @FindBy(xpath = "//tr[descendant::td/div[contains(text(),'SMS')]]/td[2]")
    private WebElementFacade sms;

    @FindBy(xpath = "//table[contains(@class,'blue_table')]/tbody/tr[descendant::td[contains(text(),'Дополнительный')]]/td/a[contains(@class,'pointer icon remove')]")
    private List<WebElement> deleteIcons;

    @FindBy(xpath = "//label[descendant::input[@type='radio' and @value='1']]")
    private WebElementFacade legalPerson;

    @FindBy(xpath = "//label[descendant::input[@type='radio' and @value='2']]")
    private WebElementFacade ip;

    @FindBy(xpath = "//input[@name='company_name']")
    private WebElementFacade companyName;

    @FindBy(xpath = "//input[@name='contact_name']")
    private WebElementFacade contactName;

    @FindBy(xpath = "//input[@name='legal_address']")
    private WebElementFacade legaladdress;

    @FindBy(xpath = "//input[@name='ogrn']")
    private WebElementFacade ogrn;

    @FindBy(xpath = "//input[@name='inn']")
    private WebElementFacade inn;

    @FindBy(xpath = "//input[@name='phone']")
    private WebElementFacade phone;

    @FindBy(xpath = "//input[@name='bic']")
    private WebElementFacade bic;

    @FindBy(xpath = "//input[@name='bank']")
    private WebElementFacade bank;

    @FindBy(xpath = "//input[@name='bank_office']")
    private WebElementFacade bankOffice;

    @FindBy(xpath = "//input[@name='bank_adress']")
    private WebElementFacade bankAdress;

    @FindBy(xpath = "//input[@name='correspondent_account']")
    private WebElementFacade correspondentAccount;

    @FindBy(xpath = "//input[@name='cc']")
    private WebElementFacade cc;

    @FindBy(xpath = "//input[@name='email']")
    private WebElementFacade mail;

    @FindBy(xpath = "//input[@name='cc2']")
    private WebElementFacade ccRepeat;


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
        waitForSpinnerDissapear();
        this.evaluateJavascript("$('a[class*=\"button dark submit\"]').click()");
        waitABit(5000);
        waitForSpinnerDissapear();
    }

    public void setphoneNumberOnlinesim(String number){
        getDriver().findElement(By.xpath("//option[contains(text(),'"+number+"')]")).click();
        getDriver().findElement(By.name("submit")).click();
    }


    public void checkAdditionalCountsNotPresent(){
        assertTrue(deleteIcons.size() == 0);
    }

    private void expandForm(){
        this.evaluateJavascript("$('div[class*=\"_content_scrollable _has_scrollable\"]').attr('style','max-height: 1000px; padding-bottom: 0px;');");
    }

}





