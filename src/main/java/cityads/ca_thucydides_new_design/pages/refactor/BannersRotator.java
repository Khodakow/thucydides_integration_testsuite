package cityads.ca_thucydides_new_design.pages.refactor;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;


public class BannersRotator extends BasePage {


    public BannersRotator(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//input[@id='id_el_text_field_name']")
    private WebElementFacade name;

    @FindBy(xpath="//input[@id='id_el_text_field_subaccount']")
    private WebElementFacade subaccount;

    @FindBy(xpath="//label[descendant::input[@id='banner_type_2']]")
    private WebElementFacade imgType;

    public void fillRotatorFormImgBanner(String nameText, String subaccountText) {
        name.waitUntilVisible();
        name.clear();
        name.sendKeys(nameText);
        imgType.waitUntilVisible();
        imgType.click();
        subaccount.waitUntilVisible();
        subaccount.clear();
        subaccount.sendKeys(subaccountText);
    }
}





