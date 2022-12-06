package university.members;

import university.administrative.sections.Subject;

import java.util.ArrayList;

public class Teacher extends Member {
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
}
