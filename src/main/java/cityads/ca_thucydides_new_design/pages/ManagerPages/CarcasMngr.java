package cityads.ca_thucydides_new_design.pages.ManagerPages;

import cityads.ca_thucydides_new_design.pages.refactor.BasePage;
import cityads.ca_thucydides_new_design.pages.refactor.Table;
import net.thucydides.core.annotations.findby.By;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;


public class CarcasMngr extends BasePage {


    public CarcasMngr(WebDriver driver) {
        super(driver);
    }

    private Table table;

    @FindBy(xpath="//a[@id='menu_top_wm_item_423010615']")
    private WebElementFacade statisticMgr;
    @FindBy(xpath="//a[@id='_left_menu_id_426449652']")
    private WebElementFacade conversionsMgr;
    @FindBy(xpath="//a[@id='_left_menu_id_423010265']")
    private WebElementFacade conversionsParticipantsMgr;

    @FindBy(xpath="//a[@id='_left_menu_id_434391052']")
    private WebElementFacade conversionsOfficesMgr;
    @FindBy(xpath="//a[@id='_left_menu_id_423010275']")
    private WebElementFacade conversionsAdvertisersMgr;
    @FindBy(xpath="//a[@id='_left_menu_id_423010285']")
    private WebElementFacade conversionsWebmastersMgr;

    @FindBy(xpath="//a[@id='_left_menu_id_429539752']")
    private WebElementFacade conversionsInstruments;
    @FindBy(xpath="//a[@id='_left_menu_id_429579752']")
    private WebElementFacade conversionsCategoryPromo;
    @FindBy(xpath="//a[@id='_left_menu_id_429559752']")
    private WebElementFacade conversionsToolsType;
    @FindBy(xpath="//a[@id='_left_menu_id_429599752']")
    private WebElementFacade conversionsCodeType;
    @FindBy(xpath="//a[@id='_left_menu_id_430139752']")
    private WebElementFacade conversionsLinkType;

    @FindBy(xpath="//a[@id='_left_menu_id_426469652']")
    private WebElementFacade sourseTraffic;
    @FindBy(xpath="//a[@id='_left_menu_id_431215535']")
    private WebElementFacade sourseTrafficDestPoints;
    @FindBy(xpath="//a[@id='_left_menu_id_431495535']")
    private WebElementFacade sourseTrafficGoods;


    public String getCarcasUrl(String id){
        return this.find(By.xpath("//a[contains(@data-bind,'left_menu_id') and not(contains(@class,'dark')) and @id='" + id + "']")).getAttribute("href");
    }

    public void goToMgrStatByOffices() {

            waitForSpinnerDissapear();
            statisticMgr.waitUntilVisible();
            statisticMgr.click();
            waitForSpinnerDissapear();
            if(!conversionsParticipantsMgr.isCurrentlyVisible()){
                conversionsMgr.click();
                waitForSpinnerDissapear();
            }

            if(!conversionsOfficesMgr.isCurrentlyVisible()){
                conversionsParticipantsMgr.click();
            waitForSpinnerDissapear();
            }

            conversionsOfficesMgr.waitUntilVisible();
            conversionsOfficesMgr.click();
            waitForSpinnerDissapear();



    }

    public void goToMgrStatByAdvertisers() {

        waitForSpinnerDissapear();
        statisticMgr.waitUntilVisible();
        statisticMgr.click();
        waitForSpinnerDissapear();
        if(!conversionsParticipantsMgr.isCurrentlyVisible()){
            conversionsMgr.click();
            waitForSpinnerDissapear();
        }

        if(!conversionsAdvertisersMgr.isCurrentlyVisible()){
            conversionsParticipantsMgr.click();
            waitForSpinnerDissapear();
        }

        conversionsAdvertisersMgr.waitUntilVisible();
        conversionsAdvertisersMgr.click();
        waitForSpinnerDissapear();



    }

