package cityads.ca_thucydides_new_design.steps;

import cityads.ca_thucydides_new_design.Constants;
import junit.framework.Assert;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class SetupSteps extends BaseSteps {

    @Step
    public static String fileToString(String file) {
        String result = null;
        DataInputStream in = null;
        try {
            File f = new File(file);
            byte[] buffer = new byte[(int) f.length()];
            in = new DataInputStream(new FileInputStream(f));
            in.readFully(buffer);
            result = new String(buffer);
        } catch (IOException e) {
            throw new RuntimeException("IO problem in fileToString", e);
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                /* ignore it */
            }
        }
        return result;
    }

    Constants con = new Constants();
    String baseUrl = con.baseUrl;
    String ipDB = con.ipDB;
    String nameDB = con.mysqlDatabaseName;
    String userDB = con.userDB;
    String userPassword = con.passwordDB;
    private Object steps;
    
    
    public SetupSteps(Pages pages) {
        super(pages);
    }


    @Step
    public void open_url(String url){
        getDriver().get(url);
    }

    @Step
    public WebDriver set_driver(String proxyurl){
        Proxy proxy = new Proxy();
        proxy.setHttpProxy(proxyurl);
        String hub = System.getProperty("webdriver.remote.url");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability(CapabilityType.PROXY,proxy);
        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL(hub), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        getPages().setDriver(driver);
        return driver;
    }

    @Step
    public String getUrlHost(String currentUrl){
        URL url = null;
        try {
            url = new URL (currentUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        String host = url.getHost();
        return host;

    }


    @Step
    public String getTopDomain(String host){
        try {
            URL url = new URL(host);
            String[] domainNameParts = url.getHost().split("\\.");
            return domainNameParts[domainNameParts.length-2];
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Step
    public String get_wm_name(){
              String wm_name = System.getProperty("user");  
              return wm_name;
}
    
    @Step
    public String get_wm_passewrd(){
              String wm_name = System.getProperty("password");  
              return wm_name;
    }
    
    @Step
    public String get_campaign_from_db_for_target_creation_test(Connection conn) throws SQLException{
              String campaign = "";  //default 
              String query = "select campaign.name"
                      + " from traffic_cluster"
                      + " inner join user on user.id = traffic_cluster.user_id"
                      + " inner join campaign  on traffic_cluster.campaign_id=campaign.id order by campaign.name desc"; 
		Statement stmt = conn.createStatement();
                      ResultSet rs = stmt.executeQuery(query);
                      while (rs.next()) {
		      campaign = rs.getString(1);
                       
    }
    return campaign;
    }
    
    @Step
    public String get_prx_from_db_for_target_creation_test(Connection conn) throws SQLException{
              String prx = "";  //default 
              String query = "select traffic_cluster.id"
                      + " from traffic_cluster"
                      + " inner join user on user.id = traffic_cluster.user_id"
                      + " inner join campaign  on traffic_cluster.campaign_id=campaign.id order by campaign.name desc"; 
		Statement stmt = conn.createStatement();
                      ResultSet rs = stmt.executeQuery(query);
                      while (rs.next()) {
		      prx = rs.getString(1);
                       
    }
    return prx;
    }
    
    @Step
    public String get_another_wm_name_from_db(Connection conn,String wm) throws SQLException{
              String wm_name = "";  //default webmaster
              String query = "select user.email"
                      + " from traffic_cluster"
                      + " inner join user on user.id = traffic_cluster.user_id"
                      + " inner join campaign  on traffic_cluster.campaign_id=campaign.id where user.email <> ( '"+wm+"' )   order by campaign.name desc"; 
		Statement stmt = conn.createStatement();
                      ResultSet rs = stmt.executeQuery(query);
                      while (rs.next()) {
		      wm_name = rs.getString(1);
                       
    }
    return wm_name;
}

    @Step 
    public String assert_submission_for_wmid_and_orderKey_is_not_empty(Connection conn, String wmName, String orderId) throws Exception{
                      String id="";  
                      String query = "select id"
                      + " from submission"
                      + " where user_id="+wmName+" AND order_key="+orderId; 
                      Statement stmt = conn.createStatement();
                      ResultSet rs = stmt.executeQuery(query);
                      Assert.assertNotNull(rs);
		      while (rs.next()) {
                      id = rs.getString(1);
                      }
                      Assert.assertFalse(id.isEmpty());
                      return id;
    }
    
    @Step
    public void assert_submission_has_status_8_after_changeStatuses_script(Connection conn, String id) throws SQLException{
                      String status= "";
                      String query = "select submission_status_id from submission where id="+id; 
                      Statement stmt = conn.createStatement();
                      ResultSet rs = stmt.executeQuery(query);
		      while (rs.next()) {
                      status = rs.getString(1);
                      }
                      Assert.assertEquals("8", status);
    }
    
    @Step
    public String get_wm_id_from_db_for_submission_check(Connection conn, String wmName) throws SQLException{
                      String wmId="";  
                      String query = "select id"
                      + " from user"
                      + " where email= '"+wmName+"' "; 
                      Statement stmt = conn.createStatement();
                      ResultSet rs = stmt.executeQuery(query);
                      while (rs.next()) {
		      wmId = rs.getString(1);
                       }
                      return wmId;
    }
    
    @Step
    public void proof_stringData(String s1,String s2){
    Assert.assertEquals(s1,s2);
    }
    
    @Step
    public String save_code(String Code) throws Exception{
      Thread.sleep(1000);
      Date j = new Date();
      j.getTime(); 
      DateFormat df = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
      String newDate = df.format(j);
      
      try 
      {   
          String workingDir = System.getProperty("user.dir");
          String FILE = workingDir+"\\"+newDate+".html";
          File file1 = new File(FILE);
          PrintWriter out = new PrintWriter(new FileWriter(file1)); 
          out.print(Code);
          out.close();
          return FILE;
      }
      catch (Exception e){
          
          String workingDir = System.getProperty("user.dir");
          String FILE = workingDir+"/"+newDate+".html";                  //для линукса
          File file1 = new File(FILE);
          PrintWriter out = new PrintWriter(new FileWriter(file1)); 
          out.print(Code);
          out.close();
          return FILE;
          
      }
}
    
    @Step
    public String strip_code_for_direct_browser_execution(String code){
        String newCode1 = code.replaceAll("<script type=\"text/javascript\">","");
        String newCode = newCode1.replaceAll("</script>","");
        return newCode;
    }

    @Step
    public void mgr_login() {
        open_main_page();
        click_login_button();
        enter_login("dkrivitski@gameleads.ru");
        enter_password();
        click_remember_me_field();
        click_enter_button();
        check_fatal_errors();
    }
    
    @Step
    public Set<String> get_window_handles(){
        Set<String> handleList = getDriver().getWindowHandles();
        return handleList;
           
        }
    
    @Step
    public String get_last_window_handle(Set<String> set){
        String handle = getDriver().getWindowHandle();
        Iterator it = set.iterator();
        while(it.hasNext()){
            handle = it.next().toString();
        }
        return handle;
    }
    
    @Step
    public String get_first_window_handle(Set<String> set){
        String handle = getDriver().getWindowHandle();
        Iterator it = set.iterator();
        while(it.hasNext()){
            handle = it.next().toString();
            return handle;
        }
        return handle;
        
    }

    @StepGroup
    public void switch_to_last_window(){
        Set<String> handleList = get_window_handles();
        String lastHandle = get_last_window_handle(handleList);
        switch_to_last_window(lastHandle);
    }
    
    @StepGroup
    public void switch_to_first_window(){
        Set<String> handleList = get_window_handles();
        String firsthandle = get_first_window_handle(handleList);
        switch_to_first_window(firsthandle);
    }
    
    @Step
    public void switch_to_last_window(String handle){
        getDriver().switchTo().window(handle);
    }
    
    @Step
    public void switch_to_first_window(String handle){
        getDriver().switchTo().window(handle);
    }
    
    @Step
    public BufferedImage  make_screenshot_of_webelement(WebElement elem) throws IOException{
        File screen = ((TakesScreenshot) this.getDriver()).getScreenshotAs(OutputType.FILE);

        Point p = elem.getLocation();

        int width = elem.getSize().getWidth();
        int height = elem.getSize().getHeight();

        BufferedImage img = ImageIO.read(screen);

        BufferedImage dest = img.getSubimage(p.getX(), p.getY(), width,        height);

        ImageIO.write(dest, "png", screen);

        //File f = null;
        
        //f = new File(elem.getTagName()+"_"+elem.getAttribute("class")+"_"+Integer.valueOf(elem.getLocation().getX())+"_"+Integer.valueOf(elem.getLocation().getY())+".png");
        
        //FileUtils.copyFile(screen, f); включить когда потребуется сделать скрин для хранения и последующего сравнения
        return dest;

    }
   
    @Step
    public int calculate_dates_interval(String date1, String date2) throws java.text.ParseException{
        int period = 0;
        
        Calendar cal1 = new GregorianCalendar();
        Calendar cal2 = new GregorianCalendar();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd.MM.yyyy");
        Date calendarDate1 = dateFormatter.parse(date1);
        Date calendarDate2 = dateFormatter.parse(date2);

        cal1.setTime(calendarDate1);
        cal2.setTime(calendarDate2);
        
        period = daysBetween(cal1.getTime(),cal2.getTime());
        
        return period;
    }
    
    public int daysBetween(Date d1, Date d2){
             return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24))+2;   // +2 т.к. включительно
     }
    
    @Step
    public void check_values_are_in_interval(int min, int val, int max){
        Assert.assertTrue(val<=max && val>=min);
    }

    @Step
    public void switch_to_first_iframe() {
        getDriver().switchTo().frame(0);
    }

    @Step("уменьшить размер окна в N раз")
    public void resize_window(int i) {
        Dimension dimension = getDriver().manage().window().getSize();
        System.out.println("Window size: "+dimension);

        int width = dimension.getWidth();
        int height = dimension.getHeight();
        width /= i;
        height /= i;
        Dimension newdim = new Dimension(width,height);

        getDriver().manage().window().setSize(newdim);
        dimension = getDriver().manage().window().getSize();
        System.out.println("New window size: "+dimension);
        waitABit(3000);
        refresh_page();
    }
}

    


    
    
    
