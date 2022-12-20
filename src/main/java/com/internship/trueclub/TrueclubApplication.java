package com.internship.trueclub;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableWebMvc
public class TrueclubApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrueclubApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){return new ModelMapper();}

	@Bean
	public InternalResourceViewResolver helper(){return new InternalResourceViewResolver();}
}
