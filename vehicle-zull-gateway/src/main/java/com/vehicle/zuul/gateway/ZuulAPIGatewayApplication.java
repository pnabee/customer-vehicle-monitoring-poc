package com.vehicle.zuul.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.vehicle.zuul.gateway.filters.ErrorFilter;
import com.vehicle.zuul.gateway.filters.PostFilter;
import com.vehicle.zuul.gateway.filters.PreFilter;
import com.vehicle.zuul.gateway.filters.RouteFilter;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class ZuulAPIGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulAPIGatewayApplication.class, args);
	}
	
	    @Bean
	    public PreFilter preFilter() {
	        return new PreFilter();
	    }
	    @Bean
	    public PostFilter postFilter() {
	        return new PostFilter();
	    }
	    @Bean
	    public ErrorFilter errorFilter() {
	        return new ErrorFilter();
	    }
	    @Bean
	    public RouteFilter routeFilter() {
	        return new RouteFilter();
	    }
}
