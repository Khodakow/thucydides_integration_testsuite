package cityads.ca_thucydides_new_design.pages.refactor;

import net.thucydides.core.annotations.findby.By;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;


public class Carcas extends BasePage {


    public Carcas(WebDriver driver) {
        super(driver);
    }

    private Table table;
    private Welcome welcome;

    @FindBy(xpath="//a[@id='menu_top_wm_item_3641925']")
    private WebElementFacade offers;

    @FindBy(xpath="//a[@id='menu_top_wm_item_3641924']")
    private WebElementFacade home;

    @FindBy(xpath="//a[@id='_left_menu_id_3641940']")
    private WebElementFacade webOffers;

    @FindBy(xpath="//a[@id='_left_menu_id_407479372']")
    private WebElementFacade mobOffers;

    @FindBy(xpath="//a[@id='_left_menu_id_3641921']")
    private WebElementFacade myAccount;

    @FindBy(xpath="//a[@id='_left_menu_id_403699272']")
    private WebElementFacade account;

    @FindBy(xpath="//a[@id='_left_menu_id_432941052']")
    private WebElementFacade api;

    @FindBy(xpath="//a[@id='_left_menu_id_434811172']")
    private WebElementFacade paymentInfo;

    @FindBy(xpath="//a[@id='menu_top_wm_item_3641923']")
    private WebElementFacade tools;

    @FindBy(xpath="//a[@id='_left_menu_id_413079372']")
    private WebElementFacade rotators;

    @FindBy(xpath="//a[@id='_left_menu_id_416459372']")
    private WebElementFacade bannerRotator;

    @FindBy(xpath="//a[@id='_left_menu_id_3999966']")
    private WebElementFacade finances;

    @FindBy(xpath="//a[@id='_left_menu_id_3999969']")
    private WebElementFacade exchange;

    @FindBy(xpath="//a[@id='_left_menu_id_3999968']")
    private WebElementFacade operationHystory;

    @FindBy(xpath="//a[@id='_left_menu_id_403459272']")
    private WebElementFacade payments;

    @FindBy(xpath="//a[@id='account_type_switch_to_old']")
    private WebElementFacade oldButton;

    @FindBy(xpath="//div[@class='section page-header']/h1")
    private WebElementFacade h1OldInterface;

    /*Локаторы статы*/

    @FindBy(xpath="//a[@id='menu_top_wm_item_3641922']")
    private WebElementFacade statistic;

    @FindBy(xpath="//a[@id='menu_top_wm_item_423010615']")
    private WebElementFacade statisticMgr;


    /*Конверсии*/

    @FindBy(xpath="//a[@id='_left_menu_id_417819372']")
    private WebElementFacade statisticConversions;

    /*по офферам*/

    @FindBy(xpath="//a[@id='_left_menu_id_419819323']")
    private WebElementFacade statisticConversionsByoffers;

    @FindBy(xpath="//a[@id='_left_menu_id_419839323']")
    private WebElementFacade statisticConversionsByoffersByOffers;

    /*по сегментам*/

    @FindBy(xpath="//a[@id='_left_menu_id_426929753']")
    private WebElementFacade statisticConversionsBySegmets;
    @FindBy(xpath="//a[@id='_left_menu_id_426949753']")
    private WebElementFacade statisticConversionsBySegmetsByType;
    @FindBy(xpath="//a[@id='_left_menu_id_426969753']")
    private WebElementFacade statisticConversionsBySegmetsByVerticals;
    @FindBy(xpath="//a[@id='_left_menu_id_426989753']")
    private WebElementFacade statisticConversionsBySegmetsByOffers;

    /*по действиям*/

    @FindBy(xpath="//a[@id='_left_menu_id_428769753']")
    private WebElementFacade statisticConversionsByActivity;
    @FindBy(xpath="//a[@id='_left_menu_id_428789753']")
    private WebElementFacade statisticConversionsByActivityByTypes;
    @FindBy(xpath="//a[@id='_left_menu_id_428809753']")
    private WebElementFacade statisticConversionsByActivityByConversions;
    @FindBy(xpath="//a[@id='_left_menu_id_431589893']")
    private WebElementFacade statisticConversionsByActivityByMethodsPay;

    /*по интенсивности*/

    @FindBy(xpath="//a[@id='_left_menu_id_431655535']")
    private WebElementFacade statisticConversionsByIntencity;

    @FindBy(xpath="//a[@id='_left_menu_id_431725535']")
    private WebElementFacade statisticConversionsByIntencityByPeriods;
    @FindBy(xpath="//a[@id='_left_menu_id_432005535']")
    private WebElementFacade statisticConversionsByIntencityBySeasons;
    @FindBy(xpath="//a[@id='_left_menu_id_431935535']")
    private WebElementFacade statisticConversionsByIntencityByDays;
    @FindBy(xpath="//a[@id='_left_menu_id_431865535']")
    private WebElementFacade statisticConversionsByIntencityByWeekends;
    @FindBy(xpath="//a[@id='_left_menu_id_431795535']")
    private WebElementFacade statisticConversionsByIntencityByWeekDays;

    /*по инструментам*/

    @FindBy(xpath="//a[@id='_left_menu_id_428969753']")
    private WebElementFacade statisticConversionsByTools;

