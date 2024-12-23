package chapter6.employeeexamples;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {

    //  An arbitrary array of employees
    Employee employeeArray[] = new Employee[]{
            new Employee(1,"John Kruvask",20000),
            new Employee(7,"Mike Thumblewood",45000),
            new Employee( 12, "Lisa Curmet",35000),
            new Employee(21,"Sarah Parker", 50000),
            new Employee(18,"Jessice Robertson",18000),
            new Employee(23,"Nathan Hughes",32000),
            new Employee(24,"Venessa Boezes",48000),
            new Employee(28,"Ashley Kunde",21000),
            new Employee(31,"Pete Granger",51000)
    };

    // todo: Write a function that returns the employee with the given id. ,
    //       The function returns null if no employee found
    Employee findById(int id)
    {
        return Arrays.stream(employeeArray)
                .filter(e->e.id == id)
                .peek(x-> System.out.println("Employee with "+ id + " has been found."))
                .findFirst().get();

    }


    // todo: 1. Create a stream from the employee array
    @Test
    void test1()
    {
        // Using Stream.of
        Stream.of(employeeArray).forEach(System.out::println);


        // Arrays.stream
        Arrays.stream(employeeArray).forEach(System.out::println);

    }

    // todo: 2. Create a collection from the stream
    @Test
    void test2()
    {
        Set<Employee> set = Arrays.stream(employeeArray)
                .collect(Collectors.toSet());
    }

    // todo: 3. Print each element on a stream
    @Test
    void test3()
    {
        Arrays.stream(employeeArray).forEach(System.out::println);
    }

    // todo: 4. Collect all of the employees whose salary is greater than or equal 30000
    @Test
    void test4()
    {
        List<Employee> list = Arrays.stream(employeeArray)
                .filter(x->x.salary>30000).toList();

        list.forEach(System.out::println);
    }

    // todo: 5. Collect all of the employees given as an array of ID
    @Test
    void test5()
    {
        Integer[] idArr= { 7, 23, 31};

        List<Employee> list =
                Arrays.stream(idArr)
                        .map(this::findById)
                        .toList();

        list.forEach(System.out::println);

    }


    // todo: 5.5. Collect all of the employees given as an array of ID and prints the first employee
    @Test
    void test5_5()
    {
        Integer[] idArr= { 7, 23, 31};

        Employee e =
                Arrays.stream(idArr)
                        .map(this::findById)
                        .findFirst().get();

        System.out.println(e);

    }

    // todo: 6. Get an array out of the stream
    @Test
    void test6()
    {
        Stream<Employee> employeeStream = Arrays.stream(employeeArray);

        Employee[] employees =  employeeStream.toArray(Employee[]::new);
        System.out.println(Arrays.toString(employees));

    }


    // todo: 7. Convert a list of list to list
    @Test
    void test7()
    {
        List<List<String>> llist= Arrays.asList( Arrays.asList("ali","veli"), Arrays.asList("ayşe","sevda","can"));
        List<String > list = llist.stream().flatMap(Collection::stream).toList();
        list.forEach(System.out::println);

        // convert 2d array into 1d array
        int[][] arr2D= { {1,2,3}, {4,5}, {6,7,8,9,0}};

        int[] arr1D =  Arrays.stream(arr2D).peek(x-> System.out.println(Arrays.toString(x))).flatMapToInt(Arrays::stream).toArray();
        System.out.println(Arrays.toString(arr1D));


    }


    // todo: 8. Use peek to increase the salary of each employees
    //       on a stream and print them
    @Test
    void test8()
    {
        Arrays.stream(employeeArray)
                .map(Employee::new)
                .peek(x->x.increaseSalary(5000)).forEach(System.out::println);


        Arrays.stream(employeeArray).forEach(System.out::println);
    }




    // todo: 9. Create map of employess according to the first letter of their names
    @Test
    void test9()
    {
        Map<Character,List<Employee>> map = Stream.of(employeeArray).
                collect(Collectors.groupingBy( x->x.name.charAt(0)));

        System.out.println(map.toString());

    }



}
