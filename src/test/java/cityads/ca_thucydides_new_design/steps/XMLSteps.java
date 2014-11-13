/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

/**
 *
 * @author s.lugovskiy
 */
public class XMLSteps extends ApiSteps{

    public XMLSteps(Pages pages) {
        super(pages);
    }

    @Step("parse xml response for parameters")
    public ArrayList<String> parse_xml_feed_responce_for_node(String response, String paremeter) throws ParserConfigurationException, SAXException, IOException {
        
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  //DOM Builder Factory
        DocumentBuilder builder = factory.newDocumentBuilder();                 //DOM Builder
        InputSource is = new InputSource(new StringReader(response));
        Document document = builder.parse(is);
        Node n = document.getFirstChild();
        NodeList nl = n.getChildNodes();
        Node mainNode,childNode;

        ArrayList<String> offerList = new ArrayList();
        
        for (int i=0; i < nl.getLength(); i++) {
            mainNode = nl.item(i);
            if(mainNode.getNodeType()==Node.ELEMENT_NODE) {
                NodeList nl2 = mainNode.getChildNodes();

                for(int i2=0; i2<nl2.getLength(); i2++) {
                   childNode = nl2.item(i2);
                       
                       //System.out.println(childNode.getNodeName() + ": value (" + childNode.getTextContent()+ "):");
                       if(paremeter.equals(childNode.getNodeName())){
                           //System.out.println(childNode.getNodeName() + ": value (" + childNode.getTextContent()+ "):");
                           offerList.add(childNode.getTextContent());
                       };
                       //if(an2.hasChildNodes()) System.out.println(an2.getFirstChild().getNodeValue());
                       //System.out.println(an2.getTextContent());
                       //System.out.println(an2.getNodeValue());
                       
                }

            }
       
        
        
    }
        return offerList;
    }


    @Step("Получаем исходный код страницы")
    public String get_page_source() {
        return getDriver().getPageSource();
    }


    public int get_node_numbers(String node,String response) {
        int lastIndex = 0;
        int count =0;

        while(lastIndex != -1){

            lastIndex = response.indexOf(node,lastIndex);

            if( lastIndex != -1){
                count ++;
                lastIndex+=node.length();
            }
        }
        return count;
    }

    @Step
    public void check_node_number(int i, int number) {
        assertTrue("Проверяем минимальное число нодов в хмл "+number, number>i);
    }
}
