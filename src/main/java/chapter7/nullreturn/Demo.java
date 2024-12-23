package chapter7.nullreturn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Demo {

    static Employee[] allEmployees = { new Employee(1,"Ali"),new Employee(2,"Ayşe") };

    public  List<Employee> retrieveEmployee(Predicate<Employee> test)
    {
        if (!_dbCheck())
            return Collections.EMPTY_LIST;

        List<Employee> employees = _retrieveFromDB(test);
        if (employees.isEmpty())
            return null;

        return employees;
    }


    public static Optional<Employee> get(int id)
    {
        if (!checkEmployee(id))
            return Optional.empty();

        Employee e = allEmployees[0];

        return Optional.of(e);


    }

    private static boolean checkEmployee(int id) {
        return false;
    }

    private boolean _dbCheck() {
        return false;
    }

    private List<Employee> _retrieveFromDB(Predicate<Employee> test) {
        return null;
    }

    public static void main(String[] args) {
        Optional<Employee> oE = get(1);
        if (oE.isPresent()) {
            Employee e = oE.get();
        }

        Employee e  = get(1).orElse(allEmployees[1]);
    }

}
