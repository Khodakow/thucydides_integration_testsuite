package cityads.ca_thucydides_new_design.WebmasterStory.offers.monitoring;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.pages.db.MySQLWorker;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.OfferCardSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.TestData;
import net.thucydides.junit.runners.ThucydidesParameterizedRunner;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Concurrent(threads = "50")
@Story(TestSuite.WebMaster.Monitoring.class)
@RunWith(ThucydidesParameterizedRunner.class)
@WithTag(name="Webmaster Tests")
public class OffersMonitoringTermsStoryTest extends Constants {


    private String offerName;

    @TestData
    public static Collection<Object[]> testData() {
        List<Object[]> list = MySQLWorker.getAllOffersFromDB();
        Collection<Object[]> offers = list;
        return offers;
/*      return Arrays.asList(new Object[][]{
                {"003.RU"},
                //{"Alba"}
        });*/
    }
    public OffersMonitoringTermsStoryTest(String offerName) {
        this.offerName = offerName;
    }

    @Qualifier
    public String getQualifier() {
        return offerName;
    }

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public OfferCardSteps steps;

    @After
    public void close_driver(){
        steps.getDriver().quit();
    }

    @BeforeClass
    public static void setup(){

    }

    @Test
    @WithTagValuesOf({"block:Monitoring", "role:Webmaster"})
    public  void offers_monitoring_terms() throws Exception{

        String wmName = steps.get_wm_name();
        steps.wm_login(wmName);
        steps.click_offer_link();
        steps.wait_for_all_spinners_dissapears(90);
        steps.click_web_offers();
        steps.wait_for_all_spinners_dissapears(180);
        steps.wait_for_offers_table_appears(90);

        steps.executeScript("$('#id_el_input_filter_reset').click()");     //сбрасываем все фильртры чтобы было больше офферов
        steps.wait_for_all_spinners_dissapears(90);
        steps.fill_in_search_filter(offerName);             //кликаем пейджер до тех пор пока не появится оффер на экране
        steps.click_apply_right_filter();
        steps.wait_for_all_spinners_dissapears(300);
        steps.click_offer_by_name(offerName);
        steps.wait_for_start_offer_button_is_visible(15);
        steps.click_offer_terms_tab_by_id();
        
        
        
        
        //1 таб
        steps.wait_for_all_spinners_dissapears(300);
        steps.wait_for_h1_title_appears(offerName, 30);
        steps.wait_for_offerterms_tabs_appears(30);
        steps.check_blue_table_is_visible();
        int stringsNumber = Integer.valueOf(steps.get_Blue_table_number_lines());
        steps.check_blue_table_has_data();
        steps.check_value_gteater_then_min(stringsNumber, 1);
        
        
        //2 таб
        steps.click_offer_terms_transactions();
        steps.wait_for_all_spinners_dissapears(300);
        steps.wait_for_h1_title_appears(offerName, 30);
        steps.wait_for_offerterms_tabs_appears(30);
        steps.check_blue_table_is_visible();
        int stringsNumber2 = Integer.valueOf(steps.get_Blue_table_number_lines());
        steps.check_blue_table_has_data();
        steps.check_value_gteater_then_min(stringsNumber2, 1);
        
        
        
        //3 таб
        steps.click_offer_terms_traffic_policy();
        steps.wait_for_all_spinners_dissapears(300);
        steps.wait_for_h1_title_appears(offerName, 30);
        steps.wait_for_offerterms_tabs_appears(30);
        steps.check_blue_table_is_visible();
        int stringsNumber3 = Integer.valueOf(steps.get_Blue_table_number_lines());
        steps.check_blue_table_has_data();
        steps.check_value_gteater_then_min(stringsNumber3, 1);
        
        
        
        //4 таб
        steps.click_offer_terms_notice_periods();
        steps.wait_for_all_spinners_dissapears(300);
        steps.wait_for_h1_title_appears(offerName, 30);
        steps.wait_for_offerterms_tabs_appears(30);
        steps.check_blue_table_is_visible();
        int stringsNumber4 = Integer.valueOf(steps.get_Blue_table_number_lines());
        steps.check_blue_table_has_data();  
        steps.check_value_gteater_then_min(stringsNumber4, 1);
               
        
        
        //payments
        
        
        steps.click_offer_payments_tab_by_id();
        steps.wait_for_all_spinners_dissapears(300);
        steps.wait_for_h1_title_appears(offerName, 30);
        steps.check_blue_table_is_visible();
        int stringsNumber5 = Integer.valueOf(steps.get_Blue_table_number_lines());
        steps.check_blue_table_has_data();  
       
        
        
        steps.close_browser();

    }


    }