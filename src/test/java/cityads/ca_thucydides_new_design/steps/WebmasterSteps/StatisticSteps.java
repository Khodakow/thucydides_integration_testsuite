/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.steps.WebmasterSteps;

import cityads.ca_thucydides_new_design.pages.MainPage;
import cityads.ca_thucydides_new_design.pages.WemasterPages.StatisticPage;
import cityads.ca_thucydides_new_design.pages.refactor.BasePage;
import cityads.ca_thucydides_new_design.steps.SetupSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;


/**
 *
 * @author s.lugovskiy
 */
public class StatisticSteps extends SetupSteps {

    MainPage mainPage;
    StatisticPage page;
    BasePage basePage;

    public StatisticSteps(Pages pages) {
        super(pages);
    }

    @Step
    public void click_calendar(){
        WebElement dp = page.getCalendarButton();
        dp.click();

    }

    @Step
    public void calendar_set_90_days(){
        click_calendar();
        click_calendar_first_select_down_arrow_by_xpath();
        click_90_days();
        click_apply_calendar();
    }

    @Step
    public void click_stat_by_interval_tab(){
        page.statByIntervalTab.click();
    }

    @Step
    public void click_stat_conversion_by_time(){
        if(page.statConversionByTime.getAttribute("class").contains("hided")){
            page.statConversionByTime.click();
        }
    }

    @Step
    public void click_stats_conversion_bytools()
    {
        if(page.statToolsLink.getAttribute("class").contains("hided")){
            page.statToolsLink.click();
        }
    }

    @Step
    public void click_stats_bytools_overwiew_click()
    {
        page.statToolsOverviewLink.click();
    }

    @Step
    public void click_stats_conversion_bytools_bytypes()
    {
        page.statToolsByTypesLink.click();
    }


    @Step
    public void click_stats_conversion_bytools_bycategories()
    {
        page.statToolsByCategoriesLink.click();
    }

    @Step
    public void click_stats_conversion_bytools_byformat()
    {
        page.statToolsByFormatLink.click();

    }

    @Step
    public void click_stats_conversion_bytime()
    {
        if(page.statTimesLink.getAttribute("class").contains("hided")){
            page.statTimesLink.click();

        }
    }

    @Step
    public void click_stats_conversion_bytime_bydate()
    {
        page.statTimeByDatesLink.click();
    }

    @Step
    public void click_stats_conversion_bytime_byperiod()
    {
        page.statByTimeByPeriodLink.click();
    }


    @Step
    public void click_stats_segments()
    {
        page.statSegmentsLink.click();
    }


    @Step
    public void click_stats_segments_type()
    {
        page.statSegmentsTypeLink.click();
    }

    @Step
    public void click_stats_segments_busines()
    {
        page.statSegmentsVerticalsLink.click();
    }

    @Step
    public void click_stats_segments_offers()
    {
        page.statSegmentsOffersLink.click();
    }

    @Step
    public void click_stats_activity()
    {
        page.statActivityLink.click();
    }

    @Step
    public void click_stats_activity_type()
    {
        page.statActivityTypeLink.click();
    }


    @Step
    public void click_stats_activity_conversion()
    {
        page.statActivityConversionLink.click();
    }


    public void click_stats_auditory()
    {
        if(page.statAuditoryLink.getAttribute("class").contains("hided")){
            page.statAuditoryLink.click();

        }
    }



    @Step
    public void click_stats_auditory_by_countries()
    {
        if(page.statAuditoryByCountriesLink.getAttribute("class").contains("hided")){
            page.statAuditoryByCountriesLink.click();

        }
    }

    @Step
    public void click_stats_auditory_by_countries_by_lang()
    {
        page.statAuditoryByCountriesByLangLink.click();
    }


    @Step
    public void click_stats_auditory_by_countries_by_location()
    {
        page.statAuditoryByCountriesByLangLocation.click();
    }



    @Step
    public void click_stats_auditory_by_countries_by_timezones()
    {
        page.statAuditoryByCountriesByTimezones.click();
    }




    @Step
    public void click_stats_auditory_by_behavior()
    {
        if(page.statAuditoryByBehavior.getAttribute("class").contains("hided")){
            page.statAuditoryByBehavior.click();

        }
    }

    @Step
    public void click_stats_auditory_by_new_and_returned()
    {
        page.statAuditoryByBehaviorNewAndRet.click();
    }

    @Step
    public void click_stats_auditory_by_tech()
    {
        if(page.statAuditoryByTech.getAttribute("class").contains("hided")){
            page.statAuditoryByTech.click();

        }
    }

    @Step
    public void click_stats_auditory_by_tech_by_browser()
    {
        page.statAuditoryByTechByBrowser.click();
    }


