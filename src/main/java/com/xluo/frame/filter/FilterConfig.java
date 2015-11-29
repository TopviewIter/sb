package com.xluo.frame.filter;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;

import com.xluo.frame.util.Constant;

@Configuration
@ServletComponentScan(Constant.FILTER_PATH)
public class FilterConfig {

//	@Bean
//	public FilterRegistrationBean additionalFilterRegistration() {
//
//		FilterRegistrationBean registration = new FilterRegistrationBean();
//		registration.setFilter(someFilter());
//		registration.addUrlPatterns("/*");
//		registration.addInitParameter("paramName", "paramValue");
//		registration.setName("secFilter");
//		return registration;
//		
//	}
//	
//	@Bean(name = "secFilter")
//	public Filter someFilter(){
//		return new SecFilter();
//	}

}
