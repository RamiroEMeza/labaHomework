package university.helpers;

import university.administrative.sections.College;
import university.administrative.sections.Speciality;
import university.administrative.sections.Subject;
import university.administrative.sections.University;
import university.members.Teacher;
import university.quizes.Quiz;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public final class UniversityCreator {
    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public University create(String name, int cost, String[] collegesNames, String[] specialitiesNames,
                             ArrayList<Teacher> teachers, int subjectsQuantity) {
        //Create a university
        University university = new University(name, cost);

        //add colleges to the university
        for (int i = 0; i < collegesNames.length; i++) {
            university.addCollege(new College(("College of " + collegesNames[i]),
                    UniversityCreator.getRandomInt(100, 2000), (i + 1)));
        }

        //add specialities to the colleges
        for (int i = 0; i < specialitiesNames.length; i++) {
            university.addSpeciality(UniversityCreator.getRandomInt(1, (university.getColleges().size() - 1)),
                    new Speciality(specialitiesNames[i], (i + 1),
                            UniversityCreator.getRandomInt(100, 2000)));

        }


        //add subjects to the specialities
        for (int i = 1; i < (subjectsQuantity + 1); i++) {
            university.addSubjectToSpeciality(UniversityCreator.getRandomInt(1, university.getSpecialities().size()),
                    new Subject(("Subject-" + i), 40,
                            teachers.get(UniversityCreator.getRandomInt(0, (teachers.size() - 1))),
                            new Quiz(4, 6, 0.7),
                            UniversityCreator.getRandomInt(50, 210)));
        }

        return university;
    }

}
