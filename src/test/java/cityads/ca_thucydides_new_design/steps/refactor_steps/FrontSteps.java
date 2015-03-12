/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.steps.refactor_steps;

import cityads.ca_thucydides_new_design.pages.refactor.Front;
import cityads.ca_thucydides_new_design.pages.refactor.Welcome;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
/**
 *
 * @author s.lugovskiy
 */
public class FrontSteps extends ScenarioSteps {

    public Front front;
    public Welcome welcome;

    public FrontSteps(Pages pages) {
        super(pages);
    }

    @Step("Клик на таб история операций и проверка что service info присутсвует")
    public void clickHistoryOperationAndCHeckmanagerServiceInfo(){
        front.clickAndCheckmanagerServiceInfo();
                                                                 }

    @Step("Авторизация пользователя")
    public void enter(){
        front.openBaseUrl();
        front.login();
        front.setRuLang();

    }

    @Step("Авторизация пользователя с лидами")
    public void enter_lead_wm(String url, String wmName){
        front.openBaseUrlPlusDirect(url);
        if(!front.isCurrentlyLogIn()) {
            front.login(wmName);
            front.setRuLang();
        }
    }

    @Step("Авторизация пользователя через директ")
    public void enter(String url){
        front.openBaseUrlPlusDirect(url);
        if(!front.isCurrentlyLogIn()) {
            front.login();
            front.setRuLang();
        }
    }


    @Step("Авторизация рекламодателя")
    private void enterAdv() {
        front.openBaseUrl();
        front.loginAdv();
    }

    @Step("Авторизация менеджера")
    public void enterMgr(){
        front.openBaseUrl();
        front.loginMgr();
    }

    @Step("Авторизация менеджера с неверным паролем")
    public void loginMgrWrongPassword(){
        front.openBaseUrl();
        front.loginMgrWrongPwd();
    }

    @Step("Авторизация пользователя с языком и валютой бразилии")
    public void enterBr(){
        front.openBaseUrl();
        front.loginBr();
    }

    public void call_welcome_page(){
        welcome.callWelcomepage();
    }

    @Step("Пользователь заполняет велком пейдж")
    public void fill_welcome_page(){
        welcome.fillWelcomePage();
    }

    @Step("Пользователь заполняет велком пейдж даже если она не появилась")
    public void fill_welcome_page_force(){
        welcome.fillWelcomePageForse();
    }

    @Step("Пользователь заполняет велком пейдж на португальском")
    public void fill_welcome_page_br(){
        welcome.fillWelcomePageBr();
    }

    @StepGroup//("Авторизация пользователя и заполнение WP")
    public void login(){
        enter();
        fill_welcome_page();
    }

    @Step
    public void login(String url){
        enter(url);
        fill_welcome_page();
    }

    @Step
    public void login(String url,String wmName){
        enter_lead_wm(url,wmName);
        fill_welcome_page();
    }


    @StepGroup
    public void login_with_wp(){
        enter();
        fill_welcome_page_force();
    }

    //advertiser login
    @StepGroup("Авторизация рекла")
    public void loginAdv() {
        enterAdv();
    }


    @StepGroup("Авторизация менеджера")
    public void loginMgr(){
        enterMgr();
        //fill_welcome_page();
    }

    @StepGroup
    public void loginBr(){
        enterBr();
        fill_welcome_page_br();
    }

    @Step
    public void loginAndCheckOfices(){
        front.openBaseUrl();
        front.login();
        welcome.fillWelcomePageAndCheckOffices();
    }
    @Step
    public void openBaseUrl(String url) {
        front.openBaseUrlPlusDirect(url);
    }

    @Step
    public void open() {
        if(!this.getDriver().getCurrentUrl().contains(System.getProperty("webdriver.base.url"))){
            this.getDriver().get(System.getProperty("webdriver.base.url"));
        }
    }


    @Step
    public void check_WP_is_not_visible(){
        assertFalse("Проверяем что велком пейдж исчез",welcome.welcomeIsVisible());
    }

    @Step("Проверяем что пользователь на сводной")
    public void is_on_dashboard(){
        assertTrue("Проверяем что порльзователь попал на сводную",front.checkIsOnDashboard());
    }

    @Step("Редактируем офферы")
    public void hotOffersEdit(){
        front.hotOffersedit();
    }

    @Step("Редактируем акции")
    public void promoEdit(){
        front.eventEdit();
    }

    @Step("Сохраняем форму")
    public void saveEditorForm(){
    front.saveForm();
    }

    @Step("Кликаем на категорию на странице категорий товаров (//div[@class='ib _category_name pointer' and descendant::span[descendant::span[@format='num']]])[1]")
    public void clickCategotyLinks(){
        front.clickAndShowGoodsCategotyBylink();
    }

    @Step("Проверяем, что в фильтрах есть категории")
    public void checkCategotyFilterResult(){
        front.checkCategoryFilterResult();
    }

    @Step("Проверяем что открыта не страница 404")
    public void check_not_404() {
        front.checkNot404();
    }

    @Step("заполняем ВМ с указанием выплаты - вручную или manually")
    public void fill_welcome_page_payments_manually() {
        welcome.fillWelcomePageManuallyPayments();
    }

    @Step("Берем баланс")
    public String getBalance() {
        return front.getbalance();
    }

    @Step
    public void log(String code){

    }

}
    

