package com.example.demo;

import com.example.demo.services.QueryService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		/*QueryService q = new QueryService();
		q.get_requested_apps(30000000);
*/


	}

}
