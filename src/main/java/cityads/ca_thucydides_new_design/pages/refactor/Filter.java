package cityads.ca_thucydides_new_design.pages.refactor;

import net.thucydides.core.annotations.findby.By;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;


public class Filter extends BasePage {


    public Filter(WebDriver driver) {
        super(driver);
    }

    private WebElementFacade filterCheckbox;
    private Popup popup;


    @FindBy(xpath="//button[@type='submit']")
    private WebElementFacade submitFilter;

    @FindBy(xpath="//div[contains(@class,'_selected_filters')]")
    private WebElementFacade selectedFilters;

    @FindBy(xpath="//input[@id='id_el_text_field_keyword']")
    private WebElementFacade keywordInput;

    @FindBy(xpath = "//input[@name='keyword']")
    private WebElementFacade keywordInputGetlink1;

    @FindBy(xpath = "(//input[@name='keyword'])[2]")
    private WebElementFacade keywordInputGetlink2;

    private WebElementFacade getFilterCheckbox(int filter,int checkbox) {
        return element(this.getDriver().findElement(By.xpath
        (
       "(((//div[   (contains(@class,'_list') and descendant::div[contains(@class,'lgc-item ')]) or (contains(@data-bind,'foreach:') and descendant::div[contains(@data-bind,'visible:')])  ])["+filter+"])/div/label)["+checkbox+"]"
        )));
    }

    public void clickCheckboxInFilter(int filter,int checkbox){
        waitForSpinnerDissapear();
        getFilterCheckbox(filter,checkbox).waitUntilVisible();
        getFilterCheckbox(filter, checkbox).click();
        waitForSpinnerDissapear();

    }

    public void resetFilter() {
        this.evaluateJavascript("$('#id_el_input_filter_reset').click()");
        this.waitABit(1000);
        this.waitForSpinnerDissapear();
    }

    public String getSelectedFiltersText(){
        return selectedFilters.getText();
    }

    public void submitFilter(){
        waitForSpinnerDissapear();
        submitFilter.waitUntilVisible();
        submitFilter.click();
        waitForSpinnerDissapear();
    }

    public void searchByKeyword(String s) {
        keywordInput.clear();
        keywordInput.sendKeys(s);
        submitFilter();
        waitForSpinnerDissapear();
    }

    public void saveFilter(String name) {
        waitForSpinnerDissapear();
        evaluateJavascript("$('a[class*=\"_save_filter\"]').click()");
        popup.waitPopup();
        popup.fillName(name);
        waitForSpinnerDissapear();
    }

    public void filterByKeywordRetarget(String keyword) {
        waitForSpinnerDissapear();
        keywordInputGetlink1.sendKeys(keyword);
    }

    public void filterByKeywordNoRetarget(String keyword) {
        waitForSpinnerDissapear();
        keywordInputGetlink2.sendKeys(keyword);
    }
}





