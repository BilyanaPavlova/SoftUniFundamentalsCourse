package iterable_iterator_comparable_comparator.exc.ex05_Comparable;

public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.setName(name);
        this.setAge(age);
        this.setTown(town);
    }

    private void setTown(String town) {
        this.town = town;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    private String getTown() {
        return this.town;
    }

    private void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Person other) {
        int result = this.getName().compareTo(other.getName());
        if (result == 0) {
            result = Integer.compare(this.getAge(), other.getAge()); //Primitive types do not have methods, so you cannot call compareTo on them. Instead, you can use the Integer.compare method to compare two int values.
        }
        if (result == 0) {
            result = this.getTown().compareTo(other.getTown());

        }
        return result; // 0 if equal, -1 if less, 1 if greater

    }

    @Override
        public String toString() {
        return String.format("%s %d %s", this.getName(), this.getAge(), this.getTown());
    }


}
