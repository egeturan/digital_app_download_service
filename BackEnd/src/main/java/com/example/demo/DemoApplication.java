package com.example.demo;

import com.example.demo.components.Application;
import com.example.demo.controller.AlertController;
import com.example.demo.services.QueryService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;
import java.text.ParseException;
import java.util.List;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		QueryService q = new QueryService();
		List<Application> appO = q.search_app("ins");
		for (int i = 0; i < appO.size(); i++){
			System.out.println(appO.get(i).getApp_name());
		}





	}

}
