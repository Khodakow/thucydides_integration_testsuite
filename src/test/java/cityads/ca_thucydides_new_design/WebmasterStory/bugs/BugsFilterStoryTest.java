package cityads.ca_thucydides_new_design.WebmasterStory.bugs;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.SetupSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.BugsSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.OfferListSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.StatisticSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FrontSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.Bugs.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="filter bugs")
public class BugsFilterStoryTest{



    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;


    @Steps
    public BugsSteps bs;

    @Steps
    public SetupSteps ss;
    
    @Steps
    public StatisticSteps stat;

    @Steps
    public  OfferListSteps offer;

    @Steps
    public FrontSteps front;
    

  @Test
  @Title("СКВОЗНОЙ КАЛЕНДАРЬ 34190")
  public void check_34190_calendar_crossPage() throws InterruptedException{
      String s = "'21.01.2014 - 21.03.2014'";
      front.login();
      bs.set_date_to_calendar(s);
      bs.wait_for_all_spinners_dissapears();
      bs.refresh_page();
      bs.wait_for_all_spinners_dissapears();
      String s1 = bs.get_date_from_period();
      bs.check_values_are_equals(s1, s.replaceAll("'",""));
      bs.click_statistic_link();
      bs.wait_for_all_spinners_dissapears();
      bs.click_stat_traffic_source_link();
      bs.wait_for_all_spinners_dissapears();
      bs.click_stat_by_sourse_sourse_link();
      bs.executeScript("$('.usabilla_live_button_container').remove();");
      bs.wait_for_all_spinners_dissapears();
      bs.click_stat_by_sourse_traffic_by_sourse_by_reffers();
      bs.wait_for_all_spinners_dissapears();
      stat.wait_highchart_displayed(60);
      stat.check_blue_table_is_visible();
      String s2 = bs.get_date_from_period();
      bs.check_values_are_equals(s2, s.replaceAll("'",""));

  }

}
