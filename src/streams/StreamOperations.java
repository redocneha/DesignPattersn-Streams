package streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOperations {
    public static void main(String[] args) {
        List<Employee> employeeList = loadEmployees();

        // get employee names as list
        Stream<Employee> employeeStream = employeeList.stream();
        //Map uses Function F.I (takes i/p and gives o/p) apply (abstract method)
        List<String> employeeNames= employeeStream.map(Employee::getName).toList();
        System.out.println("Employee names"+employeeNames);

        // Filter age > 25
        // Filter uses Predicate F.I (takes i/p and gives boolean result) test (abstract method)
        employeeNames = employeeList.stream().filter((emp)-> emp.getAge() > 25).map(Employee::getName).toList();
        System.out.println("Employee names age > 25 : "+employeeNames);

        // print distinct cities
        // foreach uses Consumer F.I (takes i/p but no o/p) => accept (abstract method)
        employeeList.stream().map(Employee::getCity).distinct().forEach(System.out::print);
        System.out.println();

        //count of employees salary > 50K
        long empCount = employeeList.stream().filter((emp)-> emp.getSalary()>90000).count();
        System.out.println("Emp count with salary > 90K :"+empCount);

        //get first 3 employee objects
        List<Employee> employees = employeeList.stream().limit(3).toList();
        System.out.println("First 3 employees "+employees);

        //skip first 3 employees
        employees = employeeList.stream().skip(3).toList();
        System.out.println("Employees after skipping 3 "+employees);

        //verify any employee with age < 18
        System.out.println("Any employee with age < 18?  "+employeeList.stream().anyMatch(emp -> emp.getAge() < 18));

        //verify all employee with yoe < 5
        System.out.println("All employees with yoe < 5?  "+employeeList.stream().allMatch(emp -> emp.getYearsOfExperience() < 5));

        // find any employee with age <=18 , similar with findfirst
        Optional<Employee> employeeOptional = employeeList.stream().filter(emp->emp.getAge()<=18).findAny();
        System.out.println("Any employee with age <=18"+employeeOptional.get());

        // return employees with asc ord of their ids
        employees = employeeList.stream().sorted(Comparator.comparingInt(Employee::getId)).toList();
        System.out.println("Sorted emp id list"+employees);

        //min salaried employee
        Employee minSalariedEmployee = employeeList.stream().min(Comparator.comparingDouble(Employee::getSalary)).get();
        System.out.println("Min Salaried Employee"+minSalariedEmployee);

        //avg salary , average only on double
        double avgSalary = employeeList.stream().mapToDouble(Employee::getSalary).average().getAsDouble();
        System.out.println("Average Salary "+avgSalary);
        // Another way
         avgSalary = employeeList.stream().collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println("Average Salary2 "+avgSalary);
        //peek => to perform action in between intermediate actions,before passing to next action
        //employees = employeeList.stream().peek(System.out::println).filter(emp -> emp.getYearsOfExperience()>8).toList();
       // System.out.println("Emps "+employees);

        //collect emp id and their salaries
        Map<Integer,Double> collectedEmps = employeeList.stream().sorted(Comparator.comparingInt(Employee::getId)).collect(Collectors.toMap(Employee::getId,Employee::getSalary,(existing, replacement) -> replacement,  LinkedHashMap::new));
        System.out.println("Collect Emp IDs and salaries ");
        collectedEmps.forEach((key, value) -> System.out.println(key + ": " + value));

        // get average salary of per gender
        Map<String,Double> avgSalaryBasedOnGender = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingDouble(Employee::getSalary)));
        System.out.println("Avg salary based on gender ");
        avgSalaryBasedOnGender.forEach((key, value) -> System.out.println(key + ": " + value));

        //get employee count per department
        Map<String,Long> empCountPerDept = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));


        System.out.println("Employee count per dept");
        empCountPerDept.forEach((key, value) -> System.out.println(key + ": " + value));

        //summing and summarizing(returns statistics of summing)
        //Summing all employee salaries
        System.out.println("Summing salaries"+employeeList.stream().collect(Collectors.summingDouble(Employee::getSalary)));
        System.out.println("Summarizing salaries"+employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary)));


        //find max age employee
        Employee maxAgedEmp = employeeList.stream().sorted(Comparator.comparingInt(Employee::getAge).reversed()).toList().get(0);
        System.out.println("Max aged employee"+maxAgedEmp);
        //(or)
        maxAgedEmp = employeeList.stream().max(Comparator.comparingInt(Employee::getAge)).get();
        System.out.println("Max aged employee"+maxAgedEmp);
        //join all the dept names with delimiter(')
        String joined = employeeList.stream().map(Employee::getDepartment).collect(Collectors.joining(","));
        System.out.println("All depts "+joined);
    }
    public static List<Employee> loadEmployees() {
        Employee emp1 = new Employee(1, "John Doe", 30, 75000, "New York", "Male", "IT", 8);
        Employee emp2 = new Employee(21, "Jane Smith", 28, 82000, "Los Angeles", "Female", "Finance", 6);
        Employee emp3 = new Employee(322, "Robert Brown", 40, 95000, "Chicago", "Male", "HR", 15);
        Employee emp4 = new Employee(4, "Emily Johnson", 35, 68000, "San Francisco", "Female", "Marketing", 10);
        Employee emp6 = new Employee(92, "Sophia Martinez", 33, 88000, "Boston", "Female", "Sales", 9);
        Employee emp7 = new Employee(27, "Daniel Wilson", 18, 102000, "Austin", "Male", "IT", 18);
        Employee emp8 = new Employee(8, "Olivia Taylor", 16, 79000, "Denver", "Female", "Design", 7);
        Employee emp9 = new Employee(89, "James Anderson", 50, 110000, "Miami", "Male", "Management", 20);
        Employee emp10 = new Employee(10, "Emma Thomas", 20, 85000, "Seattle", "Female", "Legal", 12);
        Employee emp5 = new Employee(5, "Michael Lee", 23, 72000, "Seattle", "Male", "Engineering", 5);
        return List.of(emp1,emp2,emp3,emp4,emp5,emp6,emp7,emp8,emp9,emp10);
    }
}


