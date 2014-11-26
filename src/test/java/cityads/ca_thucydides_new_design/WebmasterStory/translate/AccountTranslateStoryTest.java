package cityads.ca_thucydides_new_design.WebmasterStory.translate;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.SetupSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.BugsSteps;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.ProfileSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.CarcasSteps;
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
public class AccountTranslateStoryTest{

     public Connection con;
     public String wmName;
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
    public CarcasSteps carcas;
    
    @Steps
    public SetupSteps ss;
  


    @Test
    @Title("Аккаунт переводы")
    @WithTagValuesOf({"block:Traslation","role:Webmaster"})
    public void checkAccountTranslation(){
    String wmName = ss.get_wm_name();  
    bs.wm_login(wmName);
    carcas.go_to_account();
    //bs.change_lang_to_br();
    bs.wait_for_all_spinners_dissapears();
    bs.check_lang_select();
    bs.close_browser();
    }

} 