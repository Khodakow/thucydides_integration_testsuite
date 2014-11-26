package cityads.ca_thucydides_new_design.pages.refactor;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;


public class GlobalFilter extends BasePage {


    public GlobalFilter(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//div[contains(@class,'icon filter float-right')]")
    private WebElementFacade filterIcon;

    @FindBy(xpath="//div[contains(@class,'_toggle_ext_filter')]")
    private WebElementFacade filterToggle;

    @FindBy(xpath = "//div[contains(@class,'_ext_filter_items_container')]")
    private WebElementFacade filterContainer;

    @FindBy(xpath = "//span[contains(@class,'icon plus')]")
    private WebElementFacade plusIcon;

    @FindBy(xpath = "//span[contains(@class,'_add_compound')]")
    private WebElementFacade plusIconComplex;


    @FindBy(xpath = "//span[contains(@class,'icon add-multy')]")
    private WebElementFacade plusMultiIcon;

    @FindBy(xpath = "//input[contains(@class,'_item_value _has_autocomplete')]")
    private WebElementFacade input;

    @FindBy(xpath = "(//input[contains(@class,'_item_value _has_autocomplete')])[2]")
    private WebElementFacade input2;

    @FindBy(xpath = "//div[contains(@class,'autocomplete-results')]")
    private WebElementFacade list;

    @FindBy(xpath = "(//span[contains(@class,'_auto_items pointer')])[1]")
    private WebElementFacade firstElemeintInList;

    @FindBy(xpath = "(//span[contains(@class,'_apply_ext_filter')])[1]")
    private WebElementFacade apply;

    @FindBy(xpath = "(//span[contains(@class,'_clear_ext_filter')])[1]")
    private WebElementFacade reset;

    @FindBy(xpath = "(//div[contains(@class,'_extended_filter_title')])[1]")
    private WebElementFacade condition;

    @FindBy(xpath="//div[contains(@class,'ib v-top width-184')]/div/div[@class='select _select']/div[@class='select-choose pointer']")
    private WebElementFacade criteriaPointer;

    @FindBy(xpath="//div[contains(@class,'select-list')]")
    private WebElementFacade criteriaList;

    @FindBy(xpath="//div[@class='select-list']/a[contains(@class,'select-item') and (contains(text(),'Office') or contains(text(),'Офис')) ]")
    private WebElementFacade criteriaOffice;

    @FindBy(xpath="//span[(contains(@data-id,'Brazil')or contains(@data-id,'Бразилия'))]")
    private WebElementFacade criteriaOfficeBrazil;

    @FindBy(xpath="//div[contains(@class,'_error_msg') and string-length(text()) > 0]")
    private WebElementFacade errorMsg;



    public void setSimpleCondition(){
        waitForSpinnerDissapear();
        filterIcon.waitUntilVisible();
        filterIcon.click();
        filterContainer.waitUntilVisible();
        filterContainer.click();
        plusIcon.waitUntilVisible();
        plusIcon.click();
        input.click();
        firstElemeintInList.waitUntilVisible();
        firstElemeintInList.click();
        apply.click();
        waitForSpinnerDissapear();
    }

    public void resetFilter(){
        waitForSpinnerDissapear();
        filterToggle.waitUntilVisible();
        filterToggle.click();
        filterContainer.waitUntilVisible();
        filterContainer.click();
        reset.waitUntilVisible();
        reset.click();
        waitForSpinnerDissapear();
    }

    public String getCondition() {
        return condition.getText();
    }

    public void setOfficeBrazil() {
        waitForSpinnerDissapear();
        filterIcon.waitUntilVisible();
        filterIcon.click();
        filterContainer.waitUntilVisible();
        filterContainer.click();
        plusIcon.waitUntilVisible();
        plusIcon.click();
        criteriaPointer.waitUntilVisible();
        criteriaPointer.click();
        criteriaList.waitUntilVisible();
        criteriaOffice.waitUntilVisible();
        criteriaOffice.click();
        //input.clear();
        input.click();
        //this.evaluateJavascript("$('span[data-id*=\"CityAds Бразилия\"]').trigger('click');");
        criteriaOfficeBrazil.waitUntilVisible();
        criteriaOfficeBrazil.click();
        apply.click();
        waitForSpinnerDissapear();
    }


    public String setComplexCondition() {
        waitForSpinnerDissapear();
        filterIcon.waitUntilVisible();
        filterIcon.click();
        filterContainer.waitUntilVisible();
        filterContainer.click();

        // 1st condition
        plusIconComplex.waitUntilVisible();
        plusIconComplex.click();
        input.click();
        firstElemeintInList.waitUntilVisible();
        firstElemeintInList.click();

        // 2nd condition
        plusIconComplex.waitUntilVisible();
        plusIconComplex.click();
        input2.click();
        firstElemeintInList.waitUntilVisible();
        String offer = firstElemeintInList.getText();
        firstElemeintInList.click();

        apply.click();
        waitForSpinnerDissapear();
        filterContainer.shouldNotBeCurrentlyVisible();
        return offer;

    }

    public boolean errorMsgIsVisible(){
        return errorMsg.isCurrentlyVisible();
    }
}






