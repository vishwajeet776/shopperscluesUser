package com.shoppersclues.shoppersclues;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.shoppersclues.shoppersclues.Feign")
public class ShopperscluesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopperscluesApplication.class, args);
	}

}
