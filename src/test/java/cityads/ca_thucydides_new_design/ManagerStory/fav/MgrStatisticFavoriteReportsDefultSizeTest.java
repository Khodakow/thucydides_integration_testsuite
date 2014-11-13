package cityads.ca_thucydides_new_design.ManagerStory.fav;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.MainSiteSteps;
import cityads.ca_thucydides_new_design.steps.ManagerSteps.CarcasStepsMgr;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FavoriteSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FrontSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.StatisticsSteps;
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
public class MgrStatisticFavoriteReportsDefultSizeTest {

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
    CarcasStepsMgr carcas;

    @Steps
    FavoriteSteps favorite;

    @Before
    public void setUp() {
        front.loginMgr();
        carcas.go_to_statistic();
    }


    @Test@Title("Проверяем что в избранных офферах 3 элемента по умолчанию")
    public void statisticFavoriteButtonNotVisibleOffersTest() throws Exception{
        favorite.check_size_of_favorite_reports_mgr();

    }





} 