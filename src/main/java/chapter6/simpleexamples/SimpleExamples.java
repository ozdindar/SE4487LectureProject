package chapter6.simpleexamples;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class SimpleExamples
{

    @Test
    void demo1()
    {
        // todo: Create a stream of integers from 1 to 10 and print
        // int -> IntStream  double Double DoubleStream
        IntStream.range(1,11).forEach((x)->System.out.print(x+ " "));

    }

    @Test
    void demo2()
    {
        // todo: Create a stream of integers from 1 to 10. Omit the first 5 element and print the rest
        IntStream.range(1,11).skip(5).forEach(System.out::println);
    }

    @Test
    void demo3()
    {
        // todo: Calculate the sum of integers from 1 to 10 by using streams
        int sum = IntStream.range(1,11).sum();
        System.out.println(sum);
    }

    @Test
    void demo4()
    {
        // todo: Create a stream of 3 strings like Apple, Orange, Banana , sort them alphabetically and print the first
        String st=
                Stream.of("Apple","Orange","Banana","Potato","Bean")
                .sorted()
                .findFirst().get();
        System.out.println(st);
    }

    @Test
    void demo5()
    {
        // todo: Create a stream from an arrray of strings filter out the elements
        // not starting with 'F' and sort it and print
        String[] arr = { "Apple",  "Orange","Banana", "Fruit", "Flower"};

        Arrays.stream(arr)
                .filter((x)->!x.startsWith("F"))
                .sorted()
                .forEach(System.out::println);

    }

    @Test
    void demo6()
    {
        // todo: Find the average of the squares of the integers given in an array
        int[] arr = { 4,-3,1,6,2,7,-5,0};
        // Arrays.stream(..) will create Stream<Integer>
        Double avg=
            IntStream.of(arr)
                    .map((x)->x*x)
                    .average().orElse(0.0);

        System.out.println(avg);
    }

    @Test
    void demo7()
    {
        // Create a stream from a List. Convert to lowercase, Filter starting with 'b' and print
        List<String> list = Arrays.asList("Apple", "Orange","BANANA", "Cherry","Bean");

        list.stream()
                .map(String::toLowerCase)
                .filter((x)->x.startsWith("b"))
                .forEach(System.out::println);
    }

    @Test
    void demo8()  {
        //todo: Print the lines of a text file that are longer than 10 letters in an alphabetical order

        try (Stream<String> lines = Files.lines( Paths.get("./data/names.txt")))
        {
            lines.filter((x)-> x.length()>12)
                    .sorted()
                    .forEach(System.out::println);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    @Test
    void demo9() throws IOException {
        //todo: Get the lines of a text file that containts "se" as a list
        try (Stream<String> lines = Files.lines( Paths.get("./data/names.txt")))
        {
            List<String> list= lines.filter((x)-> x.contains("se"))
                    .toList();

            list.forEach(System.out::println);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }


    @Test
    void demo10() throws IOException {
        //Find the number of rows in a CSV file (csv.txt) that contains 3 items
        // use peek() method to see those rows. [DEBUGGING]
        try (Stream<String> lines = Files.lines( Paths.get("./data/csv.txt")))
        {
            List<String> list= lines.filter(x->x.split(",").length==3)
                    .peek(System.out::println).toList();

            //list.forEach(System.out::println);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    @Test
    void demo11() throws IOException {
        // Get the first items of the rows of a CSV(csv.txt) file that contains 3 items
        // and whose 2nd item starts with "c"
        try (Stream<String> lines = Files.lines( Paths.get("./data/csv.txt")))
        {
            List<String> list= lines
                    .map(s->s.split(","))
                    .filter(x->x.length==3)
                    .filter(x->x[1].startsWith("c"))
                    .map(x->x[0])
                    .toList();

            list.forEach(System.out::println);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }





@Test
    void demo12()
    {
        // todo: Find the sum of values in a double array using streams
        double[] arr = { 1.3, 5.9, -3,5, 7.0};

        System.out.println(DoubleStream.of(arr).sum());


    }


    @Test
    void demo13()
    {
        // todo: Print the statistical summary of given set of integers
        int[] arr = { 4,-3,1,6,2,7,-5,0};
        System.out.println(IntStream.of(arr).summaryStatistics().toString());


    }

    public static void main(String[] args) throws IOException {

        int arr[] = {1,2,3,4,5};



    }


}
