/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.steps.WebmasterSteps;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.pages.MainPage;
import cityads.ca_thucydides_new_design.steps.SetupSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author s.lugovskiy
 */
public class CarcasSteps extends SetupSteps {

    MainPage mainPage;
    Constants constants = new Constants();
    private String NAME;
    private String MAINLINK;
    private String LINK;
    private String SUBLINK;
    private String PAGETITLE;
    private String H1TITLE;
    
    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public void setMAINLINK(String MAINLINK) {
        this.MAINLINK = MAINLINK;
    }

    public void setLINK(String LINK) {
        this.LINK = LINK;
    }

    public void setSUBLINK(String SUBLINK) {
        this.SUBLINK = SUBLINK;
    }

    public void setPAGETITLE(String PAGETITLE) {
        this.PAGETITLE = PAGETITLE;
    }

    public void setH1TITLE(String H1TITLE) {
        this.H1TITLE = H1TITLE;
    }

    
    
            
    public CarcasSteps(Pages pages) {
        super(pages);
    }
    
    @Step
    public void click_main_section(String MAINLINK) {
        getDriver().findElement(By.linkText(MAINLINK)).click();
         check_fatal_errors();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(CarcasSteps.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Step
    public void click_section(String LINK) {
        getDriver().findElement(By.linkText(LINK)).click();
                check_fatal_errors();
         try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(CarcasSteps.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Step
    public void click_sub_section(String SUBLINK) {
        getDriver().findElement(By.id(SUBLINK)).click();
        check_fatal_errors();
         try {
            Thread.sleep(1000);
            if(LINK=="Товары"){
                Thread.sleep(3000);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(CarcasSteps.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Step
    public void check_page_title(String PAGETITLE){
        Assert.assertTrue(mainPage.getTitle().contains(PAGETITLE));
    }
    
    @Override
    @Step
    public void check_h1_page_title(String H1TITLE){
        Assert.assertEquals(H1TITLE,mainPage.getH1Title());        
    }
   
    @Step
    public void check_breadcrumbs(String path){
        Assert.assertTrue(mainPage.breadCrumbs.getText().contains(path));
    }
    
    
    @Step
    public void check_carcas_section(){
       
        click_main_section(MAINLINK);
        check_breadcrumbs(MAINLINK);
        click_section(LINK);

        check_breadcrumbs(MAINLINK);
        
        if(!"no".equals(SUBLINK)){
            click_sub_section(SUBLINK);
            check_breadcrumbs(MAINLINK);
            check_breadcrumbs(LINK);
            check_breadcrumbs(NAME);
        }
        check_h1_page_title(H1TITLE);
        check_page_title(PAGETITLE);
        click_section(LINK);
}
    @Step
    public void test_main_page_for_fatal_errors(){
        open_url(constants.baseUrl);
        check_fatal_errors();
    }

    public void setUpDriver() {
        getDriver().manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
   

}
    

