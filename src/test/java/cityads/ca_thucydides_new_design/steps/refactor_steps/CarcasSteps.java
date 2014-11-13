/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.steps.refactor_steps;

import cityads.ca_thucydides_new_design.pages.refactor.BasePage;
import cityads.ca_thucydides_new_design.pages.refactor.Carcas;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import static org.junit.Assert.assertTrue;

/**
 *
 * @author s.lugovskiy
 */
public class CarcasSteps extends ScenarioSteps {

    public Carcas carcas;
    public BasePage page;
    public CarcasSteps(Pages pages) {
        super(pages);
    }


    //НОВЫЙ КАРКАС============================================
    //перейти в статистику без перехода в отчет
    @Step
    public void go_to_statistic(){
        carcas.goToStatistic();
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
    public void go_to_first_advanced_report_not_realtime(){
        carcas.waitForSpinnerDissapear();
        carcas.evaluateJavascript("$('a[id=\"_left_menu_id_436601152\"]').nextAll('a[style*=\"padding-right: 8px;\"]').not('[href*=\"realtime\"]').get(0).click();");
        carcas.waitForSpinnerDissapear();
    }

    @StepGroup
    public void go_to_left_stat_menu_with_id_adv(String id){
        go_to_statistic_adv();
        String url = get_left_menu_url(id);
        get_url(url);
        wait_for_spinner();

    }

    @Step
    private void go_to_statistic_adv() {
        carcas.goToStatisticAdv();
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

    @Step
    public void get_url(String url){
        this.getDriver().get(url);
    }
    //===========================================================

    /*Офис*/
    @Step("Переход в  раздел Аккаунт")
    public void go_to_account(){
        carcas.goToAccount();
    }


    /*Офферы*/
    @Step("Переход в  раздел Веб-офферы")
    public void go_to_web_offers(){
        carcas.goToWebOffers();
    }

    /*Инструменты*/
    @Step("Переход в  раздел Ротатор Баннеров")
    public void go_to_banner_rotator(){
        carcas.goToBannerRotator();
    }

    @Step("Переход в  раздел Текст шифт - по прямой ссылке")
    public void go_to_text_shift(){
        carcas.goToTextShift();
    }

    /*Статистика*/
    /*Конверсии*/
    /*по офферам*/
    @Step
    public void go_to_statistic_by_conversion_by_offers(){
        go_to_left_stat_menu_with_id("_left_menu_id_426989753");
    }
    /*по сегментам*/
    @Step
    public void go_to_statistic_by_conversion_by_segments_byTypes(){
        go_to_left_stat_menu_with_id("_left_menu_id_426949753");
    }
    @Step
    public void go_to_statistic_by_conversion_by_segments_byVerticals(){
        go_to_left_stat_menu_with_id("_left_menu_id_426989753");
    }
    @Step
    public void go_to_statistic_by_conversion_by_segments_byOffers(){
        go_to_left_stat_menu_with_id("_left_menu_id_426989753");
    }
    /*по действиям*/

    @Step
    public void go_to_statistic_by_conversion_by_action_byTypes(){
        go_to_left_stat_menu_with_id("_left_menu_id_428789753");
    }

    @Step
    public void go_to_statistic_by_conversion_by_action_byConversion(){
        go_to_left_stat_menu_with_id("_left_menu_id_428809753");
    }

    @Step
    public void go_to_statistic_by_conversion_by_action_byMethodspay(){
        go_to_left_stat_menu_with_id("_left_menu_id_431589893");
    }
    /*по интенсивности*/
    @Step
    public void go_to_statistic_by_conversion_by_intencity_byTimePeriods(){
        go_to_left_stat_menu_with_id("_left_menu_id_431725535");
    }

    @Step
    public void go_to_statistic_by_conversion_by_intencity_bySeasons(){
        go_to_left_stat_menu_with_id("_left_menu_id_431655535");
    }

    @Step
    public void go_to_statistic_by_conversion_by_intencity_byTimeDay(){
        go_to_left_stat_menu_with_id("_left_menu_id_431655535");
    }

    @Step
    public void go_to_statistic_by_conversion_by_intencity_byWeekdaysAndWeekends(){
        go_to_left_stat_menu_with_id("_left_menu_id_431795535");
    }

    @Step
    public void go_to_statistic_by_conversion_by_intencity_byWeekDays(){
        go_to_left_stat_menu_with_id("_left_menu_id_431795535");
    }
    /*по инстурментам*/

    @Step
    public void go_to_statistic_by_conversion_by_tools_byTypes(){
        go_to_left_stat_menu_with_id("_left_menu_id_428989753");
    }

    @Step
    public void go_to_statistic_by_conversion_by_tools_byCategoryOfPromo(){
        go_to_left_stat_menu_with_id("_left_menu_id_429009753");
    }

    @Step
    public void go_to_statistic_by_conversion_by_tools_byFormatCode(){
        go_to_left_stat_menu_with_id("_left_menu_id_429029753");
    }

    @Step
    public void go_to_statistic_by_conversion_by_tools_byLinktype(){
        go_to_left_stat_menu_with_id("_left_menu_id_430079752");
    }

    @Step
    public void go_to_statistic_by_conversion_by_tools_bySizeType(){
        go_to_left_stat_menu_with_id("_left_menu_id_430099752");
    }

    @Step
    public void go_to_statistic_by_conversion_by_tools_bySizeofPromo(){
        go_to_left_stat_menu_with_id("_left_menu_id_430119752");
    }
    /*Источники Трафика*/
    /*по точкам входа*/
    @Step
    public void go_to_statistic_by_soursetraffic_byEntryPoints_byTypes(){
        go_to_left_stat_menu_with_id("_left_menu_id_430445535");
    }

    @Step
    public void go_to_statistic_by_soursetraffic_byEntryPoints_byLanding(){
        go_to_left_stat_menu_with_id("_left_menu_id_430515535");
    }

    @Step
    public void go_to_statistic_by_soursetraffic_byEntryPoints_byTargetPages(){
        go_to_left_stat_menu_with_id("_left_menu_id_430585535");
    }

    @Step
    public void go_to_statistic_by_soursetraffic_byEntryPoints_byGoods(){
        go_to_left_stat_menu_with_id("_left_menu_id_430655535");
    }

    @Step
    public void go_to_statistic_by_soursetraffic_byEntryPoints_byPromoEvents(){
        go_to_left_stat_menu_with_id("_left_menu_id_430725535");
    }


    /*по источникам*/
    @Step("Переходим в отчет по источникам по субаккаунтам")
    public void go_to_statistic_by_SourseTraffic_by_sourses_by_subaccount(){
        go_to_left_stat_menu_with_id("_left_menu_id_419879323");
    }


    @Step
    public void go_to_statistic_by_SourseTraffic_by_sourses_by_types(){
        go_to_left_stat_menu_with_id("_left_menu_id_429835535");
    }

    @Step
    public void go_to_statistic_by_SourseTraffic_by_sourses_by_referers(){
        go_to_left_stat_menu_with_id("_left_menu_id_419859323");
    }


    @Step
    public void go_to_statistic_by_SourseTraffic_by_sourses_by_kewywords(){
        go_to_left_stat_menu_with_id("_left_menu_id_424119552");
    }

    /*Аудитория*/
    /*по странам*/
    @Step
    public void go_to_statistic_by_auditory_by_countries_byLanguage(){
        go_to_left_stat_menu_with_id("_left_menu_id_419919323");
    }

    @Step
    public void go_to_statistic_by_auditory_by_countries_byGeografy(){
        go_to_left_stat_menu_with_id("_left_menu_id_419939323");
    }

    @Step
    public void go_to_statistic_by_auditory_by_countries_byTimezones(){
        go_to_left_stat_menu_with_id("_left_menu_id_429295535");
    }
    /*по поведению*/
    @Step
    public void go_to_statistic_by_auditory_by_behavior_byNewandReturned(){
        go_to_left_stat_menu_with_id("_left_menu_id_418479323");
    }
    /*по технологиям*/
    @Step
    public void go_to_statistic_by_auditory_by_technology_byBrowser(){
        go_to_left_stat_menu_with_id("_left_menu_id_418499323");
    }

    @Step
    public void go_to_statistic_by_auditory_by_technology_byOC(){
        go_to_left_stat_menu_with_id("_left_menu_id_418519323");
    }
    /*по утройствам*/

    @Step
    public void go_to_statistic_by_auditory_by_devices_byTypes(){
        go_to_left_stat_menu_with_id("_left_menu_id_418539323");
    }

    @Step
    public void go_to_statistic_by_realTime_periods(){
        go_to_left_stat_menu_with_id("_left_menu_id_426689653");
    }

    @Step
    public void shoud_be_on_devicetype_page(){
        assertTrue(carcas.isOnDevicetypePage());
    }


    @Step
    public void go_to_statistic_by_auditory_by_devices_byMobileDevices(){
        go_to_left_stat_menu_with_id("_left_menu_id_429679753");
    }

    @Step
    public void go_to_standart_statistic_offers(){
        go_to_left_stat_menu_with_id("_left_menu_id_437231152");
    }

    @Step
    public void go_to_standart_statistic_coversion(){
        go_to_left_stat_menu_with_id("_left_menu_id_437231152");
    }

    @Step
    public void go_to_standart_statistic_periods(){
        go_to_left_stat_menu_with_id("_left_menu_id_437261152");
    }

    @Step
    public void go_to_standart_statistic_subbacount(){
        go_to_left_stat_menu_with_id("_left_menu_id_437291152");
    }
    @Step
    public void go_to_fitst_advanced_reports(){
        go_to_first_advanced_report_not_realtime();
    }


    @Step
    public void go_to_api_docs(){
        carcas.goToApiDocs();
        getDriver().manage().window().maximize();
    }

    @Step("Переход в каталог товаров")
    public void go_to_goods() {
      carcas.goToGoodsCatalog();
    }

    @Step
    public void go_to_coupons() {
        carcas.goToCoupons();
    }

    @Step
    public void go_to_offers_advertiser(){
        carcas.goToOffersAdv();
    }

    @Step
    public void go_to_statistic_by_offers_advertizer(){
        go_to_left_stat_menu_with_id_adv("_left_menu_id_428629753");
    }

    @Step
    public void click_first_top_breadcrumbs_element(){
        carcas.clickFirstTopBreadcrumb();
    }

    @Step("Переход в платежную информацию")
    public void go_to_payment_information() {
        carcas.goToPaymentInfo();
    }

    @Step("Переход в раздел гетлинк по прямой ссылке")
    public void go_to_getlink() {
        String baseUrl = System.getProperty("webdriver.base.url");
        getDriver().get(baseUrl+"/ru/webmaster_pro/instrumentyi/big_data/getlink_445571172.0.htm");
        page.waitForSpinnerDissapear();

    }
}
    

