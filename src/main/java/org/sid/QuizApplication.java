package org.sid;
import static java.time.temporal.ChronoUnit.MINUTES;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.sid.dao.*;

import org.sid.entities.*;
import org.sid.service.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@ComponentScan({ "org.sid.*" })
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = { "org.sid.dao" })
public class QuizApplication  {





  public static void main(String[] args) {



    SpringApplication.run(QuizApplication.class, args);

    LocalTime l1 = LocalTime.now();
    System.out.println(LocalDateTime.now().atZone(ZoneId.of("GMT+01:00")).plusHours(1));
    LocalTime l2 = LocalTime.parse("00:20:00");

  }

}
