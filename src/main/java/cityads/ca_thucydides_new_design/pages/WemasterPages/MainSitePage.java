package cityads.ca_thucydides_new_design.pages.WemasterPages;

import cityads.ca_thucydides_new_design.pages.MainPage;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;




public class MainSitePage extends MainPage {
       
	
	public MainSitePage(WebDriver driver) {
		super(driver);
	}
        
 
        @FindBy(linkText="Панель управления")
        public WebElement controlPanelLink;
        
        @FindBy(linkText="Платформа")
        public WebElement platformLink;
        
        @FindBy(linkText="Аналитика")
        public WebElement analiticLink;
        
        @FindBy(linkText="Live Product Base")
        public WebElement liveProductBaseLink;
        
        @FindBy(linkText="Система рекомендаций")
        public WebElement recommendSystemLinkLink;
        
        @FindBy(linkText="Data Management Platform")
        public WebElement dataManagementLink;
        
        @FindBy(linkText="Dynamic Creative Optimization")
        public WebElement creativeOptimizationLink;
        
        @FindBy(linkText="E-mail платформа")
        public WebElement emailPlatformLink;
        
        public void check_links_are_present_in_platform_page(){
            element(controlPanelLink).isCurrentlyVisible();
            element(platformLink).isCurrentlyVisible();
            element(analiticLink).isCurrentlyVisible();
            element(liveProductBaseLink).isCurrentlyVisible();
            element(recommendSystemLinkLink).isCurrentlyVisible();
            element(dataManagementLink).isCurrentlyVisible();
            element(creativeOptimizationLink).isCurrentlyVisible();
            element(emailPlatformLink).isCurrentlyVisible();
        }
        
        //=======================================new footer links=====================================================
        
        @FindBy(xpath="//div[@class='footer-menu']")
        public WebElementFacade footerCorpSite;

         @FindBy(xpath="//a[@href='/ru/company' and @class='with-hover-underline']")
            public WebElementFacade footeraboutUS;
        public WebElementFacade getPlatfrmLinkFooter() {
            WebElementFacade platfrmLinkFooter = footerCorpSite.find(By.id("menuId3641930"));
            return platfrmLinkFooter;
        }

        public WebElementFacade getEmailPlatfrmLinkFooter() {
            WebElementFacade emailPlatfrmLinkFooter = this.find(By.xpath("//li[@class='menu-column']/ul/li/a[contains(@href,'platform/emailing')]"));
            return emailPlatfrmLinkFooter;
        }

        public WebElementFacade getControlPanelLinkFooter() {
            WebElementFacade controlPanelLinkFooter = this.find(By.xpath("//li[@class='menu-column']/ul/li/a[contains(@href,'platform/control')]"));
            return controlPanelLinkFooter;
        }

        public WebElementFacade getAnalyticLinkFooter() {
            WebElementFacade analyticLinkFooter = this.find(By.xpath("//li[@class='menu-column']/ul/li/a[contains(@href,'platform/analytics')]"));
            return analyticLinkFooter;
        }

        public WebElementFacade getLiveProductBaseLinkFooter() {
            WebElementFacade liveProductBaseLinkFooter = footerCorpSite.find(By.id("menuId403319223"));
            return liveProductBaseLinkFooter;                                
        }                                                                    
           public WebElementFacade getCareerLinkFooter() {                     ////menuId402919223 
            WebElementFacade CareerBaseLinkFooter = this.find(By.xpath("//li[@class='menu-column']/ul/li/a[contains(@href,'company/career')]"));
            return CareerBaseLinkFooter;
        }

           public WebElementFacade getVacancyLink(){
               WebElementFacade vacancyLink = this.find(By.xpath("//tbody/tr[2]/td[1]/a"));
               return vacancyLink;
           }


           public void click_about_company_main_footer(){
               this.footeraboutUS.click();
               waitABit(5000);
           }
//==================================================================         
//        YANDEX HTMLELEMENTS EXAMPLE        
//        @Block(@FindBy(xpath="//div[@class='footer-menu']"))
//        class FooterBlack extends HtmlElement{
//            
//            @FindBy(id="menuId403339223")
//            private Link emailPlatfrmLinkFooter;
//            
//            public void clickEmailPlatformLink(){
//                emailPlatfrmLinkFooter.click();
//            }
//        }
//==================================================================     
    

    
    }





