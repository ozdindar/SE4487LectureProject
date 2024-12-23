package chapter1.nutritionfacts;

// Nutrition facts class with Telescopic constructors
public class NutritionFactsB {
    private final int servingSize;
    private final int servings;
    private int calories;
    private int fat;
    private int sodium;
    private int carbohydrate;

    private NutritionFactsB(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
    }
    static Builder getBuilder(int servingSize,int servings)
    {
        return new Builder(servingSize,servings);
    }
    static class Builder
    {
        private final int servingSize;
        private final int servings;
        private int calories= 0;
        private int fat= 0;
        private int sodium=0;
        private int carbohydrate=0;


        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }


        Builder calories(int calories)
        {
            this.calories=calories;
            return this;
        }
        Builder fat(int fat)
        {
            this.fat=fat;
            return this;
        }
        Builder sodium(int sodium)
        {
            this.sodium=sodium;
            return this;
        }
        Builder carbohydrate(int carbohydrate)
        {
            this.carbohydrate=carbohydrate;
            return this;
        }

        NutritionFactsB build()
        {
            return new NutritionFactsB(servingSize,servings,calories,fat,sodium,carbohydrate);
        }
    }

    public static void main(String[] args) {
        NutritionFactsB food = new Builder(100,10).fat(20).sodium(20).build();
    }
}
