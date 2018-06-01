package com.jingji.insurance;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@ServletComponentScan
@MapperScan("com.jingji.insurance.*.dao")
@SpringBootApplication
@EnableScheduling
public class BasicframeworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicframeworkApplication.class, args);
		System.out.println("=====Basicframework启动成功=====");
	}
}
