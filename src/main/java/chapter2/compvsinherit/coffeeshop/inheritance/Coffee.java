package chapter2.compvsinherit.coffeeshop.inheritance;

abstract class Coffee {
    private boolean hasSugar;
    private boolean hasMilk;
    private CupSize cupSize;

    public Coffee(boolean hasSugar, boolean hasMilk, CupSize cupSize) {
        this.hasSugar = hasSugar;
        this.hasMilk = hasMilk;
        this.cupSize = cupSize;
    }

    public CupSize getCupSize() {
        return cupSize;
    }

    public boolean hasSugar() {
        return hasSugar;
    }

    public boolean hasMilk() {
        return hasMilk;
    }

    public String getDescription()
    {
        String st = _getCoffeeName();

        if (hasMilk)
            st += " with milk";

        if (hasSugar)
            st += " with sugar";

        st += " "+ cupSize.toShortName();

        return st;
    }

    public double getPrice()
    {
        double price = _getCoffePrice();

        if (hasSugar)
            price += 1.0;
        if (hasMilk)
            price += 2.0;


        return price* cupSize.toPriceCoefficient();
    }

    public String toString() {
        return getDescription() + " [" + getPrice()+ "]";
    }

    protected abstract double _getCoffePrice();

    protected abstract String  _getCoffeeName();

}