    @FindBy(xpath="//a[@id='_left_menu_id_428989753']")
    private WebElementFacade statisticConversionsByToolsByTypes;
    @FindBy(xpath="//a[@id='_left_menu_id_429009753']")
    private WebElementFacade statisticConversionsByToolsByCategories;
    @FindBy(xpath="//a[@id='_left_menu_id_429029753']")
    private WebElementFacade statisticConversionsByToolsByFormat;
    @FindBy(xpath="//a[@id='_left_menu_id_430079752']")
    private WebElementFacade statisticConversionsByToolsByTypeLink;
    @FindBy(xpath="//a[@id='_left_menu_id_430099752']")
    private WebElementFacade statisticConversionsByToolsByTypeSize;
    @FindBy(xpath="//a[@id='_left_menu_id_430119752']")
    private WebElementFacade statisticConversionsByToolsBySizeOfPromo;


    /*Источники траффика*/

    @FindBy(xpath="//a[@id='_left_menu_id_419799323']")
    private WebElementFacade statisticTrafficSourses;

    /*по точкам входа*/

    @FindBy(xpath="//a[@id='_left_menu_id_430375535']")
    private WebElementFacade statisticTrafficSoursesByEntryPoints;

    @FindBy(xpath="//a[@id='_left_menu_id_430445535']")
    private WebElementFacade statisticTrafficSoursesByEntryPointsByTypes;
    @FindBy(xpath="//a[@id='_left_menu_id_430515535']")
    private WebElementFacade statisticTrafficSoursesByEntryPointsByLanding;
    @FindBy(xpath="//a[@id='_left_menu_id_430585535']")
    private WebElementFacade statisticTrafficSoursesByEntryPointsByTargetPages;
    @FindBy(xpath="//a[@id='_left_menu_id_430655535']")
    private WebElementFacade statisticTrafficSoursesByEntryPointsByGoods;
    @FindBy(xpath="//a[@id='_left_menu_id_430725535']")
    private WebElementFacade statisticTrafficSoursesByEntryPointsByPromo;

    /*по источникам*/
    @FindBy(xpath="//a[@id='_left_menu_id_424091321']")
    private WebElementFacade statisticTrafficSoursesBySourses;

    @FindBy(xpath="//a[@id='_left_menu_id_429835535']")
    private WebElementFacade statisticTrafficSoursesBySoursesByTypes;
    @FindBy(xpath="//a[@id='_left_menu_id_419859323']")
    private WebElementFacade statisticTrafficSoursesBySoursesByReferers;
    @FindBy(xpath="//a[@id='_left_menu_id_419879323']")
    private WebElementFacade statisticTrafficSoursesBySoursesBySubaccounts;
    @FindBy(xpath="//a[@id='_left_menu_id_424119552']")
    private WebElementFacade statisticTrafficSoursesBySoursesByKeywords;

    /*Аудитория*/

    @FindBy(xpath="//a[@id='_left_menu_id_3641958']")
    private WebElementFacade statisticAuditory;

    /*по странам*/

    @FindBy(xpath="//a[@id='_left_menu_id_419899323']")
    private WebElementFacade statisticAuditoryByCountries;

    @FindBy(xpath="//a[@id='_left_menu_id_419919323']")
    private WebElementFacade statisticAuditoryByCountriesByLang;
    @FindBy(xpath="//a[@id='_left_menu_id_419939323']")
    private WebElementFacade statisticAuditoryByCountriesByGeografy;
    @FindBy(xpath="//a[@id='_left_menu_id_429295535']")
    private WebElementFacade statisticAuditoryByCountriesByTimeZones;

    /*по поведению*/

    @FindBy(xpath="//a[@id='_left_menu_id_417919372']")
    private WebElementFacade statisticAuditoryByBehavior;

    @FindBy(xpath="//a[@id='_left_menu_id_418479323']")
    private WebElementFacade statisticAuditoryByBehaviorByNewandReturned;

    /*по технологиям*/

    @FindBy(xpath="//a[@id='_left_menu_id_417899372']")
    private WebElementFacade statisticAuditoryByTechnology;

    @FindBy(xpath="//a[@id='_left_menu_id_418499323']")
    private WebElementFacade statisticAuditoryByTechnologyByBrowser;
    @FindBy(xpath="//a[@id='_left_menu_id_418519323']")
    private WebElementFacade statisticAuditoryByTechnologyByOC;

    /*по устрйоствам*/

    @FindBy(xpath="//a[@id='_left_menu_id_417879372']")
    private WebElementFacade statisticAuditoryByDevices;

    @FindBy(xpath="//a[@id='_left_menu_id_418539323']")
    private WebElementFacade statisticAuditoryByDevicesByType;
    @FindBy(xpath="//a[@id='_left_menu_id_429679753']")
    private WebElementFacade statisticAuditoryByDevicesByMobile;

    @FindBy(xpath="//h1[contains(text(),'баннеров') or contains(text(),'Banner')]")
    private WebElementFacade rotatorsH1;

    //хлебные кошки

    @FindBy(xpath = "//div[@id='pagePath']/a[1]")
    private WebElementFacade breadСrumbs;

    /*Переход в определенный раздел*/


    /*Офис*/

    public void goToAccount(){
        waitForSpinnerDissapear();
        if(!account.isCurrentlyVisible()){
            myAccount.click();

        }
        account.waitUntilVisible();
        account.click();
        waitForSpinnerDissapear();
    }

    public void goToApi(){
        waitForSpinnerDissapear();
        if(!api.isCurrentlyVisible()){
            myAccount.waitUntilVisible();
            myAccount.click();
        }
        api.waitUntilVisible();
        api.click();
        waitForSpinnerDissapear();
    }


    /*Офферы*/

    public void goToWebOffers(){
        waitForSpinnerDissapear();
        offers.waitUntilVisible();
        offers.click();
        waitForSpinnerDissapear();
        webOffers.waitUntilVisible();
        webOffers.click();
        waitForSpinnerDissapear();
    }

