package cityads.ca_thucydides_new_design.WebmasterStory.tools;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.BannerTestSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.DownloadsSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.OfferCardSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.CarcasSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FilterSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FrontSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.apache.commons.lang3.StringEscapeUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/**
 * Created by a.hodakov on 04.02.2015.
 */
@Story(TestSuite.WebMaster.Downloads.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class DCOBannersTest  {


    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;


    @Steps
    public DownloadsSteps steps;
    @Steps
    public FrontSteps front;
    @Steps
    public CarcasSteps carcas;
    @Steps
    public FilterSteps filter;
    @Steps
    public OfferCardSteps ofcard;
    @Steps
    public BannerTestSteps test;


    @Test
    @Title("Тест 003 DCO Баннеры")
    @WithTagValuesOf({"block:Downloads","role:Webmaster"})
    public void dco_banners_003_test(){
        front.login("/webmaster_pro/offers/web_6635.5.htm");
        ofcard.click_offer_instruments_tab_by_id();
        steps.wait_for_all_spinners_dissapears();

        steps.waitABit(10000); // Пришлось добавить задержку на тупняк картоки инструментов (раздел баннеры)
        ofcard.click_dynamic_tab_by_path();
        steps.wait_for_all_spinners_dissapears();
        ofcard.click_dynamic_get_code();
        String script = ofcard.get_code_from_popup_textarea();
        String newcode = StringEscapeUtils.escapeHtml4(script);
        front.log(newcode);
        test.check_dco_banner_and_redirect(script);




    }
}