package exam.oct_17_22.task03;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Bakery {

    List<Employee> employees;

    String name;
    int capacity;

    public Bakery(String name, int capacity) {
        this.employees = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }

    public void add(Employee employee) {
        if (this.employees.size() < capacity) {
            employees.add(employee);
        }
    }

    public boolean remove(String name) {
        return employees.removeIf(employee -> employee.getName().equals(name));
    }

    public Employee getOldestEmployee() {
        return employees.stream()
                .max(Comparator.comparingInt(Employee::getAge))
                .orElse(null);
    }

    public Employee getEmployee(String name) {
        return employees.stream()
                .filter(employee -> employee.getName().equals(name))
                .findAny()
                .orElse(null);
    }

    public int getCount() {
        return employees.size();
    }


    public String report() {
        StringBuilder strb = new StringBuilder("Employees working at Bakery ")
                .append(this.name)
                .append(":")
                .append(System.lineSeparator());

        employees.forEach(e -> strb.append(e.toString()).append(System.lineSeparator()));

        return strb.toString();
    }
}
