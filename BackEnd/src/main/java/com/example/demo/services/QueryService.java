package com.example.demo.services;
import com.example.demo.components.*;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class QueryService {
    //Variables
    int end_user_num;
    int developer_num;
    int editor_num;
    /// General purpose
    //DONE
    Connection connection;
    public QueryService(){
        connection = DriverManager.getConnection(google_con, userName, pass);
    }
    public List<View> get_app_download_rate_views(){

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list

        List<View> owned_apps = new ArrayList<View>();
        try {

            Statement statement = connection.createStatement();
            //String query1 = "CREATE VIEW view AS SELECT A.app_id, app_name,publishing_date,price,text,logo,AVG(R.point) AS average, SUM(D.count) AS download FROM Application A NATURAL JOIN Download D, Rate R WHERE " +
            //      " A.app_id = D.app_id AND A.app_id = R.app_id " +
            //    " GROUP BY A.app_id;";
            //String query1 = "CREATE VIEW view AS SELECT * FROM view3 UNION view2;";
            //statement.execute(query1);

            ResultSet rs = statement.executeQuery( "SELECT * FROM view");


            while (rs.next()) {
                View owned_app = new View();
                owned_app.setApp_id(rs.getInt("app_id"));
                owned_app.setApp_name(rs.getString("app_name"));
                owned_app.setDATE(rs.getString("publishing_date"));
                owned_app.setPrice(rs.getInt("price"));
                owned_app.setText(rs.getString("text"));
                owned_app.setLogo(rs.getString("logo"));
                owned_app.setPoint(rs.getDouble("average"));
                owned_app.setDownload(rs.getInt("download"));
                owned_apps.add(owned_app);
            }
            statement.close();
        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

        return owned_apps;
    }

    //DONE
    public List<View> get_app_rate_views(){

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list

        List<View> owned_apps = new ArrayList<View>();
        try {

            Statement statement = connection.createStatement();

            //String query1 = "CREATE VIEW view2 AS SELECT A.app_id, app_name,publishing_date,price,text,logo,AVG(R.point) AS average FROM Application A NATURAL JOIN Rate R WHERE " +
            //    "A.app_id = R.app_id " +
            //" GROUP BY A.app_id;";
            //statement.execute(query1);

            ResultSet rs = statement.executeQuery( "SELECT * FROM view2");


            while (rs.next()) {
                View owned_app = new View();
                owned_app.setApp_id(rs.getInt("app_id"));
                owned_app.setApp_name(rs.getString("app_name"));
                owned_app.setDATE(rs.getString("publishing_date"));
                owned_app.setPrice(rs.getInt("price"));
                owned_app.setText(rs.getString("text"));
                owned_app.setLogo(rs.getString("logo"));
                owned_app.setPoint(rs.getDouble("average"));
                //owned_app.setDownload(rs.getInt("download"));
                owned_apps.add(owned_app);
            }
            statement.close();
        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

        return owned_apps;
    }
    //DONE
    public List<View> get_app_download_views(){

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list

        List<View> owned_apps = new ArrayList<View>();
        try {

            Statement statement = connection.createStatement();

            //String query1 = "CREATE VIEW view3 AS SELECT A.app_id, app_name,publishing_date,price,text,logo,SUM(D.count) AS download FROM Application A NATURAL JOIN Download D WHERE " +
            //  "A.app_id = D.app_id " +
            //" GROUP BY A.app_id;";
            //statement.execute(query1);

            ResultSet rs = statement.executeQuery( "SELECT * FROM view3");


            while (rs.next()) {
                View owned_app = new View();
                owned_app.setApp_id(rs.getInt("app_id"));
                owned_app.setApp_name(rs.getString("app_name"));
                owned_app.setDATE(rs.getString("publishing_date"));
                owned_app.setPrice(rs.getInt("price"));
                owned_app.setText(rs.getString("text"));
                owned_app.setLogo(rs.getString("logo"));
                //owned_app.setPoint(rs.getDouble("average"));
                owned_app.setDownload(rs.getInt("download"));
                owned_apps.add(owned_app);
            }
            statement.close();
        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

        return owned_apps;
    }
    //DONE
    public List<Application> get_approved_applications(){

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list

        List<Application> owned_apps = new ArrayList<Application>();
        try {

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery( "SELECT app_id, app_name,publishing_date,price,text,logo FROM Application A NATURAL JOIN Request_publish R WHERE " +
                    "R.app_id = A.app_id AND R.approvement = 1"  );


            while (rs.next()) {
                Application owned_app = new Application();
                owned_app.setApp_id(rs.getInt("app_id"));
                owned_app.setApp_name(rs.getString("app_name"));
                owned_app.setDATE(rs.getString("publishing_date"));
                owned_app.setPrice(rs.getInt("price"));
                owned_app.setText(rs.getString("text"));
                owned_app.setLogo(rs.getString("logo"));
                owned_apps.add(owned_app);
            }
            statement.close();

        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

        return owned_apps;

    }
    //DONE
    public List<Application> get_price_ranged_applications(int lowwer_price,int upper_price){

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list

        List<Application> owned_apps = new ArrayList<Application>();
        try {

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery( "SELECT app_id, app_name,publishing_date,price,text,logo FROM Application A NATURAL JOIN Request_publish R WHERE " +
                    "R.app_id = A.app_id AND R.approvement = 1 AND price >= "+lowwer_price+" AND price <= "+ upper_price  );


            while (rs.next()) {
                Application owned_app = new Application();
                owned_app.setApp_id(rs.getInt("app_id"));
                owned_app.setApp_name(rs.getString("app_name"));
                owned_app.setDATE(rs.getString("publishing_date"));
                owned_app.setPrice(rs.getInt("price"));
                owned_app.setText(rs.getString("text"));
                owned_app.setLogo(rs.getString("logo"));
                owned_apps.add(owned_app);
            }
            statement.close();
        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

        return owned_apps;

    }

    //DONE
    public Device get_Device(int device_id){

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list
        Device owned_device = new Device();
        //List<Device> owned_devices = new ArrayList<Device>();
        try {

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT* FROM Device WHERE device_id= "+device_id);

            while(rs.next()){
                owned_device.setDevice_id(rs.getInt("device_id"));
                owned_device.setModel_version(rs.getString("model_version"));
                owned_device.setOs_version(rs.getString("os_version"));
                owned_device.setCPU(rs.getString("CPU"));
                owned_device.setRAM(rs.getInt("RAM"));
            }
            statement.close();
        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }
        return owned_device;

    }
    //DONE
    public void add_devices(int user_id,String model_version, String os_version, String CPU, String RAM){

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list
        Device owned_device = new Device();
        List<Device> owned_devices = new ArrayList<Device>();
        try {

            Statement statement = connection.createStatement();


            String query1 = "INSERT INTO Device VALUES(default,"+
                    "\"" + model_version + "\""+ ","+
                    "\"" + os_version+ "\""+ ","+
                    "\"" + CPU + "\""+ ","+
                    "\"" + RAM + "\""+ ");";


            statement.execute(query1);
            int device_id = getDeviceNum();

            String query2 = "INSERT INTO Has_device VALUES(" + user_id + ","+device_id+ ");";



            statement.execute(query2);
            statement.close();
        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

    }
    //DONE
    public void add_min_req (int app_id,String os_version, int RAM, String CPU){

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";
        MinimumRequirements req = get_min_req(app_id);

        //Application[] owned_app_list
        Device owned_device = new Device();
        List<Device> owned_devices = new ArrayList<Device>();
        try {

            Statement statement = connection.createStatement();

            String query1 = "INSERT INTO Minimum_requirements VALUES(" +
                    app_id + "," +
                    RAM + "," +
                    "\"" + CPU + "\"" + "," +
                    "\"" + os_version + "\"" + ");";

            statement.execute(query1);
            //statement.execute(query2);
            statement.close();
        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }
    }


    //DONE
    public MinimumRequirements get_min_req (int app_id){

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list
        MinimumRequirements owned_req = new MinimumRequirements();
        try {
            
            Statement statement = connection.createStatement();
           
            ResultSet rs = statement.executeQuery("SELECT app_id, CPU, RAM, OS_version FROM  Minimum_requirements M NATURAL JOIN Application A WHERE app_id ="+ app_id);

            while(rs.next()){
                owned_req.setApp_id(rs.getInt("app_id"));
                owned_req.setCPU(rs.getString("CPU"));
                owned_req.setRAM(rs.getInt("RAM"));
                owned_req.setOS_version(rs.getString("OS_version"));
            }
            //statement.execute(query2);
            statement.close();
        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }
        return owned_req;
    }
    //DONE
    public int getDeviceNum() {

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String user_name = "root";
        String pass = "CS353FALL19";

        int counter = 0;
        try {

            Statement statement = connection.createStatement();

            String query = "SELECT* FROM Device";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                counter = rs.getInt("device_id");
            }
            statement.close();
        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }
        return counter;
    }

    //// Registiration and login page queries.
    //DONE
    public int getEndUserNum() {

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String user_name = "root";
        String pass = "CS353FALL19";

        int counter = 0;
        try {

            Statement statement = connection.createStatement();

            String query = "SELECT* FROM End_user";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                counter++;
            }
            statement.close();
        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }
        return 10000000 + counter;
    }

    //DONE
    public int getDeveloperNum() {

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String user_name = "root";
        String pass = "CS353FALL19";

        int counter = 0;
        try {

            Statement statement = connection.createStatement();

            String query = "SELECT* FROM Developer";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                counter++;
            }
            statement.close();
        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }
        return 20000000 + counter;
    }

    //DONE
    public int getEditorNum() {

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String user_name = "root";
        String pass = "CS353FALL19";

        int counter = 0;
        try {

            Statement statement = connection.createStatement();

            String query = "SELECT* FROM Editor";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                counter++;
            }
            statement.close();
        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }
        return 30000000 + counter;
    }

    //DONE
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

            Statement statement = connection.createStatement();
            end_user_num = getEndUserNum();
            //end_user_num = end_user_num+1;
            int user_id = end_user_num;
            int set_id = 1;
            //System.out.println(user_id);
            //user_id, password, name, surname, birth_date, email, set_id)
            String query1 = "INSERT INTO User VALUES (" +
                    user_id + ", " + " \"" + password + "\" " + ", " + " \"" + name + "\"" + " , " + "\"" + surname + "\"" + " , " + "\"" + birth_date + "\"" + " , " + "\"" + email + "\"" + " , " + set_id + " );";


            String query2 = "INSERT INTO End_user VALUES(default);";
            //ystem.out.println(defaultQ + " \n");
            //ResultSet rs = statement.executeQuery(query1);
            statement.execute(query1);
            statement.execute(query2);
            statement.close();
        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

        return new_user;
    }
    //DONE
    public User registiration_developer(String name, String surname, String birth_date, String email, String password, String company_name) {
        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String user_name = "root";
        String pass = "CS353FALL19";
        User new_user = new User();
        Developer new_developer = new Developer();

        System.out.println(name + " " + surname + " " + birth_date + " " + email + " " + password + " " + company_name);

        try {

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

            statement.close();
        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }
        return new_user;
    }

    //DONE
    public User registiration_editor(String name, String surname, String birth_date, String email, String password, int salary) {
        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String user_name = "root";
        String pass = "CS353FALL19";
        User new_user = new User();
        Editor new_editor = new Editor();

        System.out.println(name + " " + surname + " " + birth_date + " " + email + " " + password + " " + salary);

        try {

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
            statement.close();
        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }
        return new_user;
    }

    //DONE
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
            statement.close();
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
    //DONE
    public List<Application> get_owned_applications(int user_id){

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list

        List<Application> owned_apps = new ArrayList<Application>();
        try {


            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery( "SELECT app_id, app_name,publishing_date,price,text,logo FROM Download D NATURAL JOIN Application WHERE user_id = "+user_id );


            while (rs.next()) {
                Application owned_app = new Application();
                owned_app.setApp_id(rs.getInt("app_id"));
                owned_app.setApp_name(rs.getString("app_name"));
                owned_app.setDATE(rs.getString("publishing_date"));
                owned_app.setPrice(rs.getInt("price"));
                owned_app.setText(rs.getString("text"));
                owned_app.setLogo(rs.getString("logo"));
                owned_apps.add(owned_app);
            }
            statement.close();
        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

        return owned_apps;

    }

    //WAITING
    public List<Movie> get_owned_movies(int  user_id){

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list

        List<Movie> owned_movies = new ArrayList<Movie>();
        try {


            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery( "SELECT movie_id,movie_name,release_date,imdb_rate FROM Download_movie D,User U, Movie M WHERE U.user_id in(SELECT user_id"+
                    " FROM User U"+
                    " WHERE "+ user_id+ "= U.user_id) AND M.movie_id = D.movie_id" );


            while (rs.next()) {
                Movie owned_movie = new Movie();
                owned_movie.setMovie_id(rs.getInt("movie_id"));
                owned_movie.setMovie_name(rs.getString("movie_name"));
                owned_movie.setRelease_date(rs.getString("release_date"));
                owned_movie.setImdb_rate(rs.getDouble("imdb_rate"));

                owned_movies.add(owned_movie);
            }
            statement.close();
        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

        return owned_movies;
    }

    //WAITING
    public List<Book> get_owned_books(int user_id){

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list

        List<Book> owned_books = new ArrayList<Book>();
        try {

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery( "SELECT book_id,book_name,release_date FROM Download_book D,User U, Book B WHERE U.user_id in(SELECT user_id"+
                    " FROM User U2"+
                    " WHERE "+user_id +"= U2.user_id) AND D.book_id = B.book_id" );


            while (rs.next()) {
                Book owned_book = new Book();
                owned_book.setBook_id(rs.getInt("book_id"));
                owned_book.setBook_name(rs.getString("book_name"));
                owned_book.setAuthor_name(rs.getString("release_date"));

                owned_books.add(owned_book);
            }
            statement.close();
        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

        return owned_books;
    }
    //DONE
    public List<Device> get_owned_devices(int user_id){

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list

        List<Device> owned_devices = new ArrayList<Device>();
        try {


            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT device_id,model_version,os_version,CPU,RAM FROM Has_device H NATURAL JOIN Device WHERE H.user_id = "+user_id );


            while (rs.next()) {
                Device owned_device = new Device();
                owned_device.setDevice_id(rs.getInt("device_id"));
                owned_device.setModel_version(rs.getString("model_version"));
                owned_device.setOs_version(rs.getString("os_version"));
                owned_device.setCPU(rs.getString("CPU"));
                owned_device.setRAM(rs.getInt("RAM"));

                owned_devices.add(owned_device);
            }
            statement.close();
        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

        return owned_devices;
    }
    //WAITING
    public void make_comment(int user_id, int app_id, String text){

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list

        List<Comment> owned_comments = new ArrayList<Comment>();
        try {

            Statement statement = connection.createStatement();

            String query = "INSERT INTO Comment VALUES(default"+
                    user_id+","+
                    app_id+","+
                    text+");";

            statement.execute(query);



            statement.close();
        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }
    }
    //WAITING
    public List<Comment> get_apps_comments(int app_id){

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list

        List<Comment> owned_comments = new ArrayList<Comment>();
        try {

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT comment_id, user_id, app_id, content FROM Comment C,Application A WHERE A.app_id ="+
                    app_id+ "AND C.app_id ="+app_id );


            while (rs.next()) {
                Comment owned_comment = new Comment();
                owned_comment.setComment_id(rs.getInt("comment_id"));
                owned_comment.setUser_id(rs.getInt("user_id"));
                owned_comment.setApp_id(rs.getInt("app_id"));
                owned_comment.setText(rs.getString("content"));


                owned_comments.add(owned_comment);
            }
            statement.close();
        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

        return owned_comments;
    }
    //WAITING
    public List<Comment> get_owned_comments(int user_id){

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list

        List<Comment> owned_comments = new ArrayList<Comment>();
        try {

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT comment_id,user_id,app_id,content FROM Comment WHERE user_id ="+user_id );


            while (rs.next()) {
                Comment owned_comment = new Comment();
                owned_comment.setComment_id(rs.getInt("comment_id"));
                owned_comment.setUser_id(rs.getInt("user_id"));
                owned_comment.setApp_id(rs.getInt("app_id"));
                owned_comment.setText(rs.getString("content"));


                owned_comments.add(owned_comment);
            }
            statement.close(); statement.close();
        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

        return owned_comments;
    }

    // WAITING
    public List<Payment_method> get_owned_payments(int user_id){

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list

        List<Payment_method> owned_payment_methods = new ArrayList<Payment_method>();
        try {

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT pay_id,user_id,IBAN,credit_card FROM Payment_method P, End_user E, User U WHERE P.user_id ="+
                    user_id+" AND E.user_id ="+user_id+ " AND U.user_id ="+user_id);


            while (rs.next()) {
                Payment_method owned_payment_method = new Payment_method();
                owned_payment_method.setPay_id(rs.getInt("pay_id"));
                owned_payment_method.setUser_id(rs.getInt("user_id"));
                owned_payment_method.setIBAN(rs.getString("IBAN"));
                owned_payment_method.setCredit_card(rs.getString("credit_card"));


                owned_payment_methods.add(owned_payment_method);
            }
            statement.close();
        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

        return owned_payment_methods;
    }

    //WAITING
    public Settings get_owned_settings(int user_id){

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        Settings owned_settings = new Settings();
        //Application[] owned_app_list
        //List<Payment_method> owned_payment_methods = new ArrayList<Payment_method>();
        try {

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT set_id,theme,layout,dark_mode FROM User U, Settings S WHERE U.set_id = S.set_id AND user_id= "+user_id);


            while (rs.next()) {

                owned_settings.setSet_id(rs.getInt("set_id"));
                owned_settings.setTheme(rs.getInt("theme"));
                owned_settings.setLayout(rs.getInt("layout"));
                owned_settings.setDark_mode(rs.getInt("dark_mode"));


                //owned_settings.add(owned_payment_method);
            }
            statement.close();
        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

        return owned_settings;

    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // WAITING
    public List<Application> get_best_selling_applications(){

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list

        List<Application> owned_apps = new ArrayList<Application>();
        try {

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery( "SELECT app_id,app_name,publishing_date,price,text,logo, count FROM Download D NATURAL JOIN Application A, Request_publish R" +
                    " WHERE price >0 AND count =(SELECT max(count) FROM Download) AND D.app_id = A.app_id AND R.approvement=1 AND R.app_id = A.app_id");

            while (rs.next()) {
                Application owned_app = new Application();
                owned_app.setApp_id(rs.getInt("app_id"));
                owned_app.setApp_name(rs.getString("app_name"));
                owned_app.setDATE(rs.getString("publishing_date"));
                owned_app.setPrice(rs.getInt("price"));
                owned_app.setText(rs.getString("text"));
                owned_app.setLogo(rs.getString("logo"));
                owned_apps.add(owned_app);
            }
            statement.close();
        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

        return owned_apps;

    }

    //DONE
    public List<Application> get_free_applications(){

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list

        List<Application> owned_apps = new ArrayList<Application>();
        try {

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery( "SELECT app_id,app_name,publishing_date,price,text,logo FROM Application A NATURAL JOIN Request_publish R WHERE price =0  " +
                    "AND R.app_id = A.app_id AND R.approvement=1");

            while (rs.next()) {
                Application owned_app = new Application();
                owned_app.setApp_id(rs.getInt("app_id"));
                owned_app.setApp_name(rs.getString("app_name"));
                owned_app.setDATE(rs.getString("publishing_date"));
                owned_app.setPrice(rs.getInt("price"));
                owned_app.setText(rs.getString("text"));
                owned_app.setLogo(rs.getString("logo"));
                owned_apps.add(owned_app);
            }
            statement.close();
        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

        return owned_apps;
    }

    // WAITING
    public List<Application> get_new_added_applications(){

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list

        List<Application> owned_apps = new ArrayList<Application>();
        try {
            
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery( "SELECT app_id,app_name,publishing_date,price,text,logo FROM Application A, Request_publish R " +
                    "WHERE R.app_id = A.app_id AND R.approvement=1 AND A.app_id not exist(SELECT app_id FROM Download");

            while (rs.next()) {
                Application owned_app = new Application();
                owned_app.setApp_id(rs.getInt("app_id"));
                owned_app.setApp_name(rs.getString("app_name"));
                owned_app.setDATE(rs.getString("publishing_date"));
                owned_app.setPrice(rs.getInt("price"));
                owned_app.setText(rs.getString("text"));
                owned_app.setLogo(rs.getString("logo"));
                owned_apps.add(owned_app);
            }
            statement.close();
        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

        return owned_apps;

    }
    //WAITING
    public List<Movie> get_movies() {

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list

        List<Movie> owned_movies = new ArrayList<Movie>();
        try {

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * FROM Movie");


            while (rs.next()) {
                Movie owned_movie = new Movie();
                owned_movie.setMovie_id(rs.getInt("movie_id"));
                owned_movie.setMovie_name(rs.getString("movie_name"));
                owned_movie.setRelease_date(rs.getString("release_date"));
                owned_movie.setImdb_rate(rs.getDouble("imdb_rate"));

                owned_movies.add(owned_movie);
            }
            statement.close();
        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

        return owned_movies;
    }

    //WAITING
    public List<Book> get_books(int user_id){

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list

        List<Book> owned_books = new ArrayList<Book>();
        try {

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery( "SELECT * FROM Book" );


            while (rs.next()) {
                Book owned_book = new Book();
                owned_book.setBook_id(rs.getInt("book_id"));
                owned_book.setBook_name(rs.getString("book_name"));
                owned_book.setAuthor_name(rs.getString("release_date"));

                owned_books.add(owned_book);
            }
            statement.close();
        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

        return owned_books;
    }
    //DONE
    public List<Application> get_wish_list(int  user_id){

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list

        List<Application> owned_apps = new ArrayList<Application>();
        try {

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery( "SELECT app_id, app_name,publishing_date,price,text,logo FROM Wish_list W NATURAL JOIN Application A WHERE end_user_id ="+ user_id+
                    " AND W.app_id = A.app_id");

            while (rs.next()) {
                Application owned_app = new Application();
                owned_app.setApp_id(rs.getInt("app_id"));
                owned_app.setApp_name(rs.getString("app_name"));
                owned_app.setDATE(rs.getString("publishing_date"));
                owned_app.setPrice(rs.getInt("price"));
                owned_app.setText(rs.getString("text"));
                owned_app.setLogo(rs.getString("logo"));
                owned_apps.add(owned_app);
            }
            statement.close();
        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

        return owned_apps;

    }

    //DONE
    public List<Application> search_app(String search_app){

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list
        String search_string = "\""+ search_app + "%"+"\"";
        search_app +="%";
        List<Application> owned_apps = new ArrayList<Application>();
        try {

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery( "SELECT app_id, app_name,publishing_date,price,text,logo FROM Application A NATURAL JOIN Request_publish R " +
                    " WHERE app_name LIKE "+search_string);

            //System.out.println("SELECT app_id, app_name,publishing_date,price,text,logo FROM Application A NATURAL JOIN Request_publish R " +
            //      " WHERE R.app_id = A.app_id AND R.approvement=1 AND app_name LIKE '"+"%"+search_app+"%'");

            while (rs.next()) {
                Application owned_app = new Application();
                owned_app.setApp_id(rs.getInt("app_id"));
                owned_app.setApp_name(rs.getString("app_name"));
                owned_app.setDATE(rs.getString("publishing_date"));
                owned_app.setPrice(rs.getInt("price"));
                owned_app.setText(rs.getString("text"));
                owned_app.setLogo(rs.getString("logo"));
                owned_apps.add(owned_app);
            }
            statement.close();
        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

        return owned_apps;

    }

    //WAITING
    public List<Application> search_category(String search_category){

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list

        List<Application> owned_apps = new ArrayList<Application>();
        try {
            
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery( "SELECT app_id, app_name,publishing_date,price,text,logo FROM Has_category H NATURAL JOIN Application A, Request_publish R WHERE category_name LIKE "+ "\""+search_category+"\"+" +
                    "AND H.app_id = A.app_id"+
                    "R.app_id = A.app_id AND R.approvement=1");

            while (rs.next()) {
                Application owned_app = new Application();
                owned_app.setApp_id(rs.getInt("app_id"));
                owned_app.setApp_name(rs.getString("app_name"));
                owned_app.setDATE(rs.getString("publishing_date"));
                owned_app.setPrice(rs.getInt("price"));
                owned_app.setText(rs.getString("text"));
                owned_app.setLogo(rs.getString("logo"));
                owned_apps.add(owned_app);
            }
            statement.close();
        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

        return owned_apps;

    }
    //WAITING
    public List<Application> search_app_and_category(String search_app,String search_category){

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list

        List<Application> owned_apps = new ArrayList<Application>();
        try {

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery( "SELECT app_id, app_name FROM Has_category H NATURAL JOIN Application A, Request_publish R WHERE category_name LIKE"+
                    "\""+search_category+"\""+ "AND app_name LIKE"+ "\""+search_app+"\""+"AND H.app_id = A.app_id"
                    +"R.app_id = A.app_id AND R.approvement=1");

            while (rs.next()) {
                Application owned_app = new Application();
                owned_app.setApp_id(rs.getInt("app_id"));
                owned_app.setApp_name(rs.getString("app_name"));
                owned_app.setDATE(rs.getString("publishing_date"));
                owned_app.setPrice(rs.getInt("price"));
                owned_app.setText(rs.getString("text"));
                owned_app.setLogo(rs.getString("logo"));
                owned_apps.add(owned_app);
            }
            statement.close();
        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

        return owned_apps;

    }
    // Apps page queries:
    //DONE
    public Application get_app(int app_id){

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list
        Application owned_app = new Application();
        List<Application> owned_apps = new ArrayList<Application>();
        try {
            
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery( "SELECT app_id,app_name,publishing_date,price,text,logo FROM Application WHERE app_id= "+app_id);

            while (rs.next()) {
                //Application owned_app = new Application();
                owned_app.setApp_id(rs.getInt("app_id"));
                owned_app.setApp_name(rs.getString("app_name"));
                owned_app.setDATE(rs.getString("publishing_date"));
                owned_app.setPrice(rs.getInt("price"));
                owned_app.setText(rs.getString("text"));
                owned_app.setLogo(rs.getString("logo"));
                owned_apps.add(owned_app);
            }
            statement.close();
        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

        return owned_app;
    }


    //DONE
    public List<Application> get_app_on_sale(){

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list

        List<Application> owned_apps = new ArrayList<Application>();
        try {

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery( "SELECT app_id,app_name,publishing_date,price,text,logo FROM Application A NATURAL JOIN Request_publish R WHERE price >0  " +
                    "AND R.app_id = A.app_id AND R.approvement=1");

            while (rs.next()) {
                Application owned_app = new Application();
                owned_app.setApp_id(rs.getInt("app_id"));
                owned_app.setApp_name(rs.getString("app_name"));
                owned_app.setDATE(rs.getString("publishing_date"));
                owned_app.setPrice(rs.getInt("price"));
                owned_app.setText(rs.getString("text"));
                owned_app.setLogo(rs.getString("logo"));
                owned_apps.add(owned_app);
            }
            statement.close();
        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

        return owned_apps;
    }


    //DONE
    public List<Application> get_app_best_rate(){

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list

        List<Application> owned_apps = new ArrayList<Application>();
        try {

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(
                    " SELECT app_id, AVG(point) AS rate FROM Rate GROUP BY app_id ORDER BY rate DESC ");


            rs.next();
            double max = rs.getDouble("rate");
            System.out.println("max"+max);
            Application max_app = new Application();
            max_app = get_app(rs.getInt("app_id"));
            owned_apps.add(max_app);
            while (rs.next()) {
                double count = rs.getDouble("rate");
                Application owned_app = null;
                System.out.println("count:"+count);
                if(count==max){
                    //owned_app = new Application();
                    owned_app = get_app(rs.getInt("app_id"));
                }

                /*
                owned_app.setApp_id(rs.getInt("app_id"));
                owned_app.setApp_name(rs.getString("app_name"));
                owned_app.setDATE(rs.getString("publishing_date"));
                owned_app.setPrice(rs.getInt("price"));
                owned_app.setText(rs.getString("text"));
                owned_app.setLogo(rs.getString("logo"));

                 */
                if(owned_app != null)
                    owned_apps.add(owned_app);
            }

            statement.close();
        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

        return owned_apps;
    }
    //DONE
    public List<Application> get_app_most_downloaded(){

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list

        List<Application> owned_apps = new ArrayList<Application>();
        List<Integer> list = new ArrayList<Integer>();
        try {

            Statement statement = connection.createStatement();

            //ResultSet rs1= statement.executeQuery((SELECT SUM(P.count) AS total FROM Download P GROUP BY P.app_id))

            ResultSet rs = statement.executeQuery(


                    "SELECT T.app_id, T.total"+
                            " FROM (SELECT app_id , SUM(count) AS total FROM Download GROUP BY app_id) T "
                            +" ORDER BY T.total DESC;"

                    //+" WHERE A.cont = A.maxVal"
            );
            rs.next();
            int max = rs.getInt("total");
            Application max_app = new Application();
            max_app = get_app(rs.getInt("app_id"));
            owned_apps.add(max_app);
            while (rs.next()) {
                int count = rs.getInt("total");
                Application owned_app = null;
                if(count==max){
                    //owned_app = new Application();
                    owned_app = get_app(rs.getInt("app_id"));
                }

                /*
                owned_app.setApp_id(rs.getInt("app_id"));
                owned_app.setApp_name(rs.getString("app_name"));
                owned_app.setDATE(rs.getString("publishing_date"));
                owned_app.setPrice(rs.getInt("price"));
                owned_app.setText(rs.getString("text"));
                owned_app.setLogo(rs.getString("logo"));

                 */
                if(owned_app != null)
                    owned_apps.add(owned_app);
            }
            statement.close();
        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

        return owned_apps;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Application information page queries:
    //DONE
    public Application get_app_informations(String app_name){

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list
        Application owned_app = new Application();
        List<Application> owned_apps = new ArrayList<Application>();
        try {

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery( "SELECT app_id,app_name,publishing_date,price,text,logo FROM Application WHERE app_name= "+ "\""+ app_name+"\"");

            while (rs.next()) {
                //Application owned_app = new Application();
                owned_app.setApp_id(rs.getInt("app_id"));
                owned_app.setApp_name(rs.getString("app_name"));
                owned_app.setDATE(rs.getString("publishing_date"));
                owned_app.setPrice(rs.getInt("price"));
                owned_app.setText(rs.getString("text"));
                owned_app.setLogo(rs.getString("logo"));
                owned_apps.add(owned_app);
            }
            statement.close();
        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

        return owned_app;
    }
    //DONE
    public User get_User(int user_id){

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list
        User user = new User();
        List<Application> owned_apps = new ArrayList<Application>();
        try {

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery( "SELECT * FROM User WHERE user_id = "+ user_id);

            while (rs.next()) {
                //Application owned_app = new Application();
                user.setUser_id(rs.getInt("user_id"));
                user.setPassword(rs.getString("password"));
                user.setUsername(rs.getString("name"));
                user.setSurname(rs.getString("surname"));
                user.setDATE(rs.getString("birth_date"));
                user.setEmail(rs.getString("email"));
                user.setSet_id(rs.getInt("set_id"));
                //owned_apps.add(owned_app);
            }
            statement.close();
        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

        return user;


    }

    public static int calculateAge(LocalDate birthDate, LocalDate currentDate) {
        if ((birthDate != null) && (currentDate != null)) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }
    }
    //DONE
    public void download_app(int user_id,String app_name, int device_id){

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list
        Device device = get_Device(device_id);
        System.out.println("device  id =" + device.getDevice_id());
        Application app = get_app_informations(app_name);
        System.out.println("app name =" + app.getApp_name());
        MinimumRequirements req = get_min_req(app.getApp_id());
        User user = get_User(user_id);
        //LocalDate birth_date = new LocalDate(user.getDATE());
        //calculateAge()
        String year = user.getDATE().substring(0,4);
        String month =user.getDATE().substring(5,7);
        String day=user.getDATE().substring(8,10);

        Month m = Month.of(Integer.parseInt(month));
        LocalDate now = LocalDate.now();
        LocalDate birth_date = LocalDate.of(Integer.parseInt(year),m,Integer.parseInt(day));

        int age = calculateAge (birth_date, now);

        System.out.println("age is :" + age);


        if( user.getUser_id() >= 20000000 && user !=null){
            System.out.println("You are an editor or a developer. So you cannot download an app");
        }

        else if(app.getPrice() >0 && age < 18 && app !=null){
            System.out.println("You are not above age of 18 so you cannot download paid apps");
        }
        else if(device.getRAM() < req.getRAM() && device != null){
            System.out.println("Your system's specialities are below this app's requirements");
        }

        else {


            Application owned_app = get_app_informations(app_name);
            try {

                Statement statement = connection.createStatement();

                String query1 = "INSERT INTO Download VALUES(" + user_id + "," + device_id + "," + owned_app.getApp_id() + "," + "1" + ");";
                //System.out.println(query1);


                statement.execute(query1);

                statement.close();
            } catch (Exception e) {
                System.err.println("Error Statement or Connection Failed!");
                e.printStackTrace();
            }
        }
        //return owned_app;
    }


    //DONE
    public void rate_app(int user_id,String app_name, double rate) {

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list
        Application owned_app = get_app_informations(app_name);
        try {

            Statement statement = connection.createStatement();

            String query1 = "INSERT INTO Rate VALUES(" + user_id + "," + owned_app.getApp_id() + "," + rate + ");";
            //String query2 = "SELECT average(point) FROM Rate group by app_id WHERE app_id =" + owned_app.getApp_id();

            statement.execute(query1);
            //statement.execute(query2);
            statement.close();
        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

    }

    //DONE
    public Double get_rate_app(String app_name) {

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list
        Application owned_app = get_app_informations(app_name);
        Rate rate = new Rate();
        Double point = 0.0;
        try {

            Statement statement = connection.createStatement();


            ResultSet rs = statement.executeQuery( "SELECT AVG(point) AS point FROM Rate  WHERE app_id =" + owned_app.getApp_id()+" GROUP BY app_id" );
            rs.next();
            point = rs.getDouble("point");

            //statement.execute(query2);
            statement.close();
        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }
        return point;
    }

    //DONE
    public void add_app_wish_list(int user_id,String app_name){

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list
        Application owned_app = get_app_informations(app_name);
        try{

            Statement statement = connection.createStatement();

            String query1 = "INSERT INTO Wish_list VALUES("+user_id+","+owned_app.getApp_id()+");";
            statement.execute(query1);
            statement.close();
        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

        //return owned_app;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Upload Request Page queries:
    //DONE
    public List<Editor> get_editors(){


        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";



        List<Editor> editors = new ArrayList<Editor>();

        try{

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * FROM Editor");

            while(rs.next()){
                Editor new_editor = new Editor();
                new_editor.setUser_id(rs.getInt("editor_id"));
                new_editor.setSalary(rs.getInt("salary"));
                editors.add(new_editor);
            }
            statement.close();
        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

        return editors;
    }
    //DONE
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

            Statement statement = connection.createStatement();

            String query1 = "INSERT INTO Application VALUES("+"default"+","+
                    "\""+app_name+"\""+ ","+
                    "\""+publishing_date+"\""+ ","+
                    price+ ","+
                    "\""+text+"\""+ ","+
                    "\""+logo+"\""+ ");";
            statement.execute(query1);
            ResultSet rs= statement.executeQuery("SELECT app_id FROM Application WHERE app_name= "+"\""+app_name+"\"");
            rs.next();
            int app_id = rs.getInt("app_id");

            //ResultSet rs2= statement.executeQuery("SELECT editor_id FROM Editor,User WHERE editor = ");
            //rs2.next();
            //int editor_id = rs.getInt("editor_id");

            String query2 = "INSERT INTO Request_publish VALUES("+ editor_id+","+
                    developer_id+","+
                    app_id+","+
                    "0);";


            statement.execute(query2);
            statement.close();
        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

        //return owned_app;
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Approve request page

    //DONE
    public List<Application> get_requested_apps(int editor_id){
        // we are already editor in this page so user_id = editor_id

        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list

        List<Application> owned_apps = new ArrayList<Application>();
        try {

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery( "SELECT app_id,app_name,publishing_date,price,text,logo FROM Application NATURAL JOIN Request_publish WHERE editor_id ="
                    +editor_id+
                    " AND approvement = 0");

            while (rs.next()) {
                Application owned_app = new Application();
                owned_app.setApp_id(rs.getInt("app_id"));
                owned_app.setApp_name(rs.getString("app_name"));
                owned_app.setDATE(rs.getString("publishing_date"));
                owned_app.setPrice(rs.getInt("price"));
                owned_app.setText(rs.getString("text"));
                owned_app.setLogo(rs.getString("logo"));
                owned_apps.add(owned_app);
            }
            statement.close();
        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

        return owned_apps;
    }

    //DONE
    public void approve_request(int editor_id,int app_id){
        // we are already editor in this page so user_id = editor_id



        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String userName = "root";
        String pass = "CS353FALL19";

        //Application[] owned_app_list
        Application owned_app = new Application();
        List<Application> owned_apps = new ArrayList<Application>();
        try {

            Statement statement = connection.createStatement();

            String query1 = "UPDATE Request_publish " +
                    "SET approvement = 1" +
                    " WHERE editor_id ="+ editor_id+" AND app_id ="+app_id+";";
            statement.execute(query1);
            statement.close();
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

            Statement statement = connection.createStatement();

            String query1 = "UPDATE Request_publish " +
                    "SET approvement = 0" +
                    " WHERE editor_id ="+ editor_id+" AND app_id ="+app_id+";";
            statement.execute(query1);
            statement.close();
        } catch (Exception e) {
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }
    }

}
