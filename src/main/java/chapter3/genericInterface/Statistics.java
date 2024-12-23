package chapter3.genericInterface;

public interface Statistics<T extends Number > {
    T min();
    T max();
    double avg();
}
