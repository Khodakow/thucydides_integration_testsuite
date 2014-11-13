package cityads.ca_thucydides_new_design.pages.refactor;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;


public class Front extends BasePage {


    public Front(WebDriver driver) {
        super(driver);
    }


    private Popup popup;
    private Form form;
    private Welcome welcome;
    private Table table;


    @FindBy(xpath = "//a[@class='login-link' and contains(@href,'dashboard')]")
    private WebElementFacade cabinet;

    @FindBy(xpath = "//a[@class='login-link' and contains(@href,'manager')]")
    private WebElementFacade cabinetMgr;

    @FindBy(xpath = "//div[@id='popup-login']")
    private WebElementFacade popupLogin;

    @FindBy(xpath = "//a[@id='popup-login-link' and ancestor::div[@class='link relative' and ancestor::li[@class='login']]]")
    private WebElementFacade popupLoginLink ;

    @FindBy(xpath = "//input[@name='nick']")
    private WebElementFacade popupNick;

    @FindBy(xpath = "//input[@name='passwd']")
    private WebElementFacade popupPasswd;

    @FindBy(xpath = "//div[@id='popup-login']")
    private WebElementFacade saveCheckbox;

    @FindBy(xpath = "//span[@class='submit' and ancestor::form[ancestor::div[@class='popup-padding']]]")
    private WebElementFacade popupLoginSubmit;

    @FindBy(xpath="//form[@class='new-login-form']")
    private WebElementFacade loginFormBig;

    @FindBy(xpath="//input[@id='submit_ok']")
    private WebElementFacade loginFormBigSubmit;

    @FindBy(xpath="//div[@class='opacity5 back-white']")
    private WebElementFacade opacity;

    public void login(){
        String passwd = System.getProperty("password");
        String name = System.getProperty("user");

        if(!getDriver().getPageSource().contains("/webmaster_pro/office/dashboard")) {
            popupLoginLink.waitUntilVisible();
            popupLoginLink.click();
            waitABit(500);
            popupLogin.waitUntilVisible();
            popupNick.waitUntilVisible();
            popupNick.clear();
            waitABit(500);
            popupPasswd.waitUntilVisible();
            popupPasswd.clear();
            waitABit(500);
            popupNick.sendKeys(name);
            waitABit(500);
            popupPasswd.sendKeys(passwd);
            waitABit(500);
            popupLoginSubmit.waitUntilVisible();
            popupLoginSubmit.click();
            waitABit(15000);
            opacity.waitUntilNotVisible();
        }
        else{
            cabinet.click();
            waitABit(15000);
        }


        opacity.waitUntilNotVisible();
        waitForSpinnerDissapear();

        if(getDriver().getCurrentUrl().contains("/login")){
            this.evaluateJavascript("$('form').eq(0).remove()");
            popupNick.waitUntilVisible();
            popupNick.clear();
            popupPasswd.waitUntilVisible();
            popupPasswd.clear();
            popupNick.sendKeys(name);
            popupPasswd.sendKeys(passwd);
            loginFormBigSubmit.waitUntilVisible();
            loginFormBigSubmit.click();
            opacity.waitUntilNotVisible();
        }
    }

    public void loginMgr(){
        String passwd = System.getProperty("passwordMgr");
        String name = System.getProperty("userMgr");

        if(!getDriver().getPageSource().contains("/manager")) {
            popupLoginLink.waitUntilVisible();
            popupLoginLink.click();
            waitABit(500);
            popupLogin.waitUntilVisible();
            popupNick.waitUntilVisible();
            popupNick.clear();
            waitABit(500);
            popupPasswd.waitUntilVisible();
            popupPasswd.clear();
            waitABit(500);
            popupNick.sendKeys(name);
            waitABit(500);
            popupPasswd.sendKeys(passwd);
            waitABit(500);
            popupLoginSubmit.waitUntilVisible();
            popupLoginSubmit.click();
            waitABit(15000);
            opacity.waitUntilNotVisible();
        }
        else{
            cabinetMgr.click();
            waitABit(15000);
        }


        opacity.waitUntilNotVisible();


        if(getDriver().getCurrentUrl().contains("/login")){
            this.evaluateJavascript("$('form').eq(0).remove()");
            popupNick.waitUntilVisible();
            popupNick.clear();
            popupPasswd.waitUntilVisible();
            popupPasswd.clear();
            popupNick.sendKeys(name);
            popupPasswd.sendKeys(passwd);
            loginFormBigSubmit.waitUntilVisible();
            loginFormBigSubmit.click();
            opacity.waitUntilNotVisible();
        }
        this.evaluateJavascript("$('.usabilla_live_button_container').remove();");
    }

