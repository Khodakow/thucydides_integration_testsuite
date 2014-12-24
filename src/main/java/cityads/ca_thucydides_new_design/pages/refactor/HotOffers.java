package cityads.ca_thucydides_new_design.pages.refactor;

import net.thucydides.core.annotations.findby.By;
import net.thucydides.core.annotations.findby.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class HotOffers extends BasePage {


    public HotOffers(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//div[@id='hotOffersSlider']/div/div[@class='_item']/div[@class='offer-card']/div[@class='offer-info']/div[@class='offer-props']")
    private WebElement offerProps;

    @FindBy(xpath="//div[@id='hotOffersSlider']/div/div[@class='_item']/div[@class='offer-card']/div[@class='offer-card-name']/a")
    private WebElement firstHotOffer;

    @FindBy(xpath="//div[@id='hotOffersSlider']/div/div[@class='_item']/div[@class='offer-card']/div[@class='offer-info']/div[contains(@class,'offer-stats')]/div[not(@class)]/div[@class='caption']")
    private List<WebElement> offerTooltips;

    @FindBy(xpath="(//div[@class='_slide_switcher left']/div)[1]")
    private WebElement sliderFirst;


    public Map<String, String> getHotOffersFields(){
        Map<String, String> fields = new HashMap<String,String>();

        String status = offerProps.findElements(By.tagName("div")).get(2).getText();
        String site = offerProps.findElements(By.tagName("div")).get(3).getText();
        String date = offerProps.findElements(By.tagName("div")).get(4).getText();
        String cookieLTV = offerProps.findElements(By.tagName("div")).get(5).getText();
        String type = offerProps.findElements(By.tagName("div")).get(0).getText();
        String vertical = offerProps.findElements(By.tagName("div")).get(1).getText();
        String retarget = offerProps.findElements(By.tagName("div")).get(6).getText();

        fields.put("status", status);
        fields.put("site", site);
        fields.put("date", date);
        fields.put("cookieLTV", cookieLTV);
        fields.put("vertical", vertical);
        fields.put("type", type);
        fields.put("retarget", retarget);

        return fields;
    }

    public int getHotOffersTooltipsNumber() {
        return offerTooltips.size();
    }

    public String goToFirstHotOffer(){
        waitForSpinnerDissapear();
        String offer =  firstHotOffer.getText();
        firstHotOffer.click();
        waitForSpinnerDissapear();
       return offer;
    }

    public void clickFirstSlider(){
        waitForSpinnerDissapear();
        sliderFirst.click();
    }
}





