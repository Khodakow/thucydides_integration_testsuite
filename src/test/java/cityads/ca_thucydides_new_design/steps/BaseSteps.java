package cityads.ca_thucydides_new_design.steps;

import cityads.ca_thucydides_new_design.pages.MainPage;
import cityads.ca_thucydides_new_design.pages.WemasterPages.WelcomePage;
import cityads.ca_thucydides_new_design.pages.db.MySQLWorker;
import cityads.ca_thucydides_new_design.pages.refactor.BasePage;
import cityads.ca_thucydides_new_design.pages.refactor.Front;
import cityads.ca_thucydides_new_design.pages.refactor.Welcome;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.BannerRotatorSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FrontSteps;
import com.google.common.base.Predicate;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.pages.WebElementFacade;
import org.apache.commons.lang3.StringEscapeUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;


public class BaseSteps extends FrontSteps {

    MainPage mainPage;
    WelcomePage wp;
    BasePage basePage;
    Welcome welcome;
    Front front;

    public BaseSteps(Pages pages) {
        super(pages);


    }

    @Step
    public void refresh_page(){
        String url = getDriver().getCurrentUrl();
        getDriver().get(url);
        //getDriver().navigate().refresh();

    }

    @Step
    public void remove_html_from_blue_table(){
        executeScript("$('.blue-table tbody tr td').each(function(){$(this).empty()})");
    }


    @Step
    public void click_realTimeLink(){
        if(mainPage.realTimeLink.getAttribute("class").contains("hided")) {
            mainPage.realTimeLink.click();
        }
    }
    
    @Step
    public void check_string_contains_text(String str, String text){
        assertThat(str, containsString(text));
    }

    @Step
    public void check_string_not_contains_text(String str, String text){
        assertFalse(str.contains(text));
    }
    

    @Step
    public void click_realtime_by_period(){
        mainPage.realtimrByPeriodLink.click();
    }


    @Step
    public void click_exchange_link(){
        mainPage.ExchangeLink.click();
    }
    
    
    @Step
    public void resize_all_filters(){
        executeScript("$('div.overflow._list._has_scrollable').each(function(){$(this).height('100%');})");
    }
    
    @Step("Проверяем на наличие sql error, fatal error и exception")
    public void check_fatal_errors(){
        List<String> strings = Arrays.asList(getDriver().getPageSource().split("[\\-.\\s\\t\\n\\r\\x0b<>,]"));
        ArrayList<String> words = get_all_fatals_from_array(strings);
        check_array_has_fatals(words);

    }


    @Step("Перейти на главную страницу")
    public void open_main_page(){

        getDriver().get(getPages().getDefaultBaseUrl());
        getDriver().manage().window().maximize();


    }

    @Step
    public int get_conversion_on_main_page(){
        int n;
        n= Integer.valueOf(mainPage.conversion_number.getText().replaceAll("'", ""));
        return n;

    }


    @Step
    public void close_window(){
        executeScript("$('.close').click()"); //tak rabotaet luchshe
    }

    @Step("Браузер закрывается")
    public void close_browser(){
        getDriver().quit();
        getDriver().close();
    }

    @Step
    public void click_enter_button() {
        mainPage.enterButton.click();
    }



    @Step
    public void click_login_button() {
        mainPage.loginButton.click();
    }


    @Step
    public void click_web_offers(){
        mainPage.webOffers.click();
    }

