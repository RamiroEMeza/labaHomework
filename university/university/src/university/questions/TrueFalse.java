package university.questions;

import evaluate.IEvaluate;

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

    @Override
    public String acceptableAnswers() {
        return "boolean";
    }

    public void setActualAnswer(boolean actualAnswer) {
        this.actualAnswer = actualAnswer;
    }
}
