package com.example.demo.controller;

import com.example.demo.components.*;
import com.example.demo.services.QueryService;
import org.springframework.web.bind.annotation.*;
import java.util.Hashtable;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;


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
    public Response upload_request_app(@RequestBody UploadRequestApp object){

        System.out.println(" Request App Data is: " + object.getEditor_id() + object.getDeveloper_id() + object.getApp_name() + object.getPublishing_date() + object.getPrice() + object.getText() + object.getLogo());
        System.out.println(" App requirements: cpu: " + object.getCpu() + " os version" + object.getOs_version() + " ram" +object.getRam());


        queryService.upload_request_app(object.getEditor_id(), object.getDeveloper_id(), object.getApp_name(), object.getPublishing_date(), object.getPrice(), object.getText(), object.getLogo());
        Application requestedApp = queryService.get_app_informations(object.getApp_name());
        System.out.println("App id is: " + requestedApp.getApp_id());
        int ram = Integer.parseInt(object.getRam());
        queryService.add_min_req(requestedApp.getApp_id(), object.getOs_version(),ram, object.getCpu());

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

    @RequestMapping("/rate_app") //bu url e sadece post request atılabilicek
    public Response rate_app(@RequestBody Rate rateO){
//int user_id,String app_name, double rate

        System.out.println("Rate :" + rateO.getRate() + "App name: " + rateO.getApp_name() + " user_id" + rateO.getUser_id());

        queryService.rate_app(rateO.getUser_id(),  rateO.getApp_name(), rateO.getRate());

        Response result = new Response();
        result.setSituation(1);

        return result;
    }

    @RequestMapping("/app_information") //bu url e sadece post request atılabilicek
    public Application app_information(@RequestBody Application appOb){

        System.out.println("App name is :" + appOb.getApp_name());

        Application newApplication = queryService.get_app_informations(appOb.getApp_name());

        Response result = new Response();
        result.setSituation(1);

        return newApplication;
    }

    @RequestMapping("/get_min_req") //bu url e sadece post request atılabilicek
    public MinimumRequirements get_min_req(@RequestBody Application appIdOb){

        System.out.println("App id is :" + appIdOb.getApp_id());

        MinimumRequirements minAppReq  = queryService.get_min_req(appIdOb.getApp_id());

        Response result = new Response();
        result.setSituation(1);

        return minAppReq;
    }


    @RequestMapping("/get_app_on_sale") //bu url e sadece post request atılabilicek
    public List<Application>  get_app_on_sale(){

        System.out.println("Get Apps On Sale");
        List<Application> appList  = queryService.get_app_on_sale();
        for (int i = 0; i <appList.size(); i++){
            System.out.println(appList.get(i).getApp_name());
        }

        return appList;
    }

    @RequestMapping("/get_rate_app") //bu url e sadece post request atılabilicek
    public Double get_rate_app(@RequestBody Application appR){

        System.out.println("App name is :" + appR.getApp_name());
        Double rate = queryService.get_rate_app(appR.getApp_name());


        return rate;
    }

    @RequestMapping("/reject_request") //bu url e sadece post request atılabilicek
    public Response reject_request(@RequestBody Reject rejectOb){

        System.out.println("Editor id is :" + rejectOb.getEditor_id() + " app_id is: "  + rejectOb.getApp_id());
        queryService.reject_request(rejectOb.getEditor_id() , rejectOb.getApp_id());

        Response result = new Response();
        result.setSituation(1);

        return result;
    }



    @RequestMapping("/approve_request") //bu url e sadece post request atılabilicek
    public Response approve_request(@RequestBody Reject approveObje){

        System.out.println("Editor id is :" + approveObje.getEditor_id() + " app_id is: "  + approveObje.getApp_id());
        queryService.approve_request(approveObje.getEditor_id(), approveObje.getApp_id());

        Response result = new Response();
        result.setSituation(1);

        return result;
    }


    @RequestMapping("/add_app_wish_list") //bu url e sadece post request atılabilicek
    public Response add_app_wish_list(@RequestBody Wish_list wishOb){

        System.out.println("App name is :" + wishOb.getApp_name() + "user id is: "  + wishOb.getUser_id());
        queryService.add_app_wish_list(wishOb.getUser_id(), wishOb.getApp_name());

        Response result = new Response();
        result.setSituation(1);

        return result;
    }

    @RequestMapping("/get_wish_list") //bu url e sadece post request atılabilicek
    public List<Application> get_wish_list(@RequestBody Wish_list wishOb){

        System.out.println("User id is: "  + wishOb.getUser_id());
        List<Application> listApp = queryService.get_wish_list(wishOb.getUser_id());

        return listApp;
    }

    // made but not tested
    @RequestMapping("/get_app_download_rate_views") //bu url e sadece post request atılabilicek
    public List<View>  get_app_download_rate_views(){

        System.out.println("get_app_download_rate_views");
        List<View> newView  = queryService.get_app_download_rate_views();

        return newView;
    }

    // made 2 not tested
    @RequestMapping("/get_app_rate_views") //bu url e sadece post request atılabilicek
    public List<View>  get_app_rate_views(){

        System.out.println("get_app_rate_views");
        List<View> newView2  = queryService.get_app_rate_views();

        return newView2;
    }

    // made 3 not tested
    @RequestMapping("/get_app_download_views") //bu url e sadece post request atılabilicek
    public List<View>  get_app_download_views(){

        System.out.println("get_app_download_views");
        List<View> newView3 = queryService.get_app_download_views();

        return newView3;
    }

    // made 4 not tested
    @RequestMapping("/get_approved_applications") //bu url e sadece post request atılabilicek
    public List<Application>  get_approved_applications(){

        System.out.println("get_approved_applications");
        List<Application> newApps  = queryService.get_approved_applications();

        return newApps;
    }


    // not made 5
    @RequestMapping("/get_price_ranged_applications") //bu url e sadece post request atılabilicek
    public List<Application>  get_price_ranged_applications(@RequestBody Price priceOb){

        System.out.println("get_price_ranged_applications");
        List<Application> newApps2  = queryService.get_price_ranged_applications(priceOb.getLowwer_price(), priceOb.getUpper_price());

        return newApps2;
    }

    // not made 6
    @RequestMapping("/get_Device") //bu url e sadece post request atılabilicek
    public Device  get_Device(@RequestBody Device deviceOb){

        System.out.println("get_Device");
        Device newDevice  = queryService.get_Device(deviceOb.getDevice_id());

        return newDevice;
    }


    // not made 7
    @RequestMapping("/add_devices") //bu url e sadece post request atılabilicek
    public void  add_devices(@RequestBody Device deviceOb){

        System.out.println("add_devices");
        queryService.add_devices(deviceOb.getUser_id(), deviceOb.getModel_version(), deviceOb.getOs_version(), deviceOb.getCPU(), deviceOb.getRAM() + "");

    }

    // not made 8
    @RequestMapping("/get_owned_applications") //bu url e sadece post request atılabilicek
    public List<Application>  get_owned_applications(@RequestBody User uO){

        System.out.println("get_owned_applications");
        List<Application> getOwnedApps = queryService.get_owned_applications(uO.getUser_id());

        return getOwnedApps;
    }

    // not made 9
    @RequestMapping("/get_owned_books") //bu url e sadece post request atılabilicek
    public List<Book>  get_owned_books(@RequestBody User uO2){

        System.out.println("get_owned_applications");
        List<Book> getOwnedBooks = queryService.get_owned_books(uO2.getUser_id());

        return getOwnedBooks;
    }

    // not made 10
    @RequestMapping("/get_owned_devices") //bu url e sadece post request atılabilicek
    public List<Device>  get_owned_devices(@RequestBody User uO3){

        System.out.println("get_owned_devices");
        List<Device> getDevice = queryService.get_owned_devices(uO3.getUser_id());

        return getDevice;
    }

    // not made 11
    @RequestMapping("/make_comment") //bu url e sadece post request atılabilicek
    public void  make_comment(@RequestBody Comment comOb){

        System.out.println("make_comment");
        queryService.make_comment(comOb.getUser_id(), comOb.getApp_id(), comOb.getText());

    }

    // not made 12
    @RequestMapping("/get_apps_comments") //bu url e sadece post request atılabilicek
    public List<Comment>  get_apps_comments(@RequestBody Comment comOb2){

        System.out.println("get_apps_comments");
        List<Comment> newComments = queryService.get_apps_comments(comOb2.getApp_id());

        return newComments;
    }


    // not made 13
    @RequestMapping("/get_owned_comments") //bu url e sadece post request atılabilicek
    public List<Comment>  get_owned_comments(@RequestBody Comment comOb2){

        System.out.println("get_owned_comments");
        List<Comment> commentsO = queryService.get_owned_comments(comOb2.getUser_id());

        return commentsO;
    }

    // not made 14
    @RequestMapping("/get_owned_payments") //bu url e sadece post request atılabilicek
    public List<Payment_method>  get_owned_payments(@RequestBody Comment comOb2){

        System.out.println("get_owned_payments");
        List<Payment_method> commentsO = queryService.get_owned_payments(comOb2.getUser_id());

        return commentsO;
    }

    // not made 15
    @RequestMapping("/get_owned_settings") //bu url e sadece post request atılabilicek
    public Settings  get_owned_settings(@RequestBody Comment comOb2){

        System.out.println("get_owned_settings");
        Settings setO = queryService.get_owned_settings(comOb2.getUser_id());

        return setO;
    }

    // not made 16
    @RequestMapping("/get_best_selling_applications") //bu url e sadece post request atılabilicek
    public List<Application>  get_best_selling_applications(){

        System.out.println("get_best_selling_applications");
        List<Application> appO = queryService.get_best_selling_applications();

        return appO;
    }

    // not made 17
    @RequestMapping("/get_free_applications") //bu url e sadece post request atılabilicek
    public List<Application>  get_free_applications(){

        System.out.println("get_free_applications");
        List<Application> appO8 = queryService.get_free_applications();

        return appO8;
    }

    // not made 18
    @RequestMapping("/get_new_added_applications") //bu url e sadece post request atılabilicek
    public List<Application>  get_new_added_applications(){

        System.out.println("get_new_added_applications");
        List<Application> app9 = queryService.get_new_added_applications();

        return app9;
    }


    // not made 19
    @RequestMapping("/search_app") //bu url e sadece post request atılabilicek
    public List<Application> search_app(@RequestBody Application appObje){

        System.out.println("search_app");
        System.out.println(appObje.getText());
        //List<Application> appO = queryService.search_app(appObje.getText());

        return null;
    }

    // not made 18
    @RequestMapping("/get_app") //bu url e sadece post request atılabilicek
    public Application  get_app(@RequestBody Application appObje){

        System.out.println("get_new_added_applications");
        Application appO2 = queryService.get_app(appObje.getApp_id());

        return appO2;
    }

    // not made 18
    @RequestMapping("/get_app_best_rate") //bu url e sadece post request atılabilicek
    public List<Application>  get_app_best_rate(){

        System.out.println("get_app_best_rate");
        List<Application> appO3 = queryService.get_app_best_rate();

        return appO3;
    }

    // not made 18
    @RequestMapping("/get_app_most_downloaded") //bu url e sadece post request atılabilicek
    public List<Application>  get_app_most_downloaded(){

        System.out.println("get_app_most_downloaded");
        List<Application> appO4 = queryService.get_app_most_downloaded();

        return appO4;
    }

    // not made 18
    @RequestMapping("/get_User") //bu url e sadece post request atılabilicek
    public User  get_User(@RequestBody User userOb){

        System.out.println("get_User");
        User uOb = queryService.get_User(userOb.getUser_id());

        return uOb;
    }

    // not made 18
    @RequestMapping("/download_app") //bu url e sadece post request atılabilicek
    public void  download_app(@RequestBody Device devOb4){

        System.out.println("download_app");
        queryService.download_app(devOb4.getUser_id(), devOb4.getApp_name(),devOb4.getDevice_id());


    }















    public int calculateAge(String yearS, String monthS, String dayS) throws ParseException {
        int yearI = Integer.parseInt(yearS);
        int monthI = Integer.parseInt(monthS);
        int dayI = Integer.parseInt(dayS);
        LocalDate l = LocalDate.of(yearI, monthI, dayI); //specify year, month, date directly
        LocalDate now = LocalDate.now(); //gets localDate
        Period diff = Period.between(l, now); //difference between the dates is calculated
        System.out.println(diff.getYears() + "years" + diff.getMonths() + "months" + diff.getDays() + "days");

        //using Calendar Object
        String s = "1994/06/23";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date d = sdf.parse(s);
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int date = c.get(Calendar.DATE);
        LocalDate l1 = LocalDate.of(year, month, date);
        LocalDate now1 = LocalDate.now();
        Period diff1 = Period.between(l1, now1);
        return diff1.getYears();
    }


















}
