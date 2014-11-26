/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.steps.refactor_steps;

import cityads.ca_thucydides_new_design.pages.refactor.Goods;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

/**
 *
 * @author s.lugovskiy
 */
public class GoodsSteps extends ScenarioSteps {

    public Goods goods;

    @Step("Отсортировать по цене по убыванию")
    public void sort_by_price_desc(){
        goods.sortByPriseDesc();
    }

    @Step
    public void check_goods_price_desc_sort(){
        check_desc_sort();
    }

    @StepGroup
    public void check_desc_sort(){
        ArrayList<Float> data = goods.getPrices();
        check_desc_array(data);
    }

    @Step
    public void check_desc_array(ArrayList<Float> data){
        int j;
        boolean sorted = true;
        Float current = null;
        Float prev = null;
        for(j=0; j<data.size()-1;j++){
            if(data.get(j)<data.get(j+1)){
                sorted = false;
                current = data.get(j+1);
                prev =  data.get(j);
                break;
            }
        }
        assertTrue("Сортировка по цене неверна : "+prev+" < "+current,sorted);
    }

    @Step
    public void check_asc_array(ArrayList<Float> data){
        int j;
        boolean sorted = true;
        Float current = null;
        Float prev = null;
        for(j=0; j<data.size()-1;j++){
            if(data.get(j)>data.get(j+1)){
                sorted = false;
                current = data.get(j+1);
                prev =  data.get(j);
                break;
            }
        }
        assertTrue("Сортировка по цене неверна : "+prev+" > "+current,sorted);
    }


    @Step("Отсортировать по цене по возрастанию")
    public void sort_by_price_asc() {
        goods.sortByPriseAsc();
    }

    @StepGroup
    public void check_asc_sort(){
        ArrayList<Float> data = goods.getPrices();
        check_asc_array(data);
    }

    @Step("Отмечаем валюту USD")
    public void click_USD_checkbox(){
        goods.clickBRLcheckbox();
    }

    @Step
    public void check_goods_price_asc_sort() {
        check_asc_sort();
    }

    @Step
    public int get_total_goods(){
        return goods.getTotalGoods();
    }

    @Step
    public void createFeed(String feedName) {
        goods.createFeed(feedName);
    }

    @Step("Получаем первую ссылку на товар из системы")
    public String get_first_goods_url() {
        return goods.getFirstGoodLink();
    }

    @Step("Получаем первую ссылку на товар на сайт рекла")
    public String get_first_landing_url() {
        return goods.getFirstLandingUrl();
    }
}
    

