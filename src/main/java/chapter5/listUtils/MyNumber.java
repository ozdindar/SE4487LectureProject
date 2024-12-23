package chapter5.listUtils;

import java.security.SecureRandom;

class MyNumber{
    double value;

    public MyNumber(double value) {
        this.value = value;
    }

    public MyNumber() {
        value = 0;
    }

    public static MyNumber random()
    {
        return new MyNumber(new SecureRandom().nextDouble());
    }

    public MyNumber copy()
    {
        return new MyNumber(value);
    }

    @Override
    public String toString() {
        return value+"";
    }
}