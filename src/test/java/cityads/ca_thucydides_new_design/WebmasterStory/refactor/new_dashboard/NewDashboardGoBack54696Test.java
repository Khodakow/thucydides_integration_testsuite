package cityads.ca_thucydides_new_design.WebmasterStory.refactor.new_dashboard;

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


@Story(TestSuite.WebMaster.Svodnaya.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class NewDashboardGoBack54696Test {

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
    CarcasSteps carcas;
    @Steps
    NewDashboardSteps newdash;
    @Before
    public void setUp(){
        front.login();
        carcas.go_to_statistic();
        carcas.go_to_dashboard();
    }

    @Test
    @Title("Проверка присутствия элементов на сводной после возвращения на нее из другого раздела")
    public void dashboardGoBacklinkTest() throws Exception{
        newdash.checkStructure();
    }

    @Test
    @Title("Проверка работы ссылки -=все офферы=- после возвращения на нее из другого раздела")
    public void dashboardAllOffersGoBacklinkTest() throws Exception{
        newdash.checkStructure();
    }


    
} 