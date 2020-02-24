package com.naveen.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
// if you scan for com.naveen.web all the packages in that will be scanned 
@ComponentScan({"com.naveen.web.controllers", "com.naveen.dao", "com.naveen.interfaces", "com.naveen.web.resource"})
public class AppConfig implements WebApplicationInitializer, WebMvcConfigurer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();  
		context.register(AppConfig.class);
		
		Dynamic servlet = servletContext.addServlet("ds", new DispatcherServlet(context) );
		
		servlet.addMapping("/");
		
		servlet.setLoadOnStartup(1);
	}
	
	
	// this is requied to set the assests .css 
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable(); 
	}
	
	
	// if needed more jsp to be accessed directly then make an entry here 
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/price-form").setViewName("price-form");
	}
	
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver irvr = new InternalResourceViewResolver(); 
		irvr.setPrefix("/WEB-INF/pages/");
		irvr.setSuffix(".jsp");
		return irvr;
		
	}
	
	
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource src  =
					new ReloadableResourceBundleMessageSource(); 
		src.setBasenames("classpath:error-message");
		// optional(you can use it if its I18N) 
		src.setDefaultEncoding("UTF-8");
		return src;
		
	}
	
	
}
