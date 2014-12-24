package cityads.ca_thucydides_new_design.pages.WemasterPages;

import cityads.ca_thucydides_new_design.pages.MainPage;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;


public class OfferListPage extends MainPage {
       
	
	public OfferListPage(WebDriver driver) {
		super(driver);
	}
        
        @FindBy(id="unical_id_main_actions_tabs_1")
        public WebElement newLocalOffersTab;
        
        @FindBy(id="menu_top_wm_item_3641925")
        public WebElement offerListLink;
        
        @FindBy(id="unical_id_main_actions_tabs_2")
        public WebElement newRecommendOffersTab;
        
        @FindBy(id="catSelectgeo")
        public WebElement offerListRegionFilter;
        
        @FindBy(id="catSelectcategory")
        public WebElement offerListCategoryFilter;
        
        @FindBy(id="catSelecttools")
        public WebElement offerListToolFilter;
                  
        @FindBy(xpath="//a[contains(concat(' ', normalize-space(@class), ' '), ' submit  _go_to_page ') ]")
        private WebElement goToPageArrow;

        @FindBy(xpath = "(//td[@class='favlock' and descendant::span[@class='icon-lock'] and not(descendant::span[@class='icon-favorites'])])[1]/a")
        private WebElementFacade firstLock;
        
        public void clickGoToPageArrow(){
            element(goToPageArrow).click();
        }
        
        @FindBy(xpath="//*[@id=\"table_wm.web_adv\"]/tbody/tr[1]/td[5]/a")
        public WebElement fistOfferinBlueTable;
        
        public WebElementFacade getFirstOfferInTable(){
            return element(getFirstLineInBlueTable().findElement(By.className("name")).findElement(By.tagName("a")));
        }
 
        public Integer getLocksCountWithJquery(){
            Long l = (Long) this.evaluateJavascript("return $('span[class=\"icon-lock\"]').size();");
            return l.intValue();
        }


        public void offerlistRegionFilterSelectRegions(){
       
            List<WebElement> regions = offerListRegionFilter.findElements(By.name("geo[]"));
            int n = 0;
            while(n<regions.size()/10){
                 offerListRegionFilter.findElements(By.name("geo[]")).get(n).click();
                 n++;
            }
        }
        
        public String offerlistCategoryFilterSelectCategory(){
                 offerListCategoryFilter.findElements(By.name("category[]")).get(1).click();
                 String catName;
                 catName = getDriver().findElement(By.xpath("//*[@id=\"catSelectcategory\"]/div[2]/div/div[1]/div/div/div[2]/div/div[1]/label")).getText();
                 return catName;
            }
        
        public List getCategoryNames(){
            List<WebElement> cat = getDriver().findElements(By.className("category_name"));
            int n =0;
            List<String> catName = null;
            while(n<cat.size()){
                catName.add(getDriver().findElements(By.className("category_name")).get(n).getText());
            
            }
            return catName;
        }
        
        @FindBy(xpath="//form/div[5]/div/div[1]")
        public WebElement offferlistApplyFilterButton;
        
        
        //получить список ссылок на все офферы
        public List<WebElementFacade> getOfferList(){
               
               List<WebElementFacade> trs = getBlueTable().find(By.tagName("tbody")).thenFindAll(By.tagName("tr"));
               List<WebElementFacade> offers = new ArrayList<WebElementFacade>();
               WebElementFacade offerLink;
               
               for(WebElementFacade tr: trs){
                  offerLink  = tr.thenFindAll(By.tagName("td")).get(5).findBy(By.tagName("a"));   
                  offers.add(offerLink);
                  
               }
               
               return offers;
            
        }


    public void checkFirstLock() {
        waitForSpinnerDissapear();
        firstLock.shouldBeVisible();
    }

    public boolean hasLock () {
        return firstLock.isCurrentlyVisible();
    }

}





