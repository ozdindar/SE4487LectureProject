package chapter1.car;

public class Car {
    double price;
    String brand;
    int model;

    private Car() {

    }
    private Car(double price, String brand, int model) {
        this.price = price;
        this.brand = brand;
        this.model = model;
    }

    static Car fromBrand(String brand)
    {
        Car c= new Car();
        c.brand= brand;
        return c;
    }
}
