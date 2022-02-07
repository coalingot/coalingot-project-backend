package se.project.coalingot.config;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;

@Component
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    PasswordEncoder encoder = new BCryptPasswordEncoder();
    @SneakyThrows
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
    }
}
