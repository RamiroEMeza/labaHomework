package university.members;
import university.Quiz;

public abstract class Student extends Member {

    public Student(String name, int idNumber) {
        super(name, idNumber);
    }

    public abstract void answerQuiz(Quiz quiz);
}
