package ru.geekbrains.spring.firtstproject;

import java.util.List;

public interface PupilRepository {
    List<Pupil> findAllPupils();
    void addPupil(Pupil pupil);
    void dropoutPupil(Pupil pupil);
    void changeGradeOfPupil(Pupil pupil, String newGrade);
}