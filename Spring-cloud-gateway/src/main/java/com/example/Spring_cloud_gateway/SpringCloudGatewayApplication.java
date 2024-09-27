package com.example.Spring_cloud_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringCloudGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudGatewayApplication.class, args);
	}
//
	// These is another way of configuring the Services like the application.yml files:
//	@Bean
//	public RouteLocator routerBuilder(RouteLocatorBuilder routeLocatorBuilder)
//	{
//		return routeLocatorBuilder.routes()
//
//				.route("Service-A",r->r.path("/serviceA/**")
//						.uri("http://localhost:8081/"))
//				.route("Service-B",r->r.path("/serviceB/**")
//						.uri("http://localhost:8082/")).build();
//	}

}
