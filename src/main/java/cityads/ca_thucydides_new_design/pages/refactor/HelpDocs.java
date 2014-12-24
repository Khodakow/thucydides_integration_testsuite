package cityads.ca_thucydides_new_design.pages.refactor;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;


public class HelpDocs extends BasePage {


    public HelpDocs(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[contains(@class,'_lang-switch')]")
    private WebElementFacade langSwitch;

    @FindBy(xpath = " //a[@data-lang='en']")
    private WebElementFacade en;

    @FindBy(xpath = " //a[@data-lang='br']")
    private WebElementFacade br;

    @FindBy(xpath = "//a[@href='#registration_in_cityads']")
    private WebElementFacade reg;

    @FindBy(xpath = "//a[@href='#first_entry_in_account_cityads']")
    private WebElementFacade acc;

    @FindBy(xpath = "//a[@href='#account_navigation_cityads']")
    private WebElementFacade pub;

    @FindBy(xpath = "//a[@href='#tab_office']")
    private WebElementFacade office;

    @FindBy(xpath = "//a[@href='#tab_offers']")
    private WebElementFacade offers;

    @FindBy(xpath = "//a[@href='#tab_statistics']")
    private WebElementFacade stat;

    @FindBy(xpath = "//a[@href='#tab_tools']")
    private WebElementFacade tools;

    @FindBy(xpath = "//a[@href='#products_and_oupons']")
    private WebElementFacade coup;



    public void switchlangToEng() {
        langSwitch.click();
        en.shouldBeCurrentlyVisible();
        en.click();
    }

    public void switchlangToBr() {
        langSwitch.click();
        br.shouldBeCurrentlyVisible();
        br.click();
    }

    public void goToReg() {
        reg.click();
    }

    public void goToAcc() {
        acc.click();
    }

    public void goToPub(){
        pub.click();
    }

    public void goToOffers(){
        offers.click();
    }

    public void goToStat(){
        stat.click();
    }

    public void goToTools(){
        tools.click();
    }

    public void goToCoup(){
        coup.click();
    }
}





