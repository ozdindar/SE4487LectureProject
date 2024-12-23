package chapter2.encapsulation.goodexample.data;

public class Person {
    private long id;
    private String firstName;
    private String secondName;
    private String surName;

    public Person(long id, String firtName, String surName) {
        this.id = id;
        this.firstName = firtName;
        this.surName = surName;

    }

    public String getFullName()
    {
        return firstName + " " + secondName + surName;
    }



    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurName() {
        return surName;
    }
}
