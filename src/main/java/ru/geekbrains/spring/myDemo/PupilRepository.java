package ru.geekbrains.spring.myDemo;

import java.util.List;

public interface PupilRepository {
    List<Pupil> findAllPupils();
    void addPupil(Pupil pupil);
    void dropoutPupil(Pupil pupil);
    void changeGradeOfPupil(Pupil pupil, String newGrade);
}