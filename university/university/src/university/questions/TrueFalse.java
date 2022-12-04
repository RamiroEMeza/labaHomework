package university.questions;

public class TrueFalse extends Question {
    private boolean expectedAnswer;
    private boolean actualAnswer;

    public TrueFalse(boolean expectedAnswer) {
        this.expectedAnswer = expectedAnswer;
    }

    @Override
    public boolean isCorrect() {
        return this.expectedAnswer == this.actualAnswer;
    }

    public void setActualAnswer(boolean actualAnswer) {
        this.actualAnswer = actualAnswer;
    }
}
