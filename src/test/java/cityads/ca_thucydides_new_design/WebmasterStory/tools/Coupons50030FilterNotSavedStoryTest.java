package cityads.ca_thucydides_new_design.WebmasterStory.tools;

import cityads.ca_thucydides_new_design.pages.refactor.DataGenerator;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.XMLSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.*;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;


@Story(TestSuite.WebMaster.CouponsAndPromocodes.class)
@RunWith(ThucydidesRunner.class)
public class Coupons50030FilterNotSavedStoryTest {



    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public XMLSteps steps;
    @Steps
    public CarcasSteps carcas;
    @Steps
    public FrontSteps front;
    @Steps
    public FilterSteps filter;
    @Steps
    public CouponsSteps coupons;
    @Steps
    public TableSteps table;


    
    @Test
    @Screenshots(onlyOnFailures = false)
    @Title("Проверка создания фида купонов с несохраненным фильтром #50030")
    public void checkCouponsFilterNotSavedtest() throws IOException, SAXException, ParserConfigurationException {
        String feedName = DataGenerator.getRandomNameWithDate();

        front.login();
        carcas.go_to_coupons();
        coupons.reset_filter();
        filter.submit_filter();
        coupons.create_feed_without_saved_filter(feedName);
        table.check_table_has_text(feedName);
        String code = table.get_code_in_feed_with_name(feedName);
        carcas.get_url(code);
        String response = steps.get_page_source();
        int number = steps.get_node_numbers("<item>",response);
        steps.check_node_number(10,number);
        steps.close_browser();

    }
}
