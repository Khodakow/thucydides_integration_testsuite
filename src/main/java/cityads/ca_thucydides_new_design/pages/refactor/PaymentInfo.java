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

    @FindBy(xpath = "//tr[descendant::td/div[contains(text(),'cityads')]]/td[2]")
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
        //getCode.click();
        waitSpinner();
    }

    public void fillNewCountFormJur(String walletName, String fullname,String legaladdress2,String ogrn2,String inn2,String bic2,String bank2,String bank_office2,String company,String bank_adress2,String correspondent_account2,String cc2,String telephone, String email) {
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


        legaladdress.clear();
        legaladdress.sendKeys(legaladdress2);

        ogrn.clear();
        ogrn.sendKeys(ogrn2);

        inn.clear();
        inn.sendKeys(inn2);

        bic.clear();
        bic.sendKeys(bic2);

        bank.clear();
        bank.sendKeys(bank2);

        bankOffice.clear();
        bankOffice.sendKeys(bank_office2);

        bankAdress.clear();
        bankAdress.sendKeys(bank_adress2);

        correspondentAccount.clear();
        correspondentAccount.sendKeys(correspondent_account2);

        cc.clear();
        cc.sendKeys(cc2);

        ccRepeat.clear();
        ccRepeat.sendKeys(cc2);

        expandForm();

        contactName.clear();
        contactName.sendKeys(fullname);

        phone.clear();
        phone.sendKeys(telephone);

        mail.clear();
        mail.sendKeys(email);

        //getCode.click();
        waitSpinner();

        popup.checkPopupBlackIsNotDisplayed();
    }

    public void fillNewCountFormIP(String walletName, String fullname,String legaladdress2,String ogrn2,String inn2,String bic2,String bank2,String bank_office2,String company,String bank_adress2,String correspondent_account2,String cc2,String telephone, String email) {
        create.waitUntilVisible();
        create.click();
        popup.waitPopup();
        ip.waitUntilVisible();
        ip.click();
        fullName.shouldBeCurrentlyVisible();
        fullName.clear();
        fullName.sendKeys(company);
        name.clear();
        name.sendKeys(walletName);


        legaladdress.clear();
        legaladdress.sendKeys(legaladdress2);

        ogrn.clear();
        ogrn.sendKeys(ogrn2);

        inn.clear();
        inn.sendKeys(inn2);

        bic.clear();
        bic.sendKeys(bic2);

        bank.clear();
        bank.sendKeys(bank2);

        bankOffice.clear();
        bankOffice.sendKeys(bank_office2);

        bankAdress.clear();
        bankAdress.sendKeys(bank_adress2);

        correspondentAccount.clear();
        correspondentAccount.sendKeys(correspondent_account2);

        cc.clear();
        cc.sendKeys(cc2);

        ccRepeat.clear();
        ccRepeat.sendKeys(cc2);

        expandForm();

        contactName.clear();
        contactName.sendKeys(fullname);

        phone.clear();
        phone.sendKeys(telephone);

        mail.clear();
        mail.sendKeys(email);

        //getCode.click();
        waitSpinner();

        popup.checkPopupBlackIsNotDisplayed();
    }


    public void editForm(String walletName,String fullname, String walletid) {
        popup.waitPopup();
        name.clear();
        name.sendKeys(walletName);
        fullName.clear();
        fullName.sendKeys(fullname);
        walletId.clear();
        walletId.sendKeys(walletid);
        //getCode.click();
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
        waitForSpinnerDissapear();
        this.evaluateJavascript("$('a[class*=\"button dark submit\"]').click()");
        waitABit(5000);
        waitForSpinnerDissapear();
    }

    public void setphoneNumberOnlinesim(String number){
        getDriver().findElement(By.xpath("//option[contains(text(),'"+number+"')]")).click();
        getDriver().findElement(By.name("submit")).click();
    }

    public void deleteAdditionalCounts() {
        if(deleteIcons.size()>0) {
            int i;

            for (i=0;i<deleteIcons.size();i++) {
                waitSpinner();
                deleteIcons.get(0).click();
                waitSpinner();
                popup.clickYes();
                waitSpinner();
            }
        }
    }

    public void checkAdditionalCountsNotPresent(){
        assertTrue(deleteIcons.size() == 0);
    }

    private void expandForm(){
        this.evaluateJavascript("$('div[class*=\"_content_scrollable _has_scrollable\"]').attr('style','max-height: 1000px; padding-bottom: 0px;');");
    }

}





