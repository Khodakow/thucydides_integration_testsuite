package cityads.ca_thucydides_new_design.WebmasterStory.highload;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.BannerRotatorSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.BannersRotator.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class FeedsClickStoryTest extends Constants {


    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public BannerRotatorSteps steps;


    @Test
    public void downloadsGoodsClickTest() throws Exception{

        String aliexpressXmlGoodsLink = "http://cityadspix.com/click?cid=de2096c8d17f81673257ad82b09e1905&im=LTAtMTQwNjAyNTY1OS02MDE0OTA3MS0tcXZvYWprbm8wc2VmZjdwajBncjFqOTAxazQ=&sa=&sa2=&bid=736034763&bt=15&pt=&tid=0&lt=4&tl=&url=0f641162132a0424521d6b46264d25433a4536592b5b74107e103e582d402c00432848284260274032593654210f5a3d553a537d345a3c577b036b157c52046b037410327f1674123e4c3d134626577c2e48314f6333462644274f2244301c6801610c582a4825476b1a7e056504694735572e54781f71086006750b276d18721e390a3d083704340d3a082841365a";
        String offerSite= "aliexpress.com";
        steps.open_url(aliexpressXmlGoodsLink);
        String host = steps.getUrlHost(steps.get_current_url().replace("www.",""));
        steps.check_string_contains_text(host,offerSite);

    }

    @Test
    public void downloadsCouponsLinkClickTest() throws Exception{

        String aliexpressXmlGoodsLink = "http://cityads.com/service/targetCoupon?out=1&bid=330865&cid=de2096c8d17f81673257ad82b09e1905&pt=6&bt=4&tid=0&fid=433437265&lt=4";
        String offerSite= "aliexpress.com";
        steps.open_url(aliexpressXmlGoodsLink);
        String host = steps.getUrlHost(steps.get_current_url().replace("www.",""));
        steps.check_string_contains_text(host,offerSite);

    }

    @Test
    public void downloadsCouponsIframeClickTest() throws Exception{

        String aliexpressXmlGoodsLink = "http://cityads.com/service/iframeCoupon?out=1&bid=330865&cid=de2096c8d17f81673257ad82b09e1905&group_offers=0&pt=6&bt=4&tid=0&fid=433437265&lt=4";
        String offerSite= "aliexpress.com";
        steps.open_url(aliexpressXmlGoodsLink);
        steps.switch_to_first_iframe();
        String host = steps.getUrlHost(steps.get_current_url().replace("www.",""));
        steps.check_string_contains_text(host,offerSite);


    }




} 