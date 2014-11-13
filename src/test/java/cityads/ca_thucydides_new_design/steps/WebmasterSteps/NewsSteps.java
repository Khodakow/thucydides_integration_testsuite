/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.steps.WebmasterSteps;

import cityads.ca_thucydides_new_design.pages.MainPage;
import cityads.ca_thucydides_new_design.pages.WemasterPages.NewsPage;
import cityads.ca_thucydides_new_design.steps.SetupSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import org.junit.Assert;

/**
 *
 * @author s.lugovskiy
 */
public class NewsSteps extends SetupSteps {

    NewsPage newsPage;
    
    public NewsSteps(Pages pages) {
        super(pages);
    }
    
    @Step
    public void check_news_count(){
        Assert.assertTrue(newsPage.get_news_count()>1);
    }
    
    @Step
    public void check_news_select_categories_is_displayed(){
        Assert.assertTrue(newsPage.newsSelectContainer.isDisplayed());
    }
    
    @Step
    public void click_first_news(){
        newsPage.firstNewsLink.click();
    }
    
    
   
    
    
}
