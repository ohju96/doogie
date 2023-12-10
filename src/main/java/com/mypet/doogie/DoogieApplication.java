package com.mypet.doogie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DoogieApplication {

    public static void main(String[] args) {
        SpringApplication.run(DoogieApplication.class, args);
    }

}
