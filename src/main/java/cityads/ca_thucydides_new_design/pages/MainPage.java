package cityads.ca_thucydides_new_design.pages;


import cityads.ca_thucydides_new_design.pages.refactor.BasePage;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(partialLinkText="Русский")
    public WebElement ruLink;

    @FindBy(partialLinkText="Portug")
    public WebElement ptLink;

    @FindBy(partialLinkText="English")
    public WebElement enLink;

    @FindBy(xpath = "//a[@id='popup-language-link']")
    public WebElement selectLang;

    @FindBy(id = "_left_menu_id_3999969")
    public WebElement ExchangeLink;

    @FindBy(xpath="//div[contains(@class,'select dark _select_modal')]/div[contains(@class,'select-choose pointer')]")
    public WebElement popupselectChoose;

    @FindBy(id = "id_el_text_field_name")
    public WebElement inputFieldName;

    @FindBy(xpath = "//div[contains(concat(' ', normalize-space(@class), ' '), 'popup modal show ') ]")
    public WebElement popupPage;

    public boolean checkWelcomePageIsDidplayed(){
        boolean check = element(popupPage).isCurrentlyVisible();
        return check;
    }

    @FindBy(xpath="//div[@class='hover_me _yes']/span")
    public WebElementFacade newVersionButton;


    @FindBy(xpath = "//div[contains(concat(' ', @class, ' '), ' _preview_block ')]")
    public WebElement previewBlock;


    @FindBy(xpath="//div[@class='digit']")
    public WebElement conversion_number;

    @FindBy(xpath = "//div[contains(concat(' ', @class, ' '), ' _colorpicker ')]")
    public WebElement colorPicker;


    @FindBy(id="_left_menu_id_423609452")
    public WebElement statByInstrumentsLink;

    @FindBy(id="_left_menu_id_424091311")
    public WebElement overviewLink;

    @FindBy(id="_left_menu_id_425209553")
    public WebElement realTimeLink;

    @FindBy(id="_left_menu_id_426689653")
    public WebElement realtimrByPeriodLink;

    @FindBy(xpath = "//div[contains(@class,'CheckContainer')]")
    public List<WebElement> filtersRight;


    @FindBy(id="_left_menu_id_426729753")
    public WebElement statByTimeByPeriodLink;

    @FindBy(id="_left_menu_id_425229553")
    public WebElement byOffersLink;

    @FindBy(id="_left_menu_id_419839323")
    public WebElement byOffersNotRealtimeLink;

    @FindBy(id="_left_menu_id_423130345")
    public WebElement conversionPostbackLink;

    @FindBy(id="_left_menu_id_426729753")
    public WebElement statConversionByTime;

    @FindBy(id="_left_menu_id_419819323")
    public WebElement byOffersMainLink;


