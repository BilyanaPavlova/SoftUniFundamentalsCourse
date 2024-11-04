package DefiningClasses.Excersises.ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Department {

    private String name;
    private List<Employee> employees = new ArrayList<>();

    public Department(String name){
        this.name = name;
    }

    public void addEmployee(Employee employee){
        this.employees.add(employee);
    }

    public double getAverageSalary(){
        return this.employees.
                stream().
                mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);

    }

    public String getName() {
        return this.name;
    }

    public List <Employee> getEmployees() {
        return this.employees;
    }
}
