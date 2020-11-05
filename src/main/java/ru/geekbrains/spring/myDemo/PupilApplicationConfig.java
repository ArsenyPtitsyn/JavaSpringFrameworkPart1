package ru.geekbrains.spring.myDemo;


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

    @Bean
    public Textbook textbook() {
        Textbook pupilTextbook = new Textbook("Geography", 200);
        return pupilTextbook;
    }
}
