package university.questions;

import interfaces.IEvaluate;

public final class TrueFalse implements IEvaluate {
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
