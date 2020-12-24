package com.company;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.sql.*;

public class Connection {

    public static void SetConnectionUNAMEPASS(String Username, String Password){
        password = Password;
        username = Username;
    }

    public static String ConnectAndSend (String req) throws ClassNotFoundException {

        Class.forName("com.mysql.jdbc.Driver");
        java.sql.Connection connect = null;
        try {
            connect = DriverManager.getConnection(url, username, password);
            System.out.println("Подключен к " + url);
            Statement stat = connect.createStatement();
            ResultSet result = stat.executeQuery(req);
            result.next();
            return result.getString(1);
        }
        catch (SQLException ex){
            System.out.println("не подключился..");
            System.out.println(ex);
        }
        finally {
         try
         {
             assert connect != null;
             connect.close();
         }
         catch (Exception e){
             System.out.println(e.toString());
         }
        }
        return null;
    }


        public static void GetSettingFromJFile(){

            JSONParser jsonParser = new JSONParser();

            try (FileReader reader = new FileReader("resources\\connection.json")) {
                Object obj = jsonParser.parse(reader);
                JSONObject connection = (JSONObject) obj;
                url = (String) connection.get("url");
                sheme = (String) connection.get("sheme");
                reader.close();
                System.out.println("Json file read successful!");
            }
            catch (Exception ex){
                System.out.println("something go wrong with json \n" + ex);
            }
        }

    private static String url;
    private static String sheme;
    private static String username;
    private static String password;
}
