package chapter2.compvsinherit.coffeeshop.composition;

public class TurkishCoffee implements Coffee{
    @Override
    public String getName() {
        return "Turkish Coffee";
    }

    @Override
    public double getBasePrice() {
        return 5.0;
    }
}
