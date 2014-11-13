package cityads.ca_thucydides_new_design.pages.refactor;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;


public class GetLink extends BasePage {


    public GetLink(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//table[@id='retargetTable']")
    private WebElementFacade retargetTable;

    @FindBy(xpath="//table[@id='backurlTable']")
    private WebElementFacade backurlTable;

    @FindBy(xpath="//input[@id='id_el_text_field_name']")
    private WebElementFacade nameInput;

    @FindBy(xpath="//input[@name='subaccounts[]']")
    private WebElementFacade subaccInput;

    @FindBy(xpath="(//tr/td/label)[1]")
    private WebElementFacade checkboxFirstRetarget;


    @FindBy(xpath="//thead/tr/th/a/label")
    private WebElementFacade checkboxAllRetarget;

    @FindBy(xpath="(//table[@id='backurlTable']/tbody/tr/td[@data-name='switchOn']/label)[1]")
    private WebElementFacade checkboxFirstNoretarget;

    @FindBy(xpath="//button[contains(@class,'_saveCode')]")
    private WebElementFacade save;

    @FindBy(xpath="//button[contains(@class,'_showCode')]")
    private WebElementFacade saveAndShowCode;

    @FindBy(xpath = "(//table[@id='retargetTable']/tbody/tr/td[@data-name='actionName'])[1]")
    private WebElementFacade firstRetargetOffer;

    @FindBy(xpath = "(//table[@id='backurlTable']/tbody/tr/td[@data-name='actionName'])[1]")
    private WebElementFacade firstNoRetargetOffer;

    @FindBy(xpath = "//textarea[@id='get_code']")
    private WebElementFacade codeArea;

    public String getFirstRetargetOffer() {
        return firstRetargetOffer.getText();
    }

    public String getFirstNoRetargetOffer() {
        return firstNoRetargetOffer.getText();
    }

    public void fillForm(String name, String subacc){
        waitForSpinnerDissapear();
        nameInput.waitUntilVisible();
        nameInput.sendKeys(name);
        subaccInput.sendKeys(subacc);

        //если все чекбоксы кликнуты то отжимаем чекбокс обратно
        checkboxAllRetarget.click();
        waitForSpinnerDissapear();
        if(checkboxAllRetarget.getAttribute("class").contains("checked")){
            checkboxAllRetarget.click();
            waitForSpinnerDissapear();
        }

        checkboxFirstRetarget.click();
        waitForSpinnerDissapear();
        checkboxFirstNoretarget.click();
        waitForSpinnerDissapear();
      }

    public void saveAndExit(){
        waitForSpinnerDissapear();
        save.waitUntilVisible();
        save.click();
        waitForSpinnerDissapear();
    }

    public String saveAndGetCode(){
        waitForSpinnerDissapear();
        saveAndShowCode.waitUntilVisible();
        saveAndShowCode.click();
        codeArea.shouldBeVisible();
        codeArea.shouldContainText("gl.cnt.my");
        return codeArea.getText();
    }

}





