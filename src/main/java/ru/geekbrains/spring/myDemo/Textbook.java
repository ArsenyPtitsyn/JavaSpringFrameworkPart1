package ru.geekbrains.spring.myDemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class Textbook {

    @Value("History")
    private String discipline;

    @Value("250")
    private int numberOfPages;

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    @Override
    public String toString() {
        return String.format("Textbook discipline - %s, number of pages - %d",
                discipline, numberOfPages);
    }
}
