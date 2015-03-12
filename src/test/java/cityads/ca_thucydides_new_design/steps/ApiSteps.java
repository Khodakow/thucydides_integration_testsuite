/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Assert;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author s.lugovskiy
 */
public class ApiSteps extends SetupSteps{

    public ApiSteps(Pages pages) {
        super(pages);
    }

    @Step
    public String send_post_request(String apiAdress,String parameters) throws Exception{



        URL url = new URL(getPages().getDefaultBaseUrl()+apiAdress);
        String host = url.getHost().replaceAll("/","").replace("?lang=ru", "");
        String newUrl = "http://"+host+apiAdress;
        System.out.println(newUrl);
        URL normalizedUrl = new URL(newUrl);

        HttpURLConnection con = (HttpURLConnection) normalizedUrl.openConnection();

        //add reuqest header
        con.setRequestProperty("Accept-Charset", "UTF-8");
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        con.setRequestProperty("X-Requested-With", "XMLHttpRequest");
        con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/34.0.1847.116 Safari/537.36");


        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(parameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();


        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream(), "UTF-8"));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }

    @Step
    public String send_get_request(String apiAdress) throws Exception{



        URL url = new URL(getPages().getDefaultBaseUrl()+apiAdress);
        String host = url.getHost().replaceAll("/","").replace("?lang=ru", "");
        String newUrl = "http://"+host+apiAdress;
        URL normalizedUrl = new URL(newUrl);

        HttpURLConnection con = (HttpURLConnection) normalizedUrl.openConnection();

        //add reuqest header
        con.setRequestProperty("Accept-Charset", "UTF-8");
        con.setRequestMethod("GET");
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.flush();
        wr.close();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream(), "UTF-8"));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }

    @Step
    public String send_clean_get_request(String apiAdress) throws Exception{

        BufferedReader rd;
        String line;
        String result = "";
        URL url = new URL(apiAdress.trim().replaceAll("'",""));
        HttpURLConnection conGet;
        conGet = (HttpURLConnection) url.openConnection();
        conGet.setRequestMethod("GET");
        rd = new BufferedReader(new InputStreamReader(conGet.getInputStream()));
        while ((line = rd.readLine()) != null) {
            result += line;
        }
        rd.close();
        Thread.sleep(500);
        return result;
    }


    public JSONObject parse_json_response(String response) throws Exception{

        JSONParser parser = new JSONParser();
        Object obj = parser.parse(response);
        if(obj instanceof JSONObject){
            JSONObject jsonObj = (JSONObject) obj;
            jsonObj.remove("total");
            return jsonObj;}
        else{
            throw new Exception(" http response is not in JSON format: "+response);
        }

    }

    @Step
    public void check_json_response_contains_data_entry(JSONObject response){
        JSONObject data = (JSONObject) response.get("data");
        Assert.assertTrue(!data.isEmpty());

    }

    @Step
    public String get_json_response_status(JSONObject response){
        String status =  response.get("status").toString();
        return status;
    }

    @Step
    public void check_json_code_status_is_200(String status, String ok) {
        Assert.assertEquals(status.toString(), ok);
    }

    @Step
    public void check_json_responce_X_and_Y_is_in_range(JSONObject response, int min, int max) {
        JSONObject data = (JSONObject) response.get("data");
        JSONArray x = (JSONArray)data.get("x");
        JSONArray y = (JSONArray)data.get("y");

        for (Object elem : x) {
            check_value_for_date_regular_expression(elem.toString());
        }

        for (Object elem : y) {
            check_integer_is_in_range(min,Integer.parseInt(elem.toString()),max);
        }
    }

    @Step
    public void check_cpl_delta_is_not_greater_than(JSONObject response, int max){
        //проверка на резкое падение конверсии
        JSONObject data = (JSONObject) response.get("data");
        JSONArray y = (JSONArray)data.get("y");
        int sizeY = y.size();
        int j = 0;
        for(j=0; j<sizeY-1; j++){

            float yPrev = Float.parseFloat(y.get(j).toString());
            float yActual = Float.parseFloat(y.get(j+1).toString());
            float delta = yActual-yPrev;
            float percentageDelta = delta/yPrev*100;
            if(percentageDelta<0){
                check_CPL_fall_is_not_bigger(percentageDelta,max);
            }

        }
    }

    @Step
    public void check_value_for_date_regular_expression(String elem){
        String re1="((?:(?:[0-2]?\\d{1})|(?:[3][01]{1}))[-:\\/.](?:[0]?[1-9]|[1][012])[-:\\/.](?:(?:[1]{1}\\d{1}\\d{1}\\d{1})|(?:[2]{1}\\d{3})))(?![\\d])";	// DDMMYYYY 1
        Pattern p = Pattern.compile(re1,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher m = p.matcher(String.valueOf(elem));
        Assert.assertTrue(m.find());
        //System.out.println("date found: "+m.group(1));
    }

    @Step
    public void check_integer_is_in_range(int min, int elem, int max){
        Assert.assertTrue(elem>min && elem<max);
    }

    @Step
    public void check_CPL_fall_is_not_bigger(float elem, float max){
        Assert.assertTrue(Math.abs(elem)<max);
    }

    @Step
    public String parse_url_for_api_test(String url){
        String[] urlParts = url.replace("//","").split("/",2);
        String urlPart = "/"+urlParts[1];
        return urlPart.replace("1000","10");
    }


    public ArrayList<String> parse_json_feed_response_for_parameter(JSONObject response, String parameter) throws Exception {

        Collection <JSONObject> jsonNodes = response.values();
        ArrayList <String> actionIdList = new ArrayList<String>();
        for(JSONObject elem:jsonNodes){

            try{
                String actionId = elem.get(parameter).toString();
                System.out.println(actionId);
                actionIdList.add(actionId);
            }
            catch(NullPointerException e){
                throw new AssertionError("Can not parse json feed for "+parameter);
            }

        }

        return actionIdList;


    }

    @Step
    public void check_list_has_correct_values(String text, ArrayList<String> offerList) {
        for (String elem : offerList) {
            check_values_are_equals(elem, text);
        }
    }
}
