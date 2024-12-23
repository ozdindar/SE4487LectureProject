package chapter2.compvsinherit.coffeeshop.inheritance;

public class TurkishCoffee extends Coffee {

    public TurkishCoffee(boolean hasSugar, boolean hasMilk, CupSize cupSize) {
        super(hasSugar,hasMilk,cupSize);
    }

    @Override
    protected double _getCoffePrice() {
        return 5.0;
    }

    @Override
    protected String _getCoffeeName() {
        return "Turkish Coffee";
    }

    public TurkishCoffee(boolean hasSugar, boolean hasMilk) {
        this(hasSugar,hasMilk,CupSize.Medium);
    }

    public static void main(String[] args) {
        TurkishCoffee tc1 = new TurkishCoffee(false,true,CupSize.Large);
        TurkishCoffee tc2 = new TurkishCoffee(true,false,CupSize.Medium);

        System.out.println(tc1);
        System.out.println(tc2);



    }
}
