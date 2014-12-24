package cityads.ca_thucydides_new_design.WebmasterStory.tools;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.OfferCardSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.CarcasSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FilterSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FrontSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.OfferInstruments.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class OfferInstrumentsLockedStoryTest{


     private String wmName;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;
    
    @Steps
    public OfferCardSteps steps;
    
    @Steps
    public FilterSteps filter;
    @Steps
    public CarcasSteps carcas;
    @Steps
    public FrontSteps front;

 
    @Test @WithTagValuesOf({"block:Instruments", "role:Webmaster"})
    @Title("Проверка на наличие недоступных офферов")
    public  void wm_offer_instruments_locked_offer_test() throws Exception{
        

        front.login();
        carcas.go_to_web_offers();
        filter.reset_filter();
        filter.submit_filter();
        steps.sort_blue_table_by_first_th();
        steps.wait_for_all_spinners_dissapears(60);
        steps.sort_blue_table_by_first_th();
        steps.wait_for_all_spinners_dissapears(60);
        steps.count_locks_with_jquery();
        steps.click_first_offer();

        steps.wait_for_start_offer_button_is_visible(15);
        steps.check_description_is_visible();
        steps.click_add_offer_link();
        steps.check_popup_is_currently_visible();


        steps.close_browser();
        
    }
    
    
    
    
 
    

    
} 