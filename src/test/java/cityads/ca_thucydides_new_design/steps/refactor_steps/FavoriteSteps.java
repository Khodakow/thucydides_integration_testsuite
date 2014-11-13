/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.steps.refactor_steps;

import cityads.ca_thucydides_new_design.pages.refactor.Favorite;
import cityads.ca_thucydides_new_design.pages.refactor.Front;
import cityads.ca_thucydides_new_design.pages.refactor.Welcome;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.ArrayList;

/**
 *
 * @author s.lugovskiy
 */
public class FavoriteSteps extends ScenarioSteps {

    public Front front;
    public Welcome welcome;
    public Favorite favorite;

    public FavoriteSteps(Pages pages) {
        super(pages);
    }

    @Step("Проверяем что нет кнопки добавить в избранное")
    public void check_favorite_button_is_not_visible(){
        front.waitForSpinnerDissapear();
        favorite.checkFavoriteButtonIsNotVisible();
    }

    @Step
     public void check_size_of_favorite_reports(){
        favorite.checkSizeOfFavoriteReports();
    }

    @Step
    public void check_size_of_favorite_reports_mgr(){
        favorite.checkSizeOfFavoriteReportsMgr();
    }



    @Step
    public void check_size_of_standart_reports(){
        favorite.checkSizeOfStandartReports();
    }

    @Step
    public void click_add_report(){
        favorite.clickFavoriteButton();
    }

    @Step
    public ArrayList<String> get_favorite_reports_links(){
       ArrayList<String> menu = favorite.getFavoriteReportInMenu();
        return menu;

    }

    @Step
    public ArrayList<String> get_favorite_reports_links_mgr(){
        ArrayList<String> menu = favorite.getFavoriteReportInMenuMgr();
        return menu;

    }



}
    

