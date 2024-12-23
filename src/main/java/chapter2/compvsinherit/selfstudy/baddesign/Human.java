package chapter2.compvsinherit.selfstudy.baddesign;


/*
 todo: Model these classes to avoid code repetition and provide flexibility
 */
class Human {
    String name;
    int health;
    int attack;
    int deffence;

    Human(String name, int health, int attack, int deffence) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.deffence = deffence;
    }

    void hitBy(int hit)
    {
        health -= Math.min(hit-deffence,0);
    }

    int hit()
    {
        return attack;
    }

    void animate()
    {
        System.out.println("Human animation..");
        System.out.println("Human animation..");
        System.out.println("Human animation..");
    }

}
