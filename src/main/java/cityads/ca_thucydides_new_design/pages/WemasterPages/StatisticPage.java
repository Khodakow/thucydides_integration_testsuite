package cityads.ca_thucydides_new_design.pages.WemasterPages;

import cityads.ca_thucydides_new_design.pages.MainPage;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class StatisticPage extends MainPage {
    
       
	
	public StatisticPage(WebDriver driver) {
		super(driver);
	}
        
        
        @FindBy(xpath="//a[contains(concat(' ', normalize-space(@class), ' '), ' label-icon icon-datepicker ') ]")
        private WebElement datapicker;
        
        public WebElement getCalendarButton(){
          return datapicker;
        }
       
        //
        @FindBy(partialLinkText="90 дней")
        public WebElement stat90DaysLnk;
        
        @FindBy(partialLinkText="Сегодня")
        public WebElement statTodayLnk;

        @FindBy(xpath="//*[@id=\"chart_area_graph_min\"]/div[1]/div[3]/div/a[2]")
        public WebElement min5;
        
        @FindBy(xpath="//*[@id=\"chart_area_graph_min\"]/div[1]/div[3]/div/a[3]")
        public WebElement min10;
        
        @FindBy(id="chart_area_graph_min")
        public WebElement chart1;
           
        @FindBy(id="chart_area_graph_sec")
        public WebElement chart2;
        
        @FindBy(id="chart_area_office_stat_0")
        public WebElementFacade chartOffice;
        
        @FindBy(partialLinkText="месяц")
        public WebElement statMonth;
        
        @FindBy(xpath="//a[contains(concat(' ', normalize-space(@class), ' '), ' popup-with-bg button_submit ') ]")
        public WebElement applyCalendar;
        
        @FindBy(xpath="//div[contains(concat(' ', normalize-space(@class), ' '), ' size-20 col-blue ') ]")
        public WebElement statNumbers;
        
        @FindBy(className="highcharts-container")
        public WebElementFacade highchartsContainer;
        
                   //_left_menu_id_423609452   _left_menu_id_428969753
        @FindBy(id="_left_menu_id_423609452")
        public WebElement statToolsLink;
        
        @FindBy(id="_left_menu_id_428989753")
        public WebElement statToolsByTypesLink;
        
        @FindBy(id="_left_menu_id_429009753")
        public WebElement statToolsByCategoriesLink;
        
        @FindBy(id="_left_menu_id_429029753")
        public WebElement statToolsByFormatLink;

        @FindBy(id="_left_menu_id_424091311")
        public WebElement statToolsOverviewLink;
        
        @FindBy(id="_left_menu_id_426569652")
        public WebElement statTimesLink;
        
        @FindBy(id="_left_menu_id_426589652")
        public WebElement statTimeByDatesLink;

        @FindBy(id="_left_menu_id_426929753")
        public WebElement statSegmentsLink;
        
        @FindBy(id="_left_menu_id_426949753")
        public WebElement statSegmentsTypeLink;
        
        @FindBy(id="_left_menu_id_426969753")
        public WebElement statSegmentsVerticalsLink;
        
        @FindBy(id="_left_menu_id_426989753")
        public WebElement statSegmentsOffersLink;
        
        @FindBy(id="_left_menu_id_428769753")
        public WebElement statActivityLink;
        
        @FindBy(id="_left_menu_id_428789753")
        public WebElement statActivityTypeLink;
        
        @FindBy(id="_left_menu_id_428809753")
        public WebElement statActivityConversionLink;

        @FindBy(id="unical_id_stata_overview_1")
        public WebElement statByIntervalTab;
        
        
        @FindBy(id="_left_menu_id_3641958")
        public WebElement statAuditoryLink;
        
        @FindBy(id="_left_menu_id_419899323")
        public WebElement statAuditoryByCountriesLink;
        
        @FindBy(id="_left_menu_id_419919323")
        public WebElement statAuditoryByCountriesByLangLink;
        
        @FindBy(id="_left_menu_id_419939323")
        public WebElement statAuditoryByCountriesByLangLocation;
        
        @FindBy(id="_left_menu_id_429295535")
        public WebElement statAuditoryByCountriesByTimezones;
        
        @FindBy(id="_left_menu_id_417919372")
        public WebElement statAuditoryByBehavior;
        
        @FindBy(id="_left_menu_id_418479323")
        public WebElement statAuditoryByBehaviorNewAndRet;
        
        @FindBy(id="_left_menu_id_417899372")
        public WebElement statAuditoryByTech;
        
        @FindBy(id="_left_menu_id_418499323")
        public WebElement statAuditoryByTechByBrowser;
        
        @FindBy(id="_left_menu_id_418519323")
        public WebElement statAuditoryByTechByOC;
        
        @FindBy(id="_left_menu_id_429799793")
        public WebElement statAuditoryByTechByScreenResolution;
        
        @FindBy(id="_left_menu_id_429819793")
        public WebElement statAuditoryByTechByScreenColors;
        
        @FindBy(id="_left_menu_id_429839793")
        public WebElement statAuditoryByTechByFlash;
        
        
        @FindBy(id="_left_menu_id_417879372")
        public WebElement statAuditoryByDevices;
        
        @FindBy(id="_left_menu_id_418539323")
        public WebElement statAuditoryByDevicesType;
        
        @FindBy(id="_left_menu_id_418559323")
        public WebElement statAuditoryByTechByDevicesMod;
        
        
        
        @FindBy(id="_left_menu_id_429639753")
        public WebElement statAuditoryByMobileDevices;
        
        @FindBy(id="_left_menu_id_429679753")
        public WebElement statAuditoryByMobileDevicesType;
        
        @FindBy(id="_left_menu_id_429659753")
        public WebElement statAuditoryByMobileDevicesMod;
        
        
              
        public List<WebElement> getAllStatNumbers(){
            return getDriver().findElements(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '), ' size-20 col-blue ') ]"));
        }
        
        @FindBy(xpath="//*[@id=\"highcharts-4\"]/svg/g[8]/g/g/g[2]/text/tspan")
        public WebElement highchartsBreadcrumbsHits;
        
        public String getHightChartsInnerHTML(){
            return getDriver().findElement(By.className("highcharts-container")).getAttribute("innerHTML");
        }
        
        @FindBy(xpath="//div[@id='highcharts-20']")
        public WebElement hightchartBySeconds;
        
        @FindBy(xpath="//div[@id='highcharts-12']")
        public WebElement hightchartByMinutes;
        
        public WebElement getChart1(){
            String jQuerySecondsHightChart ="'#chart_area_graph_min .chart .highcharts-container svg .highcharts-series-group .highcharts-series path:eq(2)'";
            WebElement jqueryChart1 = (WebElement) ((JavascriptExecutor) getDriver()).executeScript("return $(" + jQuerySecondsHightChart+ ").get(0)");
            return jqueryChart1;
        }
        
        @FindBy(xpath="//a[@data-value='week']")
        public WebElement byWeek;
        
        @FindBy(xpath="//a[@data-value='month']")
        public WebElement byMonth;
        
      

    public WebElement getCompareWithCheckbox() {
        return calendar.findElement(By.xpath("//label[contains(@for,'ui-datepicker-checkbox')]"));
    }
    
    public WebElementFacade getCalendar(){
        return element(calendar);
    }
    

    @FindBy(xpath="(//table[contains(@class,'blue_table')]/tbody/tr/td)[2]")
    public WebElement blueTableSocondTd;
    @FindBy(xpath="//input[@name='keyword']")
    public WebElement statisticSearchByKeyword;

    @FindBy(xpath="//div[@class='input-icon-find']")
    public WebElement statisticSearchByKeywordIcon;
    
    @FindBy(xpath="//table[contains(@class,'blue_table')]/tbody/tr/td[2]")
    public List<WebElement> bluetableFirstTdList;

    @FindBy(xpath="//a[@class='_genremotekey _no_event']")
    public WebElementFacade generateAuthkey;

    @FindBy(xpath="//span[@class='_numRemoteAuth']")
    public WebElement authKey;

    @FindBy(xpath="(//div[contains(@class,'input-button optional')])[1]")
    public WebElementFacade stat_first_additional_parametr;

    @FindBy(xpath="(//div[contains(@class,'input-button optional')])[2]")
    public WebElementFacade statAddDymanic;

    @FindBy(xpath="//div[contains(@class,'search-input-icon')]/input")
    public WebElementFacade stat_first_additional_parametr_input_search;

    @FindBy(xpath="(//table[contains(@class,'blue_table')]/tbody/tr/td[4]/nobr[not(contains(text(),'Unknown')) and not(contains(text(),'Неизвестно'))])[1]")
    public WebElementFacade stat_first_element_in_blue_table__add_parametr;

    @FindBy(xpath="(//table[contains(@class,'blue_table')]/tbody/tr/td[contains(@class,'hardBorder') and contains(@style,'z-index: 45')][1])")
    public WebElementFacade stat_first_element_in_blue_table__main_parametr;

    @FindBy(xpath="(//table[contains(@class,'blue_table')]/tbody/tr/td[contains(@class,'hardBorder') and contains(@style,'z-index: 45')][2])")
    public List<WebElement> blueTableAdditionalParamList;

    @FindBy(xpath="//label[@for='id_el_input_cb__1']")
    public WebElementFacade first_checkbox_in_blue_table;

    @FindBy(xpath="//a[contains(@class,'button submit ') and contains(@class,'to-graph')]")
    public WebElementFacade show_on_chart_icon;

    @FindBy(xpath="(//table[contains(@class,'blue_table')]/tbody/tr/td/nobr/a)[1]")
    public WebElementFacade firstlinkmainparam;

    @FindBy(xpath="(//table[contains(@class,'no-zebra')]/tbody/tr/td/a)[1]")
    public WebElementFacade secondLinkInLegend;

    @FindBy(xpath="//div[contains(@class,'_dynamics_percentage')]")
    public WebElementFacade dynamicPercentage;

    @FindBy(xpath="//div[@class='dynamics']")
    public List<WebElement> dynamicGif;
}





