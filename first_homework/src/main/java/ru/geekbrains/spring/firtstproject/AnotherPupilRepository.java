package ru.geekbrains.spring.firtstproject;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AnotherPupilRepository implements PupilRepository{
    private List<Pupil> pupils;

    @PostConstruct
    public void init() {
        this.pupils = new ArrayList<>();
        this.pupils.add(new Pupil(1L, "Kuskov Igor Vladimirovich", "7B", "+7(234)6839524", "KusIg@mail.ru"));
        this.pupils.add(new Pupil(2L, "Vetrov Arseny vitalievich", "9D", "7(207)2057295", "VetAr@gmail.com"));
        this.pupils.add(new Pupil(3L, "Larin Dmitry Konstantinovich", "10A", "+7(734)5038573", "LarinDx@yandex.ru"));
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
