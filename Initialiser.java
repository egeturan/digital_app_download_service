import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;
public class Initialiser {

    public static void main(String[] args) {
        String google_con = "jdbc:mysql://35.242.165.113/adastore";
        String user_name = "root";
        String pass = "CS353FALL19";
        try {


            Connection connection = DriverManager.getConnection(google_con, user_name, pass);
            Statement statement = connection.createStatement();


            System.out.println("Success connection");
            //statement.execute("DROP TABLE IF EXISTS apply, company, student");

            statement.execute("DROP TABLE IF EXISTS Application," +
                    "Category," +
                    "Sub_category," +
                    "Minimum_requirements," +
                    "Has_req," +
                    "Has_category," +
                    "Has_device," +
                    "Editor," +
                    "Movie," +
                    "Upload_movie,"+
                    "Book," +
                    "Upload_book," +
                    "Download_book," +
                    "Download_movie," +
                    "Request_publish," +
                    "Request_update," +
                    "Download," +
                    "Wish_list," +
                    "Rate,"+
                    "End_user," +
                    "Developer," +
                    "Device," +
                    "Payment_method,"+
                    "Comment," +
                    "User," +
                    "Settings," +
                    "Message");

            String create_application = "CREATE TABLE Application("
                    +"app_id INT AUTO_INCREMENT,"
                    +"app_name VARCHAR(255) NOT NULL,"
                    +"publishing_date DATE,"
                    +"price INT,"
                    +"text VARCHAR(255),"
                    +"logo VARCHAR(255),"
                    +"PRIMARY KEY (app_id))";

            statement.execute(create_application);
            System.out.println("Success");

            String create_user =  "CREATE TABLE User("
                    +"user_id INT AUTO_INCREMENT,"
                    +"password VARCHAR(255) NOT NULL,"
                    +"name VARCHAR(255) NOT NULL,"
                    +"surname VARCHAR(255) NOT NULL,"
                    +"birth_date DATE,"
                    +"email VARCHAR(255) NOT NULL,"
                    +"set_id INT NOT NULL,"
                    +"PRIMARY KEY (user_id))";

            statement.execute(create_user);


            String create_category = "CREATE TABLE Category("
                    +"category_id INT AUTO_INCREMENT,"
                    +"category_name VARCHAR(255) NOT NULL,"
                    +"PRIMARY KEY ( category_id))";

            statement.execute(create_category);

            String create_min_req = "CREATE TABLE Minimum_requirements ("
                    +"app_id INT NOT NULL,"
                    +"RAM INT,"
                    +"CPU VARCHAR(255),"
                    +"OS_version VARCHAR(255),"
                    +"PRIMARY KEY(app_id,RAM,CPU,OS_version))";

            statement.execute(create_min_req);



            String create_movie = "CREATE TABLE Movie("
                    +"movie_id INT AUTO_INCREMENT,"
                    +"movie_name VARCHAR(255) NOT NULL,"
                    +"release_date DATE,"
                    +"imdb_rate DOUBLE,"
                    +"PRIMARY KEY(movie_id))";

            statement.execute(create_movie);

            String create_book = "CREATE TABLE Book("
                    +"book_id INT AUTO_INCREMENT,"
                    +"book_name VARCHAR(255) NOT NULL,"
                    +"author_name VARCHAR(255) NOT NULL,"
                    +"PRIMARY KEY (book_id))";

            statement.execute(create_book);

            String create_settings = "CREATE TABLE Settings("
                    +"set_id INT AUTO_INCREMENT,"
                    +"theme INT NOT NULL,"
                    +"layout INT NOT NULL,"
                    +"dark_mode INT NOT NULL,"
                    +"PRIMARY KEY (set_id))";

            statement.execute(create_settings);


            String create_sub_category = "CREATE TABLE Sub_category("
                    +"super_category_id INT AUTO_INCREMENT,"
                    +"sub_category_id INT,"
                    +"FOREIGN KEY(super_category_id) REFERENCES Category(category_id),"
                    +"FOREIGN KEY(sub_category_id) REFERENCES Category(category_id),"
                    +"PRIMARY KEY (super_category_id, sub_category_id))";

            statement.execute(create_sub_category);

            String create_has_category = "CREATE TABLE Has_category("
                    +"app_id INT NOT NULL,"
                    +"category_id INT NOT NULL,"
                    +"FOREIGN KEY(app_id) REFERENCES Application(app_id),"
                    +"FOREIGN KEY(category_id) REFERENCES Category(category_id),"
                    +"PRIMARY KEY(app_id, category_id))";

            statement.execute(create_has_category);



            String create_editor= "CREATE TABLE Editor("
                    +"editor_id INT NOT NULL,"
                    +"salary INT NOT NULL,"
                    +"FOREIGN KEY(editor_id) REFERENCES User(user_id),"
                    +"PRIMARY KEY(editor_id))";

            statement.execute(create_editor);


            String create_upload_movie = "CREATE TABLE Upload_movie("
                    +"user_id INT NOT NULL,"
                    +"movie_id INT NOT NULL,"
                    +"FOREIGN KEY(user_id) REFERENCES Editor(editor_id),"
                    +"FOREIGN KEY(movie_id) REFERENCES Movie(movie_id),"
                    +"PRIMARY KEY (user_id,movie_id))";

            statement.execute(create_upload_movie);




            String create_upload_book =  "CREATE TABLE Upload_book("
                    +"user_id INT NOT NULL,"
                    +"book_id INT NOT NULL,"
                    +"FOREIGN KEY(user_id) REFERENCES Editor(editor_id),"
                    +"FOREIGN KEY(book_id) REFERENCES Book(book_id),"
                    +"PRIMARY KEY (user_id, book_id))";

            statement.execute(create_upload_book);

            String create_download_book = "CREATE TABLE Download_book("
                    +"user_id INT NOT NULL,"
                    +"book_id INT NOT NULL,"
                    +"FOREIGN KEY(user_id) REFERENCES User(user_id),"
                    +"FOREIGN KEY(book_id) REFERENCES Book(book_id),"
                    +"PRIMARY KEY (user_id, book_id))";

            statement.execute(create_download_book);

            String create_download_movie = "CREATE TABLE Download_movie("
                    +"user_id INT NOT NULL,"
                    +"movie_id INT NOT NULL,"
                    +"FOREIGN KEY(user_id) REFERENCES User(user_id),"
                    +"FOREIGN KEY(movie_id) REFERENCES Movie(movie_id),"
                    +"PRIMARY KEY (user_id,movie_id))";

            statement.execute(create_download_movie);

            String create_request_publish = "CREATE TABLE Request_publish("
                    +"editor_id INT NOT NULL,"
                    +"dev_id INT NOT NULL,"
                    +"app_id INT NOT NULL,"
                    +"approvement INT NOT NULL,"
                    +"FOREIGN KEY(editor_id) REFERENCES User(user_id),"
                    +"FOREIGN KEY(dev_id) REFERENCES User(user_id),"
                    +"FOREIGN KEY(app_id) REFERENCES Application(app_id),"
                    +"PRIMARY KEY (app_id))";

            statement.execute(create_request_publish);

            String create_req_update = "CREATE TABLE Request_update("
                    +"editor_id INT NOT NULL,"
                    +"dev_id INT NOT NULL,"
                    +"app_id INT NOT NULL,"
                    +"approvement INT NOT NULL,"
                    +"FOREIGN KEY(editor_id) REFERENCES User(user_id),"
                    +"FOREIGN KEY(dev_id) REFERENCES User(user_id),"
                    +"FOREIGN KEY(app_id) REFERENCES Application(app_id),"
                    +"PRIMARY KEY (app_id))";

            statement.execute(create_req_update);



            String create_end_user = "CREATE TABLE End_user("
                    +"end_user_id INT NOT NULL,"
                    +"FOREIGN KEY(end_user_id) REFERENCES User(user_id),"
                    +"PRIMARY KEY (end_user_id))";

            statement.execute(create_end_user);


            String create_wish_list =  "CREATE TABLE Wish_list("
                    +"end_user_id INT NOT NULL,"
                    +"app_id INT NOT NULL,"
                    +"FOREIGN KEY(end_user_id) REFERENCES End_user(end_user_id),"
                    +"FOREIGN KEY(app_id) REFERENCES Application(app_id),"
                    +"PRIMARY KEY (end_user_id, app_id))";


            statement.execute(create_wish_list);


            String create_rate = "CREATE TABLE Rate("
                    +"user_id INT NOT NULL,"
                    +"app_id INT NOT NULL,"
                    +"point DOUBLE,"
                    +"FOREIGN KEY(user_id) REFERENCES End_user(end_user_id),"
                    +"FOREIGN KEY(app_id) REFERENCES Application(app_id),"
                    +"PRIMARY KEY (user_id, app_id))";

            statement.execute(create_rate);



            String create_developer = "CREATE TABLE Developer("
                    +"developer_id INT NOT NULL,"
                    +"company_name VARCHAR(255),"
                    +"FOREIGN KEY(developer_id) REFERENCES User(user_id),"
                    +"PRIMARY KEY (developer_id))";

            statement.execute(create_developer);


            String create_device = "CREATE TABLE Device("
                    +"device_id INT AUTO_INCREMENT,"
                    +"model_version VARCHAR(255) NOT NULL,"
                    +"os_version VARCHAR(255) NOT NULL,"
                    +"CPU VARCHAR(255) NOT NULL,"
                    +"RAM INT NOT NULL,"
                    +"PRIMARY KEY (device_id))";


            statement.execute(create_device);


            String create_has_device = "CREATE TABLE Has_device("
                    +"user_id INT NOT NULL,"
                    +"device_id INT NOT NULL,"
                    +"FOREIGN KEY(user_id) REFERENCES End_user(end_user_id),"
                    +"FOREIGN KEY(device_id) REFERENCES Device(device_id),"
                    +"PRIMARY KEY (device_id))";

            statement.execute(create_has_device);


            String create_download =  "CREATE TABLE Download("
                    +"user_id INT NOT NULL,"
                    +"device_id INT NOT NULL,"
                    +"app_id INT NOT NULL,"
                    //+"FOREIGN KEY(user_id) REFERENCES Has_device(user_id),"
                    //+"FOREIGN KEY(device_id) REFERENCES Has_device(device_id),"
                    +"FOREIGN KEY(user_id,device_id) REFERENCES Has_device(user_id,device_id)," // for aggregation
                    +"FOREIGN KEY(app_id) REFERENCES Application(app_id),"
                    +"PRIMARY KEY (user_id,device_id,app_id))";

            statement.execute(create_download);

            String create_payment_method = "CREATE TABLE Payment_method("
                    +"pay_id INT,"
                    +"user_id INT,"
                    +"IBAN CHAR(26),"
                    +"credit_card CHAR(16),"
                    +"FOREIGN KEY(user_id) REFERENCES End_user(end_user_id),"
                    +"PRIMARY KEY (pay_id,user_id))";

            statement.execute(create_payment_method);

            String create_comment = "CREATE TABLE Comment("
                    +"comment_id INT AUTO_INCREMENT,"
                    +"user_id INT NOT NULL,"
                    +"app_id INT NOT NULL,"
                    +"content VARCHAR(255) NOT NULL,"
                    +"FOREIGN KEY(user_id) REFERENCES End_user(end_user_id),"
                    +"FOREIGN KEY(app_id) REFERENCES Application(app_id),"
                    +"PRIMARY KEY (comment_id, user_id))";

            statement.execute(create_comment);

            String create_message =  "CREATE TABLE Message("
                    +"sender_id INT NOT NULL,"
                    +"receiver_id INT NOT NULL,"
                    +"text VARCHAR(255) NOT NULL,"
                    +"FOREIGN KEY(sender_id) REFERENCES User(user_id),"
                    +"FOREIGN KEY(receiver_id) REFERENCES User(user_id),"
                    +"PRIMARY KEY (sender_id, receiver_id))";

            statement.execute(create_message);



        }
        catch(Exception e){
            System.err.println("Error Statement or Connection Failed!");
            e.printStackTrace();
        }

    }
}
