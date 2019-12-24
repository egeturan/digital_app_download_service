package com.example.demo.services;
import com.example.demo.components.Apply;
import com.example.demo.components.User;
import com.example.demo.components.End_user;
import com.example.demo.components.Developer;
import com.example.demo.components.Editor;

import java.sql.*;

public class QueryService {
    int end_user_num = 10000000;
    int developer_num = 2000000;
    int editor_num = 30000000;
    public boolean registiration_end_user() {
        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String user_name = "root";
        String pass = "CS353FALL19";
        User new_user = new User();
        End_user new_end_user = new End_user();

        try {
            Connection connection = DriverManager.getConnection(google_con, user_name, pass);
            Statement statement = connection.createStatement();
            end_user_num++;
            String query1 = "INSERT INTO User VALUES(end_user_num,@password,@UserName,@surname,@birth-date,@email,NULL);";
            String query2 = "INSERT INTO End_user VALUES();";
            //ResultSet rs = statement.executeQuery(query1);
            statement.execute(query1);
            statement.execute(query2);



        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }
        return true;
    }

    public boolean registiration_developer() {
        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String user_name = "root";
        String pass = "CS353FALL19";
        User new_user = new User();
        Developer new_developer = new Developer();

        try {
            Connection connection = DriverManager.getConnection(google_con, user_name, pass);
            Statement statement = connection.createStatement();
            developer_num++;
            String query1 = "INSERT INTO User VALUES(developer_num,@password,@UserName,@surname,@birth-date,@email,NULL);";
            String query2 = "INSERT INTO Developer VALUES(company_name);";
            //ResultSet rs = statement.executeQuery(query1);
            statement.execute(query1);
            statement.execute(query2);



        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }
        return true;
    }



    public boolean registiration_editor() {
        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String user_name = "root";
        String pass = "CS353FALL19";
        User new_user = new User();
        Editor new_editor = new Editor();

        try {
            Connection connection = DriverManager.getConnection(google_con, user_name, pass);
            Statement statement = connection.createStatement();
            editor_num++;
            String query1 = "INSERT INTO User VALUES(developer_num,@password,@UserName,@surname,@birth-date,@email,NULL);";
            String query2 = "INSERT INTO Editor VALUES(salary);";
            //ResultSet rs = statement.executeQuery(query1);
            statement.execute(query1);
            statement.execute(query2);

        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }
        return true;
    }


}
