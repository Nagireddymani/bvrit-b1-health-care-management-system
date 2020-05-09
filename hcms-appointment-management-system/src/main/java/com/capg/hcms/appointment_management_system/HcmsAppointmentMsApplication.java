package com.capg.hcms.appointment_management_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class HcmsAppointmentMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HcmsAppointmentMsApplication.class, args);
	}
	
}
