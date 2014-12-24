package cityads.ca_thucydides_new_design.WebmasterStory.tools;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.DownloadsSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.*;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.GoodsCatalog.class)
@RunWith(ThucydidesRunner.class)
public class GoodsLink53721Test {



    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public  CarcasSteps carcas;
    @Steps
    public  FrontSteps front;
    @Steps
    public  FilterSteps filter;
    @Steps
    public  GoodsSteps goods;
    @Steps
    public  TableSteps table;
    @Steps
    public  CardSteps card;
    @Steps
    public  DownloadsSteps steps;



    @Before
    public void setUp(){
        front.login();
        carcas.go_to_goods();
    }


    @Test
    @Screenshots(onlyOnFailures = false)
    @Title("Проверка совпадения ссылки на товар в интерфейсе ВМа и после редиректа, фильтр - в наличие")
    public void goodsLink53721Test() throws Exception{

        filter.reset_filter();
        filter.click_checkbox_in_filter(2,1);
        filter.submit_filter();
        steps.check_fatal_errors();
        String url = goods.get_first_goods_url();
        String landing = goods.get_first_landing_url();
        steps.open_url(url);
        String redirectedUrl = steps.get_curent_domain_name();
        steps.check_string_contains_text(landing,redirectedUrl);


    }
}
