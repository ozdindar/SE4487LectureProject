package chapter2.compvsinherit.coffeeshop.composition;

public class Mastic implements Ingredient{


    @Override
    public String getDescription() {
        return "Mastic";
    }

    @Override
    public double getPrice() {
        return 2.0;
    }
}
