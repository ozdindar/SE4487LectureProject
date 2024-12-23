package chapter7.defensivecopies;

public class A {
    int x;
    int y;

    public A(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new A(this);
    }

    public A(A a)
    {
        x = a.x;
        y = a.y;
    }
}
