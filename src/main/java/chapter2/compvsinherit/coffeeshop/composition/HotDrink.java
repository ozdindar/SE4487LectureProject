package chapter2.compvsinherit.coffeeshop.composition;

import java.util.ArrayList;
import java.util.List;

class HotDrink {
    List<Ingredient> ingredients;
    CupSize cupSize;
    Coffee coffee;

    public HotDrink(CupSize cupSize, Coffee coffee) {
        this.cupSize = cupSize;
        this.coffee = coffee;
        ingredients = new ArrayList<>();
    }

    public HotDrink(List<Ingredient> ingredients, CupSize cupSize, Coffee coffee) {
        this.ingredients = ingredients;
        this.cupSize = cupSize;
        this.coffee = coffee;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public CupSize getCupSize() {
        return cupSize;
    }

    public Coffee getCoffee() {
        return coffee;
    }

    void addIngredient(Ingredient ingredient)
    {
        ingredients.add(ingredient);
    }

    public String getDescription()
    {
        String st = coffee.getName();

        for (Ingredient i:ingredients)
        {
            st += " with "+  i.getDescription();
        }

        st += " "+ cupSize.toShortName();

        return st;
    }

    public double getPrice()
    {
        double price = coffee.getBasePrice();

        for (Ingredient i: ingredients)
        {
            price += i.getPrice();
        }

        return price* cupSize.toPriceCoefficient();
    }

    @Override
    public String toString() {
        return getDescription() + "[" + getPrice() +"]";
    }

    public static void main(String[] args) {
        HotDrink drink = new HotDrink(CupSize.Large,new TurkishCoffee());

        drink.addIngredient(new Milk());
        drink.addIngredient(new Mastic());
        drink.addIngredient(new Sugar());

        System.out.println(drink);
    }
}
