package cityads.ca_thucydides_new_design.pages.refactor;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Goods extends BasePage {


    public Goods(WebDriver driver) {
        super(driver);
    }

    private Popup popup;

    @FindBy(xpath="//div[contains(@class,'_select _sort_field')]")
    private WebElementFacade sortSelect;

    @FindBy(xpath="//div[@class='select-value pointer']")
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

    @FindBy(xpath = "//div[contains(@class,'table-card')]")
    private List<WebElement> goodsCards;

    @FindBy(xpath = "(//a[contains(@class,'button submit code')])[1]")
    private WebElementFacade getCode;

    @FindBy(xpath = "(//div[contains(@class,'table-card')]/div/div[2]/div/a)[1]")
    private WebElementFacade landingUrl;

    @FindBy(xpath = "//div[contains(@class,'_show_all_images pointer')]")
    private List<WebElement> images;

    @FindBy(xpath = "//img[contains(@src,'cnt.my')]")
    private WebElementFacade fullscreenImage;


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
/*        sortSelect.waitUntilVisible();
        sortSelect.click();*/
        evaluateJavascript("$('._sort_field').trigger('click')");
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

    public String getFirstGoodLink() {
        getCode.waitUntilVisible();
        getCode.click();
        popup.waitPopup();
        return popup.getCodeFromTextarea();

    }

    public String getFirstLandingUrl(){
        return (String) this.evaluateJavascript("return $('div[class*=\"table-card\"]>div>div>div>a').attr('href')");
    }

    public ArrayList<String> getAllImagesUrls() {
        ArrayList<String> urls = new ArrayList<String>();
        for (WebElement image : images){
            String style = image.getAttribute("style");
            Pattern pattern = Pattern.compile("url\\((.+?)\\)");
            Matcher matcher = pattern.matcher(style);
            matcher.find();
            String url = matcher.group(1).trim();
            urls.add(url);
        }
        return urls;
    }

    public void checkImageDisplayed() {
        fullscreenImage.shouldBeCurrentlyVisible();
     }
}





