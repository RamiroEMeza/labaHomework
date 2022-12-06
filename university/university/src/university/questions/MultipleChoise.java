package university.questions;

import evaluate.IEvaluate;

public class MultipleChoise implements IEvaluate {
    private char expectedAnswer;
    private char actualAnswer;

    public MultipleChoise(char expectedAnswer) {
        this.expectedAnswer = expectedAnswer;
    }

    @Override
    public boolean isCorrect() {
        return this.expectedAnswer == this.actualAnswer;
    }


    public void setActualAnswer(char actualAnswer) {
        this.actualAnswer = actualAnswer;
    }
}
