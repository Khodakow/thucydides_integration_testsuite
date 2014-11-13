package cityads.ca_thucydides_new_design.pages.refactor;

import cityads.ca_thucydides_new_design.pages.WemasterPages.DownloadsPage;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URL;


public class Popup extends PageObject {

    DownloadsPage page;


    public Popup(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//div[contains(@class,'popup modal')]")
    private WebElementFacade popup;

    @FindBy(xpath="//a[@id='id_el_link_action_links' and ancestor::*[contains(@class,'popup modal')]]")
    private WebElementFacade popupToolsLink;

    @FindBy(xpath="//textarea[ancestor::div[contains(@class,'popup')]]")
    private WebElementFacade codeTextarea;

    @FindBy(xpath="//a[contains(@class,'_copy_button') and ancestor::div[contains(@class,'popup')]]")
    private WebElementFacade copyButton;

    @FindBy(xpath=" //a[contains(@class,'submit') and ancestor::div[contains(@class,'popup')] ]")
    private WebElementFacade submit;

    //dynamic
    @FindBy(xpath = "//div[contains(@class,'back-popup')]/input[@type='text']")
    private WebElementFacade inputParameter;

    @FindBy(xpath="//input[contains(@class,'_search_box')]")
    private WebElementFacade inputSearchText;

    @FindBy(xpath="//input[@class='dark _title']")
    private WebElementFacade inputName;

    @FindBy(xpath="//a[@class='button dark submit _submit']")
    private WebElementFacade save;

    @FindBy(xpath = "//a[contains(@class,'button dark submit _confirm')]")
    private WebElementFacade yes;

    public void fillInputSearch(String text,String region){
        inputSearchText.waitUntilVisible();
        inputSearchText.click();
        inputSearchText.clear();
        inputSearchText.sendKeys(text);
        getDriver().findElement(By.xpath("//div[contains(text(),'"+text+"') and contains(@class,'item')]")).click();
        getDriver().findElement(By.xpath("//div[contains(@class,'item size-14 padding-6 col-white-hover') and contains(text(),'"+region+"')]")).click();
        submit.waitUntilVisible();
        submit.click();

    }
    public void fillInputwithotName(){
        inputSearchText.waitUntilVisible();
        inputSearchText.click();
        inputSearchText.clear();
        submit.waitUntilVisible();
        submit.click();

    }

    public WebElementFacade getPopup(){
        return element(popup);
    }

    public boolean checkPopupIsNotPresent(){
        return(popup.isCurrentlyVisible());
    }

    public boolean checkPopupHasToolsLink(){
        return popupToolsLink.isCurrentlyVisible();
    }

    public void waitPopup(){
        popup.waitUntilVisible();
    }


    public String get_curent_domain_name(){
        URL url;
        try {url = new URL(getDriver().getCurrentUrl());} catch (MalformedURLException ex) {url = null;}

        String host = url.getHost();
        return host;
    }

    public String getCodeFromTextarea(){
        copyButton.waitUntilVisible();
        WebElement couponsFeedCodename = page.couponsFeedCodeValue;
        String code =  couponsFeedCodename.getAttribute("data-clipboard-text");
        String curdomain = get_curent_domain_name();
        String code2 = code.replace("api.cityads.com",curdomain);
        Assert.assertTrue(!code.isEmpty());
        if(get_curent_domain_name().contains("cityads")){
            return code;
        }
        return code2;

    }

    public void checkPopupIsNotDisplayed() {
        popup.shouldNotBeCurrentlyVisible();
    }

    public void clickParameterWithText(String text){
        getDriver().findElement(By.xpath("//div[contains(@class,'ib') and contains(text(),'"+text+"')]")).click();
    }

    public void fillPopupInputSearchParameter(String text){
        inputParameter.waitUntilVisible();
        inputParameter.clear();
        inputParameter.sendKeys(text);
        this.waitABit(1000);
        clickParameterWithText(text);
        this.waitABit(1000);

    }

    public void fillPopupInputSearchParameterWithoutClick(String text){
        inputParameter.waitUntilVisible();
        inputParameter.clear();
        inputParameter.sendKeys(text);
        this.waitABit(1000);

    }


    public void fillName(String name) {
        inputName.clear();
        inputName.sendKeys(name);
        save.click();

    }

    public void clickYes() {
        yes.waitUntilVisible();
        yes.click();
    }
}





