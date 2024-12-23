package chapter2.encapsulation.badexample.worker;

import chapter2.encapsulation.badexample.data.Person;

public class Printer {

    void printPerson(Person p)
    {
        // Creating dependency from Printer class to Person
        System.out.println("(" + p.id + ") " + p.firtName + " "+ p.secondName + " " + p.surName );
        System.out.println("Printing done...");
    }

    public static void main(String[] args) {
        Person p = new Person(1,"Ali","Can","Çelik");
        Printer printer = new Printer();
        printer.printPerson(p);
    }
}
