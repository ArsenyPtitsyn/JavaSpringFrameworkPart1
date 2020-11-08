package ru.geekbrains.spring.firtstproject;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.awt.*;

@Configuration
@ComponentScan(basePackages = {"ru.geekbrains.spring"})
public class PupilApplicationConfig {

    @Bean
    public Pan pan() {
        Pan pupilPan = new Pan(Color.BLACK);
        pupilPan.setColor(Color.BLUE);
        return pupilPan;
    }
}
