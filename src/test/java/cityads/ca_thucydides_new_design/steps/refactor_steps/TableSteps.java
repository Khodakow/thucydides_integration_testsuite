/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.steps.refactor_steps;

import cityads.ca_thucydides_new_design.pages.refactor.*;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.WebElement;

import java.util.*;

import static org.junit.Assert.*;

/**
 *
 * @author s.lugovskiy
 */
public class TableSteps extends ScenarioSteps {

    private Table table;
    private StatTable statTable;
    private Pager pager;
    private Chart chart;
    private Filter filter;

    public TableSteps(Pages pages) {
        super(pages);
    }


    @Step("Клик по первому доступному офферу в таблице")
    public void click_first_aviable_offer(){
        table.clickFirstAvaibleOffer();
    }

    @Step("Получаем имя первого доступного оффера в таблице")
    public String get_first_aviable_offer_name(){
        return table.getFirstAvaibleOffer();
    }


    @Step("Клик по первому доступному офферу в таблице")
    public void click_first_aviable_offer_adv(){
        table.clickFirstAvaibleOfferAdv();
    }

    @Step
    public void check_table_has_text(String text){
        table.waitTable();
        assertTrue(table.getAllText().contains(text));
    }

    @Step("Проверяем что таблица не отображается")
    public void check_table_is_not_present(){
        assertFalse("Проверяем что таблица с офферами невидима",table.isTableVisible());
    }

    @Step
    public void open_popup_with_code(String text){
        table.clickGetCodeInTrWithText(text);
    }

    @Step("Устанавливаем число записей в таблице - обычно 100")
    public void setup_number_of_records(int number){// 10 20 50 100
        pager.setupTableWithNumberRecord(number);
    }

    @Step
    public void go_to_page(int number){
        pager.goToPage(number);
    }

    @Step("Проверяем что в таблице есть данные")
    public void check_table_has_data(){
        table.checkTableHasData();
    }

    @Step
    public ArrayList<Float> get_column_data(int column){  //номер столбца считая с 1
        ArrayList<Float> data = table.getColumnSortedData(column);
        return data;
    }

    @Step
    public ArrayList<Float> get_column_data_nobr(int column){  //номер столбца считая с 1
        ArrayList<Float> data = table.getColumnSortedDataNobrInstrumentsTab(column);
        return data;
    }

    @Step
    public ArrayList<String> get_column_data_string(int column){  //номер столбца считая с 1
        ArrayList<String> data = table.getColumnSortedDataString(column);
        return data;
    }

    @Step
    public ArrayList<Float> get_column_data_without_clicking(int column){  //номер столбца считая с 1
        ArrayList<Float> data = table.getColumnSortedDataWithoutClicking(column);
        return data;
    }

    @StepGroup
    public void check_column_sort_ascend(int column, String name){
        ArrayList<Float> data = get_column_data(column);
        check_array(data);
    }

    @StepGroup
    public void check_column_sort_ascend_nobr(int column, String name){
        ArrayList<Float> data = get_column_data_nobr(column);
        check_array(data);
    }



    @StepGroup
    public void check_column_sort_ascend_string(int column, String name){
        ArrayList<String> data = get_column_data_string(column);
        check_array_string(data);
    }



    @StepGroup
    public void check_column_sort_ascend_without_clicking(int column, String name){
        ArrayList<Float> data = get_column_data_without_clicking(column);
        check_array(data);
    }

    @Step
    public ArrayList<Float> get_stat_column_data(int column){  //номер столбца считая с 1
        ArrayList<Float> data = statTable.getColumnSortedData(column);
        return data;
    }

    @StepGroup
    public void check_stat_column_sort_ascend(int column, String name){
        if(column<11) {
            ArrayList<Float> data = get_stat_column_data(column);
            check_array(data);
        }

    }

    @Step
    public void check_array(ArrayList<Float> data){
        int j;
        boolean sorted = true;
        for(j=0; j<data.size()-1;j++){
            if(data.get(j)>data.get(j+1)){
                sorted = false;
                break;
            }
        }
        assertTrue("Массив не отсортирован по возрастанию: "+data,sorted);
    }

