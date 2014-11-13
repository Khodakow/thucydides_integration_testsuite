package cityads.ca_thucydides_new_design.pages.refactor;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Statistic extends BasePage {


    public Statistic(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//a[@data-date-type='event_time']")
    private WebElementFacade byConversionDate;

    @FindBy(xpath="//a[@data-date-type='sale_event_time']")
    private WebElementFacade byLoadDate;

    @FindBy(xpath="(//div[@class='absolute _context_preloader'])[1]")
    private WebElementFacade innerCircle;

    @FindBy(xpath="//a[@id='unical_id_stata_overview_1']")
    private WebElementFacade byIntervals;

    @FindBy(xpath = "//div[@class='select _select _stat_export']/div[1]")
    private WebElementFacade export;

    @FindBy(xpath = "//div[@class='select-list dark']")
    private WebElementFacade exportList;

    @FindBy(xpath = "//div[@class='select-list dark']/a[@data-id='excel']")
    private WebElementFacade exportExcel;

    public void clickByLoadDate(){
        byLoadDate.waitUntilVisible();
        byLoadDate.click();
    }

    public boolean isSpinnerDisplayed(){
        return innerCircle.isCurrentlyVisible();
    }

    public void clickByIntervalGraf(){
        byIntervals.waitUntilVisible();
        byIntervals.click();
        waitABit(2000);
        waitSpinner();
    }

    public String getTextSummaryByNumber(int num){
        String text = getDriver().findElements(By.xpath("//div[@class='size-14 col']")).get(num).getText();
        System.out.println(text);
        return text;
    }

    public void clickExportExcel(){
        export.waitUntilVisible();
        export.click();
        exportList.waitUntilVisible();
        export.click();
        exportExcel.waitUntilVisible();
        export.click();
    }


}





