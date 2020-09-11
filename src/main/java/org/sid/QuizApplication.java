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


  @Autowired
  private PersonnelRepository PersonnelRepository ;

  @Autowired
  private ResultatRepository ResultatRepository;

  @Autowired
  private ReponsesRepository ReponsesRepository;
    @Autowired

    private AppUserRepository appUserRepository;

    @Autowired

    private AppRoleRepository appRoleRepository;

    @Autowired private AccountServiceImpl accountService;

  @Bean
  CommandLineRunner start() {
    return args -> {


        AppRole rolee = new AppRole("USER"); appRoleRepository.save(rolee);

							  AppRole rolee1 = new AppRole("ADMIN"); appRoleRepository.save(rolee1);



							  AppUser us= accountService.saveUser("admin", "1234", "1234");

							  AppUser us1= accountService.saveUser("user", "1234", "1234");
							  Collection<AppRole> rol=new ArrayList<>(); rol.add(rolee); rol.add(rolee1);
							  us.setRoles(rol);
							  us1.getRoles().add(rolee); appUserRepository.save(us);
							 appUserRepository.save(us1);






          AppUser us12 = accountService.saveUser("s.sahraoui", "@scU@3F4", "@scU@3F4");
          appUserRepository.save(us12);

          accountService.addRoleToUser("s.sahraoui", "ADMIN");
          accountService.addRoleToUser("s.sahraoui", "USER");

          appUserRepository.save(us12);

          AppUser us2 = accountService.saveUser("f.natij", "@fnatU@7D4", "@fnatU@7D4");
          appUserRepository.save(us2);

          accountService.addRoleToUser("f.natij", "ADMIN");
          accountService.addRoleToUser("f.natij", "USER");

          appUserRepository.save(us2);

          AppUser us3 = accountService.saveUser("h.bouhafs", "@hbouU@4C1",
          "@hbouU@4C1"); appUserRepository.save(us3);

          accountService.addRoleToUser("h.bouhafs", "ADMIN");
          accountService.addRoleToUser("h.bouhafs", "USER");

          appUserRepository.save(us3);

          AppUser us4 = accountService.saveUser("m.kabouri", "@mkabU@5M0",
          "@mkabU@5M0"); appUserRepository.save(us4);

          accountService.addRoleToUser("m.kabouri", "ADMIN");
          accountService.addRoleToUser("m.kabouri", "USER");

          appUserRepository.save(us4);

          AppUser us5 = accountService.saveUser("m.kabbaj", "@mkbbU@89S0",
          "@mkbbU@89S0"); appUserRepository.save(us5);

          accountService.addRoleToUser("m.kabbaj", "ADMIN");
          accountService.addRoleToUser("m.kabbaj", "USER");

          appUserRepository.save(us5);






    }; }









  public static void main(String[] args) {



    SpringApplication.run(QuizApplication.class, args);

    LocalTime l1 = LocalTime.now();
    System.out.println(LocalDateTime.now().atZone(ZoneId.of("GMT+01:00")).plusHours(1));
    LocalTime l2 = LocalTime.parse("00:20:00");

  }

}
