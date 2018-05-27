package com.kingfisher.orderhub.fulfilementsource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.kingfisher.orderhub")
public class FulfilmentsourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FulfilmentsourceApplication.class, args);
	}
}
