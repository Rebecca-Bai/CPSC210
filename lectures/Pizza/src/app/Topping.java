package app;

/**
 * Created by Mengyu on 2015/10/3.
 */
public class Topping extends Ingredient implements Surchargeable{

    private int Surcharge=0;
    public Topping() {
        super();

    }
    @Override
public void setCost(int cost){
        this.cost=cost*Surcharge;
    }
    @Override
    public void setSurcharge(int extraCharge) {
    Surcharge=extraCharge;
    }
}
