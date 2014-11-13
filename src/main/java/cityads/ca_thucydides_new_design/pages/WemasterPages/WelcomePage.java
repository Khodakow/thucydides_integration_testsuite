package cityads.ca_thucydides_new_design.pages.WemasterPages;

import cityads.ca_thucydides_new_design.pages.*;

import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class WelcomePage extends MainPage {


    public WelcomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//div[contains(concat(' ', normalize-space(@class), ' '), 'popup modal show ') ]")
    public WebElement welcomeWindow;

    public boolean checkWelcomeIsDisplayed(){
        return element(welcomeWindow).isCurrentlyVisible();
    }

    public WebElement getFirstLang(){
        return welcomeWindow.findElement(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '), 'item size-14 padding-6 col-white-hover') ]"));
    }

    public WebElement getFirstPageDaleeButton(){
        return getDriver().findElement(By.partialLinkText(">"));
    }

    public WebElement getSecondPageDaleeButton() {
        return getDriver().findElement(By.partialLinkText(">"));
    }

    public WebElement getThirdPageDaleeButton() {
        return getDriver().findElement(By.partialLinkText("охранить"));
    }

    @FindBy(css="div.jqvmap-zoomout")
    public WebElement welcomeMap;

    @FindBy(xpath="//div[@value='ru']")
    public WebElement welcomeRuLang;

    @FindBy(xpath="//div[@data-bind='html: title, css: {'col-ccc': !active, 'col-white': active}']")
    public WebElement firstUncheckedCheckbox;

    //
    public WebElement getFirstUncheckedCheckbox(){
        return popup.findElement(By.xpath("//label[contains(concat(' ', normalize-space(@class), ' '), 'checkbox dark') ]")).findElement(By.tagName("div"));
    }

    @FindBy(xpath="/html/body/div[3]/div[3]/div[1]/div[2]/div/div[3]/div[1]/div[1]")
    public WebElement filterRusultBlock;

    @FindBy(xpath="//a[@class='button dark _next_button submit']")
    public WebElementFacade nexButton;


    @FindBy(xpath="//div[@class='input-button optional _modal_button']")
    private WebElementFacade selectTimeZoneButton;


    @FindBy(xpath="(//div[@class='items overflow _scrollable _has_scrollable'])[3]/div")
    private WebElementFacade firstTimeZone;


    @FindBy(xpath="(//div[@class='items overflow _scrollable _has_scrollable'])[2]/div[1]")
    private WebElementFacade firstRegion;

    @FindBy(xpath="//a[@class='button dark  submit']")
    private WebElementFacade apply;

    @FindBy(xpath="(//label[@class='checkbox dark'])[1]")
    private WebElementFacade firstCheckbox;

    @FindBy(xpath="(//label[@class='checkbox dark'])[2]")
    private WebElementFacade secondCheckbox;

    public void fillWelcomePageSocondPage(){
        selectTimeZoneButton.click();
        firstRegion.click();
        firstTimeZone.click();
        apply.click();
        firstCheckbox.waitUntilVisible();
        firstCheckbox.click();
        secondCheckbox.click();
    }


}





