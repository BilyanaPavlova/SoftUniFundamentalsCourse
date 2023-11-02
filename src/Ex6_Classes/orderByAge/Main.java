package Ex6_Classes.orderByAge;



import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Person> people = new ArrayList<>();
        String input = sc.nextLine();
        while (true) {
            if(input.equals("End")){


                Comparator <Person> byAge = Comparator.comparingInt(Person::getAge);
                people.sort(byAge);

                Iterator it = people.iterator();
                while(it.hasNext()){
                    System.out.println(it.next().toString());
                }
                return;
            }

            String[] inp = input.split(" ");
            Person person = new Person(inp[0], inp[1], Integer.parseInt(inp[2]));
            people.add(person);

            input = sc.nextLine();
        }
        }
    }

