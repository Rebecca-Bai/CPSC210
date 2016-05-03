package app;

/**
 * Created by Mengyu on 2015/10/3.
 */
public class SpecialCheese extends Cheese{
    public SpecialCheese(String name) {
        this.name = name + " cheese";
    }
    public int computeCost(){
        return super.computeCost()+cost;
    }

}
