package cityads.ca_thucydides_new_design.pages.refactor;

import net.thucydides.core.annotations.findby.By;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;


public class StatTable extends Table {

    public StatTable(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//table[contains(@class,'blue_table')]/thead/tr[2]/th[@col_name=\"dynamics\"]/div")
    private WebElementFacade dynamicTh;

    @FindBy(xpath="(//div[@class='_button_place']/div[contains(@class,'_dd_button')])[1]")
    private WebElementFacade addParam;

    @FindBy(xpath="(//table/tbody/tr/td[contains(@class,'subaccount')]/nobr/a)[1]")
    private WebElementFacade firstSubaccount;

    @FindBy(xpath="//div[@class='overflow _scroll _has_scrollable']/div[@data-bind='foreach: items']")
    private WebElementFacade addParamsList;

    private WebElementFacade getTh(int column){
        return this.find(By.xpath("//table[contains(@class,'blue_table _border_columns')]/thead/tr[position()=2]/th[" + column + "]/div/a"));
    }

    private void clickTh(int column){
        Actions builder = new Actions(getDriver());
        //Action click = builder.moveToElement(getTh(column)).moveByOffset(-5,0).click().build();
        //click.perform();
        evaluateJavascript("$('table[class*=\"blue_table\"]>thead>tr:eq(1)>th:eq("+String.valueOf(column-1)+")').click()");
        waitForSpinnerDissapear();
        Action move = builder.moveToElement(this.find(By.xpath("//div[contains(@class,'absolute back-ccc pointer') and contains(@style,'width: 25%')]"))).build();
        move.perform();
        waitForSpinnerDissapear();
        evaluateJavascript("$('html, body').animate({ scrollTop: $('.blue_table').offset().top }, 0);");
    }

    public ArrayList<Float> getColumnSortedData(int column){
        int count = 0;
        if(getTh(column).isCurrentlyVisible()){
            while(!getTh(column).getAttribute("class").contains("th-down sorted")){
                clickTh(column);
                count++;
                if(count>3){
                    break;
                }
            }
        }

        waitForSpinnerDissapear();
        List<WebElement> values = getDriver().findElements(By.xpath("//table[contains(@class,'blue_table')]/tbody/tr/td[position()="+column+"]/nobr"));

        ArrayList<Float> tds = new ArrayList<Float>();
        for(WebElement value: values){
            tds.add(Float.valueOf(value.getAttribute("innerHTML").trim().replace("%","").replaceAll("’","")));
        }
        return tds;
    }


    public void sortByDynamic() {
        dynamicTh.waitUntilVisible();
        this.evaluateJavascript("$('table[class*=\"blue_table\"]>thead>tr:eq(1)>th:eq(3)').trigger('click');");
        this.waitABit(3000);
        waitForSpinnerDissapear();
    }

    public void clickFirstSubaccount() {
        waitForSpinnerDissapear();
        firstSubaccount.waitUntilVisible();
        firstSubaccount.click();
        waitForSpinnerDissapear();
    }

    public void addAddparameter(String text) {
        waitForSpinnerDissapear();
        addParam.waitUntilVisible();
        addParam.click();
        popup.fillPopupInputSearchParameter(text);
        waitForSpinnerDissapear();

    }

    public void checkAddParamsListNotContains(String text){
        addParam.waitUntilVisible();
        addParam.click();
        popup.fillPopupInputSearchParameterWithoutClick(text);
        assertFalse("Проверяем что слово не найдено в списке субаккаунтов "+text,addParamsList.getText().contains(text));
    }


}





