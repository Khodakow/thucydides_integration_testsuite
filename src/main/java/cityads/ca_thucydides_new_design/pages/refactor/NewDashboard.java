package cityads.ca_thucydides_new_design.pages.refactor;

import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


public class NewDashboard extends BasePage {

    public NewDashboard(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//a[@id='lnk-all-offers']")
    private WebElementFacade alloffersink;
    @FindBy(xpath="//div[@id='mainSummary']")
    private WebElementFacade financeSummary;
    @FindBy(xpath="//div[@id='mainNews']")
    private WebElementFacade news;
    @FindBy(xpath="//a[@class='col-evil underline-h']")
    private WebElementFacade newslinks;
    @FindBy(xpath="//a[@class='size-14 col-black")
    private WebElementFacade saleLinks;
    @FindBy(xpath="//a[@class='col-black size-14']")
    private WebElementFacade hotOffersLinks;
    @FindBy(xpath="//div[@class='float-left size-20 col-black']")
    private WebElementFacade hotoffersBlock;



    public void clickAlloffersLink(){
        alloffersink.shouldBeCurrentlyVisible();
        alloffersink.waitUntilVisible();
        alloffersink.click();
        waitForSpinnerDissapear();
    }

    public void checkAllStucture(){
        financeSummary.isCurrentlyVisible();
        news.isCurrentlyVisible();
        newslinks.isCurrentlyVisible();
        saleLinks.isCurrentlyVisible();
        hotOffersLinks.isCurrentlyVisible();
        hotoffersBlock.isCurrentlyVisible();

    }


}





