package com.fsboot;

import com.fsboot.entities.ResponseModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FsbootApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(FsbootApplication.class, args);
    }
    @Bean
    public ResponseModel responseModel(){
        return new ResponseModel();
    }
}
