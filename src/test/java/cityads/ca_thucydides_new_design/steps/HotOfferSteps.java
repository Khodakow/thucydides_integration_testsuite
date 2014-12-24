package cityads.ca_thucydides_new_design.steps;

import cityads.ca_thucydides_new_design.pages.refactor.HotOffers;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;

import java.util.Map;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

public class HotOfferSteps extends BaseSteps {

    private HotOffers hotOffers;

    public HotOfferSteps(Pages pages) {
        super(pages);
    }

    @Step("Проверка наличия полей в карточке оффера в блоке хотофферс")
    public void check_fields(){
        Map<String,String> fields = hotOffers.getHotOffersFields();
        String status = fields.get("status");
        String site = fields.get("site");
        String date = fields.get("date");
        String cookieLTV = fields.get("cookieLTV");
        String vertical = fields.get("vertical");
        String type = fields.get("type");
        String retarget = fields.get("retarget");

        assertThat(status, containsString("Статус"));
        assertThat(site, containsString("http"));
        assertThat(date, containsString("Дата активации"));
        assertThat(cookieLTV, containsString("дней"));
        assertThat(type, containsString("Тип: "));
        assertThat(vertical, containsString("Вертикаль"));
        assertThat(retarget, containsString("Ретаргетинг"));
    }

    @Step("Проверяем что число показателей на сводной в блоке хот офферс уменьшилось (<5) после уменьшения размера окна")
    public void check_offercard_tooltip_number() {
        int tooltips = hotOffers.getHotOffersTooltipsNumber();
        assertThat(5, greaterThan(tooltips));
    }

    @Step("Переходим в первый оффер из блока хот-офферс")
    public String go_to_first_hot_offer(){
        return  hotOffers.goToFirstHotOffer();
    }

    @Step("Кликаем на первый круг  в слайдере")
    public void click_first_slider(){
        hotOffers.clickFirstSlider();
        waitABit(3000);
    }

    @Step("Останавливаем слайдер через джаваскрипт _('#hotOffersSlider').pause(true)")
    public void stop_slider() {
        executeScript("_('#hotOffersSlider').pause(true)");
    }
}

    
    
    
    
