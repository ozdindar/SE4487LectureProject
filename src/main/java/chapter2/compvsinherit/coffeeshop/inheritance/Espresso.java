package chapter2.compvsinherit.coffeeshop.inheritance;

class Espresso extends Coffee{
    public Espresso(boolean hasSugar, boolean hasMilk, CupSize cupSize) {
        super(hasSugar, hasMilk, cupSize);
    }

    @Override
    protected double _getCoffePrice() {
        return 0;
    }

    @Override
    protected String _getCoffeeName() {
        return null;
    }
}
