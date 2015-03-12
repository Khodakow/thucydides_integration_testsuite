package cityads.ca_thucydides_new_design.WebmasterStory.mainpage;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.SetupSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.CarcasSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FrontSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.Svodnaya.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class SwitchingToTheOldInterfaceTest {


    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public FrontSteps front;

    @Steps
    public SetupSteps setUp;

    @Steps
    public CarcasSteps carcas;

    @Test
    @Pending
    @Screenshots(onlyOnFailures = false)
    @Title("Переход из нового в старый интерфейс")
    public void switchOldInterfaceTest() throws Exception{

        front.login();
        String newUrl = setUp.get_current_url();
        if(newUrl.contains("cityads.com")){
            carcas.click_old_interface_button();
            String oldUrl = setUp.get_current_url();
            setUp.check_string_contains_text(oldUrl, "cityads.ru");
            carcas.check_h1_interface_old();
        }
    }

} 