package chapter4.overridedemo.good;

public class CEO extends Employee {
    public CEO(long id, String name) {
        super(id, name);
    }

    @Override
    double calculateSalary()
    {
        System.out.println("Salery is calculated..");
        return 500;
    }
}