    public void goToMobOffers(){
        waitForSpinnerDissapear();
        offers.waitUntilVisible();
        offers.click();
        waitForSpinnerDissapear();
        mobOffers.waitUntilVisible();
        mobOffers.click();
        waitForSpinnerDissapear();
    }


    /*Инструменты*/

    public void goToBannerRotator(){
        waitForSpinnerDissapear();
        tools.waitUntilVisible();
        tools.click();
        waitForSpinnerDissapear();
        if(!bannerRotator.isCurrentlyVisible()){
            rotators.click();
            waitForSpinnerDissapear();
        }
        waitForSpinnerDissapear();
        bannerRotator.click();
        waitForSpinnerDissapear();
        rotatorsH1.waitUntilVisible();
        //waitChart();

        waitForSpinnerDissapear();
        //waitSpinner();

    }

    @FindBy(xpath="//a[@id='_left_menu_id_434131042']")
    private WebElementFacade pushAds;

    @FindBy(xpath="//a[@id='_left_menu_id_434161042']")
    private WebElementFacade textShift;

    @FindBy(xpath="//h1[contains(text(),'Shift')]")
    private WebElementFacade textShiftH1;

    @FindBy(xpath="//a[@id='menu_top_wm_item_402759272']")
    private WebElementFacade goodsAndCoupons;

    @FindBy(xpath="//a[@id='_left_menu_id_403279272']")
    private WebElementFacade coupons;

    @FindBy(xpath="//a[@id='_left_menu_id_403299272']")
    private WebElementFacade goods;

    @FindBy(xpath="//a[@id='_left_menu_id_403339272']")
    private WebElementFacade goodsCategory;

    @FindBy(xpath="//a[@id='_left_menu_id_403319272']")
    private WebElementFacade goodsCatalog;

    @FindBy(xpath="//a[@id='_left_menu_id_3641918']")
    private WebElementFacade couponsAndPromocodes;


    //advertiser carcas
    @FindBy(xpath = "//a[@id='menu_top_wm_item_424509552']")
    private WebElementFacade advOffers;

    @FindBy(xpath = "//a[@id='menu_top_wm_item_424549552']")
    private WebElementFacade advStatistic;

    @FindBy(xpath = "//_left_menu_id_426509652")
    private WebElementFacade advConversions;

    @FindBy(xpath = "//_left_menu_id_428609753")
    private WebElementFacade advSegments;

    @FindBy(xpath = "//_left_menu_id_428629753")
    private WebElementFacade advStatOffers;


    //DEVELOP STAT NEW CARCAS =========================================
    //=================================================================

    //получить ссылку каркаса по имени кнопки
    public String getCarcasUrl(String id){
        return this.find(By.xpath("//a[contains(@data-bind,'left_menu_id') and not(contains(@class,'dark')) and @id='"+id+"']")).getAttribute("href");
    }

    public void clickCarcasUrl(String href){
        String baseUrl = System.getProperty("webdriver.base.url");
        this.getDriver().get(baseUrl+href);
    }

    //=================================================================
    /*Статистика*/
    public void goToStatistic(){
        waitForSpinnerDissapear();
        statistic.waitUntilVisible();
        statistic.click();
        waitForSpinnerDissapear();
    }

    /*Конверсии*/
    /*по офферам*/
    public void goToStatisticByConversionByOffers() {
        waitForSpinnerDissapear();
        statistic.waitUntilVisible();
        statistic.click();
        waitForSpinnerDissapear();
        if(!statisticConversionsByoffers.isCurrentlyVisible()){
            statisticConversions.click();
            waitForSpinnerDissapear();
        }

        statisticConversionsByoffers.waitUntilVisible();
        statisticConversionsByoffers.click();
        waitForSpinnerDissapear();
    }

    public void goToStatisticAdv(){
        advStatistic.waitUntilVisible();
        advStatistic.click();
    }

    /*по сегментам*/
    public void goToStatisticByConversionBySegmentsByTypes() {
        waitForSpinnerDissapear();
        statistic.waitUntilVisible();
        statistic.click();
        waitForSpinnerDissapear();
        if(!statisticConversionsBySegmets.isCurrentlyVisible()){
            statisticConversions.click();
            waitForSpinnerDissapear();
        }
        if(!statisticConversionsBySegmetsByType.isCurrentlyVisible()){
            statisticConversionsBySegmets.click();
            waitForSpinnerDissapear();
        }
        statisticConversionsBySegmetsByType.waitUntilVisible();
        statisticConversionsBySegmetsByType.click();
        waitForSpinnerDissapear();
    }

    public void goToStatisticByConversionBySegmentsByVerticals() {
        waitForSpinnerDissapear();
        statistic.waitUntilVisible();
        statistic.click();
        waitForSpinnerDissapear();
        if(!statisticConversionsBySegmets.isCurrentlyVisible()){
            statisticConversions.click();
            waitForSpinnerDissapear();
        }
        if(!statisticConversionsBySegmetsByVerticals.isCurrentlyVisible()){
            statisticConversionsBySegmets.click();
            waitForSpinnerDissapear();
        }
        statisticConversionsBySegmetsByVerticals.waitUntilVisible();
        statisticConversionsBySegmetsByVerticals.click();
        waitForSpinnerDissapear();
    }

    public void goToStatisticByConversionBySegmentsBySegmetOffer() {
        //try {            Thread.sleep(20000);        } catch (InterruptedException e) {        }
        waitForSpinnerDissapear();
        statistic.waitUntilVisible();
        statistic.click();
        waitForSpinnerDissapear();
        // try {            Thread.sleep(20000);        } catch (InterruptedException e) {        }
        if(!statisticConversionsBySegmets.isCurrentlyVisible()){
            statisticConversions.click();
            waitForSpinnerDissapear();
        }
        if(!statisticConversionsBySegmetsByOffers.isCurrentlyVisible()){
            statisticConversionsBySegmets.click();
            waitForSpinnerDissapear();
        }
        statisticConversionsBySegmetsByOffers.waitUntilVisible();
        statisticConversionsBySegmetsByOffers.click();
        waitForSpinnerDissapear();
    }

