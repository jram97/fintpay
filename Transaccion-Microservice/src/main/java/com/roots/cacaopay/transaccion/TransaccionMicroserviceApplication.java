package com.roots.cacaopay.transaccion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableEurekaClient
@SpringBootApplication
@EnableSwagger2
@EntityScan({
	"com.roots.cacaopay.catalogos.entity",
	"com.roots.cacaopay.transaccion.entity",
	"com.roots.cacaopay.usuarios.commons.entity"
})
public class TransaccionMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransaccionMicroserviceApplication.class, args);
	}

	@Bean
	public Docket swaggerPersonApi10() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build()
				.apiInfo(new ApiInfoBuilder().version("1.0").title("Microservicios Transacciones")
						.description("Tablas: Transaccionales ---").build());
	}
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}

}
