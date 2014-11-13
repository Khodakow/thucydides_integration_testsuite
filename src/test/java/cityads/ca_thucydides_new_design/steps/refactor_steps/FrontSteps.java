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

    @Step("Авторизация пользователя")
    public void enter(){
        front.openBaseUrl();
        front.login();
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

    @StepGroup("Авторизация пользователя и заполнение WP")
    public void login(){
        enter();
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
    public void check_WP_is_not_visible(){
        assertFalse("Проверяем что велком пейдж исчез",welcome.welcomeIsVisible());
    }

    @Step
    public void is_on_dashboard(){
        assertTrue("Проверяем что порльзователь попал на сводную",front.checkIsOnDashboard());
    }


}
    
