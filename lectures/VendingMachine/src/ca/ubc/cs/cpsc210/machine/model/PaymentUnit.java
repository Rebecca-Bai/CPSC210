package ca.ubc.cs.cpsc210.machine.model;

import java.util.ArrayList;
import java.util.List;

/*
 * Represents the payment unit in a vending machine.
 */
public class PaymentUnit {
    // number of loonies available in machine for making change
    private int numLoonies;
    // number of quarters available in machine for making change
    private int numQuarters;
    // number of dimes available in machine for making change
    private int numDimes;
    private int numNickels;
    private int numNone;
    // number of nickels available in machine for making change
    private List<Coin> currentTransaction;
    // list of coins inserted into machine during transaction

    // Constructor
    // EFFECTS: there are no banked coins and no coins ha
    // as part of a payment
    public PaymentUnit() {
        numLoonies =0;
        numDimes=0;
        numNickels=0;
        numQuarters=0;
        numNone=0;
        currentTransaction= new ArrayList<Coin>();
    }

    // Clear all the coins banked in the unit
    // MODIFIES: this
    // EFFECTS: clears all the coins banked in the unit
    public void clearCoinsBanked() {
        numLoonies=0;
        numDimes=0;
        numNickels=0;
        numQuarters=0;
        numNone=0;
    }

    // Add a number of coins of a certain type to the banked coins in the unit
    // REQUIRES: number > 0
    // MODIFIES: this
    // EFFECTS: adds number coins of type c to the banked coins in the unit
    public void addCoinsToBanked(Coin c, int number) {
        if (c==Coin.LOONIE){
            numLoonies+=number;
        }
        else if (c.getValue()==25){
            numQuarters+=number;
        }
        else if (c.getValue()==10){
            numDimes+=number;
        }
        else if (c.getValue()==5) {
            numNickels += number;
        }
            else if (c.getValue() == 0) {
            numNone+= number;
            }
        }

    // Gets the number of coins banked in the unit of the given type
    // EFFECTS: returns number of coins banked of the given type
    public int getNumberOfCoinsBankedOfType(Coin c) {
        if (c.getValue()==100){
            return numLoonies;
        }
        else if (c.getValue()==25){
            return numQuarters;
        }
        else if (c.getValue()==10){
            return numDimes;
        }
        else if (c.getValue()==5){
            return numNickels;
        }
        return 0;
    }

    // Gets total value of coins banked
    // EFFECTS: returns the total value of all coins banked in the unit
    public int getValueOfCoinsBanked() {
        return numLoonies*100+numQuarters*25+numDimes*10+numNickels*5;
    }

    // Insert a coin as part of a transaction
    // MODIFIES: this
    // EFFECTS: adds coin c to the unit as a part of a transaction
    public void insertCoin(Coin c) {
        currentTransaction.add(c);
    }

    // Get value of coins inserted for current payment
    // EFFECTS: returns value of coins inserted for current transaction
    public int getValueOfCoinsInserted() {
        int total=0;
        for (int i=0;i<currentTransaction.size();i++){
total+=currentTransaction.get(i).getValue();
        }
        return total;
    }

    // Cancel current transaction
    // MODIFIES: this
    // EFFECTS: coins inserted for current transaction are cleared; list of coins
    // inserted for current transaction is returned in the order in which they were inserted.
    public List<Coin> cancelTransaction() {
        List<Coin> returnlist = new ArrayList<Coin>();
        for (int i=0;i<currentTransaction.size();i++){
            returnlist.add(currentTransaction.get(i));
        }
        currentTransaction= new ArrayList<Coin>();
        return returnlist;
    }

    // Make a purchase of an item with given cost
    // REQUIRES: cost <= total value of coins inserted as part of current transaction
    // MODIFIES: this
    // EFFECTS: adds coins inserted to coins banked in unit and returns list of coins that will be provided as change.
    // Coins of largest possible value are used when determining the change.  Change in full is not guaranteed -
    // will provide only as many coins as are banked in the machine, without going over the amount due.
    public List<Coin> makePurchase(int cost) {
        List<Coin> returnlist=new ArrayList<Coin>();
            for (int i=0;i<currentTransaction.size();i++){
                Coin c= currentTransaction.get(i);
             addCoinsToBanked(c,1);
            }
            int change= getValueOfCoinsInserted()-cost;
            while (change>=100&&numLoonies>0){
                    change -= 100;
                    numLoonies-=1;
                    Coin c1= Coin.LOONIE;
                    returnlist.add(c1);
            }
            while (change>=25&&numQuarters>0){
                change -= 25;
                numQuarters-=1;
                Coin c2= Coin.QUARTER;
                returnlist.add(c2);
            }
            while (change>=10&&numDimes>0){
                change -= 10;
                numDimes-=1;
                Coin c3= Coin.DIME;
                returnlist.add(c3);
            }
            while (change>=5&&numNickels>0){
                change -= 5;
                numNickels-=1;
                Coin c4= Coin.NICKEL;
                returnlist.add(c4);
            }
            currentTransaction= new ArrayList<Coin>();
            return returnlist;
    }
    public int getLoonies(){
        return numLoonies;
    }
    public int getQuarters(){
        return numQuarters;
    }
    public int getDimes(){
        return numDimes;
    }
    public int getNickels(){
        return numNickels;
    }
    public List<Coin> getcurrentTransaction(){
        return currentTransaction;
    }
    public void setcurrentTransaction(List<Coin> list){
        currentTransaction=list;
    }
    }
