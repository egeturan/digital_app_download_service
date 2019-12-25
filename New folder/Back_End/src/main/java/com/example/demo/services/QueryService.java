package com.example.demo.services;
import com.example.demo.components.Apply;

import java.sql.*;

public class QueryService {




    public Apply test() {
        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String user_name = "root";
        String pass = "CS353FALL19";
        Apply applyObject = new Apply();

        try {
            Connection connection = DriverManager.getConnection(google_con, user_name, pass);
            Statement statement = connection.createStatement();

            String query = "SELECT* FROM apply";
            ResultSet rs = statement.executeQuery(query);
            System.out.println("sid \t cid \n");



           rs.next();
                String sid = rs.getString("sid");
                String cid = rs.getString("cid");
            applyObject.setCid(sid);
            applyObject.setSid(cid);


                System.out.println(sid + " " + cid);



        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }


        return applyObject;

    }
}
