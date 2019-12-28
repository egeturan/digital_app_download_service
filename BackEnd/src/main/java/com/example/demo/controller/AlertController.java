package com.example.demo.controller;

import com.example.demo.components.*;
import com.example.demo.services.QueryService;
import org.springframework.web.bind.annotation.*;
import java.util.Hashtable;
import java.util.List;


@RestController //contorller ve response bodynin birleşmiş hali
@CrossOrigin(origins = "http://localhost:3000")
public class AlertController {

    static Hashtable<String, Object> authenticatedUsers = new Hashtable<String, Object>();

    static int userCount = 0;
    final String hash = "0xabc0";

    QueryService queryService = new QueryService();


    @RequestMapping("/registerUser") //bu url e sadece post request atılabilicek
    public User registerUser(@RequestBody User userObject){

        System.out.println(userObject.getUsername());

        Response res = new Response();
        queryService.registiration_end_user(userObject.getUsername(), userObject.getSurname(), userObject.getDATE(), userObject.getEmail(), userObject.getPassword());

        res.setSituation(1);
        System.out.println(userObject.getUsername());


        return userObject;
    }



    //Register Editor
    @RequestMapping("/registerEditor") //bu url e sadece post request atılabilicek
    public Editor registerEditor(@RequestBody Editor userObject){

        System.out.println("User name is: " + userObject.getUsername());
        queryService.registiration_editor(userObject.getUsername(), userObject.getSurname(), userObject.getDATE(), userObject.getEmail(), userObject.getPassword(), userObject.getSalary());
        Response res = new Response();
        res.setSituation(1);


        return userObject;
    }

    //Register Developer
    @RequestMapping("/registerDeveloper") //bu url e sadece post request atılabilicek
    public Developer registerDeveloper(@RequestBody Developer userObject){
        //String name, String surname, String birth_date, String email, String password, String company_name
        queryService.registiration_developer(userObject.getUsername(),userObject.getSurname(), userObject.getDATE(), userObject.getEmail(), userObject.getPassword(), userObject.getCompanyname());

        Response res = new Response();
        res.setSituation(1);
        System.out.println(userObject.getCompanyname());
        return userObject;

    }

    //Login
    @RequestMapping("/login") //bu url e sadece post request atılabilicek
    public Object login(@RequestBody User userObject){
        System.out.println(userObject.getUsername());

        Object ob = queryService.loginQuery(userObject.getUsername(), userObject.getPassword());

        System.out.println("Login works");
        int idControl = ((User)ob).getUser_id();
        System.out.println("Id is: " + idControl);
        if(idControl / 10000000 == 1){
            System.out.println("We have an User");
        }else if(idControl / 10000000 == 2){
            System.out.println("We have an Developer");
        }else if(idControl / 10000000 == 3){
            System.out.println("We have an Editor");
        }
        //ob != null
        if(ob != null){ //login successful
            //add person to authenticates
            userCount++;
            System.out.println("Login successful");
        }else{ //login failed
            ob = null;
        }
        return ob;
    }


    //Logout
    @RequestMapping("/logout") //bu url e sadece post request atılabilicek
    public Response logout(@RequestBody User userObject){
        System.out.println(userObject.getUsername());
        //Object ob = queryService.loginQuery();
        Response result = new Response();





        return result;
    }

    @RequestMapping("/isAuthenticated") //bu url e sadece post request atılabilicek
    public Response authenticationController(@RequestBody HashData hashDataValue){

        System.out.println("Authentication control...");
        Response result = new Response();

        if(authenticatedUsers.containsKey(hashDataValue.getHashData())){
            result.setSituation(1);
        }else{
            result.setSituation(0);
        }




        return result;
    }

    // Uploading App
    //upload_request_app(int editor_id,int developer_id,String app_name, String publishing_date, int price, String text, String logo)
    @RequestMapping("/getEditors") //bu url e sadece post request atılabilicek
    public List<Editor> getEditors(){

        Response result = new Response();
        List<Editor> editors = queryService.get_editors();


        return editors;
    }


    // Uploading App
    //upload_request_app(int editor_id,int developer_id,String app_name, String publishing_date, int price, String text, String logo)
    @RequestMapping("/upload_request_app") //bu url e sadece post request atılabilicek
    public Response upload_request_app(@RequestBody UploadRequestApp ob){

        System.out.println(" Request App Data is: " + ob.getEditor_id() + ob.getDeveloper_id() + ob.getApp_name() + ob.getPublishing_date() + ob.getPrice() + ob.getText() + ob.getLogo());

        queryService.upload_request_app(ob.getEditor_id(), ob.getDeveloper_id(), ob.getApp_name(), ob.getPublishing_date(), ob.getPrice(), ob.getText(), ob.getLogo());

        Response result = new Response();


        return result;
    }



    @RequestMapping("/get_requested_apps") //bu url e sadece post request atılabilicek
    public List<Application> get_requested_apps(@RequestBody User ob){


        System.out.println("Editor is: " + ob.getUser_id());

         List<Application> owned_apps = queryService.get_requested_apps(ob.getUser_id());

        Response result = new Response();



        return owned_apps;
    }


}
