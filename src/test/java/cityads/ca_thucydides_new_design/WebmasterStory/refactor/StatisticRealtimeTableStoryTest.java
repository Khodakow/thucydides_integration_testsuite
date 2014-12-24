package cityads.ca_thucydides_new_design.WebmasterStory.refactor;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.StatisticSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.CarcasSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FilterSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FrontSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.TableSteps;
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
public class StatisticRealtimeTableStoryTest {

     public Connection con;
     public String wmName;


    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;


    @Steps
    public StatisticSteps steps;

    @Steps
    public TableSteps table;

    @Steps
    public FilterSteps filter;

    @Steps
    public FrontSteps front;

    @Steps
    public CarcasSteps carcas;



    @Test
    @Title("Проверка наличия таблицы в реал тайм стате при отсутствии кликов")
    @Screenshots(onlyOnFailures = true)
    public void statistic_real_time_table_test() throws Exception{

        front.login();
        carcas.go_to_statistic_by_realTime_periods();
        table.check_table_is_visible();

      
    }
    
 
    

    
} 