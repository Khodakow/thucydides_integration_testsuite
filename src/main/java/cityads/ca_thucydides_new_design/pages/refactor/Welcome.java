package cityads.ca_thucydides_new_design.pages.refactor;

import net.thucydides.core.annotations.findby.By;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;


public class Welcome extends BasePage {

    public Welcome(WebDriver driver) {
        super(driver);
    }

    private Popup popup;
    private Table table;

    @FindBy(xpath="//div[contains(@class,'popup modal') and contains(@class,'transition') and descendant::div[@class='modal-tabs'] and descendant::div[contains(@class,'buttons')]]")
    private WebElementFacade welcome;

    @FindBy(xpath = "//div[@class='content ']")
    private WebElementFacade zones;

    //нулевой шаг
    @FindBy(xpath="//div[@class='relative' and contains(@style,'background: url(/images/start/welcome_page_bg.png)')]")
    private WebElementFacade welcomeBaseStep;

    @FindBy(xpath="//div[@class='hover_me _no']")
    private WebElementFacade welcomeBaseStepNo;

    @FindBy(xpath="//div[@class='hover_me _yes']")
    private WebElementFacade welcomeBaseStepYes;

    //=========
    @FindBy(xpath="//div[contains(@class,'popup modal') and contains(@class,'transition3') and descendant::div[@class='modal-tabs hide'] and descendant::div[contains(@class,'buttons')]]")
    private WebElementFacade errorPopup;

    @FindBy(xpath="//div[contains(@class,'popup modal') and contains(@class,'transition3') and descendant::div[@class='modal-tabs hide'] and descendant::div[contains(@class,'buttons')]]/div/a")
    private WebElementFacade errorPopupClose;

    @FindBy(xpath="//div[@class='buttons _buttons_place']")
    private WebElementFacade welcomeButtons;

    @FindBy(xpath="//div[@class='buttons _buttons_place']/a[2]")
    public WebElementFacade nextButton3Step;

    @FindBy(xpath="(//div[contains(@class,'_modal_tabs')]/div[1][contains(@class,'active')])")
    private WebElementFacade tab1ActiveIndicator;

    @FindBy(xpath="(//div[contains(@class,'_modal_tabs')]/div[2][contains(@class,'active')])")
    private WebElementFacade tab2ActiveIndicator;

    @FindBy(xpath="(//div[contains(@class,'_modal_tabs')]/div[3][contains(@class,'active')])")
    private WebElementFacade tab3ActiveIndicator;

    @FindBy(xpath="//div[contains(@class,'_traffic_select')]")
    private WebElementFacade trafficSelect;

    private WebElementFacade getNextButton(){
        return welcomeButtons.thenFindAll(org.openqa.selenium.By.tagName("a")).get(0);
    }

    private WebElementFacade getNext2Button(){
        return welcomeButtons.thenFindAll(org.openqa.selenium.By.tagName("a")).get(1);
    }

    private WebElementFacade getNext3Button(){
        return welcomeButtons.thenFindAll(org.openqa.selenium.By.tagName("a")).get(2);
    }

    private WebElementFacade getSaveButton(){
        return welcomeButtons.thenFindAll(org.openqa.selenium.By.tagName("a")).get(1);
    }

    @FindBy(xpath = "//div[text()='BRL']")
    private WebElementFacade brl;

    @FindBy(xpath="//div[contains(@class,'_map')]")
    private WebElementFacade map;

    @FindBy(xpath = "//div[@value='pt']")
    private WebElementFacade brLang;

    @FindBy(xpath = "//a[text()='BRL']")
    private WebElementFacade brLangInAutoItems;

    @FindBy(xpath="//input[@class='dark _main_domain']")
    private WebElementFacade mainDomain;


    public void callWelcomepage(){
        if(!welcome.isCurrentlyVisible()) {
            this.evaluateJavascript("welcomToCityAds()");
        }
    }

    public void closeErrorPopup(){
        if(errorPopup.isCurrentlyVisible()){
            errorPopupClose.click();
            errorPopupClose.shouldNotBeCurrentlyVisible();
        }
    }

    public void fillWelcomePage(){
        waitForSpinnerDissapear();
        waitABit(1000);

        if(errorPopup.isCurrentlyVisible()){
            errorPopupClose.click();
            errorPopupClose.shouldNotBeCurrentlyVisible();
        }

        fillBaseStepYes();

        if(welcome.isCurrentlyVisible()) {
            tab1ActiveIndicator.waitUntilVisible();
            getNextButton().waitUntilVisible();
            getNextButton().click();
            waitForSpinnerDissapear();
            tab2ActiveIndicator.waitUntilVisible();
            map.waitUntilVisible();

            //fillRegion();//добавляем костыль и заполняем первой тайм зоной т к нет россии

            getNext2Button().waitUntilVisible();
            getNext2Button().click();

            //3 шаг типы траффика
            fillTrafficTypes();

            map.waitUntilVisible();
            getSaveButton().waitUntilVisible();
            getSaveButton().click();
            waitForSpinnerDissapear();
            table.waitOverview();
            waitForSpinnerDissapear();
        }
        table.waitOverview();
        this.evaluateJavascript("$('.usabilla_live_button_container').remove();");
        waitForSpinnerDissapear();
    }