    /*по действиям*/
    public void goToStatisticByConversionByActionsByType() {
        waitForSpinnerDissapear();
        statistic.waitUntilVisible();
        statistic.click();
        waitForSpinnerDissapear();
        if(!statisticConversionsByActivity.isCurrentlyVisible()){
            statisticConversions.click();
            waitForSpinnerDissapear();
        }
        if(!statisticConversionsByActivityByTypes.isCurrentlyVisible()){
            statisticConversionsByActivity.click();
            waitForSpinnerDissapear();
        }
        statisticConversionsByActivityByTypes.waitUntilVisible();
        statisticConversionsByActivityByTypes.click();
        waitForSpinnerDissapear();
    }

    public void goToStatisticByConversionByActionsByConversion() {
        waitForSpinnerDissapear();
        statistic.waitUntilVisible();
        statistic.click();
        waitForSpinnerDissapear();
        if(!statisticConversionsByActivity.isCurrentlyVisible()){
            statisticConversions.click();
            waitForSpinnerDissapear();
        }
        if(!statisticConversionsByActivityByConversions.isCurrentlyVisible()){
            statisticConversionsByActivity.click();
            waitForSpinnerDissapear();
        }
        statisticConversionsByActivityByConversions.waitUntilVisible();
        statisticConversionsByActivityByConversions.click();
        waitForSpinnerDissapear();
    }

    public void goToStatisticByConversionByActionsByMethodsPay() {
        waitForSpinnerDissapear();
        statistic.waitUntilVisible();
        statistic.click();
        waitForSpinnerDissapear();
        if(!statisticConversionsByActivity.isCurrentlyVisible()){
            statisticConversions.click();
            waitForSpinnerDissapear();
        }
        if(!statisticConversionsByActivityByMethodsPay.isCurrentlyVisible()){
            statisticConversionsByActivity.click();
            waitForSpinnerDissapear();
        }
        statisticConversionsByActivityByMethodsPay.waitUntilVisible();
        statisticConversionsByActivityByMethodsPay.click();
        waitForSpinnerDissapear();
    }

    /*по интенсивности*/
    public void goToStatisticByConversionByIntencityByPeriods() {
        waitForSpinnerDissapear();
        statistic.waitUntilVisible();
        statistic.click();
        waitForSpinnerDissapear();
        if(!statisticConversionsByIntencity.isCurrentlyVisible()){
            statisticConversions.click();
            waitForSpinnerDissapear();
        }
        if(!statisticConversionsByIntencityByPeriods.isCurrentlyVisible()){
            statisticConversionsByIntencity.click();
            waitForSpinnerDissapear();
        }
        statisticConversionsByIntencityByPeriods.waitUntilVisible();
        statisticConversionsByIntencityByPeriods.click();
        waitForSpinnerDissapear();
    }

    public void goToStatisticByConversionByIntencityBySeasons() {
        waitForSpinnerDissapear();
        statistic.waitUntilVisible();
        statistic.click();
        waitForSpinnerDissapear();
        if(!statisticConversionsByIntencity.isCurrentlyVisible()){
            statisticConversions.click();
            waitForSpinnerDissapear();
        }
        if(!statisticConversionsByIntencityBySeasons.isCurrentlyVisible()){
            statisticConversionsByIntencity.click();
            waitForSpinnerDissapear();
        }
        statisticConversionsByIntencityBySeasons.waitUntilVisible();
        statisticConversionsByIntencityBySeasons.click();
        waitForSpinnerDissapear();
    }

    public void goToStatisticByConversionByIntencityByDays() {
        waitForSpinnerDissapear();
        statistic.waitUntilVisible();
        statistic.click();
        waitForSpinnerDissapear();
        if(!statisticConversionsByIntencity.isCurrentlyVisible()){
            statisticConversions.click();
            waitForSpinnerDissapear();
        }
        if(!statisticConversionsByIntencityByDays.isCurrentlyVisible()){
            statisticConversionsByIntencity.click();
            waitForSpinnerDissapear();
        }
        statisticConversionsByIntencityByDays.waitUntilVisible();
        statisticConversionsByIntencityByDays.click();
        waitForSpinnerDissapear();
    }

    public void goToStatisticByConversionByIntencityByWeekends() {
        waitForSpinnerDissapear();
        statistic.waitUntilVisible();
        statistic.click();
        waitForSpinnerDissapear();
        if(!statisticConversionsByIntencity.isCurrentlyVisible()){
            statisticConversions.click();
            waitForSpinnerDissapear();
        }
        if(!statisticConversionsByIntencityByWeekends.isCurrentlyVisible()){
            statisticConversionsByIntencity.click();
            waitForSpinnerDissapear();
        }
        statisticConversionsByIntencityByWeekends.waitUntilVisible();
        statisticConversionsByIntencityByWeekends.click();
        waitForSpinnerDissapear();
    }

    public void goToStatisticByConversionByIntencityByWeekday() {
        waitForSpinnerDissapear();
        statistic.waitUntilVisible();
        statistic.click();
        waitForSpinnerDissapear();
        if(!statisticConversionsByIntencity.isCurrentlyVisible()){
            statisticConversions.click();
            waitForSpinnerDissapear();
        }
        if(!statisticConversionsByIntencityByWeekDays.isCurrentlyVisible()){
            statisticConversionsByIntencity.click();
            waitForSpinnerDissapear();
        }
        statisticConversionsByIntencityByWeekDays.waitUntilVisible();
        statisticConversionsByIntencityByWeekDays.click();
        waitForSpinnerDissapear();
    }

