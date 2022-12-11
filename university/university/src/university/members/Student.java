package university.members;

import university.administrative.sections.Subject;
import university.quizes.Quiz;

import java.util.ArrayList;
import java.util.HashMap;

public class Student extends Member {
    private ArrayList<Subject> aprobbedSubjects;
    private ArrayList<Subject> historicEnrolledSubjects;

    public Student(String name, int idNumber) {
        super(name, idNumber);
        this.aprobbedSubjects = new ArrayList<Subject>();
        this.historicEnrolledSubjects = new ArrayList<Subject>();
    }

    public void answerQuiz(Quiz quiz) {
        HashMap<String, String> answers = new HashMap<>();


    }
}
