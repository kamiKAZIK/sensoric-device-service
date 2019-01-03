package com.sensoric.sensor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.integration.annotation.IntegrationComponentScan;

@IntegrationComponentScan
@SpringBootApplication
class SensorService {
	public static void main(String[] args) {
		SpringApplication.run(SensorService.class, args);
	}
}
