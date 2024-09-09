package com.comit.notjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//@EnableScheduling
public class Application   {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
//	@Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        System.out.println("Application Configure");
//        return application.sources(Application.class);
//    }
}
