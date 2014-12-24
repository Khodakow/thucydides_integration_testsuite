package cityads.ca_thucydides_new_design.WebmasterStory.coupons;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.CouponsAndPromocodesSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;




@Story(TestSuite.WebMaster.CouponsAndPromocodes.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")

public class CouponsAndPromocodesFilterCheckboxStoryTest extends Constants {

    private String wmName;


    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;


    @Before
    public void setUp(){
        wmName = steps.get_wm_name();
        steps.wm_login(wmName);
        steps.wait_for_all_spinners_dissapears(60);
        steps.click_goods_and_coupons_link();
        steps.wait_for_all_spinners_dissapears(60);
        steps.click_coupons_and_promocodes_link();
        steps.wait_for_all_spinners_dissapears(60);

    }

    @Steps
    public CouponsAndPromocodesSteps steps;


    @Test
    @Title("Проверка колчества регионов в фильтре в разделе Купоны")
    @WithTagValuesOf({"block:Goods And Coupons", "role:Webmaster"})
    public void coupons_and_promocodes_reigons_filter_test() throws Exception {

        int regionsNumber = steps.get_offers_regions_count_in_filter();
        if (steps.getDriver().getCurrentUrl().contains("cityads")) {
            steps.check_value_gteater_then_min(regionsNumber, 50);
        } else {
            steps.check_value_gteater_then_min(regionsNumber, 0);
        }

    }

    @Test
    @Title("Проверка колчества офферов в фильтре в разделе Купоны")
    @WithTagValuesOf({"block:Goods And Coupons", "role:Webmaster"})
    public void coupons_and_promocodes_offers_filter_test() throws Exception {

        int offerNumber = steps.get_offers_offers_count_in_filter();

        if (steps.getDriver().getCurrentUrl().contains("cityads")) {
            steps.check_value_gteater_then_min(offerNumber, 10);
        } else {
            steps.check_value_gteater_then_min(offerNumber, 10);
        }
    }

    @Test
    @Title("Проверка колчества статусов офферов в фильтре в разделе Купоны")
    @WithTagValuesOf({"block:Goods And Coupons", "role:Webmaster"})
    public void coupons_and_promocodes_status_filter_test() throws Exception {

        int statusNumber = steps.get_offers_status_count_in_filter();
        steps.check_value_gteater_then_min(statusNumber, 4);
    }

    @Test
    @Title("Проверка колчества типов купонов в фильтре в разделе Купоны")
    @WithTagValuesOf({"block:Goods And Coupons", "role:Webmaster"})
    public void coupons_and_promocodes_type_filter_test() throws Exception {

        int typeNumber = steps.get_offers_type_count_in_filter();
        steps.check_value_gteater_then_min(typeNumber, 2);

    }
}