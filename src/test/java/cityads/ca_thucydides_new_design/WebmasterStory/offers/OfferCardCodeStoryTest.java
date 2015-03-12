package cityads.ca_thucydides_new_design.WebmasterStory.offers;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.OfferCardSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.CarcasSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FilterSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FrontSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.TableSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.sql.Connection;


@Story(TestSuite.WebMaster.OfferCardCode.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class OfferCardCodeStoryTest extends Constants {

     private Connection con;
     private String wmName;
     private String offerName;
     private String code;
     private String offerSite;
     
     
    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;
    
    @Steps
    public OfferCardSteps steps;
    @Steps
    public FilterSteps filter;
    @Steps
    public FrontSteps front;
    @Steps
    public CarcasSteps carcas;
    @Steps
    public TableSteps table;
    
 
    @Test @WithTagValuesOf({"block:Offers", "role:Webmaster"})
    public  void wm_offer_card_code_test() throws Exception{
        


        
        front.login();
        carcas.go_to_web_offers();
        offerName = table.get_first_aviable_offer_name();
        table.click_first_aviable_offer();

        steps.wait_for_start_offer_button_is_visible(15);
        steps.check_description_is_visible();
        offerSite = steps.get_offer_site().replace("www.","").replace("http://","").trim();
          
        steps.click_add_offer_link();
        steps.waitABit(3000);
        steps.check_offercard_popup_is_displayed();
        steps.click_add_link_popup_button();
        steps.waitABit(5000);
        steps.wait_for_all_spinners_dissapears(120);
        code = steps.get_code_from_popup_textarea();
        steps.check_script_code(code);
        steps.open_url(code);
        steps.check_fatal_errors();
        //String newHost = steps.getUrlHost(steps.getCurrentUrl().replace("www.",""));
        //steps.check_values_are_equals(offerSite,newHost);
        steps.close_browser();
        
    }
        

    
 
    

    
} 