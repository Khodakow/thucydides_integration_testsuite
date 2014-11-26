package cityads.ca_thucydides_new_design.pages.refactor;

import net.thucydides.core.annotations.findby.By;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class OfferCard extends BasePage {


    public OfferCard(WebDriver driver) {
        super(driver);
    }

    private String offerName;
    private Popup popup;

    @FindBy(xpath="//a[contains(@id,'id_el_link_action_start_work')]")
    private WebElementFacade startWork;

    @FindBy(xpath="//h1[@class='ib']")
    private WebElementFacade h1Offername;

    @FindBy(xpath="//a[contains(@data-href,'action=detailSW')]")
    private WebElementFacade analyticsTab;


    @FindBy(xpath="//a[contains(@data-href,'action=detailTools')]")
    private WebElementFacade instrumentsTab;

    @FindBy(xpath="//a[contains(@data-href,'action=detailMain')]")
    private WebElement dashboardTab;

    @FindBy(xpath="//table[@id='table_wm.action_tool_links']/tbody/tr/td[position()=4 or position()=5 or position()=6 or position()=7]")
    private List<WebElement> instrumentsTableData;

    @FindBy(xpath="(//table[@id='table_wm.action_tool_goods']/tbody/tr)[last()]/td/a[contains(@class,'icon code pointer')]")
    private WebElementFacade originalGoodsGetCode;

    @FindBy(xpath = "(//a[contains(@class,'_create_link _is_banner')])[1]")
    private WebElement getBannerCode;

    public void isOnOffercardPage(){
        startWork.waitUntilVisible();
        h1Offername.waitUntilVisible();
    }

    public String getOfferName(){
        h1Offername.waitUntilVisible();
        return h1Offername.getText();
    }

    public void clickStartWork(){
        startWork.waitUntilVisible();
        startWork.click();
    }


    public void goToAnalytics() {
        analyticsTab.waitUntilVisible();
        analyticsTab.click();
        waitForSpinnerDissapear();
    }

    public void goToInstruments() {
        instrumentsTab.waitUntilVisible();
        instrumentsTab.click();
        waitForSpinnerDissapear();
    }

    public ArrayList<String> getInstrumentsTableTada(){
        ArrayList<String> data = new ArrayList<String>();
        for(WebElement elem: instrumentsTableData){
            data.add(elem.getText());
        }
        return data;
    }

    public void clickGoodsOriginalGetCode() {
        waitForSpinnerDissapear();
        originalGoodsGetCode.waitUntilVisible();
        originalGoodsGetCode.click();
        popup.waitPopup();


    }

    public String getOfferSite() throws MalformedURLException {
        String site =  getDriver().findElement(By.xpath("//div[contains(@class,'about-offer-short-info')]/p/a")).getAttribute("href");
        return new URL(site).getHost();
    }

    public String getBannerCode() {
        waitForSpinnerDissapear();
        element(getBannerCode).waitUntilVisible();
        getBannerCode.click();
        popup.waitPopup();
        waitABit(5000);
        return popup.getCodeFromTextarea();
    }

    public void goToDashboardTab() {
        waitForSpinnerDissapear();
        dashboardTab.click();
        waitForSpinnerDissapear();
    }
}





