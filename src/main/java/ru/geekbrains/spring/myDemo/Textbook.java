package ru.geekbrains.spring.myDemo;

public class Textbook {
    private String discipline;
    private int numberOfPages;

    public Textbook(String discipline, int numberOfPages) {
        this.discipline = discipline;
        this.numberOfPages = numberOfPages;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    @Override
    public String toString() {
        return String.format("Textbook discipline - %s, number of pages - %d",
                discipline, numberOfPages);
    }
}
