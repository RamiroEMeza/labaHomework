import university.*;
import university.members.Teacher;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static int randomInt(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static void main(String[] args) {
        ArrayList<String> response;
        String[] colleges = {"Fine Arts", "Engineering and Technology", "Health Sciences"};
        String[] specialities = {"Anthropology", "Applied Plant Biology", "Astrophysics",
                                                    "Art History", "Applied Nutrition",
                                                 "Communication Sciences and Disorders"};

        //Create a university
        University ohioUniversity = new University("Ohio U", 200);

        //add colleges to the university
        for (int i = 0; i < colleges.length; i++) {
            ohioUniversity.addCollege(new College(("College of "+colleges[i]),
                                        Main.randomInt(100, 2000), (i+1)));
        }

        //add specialities to the colleges
        for (int i = 0; i < specialities.length; i++) {
            ohioUniversity.addSpeciality(Main.randomInt(1, colleges.length),
                                        new Speciality(specialities[i], (i+1),
                                                Main.randomInt(100, 2000)));
        }

        //add teachers to the university
        for (int i = 1; i < 6; i++) {
            ohioUniversity.addTeacher(new Teacher("Teacher "+i, i));
        }

        //add subjects to the specialities
        for (int i = 1; i < 61; i++) {
            ohioUniversity.addSubjectToSpeciality(Main.randomInt(1, specialities.length),
                                                            new Subject(("Subject "+i), 40,
                                                            ohioUniversity.getTeacher(Main.randomInt(1,ohioUniversity.getTeachersQuantity())),
                                                            new Quiz(4, 6, 0.7),
                                                            Main.randomInt(50, 210)));
        }











        System.out.println("We have these colleges:");
        response = ohioUniversity.getColleges();
        for (String word: response) {
            System.out.println("-" + word);
        }

        System.out.println("\nWe have these specialities:");
        response = ohioUniversity.getSpecialities();
        for (String word: response) {
            System.out.println("-" + word + "\n");
        }

        for (int i = 1; i < (specialities.length+1); i++) {
            String speciality = ohioUniversity.getSpecialityById(i);
            System.out.println("\nHow much does it cost to study "+ speciality +" ("+ i +") ?");
            System.out.println("It will be: " + ohioUniversity.calculateCost(i));

        }


    }
}