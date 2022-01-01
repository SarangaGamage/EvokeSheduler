package com.example.evokeshedul;

import com.example.evokeshedul.Service.AstrologerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableScheduling
public class EvokeShedulApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(EvokeShedulApplication.class);
    }
    public static void main(String[] args)
    {
        SpringApplication.run(EvokeShedulApplication.class, args);
        AstrologerService t1 = new AstrologerService();
        t1.start();
    }
}
