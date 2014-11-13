package cityads.ca_thucydides_new_design.WebmasterStory.fav;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.MainSiteSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.CarcasSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FavoriteSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FrontSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.StatisticsSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;


@Story(TestSuite.WebMaster.Statistic.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class StatisticFavoriteReportsAddTest {

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
    CarcasSteps carcas;

    @Steps
    FavoriteSteps favorite;

    @Before
    public void setUp(){ front.login();}



    @Test
    public void statisticFavoriteButtonNotVisibleOffersTest() throws Exception{
    carcas.go_to_standart_statistic_offers();

    carcas.go_to_first_advanced_report_not_realtime();
    ArrayList menu1 = favorite.get_favorite_reports_links();
    favorite.click_add_report();
    ArrayList menu2 = favorite.get_favorite_reports_links();
    steps.wait_for_all_spinners_dissapears();
    steps.check_lists_are_not_equals(menu1,menu2);

    }

    @After
    public void clean(){
        favorite.click_add_report();
    }




} 