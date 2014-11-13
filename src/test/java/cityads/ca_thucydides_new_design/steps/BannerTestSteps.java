/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.steps;

import cityads.ca_thucydides_new_design.pages.highload.BannerstestPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;
import org.apache.commons.lang3.StringEscapeUtils;

import static org.junit.Assert.assertFalse;

/**
 *
 * @author s.lugovskiy
 */
public class BannerTestSteps extends SetupSteps{

    BannerstestPage page;


    public BannerTestSteps(Pages pages) {
        super(pages);
    }



    public void submit_banner_to_test_form(String code){
        page.submitCode(code);
    }

    @Step
    public void click_banner(){
        page.clickBanner();
    }

    @StepGroup
    public void check_banner(String code){
        go_to_test_form();
        submit_banner_to_test_form(code);
        click_banner();
        switch_to_last_window();
        String host = getUrlHost(getDriver().getCurrentUrl().replace("www.",""));
        check_host_not_cityads(host);
    }

    @StepGroup
    public void check_shift(String code){
        go_to_test_form();
        submit_banner_to_test_form(StringEscapeUtils.unescapeHtml4(code));
        check_shift_first_link();
    }

    @Step
    public void go_to_test_form(){
        page.goToTestForm();
    }

    @Step
    public void check_host_not_cityads(String host){
         assertFalse(host.contains("cityads"));
         assertFalse(host.contains("develop.team"));
         assertFalse(host.contains("r209.team"));
    }

    @Step
    public void check_shift_first_link(){
        page.checkSHiftLink();
    }


}
