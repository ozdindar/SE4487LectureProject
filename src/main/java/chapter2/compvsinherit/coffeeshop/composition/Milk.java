package chapter2.compvsinherit.coffeeshop.composition;

public class Milk implements Ingredient{


    @Override
    public String getDescription() {
        return "Milk";
    }

    @Override
    public double getPrice() {
        return 2.0;
    }
}
