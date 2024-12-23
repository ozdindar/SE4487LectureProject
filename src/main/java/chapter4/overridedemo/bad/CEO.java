package chapter4.overridedemo.bad;

public class CEO extends Employee{
    public CEO(long id, String name) {
        super(id, name);
    }

    // False override due to typo
    double calculateSalery()
    {
        System.out.println("Salery is calculated..");
        return 500;
    }
}
