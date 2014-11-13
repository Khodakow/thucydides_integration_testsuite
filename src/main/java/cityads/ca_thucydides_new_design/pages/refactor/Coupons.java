package cityads.ca_thucydides_new_design.pages.refactor;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class Coupons extends BasePage {

    public Coupons(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//table[@class='no-zebra']/tbody/tr/td[preceding-sibling::td[contains(text(),'Статус') or contains(text(),'Status')]]")
    private List<WebElement> statuses;

    @FindBy(xpath="//*[@id='submit_ok']")
    private WebElementFacade submit;

    @FindBy(xpath="//form[@action='/action.php' and @method='post' and contains(@redirect,'/tools/feeds') ]")
    private WebElementFacade feeedForm;

    @FindBy(xpath="//button[@class='button submit create no-right']")
    private WebElementFacade createTool;

    @FindBy(xpath="//input[@id='id_el_text_field_name']")
    private WebElementFacade name;

    public List<WebElement> getStatuses() {
        return statuses;
    }

    public void resetFilter() {
        this.evaluateJavascript("$('#id_el_input_filter_reset').click()");
        this.waitABit(1000);
        this.waitForSpinnerDissapear();
    }

    public void clickCreateTool(){
        waitForSpinnerDissapear();
        createTool.waitUntilVisible();
        createTool.click();
        waitForSpinnerDissapear();
    }

    public void createFeed(String feedName){
        waitForSpinnerDissapear();
        feeedForm.waitUntilVisible();
        name.waitUntilVisible();
        name.clear();
        name.sendKeys(feedName);
        submit.waitUntilVisible();
        submit.click();
        waitForSpinnerDissapear();

    }

    public boolean isOnCouponsPage() {
        return this.getDriver().getCurrentUrl().contains("feeds/coupons_feed");
    }
}





