package cityads.ca_thucydides_new_design.WebmasterStory.bugs;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.StatisticSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.Bugs.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="bugs")
public class Bugs36808StoryTest extends Constants {



    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public StatisticSteps steps;


    
    @Test
    @Title("ПРОПАДАЕТ ГРАФИК ПРИ ВЫБОРЕ СРАВНИТЕЛЬНЫХ ДАТ В КАЛЕНДАРЕ 36808")
    public void check_36808(){
        String wmName = steps.get_wm_name(); 
        steps.wm_login(wmName);
        steps.wait_for_all_spinners_dissapears(60);

      
        steps.click_calendar();
        steps.wait_for_all_spinners_dissapears(60);
        steps.waitAjax(2000);
        steps.click_select_choose_n_arrow(2);
        steps.click_90_days();
        steps.click_compare_with_checkbox_in_calendar();
        steps.click_select_choose_n_arrow(3);
        steps.click_today();
        steps.click_apply_calendar();
        steps.wait_for_all_spinners_dissapears(60);
        steps.check_popup_is_not_displayed();
        steps.click_by_week();
        steps.wait_for_all_spinners_dissapears(60);
        steps.check_popup_is_not_displayed();
        steps.check_highcharts_container_is_displayed();
        //steps.check_calendar_is_displayed();
        
        steps.close_browser();
    }
}
