package cityads.ca_thucydides_new_design.WebmasterStory.refactor;

import cityads.ca_thucydides_new_design.pages.refactor.DataGenerator;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.MainSiteSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.CarcasSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FilterSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FormSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FrontSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.OfferList.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class OffersFilter53933Test {

    public String wmName;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public MainSiteSteps steps;


    @Steps
    public CarcasSteps carcas;

    @Steps
    public FormSteps form;

    @Steps
    public FrontSteps front;

    @Steps
    public FilterSteps filter;


    @Test@Screenshots(onlyOnFailures = false)
    @Title("НЕ РАБОТАЕТ КНОПКА СБРОСА ПОСЛЕ СОХРАНЕНИЯ ФИЛЬТРА 53933")
    public void offersFilter53933Test() throws Exception{

        String name = DataGenerator.getRandomNameWithDate();

        front.login();
        carcas.go_to_web_offers();
        filter.click_checkbox_in_filter(4,1);
        filter.submit_filter();
        filter.save_filter(name);
        filter.reset_filter();


    }




} 