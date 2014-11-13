package cityads.ca_thucydides_new_design.pages.highload;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

/**
 * Created by s.lugovskiy on 22.07.2014.
 */
public class BannerstestPage extends PageObject{

    @FindBy(name="script")
    private WebElementFacade textarea;

    @FindBy(id="testinput")
    private WebElementFacade goButton;

    @FindBy(xpath="//a[contains(@href,'click')]")
    private WebElementFacade bannerIMG;

    @FindBy(xpath="//a[contains(@href,'cid')]")
    private WebElementFacade bannerLink;

    @FindBy(xpath="//a[contains(@href,'cityadspix')][1]")
    private WebElementFacade shiftLink;

    public BannerstestPage(WebDriver driver) {
        super(driver);
    }

    public String getBannerLinkHref(){
        return bannerLink.getAttribute("href");
    }


    public void submitCode(String code){
        textarea.waitUntilVisible();
        textarea.sendKeys(code);
        goButton.click();
    }

    public void clickBanner(){
        bannerIMG.waitUntilVisible();
        bannerIMG.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void goToTestForm(){
        getDriver().get("http://test_result.tester.sagl/index.php?page=banner");
    }

    public void checkSHiftLink() {
        this.waitABit(20000);
        shiftLink.shouldBeCurrentlyVisible();
        shiftLink.click();
        this.waitABit(10000);
    }
}
