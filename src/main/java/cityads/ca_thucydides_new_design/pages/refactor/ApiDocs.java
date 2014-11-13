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

    @FindBy(xpath="//a[@href='?lang=en']")
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



    public void clickAuthorization(){
        authorization.waitUntilVisible();
        authorization.click();
        authorization.waitUntilVisible();
    }

    public void clickSoap(){
        soap.waitUntilVisible();
        soap.click();
        soap.waitUntilVisible();
    }

    public void clickRest(){
        rest.waitUntilVisible();
        rest.click();
        rest.waitUntilVisible();
    }

    public void clickQuoting(){
        quoting.waitUntilVisible();
        quoting.click();
        quoting.waitUntilVisible();
    }

    public void clickLang(){
        language.waitUntilVisible();
        language.click();
        language.waitUntilVisible();
    }

    public void clickOffers(){
        offers.waitUntilVisible();
        offers.click();
        offers.waitUntilVisible();
    }

    public void clickList(){
        list.waitUntilVisible();
        list.click();
        list.waitUntilVisible();
    }

    public void clickUser(){
        user.waitUntilVisible();
        user.click();
        user.waitUntilVisible();
    }

    public void clickGoods(){
        goods.waitUntilVisible();
        goods.click();
        goods.waitUntilVisible();
    }

    public void clickStat(){
        stat.waitUntilVisible();
        stat.click();
        stat.waitUntilVisible();
    }

    public void clickTools(){
        tools.waitUntilVisible();
        tools.click();
        tools.waitUntilVisible();
    }


    public void clickLib(){
        lib.waitUntilVisible();
        lib.click();
        lib.waitUntilVisible();
    }




    public void switchlangToEng(){

        apiLangSwitch.waitUntilVisible();
        apiLangSwitch.click();
        eng.waitUntilVisible();
        eng.click();
        apiLangSwitch.waitUntilVisible();
        this.evaluateJavascript("$('i').html('')");
    }

}





