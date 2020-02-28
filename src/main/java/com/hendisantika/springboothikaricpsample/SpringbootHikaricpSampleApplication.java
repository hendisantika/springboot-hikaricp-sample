package com.hendisantika.springboothikaricpsample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;

@Slf4j
@SpringBootApplication
public class SpringbootHikaricpSampleApplication implements CommandLineRunner {
    @Autowired
    DataSource dataSource;

    @Override
    public void run(String... args) throws Exception {
        log.info("DataSource = " + dataSource);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootHikaricpSampleApplication.class, args);
    }

}
