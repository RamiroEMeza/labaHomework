import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import university.administrative.sections.University;
import university.helpers.UniversityCreator;
import university.members.Teacher;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;


public class Main {
    private static final Logger LOGGER = LogManager.getLogger();

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static void isEqualsUniversities(University u1, University u2) {
        System.out.println("\nOhio University is equals to Ohio University? " +
                u1.equals(u2) + "\n");
    }

    public static void createTeachers(ArrayList<Teacher> teachers, int quantity) {
        for (int i = 1; i < (quantity + 1); i++) {
            teachers.add(new Teacher("Teacher " + i, i, i));
        }
    }


    public static void main(String[] args) {
        final String UNIVERSITY_NAME = "Ohio U";
        final int QUANTITY_OF_TEACHERS = 5;
        final int QUANTITY_OF_SUBJECTS = 60;
        final int MIN_U_COST = 50;
        final int MAX_U_COST = 1200;
        final String[] ARR_COLLEGES = {"Fine Arts", "Engineering and Technology", "Health Sciences"};
        final String[] ARR_SPECIALITIES = {"Anthropology", "Applied Plant Biology", "Astrophysics",
                "Art History", "Applied Nutrition",
                "Communication Sciences and Disorders"};
        ArrayList<Teacher> teachers = new ArrayList<>();
        Main.createTeachers(teachers, QUANTITY_OF_TEACHERS);
        UniversityCreator universityCreator = new UniversityCreator();
        ArrayList<String> response;

        int userRequest;
        BufferedReader readRequest = new BufferedReader(new InputStreamReader(System.in));

        do {
            LOGGER.info("Start of the program");
            //Create a university
            University ohioU = universityCreator.create(UNIVERSITY_NAME, Main.getRandomInt(MIN_U_COST, MAX_U_COST),
                    ARR_COLLEGES, ARR_SPECIALITIES, teachers, QUANTITY_OF_SUBJECTS);

            Main.isEqualsUniversities(ohioU, ohioU);

            //Print colleges
            System.out.println(ohioU.getName() + " have these colleges:");
            response = ohioU.getColleges();
            System.out.println(response.toString());


            //Print specialities
            System.out.println("\n" + ohioU.getName() + " have these specialities:");
            response = ohioU.getSpecialities();
            for (String word : response) {
                System.out.println("-" + word + "\n");
            }

            do {
                try {//Ask user if he wants info about any speciality
                    System.out.println("\nIf you want to know the cost of any of ours specialities, " +
                            "please enter its " + "(id) number. " + "Any other character to exit");
                    userRequest = Integer.parseInt(readRequest.readLine());
                } catch (Exception e) {
                    LOGGER.warn("User didn't ask about any speciality and enter an non integer data, " +
                            "setting userRequest=0");
                    userRequest = 0;
                }

                if (userRequest > 0 && userRequest <= ohioU.getLastSubjectId()) {
                    LOGGER.info("User ask about an speciality");
                    int specialityId = userRequest;
                    String speciality = ohioU.getSpecialityById(specialityId);
                    System.out.println("\nHow much does it cost to study " + speciality + " (" + specialityId + ") ?");
                    System.out.println("--It will be: " + ohioU.calculateCost(specialityId));

                    try {//Ask user if he wants details about the speciality
                        System.out.println("\nIf you want to know the details of " + speciality + ", please enter [1]." +
                                "\nAny other character to keep asking." + "\n[0] to exit");
                        userRequest = Integer.parseInt(readRequest.readLine());
                    } catch (Exception e) {
                        LOGGER.warn("User didn't ask about any details of an speciality and enter an non integer data, " +
                                "setting userRequest=-1");
                        userRequest = -1;
                    }

                    if (userRequest == 1) {
                        LOGGER.info("User ask about the details of an speciality");
                        System.out.println("\nIn " + speciality + " you will have:");
                        response = ohioU.getSpecialityInfo(specialityId);
                        for (String line : response) {
                            System.out.println(line);
                        }
                    }
                }

            } while (userRequest != 0);

        } while (userRequest != 0);
        LOGGER.info("END MAIN");
    }
}