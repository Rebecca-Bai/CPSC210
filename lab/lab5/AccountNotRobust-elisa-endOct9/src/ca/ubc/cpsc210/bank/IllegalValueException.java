package ca.ubc.cpsc210.bank;

/**
 * Created by elisa on 9/10/2015.
 */
public class IllegalValueException extends Exception {
    public IllegalValueException(String s) {
        System.out.println(s);
    }
}
