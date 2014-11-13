/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.steps.WebmasterSteps;

import cityads.ca_thucydides_new_design.pages.MainPage;
import cityads.ca_thucydides_new_design.pages.WemasterPages.MyDomainsPage;
import cityads.ca_thucydides_new_design.pages.WemasterPages.NewsPage;
import cityads.ca_thucydides_new_design.steps.SetupSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import org.junit.Assert;

/**
 *
 * @author s.lugovskiy
 */
public class MyDomainsSteps extends SetupSteps {

    MyDomainsPage page;
    
    public MyDomainsSteps(Pages pages) {
        super(pages);
    }
   
    @Step
    public void fill_domain_field(String domain){
        page.getDomainInputField().click();
        page.getDomainInputField().clear();
        page.getDomainInputField().sendKeys(domain);
        
    }
    
    @Step
    public void check_first_string_in_blue_table_has_domain_name(String domainName, String actualDomainName){
        
        Assert.assertEquals(domainName, actualDomainName);
    }
    
    @Step
    public String get_domain_name_in_first_record_in_blue_table(){
        String domain = get_column_text_in_blue_table_first_line(2);
        return domain;
    }
    
    @Step
    public void try_to_close_alert(){
        try{
            getDriver().switchTo().alert().accept();
        }
        catch(Exception e){
            
        }
    }
    
    
   
    
    
}
