package com.example.evokeshedul;

import com.example.evokeshedul.Service.UserAstrologerService;
import com.example.evokeshedul.Service.UserCustomerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@EnableScheduling
public class EvokeShedulApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(EvokeShedulApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(EvokeShedulApplication.class, args);
        UserAstrologerService userAstrologerService = new UserAstrologerService();
        UserCustomerService userCustomerService = new UserCustomerService();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                userAstrologerService.AstrologerReminder();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                userAstrologerService.AstrologerMainReminder();
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                userCustomerService.UserMainReminder();
            }
        });

        t1.start();
        t2.start();
        t3.start();

    }
}
