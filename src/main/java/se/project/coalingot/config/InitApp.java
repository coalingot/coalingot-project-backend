package se.project.coalingot.config;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import se.project.coalingot.auctionuser.entity.AuctionUser;
import se.project.coalingot.auctionuser.repository.AuctionUserRepository;
import se.project.coalingot.security.entity.Authority;
import se.project.coalingot.security.entity.AuthorityName;
import se.project.coalingot.security.repository.AuthorityRepository;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;

@Component
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {

    PasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    AuctionUserRepository auctionUserRepository;

    @Autowired
    AuthorityRepository authorityRepository;

    @SneakyThrows
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        addUser();
    }


    AuctionUser newUser;
    public void addUser() {
        Authority roleUser = Authority.builder().name(AuthorityName.ROLE_USER).build();
        authorityRepository.save(roleUser);

        newUser = new AuctionUser();

        newUser.setFirstname("Coal");
        newUser.setLastname("Ingot");
        newUser.setUsername("Coal123");
        newUser.setEmail("Coal@ingot.com");
        newUser.setPassword(encoder.encode("Ingot321"));
        newUser.setEnabled(true);
        newUser.setLastPasswordResetDate(Date.from(LocalDate.of(2021, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()));

        newUser.getAuthorities().add(roleUser);
        auctionUserRepository.save(newUser);
    }

    public void addItem() {
    }

}