    public void fillBaseStepYes(){
        if(welcomeBaseStep.isCurrentlyVisible()){
            welcomeBaseStepYes.click();
            waitForSpinnerDissapear();
        }
    }

    public void fillTrafficTypes(){
        if(trafficSelect.isCurrentlyVisible()){
            String inputClass = (String)this.evaluateJavascript("return $('div[class*=\"item size-14\"]>label').attr('class')");                //кликаем только если чекбокс уже не отмечен
            if(!inputClass.contains("checked")){
                evaluateJavascript("$('div[class*=\"item size-14\"]>label').each(function(){this.click()});");
            }//клик по всем типам траффика
            waitForSpinnerDissapear();
            mainDomain.waitUntilVisible();
            mainDomain.clear();
            mainDomain.sendKeys("http://testdomainpleaseingnore.ru");
            nextButton3Step.waitUntilVisible();
            nextButton3Step.click();
            waitForSpinnerDissapear();
        }
    }

    public void fillRegion(){
        this.evaluateJavascript("$('div[class=\"input-button optional _modal_button\"]').trigger('click');");
        this.waitABit(1000);
        this.evaluateJavascript("$('div[value=\"Австрия\"]').click()");
        this.waitABit(1000);
        this.evaluateJavascript("$('div[class*=\"item size-14\"]:contains(GMT):eq(0)').click()");
        this.waitABit(1000);
        this.evaluateJavascript("$('a[class=\"button dark _submit submit\"]').click()");
        this.waitABit(1000);
        this.evaluateJavascript("$('label[class=\"checkbox dark\"]:eq(0)>input').click()");
        this.waitABit(1000);
        this.evaluateJavascript("$('label[class=\"checkbox dark\"]:eq(0)>input').click()");
        this.waitABit(1000);

    }

    //после того как заходит пользователь ему принудительно вызывается велком пейдж и ставится БР валюта
    public void fillWelcomePageBr(){
        waitForSpinnerDissapear();
        waitABit(15000);

        if(errorPopup.isCurrentlyVisible()){
            errorPopupClose.click();
            errorPopupClose.shouldNotBeCurrentlyVisible();
        }

        System.out.println("WP visible: "+welcome.isCurrentlyVisible());
        System.out.println("WP 0 STEP visible: "+welcomeBaseStep.isCurrentlyVisible());

        if((!welcome.isCurrentlyVisible() && !welcomeBaseStep.isCurrentlyVisible())){
            evaluateJavascript("welcomToCityAds();");
            waitForSpinnerDissapear();
        }

        fillBaseStepYes();

        if(welcome.isCurrentlyVisible()) {
            tab1ActiveIndicator.waitUntilVisible();
            brLang.waitUntilVisible();
            brLang.click();
            getNextButton().waitUntilVisible();
            getNextButton().click();
            waitForSpinnerDissapear();
            tab2ActiveIndicator.waitUntilVisible();
            map.waitUntilVisible();
            getNext2Button().waitUntilVisible();
            getNext2Button().click();
            waitForSpinnerDissapear();

            //3 шаг типы траффика
            fillTrafficTypes();

            map.waitUntilVisible();
            if(brl.isCurrentlyVisible()){
                brl.click();
                brLangInAutoItems.waitUntilVisible();
                brLangInAutoItems.click();
            }

            getSaveButton().waitUntilVisible();
            getSaveButton().click();
            waitForSpinnerDissapear();
            table.waitTable();
            waitForSpinnerDissapear();
        }
        else{
            waitForSpinnerDissapear();
            fillBaseStepYes();
            tab1ActiveIndicator.waitUntilVisible();
            brLang.waitUntilVisible();
            brLang.click();
            getNextButton().waitUntilVisible();
            getNextButton().click();
            waitForSpinnerDissapear();
            tab2ActiveIndicator.waitUntilVisible();
            map.waitUntilVisible();
            getNext2Button().waitUntilVisible();
            getNext2Button().click();
            waitForSpinnerDissapear();
            map.waitUntilVisible();
            if(brl.isCurrentlyVisible()){
                brl.click();
                brLangInAutoItems.waitUntilVisible();
                brLangInAutoItems.click();
            }
            getSaveButton().waitUntilVisible();
            getSaveButton().click();
            waitForSpinnerDissapear();
            table.waitTable();
            waitForSpinnerDissapear();
        }
        waitABit(15000);
        waitForSpinnerDissapear();
    }

