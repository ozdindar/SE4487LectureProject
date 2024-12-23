package chapter2.compvsinherit.coffeeshop.design1;

public class FilterCoffee {
    private boolean hasSugar;
    private boolean hasMilk;
    private CupSize cupSize;


    public FilterCoffee(boolean hasSugar, boolean hasMilk, CupSize cupSize) {
        this.hasSugar = hasSugar;
        this.hasMilk = hasMilk;
        this.cupSize = cupSize;
    }

    public FilterCoffee(boolean hasSugar, boolean hasMilk) {
        this(hasSugar,hasMilk,CupSize.Large);
    }

    public CupSize getCupSize() {
        return cupSize;
    }

    public FilterCoffee(boolean hasSugar)
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
        String st = "Filter Coffee";

        if (hasMilk)
            st += " with milk";

        if (hasSugar)
            st += " with sugar";

        st += " "+ cupSize.toShortName();

        return st;
    }


    public double getPrice()
    {
        double price = 7.0;

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
        FilterCoffee tc1 = new FilterCoffee(false,true,CupSize.Large);
        FilterCoffee tc2 = new FilterCoffee(true,false,CupSize.Medium);

        System.out.println(tc1);
        System.out.println(tc2);



    }
}
