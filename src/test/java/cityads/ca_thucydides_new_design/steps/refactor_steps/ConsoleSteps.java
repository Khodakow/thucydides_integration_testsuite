/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.steps.refactor_steps;

import cityads.ca_thucydides_new_design.steps.BaseSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import org.apache.commons.lang3.StringEscapeUtils;
import org.openqa.selenium.logging.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;

/**
 *
 * @author s.lugovskiy
 */
public class ConsoleSteps extends BaseSteps {


    public ConsoleSteps(Pages pages) {
        super(pages);
    }

    @Step("Проверяем логи консоли браузера в Хроме")
    public void check_console_log(){
        List<String> l = get_all_logs();
        List<String> errorList;
        errorList = get_errors(l);
        check_array_has_errors(errorList);

    }

    @Step
    public List<String> get_all_logs(){
        List<String> l = new ArrayList<String>();
        Logs logs = getDriver().manage().logs();
        LogEntries logEntries = logs.get(LogType.BROWSER);
          for (LogEntry logEntry : logEntries) {
            System.out.println("Console output: "+logEntry.getMessage());
            l.add(logEntry.getMessage());
        }
        return l;
    }

    @Step
    public ArrayList<String> get_errors(List<String> words){
        ArrayList<String> errors = new ArrayList<String>();
        for(String s : words){
            if((     s.contains("fatal")
                    ||s.contains("Fatal")
                    ||s.contains("Uncaught")
                    ||s.contains("uncaught")
                    ||s.contains("error")
                    ||s.contains("Error")
                    ||s.contains("not found")
                    ||s.contains("Not found")
                    ||s.contains("TypeError")
                    ||s.contains("typeError")
            )){
                errors.add(StringEscapeUtils.escapeHtml4((StringEscapeUtils.escapeHtml3(s))));
            }
        }
        return errors;
    }

    @Step
    public void check_array_has_errors(List<String> list){
        assertFalse(list.size()>0);
    }

    @Step
    public void unleash_gremlins(int time){
        executeScript("$(document).ready(function() \n" +
                "{\n" +
                "    var s = document.createElement(\"script\");\n" +
                "    s.type = \"text/javascript\";\n" +
                "    s.src = \"http://test_result.tester.sagl/public/gremlins.min.js\";\n" +
                "    $(\"head\").append(s);\n" +
                "});");
        executeScript("gremlins.createHorde().unleash({ nb: 10000 });");
        waitABit(time*1000);
    }


}
    

