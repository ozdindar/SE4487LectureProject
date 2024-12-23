package org.live.chapter1.nutritionfacts;

// Nutrition facts class with Telescopic constructors
public class NutritionFactsS {
    private final int servingSize;
    private final int servings;
    private int calories;
    private int fat;
    private int sodium;
    private int carbohydrate;

    public NutritionFactsS(int servingSize, int servings) {
        this.servingSize = servingSize;
        this.servings = servings;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public void setCarbohydrate(int carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public static void main(String[] args) {

    }
}
