package cityads.ca_thucydides_new_design.pages.refactor;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


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

    @FindBy(xpath = "//h1[contains(text(),'404 Error page')]")
    private WebElement notFound;

    @FindBy(xpath = "//span[@class='submit' and ancestor::form[ancestor::div[@class='popup-padding']]]")
    private WebElementFacade popupLoginSubmit;

    @FindBy(xpath="//form[@class='new-login-form']")
    private WebElementFacade loginFormBig;

    @FindBy(xpath="//input[@id='submit_ok']")
    private WebElementFacade loginFormBigSubmit;

    @FindBy(xpath="//div[@class='opacity5 back-white']")
    private WebElementFacade opacity;

    @FindBy(xpath="//a[@id='hotoffersEdit']")
    private WebElementFacade hotOffersEditor;

    @FindBy(xpath="//label[contains(@class,'checkbox')]")
    private WebElementFacade editorCheckbox;

    @FindBy(xpath="//a[contains(@class,'dark  submit')]")
    private WebElementFacade applyButton;

    @FindBy(xpath="//a[contains(@id,'save')]")
    private WebElementFacade saveForm;

    @FindBy(xpath="//a[@id='promoEdit']")
    private WebElementFacade eventEditor;

    @FindBy(xpath="(//div[@class='item level-2 empty']/div[position()=2])[1]")
    private WebElementFacade goodsCategoryCheckbox;

    @FindBy(xpath="(//div[@class='ib _category_name pointer' and descendant::span[descendant::span[@format='num']]])[1]")
    private WebElementFacade goodsCategotyLink;

    @FindBy(xpath=" (//a[@id='category_show_selected_items'])[1]")
    private WebElementFacade goodsCategorShowButton;

    @FindBy(xpath="(//div[@class='_filter_line' and descendant::div[descendant::span[@data-bind='html: title' and contains(text(),'Категории')]]])/div[contains(@data-bind,'foreach:')]")
    private WebElementFacade goodaCategoryFilterResult;

    @FindBy(xpath="//span[@class='col-blue _header_balance']")
    private WebElementFacade balanceWm;


    public void login(){
        String passwd = System.getProperty("password");
        String name = System.getProperty("user");

        if(!cabinet.isCurrentlyVisible()) {
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
            waitABit(5000);
            opacity.waitUntilNotVisible();
        }
        else{
            cabinet.click();
            waitABit(5000);
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
        table.waitOverview();
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



        waitForSpinnerDissapear();
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
            waitForSpinnerDissapear();

        }
    }



    public void hotOffersedit(){
        hotOffersEditor.waitUntilVisible();
        hotOffersEditor.click();
        waitABit(2000);
        editorCheckbox.waitUntilVisible();
        editorCheckbox.click();
        applyButton.waitUntilVisible();
        applyButton.click();



    }


    public void eventEdit(){
        eventEditor.waitUntilVisible();
        eventEditor.click();
        waitABit(2000);
        editorCheckbox.waitUntilVisible();
        editorCheckbox.click();
        applyButton.waitUntilVisible();
        applyButton.click();
    }


    public void saveForm(){
        saveForm.waitUntilVisible();
        saveForm.click();

    }

    public void clickAndShowGoodsCategoty(){
        goodsCategoryCheckbox.waitUntilVisible().click();
        goodsCategorShowButton.waitUntilVisible().click();
        waitForSpinnerDissapear();

    }

    public void clickAndShowGoodsCategotyBylink(){
        goodsCategotyLink.waitUntilVisible().click();
        waitForSpinnerDissapear();
        waitABit(5000);

    }

    public void checkCategoryFilterResult(){
        waitForSpinnerDissapear();
        goodaCategoryFilterResult.shouldBeCurrentlyVisible();
    }

    public void loginMgrWrongPwd() {
        String passwd = DataGenerator.getRandomString();
        String name = System.getProperty("userMgr");

        if (!getDriver().getPageSource().contains("/manager")) {
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
        }
    }

    public String getbalance(){
        return  balanceWm.getText().trim().replace("/","").replace("'","").replace("`","").trim();
    }


    public void checkNot404() {
        element(notFound).shouldNotBeCurrentlyVisible();
    }
}





