package com.convertlab;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;

@SpringBootApplication
@MapperScan(value = "com.convertlab.mapper")
public class TesttwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TesttwoApplication.class, args);
	}

}
