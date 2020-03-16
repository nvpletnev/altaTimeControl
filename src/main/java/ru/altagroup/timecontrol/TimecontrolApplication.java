package ru.altagroup.timecontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.sql.SQLException;

@SpringBootApplication
public class TimecontrolApplication {

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(TimecontrolApplication.class, args);
    }

}
