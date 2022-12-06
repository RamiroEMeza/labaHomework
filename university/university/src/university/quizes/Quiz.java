package university.quizes;

import evaluate.IEvaluate;
import university.questions.MultipleChoise;
import university.questions.TrueFalse;

import java.util.ArrayList;
import java.util.Random;

public class Quiz {
    private double percentageToAprove;
    private ArrayList<IEvaluate> questions;

    public Quiz(int quantityTrueFalse, int quantityMultipleChoise, double percentageToAprove) {
        this.questions = new ArrayList<IEvaluate>();
        this.setPercentageToAprove(percentageToAprove);
        this.createTrueFalse(quantityTrueFalse);
        this.createMultipleChoise(quantityMultipleChoise);
    }

    private void createTrueFalse(int quantityTrueFalse) {
        Random r = new Random();
        for (int i = 0; i < quantityTrueFalse; i++) {
            this.questions.add(new TrueFalse(r.nextBoolean()));
        }
    }

    private void createMultipleChoise(int quantityMultipleChoise) {
        Random r = new Random();
        for (int i = 0; i < quantityMultipleChoise; i++) {
            this.questions.add(new MultipleChoise((char) (r.nextInt(26) + 'a')));
        }
    }


    public final void setPercentageToAprove(double percentageToAprove) {
        if (percentageToAprove < 0) {
            percentageToAprove *= (-1);
        }
        while (percentageToAprove > 1) {
            percentageToAprove *= 0.1;
        }

        this.percentageToAprove = percentageToAprove;
    }

    public int getResult() {
        int result = 0;
        for (IEvaluate question :
                this.questions) {
            if (question.isCorrect()) {
                result++;
            }
        }
        return result;
    }

    public final boolean isAproved() {
        if (this.getResult() >= (questions.size() * percentageToAprove)) {
            return true;
        } else {
            return false;
        }
    }

    public final double getPercentageToAprove() {
        return percentageToAprove * 100;
    }
}
