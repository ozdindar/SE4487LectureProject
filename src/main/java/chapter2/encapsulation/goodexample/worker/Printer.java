
package chapter2.encapsulation.goodexample.worker;


import chapter2.encapsulation.goodexample.data.Person;

public class Printer {

    void printPerson(Person p)
    {
        // Creating dependency from Printer class to Person
        System.out.println("(" + p.getId() + ") " + p.getFullName()  );
        System.out.println("Printing done...");
    }

    public static void main(String[] args) {
        Person p = new Person(1,"Ali","Can");
        Printer printer = new Printer();
        printer.printPerson(p);
    }
}
