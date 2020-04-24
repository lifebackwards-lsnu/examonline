package com.lsnu;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.github.pagehelper.autoconfigure.PageHelperAutoConfiguration;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication(exclude = { PageHelperAutoConfiguration.class })
public class ExamOnlineApplication {
	
	@PostConstruct
	void setDefaultTimezone() {
		//TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
		 TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
	}
	public static void main(String[] args) {
		SpringApplication.run(ExamOnlineApplication.class, args);

		System.out.println("ExamOnlineApplication-success");
	}

}
