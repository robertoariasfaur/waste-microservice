package com.rafaur.wastemicroservice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;



//@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class WasteMicroserviceApplication  {



	public static void main(String[] args) {
		SpringApplication.run(WasteMicroserviceApplication.class, args);
	}





}
