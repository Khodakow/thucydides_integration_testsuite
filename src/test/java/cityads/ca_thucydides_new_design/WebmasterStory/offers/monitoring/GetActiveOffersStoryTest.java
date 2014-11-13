package cityads.ca_thucydides_new_design.WebmasterStory.offers.monitoring;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.pages.db.MySQLWorker;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.OfferCardSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.OfferListSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.TestData;
import net.thucydides.junit.runners.ThucydidesParameterizedRunner;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.Collection;


@Story(TestSuite.WebMaster.Monitoring.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class GetActiveOffersStoryTest extends Constants {

    private String wmName;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;
    
    @Steps
    public OfferListSteps steps;

    @Before
    public void setup(){
        MySQLWorker.deleteAllFromOffersTable(); //чистим таблицу перед обновлением списка офферов
    }

    @Test @WithTagValuesOf({"block:Offers", "role:Webmaster"})
    public  void get_active_offers_from_interface() throws Exception{
        String offerName;

        wmName = steps.get_wm_name();
        steps.wm_login(wmName);
        steps.click_offer_link();
        steps.wait_for_all_spinners_dissapears(90);

        steps.click_web_offers();
        steps.wait_for_all_spinners_dissapears(90);
        steps.wait_for_offers_table_appears(90);
        steps.change_lang_to_en();
        steps.wait_for_all_spinners_dissapears(90);
        steps.executeScript("$('#id_el_input_filter_reset').click()");
        steps.wait_for_all_spinners_dissapears(90);
        steps.wait_for_offers_table_appears(90);

        steps.write_all_active_offers_to_db();

        
        steps.close_browser();
        
    }

}