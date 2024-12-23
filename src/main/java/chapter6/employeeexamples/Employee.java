package chapter6.employeeexamples;

public class Employee {
    int id;
    String name;
    double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Employee(Employee e) {
        this.id = e.id;
        this.name = e.name;
        this.salary = e.salary;
    }



    @Override
    public String toString() {
        return "["+id+"]" + " "+ name + " "+ salary;
    }

    void increaseSalary(double by)
    {
        salary+= by;
    }
}
