package cityads.ca_thucydides_new_design.WebmasterStory.tools;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.OfferCardSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.*;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.OfferInstruments.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class OfferInstruments53581StoryTest {


    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public OfferCardSteps steps;
    @Steps
    public CardSteps card;
    @Steps
    public CarcasSteps carcas;
    @Steps
    public TableSteps table;
    @Steps
    public FilterSteps filter;
    @Steps
    public FrontSteps front;
    @Steps
    public PopupSteps popup;


    @Before
    public void setUp(){
        front.login();
        carcas.go_to_web_offers();

    }

    @Test
    @WithTagValuesOf({"block:Instruments", "role:Webmaster"})
    @Title("Проверка на получение ссылки с карточки оффера после получения кода баннера с закладки Инструменты. Задача 53581")
    public  void offerInstruments53581StoryTest() throws Exception{

        filter.click_checkbox_in_filter(4,1);
        filter.submit_filter();
        steps.executeScript("$('.blue_table>thead>tr').remove()");
        table.click_first_aviable_offer();
        card.go_to_instrument_tab();
        card.get_banner_code();
        steps.executeScript("$('a[class*=\"close\"]').click();");
        card.go_to_dashboard_tab();
        card.start_work_with_offer();
        popup.click_offercard_main_links();
        String link = popup.get_textarea_code();
        steps.check_script_code(link);
        steps.close_browser();

    }








} 