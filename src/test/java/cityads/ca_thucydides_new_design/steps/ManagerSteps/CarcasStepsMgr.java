/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.steps.ManagerSteps;

import cityads.ca_thucydides_new_design.pages.ManagerPages.CarcasMngr;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

/**
 *
 * @author s.lugovskiy
 */
public class CarcasStepsMgr extends ScenarioSteps {

    public CarcasMngr carcas;

    public CarcasStepsMgr(Pages pages) {
        super(pages);
    }

    @Step
    public void go_to_statistic(){
        carcas.goToMgrStatistic();
    }

    //перейти по ссылке левого меню передав ее id
    @StepGroup
    public void go_to_left_stat_menu_with_id(String id){
        go_to_statistic();
        String url = get_left_menu_url(id);
        get_url(url);
        wait_for_spinner();

    }

    @Step
    public void get_url(String url){
        this.getDriver().get(url);
    }

    @Step
    public void go_to_first_advanced_report_not_realtime(){
        carcas.waitForSpinnerDissapear();
        carcas.evaluateJavascript("$('a[id=\"_left_menu_id_436421152\"]').nextAll('a[style*=\"padding-right: 8px;\"]').not('[href*=\"realtime\"]').get(0).click();");
        carcas.waitForSpinnerDissapear();
    }

    @Step
    public void wait_for_spinner(){
        carcas.waitForSpinnerDissapear();
    }

    @Step
    public String get_left_menu_url(String id){
        String url = carcas.getCarcasUrl(id);
        return url;
    }

    @Step("Переходим в отчет менеджера по офисам")
    public void go_to_mgr_stat_offices() {
        carcas.goToMgrStatByOffices();
    }

    @Step
    public void go_to_mgr_stat_advertisers() {
        carcas.goToMgrStatByAdvertisers();
    }

    @Step
    public void go_to_mgr_stat_webmasters() {
        carcas.goToMgrStatByWebmasters();
    }

    @Step
    public void go_to_mgr_stat_categorypromo() {
        carcas.goToMgrStatByCategoryPromo();
    }

    @Step
    public void go_to_mgr_stat_tooltype() {
        carcas.goToMgrStatByToolsType();
    }

    @Step
    public void go_to_mgr_stat_codetype() {
        carcas.goToMgrStatByCodeType();
    }

    @Step
    public void go_to_mgr_stat_linktype() {
        carcas.goToMgrStatByLinkType();
    }

    @Step
    public void go_to_mgr_stat_goods() {
        carcas.goToMgrStatByGoods();
    }

    @Step("Заходим в отчет по офферам с _left_menu_id_436631152")
    public void go_to_mgr_stat_offers() {
        go_to_left_stat_menu_with_id("_left_menu_id_436631152");
    }

    @Step("Заходим в отчет по офферам с _left_menu_id_436661152")
    public void go_to_mgr_stat_conversions() {
        go_to_left_stat_menu_with_id("_left_menu_id_436661152");
    }

    @Step("Заходим в отчет по офферам с _left_menu_id_436691152")
    public void go_to_mgr_stat_periods() {
        go_to_left_stat_menu_with_id("_left_menu_id_436691152");
    }

    @Step("Заходим в отчет по офферам с _left_menu_id_436721152")
    public void go_to_mgr_stat_subaccounts() {
        go_to_left_stat_menu_with_id("_left_menu_id_436721152");
    }

    @Step("Заходим в отчет по офферам с _left_menu_id_436751152")
    public void go_to_mgr_geolocation() {
        go_to_left_stat_menu_with_id("_left_menu_id_436751152");
    }
    @Step("Заходим в редактор офиса")
    public void go_to_office_editor() {
        carcas.goToMgrOffceEditor();
    }
}