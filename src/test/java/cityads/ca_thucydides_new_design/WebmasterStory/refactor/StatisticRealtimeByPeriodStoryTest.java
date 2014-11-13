package cityads.ca_thucydides_new_design.WebmasterStory.refactor;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.StatisticSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.CarcasSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FrontSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.sql.Connection;


@Story(TestSuite.WebMaster.Statistic.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class StatisticRealtimeByPeriodStoryTest{

     public Connection con;
     public String wmName;
 

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    
    @Steps
    public StatisticSteps steps;

    @Steps
    public CarcasSteps carcas;
    @Steps
    FrontSteps front;
    

    @Test
    public void statistic_real_time_by_period_test() throws Exception{

        front.login();
        carcas.go_to_statistic_by_realTime_periods();
        steps.click_realtime_by_period();
        steps.wait_for_all_spinners_dissapears(90);
        steps.check_fatal_errors();
        steps.wait_for_h1_title_appears("По периодам",90);
        steps.wait_for_blue_table_appears(90);
        steps.check_highcharts_is_present();
        steps.check_blue_table_is_visible();
        steps.click_all_th_in_blue_table();
        steps.wait_for_blue_table_appears(90);
        steps.check_fatal_errors();


    }
    
 
    

    
} 