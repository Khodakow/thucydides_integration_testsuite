/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.steps.refactor_steps;

import cityads.ca_thucydides_new_design.pages.refactor.Popup;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

/**
 *
 * @author s.lugovskiy
 */
public class PopupSteps extends ScenarioSteps {

    public Popup popup;

    public PopupSteps(Pages pages) {
        super(pages);
    }

    @Step("Получаем код из popup")
    public String get_textarea_code(){
        return popup.getCodeFromTextarea();
    }

    @Step("Проверяем что popup не отображается")
    public void check_popup_is_not_displayed(){
        popup.checkPopupIsNotDisplayed();
    }

    @Step("Клик по иконке Выгруза купонов в попапе")
    public void click_offercard_coupons_link(){
        popup.clickOfferCouponsLink();
    }

    @Step("Проверяем что поп-ап на подключение видимый и в нем есть основные элементы")
    public void checkLockedPopuoIsvisible(){
        popup.checkStructureInLockedPopup();
    }

    @Step("Кликаем ссылку -=ССЫЛКИ=- в попапе оффера")
    public void click_offercard_main_links() {
        popup.clickOfferNainLink();
    }
}
    

