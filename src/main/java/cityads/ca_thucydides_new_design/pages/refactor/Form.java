package cityads.ca_thucydides_new_design.pages.refactor;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;


public class Form extends BasePage {


    public Form(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//*[@id='submit_ok']")
    private WebElementFacade submit;

    @FindBy(xpath="(//*[contains(text(),'Salve as')])[2]")
    private WebElementFacade submitSecondTab;

    @FindBy(xpath="//*[@id='create_user']")
    private WebElementFacade create;


    public void submit(){
        submit.waitUntilVisible();
        submit.click();
        waitForSpinnerDissapear();
    }

    public void create(){
        create.waitUntilVisible();
        create.click();
        this.waitForSpinnerDissapear();
    }


    public void submitSecondTab() {
        /*submitSecondTab.waitUntilVisible();
        submitSecondTab.click();*/
        this.evaluateJavascript("$('#submit_ok').trigger('click');");
        waitForSpinnerDissapear();
    }
}





