package ru.geekbrains.spring.firtstproject;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PupilApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new
                AnnotationConfigApplicationContext(PupilApplicationConfig.class);

        PupilService pupilService = context.getBean("pupilService", PupilService.class);
        pupilService.printAllPupils();

        Textbook book1 = context.getBean("textbook", Textbook.class);
        Textbook book2 = context.getBean("textbook", Textbook.class);
        System.out.println(book1);
        System.out.println(book2);
        book1.setDiscipline("Physics");
        book1.setNumberOfPages(325);
        System.out.println(book1);
        book2.setDiscipline("Biology");
        book2.setNumberOfPages(443);
        System.out.println(book1);
        System.out.println(book2);

        Pan pan = context.getBean("pan", Pan.class);
        System.out.println(pan.toString());

        context.close();
    }
}
