package cityads.ca_thucydides_new_design.WebmasterStory.mainpage;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.BaseSteps;
import cityads.ca_thucydides_new_design.steps.SetupSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.ApiDocsSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.CarcasSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.CorporateSite.class)
@RunWith(ThucydidesRunner.class)
public class ApiDocs54708StoryTest {


    @Managed(uniqueSession = false)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public CarcasSteps carcas;

    @Steps
    public ApiDocsSteps apiDocs;

    @Steps
    public SetupSteps steps;

    @Steps
    public BaseSteps baseSteps;



    @Before
    public void setUp(){
        carcas.go_to_api_docs();
    }


    @Test@Pending
    @Screenshots(onlyOnFailures = false)
    @Title("Проверка шапки документации API")
    public void apiDocs54708StoryTest() throws Exception{

        String expectedUrl = "https://www.facebook.com/cityadsmedia";
        apiDocs.check_top_panel_is_visible();
        apiDocs.check_social_buttons();
        apiDocs.click_facebook();
        steps.switch_to_last_window();
        String url = steps.get_current_url();
        baseSteps.check_values_are_equals(expectedUrl,url);
    }

    @Test@Pending
    @Screenshots(onlyOnFailures = false)
    @Title("Проверка кнопки Twitter")
    public void apiDocs54708TwitterTest() throws Exception{

        String expectedUrl = "https://twitter.com/cityads_ru";
        apiDocs.check_top_panel_is_visible();
        apiDocs.check_social_buttons();
        apiDocs.click_twitter();
        steps.switch_to_last_window();
        String url = steps.get_current_url();
        baseSteps.check_values_are_equals(expectedUrl,url);
    }


    @Test@Pending
    @Screenshots(onlyOnFailures = false)
    @Title("Проверка кнопки Vkontakte")
    public void apiDocs54708VKTest() throws Exception{

        String expectedUrl = "http://vk.com/cityads";
        apiDocs.check_top_panel_is_visible();
        apiDocs.check_social_buttons();
        apiDocs.clickVk();
        steps.switch_to_last_window();
        String url = steps.get_current_url();
        baseSteps.check_values_are_equals(expectedUrl,url);
    }
    
} 