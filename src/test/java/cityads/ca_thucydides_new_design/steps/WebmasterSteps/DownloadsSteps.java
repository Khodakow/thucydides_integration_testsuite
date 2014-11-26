/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.steps.WebmasterSteps;

import cityads.ca_thucydides_new_design.pages.WemasterPages.DownloadsPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author s.lugovskiy
 */
public class DownloadsSteps extends CouponsAndPromocodesFilterSaveSteps {

    public DownloadsSteps(Pages pages) {
        super(pages);
    }
    
    DownloadsPage page;

    @Step
    public void click_offer_checkbox_in_offer_filter(String offerName) {
        page.clickOfferCheckboxInFilter(offerName);
    }
    
    @Step
    public void uncheck_filters_move_checkbox(){
        if(page.checkboxFiltersMove.getAttribute("innerHTML").contains("checked")){
        page.checkboxFiltersMove.click();
        }
        try {Thread.sleep(5000);} catch (InterruptedException ex) {}
    }
    
    @Step
    public void check_offer_shown_in_filter_result(String offerName) {
        Assert.assertTrue(page.filterRusultBlock.getAttribute("innerHTML").contains(offerName));
    }
    
    @Step
    public void check_offer_not_shown_in_filter_result(String offerName) {
        Assert.assertTrue(page.filterRusultBlock.getAttribute("innerHTML").contains(offerName));
    }
    
    @Step
    public void save_filter() {
        executeScript("$('._save_filter').click();");
        //$(".button.submit.save.pointer.no-right._save_filter._with_hook")
                }
    @Step
    public void fill_filter_name_in_popup(String filterName) {
        page.getPopupFilternameInput().sendKeys(filterName);
    }

    @Step
    public void click_popup_filter_save_button() {
        page.getPopupFilterSaveButton().click();
    }

    @Step
    public void click_select_filter_template() {
        page.filterTemplateSelector.click();
    }

    @Step
    public void select_filter_template(String filterName) {
        page.waitForTextToAppear(filterName);
        page.find(By.linkText(filterName)).click();
    }

    @Step
    public void click_downloads_link() {
        if(page.downloadsLink.getAttribute("class").contains("hided")){
        page.downloadsLink.click();
        }
    }

    @Step
    public void click_downloads_coupons_link() {
        page.downloadsCouponsLink.click();
    }

    
    @Step
    public void click_downloads_goods_link(){
        page.downloadsGoodsLink.click();
    }
    

    @Step
    public String click_first_offer_in_filrer() {
        
        WebElement firstUncheckedCheckbox = page.firstOfferInFilterCoupons;
        firstUncheckedCheckbox.click();
        return firstUncheckedCheckbox.getText();
    }

 
    @Step
    public void click_coupons_filter_create_tool_link() {
        page.couponsCreateToolButton.click();
    }
    
        
    @Step
     public void click_goods_filter_create_tool_link() {
        page.goodsCreateToolButton.click();
    }
    
    @Step
    public String get_coupons_feed_filter_name() {
        WebElement couponsFeedFiltername = page.couponsCreateFeedFilterValue;
        return couponsFeedFiltername.getText();
    }
    
    @Step
    public String get_feed_code() {
        WebElement couponsFeedCodename = page.couponsFeedCodeValue;
        String code =  couponsFeedCodename.getAttribute("data-clipboard-text");
        String curdomain = get_curent_domain_name();
         String code2 = code.replace("api.cityads.com",curdomain);
        Assert.assertTrue(!code.isEmpty());
        if(get_curent_domain_name().contains("cityads")){
            return code;
        }
        return code2;
    }
    
            
    @Step
    public void click_coupons_checkbox_in_popup(String id) {
        page.clickOfferCheckboxInPopup(id);
    } 
    
    
    @Step("click offer checkbox")
    public void script_click_offer_checkbox(String offerName) {
        executeScript("sgc = $('[name=\"offer\"]').data('simplegroupcheck');\n" +
        "CityAds.vars.simpleGroupCheck[sgc].ko.model.items().filter(function(e){return e.name == '"+offerName+"'})[0].selected(true);");
    } 
    
    
    @Step("Кдик по второму чекбосу сверху в черном попапе")
    public void click_second_checkbox_in_offer_choose_popup() {
/*//          page.getPopup().findElements(By.className("checkbox")).get(1).click();
        List<WebElementFacade> checkboxList = page.getPopup().thenFindAll(By.xpath("//label[contains(@class,'checkbox dark')]"));
        int size = checkboxList.size();
        int i = 0;
        for(i=1; i<size; i++){

            if(checkboxList.get(i).isCurrentlyVisible()){
                waitABit(3000);
                checkboxList.get(i).click();
                waitABit(3000);
                break;
            }
        }*/
        wait_for_all_spinners_dissapears();
        executeScript("$('div[class=\"lgc-item \"]>div>label>input')[0].checked = true");
        executeScript("$('div[class=\"lgc-item \"]>div>label>input').trigger('change');");
        wait_for_all_spinners_dissapears();


    } 
            
        
    @Step
    public void fill_coupons_popup_input_offer(String offerName) {
        //executeScript("$('i').each(function(){$(this).click()});");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        page.couponsfilterPopupOffersInput.sendKeys(offerName);
    }   
        
