package cityads.ca_thucydides_new_design.WebmasterStory.bugs;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.ManagerSteps.CarcasStepsMgr;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.OfferListSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.*;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.Manager.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="bugs")
public class Bugs49955ManagerXmlFileStoryTest {



    @Managed(uniqueSession = false)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public OfferListSteps steps;
    @Steps
    public CarcasStepsMgr carcas;
    @Steps
    public FrontSteps front;
    @Steps
    public FilterSteps filter;
    @Steps
    public CouponsSteps coupons;
    @Steps
    public TableSteps table;
    @Steps
    public GoodsSteps goods;
    @Steps
    public GlobalFilterSteps global;
    @Steps
    public PopupSteps popup;
    @Steps
    public StatisticsSteps stat;


    
    @Test@Title("Проверка глобального фильтра у менеджера по офису Бразилия")
    @Screenshots(onlyOnFailures = false)
    public void manager49955GlobalFilterStoryTest(){

        front.loginMgr();
        carcas.go_to_mgr_stat_offices();
        global.set_office_brazil();
        popup.check_popup_is_not_displayed();
        steps.close_browser();

    }
    @Test@Title("Проверка выгрузки в эксель у менеджера с глобальным фильтром по офису Бразилия")
    @Screenshots(onlyOnFailures = false)
    public void manager49955XMLFileStoryTest(){

        front.loginMgr();
        carcas.go_to_mgr_stat_offices();
        global.set_office_brazil();
        stat.export_xls();
        stat.export_spinner_not_visible();
        popup.check_popup_is_not_displayed();
        steps.close_browser();


    }
}
