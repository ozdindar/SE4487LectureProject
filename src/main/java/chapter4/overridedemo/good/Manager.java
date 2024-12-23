package chapter4.overridedemo.good;

public class Manager extends Employee {
    public Manager(long id, String name) {
        super(id, name);
    }

    @Override
    double calculateSalary()
    {
        System.out.println("Salary is calculated..");
        return 300;
    }

    
    void func(String st)
    {

    }
}