    @Step
    public void click_stats_auditory_by_tech_by_oc()
    {
        page.statAuditoryByTechByOC.click();
    }


    @Step
    public void click_stats_auditory_by_tech_by_screen_resolution()
    {
        page.statAuditoryByTechByScreenResolution.click();
    }


    @Step
    public void click_stats_auditory_by_tech_by_screen_colors()
    {
        page.statAuditoryByTechByScreenColors.click();
    }


    @Step
    public void click_stats_auditory_by_tech_by_flash()
    {
        page.statAuditoryByTechByFlash.click();
    }

    @Step
    public void click_stats_auditory_by_devices()
    {
        if(page.statAuditoryByDevices.getAttribute("class").contains("hided")){
            page.statAuditoryByDevices.click();

        }
    }

    @Step
    public void click_stats_auditory_by_devices_type()
    {
        page.statAuditoryByDevicesType.click();
    }

    @Step
    public void click_stats_auditory_by_devices_model()
    {
        page.statAuditoryByTechByDevicesMod.click();
    }



    @Step
    public void click_stats_auditory_by_mobile_devices()
    {
        if(page.statAuditoryByMobileDevices.getAttribute("class").contains("hided")){
            page.statAuditoryByMobileDevices.click();

        }
    }

    @Step
    public void click_stats_auditory_by_mobile_devices_by_device()
    {
        page.statAuditoryByMobileDevicesType.click();
    }

    @Step
    public void click_stats_auditory_by_mobile_devices_device_type()
    {
        page.statAuditoryByMobileDevicesMod.click();
    }


    @Step
    public void click_90_days(){
        page.stat90DaysLnk.click();
    }

    @Step
    public void click_today(){
        page.statTodayLnk.click();
    }

    @Step
    public void click_month(){
        page.statMonth.click();
    }

    @Step
    public void click_apply_calendar() {
        page.applyCalendar.click();
    }

    @Step
    public void click_hits(){
        page.statHitsSelect.click();
    }

    @Step
    public double get_stat_numbers_sum(){
        int j = 0;
        Double statSum = 0.00;
        List<WebElement> elems = page.getAllStatNumbers();
        int size = elems.size();

        for(WebElement elem:elems){
//            System.out.println((elems.get(j).getText()));
//            System.out.println(Float.valueOf(elems.get(j).getText()));
                assertTrue(!elem.getText().isEmpty());
            j++;
        }



        return statSum;

    }
    @Step
    public void go_to_stat_by_period() {
        getDriver().get(getPages().getDefaultBaseUrl()+"/statistika/konversii/po_vremeni/po_date_426589652.0.htm");
    }

    @Step
    public void go_to_stat_by_type() {
        getDriver().get(getPages().getDefaultBaseUrl()+"/statistika/auditoriya/ustroystva/tip_418539323.0.htm");
    }
    @Step
    public String get_date(){
        return getDriver().findElement(By.id("id_el_td___event_time_1")).getText();

    }

    @Step
    public String get_type(){
        return page.find(By.id("id_el_td___device_type_id_1")).getText();
    }


    @Step
    public void check_stat_sum_not_null(double realSum){
        assertFalse(realSum == 0.0);
    }

    @Step
    public void click_search_icon(){
        getDriver().findElement(By.name("keyword")).sendKeys(Keys.RETURN);
    }


    @Step
    public void fill_search_input(String s){
        getDriver().findElement(By.name("keyword")).sendKeys(s);
    }

    @Step

    public void check_selected_option_is_displayed_on_highcharts(String option){
        assertTrue(page.getHightChartsInnerHTML().contains(option));
    }

    @Step
    public void WaitForRequest() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    @Step
    public void wait_for_calendar() {
        page.waitForCalendar();
    }

    @Step
    public void select_period() {
        page.calendar.findElement(By.className("select-choose")).click();
    }

    @Step
    public void select_date_diapason() {
        page.calendar.findElements(By.className("select-choose")).get(1).click();
    }

    @Step("Ждем загрузку графиков")
    public void wait_for_all_highcharts_displayed(int timeout) {
        WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
        wait.until(ExpectedConditions.visibilityOf(page.chart1));
        wait.until(ExpectedConditions.visibilityOf(page.chart2));
    }

    @Step
    public void click_5min() {
        page.min5.click();
    }

    @Step
    public void click_10min() {
        page.min10.click();
    }

    @Step
    public void wait_highchart_displayed(int timeout) {
        WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
        wait.until(ExpectedConditions.visibilityOf(page.chartOffice));
        //chartOffice
    }

