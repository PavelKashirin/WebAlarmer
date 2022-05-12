package ru.sbrf.pprb.allo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

//@SpringBootApplication
public class Application {

    public static void main(String[] args) {
//        SpringApplication.run(Application.class, args);
        BigDecimal value = new BigDecimal("123.1902");
        BigDecimal correct = new BigDecimal("100.12");

        System.out.println(value.subtract(correct));
    }
}