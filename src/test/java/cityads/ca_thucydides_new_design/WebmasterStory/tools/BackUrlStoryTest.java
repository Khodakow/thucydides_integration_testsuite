package cityads.ca_thucydides_new_design.WebmasterStory.tools;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.BaseSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.BackUrlSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FrontSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.sql.Connection;


@Story(TestSuite.WebMaster.BannersRotator.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class BackUrlStoryTest extends Constants {

     public Connection con;
     public String wmName;
     public String rotatorName = getCurrentDate()+" "+getRandomIntNumber();
     protected String AJSCode;
     protected String JSCode;
     
    

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public FrontSteps front;
    @Steps
    public BaseSteps steps;

    @Steps
    public BackUrlSteps backurlsteps;

    @Before
    public void setUp(){
        front.login("/webmaster/tools/back_url_446601153.0.htm");
        steps.check_fatal_errors();
        steps.check_h1_page_title("r-URL");

    }

    public String bacurlName = getCurrentDate()+" "+getRandomIntNumber();

    @Test
    @Title("Проверка создания бек урла и выбора его в таблице офферов с последующим удалением")
    public void back_url_create_test_and_choose_in_offers() throws Exception {

        //Страница инструмента бек урл
        backurlsteps.check_back_url_structure_tools();
        steps.wait_for_all_spinners_dissapears();
        backurlsteps.click_create_back_url();
        //Страница создания
        steps.wait_for_all_spinners_dissapears();
        backurlsteps.check_back_url_structure_create_tools();
        backurlsteps.fill_create_backurl_form(bacurlName, "cityads.com");
        steps.check_blue_table_has_text(bacurlName);
        //Страница офферов
        steps.openBaseUrl("/webmaster/offers/web_offers_3641940.0.htm");
        steps.wait_for_all_spinners_dissapears();
        steps.executeScript("$('a[id*=\"id_el_lnk_top_adv_name\"]').text('')");
        steps.executeScript("$('td[id*=\"sppa\"]').text('')");
        backurlsteps.check_back_url_structure_offers();
        backurlsteps.choose_1st_backurl_in_offerstable();

    }

    @After
    public void delete_back_url_from_blue_table(){
        steps.openBaseUrl("/webmaster/tools/back_url_446601153.0.htm");
        backurlsteps.delete_all_from_backurl_table();
    }

} 