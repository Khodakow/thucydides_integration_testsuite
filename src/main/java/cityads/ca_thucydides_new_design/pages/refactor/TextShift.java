package cityads.ca_thucydides_new_design.pages.refactor;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;


public class TextShift extends BasePage {


    public TextShift(WebDriver driver) {
        super(driver);
    }

    private Table table;

    @FindBy(xpath="//input[@id='id_el_text_field_name']")
    private WebElementFacade name;

    @FindBy(xpath="//input[@name='subaccounts[]']")
    private WebElementFacade subacc;

    @FindBy(xpath="//button[contains(@class,'_saveCode')]")
    private WebElementFacade submit;

    @FindBy(xpath="//button[@class='button submit code _showCode']")
    private WebElementFacade saveAndGetCode;

    @FindBy(xpath = "//textarea[@id='get_code']")
    private WebElementFacade codeArea;

    @FindBy(xpath = "//a[contains(@id,'text_shift_feed_get')]")
    private WebElementFacade getCodeFromTable;

    @FindBy(xpath = "//div[contains(@class,'select _select dark')]/div[contains(@class,'select-choose pointer')]")
    private WebElementFacade getCodePopupPointer;

    @FindBy(xpath = "//a[@data-id='extension']")
    private WebElementFacade extensionsLinkFromPopupList;



    public void createTextShift(String shiftName,String subaccName){
        name.waitUntilVisible();
        name.clear();
        name.sendKeys(shiftName);
        subacc.waitUntilVisible();
        subacc.clear();
        subacc.sendKeys(subaccName);
        submit.waitUntilVisible();
        submit.click();
        table.waitTable();
        waitForSpinnerDissapear();

    }

    public String createTextShiftAndGetCode(String shiftName,String subaccName){
        name.waitUntilVisible();
        name.clear();
        name.sendKeys(shiftName);
        subacc.waitUntilVisible();
        subacc.clear();
        subacc.sendKeys(subaccName);
        saveAndGetCode.waitUntilVisible();
        saveAndGetCode.click();
        waitForSpinnerDissapear();
        codeArea.shouldBeVisible();
        String code = (String)this.evaluateJavascript("return get_code.value");
        return code;
    }

    public void get_textshift_code_from_icon_table(){
        getCodeFromTable.waitUntilVisible();
        getCodeFromTable.click();
    }

    public void get_textshift_code_from_icon_table_and_choose_extensions(){
        getCodeFromTable.waitUntilVisible();
        getCodeFromTable.click();
        getCodePopupPointer.waitUntilVisible();
        getCodePopupPointer.click();
        extensionsLinkFromPopupList.waitUntilVisible();
        extensionsLinkFromPopupList.click();
    }
}





