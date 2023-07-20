package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    static Connection connection = null;
    public static Connection getConnection(){
        if (connection != null){
            return connection;
        }
        String user = "root";
        String pass = "Sangharsh@7598";
        String db = "searchengine";
        return getConnection(user,pass,db);
    }

    private static Connection getConnection(String user,String pass,String db){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
           connection =  DriverManager.getConnection("jdbc:mysql://localhost/"+db+"?user="+user+"&password="+pass);

        }
        catch (SQLException | ClassNotFoundException sqlException){
            sqlException.printStackTrace();
        }

        return connection;
    }
}
