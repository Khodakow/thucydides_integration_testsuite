/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import testrail.APIClient;
import testrail.APIException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author s.lugovskiy
 */
public class TestRailSteps extends SetupSteps{

    private String testRailUrl;
    private String testRailUser;
    private String testRailPwd;
    private String testRailRun;
    private APIClient client;

    public TestRailSteps(Pages pages) {
        super(pages);
    }



    @Step
    public void send_test_result(Integer caseId, Integer result) throws APIException, IOException {
        this.testRailUrl = System.getProperty("testrail.url");
        this.testRailUser = System.getProperty("testrail.user");
        this.testRailPwd = System.getProperty("testrail.password");
        this.testRailRun = System.getProperty("testrail.current.run");
        this.client = new APIClient(testRailUrl);
        client.setUser(testRailUser);
        client.setPassword(testRailPwd);
        Map data = new HashMap();
        data.put("status_id", result);
        data.put("comment", "Current URL: "+this.getDriver().getCurrentUrl());
        Object r = client.sendPost("add_result_for_case/" + testRailRun + "/" + caseId + "", data);
        System.out.println(r.toString());

    }


}
