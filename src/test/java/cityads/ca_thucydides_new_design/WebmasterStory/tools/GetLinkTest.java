package cityads.ca_thucydides_new_design.WebmasterStory.tools;

import cityads.ca_thucydides_new_design.pages.refactor.DataGenerator;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.BannerTestSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.OfferCardSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.*;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.GetLink.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class GetLinkTest {

    public String wmName;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public OfferCardSteps steps;

    @Steps
    public CarcasSteps carcas;

    @Steps
    public FormSteps form;

    @Steps
    public TableSteps table;

    @Steps
    public PopupSteps popup;

    @Steps
    public BannerTestSteps test;

    @Steps
    public FrontSteps front;

    @Steps
    public GetLinkSteps getLink;

    @Steps
    public FilterSteps filter;

    @Steps
    public CardSteps card;



    @Before
    public void setUp(){
        front.login();
        carcas.go_to_getlink();
        steps.delete_all_from_blue_table();

    }

    @Test @Screenshots(onlyOnFailures=false)
    @Title("Проверка гетлинк - сохранить и выйти")
    public void getLinkTest() throws Exception{
        String name = DataGenerator.getRandomNameWithDate();
        String subacc = DataGenerator.getRandomString();

        steps.check_fatal_errors();
        form.create_form();

        String firstRetargetOffer = getLink.get_first_retarget_offer();         //заполминаем офферы которые были выбраны в гет-линке для теста
        String firstNoretargetOffer = getLink.get_first_noretarget_offer();

        steps.check_string_not_contains_text(firstRetargetOffer,"cityadspix");
        steps.check_string_not_contains_text(firstNoretargetOffer,"cityadspix");

        getLink.fill_getlink_form(name,subacc);
        table.check_table_has_text(name);
        String code = table.get_code_in_feed_with_name(name);
        steps.close_browser();

        steps.open_url(code);       //переход по ссылке
        steps.check_fatal_errors();
        String host = steps.getUrlHost(steps.getCurrentUrl().replace("www.",""));
        steps.check_string_not_contains_text(host, "cityads");
        steps.check_string_not_contains_text(host,"warthunder");

        steps.open_url(code);       //переход по ссылке еще раз ( уже с кукой )

    }

    @Test
    @Title("Проверка гетлинк - сохранить и получить код")
    @Screenshots(onlyOnFailures=false)
    public void getLinkSaveAndGetcodeTest() throws Exception{
        String name = DataGenerator.getRandomNameWithDate();
        String subacc = DataGenerator.getRandomString();

        steps.check_fatal_errors();
        form.create_form();

        String firstRetargetOffer = getLink.get_first_retarget_offer();         //заполминаем офферы которые были выбраны в гет-линке для теста
        String firstNoretargetOffer = getLink.get_first_noretarget_offer();

        steps.check_string_not_contains_text(firstRetargetOffer,"cityadspix");
        steps.check_string_not_contains_text(firstNoretargetOffer,"cityadspix");

        String code = getLink.fill_getlink_form_and_get_code(name,subacc);
        steps.close_browser();

        steps.open_url(code);       //переход по ссылке
        steps.check_fatal_errors();
        String host = steps.getUrlHost(steps.getCurrentUrl().replace("www.",""));
        steps.check_string_not_contains_text(host,"cityads");
        steps.check_string_not_contains_text(host,"warthunder");

        steps.open_url(code);       //переход по ссылке еще раз ( уже с кукой )


    }

    @Test
    @Title("GetLink Проверка поиска оффера по ключевому слову в таблице retarget")
    @Screenshots(onlyOnFailures=false)
    public void getLinkOfferSearchRetargetTest(){

        carcas.go_to_web_offers();

        //отсеиваем только офферы с товарами
        filter.click_checkbox_in_filter(4, 3);
        filter.submit_filter();

        String name = table.get_first_aviable_offer_name();
        carcas.go_to_getlink();
        form.create_form();
        filter.filter_by_keyword_retarget_getlink(name);
        getLink.check_retarget_table_has_text(name);

    }

    @Test
    @Title("GetLink Проверка поиска оффера по ключевому слову в таблице no retarget")
    @Screenshots(onlyOnFailures=false)
    public void getLinkOfferSearchNoRetargetTest(){

        carcas.go_to_web_offers();

        //отсеиваем только офферы с товарами
        filter.click_checkbox_in_filter(4,3);

        //получаем имя и сайт первого доступного оффера
        String name = table.get_first_aviable_offer_name();
        table.click_first_aviable_offer();
        String site = card.get_offer_site();

        carcas.go_to_getlink();
        form.create_form();
        filter.filter_by_keyword_noretarget_getlink(name);
        getLink.check_noretarget_table_has_text(name);



    }

    @Test
    @Screenshots(onlyOnFailures=false)
    @Title("Проверка гетлинк по первому подходящему офферу в обеих таблицах")
    public void getLinkTestWithOffer() throws Exception{
        String subacc = DataGenerator.getRandomString();

        carcas.go_to_web_offers();

        //отсеиваем только офферы с товарами
        filter.click_checkbox_in_filter(4, 3);
        filter.submit_filter();

        //получаем имя первого доступного оффера
        String name = table.get_first_aviable_offer_name();
        table.click_first_aviable_offer();
        String site = card.get_offer_site();

        carcas.go_to_getlink();
        form.create_form();

        filter.filter_by_keyword_retarget_getlink(name);
        filter.filter_by_keyword_noretarget_getlink(name);
        getLink.check_retarget_table_has_text(name);
        getLink.check_noretarget_table_has_text(name);

        String firstRetargetOffer = getLink.get_first_retarget_offer();         //заполминаем офферы которые были выбраны в гет-линке для теста
        String firstNoretargetOffer = getLink.get_first_noretarget_offer();

        steps.check_string_not_contains_text(firstRetargetOffer,"cityadspix");
        steps.check_string_not_contains_text(firstNoretargetOffer,"cityadspix");

        String code = getLink.fill_getlink_form_and_get_code(name,subacc);

        steps.open_url(code);       //переход по ссылке
        steps.check_fatal_errors();
        String host = steps.getUrlHost(steps.getCurrentUrl().replace("www.",""));

        steps.check_string_contains_text(site,host);
        steps.check_string_not_contains_text(host,"warthunder");



    }

    @After
    public void tearDown(){
        steps.close_browser();
    }



 
    

    
} 