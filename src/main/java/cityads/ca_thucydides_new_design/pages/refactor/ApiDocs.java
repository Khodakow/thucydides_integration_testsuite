package cityads.ca_thucydides_new_design.pages.refactor;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;


public class ApiDocs extends BasePage {


    public ApiDocs(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//span[@class='s-lang _lang-switch']")
    private WebElementFacade apiLangSwitch;

    @FindBy(xpath="//a[contains(@href,'?lang=en')]")
    private WebElementFacade eng;

    @FindBy(xpath="//a[contains(@href,'/api/dev/auth')]")
    private WebElementFacade authorization;

    @FindBy(xpath="//a[contains(@href,'interface/soap')]")
    private WebElementFacade soap;

    @FindBy(xpath="//a[contains(@href,'interface/rest')]")
    private WebElementFacade rest;

    @FindBy(xpath="//a[contains(@href,'quoting')]")
    private WebElementFacade quoting;

    @FindBy(xpath="//a[contains(@href,'language')]")
    private WebElementFacade language;

    @FindBy(xpath="(//a[contains(@href,'webmaster/offers')])[1]")
    private WebElementFacade offers;

    @FindBy(xpath="//a[contains(@href,'api/dev/webmaster/list')]")
    private WebElementFacade list;

    @FindBy(xpath="//a[contains(@href,'api/dev/webmaster/user')]")
    private WebElementFacade user;

    @FindBy(xpath="//a[contains(@href,'api/dev/webmaster/goods')]")
    private WebElementFacade goods;

    @FindBy(xpath="//a[contains(@href,'api/dev/webmaster/stat')]")
    private WebElementFacade stat;

    @FindBy(xpath="//a[contains(@href,'api/dev/webmaster/tools')]")
    private WebElementFacade tools;

    @FindBy(xpath="//a[contains(@href,'api/dev/lib')]")
    private WebElementFacade lib;

    @FindBy(xpath="//div[@class='header-top']")
    private WebElementFacade headerTop;

    @FindBy(xpath="//a[@href='https://www.facebook.com/cityadsmedia']")
    private WebElementFacade buttonFacebook;

    @FindBy(xpath="//a[@href='https://twitter.com/cityads_ru']")
    private WebElementFacade buttonTwitter;

    @FindBy(xpath="//a[@href='http://vk.com/cityads']")
    private WebElementFacade buttonVkontakte;




    public void clickAuthorization(){
        authorization.waitUntilVisible();
        authorization.click();

    }

    public void clickSoap(){
        soap.waitUntilVisible();
        soap.click();

    }

    public void clickRest(){
        rest.waitUntilVisible();
        rest.click();

    }

    public void clickQuoting(){
        quoting.waitUntilVisible();
        quoting.click();

    }

    public void clickLang(){
        language.waitUntilVisible();
        language.click();

    }

    public void clickOffers(){
        offers.waitUntilVisible();
        offers.click();

    }

    public void clickList(){
        list.waitUntilVisible();
        list.click();

    }

    public void clickUser(){
        user.waitUntilVisible();
        user.click();

    }

    public void clickGoods(){
        goods.waitUntilVisible();
        goods.click();

    }

    public void clickStat(){
        stat.waitUntilVisible();
        stat.click();

    }

    public void clickTools(){
        tools.waitUntilVisible();
        tools.click();

    }


    public void clickLib(){
        lib.waitUntilVisible();
        lib.click();

    }




    public void switchlangToEng(){

        apiLangSwitch.waitUntilVisible();
        apiLangSwitch.click();
        eng.waitUntilVisible();
        eng.click();
        this.evaluateJavascript("$('i').html('')");
    }

    public void checkPanelIsVisible(){
        headerTop.shouldBeCurrentlyVisible();
    }

    public void checkSocialButtons(){
        buttonFacebook.shouldBeCurrentlyVisible();
        buttonTwitter.shouldBeCurrentlyVisible();
        buttonVkontakte.shouldBeCurrentlyVisible();
    }

    public void clickFacebook(){
        buttonFacebook.waitUntilVisible();
        buttonFacebook.click();
    }


    public void clickTwitter() {
        buttonTwitter.waitUntilVisible();
        buttonTwitter.click();
}


    public void clickVk() {
        buttonVkontakte.waitUntilVisible();
        buttonVkontakte.click();
        }
    }