package chapter2.compvsinherit.selfstudy.baddesign;



class ArmoredElf {
    String name;
    int health;
    int attack;
    int deffence;

    ArmoredElf(String name, int health, int attack, int deffence) {
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
        System.out.println("Elf animation..");
        System.out.println("Elf animation..");
        System.out.println("Elf animation..");
    }


}
