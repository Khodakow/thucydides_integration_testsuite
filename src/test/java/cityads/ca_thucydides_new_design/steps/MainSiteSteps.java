package cityads.ca_thucydides_new_design.steps;

import cityads.ca_thucydides_new_design.pages.WemasterPages.MainSitePage;
import junit.framework.Assert;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainSiteSteps extends SetupSteps {

    MainSitePage page;

    public MainSiteSteps(Pages pages) {
        super(pages);
    }

    @Step
    public void click_colntrol_panel_link() {
        page.controlPanelLink.click();
    }

    @Step
    public void click_analitic_link() {
        page.analiticLink.click();
    }

    @Step
    public void click_live_product_base_link() {
        page.liveProductBaseLink.click();
    }

    @Step
    public void click_platform_link() {
        page.platformLink.click();
    }

    @Step
    public void click_recommend_system_link() {
        page.recommendSystemLinkLink.click();
    }

    @Step
    public void click_data_management_link() {
        page.dataManagementLink.click();
    }

    @Step
    public void click_dinamic_optimization_link() {
        page.creativeOptimizationLink.click();
    }

    @Step
    public void click_email_platform_link() {
        page.emailPlatformLink.click();
    }

    @Step
    public void check_links_are_present_in_platform_page() {
        page.check_links_are_present_in_platform_page();
    }

    @Step
    public void check_all_iframes_attributes() {
        int i = 0;
        List<WebElement> iframes = getDriver().findElements(By.tagName("iframe"));
        int count = iframes.size();

        for (WebElement elem : iframes) {
            check_iframe_has_facebook_or_vk_src(elem.getAttribute("src"));
        }

    }

    @Step
    public void check_iframe_has_facebook_or_vk_src(String iframe) {
        Assert.assertTrue(iframe.contains("//www.facebook.com/plugins/likebox.php") | iframe.contains("http://vk.com/widget_community.php"));
    }

    //footer clicks =========================================================================================================================
    @Step
    public void click_footer_email_platform_link() {
        page.getEmailPlatfrmLinkFooter().click();
    }

    @Step
    public void click_footer_analytics_platform() {
        page.getAnalyticLinkFooter().click();
    }

    @Step
    public void click_compain_history() {
        page.footeraboutUS.click();

    }

    @Step
    public void click_career_link() {
        page.getCareerLinkFooter().click();

    }


    @Step
    public void click_career_vacancy_link() {
        page.getVacancyLink().click();
    }

    @Step
    public int get_cpl_chart_height_with_jquery() {
        WebElement cplGraph = (WebElement) ((JavascriptExecutor) getDriver()).executeScript("return $('.highcharts-series-group').get(1)");
        int heightInt = cplGraph.getSize().getHeight();
        return heightInt;
    }

    @Step
    public int get_cpl_chart_width_with_jquery() {
        WebElement cplGraph = (WebElement) ((JavascriptExecutor) getDriver()).executeScript("return $('.highcharts-series-group').get(1)");
        int width = cplGraph.getSize().getWidth();
        return width;
    }

    @Step
    public int get_income_chart_height_with_jquery() {
        WebElement cplGraph = (WebElement) ((JavascriptExecutor) getDriver()).executeScript("return $('.highcharts-series-group').get(0)");
        int heightInt = cplGraph.getSize().getHeight();
        return heightInt;
    }

    @Step
    public int get_income_chart_width_with_jquery() {
        WebElement cplGraph = (WebElement) ((JavascriptExecutor) getDriver()).executeScript("return $('.highcharts-series-group').get(0)");
        int width = cplGraph.getSize().getWidth();
        return width;
    }

    @Step
    public void check_all_values_in_compain_history() {
       List <WebElement> list = getDriver().findElements(By.xpath("//strong"));
        for(WebElement elem:list){
            String elemtext = elem.getText();
            check_string_has_changed("0",elemtext);
        }
    }
}