import university.administrativesections.University;
import university.helpers.UniversityCreator;
import university.members.Teacher;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static int getRandomInt(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static void main(String[] args) {
        int userRequest;
        BufferedReader readRequest = new BufferedReader(new InputStreamReader(System.in));
        do{
            UniversityCreator universityCreator = new UniversityCreator();
            ArrayList<String> response;
            final int quantityOfTeachers = 5;
            ArrayList<Teacher> teachers = new ArrayList<>();
            for (int i = 1; i < (quantityOfTeachers+1); i++) {
                teachers.add(new Teacher("Teacher "+i, i));
            }

            final int quantityOfSubjects = 60;
            String[] colleges = {"Fine Arts", "Engineering and Technology", "Health Sciences"};
            String[] specialities = {"Anthropology", "Applied Plant Biology", "Astrophysics",
                                                        "Art History", "Applied Nutrition",
                                                     "Communication Sciences and Disorders"};

            //Create a university
            University ohioU = universityCreator.create("Ohio U", 200, colleges, specialities,
                    teachers, quantityOfSubjects);

            System.out.println("\nOhio University is equals to Ohio University? " +
                    ohioU.equals(ohioU) + "\n");

            //Print colleges
            System.out.println(ohioU.getName()+" have these colleges:");
            response = ohioU.getColleges();
            for (String word: response) {
                System.out.println("-" + word);
            }

            //Print specialities
            System.out.println("\n"+ohioU.getName()+" have these specialities:");
            response = ohioU.getSpecialities();
            for (String word: response) {
                System.out.println("-" + word + "\n");
            }

            do{
                try {//Ask user if he wants info about any speciality
                    System.out.println("\nIf you want to know the cost of any of ours specialities, please enter its " +
                                            "(id) number. " +
                                            "Any other character to exit");
                    userRequest = Integer.parseInt(readRequest.readLine());
                }catch (Exception e) {
                    userRequest = 0;
                }

                if (userRequest > 0 && userRequest <= ohioU.getLastSubjectId()) {
                    int specialityId = userRequest;
                    String speciality = ohioU.getSpecialityById(specialityId);
                    System.out.println("\nHow much does it cost to study "+ speciality +" ("+ specialityId +") ?");
                    System.out.println("--It will be: " + ohioU.calculateCost(specialityId));

                    try {//Ask user if he wants details about the speciality
                        System.out.println("\nIf you want to know the details of " + speciality + ", please enter [1]." +
                                "\nAny other character to keep asking." + "\n[0] to exit");
                        userRequest = Integer.parseInt(readRequest.readLine());
                    }catch (Exception e) {
                        userRequest = -1;
                    }

                    if (userRequest == 1) {
                        System.out.println("\nIn " + speciality + " you will have:");
                        response = ohioU.getSpecialityInfo(specialityId);
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