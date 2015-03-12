/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.steps.WebmasterSteps;

import cityads.ca_thucydides_new_design.pages.MainPage;
import cityads.ca_thucydides_new_design.pages.WemasterPages.BannerRotatorPage;
import cityads.ca_thucydides_new_design.pages.WemasterPages.OfferCardPage;
import com.google.common.net.InternetDomainName;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author s.lugovskiy
 */
public class OfferCardSteps extends OfferListSteps {

    
    OfferCardPage page;
    MainPage mainPage;
    BannerRotatorPage bannerRotatorPage;
            
    public OfferCardSteps(Pages pages) {
        super(pages);
    }
    
    @Step
    public void check_start_offer_button_is_visible(){
        Assert.assertTrue(page.startOfferButton().isCurrentlyVisible());
        
    }
    
    @Step
    public void wait_for_start_offer_button_is_visible(int timeout){
                WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
                wait.until(ExpectedConditions.visibilityOf(page.getAddOfferLink()));
        
    }
    @Step
    public void check_description_is_visible(){
        Assert.assertTrue(page.descriptionLogo().isCurrentlyVisible());
    }

    
    @Step
    public void check_offer_card_tab_is_visible(String tab){
       Assert.assertTrue(page.getOfferTabs().containsText(tab));
    }
    
    @Step
    public void check_offer_card_table_is_visible(){
       Assert.assertTrue(page.getOfferTabTable().isCurrentlyVisible());
    }
    
    @Step
    public void click_add_offer_link(){
        page.getAddOfferLink().click();
    }
    
    
        @Step
    public void check_dynamic_tool_not_exist(){
        Assert.assertFalse(page.addDynamicBanner.isCurrentlyVisible());
    }
    
    
    
    
    @Step
    public void check_offercard_popup_is_displayed(){
        Assert.assertTrue(page.getPopupInstruments().isCurrentlyVisible());
    }

    @Step
    public void click_offer_tab_card(String offerTab1) {
       page.click_offer_tab(offerTab1);
    }

    @Step
    public void check_offer_tab_h1_appers(int i) {
    Assert.assertTrue(page.getOfferTabTitle(i).isCurrentlyVisible());

    }

    public String get_code_from_popup_textarea() {
        String code = page.getPopupCodeTextarea();
        Assert.assertNotNull(code);
        Assert.assertTrue(!code.isEmpty());
        return code;
    }

    public void click_add_link_popup_button() {
        page.clickPopupLinksButton();
    }

    @Step
    public void check_type_in_offer_card_is_standart(){
        page.selectedLinkTypeinOfferCardPopup.waitUntilVisible();
        String type = page.selectedLinkTypeinOfferCardPopup.getText();
        check_values_are_equals(type,"Лендинг - Стандартная");
    }
    @Step
    public void click_input_type_in_offer_card_popup(){
        page.selectedLinkTypeinOfferCardPopup.waitUntilVisible();
        page.selectedLinkTypeinOfferCardPopup.click();
    }
    @Step
    public void check_types_in_select_list(String type){
                    if (page.alllinksincodepopup.isCurrentlyVisible()){
                        String text = page.alllinksincodepopup.getText();
                        check_string_has_changed(text, type);

                    }

    }

    @Step
    public void click_first_icon_get_code_in_offer_instruments(){
        page.firsticoncodepopupInInstrumentsOfferCard.click();
    }


    
    //=============================================
    //offer instruments links
    @Step
    public void click_offer_instruments_tab(){
        page.getOfferTabs().findElement(By.linkText("Инструменты")).click();
    }
    
    @Step
    public void click_offer_instruments_tab_by_id(){
        page.getOfferTabs().findElement(By.xpath("//a[contains(@data-href,'action=detailTools')]")).click();
    }

    @Step
    public void check_first_td_in_blue_table_has_text(String text){
        String newtext = page.find(By.xpath("(//td[@class='title'])[1]")).getText();
        check_values_are_equals(text,newtext);
    }
    
    
        @Step
    public void click_offer_payments_tab_by_id(){
        page.getOfferTabs().findElement(By.id("unical_id_detail_offer_2")).click();
    }
    
    @Step
    public void click_offer_terms_tab_by_id(){
        page.getOfferTabs().findElement(By.id("unical_id_detail_offer_1")).click();
    }


    @Step("Кликаем на вкладку выбора динамических банеров")
    public void click_dynamic_tab_by_path(){

        page.dynamicTabByPath.waitUntilVisible().click();
    }

    @Step("Кликаем на получить код динамических банеров")
    public void click_dynamic_get_code(){
        page.dynamicGetCodeLink.waitUntilVisible().click();
    }
    @Step
    public void click_offer_terms_paid_search(){
        page.getOfferTabs().findElement(By.id("tab_offer_inner_page_inner-2")).click();
    }   
        
    @Step
    public void click_offer_terms_transactions(){
        page.transactions.click();
    }     
        
    @Step
    public void click_offer_terms_traffic_policy(){
        page.trafficPolicy.click();
    }     
                    
    @Step
    public void click_offer_terms_notice_periods(){
        page.noticePeriods.click();
    }                 
                         
              
    @Step
    @Override
    public void check_blue_table_is_visible(){
        Assert.assertTrue(page.getCurrentVisibleBluetable().isCurrentlyVisible());
    }
              
    @Step
    public String get_Blue_table_number_lines(){
        int i = page.getCurrentVisibleBluetable().findElement(By.tagName("tbody")).findElements(By.tagName("tr")).size();
        return  String.valueOf(i);
    
    }  
    
