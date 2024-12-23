package chapter4.overridedemo.bad;

public class Employee {
    long id;
    String name;

    public Employee(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return id + " " + name;
    }

    void func(Employee e)
    {

    }

    double calculateSalary()
    {
        System.out.println("Salary is being calculated..");
        return 100;
    }
}
