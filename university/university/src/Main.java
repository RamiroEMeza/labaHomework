import university.*;
import university.members.Teacher;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static int randomInt(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static void main(String[] args) {
        int userRequest;
        BufferedReader readRequest = new BufferedReader(new InputStreamReader(System.in));
        do{
            ArrayList<String> response;
            final int quantityOfTeachers = 5;
            final int quantityOfSubjects = 60;
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
            for (int i = 1; i < (quantityOfTeachers+1); i++) {
                ohioUniversity.addTeacher(new Teacher("Teacher "+i, i));
            }

            //add subjects to the specialities
            for (int i = 1; i < (quantityOfSubjects+1); i++) {
                ohioUniversity.addSubjectToSpeciality(Main.randomInt(1, specialities.length),
                                                                new Subject(("Subject-"+i), 40,
                                                                ohioUniversity.getTeacher(Main.randomInt(1,ohioUniversity.getTeachersQuantity())),
                                                                new Quiz(4, 6, 0.7),
                                                                Main.randomInt(50, 210)));
            }


            //Print colleges
            System.out.println("We have these colleges:");
            response = ohioUniversity.getColleges();
            for (String word: response) {
                System.out.println("-" + word);
            }

            //Print specialities
            System.out.println("\nWe have these specialities:");
            response = ohioUniversity.getSpecialities();
            for (String word: response) {
                System.out.println("-" + word + "\n");
            }


            do{
                try {//Ask user if he wants info about any speciality
                    System.out.println("\nIf you want to know the cost of any of ours specialities, please enter its " +
                                            "(id) number. " +
                                            "Any other character to exit");
                    userRequest = Integer.valueOf(readRequest.readLine());
                }catch (Exception e) {
                    userRequest = 0;
                }

                if (userRequest > 0 && userRequest <= ohioUniversity.getLastSubjectId()) {
                    int specialityId = userRequest;
                    String speciality = ohioUniversity.getSpecialityById(specialityId);
                    System.out.println("\nHow much does it cost to study "+ speciality +" ("+ specialityId +") ?");
                    System.out.println("--It will be: " + ohioUniversity.calculateCost(specialityId));

                    try {//Ask user if he wants details about the speciality
                        System.out.println("\nIf you want to know the details of " + speciality + ", please enter [1]." +
                                "\nAny other character to keep asking." + "\n[0] to exit");
                        userRequest = Integer.valueOf(readRequest.readLine());
                    }catch (Exception e) {
                        userRequest = -1;
                    }

                    if (userRequest == 1) {
                        System.out.println("\nIn " + speciality + " you will have:");
                        response = ohioUniversity.getSpecialitieInfo(specialityId);
                        for (String line: response) {
                            System.out.println(line);
                        }
                    }
                }

            }while(userRequest != 0);

        }while(userRequest != 0);
        System.out.println("\nHave a nice day");
        System.out.println("\nEND MAIN");
    }
}