    public void fillWelcomePageAndCheckOffices(){
        waitForSpinnerDissapear();
        waitABit(10000);

        if(!welcome.isCurrentlyVisible()) {
            if (!welcomeBaseStep.isCurrentlyVisible()) {

                evaluateJavascript("welcomToCityAds();");
            }
        }

        waitForSpinnerDissapear();

        if(errorPopup.isCurrentlyVisible()){
            errorPopupClose.click();
            errorPopupClose.shouldNotBeCurrentlyVisible();
        }

        fillBaseStepYes();

        if(welcome.isCurrentlyVisible()) {
            tab1ActiveIndicator.waitUntilVisible();
            getNextButton().waitUntilVisible();
            getNextButton().click();
            waitForSpinnerDissapear();
            tab2ActiveIndicator.waitUntilVisible();
            map.waitUntilVisible();
            this.find(By.xpath("//div[contains(@class,'_office_select')]/div/div")).click();
            int num = this.findAll(By.xpath("//a[contains(@class,'select-item')]")).size();
            Assert.assertEquals("В оффисах больше 4 значений",num,4);

            //fillRegion();//добавляем костыль и заполняем первой тайм зоной т к нет россии

            getNext2Button().waitUntilVisible();
            getNext2Button().click();
            waitForSpinnerDissapear();
            map.waitUntilVisible();
            getSaveButton().waitUntilVisible();
            getSaveButton().click();
            waitForSpinnerDissapear();
            table.waitTable();
            waitForSpinnerDissapear();
        }
        table.waitTable();
        this.evaluateJavascript("$('.usabilla_live_button_container').remove();");
        waitForSpinnerDissapear();
    }

    public void fillWelcomePageForse() {
        waitForSpinnerDissapear();
        waitABit(15000);

        if(errorPopup.isCurrentlyVisible()){
            errorPopupClose.click();
            errorPopupClose.shouldNotBeCurrentlyVisible();
        }

        System.out.println("WP visible: "+welcome.isCurrentlyVisible());
        System.out.println("WP 0 STEP visible: "+welcomeBaseStep.isCurrentlyVisible());

        if((!welcome.isCurrentlyVisible() && !welcomeBaseStep.isCurrentlyVisible())){
            evaluateJavascript("welcomToCityAds();");
            waitForSpinnerDissapear();
        }



        fillBaseStepYes();

        tab1ActiveIndicator.waitUntilVisible();
        getNextButton().waitUntilVisible();
        getNextButton().click();
        waitForSpinnerDissapear();
        tab2ActiveIndicator.waitUntilVisible();
        map.waitUntilVisible();

        //fillRegion();//добавляем костыль и заполняем первой тайм зоной т к нет россии

        getNext2Button().waitUntilVisible();
        getNext2Button().click();

        //3 шаг типы траффика
        fillTrafficTypes();

        map.waitUntilVisible();
        getSaveButton().waitUntilVisible();
        getSaveButton().click();
        waitForSpinnerDissapear();

        waitForSpinnerDissapear();
        table.waitOverview();
        this.evaluateJavascript("$('.usabilla_live_button_container').remove();");
        waitForSpinnerDissapear();

    }

    public boolean welcomeIsVisible() {
        return welcome.isCurrentlyVisible();
    }

    public void fillWelcomePageManuallyPayments() {
        waitForSpinnerDissapear();
        waitABit(15000);

        if(errorPopup.isCurrentlyVisible()){
            errorPopupClose.click();
            errorPopupClose.shouldNotBeCurrentlyVisible();
        }

        System.out.println("WP visible: "+welcome.isCurrentlyVisible());
        System.out.println("WP 0 STEP visible: "+welcomeBaseStep.isCurrentlyVisible());

        if((!welcome.isCurrentlyVisible() && !welcomeBaseStep.isCurrentlyVisible())){
            evaluateJavascript("welcomToCityAds();");
            waitForSpinnerDissapear();
        }



        fillBaseStepYes();

        tab1ActiveIndicator.waitUntilVisible();
        getNextButton().waitUntilVisible();
        getNextButton().click();
        waitForSpinnerDissapear();
        tab2ActiveIndicator.waitUntilVisible();
        map.waitUntilVisible();

        //fillRegion();//добавляем костыль и заполняем первой тайм зоной т к нет россии

        getNext2Button().waitUntilVisible();
        getNext2Button().click();

        //3 шаг типы траффика
        fillTrafficTypes();

        map.waitUntilVisible();

        //manually payments
        this.evaluateJavascript("$('div[class*=\"_payment_select\"]>div[class*=\"select-value pointer\"]').click()");
        this.evaluateJavascript("$('a:contains(\"Вручную\")').add($('a:contains(\"Manually\")')).click()");

        getSaveButton().waitUntilVisible();
        getSaveButton().click();
        waitForSpinnerDissapear();

        waitForSpinnerDissapear();
        table.waitOverview();
        waitForSpinnerDissapear();
    }
}





