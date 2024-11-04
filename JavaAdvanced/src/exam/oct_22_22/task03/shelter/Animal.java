package exam.oct_22_22.task03.shelter;

public class Animal {

    String name;
    int age;
    String caretaker;

    public Animal(String name, int age, String caretaker) {
        setName(name);
        setAge(age);
        setCaretaker(caretaker);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCaretaker() {
        return caretaker;
    }

    public void setCaretaker(String caretaker) {
        this.caretaker = caretaker;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s %d (%s)", this.name, this.age, this.caretaker);
    }
}
