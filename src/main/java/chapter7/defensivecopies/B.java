package chapter7.defensivecopies;

public class B {
    final A a;

    public B(A a) {
        this.a = new A(a); // taking defensive copy of the incoming reference
    }

    public A getA()
    {
        return new A(a); // taking a defensive copy
    }

    public static void main(String[] args) {
        A a = new A(1,2);
        B b = new B(a);

        a.x = 3;
    }
}