   @Step
   public void check_blue_table_has_data(){
       Assert.assertFalse(
               
               (page.getCurrentVisibleBluetable().findElement(By.tagName("tbody")).getText().contains("Нет данных")) |     //true 
               (page.getCurrentVisibleBluetable().findElement(By.tagName("tbody")).getText().contains("Sem dados"))         //false 
                              
               );
    }
              
              
    @Step
    public void check_links_table_is_present(){
        Assert.assertTrue(page.linksBlueTable.isDisplayed());
    }
    
    @Step
    public void go_to_next_page(){
        page.goToNextPageArrow.click();
    }
    
    @Step
    public void click_get_offer_link(){
        page.clickGetOfferLink();
    }
    
    @Step
    public String get_offer_name_from_popup(){
        return page.getOfferNameFromPopup();
    }
    
    @Step
    public void check_offer_name_in_popoup(String expected, String actual){
        Assert.assertEquals(expected,actual);
    }
    
    @Step
    public String get_offer_site() throws MalformedURLException {
        String site = page.getOfferSite().trim();
        URL url = new URL(site);
        String host = url.getHost();
        return InternetDomainName.from(host).topPrivateDomain().parts().get(0);

    }
  
    
    @Step
    public String getCurrentUrl(){
        return getDriver().getCurrentUrl();
    }
    
    @Step
    public void check_offer_site_contains_offer_domain(String actualSite, String site){
           Assert.assertTrue(actualSite.contains(site));
    }
    
    //offer instruments rotator
    @Step
    public void click_create_rotator_icon(){
        page.clickCreateRotatorInRotatorsTable();
    }
    
    @Step
    public void click_dynamic_tab(){
        page.dynamicTab.click();
    }
       
    @Step
    public void click_dynamic_preview(){
        page.dynamicPreview.click();
    }
          
    @Step
    public void click_dynamic_code_popup(){
        page.dynamicCodePopuup.click();
    }//No offers matching your criteria
    
    @Step
    public void check_dynamic_prewiew_is_visible(){
        Assert.assertFalse(mainPage.popup.getText().contains("Нет подходящих офферов"));
        Assert.assertFalse(mainPage.popup.getText().contains("No offers matching your criteria"));
        
    }
    
    @Step
    public void click_create_download_goods_icon(){
        //Assert.assertTrue(page.createDownloadGoodsIcon.isCurrentlyVisible());
        page.createDownloadGoodsIcon.waitUntilVisible();
        page.createDownloadGoodsIcon.click();
    }
    
    @Step
    public void click_create_download_coupons_icon(){
        page.createDownloadCouponsIcon.waitUntilVisible();
        Assert.assertTrue(page.createDownloadCouponsIcon.isCurrentlyVisible());
        page.createDownloadCouponsIcon.click();
    }
    
    
    
    @Step
    public void check_offer_name_present_in_rotator(String offerName, String offerNameActual){
        Assert.assertTrue(offerName.contains(offerNameActual));
    }

    @Step
    public void click_short_link_button(){

        page.offerCardCodeLink.waitUntilVisible();
        page.offerCardCodeLink.click();
        page.shorLinkText.waitUntilVisible();


    }



    @Step
    public void check_offer_screenshot_is_visible(){
        Assert.assertTrue(page.offerScreenshot.isCurrentlyVisible());

    }

    @Step
    public void check_analytics_tab_is_visible() {
        Assert.assertTrue(page.analyticsTab.isCurrentlyVisible());
    }

    @Step
    public void click_analytics_tab() {
        page.analyticsTab.click();
    }


    @Step
    public void check_analytics_highchart_is_displayed(){
        Assert.assertTrue(page.analyticHighchart.isCurrentlyVisible());  //проверяем что график видим
    }



    @Step
    public void check_analytic_highchart_size(){
        int width = page.analyticHighchart.find(By.className("highcharts-series-group")).getSize().getWidth(); // проверяем длину и ширину кривой на графике
        int height = page.analyticHighchart.find(By.className("highcharts-series-group")).getSize().getHeight();
        Assert.assertTrue(width>500);
        Assert.assertTrue(height>0);
    }

    @Step
    public void click_offer_by_name(String name) {
        waitABit(5000);
        mainPage.getBlueTable().find(By.partialLinkText(name)).click();
    }

    @Step
    public void find_offer_in_pager(String offerName) {

        while(true) {
            if(getDriver().getPageSource().contains(offerName)){
                click_offer_by_name(offerName);
                break;
            }
            else{
                click_go_next_page();
                wait_for_all_spinners_dissapears(90);
            }
        }
    }

    @Step
    public void check_indicator_block() {
        List<Float> indivatorsValues = new ArrayList<Float>();
        for(WebElement elem : page.indicators){
            Float number = Float.parseFloat(elem.getText().replace("%", "").replace("'",""));
            indivatorsValues.add(number);

            if(number>0){                        //если есть хотя бы один не нулевой индикатор то проверяем что в таблице есть данные
                check_blue_table_has_lines_with_data();
                List<Double> data = get_top5_table_data();
                check_array_has_not_null_number(data);
                break;                              //нет смысла проверять много раз
            }

        }


    }

    @Step
    public List<Double> get_top5_table_data(){
        List<Double> data = new ArrayList<Double>();
        List<WebElement> elems = mainPage.top5Indicators;
        for(WebElement elem : elems){
            data.add(Double.valueOf(elem.getText().replaceAll("’","").replaceAll("'","")));
        }
        return data;
    }

    @Step
    public void check_array_has_not_null_number(List<Double> data){
        Double sum = 0.0;
        for(double num : data){
            sum = sum+ num;
        }
        Assert.assertTrue(sum>0);
    }

    @Step
    public void check_offer_site_has_www(String site) {
        Assert.assertTrue(site.contains("http://www"));
    }
}

