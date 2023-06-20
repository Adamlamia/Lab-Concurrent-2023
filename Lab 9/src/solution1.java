import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class solution1 {
    public static void main(String[] args) {
        List<employee> employees = new ArrayList<>();
        employees.add(new employee("Hera", "F", 18));
        employees.add(new employee("Poseidon", "M", 23));
        employees.add(new employee("Apollo", "M", 20));
        employees.add(new employee("Athena", "F", 35));
        employees.add(new employee("Demeter", "F", 50));
        
        List<employee> filteredEmployees = employees.stream()
                .filter(employee -> employee.getGender().equals("F"))
                .filter(employee -> employee.getAge() >= 21)
                .collect(Collectors.toList());
        
        filteredEmployees.forEach(employee -> System.out.println(employee.getName()));
    }
}
