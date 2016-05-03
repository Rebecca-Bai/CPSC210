package ca.ubc.cpsc210.quizbuilder.model.quiz;

import ca.ubc.cpsc210.quizbuilder.model.exceptions.*;
import ca.ubc.cpsc210.quizbuilder.model.questionslist.QuestionsList;

/**
 * Created by Mengyu on 2015/10/17.
 */
public class DecrementMarksQuiz extends EachAnswerMustBeRightQuiz {
    public DecrementMarksQuiz(QuestionsList questions) {
        super(questions);
    }
    @Override
    public String submitAnswer(String answer) throws RetryAnswerException, OutOfTriesException{
        boolean correct=super.checkAnswer(answer);
    if (!canTry()&&correct){
        return "";
    }
        if (!canTry()){
            throw new OutOfTriesException("Sorry, no more Try!");
        }

        if(!correct){
            decrementMarks();
    throw new RetryAnswerException("Wrong answer, please retry.");
        }
        return"";
    }



    private void decrementMarks() {
        double mark=curQuestion.getMaxMark()-1;
        curQuestion.setMaxMark(mark);
    }

    private boolean canTry() {
        return !(curQuestion.getMaxMark() ==1);
    }
}
