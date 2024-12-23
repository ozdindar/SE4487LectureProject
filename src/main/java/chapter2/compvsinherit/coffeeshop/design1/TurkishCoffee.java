package chapter2.compvsinherit.coffeeshop.design1;

public class TurkishCoffee {
    private boolean hasSugar;
    private boolean hasMilk;
    private CupSize cupSize;


    public TurkishCoffee(boolean hasSugar, boolean hasMilk, CupSize cupSize) {
        this.hasSugar = hasSugar;
        this.hasMilk = hasMilk;
        this.cupSize = cupSize;
    }

    public TurkishCoffee(boolean hasSugar, boolean hasMilk) {
        this(hasSugar,hasMilk,CupSize.Large);
    }

    public CupSize getCupSize() {
        return cupSize;
    }

    public TurkishCoffee(boolean hasSugar)
    {
        this(hasSugar,true,CupSize.Large);
    }

    public boolean hasSugar() {
        return hasSugar;
    }

    public boolean hasMilk() {
        return hasMilk;
    }

    public String getDescription()
    {
        String st = "Turkish Coffee";

        if (hasMilk)
            st += " with milk";

        if (hasSugar)
            st += " with sugar";

        st += " "+ cupSize.toShortName();

        return st;
    }


    public double getPrice()
    {
        double price = 5.0;

        if (hasSugar)
            price += 1.0;
        if (hasMilk)
            price += 2.0;


        return price* cupSize.toPriceCoefficient();
    }

    public String toString() {
        return getDescription() + " [" + getPrice()+ "]";
    }

    public static void main(String[] args) {
        TurkishCoffee tc1 = new TurkishCoffee(false,true,CupSize.Large);
        TurkishCoffee tc2 = new TurkishCoffee(true,false,CupSize.Medium);

        System.out.println(tc1);
        System.out.println(tc2);



    }
}
