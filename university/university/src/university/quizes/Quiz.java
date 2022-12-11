package university.quizes;

import evaluate.IEvaluate;
import university.questions.MultipleChoise;
import university.questions.TrueFalse;

import java.util.HashMap;
import java.util.Random;

public class Quiz {
    public static final Random RANDOM = new Random();
    private double percentageToAprove;
    HashMap<String, IEvaluate> questionsMap;

    public Quiz(int quantityTrueFalse, int quantityMultipleChoise, double percentageToAprove) {
        this.questionsMap = new HashMap<String, IEvaluate>();
        this.setPercentageToAprove(percentageToAprove);
        this.createTrueFalse(quantityTrueFalse);
        this.createMultipleChoise(quantityMultipleChoise);
    }

    private void createTrueFalse(int quantityTrueFalse) {
        for (int i = 0; i < quantityTrueFalse; i++) {
            this.questionsMap.put("Question" + (questionsMap.size() + 1), new TrueFalse(Quiz.RANDOM.nextBoolean()));
        }
    }

    private void createMultipleChoise(int quantityMultipleChoise) {
        for (int i = 0; i < quantityMultipleChoise; i++) {
            this.questionsMap.put("Question" + (questionsMap.size() + 1),
                    new MultipleChoise((char) (Quiz.RANDOM.nextInt(26) + 'a')));
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
                this.questionsMap.values()) {
            if (question.isCorrect()) {
                result++;
            }
        }
        return result;
    }

    public final boolean isAproved() {
        return this.getResult() >= (questionsMap.size() * percentageToAprove);
    }

    public final double getPercentageToAprove() {
        return percentageToAprove * 100;
    }

    public void receiveAnswer(HashMap<String, Boolean> answer) {
    }

    public void receiveAnswer() {
    }


}
