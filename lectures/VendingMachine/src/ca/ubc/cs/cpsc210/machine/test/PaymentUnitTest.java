package ca.ubc.cs.cpsc210.machine.test;

import ca.ubc.cs.cpsc210.machine.model.Coin;
import ca.ubc.cs.cpsc210.machine.model.PaymentUnit;
import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class PaymentUnitTest {
    private PaymentUnit vm;

    @Before
    //construct a new PaymentUnit object prior to running each test
    public void setUp() throws Exception {
        vm = new PaymentUnit();
    }

    @Test
    public void testclearCoinsBanked() {
        vm.clearCoinsBanked();
        assertEquals(vm.getLoonies(), 0);
        assertEquals(vm.getQuarters(), 0);
        assertEquals(vm.getDimes(), 0);
        assertEquals(vm.getNickels(), 0);
    }

    @Test
    public void testaddCoinsToBanked() {
        vm.addCoinsToBanked(Coin.LOONIE, 2);
        vm.addCoinsToBanked(Coin.LOONIE, 2);
        vm.addCoinsToBanked(Coin.NICKEL, 2);
        vm.addCoinsToBanked(Coin.DIME, 2);
        vm.addCoinsToBanked(Coin.QUARTER, 2);
        assertEquals(vm.getLoonies(), 4);
        assertEquals(vm.getQuarters(), 2);
        assertEquals(vm.getDimes(), 2);
        assertEquals(vm.getNickels(), 2);

    }
    @Test
    public void testaddCoinsToBanked2() {
        vm.addCoinsToBanked(Coin.LOONIE, 1);
        vm.addCoinsToBanked(Coin.NICKEL, 1);
        vm.addCoinsToBanked(Coin.DIME, 1);
        vm.addCoinsToBanked(Coin.QUARTER, 1);
        assertEquals(vm.getLoonies(), 1);
        assertEquals(vm.getQuarters(), 1);
        assertEquals(vm.getDimes(), 1);
        assertEquals(vm.getNickels(), 1);

    }
    @Test
    public void testaddCoinsToBanked3() {
        vm.addCoinsToBanked(Coin.LOONIE, 0);
        vm.addCoinsToBanked(Coin.NICKEL, 0);
        vm.addCoinsToBanked(Coin.DIME, 0);
        vm.addCoinsToBanked(Coin.QUARTER, 0);
        assertEquals(vm.getLoonies(), 0);
        assertEquals(vm.getQuarters(), 0);
        assertEquals(vm.getDimes(), 0);
        assertEquals(vm.getNickels(), 0);

    }
    @Test
    public void testaddCoinsToBanked4() {
        vm.addCoinsToBanked(Coin.LOONIE, 2);
        vm.addCoinsToBanked(Coin.LOONIE, 2);

        assertEquals(vm.getLoonies(), 4);
    }
    @Test
    public void testgetNumberOfCoinsBankedOfType() {
        assertEquals(vm.getNumberOfCoinsBankedOfType(Coin.LOONIE), 0);
        assertEquals(vm.getNumberOfCoinsBankedOfType(Coin.DIME), 0);
        assertEquals(vm.getNumberOfCoinsBankedOfType(Coin.QUARTER), 0);
        assertEquals(vm.getNumberOfCoinsBankedOfType(Coin.NICKEL), 0);
        assertEquals(vm.getNumberOfCoinsBankedOfType(Coin.NONE), 0);

    }

    @Test
    public void testgetValueOfCoinsBanked() {
        assertEquals(vm.getValueOfCoinsBanked(), 0);
    }

    @Test
    public void testinsertCoin() {
        vm.insertCoin(Coin.LOONIE);
        vm.insertCoin(Coin.LOONIE);
        vm.insertCoin(Coin.DIME);
        vm.insertCoin(Coin.NICKEL);
        List<Coin> list = new ArrayList<Coin>();
        list.add(Coin.LOONIE);
        list.add(Coin.LOONIE);
        list.add(Coin.DIME);
        list.add(Coin.NICKEL);
        assertEquals(vm.getcurrentTransaction(), list);
    }

    @Test
    public void testgetValueOfCoinsInserted() {
        vm.insertCoin(Coin.LOONIE);
        vm.insertCoin(Coin.LOONIE);
        vm.insertCoin(Coin.DIME);
        vm.insertCoin(Coin.NICKEL);
        assertEquals(vm.getValueOfCoinsInserted(), 215);
    }

    @Test
    public void testcancelTransaction() {
        List<Coin> list = new ArrayList<Coin>();
        List<Coin> list2 = new ArrayList<Coin>();
        list.add(Coin.LOONIE);
        list.add(Coin.DIME);
        list.add(Coin.DIME);
        vm.setcurrentTransaction(list);
        assertEquals(vm.cancelTransaction(), list);
        assertEquals(vm.cancelTransaction(), vm.getcurrentTransaction());
        vm.cancelTransaction();
        assertEquals(vm.getcurrentTransaction(), list2);
    }

    @Test
    public void testmakePurchase() {
        vm.insertCoin(Coin.LOONIE);
        vm.insertCoin(Coin.LOONIE);
        vm.insertCoin(Coin.DIME);
        vm.insertCoin(Coin.NICKEL);
        vm.addCoinsToBanked(Coin.LOONIE, 4);
        vm.addCoinsToBanked(Coin.DIME, 4);
        vm.addCoinsToBanked(Coin.NICKEL, 4);
        vm.addCoinsToBanked(Coin.QUARTER, 4);
        List<Coin> list = new ArrayList<Coin>();
        list.add(Coin.LOONIE);
        list.add(Coin.QUARTER);
        assertEquals(vm.makePurchase(90), list);
        vm.makePurchase(90);
        List<Coin> list2 = new ArrayList<Coin>();
        assertEquals(vm.getcurrentTransaction(), list2);
    }

    @Test
    public void testmakePurchase2() {
        vm.insertCoin(Coin.LOONIE);
        vm.insertCoin(Coin.DIME);
        vm.insertCoin(Coin.NICKEL);
        vm.addCoinsToBanked(Coin.LOONIE, 4);
        vm.addCoinsToBanked(Coin.DIME, 4);
        vm.addCoinsToBanked(Coin.NICKEL, 4);
        vm.addCoinsToBanked(Coin.QUARTER, 4);
        List<Coin> list = new ArrayList<Coin>();
        list.add(Coin.DIME);
        list.add(Coin.NICKEL);
        assertEquals(vm.makePurchase(100), list);
        vm.makePurchase(100);
        List<Coin> list2 = new ArrayList<Coin>();
        assertEquals(vm.getcurrentTransaction(), list2);
    }


    @Test
    public void testmakePurchase4() {
        vm.insertCoin(Coin.LOONIE);
        vm.insertCoin(Coin.DIME);
        vm.insertCoin(Coin.NICKEL);
        vm.addCoinsToBanked(Coin.LOONIE, 4);
        vm.addCoinsToBanked(Coin.DIME, 4);
        vm.addCoinsToBanked(Coin.NICKEL, 4);
        vm.addCoinsToBanked(Coin.QUARTER, 4);
        List<Coin> list = new ArrayList<Coin>();
        assertEquals(vm.makePurchase(115), list);
        vm.makePurchase(115);
        List<Coin> list2 = new ArrayList<Coin>();
        assertEquals(vm.getcurrentTransaction(), list2);
    }
    @Test
    public void testmakePurchase5(){
        vm.insertCoin(Coin.LOONIE);
        vm.insertCoin(Coin.DIME);
        vm.insertCoin(Coin.NICKEL);
        vm.addCoinsToBanked(Coin.NICKEL,4);
        List<Coin> list=new ArrayList<Coin>();
        list.add(Coin.DIME);
        list.add(Coin.NICKEL);
        assertEquals(vm.makePurchase(100), list);
        vm.makePurchase(100);
        List<Coin> list2=new ArrayList<Coin>();
        assertEquals(vm.getcurrentTransaction(), list2);
    }
    @Test
    public void testmakePurchase6(){
        vm.insertCoin(Coin.LOONIE);
        vm.insertCoin(Coin.LOONIE);
        vm.addCoinsToBanked(Coin.NICKEL, 2);
        vm.addCoinsToBanked(Coin.LOONIE, 2);
        List<Coin> list=new ArrayList<Coin>();
        list.add(Coin.NICKEL);
        list.add(Coin.NICKEL);
        assertEquals(list,vm.makePurchase(115));
        vm.makePurchase(115);
        List<Coin> list2=new ArrayList<Coin>();
        assertEquals(vm.getcurrentTransaction(), list2);
    }
}