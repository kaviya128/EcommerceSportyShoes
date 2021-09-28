package com.ecommerce.websecurity.config.sample;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class MvcSecurityConfig implements WebMvcConfigurer {
	
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/home").setViewName("userhome");
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/signup").setViewName("signupform");
		registry.addViewController("/signup").setViewName("success_signup");
		registry.addViewController("/userslist").setViewName("users");
		registry.addViewController("/products").setViewName("products");
		registry.addViewController("/newproduct").setViewName("newproduct");
		registry.addViewController("/edit/**").setViewName("editproduct");
		registry.addViewController("/passwordchange").setViewName("passwordchange");
		registry.addViewController("/admin").setViewName("Admin");
		registry.addViewController("/paymentprocess").setViewName("paymentprocess");
		registry.addViewController("/shoppingcart").setViewName("shoppingcart");
		registry.addViewController("/purchasereport").setViewName("purchasereport");
		registry.addViewController("/purchasereportbydate").setViewName("purchasereportbydate");
		registry.addViewController("/view/**").setViewName("viewproduct");
		registry.addViewController("/userproductpage").setViewName("userproductpage");
		
		
		

}
}