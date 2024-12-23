package chapter2.compvsinherit.coffeeshop.composition;

enum CupSize {
    Small, Medium, Large;

    String toShortName()
    {
        switch(this)
        {
            case Large: {
                return "L";
            }
            case Small: {
                return "S";
            }
            case Medium: {
                return "M";
            }
            default: return "L";
        }
    }

    public double toPriceCoefficient() {
        switch(this)
        {
            case Large: {
                return 2.0;
            }
            case Small: {
                return 1.0;
            }
            case Medium: {
                return 1.5;
            }
            default: return 2.0;
        }
    }
}
