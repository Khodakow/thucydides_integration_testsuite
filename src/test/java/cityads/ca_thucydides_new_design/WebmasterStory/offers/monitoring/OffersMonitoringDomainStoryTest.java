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
public class OffersMonitoringDomainStoryTest extends Constants {


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
    public OffersMonitoringDomainStoryTest(String offerName) {
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
    public  void offers_monitoring_check_offer_site_domain() throws Exception{

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
        steps.wait_for_start_offer_button_is_visible(15);  //ждем пока прогрузится карточка оффера
        String site  =  steps.get_offer_site();
        steps.check_offer_site_has_www(site);   //проверяем что сайт начинается с www



        steps.close_browser();

    }


    }