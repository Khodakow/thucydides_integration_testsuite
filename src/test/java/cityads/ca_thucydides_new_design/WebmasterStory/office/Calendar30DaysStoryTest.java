package cityads.ca_thucydides_new_design.WebmasterStory.office;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.SvodnayaSteps;
import cityads.ca_thucydides_new_design.steps.MainSiteSteps;
import java.sql.Connection;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.Svodnaya.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class Calendar30DaysStoryTest extends Constants {

     public Connection con;
     public String wmName;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public MainSiteSteps steps;
    
    @After
    public void shut_down_driver_process(){
        steps.close_browser();
    }
    
    @Test
    public void calendar_30days_test() throws Exception{
        String periodCalendar;
        int realPeriod;
        
        wmName = steps.get_wm_name();
        
        steps.wm_login(wmName);
        steps.wait_for_all_spinners_dissapears(60);
        steps.check_fatal_errors();
        periodCalendar = steps.get_calendar_input_data();//20.03.2014 - 18.04.2014
        
        //razbivaem datu
        String[] dates = periodCalendar.split(" - ");
        String dateStart = dates[0];
        String dateEnd = dates[1];
//        System.out.println("DATE 1 = "+dateStart);
//        System.out.println("DATE 2 = "+dateEnd);
//        System.out.println("PERIOD "+steps.calculate_dates_interval(dateStart, dateEnd));
        realPeriod =  steps.calculate_dates_interval(dateStart, dateEnd);
        steps.check_values_are_in_interval(28,realPeriod,31);
        
        steps.close_browser();
        
    }
    
 
    

    
} 