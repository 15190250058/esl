package com.xbstar.esl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.xbstar.esl.dao")
public class EslApplication {

    public static void main(String[] args) {
        SpringApplication.run(EslApplication.class, args);
    }

}
