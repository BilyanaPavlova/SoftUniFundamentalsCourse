package DefiningClasses.Excersises.ex8_review_for_exam;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {

    private String name;
    private String birthday;
    private List<Person> parents = new LinkedList<>();
    private List<Person> children = new LinkedList<>();


    public Person(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public List<Person> getParents() {
        return parents;
    }

    public void addParents(Person parent) {
        this.parents.add(parent);
    }

    public List<Person> getChildren() {
        return children;
    }

    public void addChildren(Person cild) {
        this.children.add(cild);
    }

//    @Override
//    public String toString() {
//        return this.name + " " + this.birthday + "\n"
//                + "Parents:\n"
//                + parents.stream().map(parent -> parent.getName() + " " + parent.getBirthday())
//                .collect(Collectors.joining("\n"))
//                + "\n"
//                + "Children:\n"
//                + children.stream().map(child -> child.getName() + " " + child.getBirthday())
//                .collect(Collectors.joining("\n"));
//    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(" ").append(this.birthday).append("\n");

        sb.append("Parents:\n");
        if (!parents.isEmpty()) {
            sb.append(parents.stream()
                    .map(parent -> parent.getName() + " " + parent.getBirthday())
                    .collect(Collectors.joining("\n")));
            sb.append("\n");
        }

        sb.append("Children:\n");
        if (!children.isEmpty()) {
            sb.append(children.stream()
                    .map(child -> child.getName() + " " + child.getBirthday())
                    .collect(Collectors.joining("\n")));
            sb.append("\n");
        }

        return sb.toString();
    }
}
