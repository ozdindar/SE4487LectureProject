package chapter4.planets;

public class Demo {

    public static void main(String[] args) {


        for (Planet p: Planet.values())
        {
            System.out.println(p + " mass:"+ p.getMass() + " radius:" + p.radius + " SG:"+ p.surfaceGravity());
        }

    }
}
