package chapter3.genericInterface;

public class ArrayStatistics<T extends Number> implements Statistics<T>{

    T[] arr;

    public ArrayStatistics(T[] arr) {
        this.arr = arr;
    }

    @Override
    public T min() {
        T min = null;

        for (T t :arr)
        {
            if (min==null|| min.doubleValue()>t.doubleValue() )
                min = t;
        }

        return min;
    }

    @Override
    public T max() {
        T max = null;

        for (T t :arr)
        {
            if (max==null|| max.doubleValue()<t.doubleValue() )
                max = t;
        }

        return max;
    }

    @Override
    public double avg() {
        if (arr.length==0)
            return 0;

        double avg= 0;
        for (T t:arr)
            avg += t.doubleValue();
        return avg/arr.length;
    }

    @Override
    public String toString() {
        return "Average: "+ avg() + " Max:" + max() + " Min: " + min();
    }

    public static void main(String[] args) {
        Integer[] arr= {1,4,6,2,3,5,8,2,1,2};
        Double[] dArr= { 2.5, 5.0, -3.2, 0.2};

        ArrayStatistics<Integer> statArr = new ArrayStatistics<>(arr);
        ArrayStatistics<Double> statArr2 = new ArrayStatistics<>(dArr);

        System.out.println(statArr);
        System.out.println(statArr2);
    }
}
