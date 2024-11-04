package exam.oct_17_22.task03;

public class Employee {

    String name;
    int age;
    String country;

    public Employee(String name, int age, String country) {
        setName(name);
        setAge(age);
        setCountry(country);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {

        return String.format("Employee: %s, %d (%s)", this.name, this.age, this.country);

    }
}
