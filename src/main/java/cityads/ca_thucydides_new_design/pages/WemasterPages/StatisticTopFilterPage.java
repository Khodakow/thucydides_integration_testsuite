package cityads.ca_thucydides_new_design.pages.WemasterPages;

import cityads.ca_thucydides_new_design.pages.MainPage;
import net.thucydides.core.annotations.findby.By;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class StatisticTopFilterPage extends MainPage {



	public StatisticTopFilterPage(WebDriver driver) {
		super(driver);
	}

    @FindBy(xpath="//span[contains (@class,'add_simple')]")
    private WebElementFacade statAddTopFilterSimple;

    @FindBy(xpath="//div[contains (@class,'ib v-top width-228 margin-left-micro')]/input")
    private WebElementFacade statInputTopFilterSimple;

    @FindBy(xpath="//span[contains(@class,'_apply_ext_filter')]")
    private WebElementFacade statSubmitTopFilter;

    @FindBy(xpath="//div[@class='autocomplete-results absolute back-white border-ccc border-box with-dropdown-shadow _is_open']")
    private WebElementFacade statTopFilterAutoItemsList;

    @FindBy(xpath="//span[@class='_auto_items pointer']")
    private List <WebElement> statTopFilterAutoItemsElements;

    @FindBy(xpath="//div[contains(@class,'_extended_filter_title')]")
    private WebElementFacade filterOpenLink;

    @FindBy(xpath = "//div[contains(@class,'_ext_filter_items_container')]")
    private WebElementFacade filterContainer;

    public void fillTopFilterSimpleInclude(String text, int one, int two){
        waitForSpinnerDissapear();
        filterOpenLink.waitUntilVisible();
        filterOpenLink.click();
        filterContainer.waitUntilVisible();
        statAddTopFilterSimple.waitUntilVisible();
        statAddTopFilterSimple.click();
        chooseInTopFilter(one, two);
        statInputTopFilterSimple.waitUntilVisible();
        statInputTopFilterSimple.sendKeys(text);
        submitTopFilter();
        waitForSpinnerDissapear();
    }

    public void fillTopFilterSimpleIncludeENTER(String text, int one, int two){
        filterOpenLink.waitUntilVisible();
        filterOpenLink.click();
        filterContainer.waitUntilVisible();
        statAddTopFilterSimple.waitUntilVisible();
        statAddTopFilterSimple.click();
        filterContainer.waitUntilVisible();
        chooseInTopFilter(one,two);
        statInputTopFilterSimple.waitUntilVisible();
        statInputTopFilterSimple.sendKeys(text);
        statInputTopFilterSimple.sendKeys(Keys.RETURN);


    }

    public void fillTopFilterAutoItems(String text, int one, int two){
        filterOpenLink.waitUntilVisible();
        filterOpenLink.click();
        filterContainer.waitUntilVisible();
        statAddTopFilterSimple.waitUntilVisible();
        statAddTopFilterSimple.click();
        chooseInTopFilter(one, two);
        statInputTopFilterSimple.waitUntilVisible();
        statInputTopFilterSimple.click();
        this.waitABit(1000);
        statTopFilterAutoItemsList.shouldBeCurrentlyVisible();
        statInputTopFilterSimple.sendKeys(text);
        this.find(By.xpath("//span[@class='_auto_items pointer' and text()='"+text+"']")).shouldBeCurrentlyVisible();
        this.find(By.xpath("//span[@class='_auto_items pointer' and text()='"+text+"']")).click();
        submitTopFilter();

    }


    public void fillTopFilterSimpleExclude(String text, int one, int two){
        filterOpenLink.waitUntilVisible();
        filterOpenLink.click();
        filterContainer.waitUntilVisible();
        statAddTopFilterSimple.waitUntilVisible();
        statAddTopFilterSimple.click();
        clickExcludeTopFilter();
        chooseInTopFilter(one,two);
        statInputTopFilterSimple.waitUntilVisible();
        statInputTopFilterSimple.sendKeys(text);
        submitTopFilter();
    }



    private void clickExcludeTopFilter(){
        getPointersInTopFilter(1).waitUntilVisible();
        getPointersInTopFilter(1).click();
        getDropdownListElement(2).waitUntilVisible();
        getDropdownListElement(2).click();



    }

    private void submitTopFilter(){
        statSubmitTopFilter.waitUntilVisible();
        statSubmitTopFilter.click();
    }


    //Кликает на элемент выбранный нами "number" в выпадающем списке
    public WebElementFacade getDropdownListElement(int number) {
        WebElementFacade element;
        element = this.find(By.xpath("//div[@class='select-list']/a[" + number + "]"));
        return element;
    }
    //Кликает на выбранный нами "number" стрелочку
    public WebElementFacade getPointersInTopFilter(int number){
        WebElementFacade element;
        element = this.find(By.xpath("(//div[@class='select _select']/div[@class='select-choose pointer'])["+number+"]"));
        return element;
    }




    private void chooseInTopFilter(int numberpointer,int numberdropdown){

        getPointersInTopFilter(numberpointer).waitUntilVisible();
        getPointersInTopFilter(numberpointer).click();
        getDropdownListElement(numberdropdown).waitUntilVisible();
        getDropdownListElement(numberdropdown).click();
    }




}





