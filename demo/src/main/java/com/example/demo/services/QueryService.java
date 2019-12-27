package com.example.demo.services;
import com.example.demo.components.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QueryService {
    //Variables
    int end_user_num;
    int developer_num;
    int editor_num;
    /// General purpose

    public List<Application> get_approved_applications(){

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list
        Application owned_app = new Application();
        List<Application> owned_apps = new ArrayList<Application>();
        try {

            Connection connection = DriverManager.getConnection(google_con, userName, pass);
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery( "SELECT app_id, app_name,publishin_date,price,text,logo FROM Application A, Request_Publish R WHERE " +
                 "R.app_id = A.app_id AND R.approvement = 1"  );


            while (rs.next()) {

                owned_app.setApp_id(rs.getInt("app_id"));
                owned_app.setApp_name(rs.getString("app_name"));
                owned_app.setDATE(rs.getString("publishing_date"));
                owned_app.setPrice(rs.getInt("price"));
                owned_app.setText(rs.getString("text"));
                owned_app.setLogo(rs.getString("logo"));
                owned_apps.add(owned_app);
            }

        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

        return owned_apps;

    }

    public void add_devices(int user_id,String model_version, String os_version, String CPU, String RAM){

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list
        Device owned_device = new Device();
        List<Device> owned_devices = new ArrayList<Device>();
        try {

            Connection connection = DriverManager.getConnection(google_con, userName, pass);
            Statement statement = connection.createStatement();


            String query1 = "INSERT INTO DEVICE(default,"+
                    "\"" + model_version + "\""+ ","+
                    "\"" + os_version+ "\""+ ","+
                    "\"" + CPU + "\""+ ","+
                    "\"" + RAM + "\""+ ");";

            int device_id = getDeviceNum();

            String query2 = "INSERT INTO Has_device(" + user_id + ","+device_id+ ",);";

            statement.execute(query1);
            statement.execute(query2);

        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

    }

    public void add_min_req (int app_id,String os_version, String CPU, String RAM){

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list
        Device owned_device = new Device();
        List<Device> owned_devices = new ArrayList<Device>();
        try {

            Connection connection = DriverManager.getConnection(google_con, userName, pass);
            Statement statement = connection.createStatement();


            String query1 = "INSERT INTO Minumum_Requirements("+
                    "\"" + app_id + "\""+ ","+
                    "\"" + CPU + "\""+ ","+
                    "\"" + RAM + "\""+
                    "\"" + os_version+ "\""+ ","+");";

            statement.execute(query1);
            //statement.execute(query2);

        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

    }


    public MinimumRequirements get_min_req (int app_id){

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list
        MinimumRequirements owned_req = new MinimumRequirements();
        try {

            Connection connection = DriverManager.getConnection(google_con, userName, pass);
            Statement statement = connection.createStatement();


            ResultSet rs = statement.executeQuery("SELECT app_id, CPU, RAM, OS_version FROM  Minumum_Requirements M, Applicaton A " +
                    "WHERE M.app_id = A.app_id ");

            while(rs.next()){
                owned_req.setApp_id(rs.getInt("app_id"));
                owned_req.setCPU(rs.getString("CPU"));
                owned_req.setRAM(rs.getInt("RAM"));
                owned_req.setOS_version(rs.getString("OS_version"));
            }
            //statement.execute(query2);

        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }
        return owned_req;
    }

    public int getDeviceNum() {

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String user_name = "root";
        String pass = "CS353FALL19";

        int counter = 0;
        try {
            Connection connection = DriverManager.getConnection(google_con, user_name, pass);
            Statement statement = connection.createStatement();

            String query = "SELECT* FROM Device";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                counter++;
            }

        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }
        return counter;
    }

    //// Registiration and login page queries.
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
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Profile info page queries

    public List<Application> get_owned_applications(int user_id){

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list
        Application owned_app = new Application();
        List<Application> owned_apps = new ArrayList<Application>();
        try {

            Connection connection = DriverManager.getConnection(google_con, userName, pass);
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery( "SELECT app_id, app_name,publishin_date,price,text,logo FROM Download D, Application A, Request_Publish R WHERE user_id in(SELECT user_id" +
                    "FROM User U"+
                    "WHERE "+ "\""+user_id+"\""+ "= U.user_id) AND D.app_id = A.app_id"+" AND R.approvement=1 AND R.app_id = A.app_id" );


            while (rs.next()) {

                owned_app.setApp_id(rs.getInt("app_id"));
                owned_app.setApp_name(rs.getString("app_name"));
                owned_app.setDATE(rs.getString("publishing_date"));
                owned_app.setPrice(rs.getInt("price"));
                owned_app.setText(rs.getString("text"));
                owned_app.setLogo(rs.getString("logo"));
                owned_apps.add(owned_app);
            }

        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

        return owned_apps;

    }


    public List<Movie> get_owned_movies(int  user_id){

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list
        Movie owned_movie = new Movie();
        List<Movie> owned_movies = new ArrayList<Movie>();
        try {

            Connection connection = DriverManager.getConnection(google_con, userName, pass);
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery( "SELECT movie_id,movie_name,release_date,imdb_rate FROM Download_movie D,User U, Movie M WHERE U.user_id in(SELECT user_id"+
                    "FROM User U"+
                    "WHERE "+ user_id+ "= U.user_id) AND M.movie_id = D.movie_id" );


            while (rs.next()) {

                owned_movie.setMovie_id(rs.getInt("movie_id"));
                owned_movie.setMovie_name(rs.getString("movie_name"));
                owned_movie.setRelease_date(rs.getString("release_date"));
                owned_movie.setImdb_rate(rs.getDouble("imdb_rate"));

                owned_movies.add(owned_movie);
            }

        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

        return owned_movies;
    }


    public List<Book> get_owned_books(int user_id){

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list
        Book owned_book = new Book();
        List<Book> owned_books = new ArrayList<Book>();
        try {

            Connection connection = DriverManager.getConnection(google_con, userName, pass);
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery( "SELECT book_id,book_name,release_date FROM Download_book D,User U, Book B WHERE U.user_id in(SELECT user_id"+
                    "FROM User U2"+
                    "WHERE "+user_id +"= U2.user_id) AND D.book_id = B.book_id" );


            while (rs.next()) {

                owned_book.setBook_id(rs.getInt("book_id"));
                owned_book.setBook_name(rs.getString("book_name"));
                owned_book.setAuthor_name(rs.getString("release_date"));

                owned_books.add(owned_book);
            }

        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

        return owned_books;
    }

    public List<Device> get_owned_devices(int user_id){

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list
        Device owned_device = new Device();
        List<Device> owned_devices = new ArrayList<Device>();
        try {

            Connection connection = DriverManager.getConnection(google_con, userName, pass);
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT device_id,model_version,os_version,CPU,RAM FROM Has_device H, User U WHERE H.user_id =+"+user_id+"AND U.user_id ="
                    +user_id );


            while (rs.next()) {

                owned_device.setDevice_id(rs.getInt("device_id"));
                owned_device.setModel_version(rs.getString("model_version"));
                owned_device.setOs_version(rs.getString("os_version"));
                owned_device.setCPU(rs.getString("CPU"));
                owned_device.setRAM(rs.getInt("RAM"));

                owned_devices.add(owned_device);
            }

        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

        return owned_devices;
    }


    public List<Comment> get_owned_comments(int user_id){

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list
        Comment owned_comment = new Comment();
        List<Comment> owned_comments = new ArrayList<Comment>();
        try {

            Connection connection = DriverManager.getConnection(google_con, userName, pass);
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT comment_id,user_id,app_id,content FROM Comment WHERE user_id ="+user_id );


            while (rs.next()) {

                owned_comment.setComment_id(rs.getInt("comment_id"));
                owned_comment.setUser_id(rs.getInt("user_id"));
                owned_comment.setApp_id(rs.getInt("app_id"));
                owned_comment.setContent(rs.getString("content"));


                owned_comments.add(owned_comment);
            }

        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

        return owned_comments;
    }


    public List<Payment_method> get_owned_payments(int user_id){

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list
        Payment_method owned_payment_method = new Payment_method();
        List<Payment_method> owned_payment_methods = new ArrayList<Payment_method>();
        try {

            Connection connection = DriverManager.getConnection(google_con, userName, pass);
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT pay_id,user_id,IBAN,credit_card FROM Payment_method P, End_user E, User U WHERE P.user_id ="+
                    user_id+" AND E.user_id ="+user_id+ "AND U.user_id ="+user_id);


            while (rs.next()) {

                owned_payment_method.setPay_id(rs.getInt("pay_id"));
                owned_payment_method.setUser_id(rs.getInt("user_id"));
                owned_payment_method.setIBAN(rs.getString("IBAN"));
                owned_payment_method.setCredit_card(rs.getString("credit_card"));


                owned_payment_methods.add(owned_payment_method);
            }

        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

        return owned_payment_methods;
    }


    public Settings get_owned_settings(int user_id){

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list
        Settings owned_settings = new Settings();
        //List<Payment_method> owned_payment_methods = new ArrayList<Payment_method>();
        try {

            Connection connection = DriverManager.getConnection(google_con, userName, pass);
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT set_id,theme,layout,dark_mode FROM User U, Settings S WHERE U.set_id = S.set_id AND user_id= "+user_id);


            while (rs.next()) {

                owned_settings.setSet_id(rs.getInt("set_id"));
                owned_settings.setTheme(rs.getInt("theme"));
                owned_settings.setLayout(rs.getInt("layout"));
                owned_settings.setDark_mode(rs.getInt("dark_mode"));


                //owned_settings.add(owned_payment_method);
            }

        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

        return owned_settings;

    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public List<Application> get_best_selling_applications(){

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list
        Application owned_app = new Application();
        List<Application> owned_apps = new ArrayList<Application>();
        try {

            Connection connection = DriverManager.getConnection(google_con, userName, pass);
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery( "SELECT app_id,app_name,publishing_date,price,text,logo count FROM Download D, Application A, Request_publish R" +
                    "WHERE price >0 AND count =(SELECT max(count) FROM Download) AND D.app_id = A.app_id AND R.approvement=1 AND R.app_id = A.app_id");

            while (rs.next()) {

                owned_app.setApp_id(rs.getInt("app_id"));
                owned_app.setApp_name(rs.getString("app_name"));
                owned_app.setDATE(rs.getString("publishing_date"));
                owned_app.setPrice(rs.getInt("price"));
                owned_app.setText(rs.getString("text"));
                owned_app.setLogo(rs.getString("logo"));
                owned_apps.add(owned_app);
            }

        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

        return owned_apps;

    }


    public List<Application> get_best_free_applications(){

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list
        Application owned_app = new Application();
        List<Application> owned_apps = new ArrayList<Application>();
        try {

            Connection connection = DriverManager.getConnection(google_con, userName, pass);
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery( "SELECT app_id, app_name,publishing_date,price,text,logo count FROM Download D,Application A, Request_publish T," +
                    " WHERE price =0 AND count =(SELECT max(count) FROM Download) AND D.app_id = A.app_id AND R.approvement=1 AND R.app_id = A.app_id");

            while (rs.next()) {

                owned_app.setApp_id(rs.getInt("app_id"));
                owned_app.setApp_name(rs.getString("app_name"));
                owned_app.setDATE(rs.getString("publishing_date"));
                owned_app.setPrice(rs.getInt("price"));
                owned_app.setText(rs.getString("text"));
                owned_app.setLogo(rs.getString("logo"));
                owned_apps.add(owned_app);
            }

        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

        return owned_apps;

    }


    public List<Application> get_new_added_applications(){

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list
        Application owned_app = new Application();
        List<Application> owned_apps = new ArrayList<Application>();
        try {

            Connection connection = DriverManager.getConnection(google_con, userName, pass);
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery( "SELECT app_id,app_name,publishing_date,price,text,logo FROM Application A, Request_publish R " +
                    "WHERE R.app_id = A.app_id AND R.approvement=1 AND A.app_id not exist(SELECT app_id FROM Download");

            while (rs.next()) {

                owned_app.setApp_id(rs.getInt("app_id"));
                owned_app.setApp_name(rs.getString("app_name"));
                owned_app.setDATE(rs.getString("publishing_date"));
                owned_app.setPrice(rs.getInt("price"));
                owned_app.setText(rs.getString("text"));
                owned_app.setLogo(rs.getString("logo"));
                owned_apps.add(owned_app);
            }

        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

        return owned_apps;

    }

    public List<Movie> get_movies() {

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list
        Movie owned_movie = new Movie();
        List<Movie> owned_movies = new ArrayList<Movie>();
        try {

            Connection connection = DriverManager.getConnection(google_con, userName, pass);
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * FROM Movie");


            while (rs.next()) {

                owned_movie.setMovie_id(rs.getInt("movie_id"));
                owned_movie.setMovie_name(rs.getString("movie_name"));
                owned_movie.setRelease_date(rs.getString("release_date"));
                owned_movie.setImdb_rate(rs.getDouble("imdb_rate"));

                owned_movies.add(owned_movie);
            }

        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

        return owned_movies;
    }


    public List<Book> get_books(int user_id){

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list
        Book owned_book = new Book();
        List<Book> owned_books = new ArrayList<Book>();
        try {

            Connection connection = DriverManager.getConnection(google_con, userName, pass);
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery( "SELECT * FROM Book" );


            while (rs.next()) {

                owned_book.setBook_id(rs.getInt("book_id"));
                owned_book.setBook_name(rs.getString("book_name"));
                owned_book.setAuthor_name(rs.getString("release_date"));

                owned_books.add(owned_book);
            }

        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

        return owned_books;
    }

    public List<Application> get_wish_list(int  user_id){

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list
        Application owned_app = new Application();
        List<Application> owned_apps = new ArrayList<Application>();
        try {

            Connection connection = DriverManager.getConnection(google_con, userName, pass);
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery( "SELECT app_id, app_nam,publishing_date,price,text,logo FROM Wish_list W, Application A WHERE user_id ="+ user_id+
                    "AND W.app_id = A.app_id");

            while (rs.next()) {

                owned_app.setApp_id(rs.getInt("app_id"));
                owned_app.setApp_name(rs.getString("app_name"));
                owned_app.setDATE(rs.getString("publishing_date"));
                owned_app.setPrice(rs.getInt("price"));
                owned_app.setText(rs.getString("text"));
                owned_app.setLogo(rs.getString("logo"));
                owned_apps.add(owned_app);
            }

        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

        return owned_apps;

    }


    public List<Application> search_app(String search_app){

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list
        Application owned_app = new Application();
        List<Application> owned_apps = new ArrayList<Application>();
        try {

            Connection connection = DriverManager.getConnection(google_con, userName, pass);
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery( "SELECT app_id, app_name,publishing_date,price,text,logo FROM Application A, Request_publish R " +
                    " WHERE R.app_id = A.app_id AND R.approvement=1 AND app_name LIKE '"+"\""+search_app+"\"" +"%'");

            while (rs.next()) {

                owned_app.setApp_id(rs.getInt("app_id"));
                owned_app.setApp_name(rs.getString("app_name"));
                owned_app.setDATE(rs.getString("publishing_date"));
                owned_app.setPrice(rs.getInt("price"));
                owned_app.setText(rs.getString("text"));
                owned_app.setLogo(rs.getString("logo"));
                owned_apps.add(owned_app);
            }

        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

        return owned_apps;

    }


    public List<Application> search_category(String search_category){

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list
        Application owned_app = new Application();
        List<Application> owned_apps = new ArrayList<Application>();
        try {

            Connection connection = DriverManager.getConnection(google_con, userName, pass);
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery( "SELECT app_id, app_name,publishing_date,price,text,logo FROM Has_category H,Application A, Request_publish R WHERE category_name LIKE "+ "\""+search_category+"\"+" +
                     "AND H.app_id = A.app_id"+
                      "R.app_id = A.app_id AND R.approvement=1");

            while (rs.next()) {

                owned_app.setApp_id(rs.getInt("app_id"));
                owned_app.setApp_name(rs.getString("app_name"));
                owned_app.setDATE(rs.getString("publishing_date"));
                owned_app.setPrice(rs.getInt("price"));
                owned_app.setText(rs.getString("text"));
                owned_app.setLogo(rs.getString("logo"));
                owned_apps.add(owned_app);
            }

        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

        return owned_apps;

    }

    public List<Application> search_app_and_category(String search_app,String search_category){

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list
        Application owned_app = new Application();
        List<Application> owned_apps = new ArrayList<Application>();
        try {

            Connection connection = DriverManager.getConnection(google_con, userName, pass);
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery( "SELECT app_id, app_name FROM Has_category H, Application A, Request_publish R WHERE category_name LIKE"+
                    "\""+search_category+"\""+ "AND app_name LIKE"+ "\""+search_app+"\""+"AND H.app_id = A.app_id"
            +"R.app_id = A.app_id AND R.approvement=1");

            while (rs.next()) {

                owned_app.setApp_id(rs.getInt("app_id"));
                owned_app.setApp_name(rs.getString("app_name"));
                owned_app.setDATE(rs.getString("publishing_date"));
                owned_app.setPrice(rs.getInt("price"));
                owned_app.setText(rs.getString("text"));
                owned_app.setLogo(rs.getString("logo"));
                owned_apps.add(owned_app);
            }

        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

        return owned_apps;

    }
    // Apps page queries:
    public List<Application> get_app_on_sale(){

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list
        Application owned_app = new Application();
        List<Application> owned_apps = new ArrayList<Application>();
        try {

            Connection connection = DriverManager.getConnection(google_con, userName, pass);
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery( "SELECT app_id,app_name,publishing_date,price,text,logo FROM Application A, Ruqest_publish R WHERE price >0  " +
                    "AND R.app_id = A.app_id AND R.approvement=1");

            while (rs.next()) {

                owned_app.setApp_id(rs.getInt("app_id"));
                owned_app.setApp_name(rs.getString("app_name"));
                owned_app.setDATE(rs.getString("publishing_date"));
                owned_app.setPrice(rs.getInt("price"));
                owned_app.setText(rs.getString("text"));
                owned_app.setLogo(rs.getString("logo"));
                owned_apps.add(owned_app);
            }

        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

        return owned_apps;
    }



    public List<Application> get_app_best_sale(){

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list
        Application owned_app = new Application();
        List<Application> owned_apps = new ArrayList<Application>();
        try {

            Connection connection = DriverManager.getConnection(google_con, userName, pass);
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery( "SELECT app_id,app_name,publishing_date,price,text,logo FROM Rate R,Application A , Request_publish B" +
                    " WHERE point = (SELECT max(point) FROM Rate) AND R.app_id = A.app_id"
            +"B.app_id = A.app_id AND B.approvement=1");

            while (rs.next()) {

                owned_app.setApp_id(rs.getInt("app_id"));
                owned_app.setApp_name(rs.getString("app_name"));
                owned_app.setDATE(rs.getString("publishing_date"));
                owned_app.setPrice(rs.getInt("price"));
                owned_app.setText(rs.getString("text"));
                owned_app.setLogo(rs.getString("logo"));
                owned_apps.add(owned_app);
            }

        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

        return owned_apps;
    }

    public List<Application> get_app_most_downloaded(){

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list
        Application owned_app = new Application();
        List<Application> owned_apps = new ArrayList<Application>();
        try {

            Connection connection = DriverManager.getConnection(google_con, userName, pass);
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery( "SELECT app_id,app_name FROM Download D,Application A, Request_publish" +
                    " WHERE count = (SELECT max(count) FROM Download) AND D.app_id = A.app_id"
            +"R.app_id = A.app_id AND R.approvement=1");

            while (rs.next()) {

                owned_app.setApp_id(rs.getInt("app_id"));
                owned_app.setApp_name(rs.getString("app_name"));
                owned_app.setDATE(rs.getString("publishing_date"));
                owned_app.setPrice(rs.getInt("price"));
                owned_app.setText(rs.getString("text"));
                owned_app.setLogo(rs.getString("logo"));
                owned_apps.add(owned_app);
            }

        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

        return owned_apps;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Application information page queries:

    public Application get_app_informations(String app_name){

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list
        Application owned_app = new Application();
        List<Application> owned_apps = new ArrayList<Application>();
        try {

            Connection connection = DriverManager.getConnection(google_con, userName, pass);
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery( "SELECT app_id,app_name,publishing_date,price,text,logo FROM Application WHERE app_name= "+ "\""+ app_name+"\"");

            while (rs.next()) {

                owned_app.setApp_id(rs.getInt("app_id"));
                owned_app.setApp_name(rs.getString("app_name"));
                owned_app.setDATE(rs.getString("publishing_date"));
                owned_app.setPrice(rs.getInt("price"));
                owned_app.setText(rs.getString("text"));
                owned_app.setLogo(rs.getString("logo"));
                owned_apps.add(owned_app);
            }

        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

        return owned_app;
    }


    public void download_app(int user_id,String app_name, int device_id){

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list
        Application owned_app = get_app_informations(app_name);
        try{

            Connection connection = DriverManager.getConnection(google_con, userName, pass);
            Statement statement = connection.createStatement();

        String query1 = "INSERT INTO Download VALUES("+user_id+","+device_id+","+ owned_app.getApp_id()+",NULL)";
        String query2="UPDATE Download "+
        "SET count = (SELECT count FROM Download WHERE user_id ="+ user_id+")+1"+
        "WHERE user_id = "+ user_id+" AND device_id = "+ device_id +"AND app_id = "+ owned_app.getApp_id();

        statement.execute(query1);
        statement.execute(query2);

        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

        //return owned_app;
    }



    public void rate_app(int user_id,String app_name, double rate) {

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list
        Application owned_app = get_app_informations(app_name);
        try {

            Connection connection = DriverManager.getConnection(google_con, userName, pass);
            Statement statement = connection.createStatement();

            String query1 = "INSERT INTO Rate VALUES(" + user_id + "," + owned_app.getApp_id() + "," + rate + ")";
            String query2 = "SELECT average(point) FROM Rate group by app_id WHERE app_id =" + owned_app.getApp_id();

            statement.execute(query1);
            statement.execute(query2);

        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

    }


    public void add_app_wish_list(int user_id,String app_name){

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list
        Application owned_app = get_app_informations(app_name);
        try{

            Connection connection = DriverManager.getConnection(google_con, userName, pass);
            Statement statement = connection.createStatement();

            String query1 = "INSERT INTO Wish_list VALUES("+user_id+","+owned_app.getApp_id()+")";
            statement.execute(query1);

        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

        //return owned_app;
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Upload Request Page queries:

    public List<Editor> get_editors(){


        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";


        Editor new_editor = new Editor();
        List<Editor> editors = new ArrayList<Editor>();

        try{

            Connection connection = DriverManager.getConnection(google_con, userName, pass);
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * FROM Editor");

            while(rs.next()){
                new_editor.setUser_id(rs.getInt("editor_id"));
                new_editor.setSalary(rs.getInt("salary"));
                editors.add(new_editor);
            }

        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

        return editors;
    }

    public void upload_request_app(int editor_id,int developer_id,String app_name, String publishing_date, int price, String text, String logo){

        // important comment : developer_id is already user_id so get it from global user_id object

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list
        Application owned_app = new Application();

        //owned_app.setApp_id(app_id);
        owned_app.setApp_name(app_name);
        owned_app.setDATE(publishing_date);
        owned_app.setPrice(price);
        owned_app.setText(text);
        owned_app.setLogo(logo);

        try{

            Connection connection = DriverManager.getConnection(google_con, userName, pass);
            Statement statement = connection.createStatement();




            String query1 = "INSERT INTO Application VALUES("+"default"+","+
                    "\""+app_name+"\""+ ","+
                    "\""+publishing_date+"\""+ ","+
                    price+ ","+
                    "\""+text+"\""+ ","+
                    "\""+logo+"\""+ ")";

            ResultSet rs= statement.executeQuery("SELECT app_id FROM Application WHERE app_name= "+"\""+app_name+"\"");
            rs.next();
            int app_id = rs.getInt("app_id");

            //ResultSet rs2= statement.executeQuery("SELECT editor_id FROM Editor,User WHERE editor = ");
            //rs2.next();
            //int editor_id = rs.getInt("editor_id");

            String query2 = "INSERT INTO Request_publish VALUES("+ editor_id+","+
            developer_id+","+
            app_id+","+
            "NULL)";

        statement.execute(query1);
        statement.execute(query2);

        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

        //return owned_app;
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Approve request page
public List<Application> get_requested_apps(int editor_id){
    // we are already editor in this page so user_id = editor_id

    String google_con = "jdbc:mysql://35.242.165.113/adastore";
    String userName = "root";
    String pass = "CS353FALL19";

    //Application[] owned_app_list
    Application owned_app = new Application();
    List<Application> owned_apps = new ArrayList<Application>();
    try {

        Connection connection = DriverManager.getConnection(google_con, userName, pass);
        Statement statement = connection.createStatement();

        ResultSet rs = statement.executeQuery( "SELECT app_id,app_name,publishing_date,price,text,logo FROM Request_publish,Application WHERE editor_id ="
                +editor_id+
                "AND approvement = NULL)");

        while (rs.next()) {

            owned_app.setApp_id(rs.getInt("app_id"));
            owned_app.setApp_name(rs.getString("app_name"));
            owned_app.setDATE(rs.getString("publishing_date"));
            owned_app.setPrice(rs.getInt("price"));
            owned_app.setText(rs.getString("text"));
            owned_app.setLogo(rs.getString("logo"));
            owned_apps.add(owned_app);
        }

    } catch (Exception e) {
        System.err.println("Error Statement or Connection Failed!");
        e.printStackTrace();
    }

    return owned_apps;
}

public void approve_request(int editor_id,int app_id){
    // we are already editor in this page so user_id = editor_id



    String google_con = "jdbc:mysql://35.242.165.113/adastore";
    String userName = "root";
    String pass = "CS353FALL19";

    //Application[] owned_app_list
    Application owned_app = new Application();
    List<Application> owned_apps = new ArrayList<Application>();
    try {

        Connection connection = DriverManager.getConnection(google_con, userName, pass);
        Statement statement = connection.createStatement();

        String query1 = "UPDATE Request_publish " +
                "SET approvement = 1" +
                "WHERE editor_id ="+ editor_id+" AND app_id ="+app_id+";";
        statement.execute(query1);

    } catch (Exception e) {
        System.err.println("Error Statement or Connection Failed!");
        e.printStackTrace();
    }
}


    public void reject_request(int editor_id,int app_id){
        // we are already editor in this page so user_id = editor_id

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list
        Application owned_app = new Application();
        List<Application> owned_apps = new ArrayList<Application>();
        try {

            Connection connection = DriverManager.getConnection(google_con, userName, pass);
            Statement statement = connection.createStatement();

            String query1 = "UPDATE Request_publish " +
                    "SET approvement = 0" +
                    "WHERE editor_id ="+ editor_id+" AND app_id ="+app_id+";";
            statement.execute(query1);

        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }
    }

}