    /*по инструментам*/
    public void goToStatisticByConversionByToolsByTypes() {
        waitForSpinnerDissapear();
        statistic.waitUntilVisible();
        statistic.click();
        waitForSpinnerDissapear();
        if(!statisticConversionsByTools.isCurrentlyVisible()){
            statisticConversions.click();
            waitForSpinnerDissapear();
        }
        if(!statisticConversionsByToolsByTypes.isCurrentlyVisible()){
            statisticConversionsByTools.click();
            waitForSpinnerDissapear();
        }
        statisticConversionsByToolsByTypes.waitUntilVisible();
        statisticConversionsByToolsByTypes.click();
        waitForSpinnerDissapear();
    }

    public void goToStatisticByConversionByToolsByCategoryPromo() {
        waitForSpinnerDissapear();
        statistic.waitUntilVisible();
        statistic.click();
        waitForSpinnerDissapear();
        if(!statisticConversionsByTools.isCurrentlyVisible()){
            statisticConversions.click();
            waitForSpinnerDissapear();
        }
        if(!statisticConversionsByToolsByCategories.isCurrentlyVisible()){
            statisticConversionsByTools.click();
            waitForSpinnerDissapear();
        }
        statisticConversionsByToolsByCategories.waitUntilVisible();
        statisticConversionsByToolsByCategories.click();
        waitForSpinnerDissapear();
    }

    public void goToStatisticByConversionByToolsByFormatCode() {
        waitForSpinnerDissapear();
        statistic.waitUntilVisible();
        statistic.click();
        waitForSpinnerDissapear();
        if(!statisticConversionsByTools.isCurrentlyVisible()){
            statisticConversions.click();
            waitForSpinnerDissapear();
        }
        if(!statisticConversionsByToolsByFormat.isCurrentlyVisible()){
            statisticConversionsByTools.click();
            waitForSpinnerDissapear();
        }
        statisticConversionsByToolsByFormat.waitUntilVisible();
        statisticConversionsByToolsByFormat.click();
        waitForSpinnerDissapear();
    }

    public void goToStatisticByConversionByToolsByTypeLink() {
        waitForSpinnerDissapear();
        statistic.waitUntilVisible();
        statistic.click();
        waitForSpinnerDissapear();
        if(!statisticConversionsByTools.isCurrentlyVisible()){
            statisticConversions.click();
            waitForSpinnerDissapear();
        }
        if(!statisticConversionsByToolsByTypeLink.isCurrentlyVisible()){
            statisticConversionsByTools.click();
            waitForSpinnerDissapear();
        }
        statisticConversionsByToolsByTypeLink.waitUntilVisible();
        statisticConversionsByToolsByTypeLink.click();
        waitForSpinnerDissapear();
    }

    public void goToStatisticByConversionByToolsByTypeSize() {
        waitForSpinnerDissapear();
        statistic.waitUntilVisible();
        statistic.click();
        waitForSpinnerDissapear();
        if(!statisticConversionsByTools.isCurrentlyVisible()){
            statisticConversions.click();
            waitForSpinnerDissapear();
        }
        if(!statisticConversionsByToolsByTypeSize.isCurrentlyVisible()){
            statisticConversionsByTools.click();
            waitForSpinnerDissapear();
        }
        statisticConversionsByToolsByTypeSize.waitUntilVisible();
        statisticConversionsByToolsByTypeSize.click();
        waitForSpinnerDissapear();
    }

    public void goToStatisticByConversionByToolsBySizeofPromo() {
        waitForSpinnerDissapear();
        statistic.waitUntilVisible();
        statistic.click();
        waitForSpinnerDissapear();
        if(!statisticConversionsByTools.isCurrentlyVisible()){
            statisticConversions.click();
            waitForSpinnerDissapear();
        }
        if(!statisticConversionsByToolsBySizeOfPromo.isCurrentlyVisible()){
            statisticConversionsByTools.click();
            waitForSpinnerDissapear();
        }
        statisticConversionsByToolsBySizeOfPromo.waitUntilVisible();
        statisticConversionsByToolsBySizeOfPromo.click();
        waitForSpinnerDissapear();
    }
    /*Источники трафика*/
    /*по точкам входа*/
    public void goToStatisticByTraficSourseByEntryPointsByTypes() {
        waitForSpinnerDissapear();
        statistic.waitUntilVisible();
        statistic.click();
        waitForSpinnerDissapear();
        if(!statisticTrafficSoursesByEntryPoints.isCurrentlyVisible()){
            statisticTrafficSourses.click();
            waitForSpinnerDissapear();
        }
        if(!statisticTrafficSoursesByEntryPointsByTypes.isCurrentlyVisible()){
            statisticTrafficSoursesByEntryPoints.click();
            waitForSpinnerDissapear();
        }
        statisticTrafficSoursesByEntryPointsByTypes.waitUntilVisible();
        statisticTrafficSoursesByEntryPointsByTypes.click();
        waitForSpinnerDissapear();
    }

