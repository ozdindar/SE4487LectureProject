package chapter2.compvsinherit.coffeeshop.design1;

public class Espresso {
    private boolean hasSugar;
    private boolean hasMilk;
    private CupSize cupSize;


    public Espresso(boolean hasSugar, boolean hasMilk, CupSize cupSize) {
        this.hasSugar = hasSugar;
        this.hasMilk = hasMilk;
        this.cupSize = cupSize;
    }

    public Espresso(boolean hasSugar, boolean hasMilk) {
        this(hasSugar,hasMilk,CupSize.Large);
    }

    public CupSize getCupSize() {
        return cupSize;
    }

    public Espresso(boolean hasSugar)
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
        String st = "Espresso";

        if (hasMilk)
            st += " with milk";

        if (hasSugar)
            st += " with sugar";

        st += " "+ cupSize.toShortName();

        return st;
    }


    public double getPrice()
    {
        double price = 15.0;

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
        Espresso tc1 = new Espresso(false,true,CupSize.Large);
        Espresso tc2 = new Espresso(true,false,CupSize.Medium);

        System.out.println(tc1);
        System.out.println(tc2);



    }
}
