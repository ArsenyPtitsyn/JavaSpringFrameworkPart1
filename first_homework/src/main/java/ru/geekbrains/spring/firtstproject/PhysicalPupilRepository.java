package ru.geekbrains.spring.firtstproject;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class PhysicalPupilRepository implements PupilRepository{
    private List<Pupil> pupils;

    @PostConstruct
    public void init() {
        this.pupils = new ArrayList<>();
        this.pupils.add(new Pupil(1L, "Ivanov Ivan Ivanovich", "7A", "+7(999)7353326", "IvanovI@mail.ru"));
        this.pupils.add(new Pupil(2L, "Petrov Petr Petrovich", "9B", "+7(364)4738672", "PetrovP@gmail.com"));
        this.pupils.add(new Pupil(3L, "Sidorov Ivan Petrovich", "11C", "+7(123)1234567", "SidorovIP@yandex.ru"));
    }

    @Override
    public List<Pupil> findAllPupils() {
        return Collections.unmodifiableList(pupils);
    }

    @Override
    public void addPupil(Pupil pupil) {
        pupils.add(pupil);
    }

    @Override
    public void dropoutPupil(Pupil pupil) {
        pupils.remove(pupil);
    }

    @Override
    public void changeGradeOfPupil(Pupil pupil, String newGrade) {
        pupil.setGrade(newGrade);
    }
}
