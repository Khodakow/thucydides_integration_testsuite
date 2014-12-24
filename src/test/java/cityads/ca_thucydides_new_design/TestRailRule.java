package cityads.ca_thucydides_new_design;

import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
import testrail.APIClient;
import testrail.APIException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by s.lugovskiy on 04.12.2014 16:09.
 */
public class TestRailRule implements MethodRule {
    private String testRailUrl;
    private String testRailUser;
    private String testRailPwd;
    private String testRailRun;
    private String caseId;
    private APIClient client;

    public TestRailRule(String caseId) {
        this.testRailUrl = System.getProperty("testrail.url");
        this.testRailUser = System.getProperty("testrail.user");
        this.testRailPwd = System.getProperty("testrail.password");
        this.testRailRun = System.getProperty("testrail.current.run");
        this.client = new APIClient(testRailUrl);
        client.setUser(testRailUser);
        client.setPassword(testRailPwd);
        this.caseId = caseId;
        System.out.println("TESTRAIL CASE ID: "+caseId);

    }

    private void send_test_result(Integer result, String comment) throws APIException, IOException {
        Map data = new HashMap();
        data.put("status_id", result);
        data.put("comment", comment);
        Object o = client.sendPost("add_result_for_case/" + testRailRun + "/" + this.caseId + "", data);
        System.out.println(o.toString());

    }

    @Override
    public Statement apply(final Statement statement, final FrameworkMethod frameworkMethod, Object o) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                try {
                    statement.evaluate();
                    send_test_result(1, frameworkMethod.getName());

                } catch (Throwable t) {
                    send_test_result(5, t.getMessage());
                    throw t;
                }
            }
        };
    }
}
