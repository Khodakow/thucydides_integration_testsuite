package cityads.ca_thucydides_new_design.pages.refactor;


import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

import static junit.framework.Assert.assertTrue;


public class BackUrl extends BasePage {


    public BackUrl(WebDriver driver) {
        super(driver);
    }


    //Structure Instruments
    @FindBy(xpath="//div[@id='pagePath']")   //Хлебные крошки
    private WebElementFacade pagePath;
    @FindBy(xpath="//a[contains(@id,'unical_id_default_0')]") // Таб Сводной
    private WebElementFacade summary;
    @FindBy(xpath="//a[@id='create_user']") // Кнопка создать
    private WebElementFacade createButton;
    @FindBy(xpath="//a[contains(@class,'help')]") // Кнопка хелпов
    private WebElementFacade helpButton;
    @FindBy(xpath="//a[contains(@class,'api')]") // Кнопка API
    private WebElementFacade apiButton;
    @FindBy(xpath="//input[contains(@id,'global_search')]") // Поиски в меню и глобал поиск
    private WebElementFacade search;
    @FindBy(xpath="//ul[contains(@class,'paginator')]") // Пагинатор
    private WebElementFacade paginator;
    //StructureInCreateForm
    @FindBy(xpath="//input[contains(@id,'id_el_text_field')]") // Инпуты в форме создания
    private WebElementFacade inputs;
    @FindBy(xpath="//label[@class='checkbox ']") // Чекбокс Стандартная в форме создания
    private WebElementFacade checkbox;
    @FindBy(xpath="//button[@type='submit']") // Кнопка Сохранить
    private WebElementFacade saveButton;
    //Structure Offers
    @FindBy(xpath="//th[contains(@class,'back_url')]")   //BackUrl в заголовке таблицы
    private WebElementFacade backUrlHeaderinTable;
    @FindBy(xpath="//a[contains(@class,'back-url')]")   //BackUrl иконки в таблице
    private WebElementFacade backUrllinks;
    @FindBy(xpath="//div[contains(@class,'_select _back_url')]/div[contains(@class,'select-choose pointer')]")   //Стрелка выбора бек урла в поп апе офферов
    private WebElementFacade pointerInBackurlPopup;
    @FindBy(xpath="(//div[contains(@class,'select-list')]/a)[2]")   //Лист всех бек урлов доступных для выбора в оффере
    private WebElementFacade backurlList;
    @FindBy(xpath="//div[contains(@class,'select-list')]")   //Весь выпадающий список бек урлов как один элемент
    private WebElementFacade backurlAllList;
    @FindBy(xpath="//a[contains(@class,'button dark  submi')]")   //Весь выпадающий список бек урлов как один элемент
    private WebElementFacade backurlSaveChosenBackurl;
    @FindBy(xpath="//a[contains(@class,'back-url-blue')]")   //Весь выпадающий список бек урлов как один элемент
    private WebElementFacade chosenBackUrl;
    //Create back url
    @FindBy(xpath="//input[@name='name']")   //Импут название бек урла в форме создания
    private WebElementFacade nameBackurlinput ;
    @FindBy(xpath="//input[@name='back_url']")   //Импут ссылка бек урла в форме создания
    private WebElementFacade linkBackurlinput ;
    //Удаление back url
    @FindBy(xpath="//label[@for='checkbox_446811153']")   //Чекбокс выбирающий все записи в таблице
    private WebElementFacade  checkboxChooseAll;
    @FindBy(xpath="//a[contains(@id,'delete')]")   //Кнопка удаления
    private WebElementFacade  deleteicon;
    @FindBy(xpath="//a[contains(@class,'confirm_yes')]")   //Подтвердить действие удаления в popup
    private WebElementFacade  confirmDeleteButton;




    public void checkStructureBackurlTools(){
        waitForSpinnerDissapear();
        assertTrue("Нет хлебных крошек ",pagePath.isCurrentlyVisible());
        assertTrue("Нет Таба Сводной ",summary.isCurrentlyVisible());
        assertTrue("Нет кнопки создать ",createButton.isCurrentlyVisible());
        assertTrue("Нет хелпов ",helpButton.isCurrentlyVisible());
        assertTrue("Нет апи ",apiButton.isCurrentlyVisible());
        assertTrue("Нет поиска ",search.isCurrentlyVisible());
        assertTrue("Нет Пагинатор ",paginator.isCurrentlyVisible());
    }
    public void checkStructureCreateFormbackurlTools(){
        waitForSpinnerDissapear();
        assertTrue("Нет импутов ",inputs.isCurrentlyVisible());
        assertTrue("Нет чекбокса ",checkbox.isCurrentlyVisible());
        assertTrue("Нет кнопки сохранить ",saveButton.isCurrentlyVisible());

    }

    public void checkStructureBackUrlInOffres(){
        waitForSpinnerDissapear();
        assertTrue("Нет колонки бек урл ",backUrlHeaderinTable.isCurrentlyVisible());
        assertTrue("Нет кнопки бек урла ",backUrllinks.isCurrentlyVisible());
    }

    public void clickCreateBackUrl(){
        createButton.waitUntilVisible();
        createButton.click();
    }
    public void fillBackUrlCreateForm(String name,String url){
        nameBackurlinput.waitUntilVisible();
        nameBackurlinput.clear();
        nameBackurlinput.sendKeys(name);

        linkBackurlinput.waitUntilVisible();
        linkBackurlinput.clear();
        linkBackurlinput.sendKeys(url);

        saveButton.waitUntilVisible();
        saveButton.click();

    }
    public void clickChooseBackUrl(){
        backUrllinks.waitUntilVisible();
        backUrllinks.click();
    }

    public void choose1stBackUrl(){
        backUrllinks.waitUntilVisible();
        backUrllinks.click();
        waitForSpinnerDissapear();
        pointerInBackurlPopup.waitUntilVisible().click();
        backurlList.waitUntilVisible();
        backurlList.click();
        backurlSaveChosenBackurl.waitUntilVisible();
        backurlSaveChosenBackurl.click();
        waitForSpinnerDissapear();
        assertTrue("Нет выбранного бек урла в таблице ", chosenBackUrl.isCurrentlyVisible());
    }
    public void deleteAllFromBackUrlTable(){
        checkboxChooseAll.waitUntilVisible().click();
        deleteicon.waitUntilVisible().click();
    }

    public void confirmDelete(){
        confirmDeleteButton.waitUntilVisible().click();
    }
}





