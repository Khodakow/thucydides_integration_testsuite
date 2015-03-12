/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.steps.refactor_steps;

import cityads.ca_thucydides_new_design.pages.refactor.*;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

/**
 *
 * @author s.lugovskiy
 */
public class BackUrlSteps extends ScenarioSteps {

    public OfferCard card;
    public BasePage base;
    public Popup popup;
    public BackUrl burl;
    public Table table;

    public BackUrlSteps(Pages pages) {
        super(pages);
    }


    @Step("Проверка структуры внутри инструмента бек урл")
    public void check_back_url_structure_tools(){
        burl.checkStructureBackurlTools();

    }
    @Step("Проверка структуры в форме создания бек урл")
    public void check_back_url_structure_create_tools(){
        burl.checkStructureCreateFormbackurlTools();
    }
    @Step("Проверка структуры бек урлов в офферах")
    public void check_back_url_structure_offers(){
        burl.checkStructureBackUrlInOffres();
    }
    @Step("Кликаем на кнопку создания бек урлов")
    public void click_create_back_url(){
        burl.clickCreateBackUrl();
        base.waitForSpinnerDissapear();
    }
    @Step("Заполняем форму создания бек урла")
    public void fill_create_backurl_form(String name,String url){
        burl.fillBackUrlCreateForm(name, url);
        base.waitForSpinnerDissapear();
    }
    @Step("Выбираем самый первый бек урл из списка, который не N/A")
    public void choose_1st_backurl_in_offerstable(){
        burl.choose1stBackUrl();

    }
    @Step("Удаляем все из таблицы бек урлов")
    public void delete_all_from_backurl_table(){
        burl.deleteAllFromBackUrlTable();
        base.waitForSpinnerDissapear();
        popup.checkPopupVisible();
        burl.confirmDelete();
        base.waitForSpinnerDissapear();
        popup.checkPopupVisible();
        burl.confirmDelete();
        base.waitForSpinnerDissapear();
        table.blueTableNoDataCheck();
    }

    }

    

