package cityads.ca_thucydides_new_design.pages.refactor;

import net.thucydides.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;


public class Favorite extends BasePage {


    public Favorite(WebDriver driver) {
        super(driver);
    }


    private Popup popup;
    private Form form;
    private Welcome welcome;
    private Table table;

    @FindBy(xpath = "//a[contains(@class,'favorite')]")
    private WebElementFacade favoriteButton;
    @FindBy(xpath = "//a[contains(@class,'already-favorite')]")
    private WebElementFacade alreadyFavoriteButton;

    @FindBy(xpath = "//a[following-sibling::a[@id='_left_menu_id_436601152'] and preceding-sibling::a[@id='_left_menu_id_436571152'] and contains(@id,'left_menu')]")
    private List<WebElement> favoriteReportsLinks;

    @FindBy(xpath = "//a[following-sibling::a[@id='_left_menu_id_436421152'] and preceding-sibling::a[@id='_left_menu_id_436391152'] and contains(@id,'left_menu')]")
    private List<WebElement> favoriteReportsLinksMgr;

    @FindBy(xpath = "//a[following-sibling::a[@id='_left_menu_id_436571152'] and preceding-sibling::a[@id='_left_menu_id_436541152'] and contains(@id,'left_menu')]")
    private List<WebElement> standartReportsLinks;


    public void checkFavoriteButtonIsNotVisible(){
        waitForSpinnerDissapear();
        favoriteButton.shouldNotBeVisible();
    }

    public void checkAlreadyFavoriteButtonIsVisible(){
        waitForSpinnerDissapear();
        favoriteButton.isCurrentlyVisible();

    }

    public void clickFavoriteButton(){
        waitForSpinnerDissapear();
        favoriteButton.waitUntilVisible();
        favoriteButton.click();
        waitABit(2500);
        waitForSpinnerDissapear();

    }
    public ArrayList<String> getFavoriteReportInMenu(){
        ArrayList<String> razdelli = new ArrayList<String>();
        for(WebElement elem: favoriteReportsLinks){
            razdelli.add(elem.getText());
        }
        return razdelli;

    }

    public ArrayList<String> getFavoriteReportInMenuMgr(){
        ArrayList<String> razdelli = new ArrayList<String>();
        for(WebElement elem: favoriteReportsLinksMgr){
            razdelli.add(elem.getText());
        }
        return razdelli;

    }


    public void checkSizeOfFavoriteReports() {
        form.waitForSpinnerDissapear();
        int size = favoriteReportsLinks.size();
        Assert.assertEquals("Количество favotite reorts "+size+", не равно 3, ",size,3);

    }

    public void checkSizeOfFavoriteReportsMgr() {
        form.waitForSpinnerDissapear();
        int size = favoriteReportsLinksMgr.size();
        Assert.assertEquals("Количество favotite reorts "+size+", не равно 3, ",size,3);

    }

    public void checkSizeOfStandartReports() {
        form.waitForSpinnerDissapear();
        int size = standartReportsLinks.size();
        Assert.assertEquals("Количество standart reorts "+size+", не равно 5, ",size,5);

    }

}





