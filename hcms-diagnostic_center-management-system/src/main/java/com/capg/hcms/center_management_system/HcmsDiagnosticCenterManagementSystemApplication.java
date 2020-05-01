package com.capg.hcms.center_management_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HcmsDiagnosticCenterManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(HcmsDiagnosticCenterManagementSystemApplication.class, args);
	}

}
