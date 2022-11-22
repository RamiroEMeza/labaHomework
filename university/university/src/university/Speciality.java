package university;

import java.util.ArrayList;
import java.util.Objects;

public class Speciality extends AdmnistrativeSection{
    private ArrayList<Subject> subjects;
    private int id;

    private boolean requiredEntranceQuiz;

    public Speciality(String name, int id, int cost) {
        super(name, cost);
        this.id = id;
        this.requiredEntranceQuiz = true;
        this.subjects = new ArrayList<Subject>();
    }

    public int calculateCost() {
        int result = 0;
        for (Subject subject : subjects) {
            result += subject.getCost();
        }
        return result + this.getCost();
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Speciality that = (Speciality) o;
        if (this.hashCode() != that.hashCode()) return false;
        return Objects.equals(getName(), that.getName()) && Objects.equals(getCost(), that.getCost());
    }

    public boolean haveSubjectByName(String subject){
        for (Subject subj: this.subjects) {
            if (subj.getName().equals(subject)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCost());
    }

    @Override
    public String toString() {
        return "Speciality{" +
                "Name=" + getName() +
                "id=" + getId() +
                ", requiredEntranceQuiz=" + isRequiredEntranceQuiz() +
                '}';
    }

    public void addSubject(Subject subject) {
        if (!this.subjects.contains(subject)){
            this.subjects.add(subject);
        }
    }

    public int getId() {
        return id;
    }

    @Override
    public int getQuantityOfStudents() {
        int result = 0;
        for (Subject subject : subjects) {
            result += subject.getQuantityOfStudents();
        }
        return result;
    }

    public int getQuantitySubjects(){
        return this.subjects.size();
    }

    public void setRequiredEntranceQuiz(boolean requiredEntranceQuiz) {
        this.requiredEntranceQuiz = requiredEntranceQuiz;
    }

    public ArrayList<String> getDetail() {
        ArrayList<String> response = new ArrayList<>();
        for (Subject subject : subjects) {
            response.add("~ "+subject.getName()+ " Cost: " + subject.getCost() + " QuizQ: " + subject.getQuizes().size());
        }
        response.add("--Is enter exam required? " + this.isRequiredEntranceQuiz());
        return response;
    }

    public boolean isRequiredEntranceQuiz() {
        return requiredEntranceQuiz;
    }

    public void deleteSubjectByName(String subject) {
        for (int i = 0; i < subjects.size(); i++) {
            if (subjects.get(i).getName().equals(subject)) {
                this.subjects.remove(i);
            }
        }
    }
}
