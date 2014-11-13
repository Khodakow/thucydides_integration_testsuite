/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.steps.refactor_steps;

import cityads.ca_thucydides_new_design.pages.refactor.Account;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import static junit.framework.Assert.assertEquals;

/**
 *
 * @author s.lugovskiy
 */
public class AccountSteps extends ScenarioSteps {

    public Account account;





    public AccountSteps(Pages pages) {
        super(pages);
    }

    @Step
    public void fill_and_submit_personal_info(String name, String skype, String top20, String phone){
        account.fillProfile(name,skype,top20,phone);
    }

    @Step
    public void fill_and_submit_personal_info_with_timezone(String name, String skype, String top20, String phone,String country, String region){
        account.fillProfileWithTimezone(name,skype,top20,phone,country,region);
    }

    @Step
    public void fill_and_submit_personal_info_with_timezone_withot_name(String name, String skype, String top20, String phone){
        account.fillProfileWithTimezoneWithoutName(name,skype,top20,phone);
    }

    @Step
    public void check_personal_info_saved(String name, String skype, String top20, String phone){
        String newName = account.getName();
        String newSkype = account.getSkype();
        String newTop20 = account.getTop20nick();
        String newPhone = account.getPhone();
        assertEquals(newName,name);
        assertEquals(newSkype,skype);
        assertEquals(newTop20,top20);
        assertEquals(newPhone,phone);
     }

    @Step
    public void go_to_billing_info(){
        account.goToBilling();
    }

    @Step
    public void fill_first_bank(){
        account.fillFirstBank();
    }

    @Step
    public void fill_account_info(int accountNumber){
        account.fillCountInfo(accountNumber);
    }

    @Step
    public void check_form_is_displayed(){
        account.secondFormIsVisible();
    }

}
    

