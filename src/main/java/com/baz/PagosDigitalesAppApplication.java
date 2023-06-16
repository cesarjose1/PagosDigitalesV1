package com.baz;

import com.baz.services.LoginService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PagosDigitalesAppApplication {

    public static void main(String[] args) {

        SpringApplication.run(PagosDigitalesAppApplication.class, args);
    }
}
