/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.steps.refactor_steps;

import cityads.ca_thucydides_new_design.pages.refactor.OfferCard;
import cityads.ca_thucydides_new_design.pages.refactor.Popup;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import java.net.MalformedURLException;
import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author s.lugovskiy
 */
public class CardSteps extends ScenarioSteps {

    public OfferCard card;
    public Popup popup;

    public CardSteps(Pages pages) {
        super(pages);
    }

    @Step
    public void start_work_with_offer(){
        card.clickStartWork();
    }

    @Step
    public void check_offer_is_avaible(){
        assertTrue(popup.checkPopupHasToolsLink());
    }

    @Step
    public void go_to_analytics_tab() {
        card.goToAnalytics();
    }

    @Step("Переход на вкладку инструменты")
    public void go_to_instrument_tab() {
        card.goToInstruments();
    }

    @Step
    public ArrayList<String> get_instruments_tab_offer_data(){
        return card.getInstrumentsTableTada();
    }


    @Step
    public void check_instruments_data_has_no_text(ArrayList<String> list){
        for(String elem: list){
            assertFalse("Проверяем что в данным на закладке инструменты нет N/A", elem.contains("N/A"));
        }
    }

    @Step("Получаем код гугл выгрузки")
    public String get_goods_original_code(){
        card.clickGoodsOriginalGetCode();
        String code = popup.getCodeFromTextarea();
        return code;
    }


    @Step("Получить сайт оффера с карточки оффера")
    public String get_offer_site() {
        try {
            return card.getOfferSite();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
    

