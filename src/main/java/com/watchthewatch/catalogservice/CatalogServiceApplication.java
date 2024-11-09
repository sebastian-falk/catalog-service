package com.watchthewatch.catalogservice;

import com.watchthewatch.catalogservice.infrastructure.model.Watch;
import com.watchthewatch.catalogservice.infrastructure.repository.WatchRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class CatalogServiceApplication {

//    private static final Logger log = LoggerFactory.getLogger(CatalogServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CatalogServiceApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner demo(WatchRepository repository) {
//        return (args) -> {
////            repository.save(new Watch("001", "Name", new BigDecimal(123), "asdf"));
//
//            log.info("Testing to log or something....?!");
//        };
//    }

}
