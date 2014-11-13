/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.steps.WebmasterSteps;

import cityads.ca_thucydides_new_design.pages.WemasterPages.GoodsCategoryPage;
import cityads.ca_thucydides_new_design.steps.SetupSteps;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import org.junit.Assert;

/**
 *
 * @author s.lugovskiy
 */
public class GoodsCategorySteps extends GoodsCatalogSteps {

    public GoodsCategorySteps(Pages pages) {
        super(pages);
    }

    GoodsCategoryPage page;

    @Step
    public int get_categories_items_count() {
        int count = page.getCategoriesItemsCount();
        return count;
    }
    
     @Step
     public void check_categories_titles(int expectedCount, int count){
         Assert.assertTrue(expectedCount<=count);
        }
   
    
   
    
}
