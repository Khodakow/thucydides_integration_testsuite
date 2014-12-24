package cityads.ca_thucydides_new_design.WebmasterStory.tools;

import cityads.ca_thucydides_new_design.Constants;
import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.WebmasterSteps.BannerRotatorSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.CarcasSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.FrontSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.TableSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.sql.Connection;


@Story(TestSuite.WebMaster.BannersRotator.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class BannerRotatorStoryTest extends Constants {

     public Connection con;
     public String wmName;
     public String rotatorName = getCurrentDate()+" "+getRandomIntNumber();
     protected String AJSCode;
     protected String JSCode;
     
    

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public BannerRotatorSteps steps;

    @Steps
    CarcasSteps carcas;
    @Steps
    TableSteps table;
    @Steps
    FrontSteps front;

    @Before
    public void setUp(){
        front.login();
    }
    
    @Test
    @Title("Тест на ротатор баннеров")
    @WithTagValuesOf({"block:Instruments","role:Webmaster"})
    public void banner_rotator_test() throws Exception{
       
        

        carcas.go_to_banner_rotator();
        steps.check_fatal_errors();
      
         
        //steps.click_all_th_in_blue_table();
        steps.click_create_button();
        steps.check_fatal_errors();
       
        steps.fill_name_input(rotatorName);
        steps.select_all_promo_type();

        
        //multiselects
        steps.click_i_multiselect_button(0);
        steps.click_some_elements_in_popup_list(2);
        steps.submit_form();
        steps.wait_for_all_spinners_dissapears(190);
        steps.check_fatal_errors();

        //view result
        steps.wait_for_all_spinners_dissapears(60);
        steps.check_blue_table_has_text(rotatorName);
        
        //preview
        steps.click_icon_in_blue_table_line_with_text(2,rotatorName);
       
        steps.check_preview_is_visible();
        //steps.click_h1();
        steps.close_window();
        steps.waitAjax(2000);
        
        //parameters + preview
        steps.click_icon_in_blue_table_line_with_text(0,rotatorName);
        steps.waitAjax(5000);
        steps.check_fatal_errors();
        steps.check_preview_is_visible();
        steps.click_update_button();
        steps.check_fatal_errors();
        steps.check_preview_is_visible();
        
        //change
        steps.click_change_button();
        steps.wait_for_all_spinners_dissapears(30);
        steps.check_fatal_errors();
        String rotatorName2 = getCurrentDate()+" "+getRandomIcqNumber();
        steps.fill_name_input(rotatorName2);
        steps.submit_form();
       

        steps.waitAjax(2000);
        steps.scroll_to_select();
        steps.click_select_choose_toggle();
        steps.select_javascript_code();
        steps.check_fatal_errors();
        JSCode = steps.get_js_code_from_textarea();
        steps.check_banner_code(JSCode);
        
        
        steps.click_select_choose_toggle();
        steps.select_ajs_code();
        steps.waitAjax(2000);
        steps.check_fatal_errors();
        AJSCode = steps.get_ajs_code_from_textarea();
        steps.check_banner_code(AJSCode);
        
        steps.click_select_choose_toggle();
        steps.select_xml_code();
        steps.check_fatal_errors();
        steps.get_xml_code_from_textarea();
        
        //check saved name
        //steps.go_back();
        steps.click_banners_rotator();
        steps.wait_for_all_spinners_dissapears(90);
        steps.check_blue_table_has_text(rotatorName2);

        
        
    }
    
    @Test
    @Title("Тест на ротатор баннеров только 1100AD и флеш")
    @WithTagValuesOf({"block:Instruments","role:Webmaster"})
    public void banner_rotator_one_offer_flash_banner_test() throws Exception{

        String flashOfferName = "1100AD";
        String rotatorName2 = getCurrentDate()+" "+getRandomIntNumber();
        String offerNameInRotatorParams;


        carcas.go_to_banner_rotator();
        steps.check_fatal_errors();
        steps.check_fatal_errors();

        
        //steps.click_all_th_in_blue_table();
        steps.click_create_button();
        steps.check_fatal_errors();
        steps.fill_name_input(rotatorName2);
        
        //form fill============================
        steps.waitAjax(2000);
        steps.select_flash_promo_type();
        steps.waitAjax(2000);
        steps.click_i_multiselect_button(1);
        steps.click_offer_in_popup_list(flashOfferName);
        steps.submit_form();
        steps.waitABit(10000);
        
        //view result
        steps.wait_for_all_spinners_dissapears(90);
        steps.check_blue_table_has_text(rotatorName2);
        
        //check offer name present in last rotator
        //steps.sort_blue_table_by_id();
        steps.click_icon_in_blue_table_line_with_text(0,rotatorName2);
        steps.wait_for_h1_title_appears("Параметры",25);
        steps.waitAjax(3000);
        offerNameInRotatorParams = steps.get_offer_name_in_rotataor_params();
        steps.check_values_are_equals(offerNameInRotatorParams, flashOfferName);
        steps.check_banner_preview_has_only_FLASH_tag(); //check this is image banner
        steps.click_offer_name_in_rotataor_params();
        //steps.wait_for_offer_params_page_appears(25);
        steps.wait_for_h1_title_appears(flashOfferName, 25);
        steps.waitAjax(3000);
        //go back to rotators
        steps.click_instruments_link();
        steps.wait_for_all_spinners_dissapears(90);
        steps.click_rotators_link();
        steps.wait_for_all_spinners_dissapears(90);
        steps.wait_for_blue_table_appears(25);
        steps.waitAjax(3000);

    }

    @Test
    @Title("Тест на ротатор баннеров только 1100AD и img")
    @WithTagValuesOf({"block:Instruments","role:Webmaster"})
    public void banner_rotator_one_offer_image_banner_test() throws Exception{
        String rotatorName3 = getCurrentDate()+" "+getRandomIntNumber();
        String offerNameInRotatorParams;
        String offerWithImgBanner = "1100AD";

        carcas.go_to_banner_rotator();
        steps.check_fatal_errors();
        steps.check_fatal_errors();

        //steps.click_all_th_in_blue_table();
        steps.click_create_button();
        steps.check_fatal_errors();
       
        steps.fill_name_input(rotatorName3);
        
        //form fill============================
        steps.waitAjax(2000);
        steps.click_i_multiselect_button(1);
        steps.click_offer_in_popup_list(offerWithImgBanner);
        steps.select_image_promo_type();
        steps.submit_form();
        steps.waitABit(10000);
        steps.wait_for_all_spinners_dissapears(90);
        steps.check_fatal_errors();
        //view result
        steps.waitAjax(8000);
        steps.check_blue_table_has_text(rotatorName3);
        
        //check offer name present in last rotator
        //steps.sort_blue_table_by_id();
        steps.click_icon_in_blue_table_line_with_text(0,rotatorName3);
        steps.wait_for_h1_title_appears("Параметры",25);
        steps.waitAjax(3000);
        offerNameInRotatorParams = steps.get_offer_name_in_rotataor_params();
        steps.check_values_are_equals(offerNameInRotatorParams, offerWithImgBanner);
        steps.check_banner_preview_has_only_IMG_tag(); //check this is image banner
        steps.click_offer_name_in_rotataor_params();
        //steps.wait_for_offer_params_page_appears(25);
        steps.wait_for_h1_title_appears(offerWithImgBanner, 25);
        steps.waitAjax(3000);
        //go back to rotators
        steps.click_instruments_link();
        steps.waitAjax(2000);
        steps.click_rotators_link();
        steps.wait_for_all_spinners_dissapears(90);
        steps.wait_for_blue_table_appears(25);
        steps.waitAjax(3000);

        
        
    }
   
} 