    @Step
    public void check_array_string(ArrayList<String> data){

        ArrayList<String> dataCopy = new ArrayList<String>(data);
        Collections.sort(data);

        for(int j =0;j<dataCopy.size();j++){
            assertTrue("Проверяем что сортировка в интерфейса совпадает с сортировкой джавы.  Сортировка коллекций джавы: -->"
                            +data
                            +"______________________________________________________________" +
                            "_______________________________________________________________" +
                            "_______________________________________________________________Сортировка сити: -->"
                            +dataCopy,
                    dataCopy.get(j).equals(data.get(j)));
        }


    }

    @Step
    public int get_strings_number(){
        int stringNumber = table.getStringNumber();
        return stringNumber;
    }

    @Step
    public void sort_by_main_parameter() {
        table.sortByMain();
    }

    @Step
    public void add_dynamic_parameter(String text){
        if(table.tableHasData()) {
            table.addDynamicParameter(text);
            table.checkDynamicThVisible();
        }
    }

    @Step
    public void add_dynamic_parameter_tools(String text){
        if(table.tableHasData()) {
            table.addDynamicParameterTools(text);
            table.checkDynamicThVisible();
        }
    }




    @Step
    public void check_all_h1_by_click_in_links_blue_table(){
        table.checkAllH1ByClicksInBlueTable();
    }

    @Step
    public void show_additional_parametr_by_name(String name){
        table.show_additional_parametr_by_name(name);
    }

    @Step
    public void check_all_data_in_main_parametr(String name){
        table.check_all_elem_in_main_param_blue_table(name);
    }

    @Step
    public void check_all_data_in_offers_main_parametr(String name){
        table.check_all_elem_in_offers_param_blue_table(name);
    }

    @Step
    public void check_all_date_in_main_parametr_num_exclude(){
        table.check_all_elem_in_main_param_not_include_num_blue_table();
    }
    @Step("Отмечаем первый офис и  проверяем что в легенде есть CityAds")
    public void tag_first_office_and_check_legend_in_graf(){
        table.showOnGrafFirstElementInTableTagedByCityads();
    }
    @Step("Отмечаем первый офис и  проверяем что в легенде есть CityAds =по интервалам=")
    public void tag_first_office_and_check_legend_in_interval_graf(){
        table.show_on_Interval_graf_first_element_in_table_taged_by_Cityads();
    }

    @Step("Отмечаем первого ВМа и проверяем легенду")
    public void tag_first_webmaster_and_check_legend_in_graf(){
        table.show_on_graf_first_element_in_table_taged_by_not_unknow();
    }

    @Step("Отмечаем первого ВМа и проверяем легенду (по интервалам)")
    public void tag_first_webmaster_and_check_legend_in_interval_graf(){
        table.show_on_Interval_graf_first_element_in_table_taged_by_unknows();
    }

    @Step("Заходим запервого рекла через суда")
    public void click_sudo_advertiser_in_table(){table.click_sudo_in_table();}

    @Step("Перетаскиваем таблицу вправо")
    public void drag_blue_table(){table.dragBlueTableByX(10000);}

    @Step
    public void check_blue_table_td_and_th_equals(){
        table.waitSpinner();
        int thcount = table.getThcount();
        int tdcount =table.getTdcount();
        if(tdcount>0){
            assertEquals("Не совпадает кол-во столбцов в таблице",tdcount,thcount);
        }
    }

    @Step("Проверяем доп параметр Офферы на уникальность ")
    public void check_additional_parameter_offers_column_for_unique_values(){
        List<String> cols = table.getAddParameterColumn();
        Set<String> set = new HashSet<String>();
        for(String col: cols){
            boolean added = set.add(col);
            assertTrue("Проверка на уникальность значение в столбце офферы --->"+col,added);
        }
    }

    @Step
    public void check_column_for_unique_values(List<String> cols){

        Set<String> set = new HashSet<String>();
        for(String col: cols){
            boolean added = set.add(col);
            assertTrue("Проверка на уникальность значение в столбце --->"+col,added);
        }
    }

    @Step
    public void check_column_for_numbers(List<String> cols){
        for(String col: cols){
            String regexp = "\\d+";
            assertFalse("number in table! " + col, col.matches(regexp));

        }
    }

    @Step
    public void click_checkbox_left_column(int i) {
        table.clickLeftCheckbox(i);
        table.clickShowOnChartIcon();
    }

