package chapter4.planets;

/*
         MERCURY    Mass: 3.302e+23 Radius: 2.439e6
         VENUS      Mass: 4.869e+24 Radius: 6.052e6
         EARTH      Mass: 5.975e+24 Radius: 6.378e6
         MARS       Mass: 6.419e+23 Radius: 3.393e6
         JUPITER    Mass: 1.899e+27 Radius: 7.149e7
         SATURN     Mass: 5.685e+26 Radius: 6.027e7
         URANUS     Mass: 8.683e+25 Radius: 2.556e7
         NEPTUNE    Mass: 1.024e+26 Radius: 2.477e7

-Every Planet has different mass, radius and surface gravity
-Surface Gravity = Gxm/r^2 where G: 6.67300E-11
-Thus surface weight of a mass m = m * Surface Gravity
 */
public enum Planet {
    MERCURY(3.302e+23, 2.439e6),
    VENUS(4.869e+24 ,6.052e6),
    EARTH(5.975e+24 , 6.378e6),
    MARS (6.419e+23 , 3.393e6),
    JUPITER(1.899e+27, 7.149e7),
    SATURN (5.685e+26 ,6.027e7),
    URANUS (8.683e+25 , 2.556e7),
    NEPTUNE( 1.024e+26,2.477e7);

    public static final double G =  6.67300E-11;

    final double mass;
    final double radius;

    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
    }

    public double getMass() {
        return mass;
    }

    public double getRadius() {
        return radius;
    }

    public double surfaceGravity()
    {
        return G*mass/(radius*radius);
    }

    public double surfaceWeight(double m)
    {
        return m*surfaceGravity();
    }
}
