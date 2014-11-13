package cityads.ca_thucydides_new_design.pages.refactor;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Pager extends BasePage {

    private Table table;

    public Pager(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//a[@id='pager_settings_menu']")
    private WebElementFacade settings;

    @FindBy(xpath="//div[contains(@class,'contextmenu')]")
    private WebElementFacade contextMenu;

    @FindBy(xpath="//div[contains(@class,'select micro')]")
    private WebElementFacade selectChoose;

    @FindBy(xpath="//div[@class='select-list']")
    private WebElementFacade selectList;

    @FindBy(xpath="//button[@id='pager_setting_menu_submit']")
    private WebElementFacade submit;

    @FindBy(xpath="//input[@id='pager_go_to_page']")
    private WebElementFacade goToPage;

    @FindBy(xpath="//a[contains(@class,'_go_to_page')]")
    private WebElementFacade goToPageArrow;

    private void selectNumberOfRecords(int number){   //10 20 50 100
        selectList.find(By.linkText(String.valueOf(number))).click();
    }

    public void setupTableWithNumberRecord(int number){
        if(!getDriver().findElement(By.className("blue_table")).getText().contains("данных")) {

            settings.waitUntilVisible();
            waitForSpinnerDissapear();
            settings.click();
            contextMenu.waitUntilVisible();
            selectChoose.waitUntilVisible();
            selectChoose.click();
            selectList.waitUntilVisible();
            selectNumberOfRecords(number);
            submit.waitUntilVisible();
            submit.click();
            this.waitABit(5000);
            waitForSpinnerDissapear();
            waitOpacity();
        }

    }

    public void goToPage(int number) {
        waitForSpinnerDissapear();
        goToPage.waitUntilVisible();
        goToPage.clear();
        goToPage.sendKeys(String.valueOf(number));
        goToPageArrow.waitUntilVisible();
        goToPageArrow.click();
        waitOpacity();
        waitForSpinnerDissapear();

    }
}





