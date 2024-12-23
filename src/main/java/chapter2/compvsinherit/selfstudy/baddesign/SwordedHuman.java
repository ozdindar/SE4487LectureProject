package chapter2.compvsinherit.selfstudy.baddesign;

class SwordedHuman {
    String name;
    int health;
    int attack;
    int deffence;

    SwordedHuman(String name, int health, int attack, int deffence) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.deffence = deffence;
    }

    void hitBy(int hit)
    {

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