    @Step
    public void click_all_plus(){
        executeScript("$('i').each(function(){$(this).click()});");
    }
    
    @Step
    public void click_coupons_sort_by_desc() {
        page.couponsSortByDescButton.click();
    }    
    
    @Step
    public void click_coupons_second_checkbox_offer_popup() {
        page.couponsSecondCheckboxInOffersPopup.click();
    }     
         
    @Step
    public void click_coupons_filter_popup_submit() {
        page.couponsfilterPopupOffersSubmit.click();
    }           
         
         
    @Step
    public void click_tools_json_format() {
        page.couponsPopupChooseformatJson.click();
    }       
         
    @Step
    public void check_name_input_has_text(String downloadName) {
        Assert.assertEquals(downloadName, page.inputFieldName.getText());
    }
    
    @Step
    public void check_subaccount_input_has_text(String subAcc) {
        Assert.assertEquals(subAcc, page.SubAcccountInputField.getAttribute("value"));
    }

    @Step
    public void check_page_has_text(String filterName) {
        Assert.assertTrue(getDriver().getPageSource().contains(filterName));
    }
 
    
    @Step
    public void click_downloads_popup_copy_url_button() {
        page.couponsPopupCopyCodeButton.click();
    } 

          
    @Step      
    public String get_offer_id_from_coupon_card() {
        String id = null;
        String href = page.firstCouponCardOfferLink.getAttribute("href");
            
        String re1=".*?";	// Non-greedy match on filler
        String re2="(\\d+)";	// Integer Number 1

        Pattern p = Pattern.compile(re1+re2,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher m = p.matcher(href);
        if (m.find())
        {
            id=m.group(1);
           
        }
        return id;
       
    }
    
    
    @Step      
    public String get_goods_id_from_coupon_card() {
        String id = null;
        String href = page.firstGoodsCardOfferIDLink.getAttribute("href");
            
        String re1=".*?";	// Non-greedy match on filler
        String re2="(\\d+)";	// Integer Number 1

        Pattern p = Pattern.compile(re1+re2,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher m = p.matcher(href);
        if (m.find())
        {
            id=m.group(1);
           
        }
        return id;
       
    }
    
    @Step  //клик на итую по счету кнопку http://pumpshooter.com/B3zOfijM  на странице
    public void click_i_plus_button(int i) {
        List<WebElement> buttonList;
        buttonList = getDriver().findElements(By.xpath("//div[@class='input-button _modal_button']"));
        buttonList.get(i).click();
    }

    @Step
    public void click_add_offers_plus_button() {
        List<WebElement> filters = getDriver().findElements(By.xpath("//div[contains(@class,'CheckContainer')]"));
        for(WebElement filter:filters){
            if(filter.getText().contains("фферы")){
                filter.findElement(By.className("input-button")).click();
            }
        }
    }
    
    @Step
    public void fill_download_name_in_popup(String name, String filterName){
        page.fillDownloadPopupForm(name,filterName);
    }
    
    @Step
    public void check_all_goods_offers_name(String offerName){
        List<WebElement> offerNames = page.goodsOffersName;
        for(WebElement offer: offerNames){
            Assert.assertEquals(offer.getText(), offerName);
            System.out.println(offer.getText()+"         " + offerName);
        }
        
    }
    
    
        @Step
    public void check_all_coupons_offers_name(String offerName){
        List<WebElement> offerNames = page.couponsOffersName;
        for(WebElement offer: offerNames){
            Assert.assertEquals(offer.getText(), offerName);
            System.out.println(offer.getText()+"         " + offerName);
        }
        
    }
    
    
    
    
}

