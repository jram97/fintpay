package com.roots.cacaopay.zuul;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Autowired
	ZuulProperties properties;
	
	@Bean
	public SwaggerResourcesProvider docApi() {
		return () -> {
			List<SwaggerResource> resources = new ArrayList<>();
			properties.getRoutes().values().stream()
					.forEach(route -> resources
					.add(createResource(route.getServiceId(), route.getServiceId(), "3.0")));
			return resources;
		};
	}
	private SwaggerResource createResource(String name, String location, String version) {
		SwaggerResource swaggerResource = new SwaggerResource();
		swaggerResource.setName(name);
		swaggerResource.setLocation("/" + location + "/v3/api-docs");
		swaggerResource.setSwaggerVersion(version);
		return swaggerResource;
	}
}
