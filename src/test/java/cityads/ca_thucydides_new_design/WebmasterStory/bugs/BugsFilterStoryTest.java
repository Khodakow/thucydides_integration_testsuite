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
@WithTag(name="filter bugs")
public class BugsFilterStoryTest extends Constants {



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
  public void check_34190_calendar_crossPage() throws InterruptedException{
      String s = "21.01.2014 - 21.03.2014";
      String wmName = ss.get_wm_name();
      bs.wm_login(wmName);
      bs.setDateToCalendar(s);
      bs.wait_for_all_spinners_dissapears(90);
      bs.refresh_page();

      bs.wait_for_all_spinners_dissapears(90);
      String s1 = bs.get_date_from_period();
      bs.check_values_are_equals(s1, s);
      bs.click_statistic_link();
      bs.wait_for_all_spinners_dissapears(90);

      bs.click_stat_traffic_source_link();
      bs.waitABit(1000);
      bs.click_stat_by_sourse_sourse_link();
      bs.waitABit(1000);


      bs.click_stat_by_sourse_traffic_by_sourse_by_reffers();


      bs.waitAjax(5000);
      stat.wait_for_all_spinners_dissapears(90);
      stat.wait_highchart_displayed(30);
      stat.check_fatal_errors();
      stat.check_blue_table_is_visible();
      String s2 = bs.get_date_from_period();
      bs.check_values_are_equals(s2, s);

  }

}
