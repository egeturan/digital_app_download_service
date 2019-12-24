package com.example.demo.controller;

import com.example.demo.components.Apply;
import com.example.demo.services.QueryService;
import org.springframework.web.bind.annotation.*;

@RestController //contorller ve response bodynin birleşmiş hali
@CrossOrigin(origins = "http://localhost:3000")
public class AlertController {

    @RequestMapping("/alerts") //bu url e sadece post request atılabilicek
    public boolean getAlerts(){

        System.out.println("Request is taken");
        QueryService newq = new QueryService();
        //Apply appArr = newq.test();

        return true;
    }

}