//       public WebElement getFirstPointInActive(){
//             WebElement circle = getDriver().findElement(By.className("hb-navi")).findElement(By.className(""));
//             return circle;
//       }

    @FindBy(linkText="Список офферов")
    public WebElement offerListLink;

    @FindBy(className="progress-busy")
    public WebElement progressBar;

    @FindBy(className="path")
    public WebElement breadCrumbs;

    @FindBy(className="_selected_filters")
    public WebElementFacade filterBreadcrumbs;

    public List<WebElementFacade> getAllFilterBreadcrumbs(){
        return this.findAll(By.xpath("//div[contains(@class,'_selected_filters')]"));
    }


    @FindBy(className="site_search")
    public WebElement searchField;

    @FindBy(id="_left_menu_id_3641940")
    public WebElement webOffers;

    @FindBy(id="_left_menu_id_407479372")
    public WebElement mobileOffers;

    @FindBy(xpath="//a[@class='close _close size-12 col-ccc']")
    public WebElement popupClose;

    @FindBy(className="lens")
    public WebElement searchButton;

    @FindBy(xpath="/html/body/div[2]/div[1]/div[2]/div[2]/div[3]")
    public WebElement wmNameLink;

    @FindBy(id="swiffycontainer")
    public WebElement flashBlock;

    @FindBy(className="login-link")
    public WebElement loginButton;

    @FindBy(className="popup-padding")
    public WebElement popupLogin;

    @FindBy(name="nick")
    public WebElement loginField;

    @FindBy(name="passwd")
    public WebElement passwordField;

    @FindBy(xpath="//*[@id=\"popup-login\"]/div/div/form/span[2]")
    public WebElement enterButton;

    @FindBy(xpath="//*[@id=\"popup-login\"]/div/div/form/span[1]")
    public WebElement rememberMe;

    @FindBy(className="_menu_switch")
    public WebElement menuSwitch;

    @FindBy(className="no-zebra")
    public WebElement rightBlock;

    @FindBy(linkText="Изменить")
    public WebElement changeButton;

    @FindBy(xpath="/html/body/center/div/div[4]/div/div[2]/h1")
    public WebElement title;

    @FindBy(className="footer")
    public WebElement footer;

    @FindBy(id="submit_ok")
    public WebElementFacade submitOk;

    @FindBy(linkText="ОК")
    public WebElement submitPopupButton;

    @FindBy(tagName="h1")
    public WebElement h1;

    public String getH1Title() {
        return h1.getText();
    }

    @FindBy(xpath="//table[contains(concat(' ', normalize-space(@class), ' '), 'blue_table') ]")
    public WebElement blueTable;

    public WebElementFacade getBlueTable(){
        return element(blueTable);
    }


    public int getBluetablePageCount(){
        if(!(getBlueTable().findElement(By.tagName("tbody")).getText().contains("Нет данных")&&getBlueTable().findElement(By.tagName("tbody")).getText().contains("Элементы не найдены"))){
            return Integer.parseInt(this.find(By.xpath("//div[@class='ib' and @format='num'][2]")).getText());}
        else {
            return 0;
        }
    }

    public WebElementFacade getBluetableFirstCheckbox(){
        return element(getBlueTable().findElement(By.tagName("tbody")).findElement(By.tagName("label")));
    }

    public int getBlueTableLinesCount(){
        int count = getBlueTable().findElements(By.tagName("tr")).size();
        return count;
    }

    @FindBy(linkText="Новости")
    public WebElement newsLink;


    @FindBy(className="paginator_new")
    public WebElement pager;

    @FindBy(className="select-list")
    public WebElement selectList;

    public WebElement getSelectList(){
        element(selectList).waitUntilVisible();
        return selectList;
    }

    @FindBy(id="menu_top_wm_item_3641923")
    public WebElement instrumentiLink;

    @FindBy(className="chart")
    public WebElement highCharts;

    public WebElementFacade getHightcharts(){
        return element(highCharts);
    }

    @FindBy(id="create_user")
    public WebElement createButton;

    @FindBy(id="_left_menu_id_3641921")
    public WebElement cabinetLink;

    @FindBy(id="_left_menu_id_403699272")
    public WebElement accountLink;

    @FindBy(id="_left_menu_id_413079372")
    public WebElement rotatorsLink;

    @FindBy(id="_left_menu_id_416459372")
    public WebElement bannerRotatorLink;

    @FindBy(xpath="//div[@class='error-container']")
    public WebElementFacade errorCOntainer;

    @FindBy(xpath="//form[@class='new-login-form']")
    public WebElementFacade loginFormBig;

    @FindBy(id="id_el_th_a_364199172_67_id")
    public WebElement sortByIdButton;

    public void sort_blue_table_by_first_th(){
        waitForSpinnerDissapear();
        blueTable.findElement(By.tagName("thead")).findElement(By.tagName("th")).click();
        waitForSpinnerDissapear();

    }

    public WebElement get_first_line_in_blue_table(){
        return blueTable.findElement(By.tagName("tbody")).findElement(By.tagName("tr"));
    }


    @FindBy(id="id_el_td_364197172_67_name_1")
    public WebElement blueTableFirstLineName;

    @FindBy(id="user_feed_wm_full_edit")
    public WebElement editButton;

    @FindBy(className="select-choose")
    public WebElement firstSelectDownArrow;

    @FindBy(className="select-item")
    public WebElement selectItem;

    @FindBy(linkText="JavaScript код")
    public WebElement bannerRotatorBannerTypeLink;

    @FindBy(id="menu_top_wm_item_3641922")
    public WebElement statisticLink;

    @FindBy(id="id_el_link_update")
    public WebElement updateButton;

    @FindBy(xpath="//div[@class='select datepicker-range-select period']/div[@class='select-choose pointer']")
    public WebElement calendarpointer;



    public WebElement getUpdateButtonOnPopupWindow(){
        WebElement button;
        button = getDriver().findElement(By.className("popup-controls")).findElement(By.tagName("a"));
        return button;
    }

    @FindBy(id="_left_menu_id_424119552")
    public WebElementFacade statByKeywordsLink;

    @FindBy(id="_left_menu_id_424091321")
    public WebElementFacade statSourseBySourse;

    @FindBy(id="_left_menu_id_424119552")
    public WebElementFacade statByWordsLink;

    @FindBy(className="calendar")
    public WebElement calendar;

    @FindBy(id="_left_menu_id_419879323")
    public WebElementFacade statBySubaccountsLink;

    public void waitForCalendar(){
        element(calendar).waitUntilVisible();
    }


    @FindBy(className="select-list")
    private WebElement calendarSelectList;

    @FindBy(className="popup-with-bg")
    private WebElement calendarSubmitButton;

    @FindBy(linkText="С начала года")
    private WebElement startDate;

    public void scroll(WebElement element) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element); // прокрутка к элементу
    }

    public void select_from_year_start_in_calendar(WebElement calendar){
        getDriver().findElement(By.xpath("/html/body/div[4]/div[2]/div[2]/div/div/div[2]")).click();  //будет разный путь для всех календарей
        element(calendarSelectList).isCurrentlyVisible();
        scroll(startDate);
        startDate.click();
        getUpdateButtonOnPopupWindow().click();

    }

    public WebElement get_first_icon_select_button(int i){
        WebElement button;
        button=getDriver().findElements(By.className("icon-select")).get(i);
        return button;
    }


    @FindBy(className="spinner-icon")
    public WebElement spinner;

    @FindBy(tagName="circle") //поменять на нормальный
    public WebElement statSpinner;

    public WebElementFacade getStatSpinner(){
        return element(statSpinner);
    }

    @FindBy(className="home-banner")
    public WebElement homeBanner;

    @FindBy(partialLinkText="охранить")
    public WebElement saveButton;

    @FindBy(linkText="Сохранить изменения")
    public WebElement saveChangesButton;

    @FindBy(linkText="Сбросить")
    public WebElement resetButton;

    @FindBy(id="id_el_input_filter_reset")
    public WebElement resetFilter;

    @FindBy(linkText="Применить")
    public WebElement applyButton;

    public WebElementFacade getApplyFilterButton(){
        return element(applyButton);
    }

    public WebElementFacade getSpinner(){
        return element(spinner);
    }

    public boolean spinnerCheck(){
        return element(spinner).isPresent();
    }



    @FindBy(linkText="Применить фильтр")
    public WebElement applyFilterButton;

    @FindBy(id="pager_go_to_page")
    public WebElement goToPageField;

    @FindBy(xpath="//button[@class='button submit refresh _apply_filter _with_hook']")
    public WebElementFacade applyFilterRight;

    public WebElement getFirstLineInBlueTable(){
        WebElement line;
        line = getBlueTable().findElement(By.tagName("tbody")).findElement(By.tagName("tr"));
        return line;
    }



    @FindBy(linkText="Топ офферов")
    public WebElement topOffersLink;

    @FindBy(id="_left_menu_id_3641935")
    public WebElement raitingsLink;

    @FindBy(id="menu_top_wm_item_3641924")
    public WebElement officeLink;

    public void clickAccountLink() {
        if(cabinetLink.getAttribute("class").contains("hided")){
            cabinetLink.click();
            waitABit(1000);}
        accountLink.click();
    }

    @FindBy(linkText="Мои домены")
    public WebElement myDomainsLink;

    @FindBy(xpath="//div[contains(@class,'popup')]")
    public WebElementFacade popup;

    @FindBy(id="_left_menu_id_3999966")
    public WebElement financesLink;

    @FindBy(className="profile-manager")
    public WebElement yourManagerBlock;

    @FindBy(id="_left_menu_id_3999968")
    public WebElement operationHistoryLink;

    @FindBy(css="html body.page-home div.all div.section div div.page-content div._main_content div.grid4 div.span3 div.float-right ul.paginator_new li.pages-jump div.relative a.submit")
    public WebElement goToPageArrow;

    @FindBy(className="pages-jump")
    public WebElement pageJumpBlock;

    public WebElement getGotopageArrow(){
        return element(pageJumpBlock).findElement(By.tagName("a"));

    }



    @FindBy(className="ui-autocomplete")
    public WebElement popupList;

    @FindBy(id="ui-id-2")
    public WebElement popupActionsList;

    @FindBy(id="id_el_link_delete")
    public WebElement deleteButton;

    @FindBy(xpath="//table[contains(concat(' ', normalize-space(@class), ' '), 'params') ]")
    public WebElement paramsTable;

    //feedBannerDiv
    @FindBy(xpath="//div[contains(concat(' ', normalize-space(@class), ' '), 'feedBannerDiv') ]")
    public WebElement bannerBlock;

    @FindBy(id="preview")
    public WebElementFacade preview;

    @FindBy(xpath="//div[contains(concat(' ', normalize-space(@class), ' '), 'margin-top popup modal show color-preview width-100 _preview_block') ]")
    public WebElement previewContainer;

    @FindBy(xpath="//div[@class='select-choose pointer']")
    public WebElement selectChoose;

    @FindBy(xpath="//div[@class='select _code_toggle _select']")
    public WebElement selectChooseToggle;

    @FindBy(xpath="//div[contains(concat(' ', normalize-space(@class), ' '), ' select-choose pointer ') ]")
    public WebElement codeSelectArrow;

    public WebElement get_code_toggle_select_arrow(){
        WebElement arrow =  getDriver().findElement(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '), ' _code_toggle ') ]")).findElement(By.className("select-choose"));
        return arrow;
    }

    @FindBy(xpath="//a[@data-id='feedJsField']")
    public WebElement javascriptSelect;

    @FindBy(xpath="//a[@data-id='feedJsField']")
    public WebElement ajsSelect;

    public String getTextareaCodeWithCode(){
        List<WebElementFacade> areas = this.findAll(By.xpath("//textarea"));
        for(WebElementFacade elem : areas){
            if(elem.isCurrentlyVisible()){
                return elem.getText();
            }
        }
        return null;
    }

    @FindBy(linkText="URL xml-фида")
    public WebElement urlXmlSelect;

    @FindBy(linkText="Тизерная выдача")
    public WebElement teaserIssueLink;

    @FindBy(id="id_el_text_field_subaccount")
    public WebElement SubAcccountInputField;

    @FindBy(css="html body.page-tools div.all div.section div div.page-content div._main_content div.section div.list-pages div.swipe div.item form#iform_56 div#feed_filter div.grid4 div div.relative label.with-icon a.label-icon")
    public WebElement multiselectButton;


    public WebElementFacade getPopup(){
        return element(popup);
    }




    @FindBy(css="html body.page-tools div.popup div.popup-padding div.popup-body div.popup-column div.popup-input a.popup-click-list")
    public WebElement popupListSmallArrow;

    public void clickActiveSmallArrow(){
        List<WebElement> list1 = getDriver().findElements(By.className("popup-click-list"));
        int j = 0;
        int size = list1.size();
        while(j<=size){

            try
            {
                getDriver().findElements(By.className("popup-click-list")).get(j).click();
                break;
            }
            catch (Exception e){
                j++;
            }

        }
    }

    public void clickApplyPopupButton(){
        List<WebElement> list1 = getDriver().findElements(By.linkText("Применить"));
        int j = 0;
        int size = list1.size();
        while(j<=size){

            try
            {
                getDriver().findElements(By.linkText("Применить")).get(j).click();
                break;
            }
            catch (Exception e){
                j++;
            }

        }
    }

    @FindBy(css="html body.page-tools div.popup div.popup-padding div.popup-body div.popup-controls a.popup-with-bg")
    public WebElement popupApplyButton;

    @FindBy(className="tabs")
    public WebElement tabs;

    @FindBy(linkText="Ротатор ссылок")
    public WebElement linksRotatorLink;

    @FindBy(className="_reload")
    public WebElement addForm;

    public WebElement getPopupWindowList(int i){
        return getDriver().findElements(By.xpath("//ul[contains(concat(' ', normalize-space(@class), ' '), ' ui-autocomplete ')]")).get(i);
    }

    public WebElement getPopupWindow(int i){
        return getDriver().findElements(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '), 'popup-padding')]")).get(i);
    }

    @FindBy(xpath="//a[contains(concat(' ', normalize-space(@class), ' '), ' button submit save pointer no-right _save_filter _with_hook ')]")
    public WebElement saveLittleButton;

    public void click_apply_in_popup(WebElement elem){
        elem.findElement(By.linkText("Применить")).click();
    }

    public WebElement getPopupControls(int i){
        return getDriver().findElements(By.className("popup-controls")).get(i);
    }

    @FindBy(id="menu_top_wm_item_402759272")
    public WebElement goodsAndCouponsLinks;

    @FindBy(id="_left_menu_id_3641918")
    public WebElement couponsAndPromocodesLink;


    @FindBy(className="simpleGroupCheckContainer")
    public WebElementFacade filters;

    //goods catalog
    @FindBy(id="_left_menu_id_403319272")
    public WebElement goodsCatalogLink;

    @FindBy(id="_left_menu_id_403299272")
    public WebElement goodsLink;

    @FindBy(linkText="Прайс площадка")
    public WebElement pricePlatformLink;

    @FindBy(id="_left_menu_id_403339272")
    public WebElement goodsCategoryLink;


    //statistic
    @FindBy(xpath="//div[contains(concat(' ', normalize-space(@class), ' '), ' icon help pointer nohover margin-left-8 ') ]")
    public WebElement helpIcon;


    public WebElement getHelpIcon(int i){
        return getDriver().findElements(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '), ' icon help pointer nohover margin-left-8 ') ]")).get(i-1);
    }

    @FindBy(xpath="//div[contains(concat(' ', normalize-space(@class), ' '), ' tooltip swing absolute show ') ]")
    public WebElement helpTooltip;

    @FindBy(linkText="Хиты")
    public WebElement statHitsSelect;

    //smart banners
    @FindBy(linkText="Динамические баннеры")
    public WebElement smartBannersLink;

    //financial feed
    @FindBy(linkText="Финансовый фид")
    public WebElement financialFeedLink;

    @FindBy(linkText="Фид")
    public WebElement feedLink;

    public void checkOffersFaviconDisplayed(){
        List<WebElement> icons = getDriver().findElements(By.className("offer-favicon"));

        for(WebElement icon:icons){
            element(icon).isCurrentlyVisible();
        }
    }

    @FindBy(id="_left_menu_id_403459272")
    public WebElement paymentsLink;

    @FindBy(id="pager_go_next")
    public WebElement next_page;

    @FindBy(id="_left_menu_id_3641937")
    public WebElement topWM;

    @FindBy(id="unical_id_actions_web_0")
    public WebElement topWM_all;

    @FindBy(id="unical_id_actions_web_1")
    public WebElement topWM_local;

    @FindBy(xpath="//a[@class='col-blacky underline-h icon-lang dropdown-link']")
    public WebElement ru;


    //col-blacky underline-h icon-lang dropdown-link

    public void click_select_lang(){
        getDriver().findElement(By.xpath("//div[contains(@class,'ib dropdown')]/a")).click();
    }

    public void click_first_lang(){
        getDriver().findElement(By.xpath("//div[contains(@class,'params')]/a[1]")).click();
    }

    public void click_third_lang(){
        getDriver().findElement(By.xpath("//div[contains(@class,'params')]/a[3]")).click();
    }

    public void click_second_lang(){
        getDriver().findElement(By.xpath("//div[contains(@class,'params')]/a[2]")).click();
    }


    @FindBy(linkText="Português (Brasil)")
    public WebElement br;

    @FindBy(id= "id_el_text_field_keyword")
    public WebElement seachfield;

    @FindBy(id= "period")
    public WebElement period;

    @FindBy(id="_left_menu_id_417819372")
    public WebElement conversionsStatMainLink;

    @FindBy(id="_left_menu_id_422049352")
    public WebElement bySalesLink;

    @FindBy(id="_left_menu_id_419799323")
    public WebElement statTrafficSourceLink;

    @FindBy(id="_left_menu_id_424091321")
    public WebElement statBySourcesLink;

    @FindBy(id="_left_menu_id_419859323")
    public WebElement statBySitesLink;

    @FindBy(id="_left_menu_id_431655535")
    public WebElement statByConversionByIntensity;

    @FindBy(id="_left_menu_id_431725535")
    public WebElement statByConversionByIntensityPeriods;

    @FindBy(id="_left_menu_id_432005535")
    public WebElement statByConversionByIntensitySeasons;

    @FindBy(id="_left_menu_id_431935535")
    public WebElement statByConversionByIntensityDays;

    @FindBy(id="_left_menu_id_431865535")
    public WebElement statByConversionByIntensityWeekends;

    @FindBy(id="_left_menu_id_431795535")
    public WebElement statByConversionByIntensityByWeekDay;

    @FindBy(id="_left_menu_id_430375535")
    public WebElement statByTrafficSourseByEntryPoints;

    @FindBy(id="_left_menu_id_430445535")
    public WebElement statByTrafficSourseByEntryPointsByTypes;

    @FindBy(id="_left_menu_id_430515535")
    public WebElement statByTrafficSourseByEntryPointsByLanding;

    @FindBy(id="_left_menu_id_430585535")
    public WebElement statByTrafficSourseByEntryPointsByTargetpages;

    @FindBy(id="_left_menu_id_430655535")
    public WebElement statByTrafficSourseByEntryPointsByGoods;

    @FindBy(id="_left_menu_id_430725535")
    public WebElement statByTrafficSourseByEntryPointsByPromoevets;





    @FindBy(id="_left_menu_id_429835535")
    public WebElement statByTrafficSourseBySourseByTypes;

    @FindBy(id="_left_menu_id_419859323")
    public WebElement statByTrafficSourseBySourseByReferrs;

    @FindBy(id="_left_menu_id_419879323")
    public WebElement statByTrafficSourseBySourseBySubaccounts;

    @FindBy(id="_left_menu_id_424119552")
    public WebElement statByTrafficSourseBySourseByKeywords;





    @FindBy(id="_left_menu_id_426929753")
    public WebElement statByConversionBySegments;
    @FindBy(id="_left_menu_id_426949753")
    public WebElement statByConversionBySegmentsTypes;
    @FindBy(id="_left_menu_id_426969753")
    public WebElement statByConversionBySegmentsBusines;
    @FindBy(id="_left_menu_id_426989753")
    public WebElement statByConversionBySegmentsOffers;


    @FindBy(id="_left_menu_id_428769753")
    public WebElement statByConversionByActions;
    @FindBy(id="_left_menu_id_428789753")
    public WebElement statByConversionByActionsTypes;
    @FindBy(id="_left_menu_id_428809753")
    public WebElement statByConversionByActionsConversions;
    @FindBy(id="_left_menu_id_431589893")
    public WebElement statByConversionByActionsByMetods;

    @FindBy(id="_left_menu_id_428969753")
    public WebElement statByConversionByTools;
    @FindBy(id="_left_menu_id_428989753")
    public WebElement statByConversionByToolsTypes;
    @FindBy(id="_left_menu_id_429009753")
    public WebElement statByConversionByToolsCategories;
    @FindBy(id="_left_menu_id_429029753")
    public WebElement statByConversionByToolsFormat;
    @FindBy(id="_left_menu_id_430079752")
    public WebElement statByConversionByToolsTypeLink;
    @FindBy(id="_left_menu_id_430099752")
    public WebElement statByConversionByToolsTypeSize;
    @FindBy(id="_left_menu_id_430119752")
    public WebElement statByConversionByToolsSizePromo;

    //calendar
    @FindBy(id="period")
    public WebElement calendarInput;

    @FindBy(xpath="//div[@class='float-right _checkbox_place']")
    public WebElement checkboxFiltersMove;

    public List<WebElementFacade> getTooltipsIcons(){
        return this.findAll(By.xpath("//*[contains(@class, '_has_tooltip')]"));
    }

    @FindBy(xpath="//div[@class='tooltip swing absolute show']")
    public WebElementFacade tooltip;

    @FindBy(css="a.popup-click-list")
    public WebElement smallPopupArrow;

    @FindBy(xpath="//div[contains(@class,'autocomplete-results')]")
    public WebElementFacade popupAutocomplete;

    public int getPageCountInPager() {
        return Integer.valueOf(this.find(By.xpath("//div[@class='pager-page']/div[@class='ib'][2]")).getText());
    }

    @FindBy(xpath="//td/nobr[@format='fixed']")
    public List<WebElement> top5Indicators;

    @FindBy(xpath="//div[@class='highcharts-container']")
    public WebElementFacade chart;
}





