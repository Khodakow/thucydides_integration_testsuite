package cityads.ca_thucydides_new_design.WebmasterStory.bugs;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.MainSiteSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.StatisticSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.*;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;


@Story(TestSuite.WebMaster.Statistic.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class StatisticDuplicateMainParaterColumnTest {

    public String wmName;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public MainSiteSteps steps;


    @Steps
    FrontSteps front;
    @Steps
    StatisticsSteps stat;
    @Steps
    StatisticSteps ssteps;
    @Steps
    CarcasSteps carcas;
    @Steps
    TableSteps table;
    @Steps
    ConsoleSteps console;

    @Before
    public void setUp(){
        front.login();
    }


    @Test
    public void statOffersDuplicateMainParameterTest() throws Exception{

        carcas.go_to_statistic_by_conversion_by_segments_byOffers();
        table.setup_number_of_records(100);
        ArrayList<String> mainParams = table.get_offers_mainparam();
        table.check_column_for_unique_values(mainParams);
    }

    @Test
    public void statVertikaliDuplicateMainParameterTest() throws Exception{

        carcas.go_to_statistic_by_conversion_by_segments_byVerticals();
        table.setup_number_of_records(100);
        ArrayList<String> mainParams = table.get_vertikals_mainparam();
        table.check_column_for_unique_values(mainParams);

    }

    @Test
    public void statPromoSizeDuplicateMainParameterTest() throws Exception{

        carcas.go_to_statistic_by_conversion_by_tools_bySizeofPromo();
        table.setup_number_of_records(100);
        ArrayList<String> mainParams = table.get_promosize_mainparam();
        table.check_column_for_unique_values(mainParams);

    }


    
 
    

    
} 