    @Step("Получаем значения из столбца Основной параметр - Офферы")
    public ArrayList<String> get_offers_mainparam() {
        return table.getOffersMainParamArray();

    }

    @Step("Получаем значения из столбца Основной параметр - Вертикали")
    public ArrayList<String> get_vertikals_mainparam() {
        return table.getVertikalsMainParamArray();

    }

    @Step("Получаем значения из столбца Основной параметр - Размер Промо")
    public ArrayList<String> get_promosize_mainparam() {
        return table.getPromosizeMainParamArray();

    }

    @Step("Получаем значения из столбца Основной параметр - Товары")
    public ArrayList<String> get_goods_mainparam() {
        return table.getGoodsMainParamArray();

    }

    @StepGroup("Проверяем что сходятся open leads в таблице и на сводной")
    public void check_open_leads_chart_table(){
        ArrayList<Integer> sum = new ArrayList<Integer>();
        sum = get_open_leads_table();
        System.out.println("Open leads in table: \n"+sum);
        int leads = get_open_leads_chart();
        System.out.println("Open leads in chart "+leads);
        check_chart_equals_table(leads,sum);
    }

    @Step("Получаем open leads из таблицы")
    public ArrayList<Integer> get_open_leads_table(){
        ArrayList<Integer> openleads = table.getOpenleads();
        ArrayList<Integer> openleadsPaid = table.getOpenleadsPaid();
        ArrayList<Integer> openleadsRejected = table.getOpenleadsRejected();
        ArrayList<Integer> sum = new ArrayList<Integer>();
        sum.addAll(openleads);
        sum.addAll(openleadsPaid);
        sum.addAll(openleadsRejected);
        return sum;
    }

    @Step("Получаем open leads из сводной")
    public Integer get_open_leads_chart(){
        int leads = chart.getLeads();
        return leads;
    }

    @StepGroup
    public void check_chart_equals_table(int chart, ArrayList<Integer> table) {
        int sum = sum_array(table);
        check_number_is_in_interval_5_percent(chart,sum);

    }

    @Step
    public void check_numbers_are_equals(int one, int two){
        assertEquals("Проверка что сумма соответствующих элементов в таблице равна числу на сводной.",one,two);
    }

    @Step
    public void check_number_is_in_interval_5_percent(int one, int two){
        boolean ckeck = one <= two*1.10 && one >= two*0.90;
        assertTrue("Проверка что значения различаются не более чем на 5%. "+one+" "+two, ckeck);
    }


    @Step
    public Integer sum_array(ArrayList<Integer> list) {
        Integer sum= 0;
        for (Integer i:list)
            sum = sum + i;
        return sum;
    }

    @Step
    public ArrayList<String> get_offers_column_advertiser() {
        ArrayList<String> list = new ArrayList<String>();
        for(WebElement offer : table.getOffersNamesAdvertizer()){
            list.add(offer.getText());
        }
        return list;

    }

    @Step
    public void filter_by_keyword(String s) {
        filter.searchByKeyword(s);
    }

    @Step("Сортируем таблицу по столбцу Динамика")
    public void sort_by_dynamic() {
        statTable.sortByDynamic();
    }

    @Step
    public void click_first_subaccount() {
        statTable.clickFirstSubaccount();
    }

    @Step
    public void add_parameter(String text) {
        statTable.addAddparameter(text);
    }

    @Step
    public void check_add_parameter_not_present(String s) {
        statTable.checkAddParamsListNotContains(s);
    }

    @Step
    public void check_table_has_lines(int i) {
        assertTrue("Проверяем что число строк в таблице = 1. Строк было: "+table.getLineNumber(),table.getLineNumber() == 1);
    }

    @Step
    public String get_code_in_feed_with_name(String feedName) {
        return table.getFeedCodeWithtext(feedName);
    }

    @Step
    public void click_edit_wallet_with_name(String name){
        table.clickPaymentEditWithtext(name);
    }


    @Step("Получаем имя первого рекла из таблицы (основнйо параметр)")
    public String get_first_adv_mainparam() {
        return table.getFirstAdv();
    }

    @Step("Проверяем что таблица присутствует")
    public void check_table_is_visible() {
        assertTrue(table.isTableVisible());
    }
}

