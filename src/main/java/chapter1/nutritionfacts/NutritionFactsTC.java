package chapter1.nutritionfacts;

// Nutrition facts class with Telescopic constructors
public class NutritionFactsTC {
    private final int servingSize;
    private final int servings;
    private int calories;
    private int fat;
    private int sodium;
    private int carbohydrate;

    public NutritionFactsTC(int servingSize, int servings) {
        this.servingSize = servingSize;
        this.servings = servings;
    }

    public NutritionFactsTC(int servingSize, int servings, int calories) {
        this(servingSize,servings);
        this.calories = calories;
    }

    public NutritionFactsTC(int servingSize, int servings, int calories, int fat) {
        this(servingSize,servings,calories);
        this.fat = fat;
    }

    public NutritionFactsTC(int servingSize, int servings, int calories, int fat, int sodium) {
        this(servingSize,servings,calories,fat);
        this.sodium = sodium;
    }

    public static void main(String[] args) {

    }
}