    public void goToMgrStatByWebmasters() {

        waitForSpinnerDissapear();
        statisticMgr.waitUntilVisible();
        statisticMgr.click();
        waitForSpinnerDissapear();
        if(!conversionsParticipantsMgr.isCurrentlyVisible()){
            conversionsMgr.click();
            waitForSpinnerDissapear();
        }

        if(!conversionsWebmastersMgr.isCurrentlyVisible()){
            conversionsParticipantsMgr.click();
            waitForSpinnerDissapear();
        }

        conversionsWebmastersMgr.waitUntilVisible();
        conversionsWebmastersMgr.click();
        waitForSpinnerDissapear();



    }

    public void goToMgrStatByCategoryPromo() {

        waitForSpinnerDissapear();
        statisticMgr.waitUntilVisible();
        statisticMgr.click();
        waitForSpinnerDissapear();
        if(!conversionsInstruments.isCurrentlyVisible()){
            conversionsMgr.click();
            waitForSpinnerDissapear();
        }

        if(!conversionsCategoryPromo.isCurrentlyVisible()){
            conversionsInstruments.click();
            waitForSpinnerDissapear();
        }

        conversionsCategoryPromo.waitUntilVisible();
        conversionsCategoryPromo.click();
        waitForSpinnerDissapear();



    }

    public void goToMgrStatByToolsType() {

        waitForSpinnerDissapear();
        statisticMgr.waitUntilVisible();
        statisticMgr.click();
        waitForSpinnerDissapear();
        if(!conversionsInstruments.isCurrentlyVisible()){
            conversionsMgr.click();
            waitForSpinnerDissapear();
        }

        if(!conversionsToolsType.isCurrentlyVisible()){
            conversionsInstruments.click();
            waitForSpinnerDissapear();
        }

        conversionsToolsType.waitUntilVisible();
        conversionsToolsType.click();
        waitForSpinnerDissapear();



    }

    public void goToMgrStatByCodeType() {

        waitForSpinnerDissapear();
        statisticMgr.waitUntilVisible();
        statisticMgr.click();
        waitForSpinnerDissapear();
        if(!conversionsInstruments.isCurrentlyVisible()){
            conversionsMgr.click();
            waitForSpinnerDissapear();
        }

        if(!conversionsCodeType.isCurrentlyVisible()){
            conversionsInstruments.click();
            waitForSpinnerDissapear();
        }

        conversionsCodeType.waitUntilVisible();
        conversionsCodeType.click();
        waitForSpinnerDissapear();



    }

    public void goToMgrStatByLinkType() {

        waitForSpinnerDissapear();
        statisticMgr.waitUntilVisible();
        statisticMgr.click();
        waitForSpinnerDissapear();
        if(!conversionsInstruments.isCurrentlyVisible()){
            conversionsMgr.click();
            waitForSpinnerDissapear();
        }

        if(!conversionsLinkType.isCurrentlyVisible()){
            conversionsInstruments.click();
            waitForSpinnerDissapear();
        }

        conversionsLinkType.waitUntilVisible();
        conversionsLinkType.click();
        waitForSpinnerDissapear();



    }

    public void goToMgrStatByGoods() {

        waitForSpinnerDissapear();
        statisticMgr.waitUntilVisible();
        statisticMgr.click();
        waitForSpinnerDissapear();
        if(!sourseTrafficDestPoints.isCurrentlyVisible()){
            sourseTraffic.click();
            waitForSpinnerDissapear();
        }

        if(!sourseTrafficGoods.isCurrentlyVisible()){
            sourseTrafficDestPoints.click();
            waitForSpinnerDissapear();
        }

        sourseTrafficGoods.waitUntilVisible();
        sourseTrafficGoods.click();
        waitForSpinnerDissapear();



    }

    public void goToMgrStatistic() {
        waitForSpinnerDissapear();
        statisticMgr.waitUntilVisible();
        statisticMgr.click();
        waitForSpinnerDissapear();
    }
}





