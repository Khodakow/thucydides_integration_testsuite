package cityads.ca_thucydides_new_design.WebmasterStory.translate.br;

import cityads.ca_thucydides_new_design.requirements.TestSuite;
import cityads.ca_thucydides_new_design.steps.BaseSteps;
import cityads.ca_thucydides_new_design.steps.MainSiteSteps;
import cityads.ca_thucydides_new_design.steps.refactor_steps.*;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Story(TestSuite.WebMaster.Translate.class)
@RunWith(ThucydidesRunner.class)
@WithTag(name="Webmaster Tests")
public class ApiDocsTranslateTest {

    public String wmName;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public BaseSteps baseSteps;

    @Steps
    public MainSiteSteps steps;


    @Steps
    public CarcasSteps carcas;

    @Steps
    public FormSteps form;

    @Steps
    public FrontSteps front;

    @Steps
    ApiDocsSteps apiDocs;


    @Test
    public void apiDocsTranslateTest() throws Exception{

        carcas.go_to_api_docs();
        apiDocs.change_api_docs_lang_to_en();
        baseSteps.check_lang_select();

    }

    @Test
    public void apiDocAuthorizationTranslateTest() throws Exception{
        carcas.go_to_api_docs();
        apiDocs.go_to_authorization();
        apiDocs.change_api_docs_lang_to_en();
        baseSteps.check_lang_select();
    }

    @Test
    public void apiDocSoapTranslateTest() throws Exception{
        carcas.go_to_api_docs();
        apiDocs.go_to_soap();
        apiDocs.change_api_docs_lang_to_en();
        baseSteps.check_lang_select();
    }

    @Test
    public void apiDocRestTranslateTest() throws Exception{
        carcas.go_to_api_docs();
        apiDocs.go_to_rest();
        apiDocs.change_api_docs_lang_to_en();
        baseSteps.check_lang_select();
    }

    @Test
    public void apiDocQuotingTranslateTest() throws Exception{
        carcas.go_to_api_docs();
        apiDocs.go_to_qouting();
        apiDocs.change_api_docs_lang_to_en();
        baseSteps.check_lang_select();
    }


    @Test
    public void apiDocLangTranslateTest() throws Exception{
        carcas.go_to_api_docs();
        apiDocs.go_to_lang();
        apiDocs.change_api_docs_lang_to_en();
        baseSteps.check_lang_select();
    }

    @Test
    public void apiDocOffersTranslateTest() throws Exception{
        carcas.go_to_api_docs();
        apiDocs.go_to_offers();
        apiDocs.change_api_docs_lang_to_en();
        baseSteps.check_lang_select();
    }

    @Test
    public void apiDocListTranslateTest() throws Exception{
        carcas.go_to_api_docs();
        apiDocs.go_to_list();
        apiDocs.change_api_docs_lang_to_en();
        baseSteps.check_lang_select();
    }

    @Test
    public void apiDocUserTranslateTest() throws Exception{
        carcas.go_to_api_docs();
        apiDocs.go_to_user();
        apiDocs.change_api_docs_lang_to_en();
        baseSteps.check_lang_select();
    }

    @Test
    public void apiDocGoodsTranslateTest() throws Exception{
        carcas.go_to_api_docs();
        apiDocs.go_to_goods();
        apiDocs.change_api_docs_lang_to_en();
        baseSteps.check_lang_select();
    }

    @Test
    public void apiDocStatTranslateTest() throws Exception{
        carcas.go_to_api_docs();
        apiDocs.go_to_stat();
        apiDocs.change_api_docs_lang_to_en();

        baseSteps.check_lang_select();
    }

    @Test
    public void apiDocToolsTranslateTest() throws Exception{
        carcas.go_to_api_docs();
        apiDocs.go_to_stat();
        apiDocs.change_api_docs_lang_to_en();
        baseSteps.check_lang_select();
    }

    @Test
    public void apiDocLibTranslateTest() throws Exception{
        carcas.go_to_api_docs();
        apiDocs.go_to_lib();
        apiDocs.change_api_docs_lang_to_en();
        baseSteps.check_lang_select();
    }

} 