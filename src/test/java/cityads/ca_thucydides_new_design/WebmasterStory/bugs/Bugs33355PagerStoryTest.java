package cityads.ca_thucydides_new_design.WebmasterStory.bugs;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.SetupSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.BugsSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.DownloadsSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.OfferListSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.StatisticSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.CarcasSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FrontSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.Bugs.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="pager bugs")
public class Bugs33355PagerStoryTest{



    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    String dateFirstPage;
    String dateSecondPage;



    @Steps
    public OfferListSteps steps;


    @Steps
    public DownloadsSteps ds;

    @Steps
    public BugsSteps bs;

    @Steps
    public SetupSteps ss;

    @Steps
    public StatisticSteps stat;


    @Steps
    public FrontSteps front;

    @Steps
    CarcasSteps carcas;

    @Test
    @Title("Курс обмена пейджинг 33355")
    public void check_33355_exchange() throws Exception{
        front.login();
        carcas.go_to_exchange();
        dateFirstPage = bs.get_currency_date_value();  //дата на первой странице в первой ячейке таблицы
        bs.wait_for_all_spinners_dissapears(90);
        bs.click_go_next_page();
        bs.wait_for_all_spinners_dissapears(90);
        bs.check_fatal_errors();
        dateSecondPage = bs.get_currency_date_value(); //дата на второй странице в первой ячейке таблицы (должна отличаться от даты на первой странице)
        bs.check_string_has_changed(dateSecondPage, dateFirstPage);
        bs.close_browser();


    }

    @Test
    @Title("Офферы пейджинг 33355")// офферы пейджер
    public void check_33355_offers() throws Exception{
        front.login();
        carcas.go_to_web_offers();
        steps.wait_for_all_spinners_dissapears(90);
        steps.click_reset_filter_button();
        steps.wait_for_all_spinners_dissapears(90);
        String first_offer_name = steps.get_first_offer_name();
        bs.click_go_next_page();
        bs.wait_for_all_spinners_dissapears(90);
        String second_offer_name = steps.get_first_offer_name();
        bs.check_string_has_changed(first_offer_name,second_offer_name);
        bs.close_browser();

    }

}
