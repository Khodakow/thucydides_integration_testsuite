package cityads.ca_thucydides_new_design.WebmasterStory.translate.eng;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.SetupSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.BugsSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.ProfileSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.sql.Connection;


@Story(TestSuite.WebMaster.Translate.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class OperationEngStoryTest extends Constants {

    public Connection con;
    public String wmName;
    public String rotatorName = getCurrentDate();
    private String  bannerSize1;
    private String  bannerSize2;
    private String  bannerSize3;
    protected String AJSCode;
    protected String JSCode;



    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public BugsSteps bs;

    @Steps
    public ProfileSteps profile;


    @Steps
    public SetupSteps ss;


    @Test
    @Title("Переводы англ финансы и выплаты")
    @WithTagValuesOf({"block:Traslation","role:Webmaster"})
    public void checkOperationTranslation(){
        String wmName = ss.get_wm_name();
        bs.wm_login(wmName);
        bs.click_finances_link();
        bs.waitAjax(3000);
        bs.click_operation_history_link();
        bs.waitAjax(3000);
        bs.change_lang_to_en();
        bs.check_lang_select();
        bs.close_browser();
    }

} 