    @Step
    public void click_mobile_offers(){
        mainPage.mobileOffers.click();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException ex) {
            Logger.getLogger(BaseSteps.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Step
    public void click_remember_me_field() {
        mainPage.rememberMe.click();
    }


    @Step
    public void check_text_in_page (String text){

        assertTrue(getDriver().getPageSource().contains(text));
    }


    @Step
    public void enter_login(String wmName) {
        try {Thread.sleep(1000);} catch (InterruptedException ex) {ex.printStackTrace();}
        mainPage.loginField.click();
        mainPage.loginField.clear();
        try {Thread.sleep(1000);} catch (InterruptedException ex) {ex.printStackTrace();}
        executeScript("$('[name=nick]').val('')");
        mainPage.loginField.sendKeys(wmName);
    }

    @Step
    public String get_wm_password(){
        return System.getProperty("password");
    }

    @Step
    public void enter_password() {
        mainPage.passwordField.click();
        mainPage.passwordField.clear();
        executeScript("$('[name=passwd]').val('')");
        mainPage.passwordField.sendKeys(get_wm_password());
    }

    @Step
    public void enter_password(String password) {
        mainPage.passwordField.sendKeys(password);
    }

    @Step
    public void select_ru_language(){
        mainPage.selectLang.click();
        mainPage.ruLink.click();
    }

    @Step
    public void  select_pt_language(){
        mainPage.selectLang.click();
        mainPage.ptLink.click();
    }

    @Step
    public void  select_esp_language(){
        mainPage.selectLang.click();
        mainPage.espLink.click();
    }

    @Step
    public void  select_en_language(){
        mainPage.selectLang.click();
        mainPage.enLink.click();

    }

    @Step("Получаем домен сайта")
    public String get_curent_domain_name(){
        URL url;
        try {url = new URL(getDriver().getCurrentUrl());} catch (MalformedURLException ex) {url = null;}

        String host = url.getHost();
        return host;
    }

    @Step
    public void wm_login(String wmName) {

        login();

        /*open_main_page();
        getDriver().manage().window().maximize();
        String hostBeforeLogin = get_curent_domain_name();

        click_login_button();
        enter_login(wmName);
        waitAjax(1000);
        enter_password();
        waitAjax(1000);
        click_enter_button();
        waitAjax(10000);
        wait_for_opacity();


        if(getDriver().getCurrentUrl().contains("/login")){

            executeScript("$('form').eq(0).remove()"); //убираем верхнюю фирму и заходим через нижнюю
            waitAjax(1000);
            enter_login(wmName);
            waitAjax(1000);
            enter_password();
            waitAjax(1000);
            submit_form();
            waitAjax(2000);
            if(mainPage.submitOk.isCurrentlyVisible()){
                click_login_button();
                waitAjax(10000);
                wait_for_opacity();
            }

        }


        fill_welcome_page();
        waitAjax(3000);
        executeScript("$('.usabilla_live_button_container').remove();");
        String hostAfterLogin = get_curent_domain_name();
        check_values_are_equals(hostBeforeLogin, hostAfterLogin);
        wait_for_opacity();

        if(getDriver().getCurrentUrl().contains("/login")){

            executeScript("$('form').eq(0).remove()"); //убираем верхнюю фирму и заходим через нижнюю
            waitAjax(1000);
            enter_login(wmName);
            waitAjax(1000);
            enter_password();
            waitAjax(1000);
            submit_form();
            waitAjax(2000);
            if(mainPage.submitOk.isCurrentlyVisible()){
                click_login_button();
                waitAjax(10000);
                wait_for_opacity();
            }

        }*/


    }

    @Step
    public void wm_login(String wmName, String password) {
        boolean check;
        open_main_page();
        getDriver().manage().window().maximize();
        String hostBeforeLogin = get_curent_domain_name();
        check = getDriver().getPageSource().contains("Личный кабинет");

        if(check)
        {
            click_login_button();
            waitAjax(2000);
        }

        else
        {
            click_login_button();
            enter_login(wmName);
            enter_password(password);
            click_enter_button();
            waitAjax(2000);

            if(getDriver().getPageSource().contains("error-container")||getDriver().getPageSource().contains("Вы допустили ошибку при заполнении формы")){

                click_login_button();
                enter_login(wmName);
                enter_password(password);
                click_enter_button();
                waitAjax(2000);

            }

        }
        fill_welcome_page();
        waitAjax(3000);
        executeScript("$('.usabilla_live_button_container').remove();");
        String hostAfterLogin = get_curent_domain_name();
        check_values_are_equals(hostBeforeLogin, hostAfterLogin);


    }


    @Step
    public void submit_form(){
        mainPage.submitOk.click();
        waitABit(5000);
    }




    @Step
    public void check_h1_page_title(String title){
        try {
            Thread.sleep(2500);
        } catch (InterruptedException ignored) {

        }
        assertEquals(title, mainPage.getH1Title());
    }

    @Step
    public String get_h1_in_page(){
        return mainPage.getH1Title();
    }

    @Step
    public void check_blue_table_is_visible(){
        assertTrue(mainPage.getBlueTable().isCurrentlyVisible());
    }

    @Step
    public void check_blue_table_has_lines(){
        assertTrue(mainPage.getBlueTableLinesCount() > 1);
    }

    @Step
    public void check_blue_table_has_lines_with_data(){
        assertTrue(mainPage.getBlueTableLinesCount() > 1);
        assertFalse(mainPage.getBlueTable().getText().contains("Sem dados"));
        assertFalse(mainPage.getBlueTable().getText().contains("No data"));
        assertFalse(mainPage.getBlueTable().getText().contains("Нет данных"));
    }

    @Step
    public void check_blue_table_has_text(String name){
        waitABit(5000);
        assertTrue(mainPage.getBlueTable().getText().contains(name));
    }

    @Step
    public void click_blue_table_th(WebElement th, String thText){
        th.click();
        check_fatal_errors();
    }


    public void click_all_th_in_blue_table(){

   /*     int n = 0;
        while(n<get_all_th_in_blue_table().size()-1){
            //waitAjax(5000);
            List<WebElementFacade> thsNew = get_all_th_in_blue_table();
            if(thsNew.get(n).isCurrentlyVisible()){
                List<WebElementFacade> thsNew2 = get_all_th_in_blue_table();
                click_blue_table_th(thsNew2.get(n),thsNew2.get(n).getText());
                waitAjax(3000);
                check_fatal_errors();
                check_popup_is_not_displayed();
                wait_for_all_spinners_dissapears(30);
            }
            n++;
        }*/
    }




    @Step
    public void check_all_th_sort_in_blue_table(){

        waitAjax(8000);
        List<WebElementFacade> ths2 = get_blue_table_list();
        int nn = 0;
        while(nn<ths2.size()){
            List<WebElementFacade> thsNew = mainPage.getBlueTable().thenFindAll(By.tagName("a"));
            if(thsNew.get(nn).isCurrentlyVisible()){
                click_blue_table_th(thsNew.get(nn),thsNew.get(nn).getText());
                //waitAjax(3000);
                check_popup_is_not_displayed();
                //waitAjax(5000);
                wait_for_spinner_dissapear(25);
                check_blue_table_is_visible();
                check_fatal_errors();
                check_popup_is_not_displayed();

            }
            nn++;
        }

        //check_all_th_with_jquery_click();

    }


    @Step
    public List<WebElementFacade> get_blue_table_list(){
        return mainPage.getBlueTable().thenFindAll(By.tagName("a"));
    }


    @Step
    public WebElement getFirstLineInBlueTable(){
        return getDriver().findElement(By.className("blue_table")).findElement(By.tagName("tbody")).findElement(By.tagName("tr"));

    }

    @Step
    public void click_news_link(){
        mainPage.newsLink.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(BaseSteps.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Step
    public void check_pager_is_displayed(){
        assertTrue(mainPage.pager.isDisplayed());
    }

    @Step
    public void check_footer_is_displayed(){
        assertTrue(mainPage.footer.isDisplayed());
    }

    @Step
    public void check_webelement_is_visible(WebElement element){
        assertTrue(element.isDisplayed());
    }



    @Step
    public void check_webelement_value_contains_saved_data(String data, WebElement element){
        assertEquals(data, element.getAttribute("value"));
    }
    @Step
    public void click_submit_ok(){
        try {
            Thread.sleep(2000);
            mainPage.submitOk.click();
        } catch (InterruptedException ex) {
            Logger.getLogger(BaseSteps.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Step
    public void click_instruments_link(){
        mainPage.instrumentiLink.click();


    }

    @Step
    public void click_banners_rotator(){
        mainPage.bannerRotatorLink.click();
    }

    @Step
    public void click_rotators_link(){
        if(mainPage.rotatorsLink.getAttribute("class").contains("hided")){
            mainPage.rotatorsLink.click();}
    }

    @Step
    public void check_highcharts_is_present(){
        assertTrue(mainPage.getHightcharts().isCurrentlyVisible());

    }

    @Step
    public void click_create_button(){
        mainPage.createButton.click();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException ex) {
            Logger.getLogger(BaseSteps.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Step
    public void go_back(){
        getDriver().navigate().back();
    }

    @Step
    public void click_edit_button(){
        mainPage.editButton.click();
    }

    @Step
    public void click_first_select_down_arrow(){
        mainPage.firstSelectDownArrow.click();

    }


    @Step
    public void click_select_choose_n_arrow(int n){
        getDriver().findElements(By.className("select-choose")).get(n).click();

    }


    @Step
    public void click_calendar_first_select_down_arrow_by_xpath(){
        mainPage.calendarpointer.click();

    }

    @Step
    public void executeScript(String Script){
        ((JavascriptExecutor) getDriver()).executeScript(Script);
    }

    @Step
    public int get_offers_count_in_filter(){
        List<WebElement> filters = mainPage.filtersRight;;
        for(WebElement filter:filters){
            if(filter.getAttribute("innerHTML").contains("атегории")){
                return filter.findElements(By.tagName("label")).size();

            }
        }
        return 0;

    }
    @Step
    public int get_offers_brands_count_in_filter(){
        List<WebElement> filters = mainPage.filtersRight;;
        for(WebElement filter:filters){
            if(filter.getText().contains("ренды")){
                return filter.findElements(By.tagName("label")).size();

            }
        }
        return 0;

    }

    @Step
    public int get_offers_regions_count_in_filter(){
        List<WebElement> filters = mainPage.filtersRight;;
        for(WebElement filter:filters){
            if(filter.getAttribute("innerHTML").contains("егионы")){
                return filter.findElements(By.tagName("label")).size();

            }
        }
        return 0;

    }
//filtersRight
    @Step
    public int get_offers_offers_count_in_filter(){
        List<WebElement> filters = mainPage.filtersRight;
        for(WebElement filter:filters){
            if(filter.getText().contains("фферы")){
                return filter.findElements(By.tagName("label")).size();

            }
        }
        return 0;

    }


    @Step
    public int get_offers_status_count_in_filter(){
        List<WebElement> filters = mainPage.filtersRight;;
        for(WebElement filter:filters){
            if(filter.getText().contains("атус купона")){
                return filter.findElements(By.tagName("label")).size();

            }
        }
        return 0;

    }

    @Step
    public int get_offers_type_count_in_filter(){
        List<WebElement> filters = mainPage.filtersRight;;
        for(WebElement filter:filters){
            if(filter.getText().contains("ип купона")){
                return filter.findElements(By.tagName("label")).size();

            }
        }
        return 0;

    }

    @Step
    public int get_offers_currensy_count_in_filter(){
        List<WebElement> filters = mainPage.filtersRight;;
        for(WebElement filter:filters){
            if(filter.getText().contains("алют")){
                return filter.findElements(By.tagName("label")).size();

            }
        }
        return 0;

    }


    @Step
    public int get_offers_traffic_count_in_filter(){
        List<WebElement> filters = mainPage.filtersRight;;
        for(WebElement filter:filters){
            if(filter.getText().contains("трафика")){
                return filter.findElements(By.tagName("label")).size();

            }
        }
        return 0;

    }

    @Step
    public void check_value_gteater_then_min (int count, int countminimum){
        assertTrue(count > countminimum);
    }


    @Step
    public void click_statistic_link(){
        mainPage.statisticLink.click();
    }


    @Step
    public void check_home_big_banner_is_present(){
        assertTrue(mainPage.homeBanner.isDisplayed());
    }


    @Step
    public void click_save_changes_button(){
        mainPage.saveChangesButton.click();
    }

    @Step
    public void clickApplyButton(){
        List <WebElement>list1 =  getDriver().findElements(By.xpath("//a[contains(concat(' ', normalize-space(@class), ' '), ' window-apply ') ]"));
        int size = list1.size();
        int j = 0;
        WebElement apply = null;
        while(j<=size){
            try{
                list1.get(j).click();
                break;
            }
            catch(Exception e){
                apply = null;
                j++;

            }
        }


    }


    @Step("Сбросить фильтр с помошью скрипта #id_el_input_filter_reset'.click")
    public void click_reset_filter_button(){
        executeScript("$('#id_el_input_filter_reset').click()");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Step
    public void click_apply_button(){
        mainPage.applyButton.click();
    }

    @Step
    public void click_links_rotator_link(){
        mainPage.linksRotatorLink.click();

    }

    @Step
    public void click_apply_filter_button(){
        mainPage.applyFilterButton.click();
    }

    @Step("Применить фильтр справа")
    public void click_apply_right_filter(){
        mainPage.applyFilterRight.click();
    }

    @Step
    public void clickApplyPopupButton(){
        getDriver().findElement(By.className("popup-controls")).findElement(By.tagName("a")).click();
    }


    @Step
    public void click_change_button(){
        mainPage.changeButton.click();
    }



    @Step
    public void click_Office_link(){
        mainPage.officeLink.click();

    }


    @Step
    public String get_column_text_in_blue_table_first_line(int columnNumber){
        return mainPage.getFirstLineInBlueTable().findElements(By.tagName("td")).get(columnNumber-1).getText();
    }

    @Step
    public void click_profile_link() {
        mainPage.clickAccountLink();
    }

    @Step
    public void click_my_domains_link(){
        mainPage.myDomainsLink.click();
    }

    @Step
    public void check_popup_is_displayed(){
        mainPage.popup.isDisplayed();
    }

    @Step
    public boolean check_popup_is_currently_visible(){
        return mainPage.getPopup().isCurrentlyVisible();
    }

    @Step
    public void sort_blue_table_by_id() {

        mainPage.blueTable.findElement(By.tagName("thead")).findElement(By.className("id")).click();

    }

    @Step("отсортировать таблицу по первому th")
    public void sort_blue_table_by_first_th(){
        mainPage.sort_blue_table_by_first_th();
    }


    @Step
    public void click_operation_history_link(){
        mainPage.operationHistoryLink.click();

    }


    @Step
    public void click_go_next_page(){
        getDriver().findElement(By.id("pager_go_next")).click();
    }

    @Step
    public void check_popup_list_is_displayed() {
        assertTrue(mainPage.popupList.isDisplayed());
    }

    @Step
    public void click_popup_list_first_item() {
        mainPage.popupList.findElement(By.tagName("li")).findElement(By.tagName("a")).click();
    }


    @Step
    public void select_all_lines_checkbox_in_blue_table(){
        mainPage.blueTable.findElement(By.tagName("thead")).findElement(By.tagName("label")).click();
    }

    @Step
    public void check_advertisment_tabs_displaeyd(){
        assertTrue(mainPage.tabs.isDisplayed());
    }


    @Step
    public void click_icon_in_blue_table_first_line(int i){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(BaseSteps.class.getName()).log(Level.SEVERE, null, ex);
        }
        mainPage.getFirstLineInBlueTable().findElements(By.tagName("img")).get(i).click();
    }

    @Step
    public void click_delete_button(){
        mainPage.deleteButton.click();
    }

    @Step
    public void check_blue_table_has_no_data(){
        assertTrue((mainPage.getBlueTable().findElement(By.tagName("tbody")).getText().contains("Нет данных"))
                || (mainPage.getBlueTable().findElement(By.tagName("tbody")).getText().contains("Элементы не найдены")));
    }

    @Step
    public boolean blue_table_data_check(){
        return ((mainPage.getBlueTable().findElement(By.tagName("tbody")).getText().contains("Нет данных"))
                ||(mainPage.getBlueTable().findElement(By.tagName("tbody")).getText().contains("Элементы не найдены")));
    }

    @Step
    public void check_param_table_is_visible(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(BaseSteps.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertTrue(mainPage.paramsTable.isDisplayed());
    }

    @Step
    public void check_preview_is_visible(){
        assertTrue(mainPage.preview.isDisplayed());
    }


    @Step
    public void click_select_choose(){
        mainPage.selectChoose.click();
    }

    @Step
    public void click_popup_select(){
        mainPage.popupselectChoose.click();
    }


    @Step
    public void click_select_choose_toggle(){
        //mainPage.selectChooseToggle.click();
        executeScript("$('._code_toggle').trigger('click')");
    }

    @Step
    public void click_select_code_arrow(){
        mainPage.get_code_toggle_select_arrow().click();
    }
    @Step
    public void scroll(WebElement element) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element); // прокрутка к элементу
    }

    @Step
    public void scroll_to_apply_filter_button(){
        if(mainPage.applyFilterRight.isCurrentlyVisible()) {
            mainPage.scroll(mainPage.applyFilterRight);
        }
    }

    @Step
    public void select_javascript_code(){

        //mainPage.javascriptSelect.click();
        executeScript("$('[data-id=\"feedJsField\"]').click()");
    }

    @Step
    public void select_ajs_code(){
        //mainPage.ajsSelect.click();
        executeScript("$('[data-id=\"feedJsaField\"]').click()");
    }

    @Step
    public void select_xml_code(){
        mainPage.urlXmlSelect.click();
    }

    @Step
    public void check_banner_code(String code){
        Assert.assertNotNull(code);
    }

    @Step
    public void check_script_code(String code){
        assertTrue("Проверяем что строка не пуста",!code.isEmpty());
    }

    @Step
    public void click_teaser_issue_link(){
        mainPage.teaserIssueLink.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(BaseSteps.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Step
    public void fill_name_input(String name) {
        mainPage.inputFieldName.click();
        mainPage.inputFieldName.clear();
        mainPage.inputFieldName.sendKeys(name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(BannerRotatorSteps.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Step
    public void fill_subaccount_input(String name) {
        mainPage.SubAcccountInputField.click();
        mainPage.SubAcccountInputField.clear();
        mainPage.SubAcccountInputField.sendKeys(name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(BannerRotatorSteps.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Step
    public String click_i_element_in_select_list(int i){
        String selectedElementText = mainPage.selectList.findElements(By.tagName("a")).get(i).getText();
        mainPage.selectList.findElements(By.tagName("a")).get(i).click();
        return selectedElementText;
    }

    @Step
    public String get_i_multiselect_text(int i){
        return getDriver().findElements(By.className("select-value")).get(i).getText();
    }

    @Step
    public void check_values_are_equals(String expected , String actual){
        assertEquals("Проверка что строки равны: " + expected + " = " + actual, expected, actual);
    }

    @Step
    public void check_values_are_equals(int expected , int actual){
        assertEquals("Проверяем что значения равны", expected, actual);
    }

    @Step
    public void click_i_multiselect_button(int i){
        getDriver().findElements(By.xpath("//a[contains(concat(' ', normalize-space(@class), ' '), ' icon-multiselect ')]")).get(i).click();
    }

//     @Step
//     public boolean  waitForAjax() {
//
//            int timeout = 60000;
//            final long startTime = System.currentTimeMillis();
//            final JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getDriver();
// 
//            while ((startTime + timeout) >= System.currentTimeMillis()) {
//                final Boolean scriptResult = (Boolean) javascriptExecutor.executeScript("return jQuery.active == 0");
// 
//                if (scriptResult)
//                    return true;
// 
//                delay(500);
// 
//            }
//            return false;
//      
//       
//}


    @Step
    public void click_popup_small_arrow(){
        mainPage.clickActiveSmallArrow();
    }


    @Step
    public void click_first_element_in_popup_list(){
        mainPage.getPopup().findElement(By.xpath("//span[@class='_auto_items pointer']")).click();


    }


    @StepGroup
    public void click_some_elements_in_popup_list(int i){
        int n = 0;
        int m = i;

        while(n<m){
            click_small_popup_button();
            check_autocomplete_is_displayed();
            click_first_element_in_popup_list();
            n++;
        }
        click_popup_apply_button();
    }

    @Step
    public void check_autocomplete_is_displayed(){
        assertTrue(mainPage.popupAutocomplete.isCurrentlyVisible());
    }

    @Step
    public void click_popup_apply_button(){
        getDriver().findElement(By.xpath("//a[@class='popup-with-bg _window_apply']")).click();
    }

    @Step
    public void click_small_popup_button(){
        mainPage.smallPopupArrow.click();
    }


    @Step
    public void click_first_item_in_popup_dropdown_list(){
        List<WebElement> list2 = getDriver().findElements(By.className("ui-menu-item"));
        int size;
        size = list2.size();
        int j = 0;
        while(j<=size){
            try{
                getDriver().findElement(By.className("ui-menu-item")).findElement(By.tagName("a")).click();
                break;
            }
            catch(Exception e){
                j++;
            }
        }
    }

    @Step
    public void wait_until_element_is_loaded(WebElement elem) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 5000);
        wait.until(ExpectedConditions.visibilityOf(elem));
    }


    @Step
    public void check_add_form_is_displayed(){
        assertTrue(mainPage.addForm.isDisplayed());
    }


    @Step
    public void accept_alert(){
        wait_for_popup_appears(5);
        click_yes_in_popup_delete();
        wait_for_all_spinners_dissapears(90);


    }


    @Step
    public void click_first_checkbox_in_bluetable(){
        wait_for_all_spinners_dissapears();
        mainPage.getBluetableFirstCheckbox().isCurrentlyVisible();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mainPage.getBluetableFirstCheckbox().click();
        wait_for_all_spinners_dissapears();
    }

    @Step("Удаляем все инструменты")
    public void delete_all_from_blue_table(){
        int count = 0;
        while(true) {
            if (!blue_table_data_check()) {
                if (mainPage.getBluetableFirstCheckbox().isCurrentlyVisible()) {
                    waitAjax(1000);
                    click_first_checkbox_in_bluetable();
                    waitAjax(1000);
                    click_delete_button();
                    waitAjax(1000);
                    count++;
                    accept_alert();
                    wait_for_all_spinners_dissapears(120);
                    if(count>50){
                        break;
                    }
                }
            }
            else {
                check_blue_table_has_no_data();
                break;
            }
        }

        //старое удаление
        /*  if(!(mainPage.getBlueTable().findElement(By.tagName("tbody")).getText().contains("Нет данных"))){
            if(!(mainPage.getBlueTable().findElement(By.tagName("tbody")).getText().contains("Элементы не найдены"))){


                int i = mainPage.getBluetablePageCount();  //число страниц
                int j = 0;
                for(j=0;j<i;j++){
                    select_all_lines_checkbox_in_blue_table();
                    click_delete_button();
                    accept_alert();
                    wait_for_all_spinners_dissapears(60);
                    waitAjax(15000);
                }

            }
        }
        check_blue_table_has_no_data();*/
    }

    @Step
    public void click_goods_and_coupons_link(){
        mainPage.goodsAndCouponsLinks.click();
    }

    @Step
    public void click_coupons_and_promocodes_link(){
        mainPage.couponsAndPromocodesLink.click();
    }

    @Step
    public void check_filter_breadcrumbs_is_displayed() {
        assertTrue(mainPage.filterBreadcrumbs.isCurrentlyVisible());
    }

    @Step
    public void search_offer_in_filters_breadcrumbs(String offerName) {
        List<WebElementFacade> list = mainPage.getAllFilterBreadcrumbs();
        String text = null;
        for( WebElementFacade filter : list){
            text += filter.getText();
        }
        assertTrue(text.contains(offerName));


    }
    //goods catalog
    @Step
    public void click_goods_catalog(){
        mainPage.goodsCatalogLink.click();
    }

    
    @Step
    public void click_all_pluses(){
        //executeScript("$(\"i:contains('+')\").each(function(){$(this).click()});");
    }

    
    
    @Step
    public void click_goods_link(){
        if(mainPage.goodsLink.getAttribute("class").contains("hided")){
            mainPage.goodsLink.click();}
    }

    @Step
    public void click_price_platform_link(){
        mainPage.pricePlatformLink.click();
    }

    @Step
    public void click_categories_link(){
        mainPage.goodsCategoryLink.click();
    }

    //statistic

    @Step
    public void check_help_tooltip_is_displayed(){
        assertTrue(mainPage.helpTooltip.isDisplayed());
    }

    //smart banners
    @Step
    public void click_smart_banners(){
        mainPage.smartBannersLink.click();
    }

    @Step
    public void click_i_checkboxes_in_i_offer_filter(int filterNumber, int checkboxAmount) {
        int j = 0;
        //
        WebElement filter = getDriver().findElements(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '), 'simpleGroupCheckContainer') ]")).get(filterNumber);
        int i = 0;
        List<WebElement> allCheckboxList = filter.findElements(By.tagName("label"));
        for (i = 0; i < checkboxAmount; i++) {
            try {
                if (!allCheckboxList.get(i).getAttribute("class").contains("checked selected")) {
                    try {
                        allCheckboxList.get(i).click();
                    } catch (Exception e) {
                        System.out.println("right filter checkbox click fail" + e.getMessage());
                    }
                }
            } catch (Exception e2) {
            }
        }
    }

    @Step
    public void check_offers_favicons_displayed(){
        mainPage.checkOffersFaviconDisplayed();

    }


    @Step
    public void fill_time_zone(){
        wp.fillWelcomePageSocondPage();
    }


    //welcome page================================================
    @StepGroup
    public void fill_welcome_page(){
        welcome.fillWelcomePage();
    }

    @Step
    private void click_new_version() {

        try {
            mainPage.newVersionButton.click();
        }
        catch(Exception ex){

        }

    }

    @Step
    public void wait_for_map(int timeout){
        WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
        wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.className("_map"))));
    }

    @Step
    public void click_dalee_welcome_page_1(){
        wp.nexButton.waitUntilVisible();
        wp.nexButton.click();
    }

    @Step
    public void click_english(){
        wp.getFirstLang().click();
    }

    @Step
    public void click_dalee_welcome_page_2(){
        wp.nexButton.waitUntilVisible();
        wp.nexButton.click();
    }


    @Step
    public void click_dalee_welcome_page_3(){
        executeScript("$('._save_button').click()");
    }
    //==============================================================
    @Step
    public void click_payments_link(){
        mainPage.paymentsLink.click();
    }

    @Step
    public void waitAjax(int timeout){
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException ex) {

        }
    }


    @Step
    public void wait_for_spinner_dissapear(int timeout){
        new FluentWait<WebDriver>(getDriver()).
                withTimeout(timeout, TimeUnit.SECONDS).
                pollingEvery(1, TimeUnit.SECONDS).
                ignoring(NoSuchElementException.class).
                until(new Predicate<WebDriver>(){
                    public boolean apply(WebDriver driver){
                        return !check_if_spinner_visible_with_jquery();
                    }
                });
    }

    @Step
    public void wait_for_opacity_spinner_dissapear(int timeout){
        new FluentWait<WebDriver>(getDriver()).
                withTimeout(timeout, TimeUnit.SECONDS).
                pollingEvery(1, TimeUnit.SECONDS).
                ignoring(NoSuchElementException.class).
                until(new Predicate<WebDriver>(){
                    public boolean apply(WebDriver driver){
                        return !check_if_stat_spinner_visible_with_jquery();
                    }
                });
    }


    @Step("Ждем загрузку страницы, всех крутилок и запросов к стате")
    public void wait_for_all_spinners_dissapears(int timeout){
        basePage.waitSpinner();
    }

    @Step
    public void wait_for_opacity(){
        basePage.waitForAbsenceOf("//div[@class='opacity5 back-white']");
    }

    @Step("Ждем загрузку страницы, всех крутилок и запросов к стате")
    public void wait_for_all_spinners_dissapears(){     //чтобы можно было вызывтаь без времени
        basePage.waitSpinner();
    }


    @Step
    public void wait_for_h1_title_appears(String title, int timeout){
        WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'"+title+"')]")));
    }

    @Step("Ждем появления таблицы")
    public void wait_for_blue_table_appears(int timeout){
        wp.getBlueTable().waitUntilVisible();
    }

    @Step
    public void wait_for_offers_table_appears(int timeout){

        WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("table_wm.web_adv")));
    }


    @Step
    public void wait_for_offerterms_tabs_appears(int timeout){

        WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@tab='offer_inner']")));
    }

    @Step("Ждем появления popup")
    public void wait_for_popup_appears(int timeout){
        mainPage.getPopup().waitUntilVisible();
    }

    @Step
    public void click_finances_link() {
        mainPage.financesLink.click();
    }

    @Step
    public void check_string_has_changed(String oldDate, String newDate) {
        Assert.assertThat(newDate, is(not(oldDate)));

    }

    @Step("Переключаем язык на БР")
    public  void change_lang_to_br(){
        mainPage.click_select_lang();
        mainPage.click_third_lang();
    }

    @Step("Переключаем язык на Es")
    public  void change_lang_to_es(){
        mainPage.click_select_lang();
        mainPage.click_fourth_lang();
    }

    @Step("Переключаем язык на Англ")
    public  void change_lang_to_en(){
        mainPage.click_select_lang();
        mainPage.click_second_lang();
        waitAjax(5000);


    }

    public boolean check_if_stat_spinner_visible_with_jquery(){
        boolean check = false;
        Long spinner;
        spinner = (Long)((JavascriptExecutor)getDriver()).executeScript("return $('.inner-circle').length");
        if(spinner == 0){check = false;}
        else {check = true;}
        return check;
    }


    public boolean check_if_spinner_visible_with_jquery(){
        boolean check = false;
        Long spinner;
        spinner = (Long)((JavascriptExecutor)getDriver()).executeScript("return $('.spinner-icon').length");
        if(spinner == 0){check = false;}
        else {check = true;}
        return check;

    }

    @Step("Проверяем на наличие слов на кириллице")
    public void check_lang_select(){
        executeScript("$('.blue_table>tbody').remove()");
        executeScript("$('div[class*=\"margin-top-micro wsn\"]').remove();");
        executeScript("$('span[class*=\"size-14 col-black\"]').remove();");
        executeScript("$('.mercedes-res').remove()");
        WebElement elem = mainPage.find(By.xpath("//*"));
        List<String> strings = Arrays.asList(elem.getText().split("[\\-.\\s\\t\\n\\r\\x0b<>,]"));
        ArrayList<String> rusWords = get_all_rus_words_from_array(strings);
        check_array_has_elements(rusWords);

    }

    @Step
     public void check_array_has_elements(ArrayList<String> list){
        assertFalse("Найдены слова на кириллице!",list.size()>0);
    }

    @Step
    public void check_array_has_fatals(ArrayList<String> list){
        assertFalse("В исходном коде найдены подозрительные слова !",list.size()>0);
    }

    public ArrayList<String> get_all_rus_words_from_array(List<String> words){
        ArrayList<String> rusWords = new ArrayList<String>();
        for(String s : words){
            if((              s.contains("а")
                            ||s.contains("ы")
                            ||s.contains("и")
                            ||s.contains("э")
                            ||s.contains("ю")
                            ||s.contains("я")
                            ||s.contains("о")
                            ||s.contains("к")
                            ||s.contains("х")
                            ||s.contains("р")
                            ||s.contains("м")
                            ||s.contains("т")
                            ||s.contains("ё")
                            ||s.contains("у")
                            ||s.contains("ю")
                            ||s.contains("е")
                            ||s.contains("ё")
                            ||s.contains("Ы")
                            ||s.contains("И")
                            ||s.contains("Э")
                            ||s.contains("Ю")
                            ||s.contains("Я")
                            ||s.contains("О")
                            ||s.contains("К")
                            ||s.contains("Х")
                            ||s.contains("Р")
                            ||s.contains("М")
                            ||s.contains("Т")
                            ||s.contains("Ё")
                            ||s.contains("У")
                            ||s.contains("Ю")
                            ||s.contains("Е")
                            ||s.contains("Ё")

            )){
                 rusWords.add(StringEscapeUtils.escapeHtml4((StringEscapeUtils.escapeHtml3(s))));
            }
        }
        return rusWords;
    }

    public ArrayList<String> get_all_fatals_from_array(List<String> words){
        ArrayList<String> rusWords = new ArrayList<String>();
        for(String s : words){
            if((      s.contains("Fatal")
                    ||s.contains("Sql error")
                    ||s.contains("SQL ERROR")
                    ||s.contains("SQL error")
                         ||s.contains("FATAL")
                    ||s.contains("FATAL")
                    ||s.contains("ORDER BY")
                    ||s.contains("exception")
                    ||s.contains("sql error")
            )){
                rusWords.add(StringEscapeUtils.escapeHtml4((StringEscapeUtils.escapeHtml3(s))));
            }
        }
        return rusWords;
    }


    @Step
    public void check_welcomepage_for_rus(WebElement elem){
        List<String> strings = Arrays.asList(elem.getText().split(" "));
        for (String elemnt:strings){
            if(!elemnt.contains("Русский")){
                check_strng_for_rus(elemnt);  //добавляем проверку чтобы не тест вылетал на проверкe названия языка
            }
        }
    }


    @Step
    @SuppressWarnings("empty-statement")
    public void check_strng_for_rus(String s) {

        assertFalse(
                s.contains("а")
                        || s.contains("ы")
                        || s.contains("и")
                        || s.contains("э")
                        || s.contains("ю")
                        || s.contains("я")
                        || s.contains("о")
                        || s.contains("к")
                        || s.contains("х")
                        || s.contains("р")
                        || s.contains("м")
                        || s.contains("т")
                        || s.contains("ё")
                        || s.contains("у")
                        || s.contains("ю")
                        || s.contains("е")
                        || s.contains("ё")//
                        || s.contains("Ы")
                        || s.contains("И")
                        || s.contains("Э")
                        || s.contains("Ю")
                        || s.contains("Я")
                        || s.contains("О")
                        || s.contains("К")
                        || s.contains("Х")
                        || s.contains("Р")
                        || s.contains("М")
                        || s.contains("Т")
                        || s.contains("Ё")
                        || s.contains("У")
                        || s.contains("Ю")
                        || s.contains("Е")
                        || s.contains("Ё")
        );

    }


    @Step("Прокручиваем страницу вниз")
    public void scroll_to_bottom() {
        executeScript("window.scrollTo(0,document.body.scrollHeight);");
    }


    @Step("Прокручиваем страницу вверх")
    public void scroll_to_top() {
        executeScript("$('html, body').animate({ scrollTop: 0 }, 'fast');");
    }

    @Step
    public void click_conversions_stat_link(){                                               
        if(getDriver().getPageSource().contains("_left_menu_id_417819372")){
            if(mainPage.conversionsStatMainLink.getAttribute("class").contains("hided")){
                mainPage.conversionsStatMainLink.click();
            }
        }
    }

    @Step
    public void click_conversions_stat_by_intensity_link(){                                               
        
            if(mainPage.statByConversionByIntensity.getAttribute("class").contains("hided")){
                mainPage.statByConversionByIntensity.click();
            
        }
    }    
        
    
    @Step
    public void click_conversions_stat_by_segments_link(){                                               
        
            if(mainPage.statByConversionBySegments.getAttribute("class").contains("hided")){
                mainPage.statByConversionBySegments.click();
            
        }
    }         
                
                
                
    @Step
    public void click_conversions_stat_by_actions_link(){                                               
        
            if(mainPage.statByConversionByActions.getAttribute("class").contains("hided")){
                mainPage.statByConversionByActions.click();
            
        }
    }           
                
        @Step
    public void click_conversions_stat_by_tools_link(){                                               
        
            if(mainPage.statByConversionByTools.getAttribute("class").contains("hided")){
                mainPage.statByConversionByTools.click();
            
        }
                
        }    
            
    @Step
    public WebElement get_blue_table_string_with_text(String text){
        String locator ="'tr:contains(\""+text+"\")'";
        WebElement elem = (WebElement) ((JavascriptExecutor) getDriver()).executeScript("return $(" + locator+ ").get(0)");
        return elem;
    }

    @Step
    public void click_icon_in_blue_table_line_with_text(int i, String text){
        WebElement elem = get_blue_table_string_with_text(text);
        click_icon_in_blue_table_line(i,elem);
    }

    @Step
    public void click_icon_in_blue_table_line(int i, WebElement elem){
        elem.findElement(By.className("acts")).findElements(By.tagName("img")).get(i).click();
    }

    @Step
    public void check_popup_is_not_displayed() {
        assertFalse(mainPage.popup.isCurrentlyVisible());
    }

    @Step
    public void check_text_is_not_displayed(String text){
        mainPage.waitForTextToDisappear(text);
    }

    @Step
    public void click_conversion_by_intensity_by_periods() {
        mainPage.statByConversionByIntensityPeriods.click();
    }
    
    @Step
    public void click_conversion_by_intensity_by_seasons() {
        mainPage.statByConversionByIntensitySeasons.click();
    }
        
    @Step
    public void click_conversion_by_intensity_by_days() {
        mainPage.statByConversionByIntensityDays.click();
    }
    @Step
    public void click_conversion_by_intensity_by_weekends() {
        mainPage.statByConversionByIntensityWeekends.click();
    }
    @Step
    public void click_conversion_by_intensity_by_week_day() {
        mainPage.statByConversionByIntensityByWeekDay.click();
    }
    @Step
    public void click_conversion_by_segments__types(){
        mainPage.statByConversionBySegmentsTypes.click();
    }
    @Step
    public void click_conversion_by_segments_busines() {
        mainPage.statByConversionBySegmentsBusines.click();
    }
    @Step
    public void click_conversion_by_segments_offers() {
        mainPage.statByConversionBySegmentsOffers.click();
    }
   
    @Step
    public void click_conversion_by_actions_types() {
        mainPage.statByConversionByActionsTypes.click();
    } 
       
    @Step
    public void click_conversion_by_actions_conversions() {
        mainPage.statByConversionByActionsConversions.click();
    }
    @Step
    public void click_conversion_by_actions_metods() {
        mainPage.statByConversionByActionsByMetods.click();
    }
    
    
    @Step
    public void click_conversion_by_tools_types() {
        mainPage.statByConversionByToolsTypes.click();
    }
        
    @Step
    public void click_conversion_by_tools_categories() {
        mainPage.statByConversionByToolsCategories.click();
    }    
    
    @Step
    public void click_conversion_by_tools_format() {
        mainPage.statByConversionByToolsFormat.click();
    }
    
    @Step
    public void click_conversion_by_tools_type_link() {
        mainPage.statByConversionByToolsTypeLink.click();
    }
    
    @Step
    public void click_conversion_by_tools_type_size() {
        mainPage.statByConversionByToolsTypeSize.click();
    }
    
    @Step
    public void click_conversion_by_tools_size_promo() {
        mainPage.statByConversionByToolsSizePromo.click();
    }
    
    @Step
    public void click_stat_traffic_source_link(){
        if(mainPage.statTrafficSourceLink.getAttribute("class").contains("hided")){
            mainPage.statTrafficSourceLink.click();
        }
    }

    @Step
    public void click_stat_by_keywords_link(){
        if(mainPage.statByKeywordsLink.getAttribute("class").contains("hided")){
            mainPage.statByKeywordsLink.click();
        }
    }
    
    @Step
    public void click_stat_by_sourse_sourse_link(){
        if(mainPage.statSourseBySourse.getAttribute("class").contains("hided")){
            mainPage.statSourseBySourse.click();
        }
    }
    
        
    @Step
    public void click_stat_by_sourse_traffic_by_entry_poits(){
        if(mainPage.statByTrafficSourseByEntryPoints.getAttribute("class").contains("hided")){
            mainPage.statByTrafficSourseByEntryPoints.click();
        }
    }   
        

    @Step
    public void click_by_subaccounts_link(){
        mainPage.statBySubaccountsLink.click();
    }

    @Step
    public void click_stat_traffic_by_source_link(){
        if(mainPage.statBySourcesLink.getAttribute("class").contains("hided")){
            mainPage.statBySourcesLink.click();
        }
    }

    @Step
    public void click_stat_traffic_by_sites_link(){
        mainPage.statBySitesLink.click();
    }
    
    
    @Step
    public void click_stat_by_sourse_traffic_by_entry_poits_by_types(){
        mainPage.statByTrafficSourseByEntryPointsByTypes.click();
    }
    
    @Step
    public void click_stat_by_sourse_traffic_by_entry_poits_by_landing(){
        mainPage.statByTrafficSourseByEntryPointsByLanding.click();
    }
            
            
   
           
    
    @Step
    public void click_stat_by_sourse_traffic_by_entry_poits_by_targetpages(){
        mainPage.statByTrafficSourseByEntryPointsByTargetpages.click();
    }
        
        
    @Step
    public void click_stat_by_sourse_traffic_by_entry_poits_by_goods(){
        mainPage.statByTrafficSourseByEntryPointsByGoods.click();
    }
        
    @Step
    public void click_stat_by_sourse_traffic_by_entry_poits_by_promo_events(){
        mainPage.statByTrafficSourseByEntryPointsByPromoevets.click();
    }    
    
    
    
    
    
    
    @Step
    public void click_stat_by_sourse_traffic_by_sourse_by_types(){
        mainPage.statByTrafficSourseBySourseByTypes.click();
    }
        
        
    @Step
    public void click_stat_by_sourse_traffic_by_sourse_by_reffers(){
        mainPage.statByTrafficSourseBySourseByReferrs.click();
    }
        
    @Step
    public void click_stat_by_sourse_traffic_by_sourse_by_subaccounts(){
        mainPage.statByTrafficSourseBySourseBySubaccounts.click();
    }  
    
    
    @Step
    public void click_stat_by_sourse_traffic_by_sourse_by_keywords(){
        mainPage.statByTrafficSourseBySourseByKeywords.click();
    } 
    
    
    
    
    
    
        
    @Step
    public String get_calendar_input_data(){
        return mainPage.calendarInput.getAttribute("value");
    }

    @Step
    public void click_conversion_postback_link() {
        mainPage.conversionPostbackLink.click();
    }

    @Step
    public void check_all_tooltips_translate(){
        basePage.waitOpacity();
        List<WebElementFacade> list = mainPage.getTooltipsIcons();
        for(WebElementFacade icon : list){
            if(icon.isCurrentlyVisible()){
                click_element(icon);
                waitAjax(1000);
                if(mainPage.tooltip.isCurrentlyVisible()){
                    check_strng_for_rus(get_tooltip_text());
                }
            }
        }
    }

    @Step
    public String get_tooltip_text(){
        try {
            String text = mainPage.tooltip.getText();
            return text;
        }
        catch(Exception e){
            return " ";
        }

    }


    @Step
    public void click_element(WebElement elem){
        elem.click();
    }

    @Step
    public void fill_in_search_filter(String text) {
        mainPage.seachfield.clear();
        mainPage.seachfield.sendKeys(text);
    }

    @Step
    public void check_welcomepage_translate(){
        check_welcomepage_for_rus(mainPage.popup);
    }

    @Step
    private void click_yes_in_popup_delete() {
        mainPage.find(By.xpath("//a[contains(@class,'button dark')]")).click();
    }


    @Step
    public WebElement get_webelement_with_jquery(String script){

        WebElement element = (WebElement)((JavascriptExecutor) getDriver()).executeScript("return "+script);
        return element;
    }


    @Step
    public void wait_for_filters() {
        mainPage.filters.waitUntilVisible();
    }


    @Step("Берем текущий URL")
    public String get_current_url() {
        return getDriver().getCurrentUrl();
    }

    @Step
    public void check_array_elements_has_string(String text, ArrayList<String> statuses) {
        for(String elem: statuses){
            assertTrue("Проверка что в тексте купона "+elem+" сожержится подстрока "+text,elem.contains(text));
        }
    }

    @Step
    public void open_direct_offer_url(String offerId) {
        String curUrl = getDriver().getCurrentUrl();
        String curOffer = curUrl.split("web_")[1];
        String newUrl = curUrl.replace(curOffer,offerId+".5.htm").replace("advertiser_pro","webmaster_pro");
        System.out.println("newUrl: "+newUrl);
        getDriver().get(newUrl);
        basePage.waitForSpinnerDissapear();

    }

    @Step
    public void check_list_contains_list(ArrayList<String> offers, ArrayList<String> statOffers ) {
        assertTrue("Проверяем что офферы из статы есть в списке офферов рекла",offers.containsAll(statOffers));
    }

    @Step
    public void check_lists_are_equals(ArrayList<String> offersBbefore, ArrayList<String> offersAfter) {
        assertEquals("Проверяем что списки одинаковы" ,offersBbefore,offersAfter);
    }
    @Step
    public void check_lists_are_not_equals(ArrayList<String> offersBbefore, ArrayList<String> offersAfter) {
        assertFalse("Проверяем что списки одинаковы", offersBbefore.equals(offersAfter));
    }

    @Step
    public void change_lang_to_ru() {
        wait_for_all_spinners_dissapears();
        mainPage.click_select_lang();
        mainPage.click_first_lang();
        wait_for_all_spinners_dissapears();
    }

    public String get_all_text() {
        return getDriver().findElement(By.xpath("//*")).getText();
    }

    @Step
    public void scroll_to_legend() {
        scroll(getDriver().findElement(By.xpath("//div[contains(@class,'select _table_chart_select_lines')]")));
    }
    @Step("Добавляем через запрос акции")
    public void addPromoMysql(){
        MySQLWorker.addPromo();
    }

    @Step("CityAds.notifyLogoff();")
    public void execute_javascript_logoff() {
        try{
        mainPage.evaluateJavascript("CityAds.notifyLogoff();");}
        catch(Exception e){

        }
    }

    @Step("Удаляем все фильтрыы")
    public void delete_all_filters() {
        mainPage.deleteAllFilters();
    }

    @Step
    public void wait_opacity() {
        basePage.waitOpacity();
    }

    @Step
    public void check_diff(Integer goodsnumber, int goodsCount) {
        float dele = 0;
        if(goodsnumber>goodsCount) {
             dele = ((float) goodsnumber / (float) goodsCount) * 100;
        }
        if(goodsCount>goodsnumber) {
             dele = ((float) goodsCount / (float) goodsnumber) * 100;
        }
        assertTrue("Процент расхождения значения total из выгрузки "+goodsnumber+" и значения из интерфейса раздела товаров"+goodsCount+" ,больше 10 процентов(сейчас на "+dele+")",dele <10);

    }
}

    
    
    
    
