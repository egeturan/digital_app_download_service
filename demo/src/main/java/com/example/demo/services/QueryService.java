package com.example.demo.services;
import com.example.demo.components.*;

import java.sql.*;

public class QueryService {
    //Variables
    int end_user_num;
    int developer_num;
    int editor_num;


    public int getEndUserNum() {

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String user_name = "root";
        String pass = "CS353FALL19";

        int counter = 0;
        try {
            Connection connection = DriverManager.getConnection(google_con, user_name, pass);
            Statement statement = connection.createStatement();

            String query = "SELECT* FROM End_user";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                counter++;
            }

        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }
        return 10000000 + counter;
    }


    public int getDeveloperNum() {

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String user_name = "root";
        String pass = "CS353FALL19";

        int counter = 0;
        try {
            Connection connection = DriverManager.getConnection(google_con, user_name, pass);
            Statement statement = connection.createStatement();

            String query = "SELECT* FROM Developer";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                counter++;
            }

        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }
        return 20000000 + counter;
    }


    public int getEditorNum() {

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String user_name = "root";
        String pass = "CS353FALL19";

        int counter = 0;
        try {
            Connection connection = DriverManager.getConnection(google_con, user_name, pass);
            Statement statement = connection.createStatement();

            String query = "SELECT* FROM Editor";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                counter++;
            }

        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }
        return 30000000 + counter;
    }


    public User registiration_end_user(String name, String surname, String birth_date, String email, String password) {
        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String user_name = "root";
        String pass = "CS353FALL19";
        User new_user = new User();
        End_user new_end_user = new End_user();
        System.out.println(name + " " + surname + " " + birth_date + " " + email + " " + password);
        Date newDate = new Date(2019, 10, 10);

        System.out.println(newDate.toString());


        try {
            Connection connection = DriverManager.getConnection(google_con, user_name, pass);
            Statement statement = connection.createStatement();
            end_user_num = getEndUserNum();
            //end_user_num = end_user_num+1;
            int user_id = end_user_num;
            int set_id = 1;
            //System.out.println(user_id);
            //user_id, password, name, surname, birth_date, email, set_id)
            String query1 = "INSERT INTO User VALUES (" +
                    user_id + ", " + " \"" + password + "\" " + ", " + " \"" + name + "\"" + " , " + "\"" + surname + "\"" + " , " + "\"" + birth_date + "\"" + " , " + "\"" + email + "\"" + " , " + set_id + " );";


            String query2 = "INSERT INTO End_user VALUES();";
            //ystem.out.println(defaultQ + " \n");
            //ResultSet rs = statement.executeQuery(query1);
            statement.execute(query1);
            statement.execute(query2);

        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

        return new_user;
    }

    public User registiration_developer(String name, String surname, String birth_date, String email, String password, String company_name) {
        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String user_name = "root";
        String pass = "CS353FALL19";
        User new_user = new User();
        Developer new_developer = new Developer();

        System.out.println(name + " " + surname + " " + birth_date + " " + email + " " + password + " " + company_name);

        try {
            Connection connection = DriverManager.getConnection(google_con, user_name, pass);
            Statement statement = connection.createStatement();
            developer_num = getDeveloperNum();

            int user_id = developer_num;
            int set_id = 1;
            //System.out.println(user_id);
            //user_id, password, name, surname, birth_date, email, set_id)
            String query1 = "INSERT INTO User VALUES (" +
                    user_id + ", " + " \"" + password + "\" " + ", " + " \"" + name + "\"" + " , " + "\"" + surname + "\"" + " , " + "\"" + birth_date + "\"" + " , " + "\"" + email + "\"" + " , " + set_id + " );";


            String query2 = "INSERT INTO Developer VALUES("+ "default," + "\"" + company_name + "\"" + ");";
            //ResultSet rs = statement.executeQuery(query1);
            statement.execute(query1);
            statement.execute(query2);


        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }
        return new_user;
    }


    public User registiration_editor(String name, String surname, String birth_date, String email, String password, int salary) {
        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String user_name = "root";
        String pass = "CS353FALL19";
        User new_user = new User();
        Editor new_editor = new Editor();

        System.out.println(name + " " + surname + " " + birth_date + " " + email + " " + password + " " + salary);

        try {
            Connection connection = DriverManager.getConnection(google_con, user_name, pass);
            Statement statement = connection.createStatement();
            editor_num = getEditorNum();

            int user_id = editor_num;
            int set_id = 1;
            //System.out.println(user_id);
            //user_id, password, name, surname, birth_date, email, set_id)
            String query1 = "INSERT INTO User VALUES (" +
                    user_id + ", " + " \"" + password + "\" " + ", " + " \"" + name + "\"" + " , " + "\"" + surname + "\"" + " , " + "\"" + birth_date + "\"" + " , " + "\"" + email + "\"" + " , " + set_id + " );";

            System.out.println("salary" +salary);
            //String query2 = "INSERT INTO Editor VALUES("+ salary+");";
            String query2 = "INSERT INTO Editor VALUES("+"default,"+salary+");";
            statement.execute(query1);
            statement.execute(query2);

        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }
        return new_user;
    }


    public User loginQuery(String user_name, String password) {

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";
        User login_user = new User();
        boolean bool = false;
        try {

            Connection connection = DriverManager.getConnection(google_con, userName, pass);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT* FROM User WHERE name =" +"\"" + user_name + "\""
                    + "AND password ="+ "\""+password+"\"" );


            while (rs.next()) {
                bool = true;
                login_user.setUser_id(rs.getInt("user_id"));
                login_user.setUsername(rs.getString("name"));
                login_user.setPassword(rs.getString("password"));
                login_user.setDATE(rs.getString("birth_date"));
                login_user.setEmail(rs.getString("email"));
                login_user.setSet_id(rs.getInt("set_id"));
            }

        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }
        if (bool)
            return login_user;
        else
            return null;
    }
}
