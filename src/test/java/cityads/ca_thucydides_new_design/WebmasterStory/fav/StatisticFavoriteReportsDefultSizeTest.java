package cityads.ca_thucydides_new_design.WebmasterStory.fav;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.MainSiteSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.*;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.Statistic.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class StatisticFavoriteReportsDefultSizeTest {

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
    public void setUp() {
        front.login();
        carcas.go_to_standart_statistic_offers();
    }




    @Test
    public void statisticFavoriteButtonNotVisibleOffersTest() throws Exception{
        favorite.check_size_of_favorite_reports();

    }

    @Test
    public void statisticFavoriteButtonNotVisibleConversionTest() throws Exception{
        favorite.check_size_of_standart_reports();
    }




} 