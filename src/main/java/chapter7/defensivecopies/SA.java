package chapter7.defensivecopies;

public class SA extends A{

    public SA(int x, int y) {
        super(x, y);
    }

    // Improper implementation of clone function..
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return this;
    }
}
