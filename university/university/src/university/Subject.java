package university;

import university.members.Student;
import university.members.Teacher;

import java.util.ArrayList;

public class Subject extends AdmnistrativeSection{
    private int hours;
    private ArrayList<Teacher> teachers;
    private ArrayList<Quiz> quizes;
    private ArrayList<Student> students;

    public Subject(String name, int hours, Teacher teacher, Quiz quiz, int cost) {
        this.name = name;
        this.cost = cost;
        this.hours = hours;
        this.teachers = new ArrayList<Teacher>();
        this.addTeacher(teacher);
        this.quizes = new ArrayList<Quiz>();
        this.addQuiz(quiz);
        this.students = new ArrayList<Student>();
    }

    private void addQuiz(Quiz quiz) {
        this.quizes.add(quiz);
    }

    private void addTeacher(Teacher teacher) {
        this.teachers.add(teacher);
    }

    @Override
    public int getQuantityOfStudents() {
        return this.students.size();
    }
}