    public void goToStatisticByTraficSourseByEntryPointsByLanding() {
        waitForSpinnerDissapear();
        statistic.waitUntilVisible();
        statistic.click();
        waitForSpinnerDissapear();
        if(!statisticTrafficSoursesByEntryPoints.isCurrentlyVisible()){
            statisticTrafficSourses.click();
            waitForSpinnerDissapear();
        }
        if(!statisticTrafficSoursesByEntryPointsByLanding.isCurrentlyVisible()){
            statisticTrafficSoursesByEntryPoints.click();
            waitForSpinnerDissapear();
        }
        statisticTrafficSoursesByEntryPointsByLanding.waitUntilVisible();
        statisticTrafficSoursesByEntryPointsByLanding.click();
        waitForSpinnerDissapear();
    }

    public void goToStatisticByTraficSourseByEntryPointsByTargetPages() {
        waitForSpinnerDissapear();
        statistic.waitUntilVisible();
        statistic.click();
        waitForSpinnerDissapear();
        if(!statisticTrafficSoursesByEntryPoints.isCurrentlyVisible()){
            statisticTrafficSourses.click();
            waitForSpinnerDissapear();
        }
        if(!statisticTrafficSoursesByEntryPointsByTargetPages.isCurrentlyVisible()){
            statisticTrafficSoursesByEntryPoints.click();
            waitForSpinnerDissapear();
        }
        statisticTrafficSoursesByEntryPointsByTargetPages.waitUntilVisible();
        statisticTrafficSoursesByEntryPointsByTargetPages.click();
        waitForSpinnerDissapear();
    }

    public void goToStatisticByTraficSourseByEntryPointsByGoods() {
        waitForSpinnerDissapear();
        statistic.waitUntilVisible();
        statistic.click();
        waitForSpinnerDissapear();
        if(!statisticTrafficSoursesByEntryPoints.isCurrentlyVisible()){
            statisticTrafficSourses.click();
            waitForSpinnerDissapear();
        }
        if(!statisticTrafficSoursesByEntryPointsByGoods.isCurrentlyVisible()){
            statisticTrafficSoursesByEntryPoints.click();
            waitForSpinnerDissapear();
        }
        statisticTrafficSoursesByEntryPointsByGoods.waitUntilVisible();
        statisticTrafficSoursesByEntryPointsByGoods.click();
        waitForSpinnerDissapear();
    }

    public void goToStatisticByTraficSourseByEntryPointsByPromoEvents() {
        waitForSpinnerDissapear();
        statistic.waitUntilVisible();
        statistic.click();
        waitForSpinnerDissapear();
        if(!statisticTrafficSoursesByEntryPoints.isCurrentlyVisible()){
            statisticTrafficSourses.click();
            waitForSpinnerDissapear();
        }
        if(!statisticTrafficSoursesByEntryPointsByPromo.isCurrentlyVisible()){
            statisticTrafficSoursesByEntryPoints.click();
            waitForSpinnerDissapear();
        }
        statisticTrafficSoursesByEntryPointsByPromo.waitUntilVisible();
        statisticTrafficSoursesByEntryPointsByPromo.click();
        waitForSpinnerDissapear();
    }
    /*по источникам*/
    public void goToStatisticByTrafficSoursesBySoursesByTypes() {
        waitForSpinnerDissapear();
        statistic.waitUntilVisible();
        statistic.click();
        waitForSpinnerDissapear();
        if(!statisticTrafficSoursesBySourses.isCurrentlyVisible()){
            statisticTrafficSourses.click();
            waitForSpinnerDissapear();
        }
        if(!statisticTrafficSoursesBySoursesByTypes.isCurrentlyVisible()){
            statisticTrafficSoursesBySourses.click();
            waitForSpinnerDissapear();
        }
        statisticTrafficSoursesBySoursesByTypes.waitUntilVisible();
        statisticTrafficSoursesBySoursesByTypes.click();
        waitForSpinnerDissapear();
    }


    public void goToStatisticByTrafficSoursesBySoursesByReffers() {
        waitForSpinnerDissapear();
        statistic.waitUntilVisible();
        statistic.click();
        waitForSpinnerDissapear();
        if(!statisticTrafficSoursesBySourses.isCurrentlyVisible()){
            statisticTrafficSourses.click();
            waitForSpinnerDissapear();
        }
        if(!statisticTrafficSoursesBySoursesByReferers.isCurrentlyVisible()){
            statisticTrafficSoursesBySourses.click();
            waitForSpinnerDissapear();
        }
        statisticTrafficSoursesBySoursesByReferers.waitUntilVisible();
        statisticTrafficSoursesBySoursesByReferers.click();
        waitForSpinnerDissapear();
    }

    public void goToStatisticByTrafficSoursesBySoursesBySubaccounts() {
        waitForSpinnerDissapear();
        statistic.waitUntilVisible();
        statistic.click();
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {

        }
        waitForSpinnerDissapear();

        if(!statisticTrafficSoursesBySourses.isCurrentlyVisible()){
            statisticTrafficSourses.click();
            waitForSpinnerDissapear();
        }

        if(!statisticTrafficSoursesBySoursesBySubaccounts.isCurrentlyVisible()){
            statisticTrafficSoursesBySourses.click();
            waitForSpinnerDissapear();
        }
        statisticTrafficSoursesBySoursesBySubaccounts.waitUntilVisible();
        statisticTrafficSoursesBySoursesBySubaccounts.click();
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {

        }
        waitForSpinnerDissapear();
    }

    public void goToStatisticByTrafficSoursesBySoursesByKeywords() {
        waitForSpinnerDissapear();
        statistic.waitUntilVisible();
        statistic.click();
        waitForSpinnerDissapear();
        if(!statisticTrafficSoursesBySourses.isCurrentlyVisible()){
            statisticTrafficSourses.click();
            waitForSpinnerDissapear();
        }
        if(!statisticTrafficSoursesBySoursesByKeywords.isCurrentlyVisible()){
            statisticTrafficSoursesBySourses.click();
            waitForSpinnerDissapear();
        }
        statisticTrafficSoursesBySoursesByKeywords.waitUntilVisible();
        statisticTrafficSoursesBySoursesByKeywords.click();
        waitForSpinnerDissapear();
    }

