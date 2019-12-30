package com.example.demo;

import com.example.demo.controller.AlertController;
import com.example.demo.services.QueryService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;
import java.text.ParseException;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		/*QueryService q = new QueryService();
		q.get_requested_apps(30000000);
*/
		AlertController newA = new AlertController();
		try {
			int age = newA.calculateAge("1996", "05","06");
			System.out.println("age is" + age);
		} catch (ParseException e) {
			e.printStackTrace();
		}


	}

}
