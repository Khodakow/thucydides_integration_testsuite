package cityads.ca_thucydides_new_design.pages.refactor;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;


public class Chart extends BasePage {


    public Chart(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//div[@graph_overview_data='Лиды' or @graph_overview_data='Leads']/nobr")
    private WebElementFacade leads;

    @FindBy(xpath="//div[@graph_overview_data='Клики' or @graph_overview_data='Clicks']/nobr")
    private WebElementFacade clicks;

    @FindBy(xpath="//div[@graph_overview_data='Хиты' or @graph_overview_data='Hits']/nobr")
    private WebElementFacade hits;

    @FindBy(xpath="//div[@graph_overview_data='Продажи' or @graph_overview_data='Vendas' @graph_overview_data='Sales']/nobr")
    private WebElementFacade sales;

    public int getLeads(){
        leads.waitUntilVisible();
        int lead;
        lead = Integer.valueOf(leads.getText().replace("’","").replace(".","").replace(",",""));
        return lead;
    }

    public int getClicks(){
        clicks.waitUntilVisible();
        int lead;
        lead = Integer.valueOf(clicks.getText().replace("’","").replace(".","").replace(",",""));
        return lead;
    }

    public int getSales(){
        sales.waitUntilVisible();
        int lead = Integer.valueOf(sales.getText().replace("’","").replace(".","").replace(",",""));
        return lead;
    }

    public int getHits(){
        hits.waitUntilVisible();
        int lead = Integer.valueOf(hits.getText().replace("’","").replace(".","").replace(",",""));
        return lead;
    }




}





