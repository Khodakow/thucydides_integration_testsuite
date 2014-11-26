package cityads.ca_thucydides_new_design.WebmasterStory.offers;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.OfferCardSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.CarcasSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.CardSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FrontSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.PopupSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.sql.Connection;


@Story(TestSuite.WebMaster.OfferCard.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class AddLockedOfferStoryTest extends Constants {

     private Connection con;
     private String wmName;
     private String offerName;
     private String code;
     

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;
    
    @Steps
    public OfferCardSteps steps;
    @Steps
    public PopupSteps psteps;
    @Steps
    public CardSteps csteps;
    @Steps
    public FrontSteps fsteps;
    @Steps
    public CarcasSteps carcassteps;
    
    
    @Test @WithTagValuesOf({"block:Offers", "role:Webmaster"})@Title("Проверка, что po-up с заблокированным оффером пояявился")
    public  void add_locked_offer_test() throws Exception{
        
        fsteps.login();
        carcassteps.go_to_web_offers();
        steps.wait_for_offers_table_appears(25);
        steps.check_fatal_errors();
        steps.Sort_blue_table_by_first_th();
        steps.wait_for_all_spinners_dissapears(60);

        steps.wait_for_all_spinners_dissapears(60);
        if (steps.hasLockOffer()){

            steps.click_first_offer();
            steps.wait_for_all_spinners_dissapears(60);
            csteps.start_work_with_offer();
            psteps.checkLockedPopuoIsvisible();



        }

        steps.close_browser();
  }
    
 
    

    
} 