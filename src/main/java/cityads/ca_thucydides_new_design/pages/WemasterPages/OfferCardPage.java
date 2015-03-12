package cityads.ca_thucydides_new_design.pages.WemasterPages;

import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class OfferCardPage extends PageObject {
       
    
	public OfferCardPage(WebDriver driver) {
		super(driver);
	}
       
        @FindBy(className="description_logo_offer")
        private WebElement descriptionLogoOffer;
        
        @FindBy(xpath="//span[text()='Подключить оффер']")
        private WebElement startOffer;
        
        @FindBy(xpath="//*[@id=\"list_form\"]/div/div/div/table")
        private WebElement offerCardTable;


        @FindBy(xpath="((//tbody)[6]/tr/td/a)[2]")
        public WebElementFacade dynamicTabByPath;
        @FindBy(xpath="(//table[contains(@id,'banners')]/tbody/tr/td/a[contains(@class,'create_link')])[1]")
        public WebElementFacade dynamicGetCodeLink;

        public WebElementFacade  descriptionLogo(){
            return element(descriptionLogoOffer);
        }
        
        public WebElementFacade  startOfferButton(){
            return element(startOffer);
        }
        
        public WebElementFacade getOfferTabs(){
            return element(getDriver().findElement(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '), ' tabs ') ]"))); 
        }
        
        @FindBy(xpath="//div[@class='margin-top tabs inline-block _tab _hasTabs']/a[@id='tab_offer_inner_page_inner-4']")
        public WebElement transactions;
        
        @FindBy(xpath="//div[@class='margin-top tabs inline-block _tab _hasTabs']/a[@id='tab_offer_inner_page_inner-5']")
        public WebElement trafficPolicy;
        
        @FindBy(xpath="//div[@class='margin-top tabs inline-block _tab _hasTabs']/a[@id='tab_offer_inner_page_inner-7']")
        public WebElement noticePeriods;
        
        public WebElementFacade getOfferTabTable(){
            return element(offerCardTable);
        }
        
        @FindBy(id="unical_id_detail_offer_4")
        public WebElement instrumentsOfferTab;
            
        
        @FindBy(xpath="//a[contains(@id,'id_el_link_action_start_work')]")
        private WebElement addOfferLink;
        
        public WebElementFacade getAddOfferLink(){
            return element(addOfferLink);
        }
        
        
        @FindBy(xpath="(//div/a[@id='id_el_link_action_banners'])[2]")
        public WebElementFacade addDynamicBanner;
        
        //
        @FindBy(xpath="//div[contains(text(),'нструменты по офферу')]")
        private WebElement offerCardPopup;
        
        public WebElementFacade getPopupInstruments(){
            return element(offerCardPopup);
        }
        
        public void click_offer_tab(String name){
            getOfferTabs().findBy(By.linkText(name)).click();
        }
        
        
        @FindBy(xpath="//div[@class='col-black size-20 margin-bottom-small']")
        public WebElementFacade offerCardtabh1;
            
        public WebElementFacade getOfferTabTitle(int i){
            List<WebElementFacade> tabsTitles = this.findAll(By.xpath("//div[@class='col-black size-20 margin-bottom-small']"));
                    return tabsTitles.get(i);
        }
        
        @FindBy(linkText="id_el_link_action_links")
        private WebElement offerPopupLinks;
        
        public void clickPopupLinksButton(){
            element(offerPopup).find(By.id("id_el_link_action_links")).click();
        }
        
        @FindBy(xpath="//div[text()='Создать ссылку']")
        private WebElement offerCreateLinkPopup;
        
        @FindBy(xpath="//div[contains(concat(' ', normalize-space(@class), ' '), ' overflow _content_scrollable ') ]")
        private WebElement offerPopup;
        
        @FindBy(xpath="//textarea[contains(concat(' ', normalize-space(@class), ' '), ' dark no-border _click_select _code link-popup-textarea ') ]")
        private WebElement popupGetcodeTextarea;
        
        public String getPopupCodeTextarea(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
           
        }
            return element(popupGetcodeTextarea).getText();
        }
        
        @FindBy(id="table_wm.action_tool_links")
        public WebElement linksBlueTable;
        
        @FindBy(xpath="//div[2]/div/div/div[2]/div[2]/ul/li[2]/div/a")//
        public WebElement goToNextPageArrow;
        
        public void clickGetOfferLink(){
            element(linksBlueTable).findBy(By.xpath("//*[@id=\"id_el_td_423569453_67_action_1\"]/a[2]")).click();
        }
        
        @FindBy(xpath="//span[contains(concat(' ', normalize-space(@class), ' '), ' _offer_name ') ]")
        private WebElement offerNameInPopup;
        
        public String getOfferNameFromPopup(){
            return element(offerNameInPopup).getText();
        }
        
        public String getOfferSite(){
            return getDriver().findElement(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '), ' margin-top-small about-offer-short-info ') ]")).findElement(By.xpath("//a[contains(concat(' ', normalize-space(@class), ' '), ' icon link ') ]")).getText();
        }

        //offercard-L>rotator steps
        @FindBy(id="table_wm.action_tool_rotator")
        private WebElement rotatorsBlueTable;
        
        public void clickCreateRotatorInRotatorsTable(){
            element(rotatorsBlueTable).findBy(By.xpath("//*[@id=\"id_el_td_423809453_67_action_1\"]/a")).click();
        }
        
        
        @FindBy (xpath = "//a[@class='no-hover col-blue dashed-bottom' and text()='Динамический']")
        public WebElementFacade dynamicTab;

        @FindBy (xpath = "(//a[@class='pointer _preview_open'])[1]")
        public WebElementFacade dynamicPreview;

        @FindBy (xpath = "(//a[@class='icon code pointer _create_link _is_banner'])[1]")
        public WebElementFacade dynamicCodePopuup;

        @FindBy (xpath = "(//a[@class='icon code pointer _create_link'])[1]")
         public WebElementFacade firsticoncodepopupInInstrumentsOfferCard;


          
        @FindBy(xpath="//table[@id='table_wm.action_tool_goods']/tbody/tr[td/nobr[contains(text(),'Выгрузки купонов')]]/td[6]/a")
        public WebElementFacade createDownloadCouponsIcon;
            
        @FindBy(xpath="//table[@id='table_wm.action_tool_goods']/tbody/tr[td/nobr[contains(text(),'Выгрузки товаров')]]/td[6]/a")
        public WebElementFacade createDownloadGoodsIcon;    

        @FindBy(xpath="//a[contains(@class,'_shorten_link')]/span")
        public WebElementFacade offerCardCodeLink;

        @FindBy(xpath="//div[@class='select-value pointer']")
        public WebElementFacade selectedLinkTypeinOfferCardPopup;

        @FindBy(xpath="//a[@class='select-item']")
        public WebElementFacade alllinksincodepopup;

        @FindBy(xpath="//textarea[contains(text(),'http://')]")
        public WebElementFacade shorLinkText;
        
        @FindBy(xpath="//img[@class='description_logo_offer']")
        public WebElementFacade offerScreenshot;

        @FindBy(xpath="//a[@id='unical_id_detail_offer_4']")
        public WebElementFacade analyticsTab;

        @FindBy(xpath = "//div[@class='highcharts-container']")
        public WebElementFacade analyticHighchart;

        public WebElementFacade getCurrentVisibleBluetable(){
            
            List<WebElementFacade> tables = this.findAll(By.xpath("//table[contains(@class,'blue_table')]"));
            for(WebElementFacade table : tables){
                if(table.isCurrentlyVisible()){
                    return table;
                }
            }
            return null;
            
        }

        @FindBy(xpath="//div[contains(@class,'_ajaxFilterIndicator')]/div/div[ not(div) and contains(@class, 'value') ]")
        public List<WebElement> indicators;

       }




