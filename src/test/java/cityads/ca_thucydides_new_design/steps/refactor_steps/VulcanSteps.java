/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.steps.refactor_steps;

import cityads.ca_thucydides_new_design.pages.db.MySQLWorker;
import cityads.ca_thucydides_new_design.pages.refactor.Vulcan;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.Properties;

/**
 *
 * @author s.lugovskiy
 */
public class VulcanSteps extends ScenarioSteps {

    public Vulcan vulcan;

    public VulcanSteps(Pages pages) {
        super(pages);
    }

    @Step
    public void fillVulcanForm(String email){
        vulcan.fiilVulcanRegistationForm(email);
    }

    @Step
    public String getEmailFromDb(){
        String email = MySQLWorker.getEmailFromDB();
        deleteEmail(email);
        return email;

    }
    @Step
    public void deleteEmail(String email){
        MySQLWorker.deleteEmail(email);
    }

    @Step
    public void set_proxy(String ip, String port){
        Properties props = System.getProperties();
        props.setProperty("thucydides.proxy.http", ip);
        props.setProperty("thucydides.proxy.http_port", port);
    }
}
    

