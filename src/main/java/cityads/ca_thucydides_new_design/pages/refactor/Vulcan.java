package cityads.ca_thucydides_new_design.pages.refactor;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;


public class Vulcan extends BasePage {


    public Vulcan(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="(//input[@type='password'])[2]")
    private WebElementFacade password2;

    @FindBy(xpath="(//input[@type='password'])[1]")
    private WebElementFacade password;

    @FindBy(xpath="//input[@type='email']")
    private WebElementFacade email;

    @FindBy(xpath="//span[text()='Зарегистрироваться']")
    private WebElementFacade registerVulcan;

    @FindBy(xpath="(//button[@type='submit'])[2]")
    private WebElementFacade submit;

    @FindBy(xpath="//span[text()='Проверить почту']")
    private WebElementFacade succesForm;

    @FindBy(xpath="span[@class='h_top_userdata-title']")
    private WebElementFacade profile;



    public void fiilVulcanRegistationForm(String emailvalue){
        registerVulcan.waitUntilVisible();
        registerVulcan.click();
        email.waitUntilVisible();
        email.sendKeys(emailvalue);
        password.waitUntilVisible();
        String pass = "q1w2e3r4t5;";
        password.sendKeys(pass);
        password2.waitUntilVisible();
        password2.sendKeys(pass);
        //submit.sendKeys(Keys.RETURN);
        this.evaluateJavascript("$('button[class=\"button button-red50\"]>span:contains(\"Регистрация\")').click()");
        this.waitABit(5000);




    }


}





