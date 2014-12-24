package cityads.ca_thucydides_new_design.WebmasterStory.tools;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.DownloadsSteps;
import cityads.ca_thucydides_new_design.steps.XMLSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


@Story(TestSuite.WebMaster.Downloads.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class DownloadAllGoodsInXMLStoryTest extends Constants {


    private String wmName;
    public String offerName;
    public String offerId;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;


    @Steps
    public DownloadsSteps steps;
    @Steps
    public XMLSteps apiSteps;



    @Test
    @Title("Тест на выгрузку всех товаров в json")
    @WithTagValuesOf({"block:Downloads","role:Webmaster"})
    public void downloads_allgoods_xml_test() throws Exception{


        String filterName = null;


        wmName = steps.get_wm_name();
        steps.wm_login(wmName);
        steps.click_goods_and_coupons_link();
        steps.wait_for_all_spinners_dissapears(30);
        steps.click_goods_link();
        steps.click_goods_catalog();

        steps.wait_for_all_spinners_dissapears(180);
        steps.check_fatal_errors();
        steps.waitAjax(1000);

        steps.executeScript("$('#id_el_input_filter_reset').click()");
        steps.wait_for_all_spinners_dissapears(120);
        steps.wait_for_all_spinners_dissapears(120);

        filterName = getCurrentDate()+" "+getRandomIntNumber();
        String downloadName = getCurrentDate()+" "+getRandomIntNumber();
        String subaccountName = getCurrentDate()+" "+getRandomIntNumber();


        steps.click_apply_right_filter();
        steps.wait_for_all_spinners_dissapears(60);
        

        
        steps.uncheck_filters_move_checkbox();
        steps.waitABit(1000);
        //переход в инструменты - выгрузки
        steps.click_goods_filter_create_tool_link();
        steps.wait_for_all_spinners_dissapears(90);
        steps.waitAjax(10000);
        steps.check_h1_page_title("Добавление фида");
        steps.wait_for_all_spinners_dissapears(60);


        steps.fill_name_input(downloadName);
        steps.fill_subaccount_input(subaccountName);
        steps.submit_form();
        steps.wait_for_all_spinners_dissapears(60);
        steps.waitABit(5000);
        steps.check_blue_table_has_text(downloadName);
        

        steps.wait_for_all_spinners_dissapears(30);


        WebElement string = steps.get_blue_table_string_with_text(downloadName);
        steps.click_icon_in_blue_table_line(1, string);

        //steps.click_icon_in_blue_table_first_line(1);
        steps.wait_for_all_spinners_dissapears(30);
        String url = steps.get_feed_code();
        steps.wait_for_all_spinners_dissapears(30);
        steps.check_string_contains_text(url,"goods");
        steps.open_url(url);
        steps.check_text_in_page("total");
        steps.close_browser();



    }






} 