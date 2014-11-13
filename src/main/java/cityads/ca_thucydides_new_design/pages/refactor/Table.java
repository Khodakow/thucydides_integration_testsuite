package cityads.ca_thucydides_new_design.pages.refactor;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.findby.By;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class Table extends BasePage {


    public Table(WebDriver driver) {
        super(driver);
    }

    public Popup popup;



    @FindBy(xpath="//table[contains(@class,'blue_table')]")
    private WebElementFacade table;

    @FindBy(xpath="//h2[contains(@class,'_overview_text')]")
    private WebElementFacade overview;

    @FindBy(xpath="//table[contains(@class,'blue_table')]/tbody")
    private WebElementFacade tableBody;

    @FindBy(xpath="//table/tbody/tr/td/div/span[@class='icon-favorites']")
    private List<WebElement> favIcons;

    @FindBy(xpath="(//table/tbody/tr[descendant::span[@class='icon-favorites']])[1]")
    private WebElementFacade firstLineWithAvaibleOffer;

    @FindBy(xpath="//table/tbody/tr[descendant::span[@class='icon-favorites']]/td[4]/a")
    private WebElementFacade firstAvaibleOffer;

    @FindBy(xpath="(//table/tbody/tr/td[3]/a)[1]")
    private WebElementFacade firstAvaibleOfferAdv;

    @FindBy(xpath = "//table[contains(@class,'blue_table')]/tbody/tr")
    private List<WebElementFacade> strings;

    @FindBy(xpath="//table[contains(@class,'blue_table')]/thead/tr[2]/th[2]")
    private WebElementFacade mainParamTh;

    @FindBy(xpath="//div[@class='absolute back-ccc pointer' and contains(@style,'width: 25%')]")
    private WebElementFacade scroolInTable;

    @FindBy(xpath="(//div[@class='_button_place']/div[contains(@class,'_dd_button')])[2]")
    private WebElementFacade addDynamic;

    @FindBy(xpath="(//div[@class='_button_place']/div[contains(@class,'_dd_button')])[1]")
    private WebElementFacade addDynamicTools;

    @FindBy(xpath = "//th[@col_name='_dynamics']")
    private WebElementFacade dynamicTh;

    @FindBy(tagName="h1")
    private WebElementFacade h1;

    @FindBy(xpath="(//table[contains(@class,'blue_table')]/tbody/tr/td/nobr/a)[1]")
    private WebElementFacade firstlinkmainparam;

    @FindBy(xpath="(//div[contains(@class,'input-button optional')])[1]")
    private WebElementFacade statFirstAdditionalParametr;

    @FindBy(xpath="//div[contains(@class,'search-input-icon')]/input")
    private WebElementFacade statFirstAdditionalParametrInputSearch;

    @FindBy(xpath="//table[contains(@class,'blue_table')]/tbody/tr/td[2][descendant::nobr[not(contains(text(),'еизвестн')) and not(contains(text(),'known')) and not(contains(text(),'esconhecido'))]]")
    private List<WebElement> allElemInMainParametr;

    @FindBy(xpath="//table[contains(@class,'blue_table')]/tbody/tr/td[1]/label[descendant::input[contains(@value,'CityAds') or contains(@value,'Москва') or contains(@value,'Moscow') ]]")
    private WebElementFacade allCheckboxesFindedByCityadsInBluetable;

    @FindBy(xpath="//table[contains(@class,'blue_table')]/tbody/tr/td[1]/label[descendant::input[not(@value='0')]]")
    private WebElementFacade allCheckboxesFindedNotUnknownInBlueTable;

    @FindBy(xpath="//a[contains(@class,'button submit ') and contains(@class,'to-graph')]")
    private WebElementFacade showOnChartIcon;

    @FindBy(xpath="//td[descendant::nobr[2] and not(contains(node()[2],'Неизвестно')) and not(contains(node()[2],'Unknown')) ]/nobr/a")
    private WebElementFacade sudoInTable;

    @FindBy(xpath="//*[contains(text(),'нет прав для просмотра')]")
    private WebElementFacade noRightsText;

    @FindBy(xpath = "//th/div/a[contains(text(),'Оффер')]")
    private WebElementFacade offerTh;

    @FindBy(xpath = "//table[contains(@class,'blue_table')]/tbody/tr/td[position()=4]/nobr")
    private List<WebElement> addParameterColumn;

    @FindBy(xpath = "//td[contains(@class,'action_name')]")
    private List<WebElement> offersMainParams;

    @FindBy(xpath = "//td[contains(@class,'category_lvl_1')]")
    private List<WebElement> vertikalsMainParam;

    @FindBy(xpath = "//td[contains(@class,'promo_size')]")
    private List<WebElement> promosizeMainParam;

    @FindBy(xpath = "//td[contains(@class,'link_id')]")
    private List<WebElement> goodsMainParam;

    //data in table for chart
    @FindBy(xpath="//td[contains(@class,'openleads_open')]")
    private List<WebElement> openleads;

    @FindBy(xpath="//td[contains(@class,'openleads_rejected')]")
    private List<WebElement> openleadsRejected;

    @FindBy(xpath="//td[contains(@class,'openleads_paid')]")
    private List<WebElement> openleadsPaid;

    @FindBy(xpath="//table[contains(@class,'blue_table')]/tbody/tr/td[contains(@id,'name')]/a")
    private List<WebElement> offersAdv;

    @FindBy(xpath = "//div[contains(@class,'dynamics')]/img[@src='/images/start/spinner.gif']")
    private WebElementFacade dynamicSpinner;

    public ArrayList<Integer> getOpenleads() {
        ArrayList<Integer> leads = new ArrayList<Integer>();
        for(WebElement lead : openleads){
            leads.add(Integer.valueOf(lead.getText().replace("’","").replace(".","").replace(",","")));
        }
        return leads;
    }

    public ArrayList<Integer> getOpenleadsRejected() {
        ArrayList<Integer> leads = new ArrayList<Integer>();
        for(WebElement lead : openleadsRejected){
            System.out.println(lead.getText());
            leads.add(Integer.valueOf(lead.getText().replace("’","").replace(".","").replace(",","")));
        }
        return leads;
    }

    public ArrayList<Integer> getOpenleadsPaid() {
        ArrayList<Integer> leads = new ArrayList<Integer>();
        for(WebElement lead : openleadsPaid){
            leads.add(Integer.valueOf(lead.getText().replace("’","").replace(".","").replace(",","")));
        }
        return leads;
    }

    public void dragBlueTableByX(int pixels){
        withAction().moveToElement(scroolInTable).clickAndHold().moveByOffset(pixels,0).click().perform();

    }

    private WebElementFacade getTh(int column){
        return this.findAll(By.xpath("//table[contains(@class,'blue_table')]/thead/tr[position()=1]/th")).get(column-1);
    }

    public ArrayList<Float> getColumnSortedData(int column){
        int count = 0;
        if(getTh(column).isCurrentlyVisible()){
            while(!getTh(column).getAttribute("innerHTML").contains("th-down sorted")){
                clickTh(column);
                count++;
                if(count>3){
                    break;
                }
            }
        }

        waitForSpinnerDissapear();
        List<WebElement> values = getDriver().findElements(By.xpath("//table[contains(@class,'blue_table')]/tbody/tr/td[position()="+column+"]"));

        ArrayList<Float> tds = new ArrayList<Float>();
        for(WebElement value: values){
            String text = value.getAttribute("innerHTML");
            if(!text.contains("%") && !text.contains("-")){
                tds.add(Float.valueOf(text.trim().replaceAll("[^\\d.]", "")));
            }
        }
        return tds;
    }

    public ArrayList<Float> getColumnSortedDataNobrInstrumentsTab(int column){
        int count = 0;
        if(getTh(column).isCurrentlyVisible()){
            while(!getTh(column).getAttribute("innerHTML").contains("th-down sorted")){
                clickTh(column);
                count++;
                if(count>3){
                    break;
                }
            }
        }

        waitForSpinnerDissapear();
        List<WebElement> values = getDriver().findElements(By.xpath("//table[contains(@class,'blue_table')]/tbody/tr/td[position()="+column+"]/nobr"));

        ArrayList<Float> tds = new ArrayList<Float>();
        for(WebElement value: values){
            String text = value.getAttribute("innerHTML");
                   tds.add(Float.valueOf(text.trim().replace("%","").replaceAll("[^\\d.]", "")));
            }
        return tds;
    }

    public ArrayList<String>  getColumnSortedDataString(int column){
        int count = 0;
        if(getTh(column).isCurrentlyVisible()){
            while(!getTh(column).getAttribute("innerHTML").contains("th-down sorted")){
                clickTh(column);
                count++;
                if(count>3){
                    break;
                }
            }
        }

        waitForSpinnerDissapear();
        List<WebElement> values = getDriver().findElements(By.xpath("//table[contains(@class,'blue_table')]/tbody/tr/td[position()="+column+"]"));

        ArrayList<String> tds = new ArrayList<String>();

        //Добавление всех имен офферов в коллекцию


        for(WebElement value: values){
            String text = value.getText();
            boolean check = textHasCyrillic(text); //добавлять только если имя оффера не начинается с кириллицы
            if(!check) {
                tds.add((text.toLowerCase()));      //делаем проверку сортировки регистронезависимой
            }
        }
        return tds;
    }

    private void clickTh(int column){
        //Actions builder = new Actions(getDriver());
        //getTh(column).click();
        evaluateJavascript("$('table[class*=\"blue_table\"]>thead>tr>th:eq("+String.valueOf(column-1)+")').click()");
        waitForSpinnerDissapear();
        waitOpacity();
        //Action move = builder.moveToElement(this.find(By.xpath("//div[contains(@class,'absolute back-ccc pointer') and contains(@style,'width: 25%')]"))).build();
        //move.perform();
        waitForSpinnerDissapear();
        evaluateJavascript("$('html, body').animate({ scrollTop: $('.blue_table').offset().top }, 0);");
    }

    public ArrayList<Float> getColumnSortedDataWithoutClicking(int column){
        waitForSpinnerDissapear();
        List<WebElement> values = getDriver().findElements(By.xpath("//table[contains(@class,'blue_table')]/tbody/tr/td[position()="+column+"]"));

        ArrayList<Float> tds = new ArrayList<Float>();
        for(WebElement value: values){
            String text = value.getAttribute("innerHTML");
            if(!text.contains("%") && !text.contains("-")){
            tds.add(Float.valueOf(text.trim().replaceAll("[^\\d.]", "")));
            }
        }
        return tds;
    }

    private WebElementFacade getTrWithText(String text){
        table.waitUntilVisible();
        return this.find(By.xpath("//table/tbody/tr[descendant::td[contains(text(),'"+text+"')]]"));
    }

    private void clickGetcodeIconInTrWithText(String text){
        getTrWithText(text).find(By.className("acts")).thenFindAll(By.tagName("a")).get(1).click();
    }

    public void clickGetCodeInTrWithText(String text){
        waitForSpinnerDissapear();
        clickGetcodeIconInTrWithText(text);
        popup.waitPopup();

    }

    public void waitTable(){
        table.waitUntilVisible();
    }

    public void waitOverview(){
        overview.waitUntilVisible();
    }

    public void clickFirstAvaibleOffer(){
        waitForSpinnerDissapear();
        firstAvaibleOffer.waitUntilVisible();
        firstAvaibleOffer.click();
        waitForSpinnerDissapear();
    }

    public String getFirstAvaibleOffer(){
        waitForSpinnerDissapear();
        return firstAvaibleOffer.getText();

    }

    public String getAllText(){
        table.waitUntilVisible();
        return tableBody.getText();
    }

    public int getStringNumber() {
        waitForSpinnerDissapear();
        return strings.size();
    }

    public void sortByMain() {
        waitForSpinnerDissapear();
        mainParamTh.waitUntilVisible();
        mainParamTh.click();
        waitForSpinnerDissapear();
    }

    public void addDynamicParameter(String text) {
        waitSpinner();
        addDynamic.waitUntilVisible();
        addDynamic.click();
        popup.fillPopupInputSearchParameter(text);
        dynamicSpinner.waitUntilNotVisible();
        waitSpinner();        //dynamicTh.waitUntilVisible();

    }

    public void addDynamicParameterTools(String text) {
        waitForSpinnerDissapear();
        addDynamicTools.waitUntilVisible();
        addDynamicTools.click();
        waitForSpinnerDissapear();
        popup.fillPopupInputSearchParameter(text);
        dynamicSpinner.waitUntilNotVisible();
        waitForSpinnerDissapear();        //dynamicTh.waitUntilVisible();

    }

    public boolean tableHasData(){
        waitTable();
        int size = getDriver().findElements(By.xpath("//table[contains(@class,'blue_table')]/tbody/tr/td")).size();
        if(size>1){
            return true;
        }
        else{
            return false;
        }
    }

    public void checkDynamicThVisible(){
        dynamicTh.waitUntilVisible();
    }


    public WebElementFacade getBlueTable(){
        return element(table);
    }

    public boolean blueTableNoDataCheck(){
        return ((this.getBlueTable().findElement(By.tagName("tbody")).getText().contains("Нет данных"))
                ||(this.getBlueTable().findElement(By.tagName("tbody")).getText().contains("Элементы не найдены")));
    }

    public String getH1Title() {
        h1.waitUntilVisible();
        return h1.getText();
    }



    public void clickAnyLinkMainParamInBlueTable(int num) {
        this.firstlinkmainparam.waitUntilVisible();
        this.find(By.xpath("(//table[contains(@class,'blue_table')]/tbody/tr/td/nobr/a)[" + num + "]")).click();
        waitABit(5000);

    }

    public void checkStringHasChanged(String oldString, String newString) {
        assertThat(newString, is(not(oldString)));

    }

    @Step
    public void checkValuesAreEquals(String expected, String actual){
        Assert.assertEquals(expected, actual);
    }

    @Step
    public void checkValuesAreEquals(int expected, int actual){
        Assert.assertEquals(expected, actual);
    }
    @Step
    public void checkStringContainsText(String str, String text){
        Assert.assertTrue("Проверяем что строка "+str  +" содержит подстроку " +text,str.contains(text));
    }

    public void checkAllH1ByClicksInBlueTable() {
        if (!blueTableNoDataCheck()) {

            String old_h1 = getH1Title();
            clickAnyLinkMainParamInBlueTable(1);
            waitForSpinnerDissapear();
            String new_h1 = getH1Title();
            checkStringHasChanged(old_h1, new_h1);
        }

        String old_h1_1 = getH1Title();
        clickAnyLinkMainParamInBlueTable(1);
        waitForSpinnerDissapear();
        String new_h1_1 = getH1Title();
        checkStringHasChanged(old_h1_1, new_h1_1);

        String old_h1_2 = getH1Title();
        clickAnyLinkMainParamInBlueTable(1);
        waitForSpinnerDissapear();
        String new_h1_2 = getH1Title();
        checkStringHasChanged(old_h1_2, new_h1_2);

        String old_h1_3 = getH1Title();
        clickAnyLinkMainParamInBlueTable(1);
        waitForSpinnerDissapear();
        String new_h1_3 = getH1Title();
        checkStringHasChanged(old_h1_3, new_h1_3);

    }

    private void click_first_list_additional_parametr_in_blue_table(){
        this.statFirstAdditionalParametr.waitUntilVisible();
        this.statFirstAdditionalParametr.click();
    }

    private void fill_first_list_additional_par_search_input(String text){
        this.statFirstAdditionalParametrInputSearch.waitUntilVisible();
        this.statFirstAdditionalParametrInputSearch.sendKeys(text);
    }

    private void click_first_item_in_additional_param_popup_list(String text){
        this.getDriver().findElement(By.xpath("(//div/div[contains(@class,'ib') and (text()='"+text+"')])[2]")).click();
    }


    public void show_additional_parametr_by_name(String name){

        click_first_list_additional_parametr_in_blue_table();
        fill_first_list_additional_par_search_input(name);
        click_first_item_in_additional_param_popup_list(name);
        waitForSpinnerDissapear();



    }

    public void check_all_elem_in_main_param_blue_table(String name){
        waitSpinner();
        List<WebElement> list = this.allElemInMainParametr;
        for(WebElement elem:list){
            String elemtext = elem.getText();
            checkStringContainsText(elemtext, name);
        }
    }

    public void check_all_elem_in_main_param_not_include_num_blue_table(){
        waitABit(2000);
        waitSpinner();
        List<WebElement> list = this.allElemInMainParametr;
        for(WebElement elem:list){
            String elemtext = elem.getText();
            String regexp = "\\d+";
            assertFalse("number in table! " + elemtext, elemtext.matches(regexp));
        }
    }


    public void clickShowOnChartIcon(){
        this.showOnChartIcon.waitUntilVisible();
        this.showOnChartIcon.click();
        waitABit(2500);
        waitSpinner();
    }

    public void showOnGrafFirstElementInTableTagedByCityads(){
        allCheckboxesFindedByCityadsInBluetable.click();
        clickShowOnChartIcon();
        waitABit(2500);
        waitSpinner();
        String legend = get_webelement_with_jquery("$('g.highcharts-legend')[0]").getText();
        checkStringContainsText(legend, "CityAds");

    }

    public void show_on_Interval_graf_first_element_in_table_taged_by_Cityads(){
        allCheckboxesFindedByCityadsInBluetable.waitUntilVisible();
        allCheckboxesFindedByCityadsInBluetable.click();
        clickShowOnChartIcon();
        waitABit(2500);
        waitSpinner();
        String legend = get_webelement_with_jquery("$('g.highcharts-legend')[1]").getText();
        checkStringContainsText(legend, "CityAds");

    }

    public void show_on_graf_first_element_in_table_taged_by_not_unknow(){
        allCheckboxesFindedNotUnknownInBlueTable.waitUntilVisible();
        allCheckboxesFindedNotUnknownInBlueTable.click();
        clickShowOnChartIcon();
        waitABit(2500);
        waitSpinner();
        String legend = get_webelement_with_jquery("$('g.highcharts-legend')[0]").getText();
        if (getDriver().getCurrentUrl().contains("cityads")){
            checkStringContainsText(legend, "W");
        }
        else {
            checkStringContainsText(legend, "@");
        }

    }

    public void show_on_Interval_graf_first_element_in_table_taged_by_unknows(){
        allCheckboxesFindedNotUnknownInBlueTable.waitUntilVisible();
        allCheckboxesFindedNotUnknownInBlueTable.click();
        clickShowOnChartIcon();
        waitABit(2500);
        waitSpinner();
        String legend = get_webelement_with_jquery("$('g.highcharts-legend')[1]").getText();
        if (getDriver().getCurrentUrl().contains("cityads")){
            checkStringContainsText(legend, "W");
        }
        else {
            checkStringContainsText(legend, "@");
        }

    }



    public void click_sudo_in_table(){
        sudoInTable.waitUntilVisible();
        sudoInTable.click();
        waitABit(2500);
        waitSpinner();
        noRightsText.shouldNotBeCurrentlyVisible();
    }

    public int getThcount(){
        return table.find(By.tagName("thead")).findElements(By.tagName("tr")).get(1).findElements(By.tagName("th")).size();
    }

    public int getTdcount(){

        if(!this.blueTableNoDataCheck()){
            return table.find(By.tagName("tbody")).findElement(By.tagName("tr")).findElements(By.tagName("td")).size();
        }



        return 0;
    }

    public List<String> getAddParameterColumn(){
        offerTh.waitUntilVisible();
        List<String> tds = new ArrayList<String>();
        for(WebElement td:addParameterColumn){
            tds.add(td.getText());
        }
        return tds;
    }


    public void clickLeftCheckbox(int i) {
        WebElementFacade elem = this.find(By.xpath("//table[contains(@class,'blue_table')]/tbody/tr["+i+"]/td/label"));
        waitSpinner();
        elem.waitUntilVisible();
        elem.click();
        waitSpinner();
    }

    public ArrayList<String> getOffersMainParamArray() {
        ArrayList<String> list = new ArrayList<String>();
        for (WebElement elem :offersMainParams){
            list.add(elem.getText());
        }
        return list;

    }

    public boolean isTableVisible(){
        return table.isCurrentlyVisible();
    }

    public ArrayList<String> getVertikalsMainParamArray() {
        ArrayList<String> list = new ArrayList<String>();
        for (WebElement elem :vertikalsMainParam){
            list.add(elem.getText());
        }
        return list;
    }

    public ArrayList<String> getPromosizeMainParamArray() {
        ArrayList<String> list = new ArrayList<String>();
        for (WebElement elem :promosizeMainParam){
            list.add(elem.getText());
        }
        return list;
    }

    public ArrayList<String> getGoodsMainParamArray() {
        waitABit(5000);
        waitForSpinnerDissapear();
        ArrayList<String> list = new ArrayList<String>();
        for (WebElement elem :goodsMainParam){
            if(element(elem).isCurrentlyVisible()) {
                String text = elem.getText().trim();
                System.out.println(text);
                waitABit(500);
                list.add(text);
            }

        }
        return list;
    }

    public void checkTableHasData(){
        int count = table.find(By.tagName("tbody")).find(By.tagName("tr")).findElements(By.tagName("td")).size();
        assertTrue("Проверка что с таблице есть данные ( больше одного элемента с тегом td",count>1);
    }

    public void clickFirstAvaibleOfferAdv() {
        firstAvaibleOfferAdv.waitUntilVisible();
        firstAvaibleOfferAdv.click();
        waitForSpinnerDissapear();
        waitOpacity();
    }

    public List<WebElement> getOffersNamesAdvertizer() {
        return offersAdv;
    }

    public int getLineNumber() {
        return table.then(org.openqa.selenium.By.tagName("tbody")).thenFindAll(org.openqa.selenium.By.tagName("tr")).size();
    }

    public String getFeedCodeWithtext(String feedName) {
        waitForSpinnerDissapear();
        this.evaluateJavascript("$('table>tbody>tr:contains(\""+feedName+"\")>td>a:eq(1)[id*=\"get_code\"]>img').click()");
        waitForSpinnerDissapear();
        return popup.getCodeFromTextarea();
    }

    public void clickPaymentEditWithtext(String feedName) {
        waitForSpinnerDissapear();
        getDriver().findElement(By.xpath("//table[contains(@class,'blue_table')]/tbody/tr[descendant::td[contains(text(),'"+feedName+"')]]/td/a[contains(@class,'_payinfo_edit')]")).click();
        waitForSpinnerDissapear();
    }
}





