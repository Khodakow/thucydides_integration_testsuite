package cityads.ca_thucydides_new_design.pages.refactor;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;


public class Account extends BasePage {

    Popup popup;


    public Account(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//div[contains(@class,'tabs')]")
    private WebElementFacade tabs;

    @FindBy(xpath="//form[@id='profile_form_1']")
    private WebElementFacade personalInfoForm;

    @FindBy(xpath="//input[@id='id_el_text_field_fname']")
    private WebElementFacade name;

    @FindBy(xpath="//input[@id='id_el_text_field_nick_for_top']")
    private WebElementFacade top20nick;

    @FindBy(xpath="//input[@id='id_el_text_field_contact_phone']")
    private WebElementFacade phone;

    @FindBy(xpath="//input[@id='id_el_text_field_skype']")
    private WebElementFacade skype;

    //brazil account----------------------------------

    //bank----------------------------------------
    @FindBy(xpath="//a[@id='unical_id_default_1']")
    private WebElementFacade billingTab;

    @FindBy(xpath = "//input[@id='nbr_bank_id_text']")
    private WebElementFacade bank;

    @FindBy(xpath = "//div[contains(@class,'autocomplete-results')]")
    private WebElementFacade bankList;

    @FindBy(xpath = "//div[contains(@class,'autocomplete-results')]/div[1]/span[1]")
    private WebElementFacade firstBank;

    @FindBy(xpath = "//div[contains(@class,'autocomplete-results')]/div[1]/span[2]")
    private WebElementFacade secondBank;

    @FindBy(xpath = "//input[@id='id_el_text_field_nbr_account_number']")
    private WebElementFacade accountNumber;

    @FindBy(xpath = "//div[@id='tr_nbr_account_type']/div/div/div[@class='select selform _select']/div[@class='select-value pointer']")
    private WebElementFacade accountType;

    @FindBy(xpath = "//div[@class='select-list']")
    private WebElementFacade accountSelectList;

    @FindBy(xpath = "//a[@data-id='1']")
    private WebElementFacade firstCountType;

    @FindBy(xpath = "//form[@id='profile_form_2']")
    private WebElementFacade tab2form;

    public void selectTimeZone(String country,String region){
        this.evaluateJavascript("$('div.input-button.optional._modal_button').click()");
        popup.waitPopup();
        popup.fillInputSearch(country,region);

    }


    public void selectTimeZonewithoutName(){
        this.evaluateJavascript("$('div.input-button.optional._modal_button').click()");
        popup.waitPopup();
        popup.fillInputwithotName();

    }


    public void fillProfileWithTimezone(String nick,String skypeName,String top20,String phoneNumber, String country, String region){


        name.waitUntilVisible();
        name.clear();
        name.sendKeys(nick);

        top20nick.clear();
        top20nick.sendKeys(top20);

        phone.clear();
        phone.sendKeys(phoneNumber);

        skype.clear();
        skype.sendKeys(skypeName);

        selectTimeZone(country,region);

    }

    public void fillProfileWithTimezoneWithoutName(String nick,String skypeName,String top20,String phoneNumber){


        name.waitUntilVisible();
        name.clear();
        name.sendKeys(nick);

        top20nick.clear();
        top20nick.sendKeys(top20);

        phone.clear();
        phone.sendKeys(phoneNumber);

        skype.clear();
        skype.sendKeys(skypeName);

        selectTimeZonewithoutName();

    }


    public void fillProfile(String nick,String skypeName,String top20,String phoneNumber){
        name.waitUntilVisible();
        name.clear();
        name.sendKeys(nick);

        top20nick.clear();
        top20nick.sendKeys(top20);

        phone.clear();
        phone.sendKeys(phoneNumber);

        skype.clear();
        skype.sendKeys(skypeName);
    }

    public String getName() {
        name.waitUntilVisible();
        return name.getAttribute("value");
    }

    public String getTop20nick() {
        top20nick.waitUntilVisible();
        return top20nick.getAttribute("value");
    }

    public String getPhone() {
        phone.waitUntilVisible();
        return phone.getAttribute("value").replace("+","");
    }

    public String getSkype() {
        skype.waitUntilVisible();
        return skype.getAttribute("value");
    }

    public void goToBilling() {
        this.waitABit(3000);
        billingTab.waitUntilVisible();
        billingTab.click();
        this.waitABit(3000);
    }

    public void fillFirstBank(){
        bank.waitUntilVisible();
        bank.click();
        bankList.shouldBeCurrentlyVisible();
        firstBank.click();
    }

    public void fillSecondBank(){
        bank.waitUntilVisible();
        bank.click();
        bankList.shouldBeCurrentlyVisible();
        secondBank.click();
    }

    public void fillCountInfo(int countNumber){
        accountNumber.waitUntilVisible();
        accountNumber.clear();
        accountNumber.sendKeys(String.valueOf(countNumber));
        accountType.waitUntilVisible();
        accountType.click();
        accountSelectList.waitUntilVisible();
        firstCountType.waitUntilVisible();
        firstCountType.click();

    }

    public void secondFormIsVisible(){
        this.waitABit(5000);
        tab2form.shouldBeCurrentlyVisible();

    }
}





