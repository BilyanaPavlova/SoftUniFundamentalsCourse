package halloween;

public class Kid {

    String name;
    int age;
    String street;

    public Kid(String name, int age, String street) {
        setName(name);
        setAge(age);
        setStreet(street);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.age + ", " + "years old, from " + this.street;

    }

}
