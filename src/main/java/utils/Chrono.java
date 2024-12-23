package utils;

import java.time.Duration;
import java.time.Instant;
import java.util.function.Function;

public class Chrono {

    public static <T,A> Duration runFor(Function<T,A> f, T a, int count)
    {
        Instant start = Instant.now();
        for (int i = 0; i < count; i++) {
            f.apply(a);
        }

        Duration duration = Duration.between(Instant.now(),start);

        return duration;
    }

    public static Duration runFor(Runnable f,  int count)
    {
        Instant start = Instant.now();
        for (int i = 0; i < count; i++) {
            f.run();
        }

        Duration duration = Duration.between(Instant.now(),start);

        return duration;
    }


}
