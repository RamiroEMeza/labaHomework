package university.members;

import exam.IExamStudents;
import university.administrative.sections.Subject;

import java.util.ArrayList;

public class Teacher extends Member implements IExamStudents {
    private int rating;
    private ArrayList<Subject> currentlyAsignedSubjects;

    public Teacher(String name, int idNumber, int rating) {
        super(name, idNumber);
        this.setRating(rating);
        this.currentlyAsignedSubjects = new ArrayList<Subject>();
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        if (rating < 0) {
            rating *= (-1);
        }
        this.rating = rating;
    }

    @Override
    public String getInfo() {
        return this.getName() + " is a " + this.getClass() + " Teaches in " +
                this.currentlyAsignedSubjects.size() + " classes";
    }

    @Override
    public void ExamStudents() {
        for (Subject subject : this.currentlyAsignedSubjects) {
            subject.Exam();
        }
    }
}
