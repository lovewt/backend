package com.dcmd.service.business;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;


@MapperScan(basePackages= {"com.dcmd.service.business.mapper"})
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
@EnableHystrix
@EnableHystrixDashboard
public class BusinessServiceApplication {
	private final static Logger logger = LoggerFactory.getLogger(com.dcmd.service.business.BusinessServiceApplication.class);

	public static void main(String[] args) {
		
		logger.info("服务启动开始");
		try {
			SpringApplication.run(com.dcmd.service.business.BusinessServiceApplication.class, args);
		} catch (Exception e) {
			
			logger.info("服务启动异常，异常原因：", e);
			return;
		}
		logger.info("服务启动结束");

	}

}
