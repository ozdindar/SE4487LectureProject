package chapter4.overridedemo.bad;

public class Demo {

    public static void main(String[] args) {
        Employee e1 = new Employee(1,"Ali");
        Employee e2 = new Manager(2,"Mehmet");
        Employee e3 = new CEO(3,"Ayşe");

        System.out.println(e1 + " gets salary:"+ e1.calculateSalary());
        System.out.println(e2 + " gets salary:"+ e2.calculateSalary());
        System.out.println(e3 + " gets salary:"+ e3.calculateSalary());

    }
}