    @Step
    public void wait_svodnaya_highchart_displayed(int timeout) {
        WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
        wait.until(ExpectedConditions.visibilityOf(page.highchartsContainer));
        //chartOffice
    }

    @Step
    public void check_highcharts_container_is_displayed(){
        assertTrue(page.highchartsContainer.isCurrentlyVisible());
    }

    @Step
    public WebElement get_innerHTML_from_minutes_hightcharts() {
        return page.getChart1();
    }

    @Step
    public String get_graph_parameters_from_highchart(WebElement elem){
        return elem.getAttribute("d");
    }

    @Step
    public void check_chart_has_changed(String chartOldParams, String chartnewParams){
        assertThat(chartnewParams, is(not(chartOldParams)));
    }

    @Step
    public void check_opacity_spinner_is_not_present() {
        assertFalse(check_if_stat_spinner_visible_with_jquery());
    }

    @Step
    public void click_by_week() {
        page.byWeek.click();
        try { Thread.sleep(2000);} catch (InterruptedException ex) {         }
    }

    @Step
    public void click_by_month() {
        page.byMonth.click();
        try { Thread.sleep(2000);} catch (InterruptedException ex) {         }
    }

    @Step
    public void click_compare_with_checkbox_in_calendar() {
        page.getCompareWithCheckbox().click();
    }

    @Step
    public void check_calendar_is_displayed() {
        assertTrue(page.getCalendar().isCurrentlyVisible());
    }

    @Step("Берем даты с оси Х на графике")
    public String get_axis_text() {
        WebElement axis = get_webelement_with_jquery("$('.highcharts-axis-labels').get(0)");
        return axis.getText();
    }

    @Step
    public void click_stat_by_words_link(){
        page.statByWordsLink.click();
    }

    @Step
    public void check_search_by_keyword(int num) {
        if(!blue_table_data_check()){

            String searchtext =  get_td_text_from_bluetable(num).replace("...","");
            fill_statistic_input_search_by_keyword(searchtext);
            enter_statistic_search_by_keyword_icon();
            wait_for_all_spinners_dissapears(60);
            check_blue_table_for_search_by_keyword(searchtext,num);

        }

    }



    @Step
    public String get_td_text_from_bluetable(int num) {
        String text = this.getDriver().findElement(By.xpath("(//table[contains(@class,'blue_table')]/tbody/tr/td["+num+"]/nobr[not(contains(text(),'Неизвестно')) and not(contains(text(),'Unknown')) and not(contains(text(),'Desconhecido')) ])[1]")).getText();
        return text;

    }

    @Step
    public void fill_statistic_input_search_by_keyword(String text) {

        page.statisticSearchByKeyword.sendKeys(text);

    }



    @Step
    public void enter_statistic_search_by_keyword_icon(){

        page.statisticSearchByKeyword.sendKeys(Keys.RETURN);
    }


    @Step
    public void check_blue_table_for_search_by_keyword(String keyword,int num){
        //table[contains(@class,'blue_table')]/tbody/tr/td[2]
        List<WebElement> allDataFromBlueTable = this.getDriver().findElements(By.xpath("//table[contains(@class,'blue_table')]/tbody/tr/td["+num+"]"));
        assertTrue("No data",allDataFromBlueTable.size()>0);
        for(WebElement elem : allDataFromBlueTable){
            String td = elem.getText();
            check_string_contains_text(td, keyword);

        }
    }

    @Step
    public void click_first_list_additional_parametr_to_blue_table(){
        basePage.waitForSpinnerDissapear();
        page.stat_first_additional_parametr.waitUntilVisible();
        page.stat_first_additional_parametr.click();
        basePage.waitForSpinnerDissapear();
    }

    @Step
    public void click_add_dynamic(){
        basePage.waitForSpinnerDissapear();
        page.statAddDymanic.waitUntilVisible();
        page.statAddDymanic.click();
        basePage.waitForSpinnerDissapear();
    }


    @StepGroup
    public void add_additional_parameter(String text){
        click_first_list_additional_parametr_to_blue_table();
        fill_first_list_additional_par_search_input(text);
        click_first_list_additional_par_first_visible_item(text);
    }

    @StepGroup
    public void add_dynamic_parameter(String text){
        click_add_dynamic();
        fill_first_list_additional_par_search_input(text);
        click_first_list_additional_par_first_visible_item(text);
        wait_dinamic_percentage();
    }

    @Step
    private void wait_dinamic_percentage() {
        page.dynamicPercentage.waitUntilNotVisible();
    }

    @Step
    public void check_dinamic_spinner_not_visible(){
        for(WebElement spinner : page.dynamicGif){
            assertFalse("После добавления динамики и доп параметра висит вечная крутилка в динамике",spinner.getAttribute("innerHTML").contains("img"));
        }
    }

