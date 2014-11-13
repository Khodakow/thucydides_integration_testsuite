package cityads.ca_thucydides_new_design.WebmasterStory.bugs;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.StatisticSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.*;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.Bugs.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class StatHavingbugTest {

    public String wmName;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public StatisticSteps steps;
    @Steps
    FrontSteps front;
    @Steps
    StatisticsSteps stat;
    @Steps
    CarcasSteps carcas;
    @Steps
    TableSteps table;
    @Steps
    PopupSteps popup;

    @Test @Screenshots(onlyOnFailures=false)
    public void statlegendplusadditionalTest() throws Exception{

        front.login();
        carcas.go_to_statistic_by_conversion_by_segments_byTypes();
        table.check_all_h1_by_click_in_links_blue_table();
        table.show_additional_parametr_by_name("Категории");
        popup.check_popup_is_not_displayed();
        steps.close_browser();

    }





}