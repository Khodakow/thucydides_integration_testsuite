/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.steps.refactor_steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.Logs;

import static org.junit.Assert.assertFalse;

/**
 *
 * @author s.lugovskiy
 */
public class ConsoleSteps extends ScenarioSteps {


    public ConsoleSteps(Pages pages) {
        super(pages);
    }

    @Step
    public void check_console_log(){
        Logs logs = getDriver().manage().logs();
        LogEntries logEntries = logs.get(LogType.BROWSER);
        for (LogEntry logEntry : logEntries) {
            System.out.println("Console output: "+logEntry.getMessage());
            check_log_for_error(logEntry.getMessage());
        }
    }


    public void check_log_for_error(String log){
        assertFalse(log.contains("fatal"));
        assertFalse(log.contains("Fatal"));
        //assertFalse(log.contains("SyntaxError"));
        //assertFalse(log.contains("Fail"));
        //assertFalse(log.contains("fail"));
    }

}
    

