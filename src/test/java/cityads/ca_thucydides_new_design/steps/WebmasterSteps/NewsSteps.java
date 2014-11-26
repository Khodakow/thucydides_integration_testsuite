/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.steps.WebmasterSteps;

import cityads.ca_thucydides_new_design.pages.WemasterPages.NewsPage;
import cityads.ca_thucydides_new_design.steps.SetupSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;

import static org.junit.Assert.assertTrue;

/**
 *
 * @author s.lugovskiy
 */
public class NewsSteps extends SetupSteps {

    NewsPage news;
    
    public NewsSteps(Pages pages) {
        super(pages);
    }

    @Step("Проверяем что новостей в списке отображается >0")
    public void check_news_count(){
        assertTrue(news.getNewsCount()>0);
    }

    @Step("Получаем название первой новости")
    public String get_first_news_name(){
        return news.getFirstNewsName();
    }

    @Step("Клик по первой новости")
    public void click_first_news(){
        news.clickFirstNews();
    }

    @Step("Поулчаем текст h1 заголовка страницы ")
    public String get_h1_text(){
        return news.getH1();
    }



    
   
    
    
}
