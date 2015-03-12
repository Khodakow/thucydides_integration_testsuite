package cityads.ca_thucydides_new_design.WebmasterStory.tools;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.ApiSteps;
import cityads.ca_thucydides_new_design.steps.XMLSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.*;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;


@Story(TestSuite.WebMaster.CouponsAndPromocodes.class)
@RunWith(ThucydidesRunner.class)
public class GoodsImagesTest {



    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    XMLSteps steps;
    @Steps
    CarcasSteps carcas;
    @Steps
    FrontSteps front;
    @Steps
    FilterSteps filter;
    @Steps
    GoodsSteps goods;
    @Steps
    TableSteps table;
    @Steps
    CardSteps card;
    @Steps
    ApiSteps api;
    @Steps
    ConsoleSteps console;



    @Test@Screenshots(onlyOnFailures = false)
    @Title("Проверка картинок в товарах")
    public void goodsImageTest() throws Exception {

        front.login();
        carcas.go_to_goods();
        ArrayList<String> urls = goods.get_images_urls();
        String url = urls.get(0).replaceAll("\"","");
        steps.open_url(url);
        goods.check_image_displayed();
        api.send_clean_get_request(url);


    }
}