    @Step
    public void click_generate_auth_key(){
        page.generateAuthkey.click();
    }

    @Step
    public String get_auth_key(){
        return page.authKey.getText();
    }

    @Step
    public void fill_first_list_additional_par_search_input(String text){
        page.stat_first_additional_parametr_input_search.waitUntilVisible();
        page.stat_first_additional_parametr_input_search.sendKeys(text);
    }

    @Step
    public void click_first_list_additional_par_second_visible_item(String text){
        basePage.waitForSpinnerDissapear();
        page.getPopup().findElement(By.xpath("(//div/div[contains(@class,'ib') and (text()='"+text+"')])[2]")).click();
        basePage.waitForSpinnerDissapear();
    }

    @Step
    public void click_first_list_additional_par_first_visible_item(String text){
        basePage.waitForSpinnerDissapear();
        page.getPopup().findElement(By.xpath("(//div/div[contains(@class,'ib') and (text()='"+text+"')])[1]")).click();
        basePage.waitForSpinnerDissapear();
    }

    //СКОРЕЕ ВСЕГО МЕТОД Сверху СЛОМАЕТСЯ, когда починят отчет, поэтому напишу похожий ниже на другой параметр


    @Step
    public void click_first_list_additional_par_fitst_visible_item_(String text){
        page.getPopup().findElement(By.xpath("(//div/div[contains(@class,'ib') and (text()='"+text+"')])[1]")).click();
    }

    @Step
    public String  get_text_from_first_element_in_blue_table_additional_parametr(){
        String Text = page.stat_first_element_in_blue_table__add_parametr.getText();
        return Text;

    }

    @Step
    public String  get_text_from_first_element_in_blue_table_main_parametr(){
        executeScript("$('tr:contains(\"Неизвестн\")').remove();");
        executeScript("$('tr:contains(\"Unknow\")').remove();");
        String Text = page.stat_first_element_in_blue_table__main_parametr.getText();
        return Text;

    }


    @Step
    public void check_all_additional_parametr_in_blue_table(String text){
        List<WebElement> list = page.blueTableAdditionalParamList;
        for(WebElement elem:list){
            String elemtext = elem.getText();
            check_values_are_equals(text,elemtext);
        }
    }


    @Step
    public void check_all_additional_parametr_in_blue_table_not_equals(String text){
        List<WebElement> list = page.blueTableAdditionalParamList;
        for(WebElement elem:list){
            String elemtext = elem.getText();
            check_string_has_changed(text,elemtext);
        }
    }

    @Step
    public void click_first_checkbox_in_blue_table(){
        page.first_checkbox_in_blue_table.waitUntilVisible();
        page.first_checkbox_in_blue_table.click();
    }


    @Step
    public void click_show_on_chart_icon(){
        page.show_on_chart_icon.waitUntilVisible();
        page.show_on_chart_icon.click();
        waitABit(5000);
    }
    @Step
    public void click_any_link_main_param_in_blue_table(int num) {


            page.firstlinkmainparam.waitUntilVisible();
            page.find(By.xpath("(//table[contains(@class,'blue_table')]/tbody/tr/td/nobr/a)[" + num + "]")).click();
            waitABit(5000);

    }


    @Step
    public void click_any_link_in_legend(int num) {
        page.secondLinkInLegend.waitUntilVisible();
        page.find(By.xpath("(//table[contains(@class,'no-zebra')]/tbody/tr/td/a[contains(@class,'col-blue')])["+num+"]")).click();
        waitABit(5000);
    }

    @Step
    public void check_legend_in_breadcrumbs(){

        String old_h1 = get_h1_in_page();

        click_any_link_in_legend(2);
        wait_for_all_spinners_dissapears(120);

        String new_h1 = get_h1_in_page();
        check_string_has_changed(old_h1,new_h1);
        click_any_link_in_legend(1);
        wait_for_all_spinners_dissapears(120);
        String new_h1_2 = get_h1_in_page();
        check_string_has_changed(new_h1,new_h1_2);

    }

    @Step
    public void check_breadcrums_by_click_in_link_blue_table(){
        if(!blue_table_data_check()) {
            String old_h1 = get_h1_in_page();

            click_any_link_main_param_in_blue_table(1);

            wait_for_all_spinners_dissapears(120);
            String new_h1 = get_h1_in_page();

            check_string_has_changed(old_h1, new_h1);
            click_any_link_in_legend(1);
            wait_for_all_spinners_dissapears(120);
            String new_h1_2 = get_h1_in_page();
            check_string_has_changed(new_h1,new_h1_2);
        }
    }


}
