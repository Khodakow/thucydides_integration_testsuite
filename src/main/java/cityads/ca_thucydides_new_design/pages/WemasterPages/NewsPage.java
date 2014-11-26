package cityads.ca_thucydides_new_design.pages.WemasterPages;

import cityads.ca_thucydides_new_design.pages.MainPage;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class NewsPage extends MainPage {
       
	
	public NewsPage(WebDriver driver) {
		super(driver);
	}

    @FindBy(xpath="//div[@id='mainNews']")
    private WebElementFacade newsContainer;

    @FindBy(xpath="//div[@id='mainNews']/div[contains(@class,'margin-top-small')]")
    private List<WebElement> news;

    @FindBy(xpath="//div[@id='mainNews']/div[contains(@class,'margin-top-small')]/div")
    private List<WebElement> newsLinks;

    @FindBy(xpath = "//div/h1")
    private WebElementFacade h1;

    public String getH1(){
        h1.waitUntilVisible();
        return h1.getText();
    }


    public int getNewsCount(){
        return newsLinks.size();
    }

    public String getFirstNewsName(){
        return news.get(0).getText();
    }

    public void clickFirstNews(){
        waitForSpinnerDissapear();
        element(news.get(0)).waitUntilVisible();
        news.get(0).click();
        waitForSpinnerDissapear();
    }


}





