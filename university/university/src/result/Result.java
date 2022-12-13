package result;

import university.administrative.sections.Subject;
import university.members.Student;

public class Result {
    private Student student;
    private Subject subject;
    private boolean approved;
    private int result;

    public Result(Student student, Subject subject, boolean approved, int result) {
        this.student = student;
        this.subject = subject;
        this.approved = approved;
        this.result = result;
    }

    public Student getStudent() {
        return student;
    }

    public Subject getSubject() {
        return subject;
    }

    public boolean isApproved() {
        return approved;
    }

    public int getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "Result{" +
                "student=" + student +
                ", subject=" + subject +
                ", approved=" + approved +
                ", result=" + result +
                '}';
    }
}
