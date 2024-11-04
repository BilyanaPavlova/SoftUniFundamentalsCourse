package DefiningClasses.Excersises.ex8_review_for_exam;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> relationships = new LinkedList<>();
        List<Person> persons = new LinkedList<>();

        String personToPrint = scanner.nextLine();

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            if (input.contains("-")) {
                relationships.add(input);
            } else {
                String[] tokens = input.split("\\s+");
                String name = tokens[0] + " " + tokens[1];
                String birthday = tokens[2];
                Person person = new Person(name, birthday);
                persons.add(person);
            }
            input = scanner.nextLine();
        }

        String parentName;
        String parentDate;
        String childName;
        String childDate;

        for (String relationship : relationships) {
            String[] tokens = relationship.split("\\s+-\\s+");

            if (!tokens[0].contains("/") && !tokens[1].contains("/")) {
                childDate = "";
                parentDate = "";
                parentName = tokens[0];
                childName = tokens[1];
            } else if (tokens[0].contains("/") && !tokens[1].contains("/")) {
                childDate = "";
                parentName = "";
                parentDate = tokens[0];
                childName = tokens[1];
            } else if (!tokens[0].contains("/") && tokens[1].contains("/")) {
                childName = "";
                parentDate = "";
                parentName = tokens[0];
                childDate = tokens[1];
            } else {
                parentName = "";
                childName = "";
                parentDate = tokens[0];
                childDate = tokens[1];
            }

            String finalParentName = parentName;
            String finalParentDate = parentDate;
            String finalChildName = childName;
            String finalChildDate = childDate;
            persons.stream()
                    .filter(p -> p.getName().equals(finalParentName) || p.getBirthday().equals(finalParentDate))
                    .findFirst()
                    .ifPresent(parent -> {
                        persons.stream()
                                .filter(c -> c.getName().equals(finalChildName) || c.getBirthday().equals(finalChildDate))
                                .findFirst()
                                .ifPresent(child -> {
                                    parent.addChildren(child);
                                    child.addParents(parent);
                                });
                    });
        }

        persons.stream()
                .filter(p -> p.getName().equals(personToPrint) || p.getBirthday().equals(personToPrint))
                .forEach(System.out::println);

    }
}

     /*
     * In Java lambda expressions and inner classes work with effectively final variables.(variables that are not reassigned)
     * In Java lambda expressions, you can only reference variables from the enclosing scope if they are final or effectively final.
     *
     * In the provided code, `parentName` is not effectively final because it is reassigned within the loop.
     * Each time the loop iterates, `parentName` gets a new value.
     * This is why it's not considered effectively final.
     *
     * The concept of "effectively final" in Java means that once a variable has been assigned, it can never be reassigned.
     * It's as if the variable was declared with the `final` keyword. This is important in contexts
     * such as lambda expressions or inner classes, where you can only reference variables from the enclosing scope
     * if they are final or effectively final.
     *
     * In your code, `parentName` is reassigned in each iteration of the loop, depending on the condition.
     * Therefore, it's not effectively final.
     *
     * However, you've created a new variable `finalParentName` and assigned `parentName` to it
     * right after all the reassignments. This `finalParentName` variable is effectively final,
     * as it's not being reassigned after its initialization, and it's used in the lambda expression
     * inside the `stream()` operation. This is a common practice
     * to "transfer" a value from a non-final variable to a final or effectively final variable,
     * so it can be used in a context that requires such a variable.
     *
     * but do not I reassign a value to finalParentName on each iteration of the  loop as well?
     *
     * Yes, you are correct. The variable `finalParentName` is reassigned in each iteration of the loop,
     * just like `parentName`. However, the key difference is how these variables are used
     * in the context of the lambda expression.
     *
     * In the lambda expression, `finalParentName` is treated as effectively final
     * because it's not modified after it's captured by the lambda. !!!!!!!!!!!
     * From the perspective of the lambda, `finalParentName` is effectively final
     * because it doesn't change after the lambda is created.!!!!!!!!!!!!
     *
     * On the other hand, `parentName` is not effectively final because it's reassigned in each iteration of the loop,
     * which means it could potentially change after the lambda is created, leading to unpredictable behavior.!!!!!!!!
     *
     * This is why `finalParentName` can be used in the lambda expression, while `parentName` cannot.
     * The key point here is that a variable must be final or effectively final
     * at the point where it's used in a lambda expression or anonymous inner class.
     */






