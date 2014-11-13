package cityads.ca_thucydides_new_design.WebmasterStory.api;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.ApiSteps;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.json.simple.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.Api.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="api")
public class GraphApiStoryTest extends Constants {



    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;


    
    @Steps
    public ApiSteps steps;
    
    @Test
    public void test_main_page_highcharts_api_avg_income() throws Exception{

        String response = steps.send_post_request("/main/graphic", "type=avg_income");
        JSONObject jsonResponse = steps.parse_json_response(response);            
        steps.check_json_response_contains_data_entry(jsonResponse);
        String status = steps.get_json_response_status(jsonResponse);
        steps.check_json_code_status_is_200(status,"ok");
        steps.check_json_responce_X_and_Y_is_in_range(jsonResponse,1,5000);
        
    }
    //cpl
     @Test
    public void test_main_page_highcharts_api_cpl() throws Exception{

        String response = steps.send_post_request("/main/graphic", "type=cpl");
        JSONObject jsonResponse = steps.parse_json_response(response);            
        steps.check_json_response_contains_data_entry(jsonResponse);
        String status = steps.get_json_response_status(jsonResponse);
        steps.check_json_code_status_is_200(status,"ok");
        steps.check_cpl_delta_is_not_greater_than(jsonResponse, 100);

    }
     
    @Test
    public void test_main_page_highcharts_api_X_Y() throws Exception{

        String response = steps.send_post_request("/main/graphic", "type=cpl");
        JSONObject jsonResponse = steps.parse_json_response(response);            
        steps.check_json_response_contains_data_entry(jsonResponse);
        String status = steps.get_json_response_status(jsonResponse);
        steps.check_json_code_status_is_200(status,"ok");
        steps.check_json_responce_X_and_Y_is_in_range(jsonResponse,1,1000000);
       
        
    }
 
} 