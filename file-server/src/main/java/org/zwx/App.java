package org.zwx;


import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "org.zwx")
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
