package cityads.ca_thucydides_new_design.pages.refactor;

import com.google.common.base.Predicate;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static junit.framework.Assert.assertFalse;


public class BasePage extends PageObject {

    private String baseUrl;
    public BasePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(@class,'absolute _context_preloader')]")
    private WebElementFacade opacitySpinner;

    @FindBy(xpath = "//div[contains(@class,'select-value') and (contains(text(),'CSV') or contains(text(),'XLSX'))]")
    private WebElementFacade exportSelect;

    @FindBy(xpath = "//div[@class='spinner-icon']")
    private WebElementFacade spinner;

    @FindBy(xpath="//div[@class='highcharts-container']")
    private WebElementFacade chart;

    @FindBy(xpath="//div[@class='absolute _context_preloader']")
    private WebElementFacade opacity;

    @FindBy(xpath="//div[@class= '_content_place' and contains(text(),'технических работ') or contains(text(),'trabalhos técnicos') or contains(text(),'server maintenance')]")
    private WebElementFacade statError;

    @FindBy(xpath="//div[contains(@class,'_window_title') and (contains(text(),'Запросы') or contains(text(),'Pedido'))]")
    private WebElementFacade popupVersion;

    @FindBy(xpath = "//a[contains(@id,'statExportButton')]")
    private WebElementFacade export;

    @FindBy(xpath="//img[@src='/images/start/spinner.gif']")
    private WebElementFacade exportSpinner;

    @FindBy(xpath = "//a[contains(@class,'button dark  submit')]")
    private WebElementFacade submitExport;

    @FindBy(xpath = "//a[contains(text(),'XLS')]")
    private WebElementFacade xls;

    @FindBy(xpath = "//a[contains(@ff_params,'q_data_group==event_time_month')]")
    private WebElementFacade byMonth;

    @FindBy(xpath = "//div[@time]")
    private List<WebElement> months;



    public void waitOpacity(){
        new FluentWait<WebDriver>(getDriver()).
                withTimeout(300, TimeUnit.SECONDS).
                pollingEvery(1, TimeUnit.SECONDS).
                ignoring(NoSuchElementException.class).
                until(new Predicate<WebDriver>(){
                    public boolean apply(WebDriver driver){
                        return !opacitySpinner.isCurrentlyVisible();
                    }
                });
    }

    public void waitSpinner(){
        new FluentWait<WebDriver>(getDriver()).
                withTimeout(160, TimeUnit.SECONDS).
                pollingEvery(500, TimeUnit.MILLISECONDS).
                ignoring(NoSuchElementException.class).
                until(new Predicate<WebDriver>(){
                    public boolean apply(WebDriver driver){
                        System.out.println("small spinner ready: "+!checkSpinnerJquery());
                        return !checkSpinnerJquery();
                    }
                });


        new FluentWait<WebDriver>(getDriver()).
                withTimeout(120, TimeUnit.SECONDS).
                pollingEvery(500, TimeUnit.MILLISECONDS).
                ignoring(NoSuchElementException.class).
                until(new Predicate<WebDriver>(){
                    public boolean apply(WebDriver driver){
                        boolean check = checkOpacitySpinnerJquery();
                        return check;
                    }
                });

    }


    public void openBaseUrl(){
        this.baseUrl = System.getProperty("webdriver.base.url");
        getDriver().get(this.baseUrl);
        getDriver().manage().window().maximize();

    }
    public void openBaseUrlPlusDirect(String url){
        this.baseUrl = System.getProperty("webdriver.base.url");
        String directUrl = (baseUrl+url);
        getDriver().get(directUrl);
        getDriver().manage().window().maximize();
    }

    public void waitForSpinnerDissapear(){
        waitSpinner();
    }


    public void export(){
        waitForSpinnerDissapear();
        export.waitUntilVisible();
        export.click();
        waitForSpinnerDissapear();
        this.evaluateJavascript("$('div[class*=\"select-choose pointer\"]').last().click();");
        xls.waitUntilVisible();
        xls.click();
        submitExport.waitUntilVisible();
        submitExport.click();
        waitForSpinnerDissapear();
        //exportSpinner.waitUntilVisible();

    }

    private boolean checkSpinnerJquery(){
        boolean check = false;
        Long spinner;
        spinner = (Long)((JavascriptExecutor)getDriver()).executeScript("return $('.spinner-icon').length");
        if(spinner == 0){check = false;}
        else {check = true;}
        return check;

    }
    private void waitForOpacitySpinnerDissapear(){
        new FluentWait<WebDriver>(getDriver()).
                withTimeout(30, TimeUnit.SECONDS).
                pollingEvery(1, TimeUnit.SECONDS).
                ignoring(NoSuchElementException.class).
                until(new Predicate<WebDriver>(){
                    public boolean apply(WebDriver driver){
                        return !checkOpacitySpinnerJquery();
                    }
                });
    }
    private boolean checkOpacitySpinnerJquery(){
        boolean check;
        System.out.println("stat error: "+statError.isCurrentlyVisible());
        if(statError.isCurrentlyVisible()){
            this.evaluateJavascript("$('div[class=\"_queries_log\"]').click()");
            //сдвигаем  попап с ошибкой чтобы было видно
            this.evaluateJavascript("$('div[class*=\"popup modal black show transition3\"]:eq(0)').css('left','0px')");

        }
        assertFalse("отображается окно с ошибкой 'что-то пошло не так'",statError.isCurrentlyVisible());
        if (tableIsReady() && chartIsReady() && deltachartIsReady()) {check = true;}  //Добавить && mapIsReady() если будет тупить крутилка на карте
        else {check = false;}
        return check;
    }

    public WebElement get_webelement_with_jquery(String script){

        WebElement element = (WebElement)((JavascriptExecutor) getDriver()).executeScript("return "+script);
        return element;
    }

    private boolean tableIsReady(){
        boolean contextCheck = true;
        boolean cityCheck = true;
        boolean check = true;
        contextCheck = (Boolean)((JavascriptExecutor)getDriver()).executeScript("return CityAds.context.current==null");
        cityCheck = (Boolean)((JavascriptExecutor)getDriver()).executeScript("return typeof(CityAds) == 'undefined'");
        if(!contextCheck && !cityCheck){
            check =  (Boolean)((JavascriptExecutor)getDriver()).executeScript("return typeof (CityAds.context.current.requesterInterface.requesters.table) == 'undefined';");
            if(!check){
                try {
                    int requestId = ((Long) this.evaluateJavascript("return CityAds.context.current.requesterInterface.requesters.table.req_id[0]")).intValue();
                    System.out.println("-------->>>>   Request ID = " + requestId);
                }
                catch(Exception e) {
                }
            }
        }
        System.out.println("table ready: "+check);
        return check;

    }

    private boolean mapIsReady(){
        boolean contextCheck = true;
        boolean check = true;
        contextCheck = (Boolean)((JavascriptExecutor)getDriver()).executeScript("return CityAds.context.current==null");
        if(!contextCheck){
            check =  (Boolean)((JavascriptExecutor)getDriver()).executeScript("return typeof (CityAds.context.current.requesterInterface.requesters.map) == 'undefined';");
            if(!check){
                try {
                    int requestId = ((Long) this.evaluateJavascript("return CityAds.context.current.requesterInterface.requesters.map.req_id[0]")).intValue();
                    System.out.println("-------->>>>   Request ID = " + requestId);
                }
                catch(Exception e) {
                }
            }
        }
        System.out.println("map ready: "+check);
        return check;
    }

    private boolean chartIsReady(){
        boolean contextCheck = true;
        boolean check = true;
        contextCheck = (Boolean)((JavascriptExecutor)getDriver()).executeScript("return CityAds.context.current==null");
        if(!contextCheck){
            check =  (Boolean)((JavascriptExecutor)getDriver()).executeScript("return typeof (CityAds.context.current.requesterInterface.requesters.chart) == 'undefined';");
            if(!check){
                try {
                    int requestId = ((Long) this.evaluateJavascript("return CityAds.context.current.requesterInterface.requesters.chart.req_id[0]")).intValue();
                    System.out.println("-------->>>>   Request ID = " + requestId);
                }
                catch(Exception e) {
                }
            }
        }
        System.out.println("chart ready: "+check);
        return check;
    }

    private boolean deltachartIsReady(){
        boolean contextCheck = true;
        boolean check = true;
        contextCheck = (Boolean)((JavascriptExecutor)getDriver()).executeScript("return CityAds.context.current==null");
        if(!contextCheck){
            check =  (Boolean)((JavascriptExecutor)getDriver()).executeScript("return typeof (CityAds.context.current.requesterInterface.requesters.delta_chart) == 'undefined';");
            if(!check){
                try {
                    int requestId = ((Long) this.evaluateJavascript("return CityAds.context.current.requesterInterface.requesters.delta_chart.req_id[0]")).intValue();
                    System.out.println("-------->>>>   Request ID = " + requestId);
                }
                catch(Exception e) {
                }
            }
        }
        System.out.println("delta chart ready: "+check);
        return check;
    }

    public boolean textHasCyrillic(String text){
        boolean check;
        check = true;
        String patternString = "[А-ЯЁ][а-яё]*";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(text);
        check = matcher.matches();
        return check;
    }

    public void exportSpinerNotVisible() {
        exportSpinner.shouldNotBeVisible();
    }

    public void clickByMonth() {
        byMonth.waitUntilVisible();
        byMonth.click();
        waitForSpinnerDissapear();
    }

    public Set<String> getMonths(){
        waitForSpinnerDissapear();
        Set<String> mnths = new HashSet<String>();
        for(WebElement month: months){
            mnths.add(month.getText());
        }
        return mnths;
    }
}





