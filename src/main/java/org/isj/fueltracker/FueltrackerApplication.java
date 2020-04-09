package org.isj.fueltracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class FueltrackerApplication extends SpringBootServletInitializer {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(FueltrackerApplication.class, args);
    }

}
