package com.xluo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration  
@ComponentScan({"com.xluo"})  
@EnableAutoConfiguration
public class StartWeb {

	public static void main(String[] args) {  
        SpringApplication.run(StartWeb.class);  
    } 
	
}
