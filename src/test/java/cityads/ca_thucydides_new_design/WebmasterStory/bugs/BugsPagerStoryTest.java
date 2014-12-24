package cityads.ca_thucydides_new_design.WebmasterStory.bugs;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.SetupSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.*;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.Bugs.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="pager bugs")
public class BugsPagerStoryTest extends Constants {



    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    String dateFirstPage;
    String dateSecondPage;


    @Steps
    public BannerRotatorSteps banrot;

    @Steps
    public BugsSteps bs;

    @Steps
    public SetupSteps ss;

    @Steps
    public StatisticSteps stat;

    @Steps
    public TopWMSteps topwm;

    @Steps
    public  OfferListSteps offer;



    @Test
    @Title("Купоны пейджер 33355")//
    public void check_33355_cupons(){

        String wmName = ss.get_wm_name();
        bs.wm_login(wmName);
        bs.click_goods_and_coupons_link();
        bs.wait_for_all_spinners_dissapears(30);
        bs.click_coupons_and_promocodes_link();
        bs.wait_for_all_spinners_dissapears(30);
        bs.wait_for_h1_title_appears("", 30);


        int couponCount = Integer.parseInt(bs.get_coupons_count());
        if(couponCount > 20) {
            String first = bs.get_first_coupon_text();
            bs.click_go_next_page();
            bs.wait_for_all_spinners_dissapears(30);
            bs.scroll_top();
            bs.wait_for_all_spinners_dissapears(30);
            String second = bs.get_first_coupon_text();
            bs.check_string_has_changed(first,second); }
        bs.close_browser();
    }

}
