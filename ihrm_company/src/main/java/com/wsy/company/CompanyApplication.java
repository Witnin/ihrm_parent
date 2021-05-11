package com.wsy.company;

import com.wsy.common.utils.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

/**
 * @author within
 * @version 1.0
 * @date 2021/4/20 15:20
 */
//1、配置springboot包的扫描

@SpringBootApplication(scanBasePackages = "com.wsy")

//2、配置jpa注解的扫描
@EntityScan(value="com.wsy.domain")
public class CompanyApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompanyApplication.class, args);
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker();
    }
}
