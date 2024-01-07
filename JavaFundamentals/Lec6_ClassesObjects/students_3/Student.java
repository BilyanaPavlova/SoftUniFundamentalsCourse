package Lec6_ClassesObjects.students_3;

public class Student {
    private String firstName;
    private String lastName;
    private String age;
    private String homeTown;

    public void setAge(String age) {
        this.age = age;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public Student(String firstName, String lastName, String age, String homeTown) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.homeTown = homeTown;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAge() {
        return age;
    }

    public String getHomeTown() {
        return homeTown;
    }

    @Override
    public String toString(){
        return this.firstName + " "
                + this.lastName + " "
                + this.age + " "
                + this.homeTown;
    }
}