    public void loginBr(){
        String passwd = System.getProperty("passwordBrazil");
        String name = System.getProperty("userBrazil");

        if(!getDriver().getPageSource().contains("/webmaster_pro/office/dashboard")) {
            popupLoginLink.waitUntilVisible();
            popupLoginLink.click();
            waitABit(500);
            popupLogin.waitUntilVisible();
            popupNick.waitUntilVisible();
            popupNick.clear();
            waitABit(500);
            popupPasswd.waitUntilVisible();
            popupPasswd.clear();
            waitABit(500);
            popupNick.sendKeys(name);
            waitABit(500);
            popupPasswd.sendKeys(passwd);
            waitABit(500);
            popupLoginSubmit.waitUntilVisible();
            popupLoginSubmit.click();
            waitABit(15000);
            opacity.waitUntilNotVisible();
        }
        else{
            cabinet.click();
            waitABit(15000);
        }


        opacity.waitUntilNotVisible();
        waitForSpinnerDissapear();

        if(getDriver().getCurrentUrl().contains("/login")){
            this.evaluateJavascript("$('form').eq(0).remove()");
            popupNick.waitUntilVisible();
            popupNick.clear();
            popupPasswd.waitUntilVisible();
            popupPasswd.clear();
            popupNick.sendKeys(name);
            popupPasswd.sendKeys(passwd);
            loginFormBigSubmit.waitUntilVisible();
            loginFormBigSubmit.click();
            opacity.waitUntilNotVisible();
        }
    }

    public void enterAfterLogin(){
        cabinet.waitUntilVisible();
        cabinet.click();
        waitForSpinnerDissapear();
    }

    public boolean checkIsOnDashboard(){
        waitForSpinnerDissapear();
        table.waitTable();
        boolean dashboardCheck = getDriver().getCurrentUrl().contains("dashboard");
        return dashboardCheck;
    }

    public void loginAdv() {
        String passwd = System.getProperty("passwordAdv");
        String name = System.getProperty("userAdv");

        if(!getDriver().getPageSource().contains("/webmaster_pro/office/advertiser")) {
            popupLoginLink.waitUntilVisible();
            popupLoginLink.click();
            waitABit(500);
            popupLogin.waitUntilVisible();
            popupNick.waitUntilVisible();
            popupNick.clear();
            waitABit(500);
            popupPasswd.waitUntilVisible();
            popupPasswd.clear();
            waitABit(500);
            popupNick.sendKeys(name);
            waitABit(500);
            popupPasswd.sendKeys(passwd);
            waitABit(500);
            popupLoginSubmit.waitUntilVisible();
            popupLoginSubmit.click();
            waitABit(15000);
            opacity.waitUntilNotVisible();
        }
        else{
            cabinet.click();
            waitABit(15000);
        }


        opacity.waitUntilNotVisible();
        waitForSpinnerDissapear();

        if(getDriver().getCurrentUrl().contains("/login")){
            this.evaluateJavascript("$('form').eq(0).remove()");
            popupNick.waitUntilVisible();
            popupNick.clear();
            popupPasswd.waitUntilVisible();
            popupPasswd.clear();
            popupNick.sendKeys(name);
            popupPasswd.sendKeys(passwd);
            loginFormBigSubmit.waitUntilVisible();
            loginFormBigSubmit.click();
            waitForSpinnerDissapear();

        }
    }
}





