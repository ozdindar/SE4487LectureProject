package chapter3.covariance;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class DemoCovariance {

    @Test
    void arrayCovariance()
    {
        // This code is wrong but creates run-time
        Object[] arr= new Integer[10]; // Covariance
        arr[0]  = "This is item";
    }


    void listInvariance()
    {
        // ArrayList<Object> list = new ArrayList<Integer>(); // Compile time error
        // list.add("Thisi is one item");
    }
}
