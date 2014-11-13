package cityads.ca_thucydides_new_design.WebmasterStory.tools;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.OfferCardSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.CarcasSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.CardSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FrontSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.TableSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.sql.Connection;


@Story(TestSuite.WebMaster.OfferInstruments.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class OfferInstrumentsShortLinkStoryTest{

     private Connection con;
     private String wmName;
     private String offerName;
     private String actualOfferName;
     private String code;
     private String offerSite;
     private String offerSiteparsed;
     private String actualSite;
     

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;
    
    @Steps
    public OfferCardSteps steps;

    @Steps
    FrontSteps front;

    @Steps
    CarcasSteps carcas;

    @Steps
    TableSteps table;

    @Steps
    CardSteps card;

 
    @Test @WithTagValuesOf({"block:Instruments", "role:Webmaster"})
    public  void wm_offer_short_link_test() throws Exception{


        front.login();
        carcas.go_to_web_offers();
        offerName = steps.get_first_offer_name();
        table.click_first_aviable_offer();
        steps.wait_for_start_offer_button_is_visible(25);
        steps.wait_for_h1_title_appears(offerName, 160);
        steps.check_h1_page_title(offerName);
        offerSite = steps.get_offer_site().replaceAll("\\s+","").trim();
        String offerHost = steps.getTopDomain(offerSite);
        System.out.println(offerHost);


        card.go_to_instrument_tab();
        steps.check_links_table_is_present();
        steps.click_get_offer_link();
        steps.wait_for_all_spinners_dissapears();
        steps.click_short_link_button();
        steps.wait_for_all_spinners_dissapears();
        code = steps.get_code_from_popup_textarea();
        steps.check_script_code(code);
        actualOfferName = steps.get_offer_name_from_popup();
        steps.check_offer_name_in_popoup(offerName, actualOfferName);
        steps.open_url(code);
        steps.waitAjax(5000);
        actualSite = steps.getCurrentUrl();

        String actualHost = steps.getTopDomain(actualSite);
        System.out.println(actualHost);

        steps.check_offer_site_contains_offer_domain(actualHost,offerHost);
        
        steps.close_browser();
        
    }
    
    
    
    
 
    

    
} 