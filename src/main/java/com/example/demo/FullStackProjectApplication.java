package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
public class FullStackProjectApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(FullStackProjectApplication.class);
        app.addListeners(new ApplicationListener<ApplicationEnvironmentPreparedEvent>() {
            @Override
            public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
                ConfigurableEnvironment env = event.getEnvironment();
                env.getSystemProperties().put("spring.data.mongodb.uri", "mongodb://localhost:27017/ProjectDb");
                env.getSystemProperties().put("server.port", "8080");
            }
        });
        app.run(args);
    }
}
