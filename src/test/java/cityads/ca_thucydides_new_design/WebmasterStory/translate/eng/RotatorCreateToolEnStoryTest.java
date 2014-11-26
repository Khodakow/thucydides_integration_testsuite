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
public class RotatorCreateToolEnStoryTest extends Constants {

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
    @Title("Переводы англ создание ротатора")
    @WithTagValuesOf({"block:Traslation","role:Webmaster"})
    public void checkToolsCreationRotatorTranslation(){
        String wmName = ss.get_wm_name();
        bs.wm_login(wmName);
        bs.wait_for_all_spinners_dissapears(30);
        bs.click_instruments_link();
        bs.click_banners_rotator();
        bs.wait_for_all_spinners_dissapears(30);
        bs.click_create_button();
        bs.wait_for_all_spinners_dissapears(30);
        bs.change_lang_to_en();
        bs.wait_for_all_spinners_dissapears(30);
        bs.check_lang_select();
        bs.close_browser();
    }
} 