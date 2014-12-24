package cityads.ca_thucydides_new_design.WebmasterStory.tools;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.DownloadsSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FilterSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;




@Story(TestSuite.WebMaster.Downloads.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class DownloadGoodsStoryTest extends Constants {

    
     private String wmName;
     private String offerName;
     
     
    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    
    @Steps
    public DownloadsSteps steps;
    
    @Steps
    public FilterSteps filter;
    
    @Test
    @Title("Тест на выгрузку товаров ")
    @WithTagValuesOf({"block:Downloads","role:Webmaster"})
    public void downloads_goods_test() throws Exception{


        String filterName = getCurrentDate()+" "+getRandomIntNumber();

        wmName = steps.get_wm_name();
        steps.wm_login(wmName);
        steps.click_goods_and_coupons_link();
        steps.wait_for_all_spinners_dissapears(60);
        steps.click_goods_link();
        steps.wait_for_all_spinners_dissapears(60);
        steps.click_goods_catalog();
        steps.wait_for_all_spinners_dissapears(60);

        filter.click_checkbox_in_filter(2,1);
        steps.wait_for_all_spinners_dissapears(60);
        steps.click_apply_right_filter();
        steps.wait_for_all_spinners_dissapears(60);
          
        steps.uncheck_filters_move_checkbox();
        steps.wait_for_all_spinners_dissapears(60);
        steps.save_filter();  //КНПОКА ВЕБДРАЙВЕРОМ НЕ ЖМЕТСЯ,  ВЫЗЫВАЮ С КОНСОЛИ


        steps.wait_for_popup_appears(5);

        steps.fill_filter_name_in_popup(filterName);
        steps.click_popup_filter_save_button();
        steps.wait_for_all_spinners_dissapears(120);
        steps.check_fatal_errors();
        steps.scroll_to_top();
        steps.check_filter_breadcrumbs_is_displayed();
        steps.waitAjax(10000);
//        //переход в инструменты - выгрузки
        steps.click_goods_filter_create_tool_link();
        
        steps.wait_for_all_spinners_dissapears(60);
        steps.scroll_to_top();
        steps.check_h1_page_title("Добавление фида");
        String feedFilterName   =   steps.get_coupons_feed_filter_name();
        steps.check_values_are_equals(filterName,feedFilterName );
        steps.wait_for_all_spinners_dissapears(30);

                //создание выгрузки
        String downloadNameNew = getCurrentDate()+" "+getRandomIntNumber();
        String subaccountNameNew = getCurrentDate()+" "+getRandomIntNumber();
        steps.fill_name_input(downloadNameNew);
        steps.fill_subaccount_input(subaccountNameNew);
                //выбор сохраненного фильтра
        steps.click_select_choose();
        steps.select_filter_template(filterName);
        steps.submit_form();
        steps.wait_for_all_spinners_dissapears(60);
        steps.wait_for_all_spinners_dissapears(30);
        steps.check_blue_table_has_text(downloadNameNew);
        
        steps.wait_for_all_spinners_dissapears(30);
      
       steps.wait_for_all_spinners_dissapears(30);

        //check created download

        WebElement string = steps.get_blue_table_string_with_text(downloadNameNew);
        steps.click_icon_in_blue_table_line(0, string);


        steps.wait_for_h1_title_appears("Редактирование фида", 20);
        steps.wait_for_all_spinners_dissapears(60);
        steps.check_subaccount_input_has_text(subaccountNameNew);
        steps.check_page_has_text(filterName);

        steps.fill_subaccount_input(subaccountNameNew+"_CHANGED");
        steps.fill_name_input(filterName+"_CHANGED");
        steps.submit_form();
        steps.wait_for_all_spinners_dissapears(60);
        steps.check_fatal_errors();
        steps.check_blue_table_has_text(filterName+"_CHANGED");
        


//         steps.click_downloads_goods_link();
//         steps.waitAjax(3000);
//         steps.delete_all_from_blue_table();
        
        
        steps.close_browser();
      
        
    }
   
    
 
    

    
} 