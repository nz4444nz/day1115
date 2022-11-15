package com.lening.test_niuzhuang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.lening.test_niuzhuang.mapper"})
public class TestNiuzhuangApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestNiuzhuangApplication.class, args);
    }

}
