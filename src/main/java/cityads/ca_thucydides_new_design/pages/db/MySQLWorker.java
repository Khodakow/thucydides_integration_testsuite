package cityads.ca_thucydides_new_design.pages.db;

import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by s.lugovskiy on 30.05.2014.
 */
public class MySQLWorker {
    private final static String offersTable = "offersForTest";

    //объявляем методы статичными чтобы можно было использовать в junit методах с @BeforeClass  (вызывать один раз перед тестами)
    private static Connection connectToDB() {      //если не заданы параметры базы то коннектимся к тестовой monitoring

        String ipDB = "10.8.0.229";
        String userDB = "root";
        String userPassword = "123456";
        String nameDB = "monitoring";

        Connection connection = null;
        try {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://" + ipDB + "/" + nameDB+"?useUnicode=true&characterEncoding=UTF-8";
            String username = userDB;
            String password = userPassword;
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("MySql connected to base: " + connection.getCatalog());
            return connection;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
            return null;
        } catch (InstantiationException i) {
            i.printStackTrace();
            return null;
        } catch (IllegalAccessException a) {
            a.printStackTrace();
            return null;
        }

    }

    private static Connection connectToMonitoringCADB() {      //если не заданы параметры базы то коннектимся к тестовой monitoring

        String ipDB = "10.8.0.229";
        String userDB = "root";
        String userPassword = "123456";
        String nameDB = "monitoring_ca";

        Connection connection = null;
        try {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://" + ipDB + "/" + nameDB+"?useUnicode=true&characterEncoding=UTF-8";
            String username = userDB;
            String password = userPassword;
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("MySql connected to base: " + connection.getCatalog());
            return connection;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
            return null;
        } catch (InstantiationException i) {
            i.printStackTrace();
            return null;
        } catch (IllegalAccessException a) {
            a.printStackTrace();
            return null;
        }

    }

    //запись оффера в базу в таблицу tableName
    public static void addOffersToDB(String offerName) {

        Connection con = connectToDB();
        java.sql.Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
        String query = " insert into " + offersTable + " (offer, date) values (?, ?)";


        try {
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, offerName);
            preparedStmt.setTimestamp(2, timeStamp);
            preparedStmt.execute();
            System.out.println("offer added in db: \n" + preparedStmt.toString());
            con.close();
            System.out.println("connection "+con.toString()+" closed");

        } catch (SQLException s) {
            System.out.println("Wrong sql request in " + query);
            s.printStackTrace();
            try {
                con.close();
                System.out.println("connection "+con.toString()+" closed");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    //обнуление таблицы со списком офферов
    public static void deleteAllFromOffersTable(){
        Connection con = connectToDB();
        try {
            String query = "TRUNCATE TABLE " + offersTable;
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.execute();
            System.out.println("all offers deleted from table: "+offersTable +"\n"+ preparedStmt.toString());
            con.close();
        }
        catch(SQLException s){
            s.printStackTrace();
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //получение списка всех активных офферов из базы
    public static List<Object[]> getAllOffersFromDB(){
        ArrayList<Object[]> offers = new ArrayList<Object[]>();
        Connection con = connectToMonitoringCADB();
        try {

            Statement st = con.createStatement();
            String query = ("SELECT * FROM "+offersTable+" ORDER BY id ASC;");
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                    Object[] offerName = new Object[1];
                    offerName[0] = rs.getString("offer");
                    offers.add(offerName);
                    System.out.println("Offer found in DB for test: "+ offerName[0]);
            }
            con.close();


            return offers;


        } catch (SQLException e) {
            e.printStackTrace();
            try {
                con.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            return null;
        }

    }

    public class Offer{
        private String name;

        public Offer(String name) {
            this.name = name;
        }
    }

}
