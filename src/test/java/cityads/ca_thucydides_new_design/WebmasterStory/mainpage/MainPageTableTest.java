package cityads.ca_thucydides_new_design.WebmasterStory.mainpage;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.MainSiteSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.CorporateSite.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="corporate site")
public class MainPageTableTest {


    public String wmName;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;


    
    @Steps
    public MainSiteSteps steps;
    
    @Test@Title("Проверка что таблица на главной содержит данные")
    public void test_main_page_webmaster_table() throws Exception{
 
        steps.open_main_page();
        steps.select_ru_language();
        steps.waitABit(3000);
        steps.click_and_hold_mainpage_bluetable(1);
        steps.check_mainpage_table_contains_data_advertizer();
        steps.click_and_hold_mainpage_bluetable(2);
        steps.check_mainpage_table_contains_data_offers();
        steps.click_and_hold_mainpage_bluetable(0);
        steps.check_mainpage_table_contains_data_webmaster();

    }


   


} 