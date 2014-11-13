package cityads.ca_thucydides_new_design.pages.refactor;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class Goods extends BasePage {


    public Goods(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//div[contains(@class,'_select _sort_field')]")
    private WebElementFacade sortSelect;

    @FindBy(xpath="//div[@class='select-list']")
    private WebElementFacade selectList;

    @FindBy(xpath="//a[@data-id='price:desc']")
    private WebElementFacade priceDesc;

    @FindBy(xpath="//a[@data-id='price:asc']")
    private WebElementFacade priceAsc;

    @FindBy(xpath = "//div[contains(@class,'table-card')]/div/div[@class='v-top margin-left-20']/div/div[1]/div[@class='grid2 margin-top-micro '][2]/div[@class='span2 no-margin-tb']")
    private List<WebElement> prices;

    @FindBy(xpath="//form/div[4]/div[7]/div/div[1]/div[2]/div/div[1]/div[2]/label")
    private WebElementFacade BRL;

    @FindBy(xpath="//div/h2/span")
    private WebElementFacade totalGoods;

    @FindBy(xpath="//a[contains(@class,'_add_tools')]")
    private WebElementFacade createToolGoods;

    @FindBy(xpath="//form[@action='/action.php' and @method='post']")
    private WebElementFacade feedForm;

    @FindBy(xpath = "//input[@id='id_el_text_field_name']")
    private WebElementFacade name;

    @FindBy(xpath = "//*[@id='submit_ok']")
    private WebElementFacade save;

    public void resetFilter(){
        this.evaluateJavascript("$('#id_el_input_filter_reset').click()");
        waitForSpinnerDissapear();
    }

    public void sortByPriseDesc(){
        waitForSpinnerDissapear();
        sortSelect.waitUntilVisible();
        sortSelect.click();
        waitForSpinnerDissapear();
        selectList.waitUntilVisible();
        priceDesc.waitUntilVisible();
        priceDesc.click();
        waitForSpinnerDissapear();
        waitForSpinnerDissapear();
        this.waitABit(5000);
    }

    public void sortByPriseAsc(){
        waitForSpinnerDissapear();
        sortSelect.waitUntilVisible();
        sortSelect.click();
        waitForSpinnerDissapear();
        selectList.waitUntilVisible();
        priceAsc.waitUntilVisible();
        priceAsc.click();
        waitForSpinnerDissapear();
        this.waitABit(5000);
    }

    public ArrayList<Float> getPrices(){
        ArrayList<Float> list = new ArrayList<Float>();
        for(WebElement elem : prices){
            list.add(Float.valueOf(elem.getText().replace("'","").replace(" RUB","").replace("BRL","").replace("USD","").trim()));
        }
        return list;
    }

    public void clickBRLcheckbox(){
        BRL.waitUntilVisible().click();
    }

    public int getTotalGoods(){
        System.out.println(totalGoods.getText());
        return Integer.valueOf(totalGoods.getText().replaceAll("'",""));
    }


    public void createFeed(String feedName) {
        waitForSpinnerDissapear();
        createToolGoods.waitUntilVisible();
        createToolGoods.click();
        waitForSpinnerDissapear();
        feedForm.waitUntilVisible();
        name.waitUntilVisible();
        name.clear();
        name.sendKeys(feedName);
        save.click();
        waitForSpinnerDissapear();
    }
}





