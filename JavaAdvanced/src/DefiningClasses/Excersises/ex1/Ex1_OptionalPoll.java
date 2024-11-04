package DefiningClasses.Excersises.ex1;

public class Ex1_OptionalPoll {

    private String name;
    private int age;

    public Ex1_OptionalPoll(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name  + " - " + age + "\n";
    }

    public int getAge() {
        return age;
    }
}
