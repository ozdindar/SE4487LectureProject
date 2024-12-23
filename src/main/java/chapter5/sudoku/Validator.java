package chapter5.sudoku;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class Validator {

    public static <T1,T2>  boolean validateAll(Supplier<T1[]> producer, Function< T1,T2> transformer, Predicate<T2> validator)
    {
        for (T1 t1: producer.get())
        {
            T2 t2 = transformer.apply(t1);
            if (!validator.test(t2))
                return false;
        }
        return true;
    }

    public static <T1,T2>  boolean validateAll(Supplier<T1[]> producer, List<Function< T1,T2> > transformers, Predicate<T2> validator)
    {
        for (Function<T1,T2> transformer:transformers)
        {
            if (!validateAll(producer,transformer,validator))
                return false;
        }
        return true;
    }



}
