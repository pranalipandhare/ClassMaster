package com.example.ClassMaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com")
public class ClassMasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClassMasterApplication.class, args);
	}

}
