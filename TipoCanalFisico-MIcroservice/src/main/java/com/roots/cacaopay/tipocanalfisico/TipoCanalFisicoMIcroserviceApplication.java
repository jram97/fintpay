package com.roots.cacaopay.tipocanalfisico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class TipoCanalFisicoMIcroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TipoCanalFisicoMIcroserviceApplication.class, args);
	}

}