    /*Аудитория*/
    /*по странам*/
    public void goToStatisticByAuditoryByCountriesByLang() {
        waitForSpinnerDissapear();
        statistic.waitUntilVisible();
        statistic.click();
        waitForSpinnerDissapear();
        if(!statisticAuditoryByCountries.isCurrentlyVisible()){
            statisticAuditory.click();
            waitForSpinnerDissapear();
        }
        if(!statisticAuditoryByCountriesByLang.isCurrentlyVisible()){
            statisticAuditoryByCountries.click();
            waitForSpinnerDissapear();
        }
        statisticAuditoryByCountriesByLang.waitUntilVisible();
        statisticAuditoryByCountriesByLang.click();
        waitForSpinnerDissapear();
    }

    public void goToStatisticByAuditoryByCountriesByGeografy() {
        waitForSpinnerDissapear();
        statistic.waitUntilVisible();
        statistic.click();
        waitForSpinnerDissapear();
        if(!statisticAuditoryByCountries.isCurrentlyVisible()){
            statisticAuditory.click();
            waitForSpinnerDissapear();
        }
        if(!statisticAuditoryByCountriesByGeografy.isCurrentlyVisible()){
            statisticAuditoryByCountries.click();
            waitForSpinnerDissapear();
        }
        statisticAuditoryByCountriesByGeografy.waitUntilVisible();
        statisticAuditoryByCountriesByGeografy.click();
        waitForSpinnerDissapear();
    }

    public void goToStatisticByAuditoryByCountriesByTimezones() {
        waitForSpinnerDissapear();
        statistic.waitUntilVisible();
        statistic.click();
        waitForSpinnerDissapear();
        if(!statisticAuditoryByCountries.isCurrentlyVisible()){
            statisticAuditory.click();
            waitForSpinnerDissapear();
        }
        if(!statisticAuditoryByCountriesByTimeZones.isCurrentlyVisible()){
            statisticAuditoryByCountries.click();
            waitForSpinnerDissapear();
        }
        statisticAuditoryByCountriesByTimeZones.waitUntilVisible();
        statisticAuditoryByCountriesByTimeZones.click();
        waitForSpinnerDissapear();
    }
    /*по поведению*/
    public void goToStatisticByAuditoryByBehaviorByNewandReturned() {
        waitForSpinnerDissapear();
        statistic.waitUntilVisible();
        statistic.click();
        waitForSpinnerDissapear();
        if(!statisticAuditoryByBehavior.isCurrentlyVisible()){
            statisticAuditory.click();
            waitForSpinnerDissapear();
        }
        if(!statisticAuditoryByBehaviorByNewandReturned.isCurrentlyVisible()){
            statisticAuditoryByBehavior.click();
            waitForSpinnerDissapear();
        }
        statisticAuditoryByBehaviorByNewandReturned.waitUntilVisible();
        statisticAuditoryByBehaviorByNewandReturned.click();
        waitForSpinnerDissapear();
    }

    /*по технологии*/
    public void goToStatisticByAuditoryByTechnologyByBrowser() {
        waitForSpinnerDissapear();
        statistic.waitUntilVisible();
        statistic.click();
        waitForSpinnerDissapear();
        if(!statisticAuditoryByTechnology.isCurrentlyVisible()){
            statisticAuditory.click();
            waitForSpinnerDissapear();
        }
        if(!statisticAuditoryByTechnologyByBrowser.isCurrentlyVisible()){
            statisticAuditoryByTechnology.click();
            waitForSpinnerDissapear();
        }
        statisticAuditoryByTechnologyByBrowser.waitUntilVisible();
        statisticAuditoryByTechnologyByBrowser.click();
        waitForSpinnerDissapear();
    }

    public void goToStatisticByAuditoryByTechnologyByOC() {
        waitForSpinnerDissapear();
        statistic.waitUntilVisible();
        statistic.click();
        waitForSpinnerDissapear();
        if(!statisticAuditoryByTechnology.isCurrentlyVisible()){
            statisticAuditory.click();
            waitForSpinnerDissapear();
        }
        if(!statisticAuditoryByTechnologyByOC.isCurrentlyVisible()){
            statisticAuditoryByTechnology.click();
            waitForSpinnerDissapear();
        }
        statisticAuditoryByTechnologyByOC.waitUntilVisible();
        statisticAuditoryByTechnologyByOC.click();
        waitForSpinnerDissapear();
    }
    /*по устройствам*/
    public void goToStatisticByAuditoryByDevicesByTypes() {
        waitForSpinnerDissapear();
        statistic.waitUntilVisible();
        statistic.click();
        waitForSpinnerDissapear();
        if(!statisticAuditoryByDevices.isCurrentlyVisible()){
            statisticAuditory.click();
            waitForSpinnerDissapear();
        }
        if(!statisticAuditoryByDevicesByType.isCurrentlyVisible()){
            statisticAuditoryByDevices.click();
            waitForSpinnerDissapear();
        }
        statisticAuditoryByDevicesByType.waitUntilVisible();
        statisticAuditoryByDevicesByType.click();
        waitForSpinnerDissapear();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {

        }
    }

    public boolean isOnDevicetypePage(){
        return this.getDriver().getCurrentUrl().contains("devices/type");
    }

