package streams;

public class Employee {
    private int id;
    private String name;
    private int age;
    private double salary;
    private String city;
    private String gender;
    private String department;
    private int yearsOfExperience;

    public Employee(int id, String name, int age, double salary){
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    // Constructor
    public Employee(int id, String name, int age, double salary, String city,
                    String gender, String department, int yearsOfExperience) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.city = city;
        this.gender = gender;
        this.department = department;
        this.yearsOfExperience = yearsOfExperience;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getSalary() { return salary; }
    public String getCity() { return city; }
    public String getGender() { return gender; }
    public String getDepartment() { return department; }
    public int getYearsOfExperience() { return yearsOfExperience; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setSalary(double salary) { this.salary = salary; }
    public void setCity(String city) { this.city = city; }
    public void setGender(String gender) { this.gender = gender; }
    public void setDepartment(String department) { this.department = department; }
    public void setYearsOfExperience(int yearsOfExperience) { this.yearsOfExperience = yearsOfExperience; }

    // toString() method for easy printing
    @Override
    public String toString() {
        return "Employee { " +
                "ID=" + id +
                ", Name='" + name + '\'' +
                ", Age=" + age +
                ", Salary=" + salary +
                ", City='" + city + '\'' +
                ", Gender='" + gender + '\'' +
                ", Department='" + department + '\'' +
                ", Years of Experience=" + yearsOfExperience +
                " }";
    }
}
