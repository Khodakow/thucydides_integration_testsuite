package cityads.ca_thucydides_new_design.WebmasterStory.offers;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.MainSiteSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.*;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.OfferCard.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class OffercardInstrumentsSortTest {

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
    TableSteps table;
    @Steps
    CardSteps card;

    @Test
    public void offercardInstrumentsSortTest() throws Exception{

        front.login();
        carcas.go_to_web_offers();
        table.filter_by_keyword("Телеконтракт: Ипотека");  //возможно придется заменить оффер если его отключат
        table.click_first_aviable_offer();
        card.go_to_instrument_tab();
        steps.executeScript("$('table:eq(0)').remove();"); //удаляем невидимую таблицу
        table.check_column_sort_ascend_nobr(4,"7D EPC");
        table.check_column_sort_ascend_nobr(5,"3M eCPC");
        table.check_column_sort_ascend_nobr(6,"3M eCPM");
        table.check_column_sort_ascend_nobr(7,"CR");
        steps.close_browser();

    }
    
 
    

    
} 