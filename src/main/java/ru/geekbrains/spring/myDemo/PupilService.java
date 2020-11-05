package ru.geekbrains.spring.myDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PupilService {

    @Autowired
    @Qualifier(value = "physicalPupilRepository")
    private PupilRepository pupilRepository;

//    public PupilService(@Autowired PupilRepository pupilRepository) {
//        this.pupilRepository = pupilRepository;
//    }

//    @Autowired
//    public void setPhysicalPupilRepository(@Qualifier(value = "physicalPupilRepository")
//                                                       PupilRepository pupilRepository) {
//        this.pupilRepository = pupilRepository;
//    }

    public void printAllPupils() {
        List<Pupil> pupils = pupilRepository.findAllPupils();
        for (Pupil p: pupils) {
            System.out.println(p);
        }
    }
}
