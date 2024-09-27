package com.example.employee_services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
//import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EmployeeServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServicesApplication.class, args);
	}

}
