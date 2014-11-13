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


@Story(TestSuite.Manager.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class MgrStatisticFavoriteReportsTest {

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
    public void setUp(){ front.loginMgr();}



    @Test@Title("Проверка что нет кнопки 'Добавить в избранные отчеты' в отчете по офферам у менедежра")
     public void mgrStatisticOffersFavoriteButtonNotVisibleTest() throws Exception{
        carcas.go_to_mgr_stat_offers();
        favorite.check_favorite_button_is_not_visible();
    }

    @Test@Title("Проверка что нет кнопки 'Добавить в избранные отчеты' в отчете по конверсиям у менедежра")
     public void mgrStatisticConversionsFavoriteButtonNotVisibleTest() throws Exception{
        carcas.go_to_mgr_stat_conversions();
        favorite.check_favorite_button_is_not_visible();
    }

    @Test@Title("Проверка что нет кнопки 'Добавить в избранные отчеты' в отчете по периодам у менедежра")
    public void mgrStatisticPeriodsFavoriteButtonNotVisibleTest() throws Exception{
        carcas.go_to_mgr_stat_periods();
        favorite.check_favorite_button_is_not_visible();
    }

    @Test@Title("Проверка что нет кнопки 'Добавить в избранные отчеты' в отчете по субаккаунтам у менедежра")
    public void mgrStatisticSubaccountsFavoriteButtonNotVisibleTest() throws Exception{
        carcas.go_to_mgr_stat_subaccounts();
        favorite.check_favorite_button_is_not_visible();
    }


} 