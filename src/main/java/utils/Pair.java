package utils;

public class Pair<F,S> {

    final F f;
    final S s;

    Pair(F f, S s) {
        this.f = f;
        this.s = s;
    }
    public static<F,S> Pair<F,S> of(F f, S s)
    {
        return new Pair<>(f,s);
    }

    public F first()
    {
        return f;
    }

    public S second()
    {
        return s;
    }
}
