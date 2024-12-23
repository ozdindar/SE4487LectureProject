package chapter2.compvsinherit.coffeeshop.composition;

public class Sugar implements Ingredient{


    @Override
    public String getDescription() {
        return "Sugar";
    }

    @Override
    public double getPrice() {
        return 1.0;
    }
}
