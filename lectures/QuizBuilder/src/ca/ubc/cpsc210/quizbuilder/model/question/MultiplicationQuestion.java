package ca.ubc.cpsc210.quizbuilder.model.question;

/**
 * Created by Mengyu on 2015/10/17.
 */
public class MultiplicationQuestion extends Question {

        private int factor1;
        private int factor2;

    public MultiplicationQuestion(double maxMark, int factor1, int factor2){
        super(maxMark, "what is "+Integer.toString(factor1)+"*"+Integer.toString(factor2));
        this.factor1=factor1;
        this.factor2=factor2;
    }
    public int maltiplication(int factor1, int factor2){
        return factor1*factor2;
    }

    @Override
    public boolean isCorrect(String answer) {
        return formateCorrect(answer) && (Integer.parseInt(answer) == maltiplication(factor1, factor2));
    }


    public boolean formateCorrect(String answer) {
        try{
            Integer.parseInt(answer);
            return true;}
        catch (NumberFormatException e){
            return false;
        }
    }
}
