package university;

import java.util.ArrayList;

public class Speciality extends AdmnistrativeSection{
    private ArrayList<Subject> subjects;
    private int id;

    public Speciality(String name, int id, int cost) {
        this.name = name;
        this.id = id;
        this.cost = cost;
        this.subjects = new ArrayList<Subject>();
    }

    public int getId() {
        return id;
    }

    @Override
    public int getQuantityOfStudents() {
        return 0;
    }

    public int calculateCost() {
        int result = 0;
        for (Subject subject : subjects) {
            result += subject.getCost();
        }
        return result + this.cost;
    }

    public void addSubject(Subject subject) {
        if (!this.subjects.contains(subject)){
            this.subjects.add(subject);
        }
    }

    public int getQuantitySubjects(){
        return this.subjects.size();
    }
}
