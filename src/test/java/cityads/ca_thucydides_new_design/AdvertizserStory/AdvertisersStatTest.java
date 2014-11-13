package cityads.ca_thucydides_new_design.AdvertizserStory;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.BaseSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.CarcasSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.ConsoleSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FrontSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.TableSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Collections;


@Story(TestSuite.Advertiser.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Advertiser Tests")
public class AdvertisersStatTest {

    public String wmName;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public BaseSteps steps;
    @Steps
    TableSteps table;
    @Steps
    public CarcasSteps carcas;
    @Steps
    public ConsoleSteps console;


    @Steps
    FrontSteps front;

    @Before
    public void setUp(){
        front.loginAdv();
        carcas.go_to_statistic_by_offers_advertizer();
    }


    @Test
    public void advertiserOffersStatTest() throws Exception{
        steps.check_fatal_errors();
        ArrayList<String> statOffers = table.get_offers_mainparam();
        carcas.go_to_offers_advertiser();
        ArrayList<String> offers = table.get_offers_column_advertiser();
        Collections.sort(statOffers);
        Collections.sort(offers);
        steps.check_list_contains_list(offers,statOffers);

    }
    

    

    
} 