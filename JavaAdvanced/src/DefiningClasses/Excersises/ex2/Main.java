package DefiningClasses.Excersises.ex2;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Set<Department> departments = new HashSet<>();

        while (n-- > 0) {
            String[] arr = sc.nextLine().split("\\s+");
            Employee employee = new Employee(arr[0], Double.parseDouble(arr[1]), arr[2], arr[3]);

            if (arr.length > 5){
                employee.setAge(Integer.parseInt(arr[5]));
                employee.setEmail(arr[4]);
            }

            if (arr.length == 5){
                if (arr[4].contains("@")) {
                    employee.setEmail(arr[4]);
                } else {
                    employee.setAge(Integer.parseInt(arr[4]));
                }
            }

            if (!contains(departments, arr[3])){
                Department department = new Department(arr[3]);
                department.addEmployee(employee);
                departments.add(department);

            } else {

                Department foundDepartment = departments.stream()
                        .filter(d -> d.getName().equals(arr[3]))
                        .findFirst()
                        .get();

                foundDepartment.addEmployee(employee);


            }



        }

        departments.stream()
                .max(Comparator.comparingDouble(Department::getAverageSalary))

                .ifPresent(d -> {
                    System.out.println("Highest Average Salary: " + d.getName());
                    d.getEmployees()
                            .stream()
                            .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                            .forEach(System.out::println);
                });


    }

    public static boolean contains(Set<Department> departments, String name){
        for (Department d : departments) {
            if (d.getName().equals(name)){
                return true;
            }
        }
        return false;
    }
}