    public void goToStatisticByAuditoryByDevicesByMobileDevices() {
        waitForSpinnerDissapear();
        statistic.waitUntilVisible();
        statistic.click();
        waitForSpinnerDissapear();
        if(!statisticAuditoryByDevices.isCurrentlyVisible()){
            statisticAuditory.click();
            waitForSpinnerDissapear();
        }
        if(!statisticAuditoryByDevicesByMobile.isCurrentlyVisible()){
            statisticAuditoryByDevices.click();
            waitForSpinnerDissapear();
        }
        statisticAuditoryByDevicesByMobile.waitUntilVisible();
        statisticAuditoryByDevicesByMobile.click();
        waitForSpinnerDissapear();
    }

    public void goToApiDocs(){
        this.getDriver().get(System.getProperty("webdriver.base.url")+"api/dev");
    }

    public void goToHelp(){
        this.getDriver().get(System.getProperty("webdriver.base.url")+"help/info");
        this.getDriver().manage().window().maximize();
    }

    public void goToGoods() {
        waitForSpinnerDissapear();
        goodsAndCoupons.waitUntilVisible();
        goodsAndCoupons.click();
        waitForSpinnerDissapear();
        goods.waitUntilVisible();
        if(!goodsCatalog.isCurrentlyVisible()){
            goods.click();
        }
        goodsCatalog.click();
        waitForSpinnerDissapear();
    }

    public void goToTextShift() {
        String baseUrl = System.getProperty("webdriver.base.url");
        getDriver().get(baseUrl+"webmaster_pro/tools/feeds/text_shift_434161042.0.htm");
        /*waitForSpinnerDissapear();
        tools.waitUntilVisible();
        tools.click();
        try {Thread.sleep(10000);} catch (InterruptedException e) {}
        waitForSpinnerDissapear();
        if(!textShift.isCurrentlyVisible()){
            pushAds.waitUntilVisible();
            pushAds.click();
        }
        textShift.click();
        try {Thread.sleep(10000);} catch (InterruptedException e) {e.printStackTrace();}*/
        waitForSpinnerDissapear();
    }

    public void goToGoodsCatalog(){
        waitForSpinnerDissapear();
        goodsAndCoupons.waitUntilVisible();
        goodsAndCoupons.click();
        try {Thread.sleep(10000);} catch (InterruptedException e) {}
        waitForSpinnerDissapear();
        if(!goodsCatalog.isCurrentlyVisible()){
            goods.waitUntilVisible();
            goods.click();
        }
        goodsCatalog.click();
        try {Thread.sleep(10000);} catch (InterruptedException e) {e.printStackTrace();}
        waitForSpinnerDissapear();
    }


    public void goToGoodsCategory(){
        waitForSpinnerDissapear();
        goodsAndCoupons.waitUntilVisible();
        goodsAndCoupons.click();
        try {Thread.sleep(10000);} catch (InterruptedException e) {}
        waitForSpinnerDissapear();
        if(!goodsCatalog.isCurrentlyVisible()){
            goods.waitUntilVisible();
            goods.click();
        }
        goodsCategory.waitUntilVisible();
        goodsCategory.click();
        try {Thread.sleep(10000);} catch (InterruptedException e) {e.printStackTrace();}
        waitForSpinnerDissapear();
    }



    public void goToCoupons(){
        waitForSpinnerDissapear();
        goodsAndCoupons.waitUntilVisible();
        goodsAndCoupons.click();
        try {Thread.sleep(10000);} catch (InterruptedException e) {}
        waitForSpinnerDissapear();
        if(!couponsAndPromocodes.isCurrentlyVisible()){
            coupons.waitUntilVisible();
            coupons.click();
        }
        couponsAndPromocodes.click();
        try {Thread.sleep(10000);} catch (InterruptedException e) {e.printStackTrace();}
        waitForSpinnerDissapear();
    }



    public void goToOffersAdv() {
        advOffers.waitUntilVisible();
        advOffers.click();
        waitForSpinnerDissapear();
        table.waitTable();
        waitOpacity();
    }

    public void clickFirstBreadCrumbs() {
        waitForSpinnerDissapear();
        breadСrumbs.waitUntilVisible();
        breadСrumbs.click();
        waitForSpinnerDissapear();
    }

    public void goToPaymentInfo() {
        waitForSpinnerDissapear();
        if(!paymentInfo.isCurrentlyVisible()){
            myAccount.waitUntilVisible();
            myAccount.click();
        }
        waitForSpinnerDissapear();
        if(paymentInfo.isCurrentlyVisible()){
            paymentInfo.click();
        }
        waitForSpinnerDissapear();
    }

    public void goToExchange() {
        waitForSpinnerDissapear();
        if(!exchange.isCurrentlyVisible()){
            finances.click();
            waitForSpinnerDissapear();
        }
        exchange.click();
        waitForSpinnerDissapear();
    }

    public void goToOperation() {
        waitForSpinnerDissapear();
        if(!operationHystory.isCurrentlyVisible()){
            finances.click();
            waitForSpinnerDissapear();
        }
        operationHystory.click();
        waitForSpinnerDissapear();
    }

    public void goToPayments() {
        waitForSpinnerDissapear();
        if(!payments.isCurrentlyVisible()){
            finances.click();
            waitForSpinnerDissapear();
        }
        payments.click();
        waitForSpinnerDissapear();
    }

    public void goToDashboard() {
        waitForSpinnerDissapear();
        home.click();
        waitForSpinnerDissapear();
        table.waitOverview();
    }

    public void clickOldInterfaceButton() {
        waitForSpinnerDissapear();
        oldButton.waitUntilVisible();
        oldButton.click();
    }


    public void checkH1interfaceOld() {
        h1OldInterface.shouldBeCurrentlyVisible();
    }
}





