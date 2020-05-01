package com.capg.hcms.test_management_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HcmsDiagnosticTestManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(HcmsDiagnosticTestManagementSystemApplication.class, args);
	}

}
