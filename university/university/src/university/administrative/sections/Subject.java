package university.administrative.sections;

import cost.ICalculateCost;
import result.Result;
import university.members.Student;
import university.members.Teacher;
import university.quizes.Quiz;

import java.util.ArrayList;
import java.util.HashMap;

public class Subject extends AdmnistrativeSection {
    private int hours;
    private ArrayList<Teacher> teachers;
    private ArrayList<Quiz> quizes;
    private ArrayList<Student> students;

    private ArrayList<Result> results;

    public Subject(String name, int hours, Teacher teacher, Quiz quiz, ICalculateCost cost) {
        super(name, cost);
        this.hours = hours;
        this.teachers = new ArrayList<Teacher>();
        this.addTeacher(teacher);
        this.quizes = new ArrayList<Quiz>();
        this.addQuiz(quiz);
        this.students = new ArrayList<Student>();
    }

    public void addQuiz(Quiz quiz) {
        this.quizes.add(quiz);
    }

    public void removeQuiz(int index) {
        if (this.quizes.size() > 1) {
            this.quizes.remove(index);
        }
    }

    public void addTeacher(Teacher teacher) {
        this.teachers.add(teacher);
    }

    public void removeTeacher(int index) {
        if (this.teachers.size() > 1) {
            this.teachers.remove(index);
        }
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void removeStudent(int index) {
        this.students.remove(index);
    }

    @Override
    public int getQuantityOfStudents() {
        return this.students.size();
    }

    public ArrayList<Quiz> getQuizes() {
        return new ArrayList<Quiz>(this.quizes);
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }


    public int getExtraCharge() {
        int result = 0;
        for (Teacher t :
                teachers) {
            result += t.getRating();
        }
        return result * this.getBaseCost();
    }

    public void Exam() {
        for (Student s : this.students) {//ask each student
            for (Quiz q : this.quizes) {//gives the student each quiz
                HashMap<String, String> answer = new HashMap<>();
                answer = s.answerQuiz(q);//student answer the quiz
                q.receiveAnswers(answer);//the quiz receives the answers
                this.results.add(new Result(s, this, q.isAproved(), q.getResult()));
                q.clear();
            }
        }
    }

    public ArrayList<String> getResults() {
        ArrayList<String> results = new ArrayList<String>();
        for (Result r : this.results) {
            results.add(r.toString());
        }
        return results;
    }
}
