package cityads.ca_thucydides_new_design.WebmasterStory.tools;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.ApiSteps;
import cityads.ca_thucydides_new_design.steps.XMLSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.*;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;


@Story(TestSuite.WebMaster.CouponsAndPromocodes.class)
@RunWith(ThucydidesRunner.class)
public class GoodsGoogleXml51149Test {



    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public XMLSteps steps;
    @Steps
    public CarcasSteps carcas;
    @Steps
    public FrontSteps front;
    @Steps
    public FilterSteps filter;
    @Steps
    public GoodsSteps goods;
    @Steps
    public TableSteps table;
    @Steps
    public CardSteps card;
    @Steps
    public ApiSteps api;



    @Test@Screenshots(onlyOnFailures = false)
    @Title("Проверка выгрузки в формате гугл")
    public void goodsGoogleXml51149Test() throws Exception {


        front.login();
        carcas.go_to_web_offers();
        filter.reset_filter();
        filter.click_checkbox_in_filter(4, 3);
        filter.submit_filter();
        table.click_first_aviable_offer();
        card.go_to_instrument_tab();
        steps.scroll_to_bottom();
        String code = card.get_goods_original_code();
        steps.open_url(code);
        steps.check_fatal_errors();

        //проверяем что отдается по апи гет - запросом
        String responseApi = api.send_clean_get_request(code);
        ArrayList<String> list = steps.parse_xml_feed_responce_for_node(responseApi,"link");

        //получаем первую ссылку из фида
        String link = (list.get(0));
        steps.open_url(link);

        String host = steps.get_curent_domain_name();

        //проверяем что мы не на вартандере
        steps.check_string_not_contains_text(host,"warthunder");




    }
}
