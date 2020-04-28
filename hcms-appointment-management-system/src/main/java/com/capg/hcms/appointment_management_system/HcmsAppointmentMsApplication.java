package com.capg.hcms.appointment_management_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class HcmsAppointmentMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HcmsAppointmentMsApplication.class, args);
	}
	
	
	@Bean
	public RestTemplate getRestTemplate() {

		return new RestTemplate();
	}

}
