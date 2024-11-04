package FunctionalProgramming.Lec;

import java.util.HashMap;
import java.util.Map;

public class NOTES_StreamOnMap {

    public static void main(String[] args) {


        Map<String, Integer> map = new HashMap<>();

        map.put("Pesho", 2);
        map.put("Gosho", 3);
        map.put("Misho", 5);

//        можем да пускаме stream по entry-тата, по key-овете и по value-тата:

        // стрийм по ентритата
        map.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));

        // стрийм по кейовете
        map.keySet().stream().forEach(System.out::println);

        //стрийм по валютата
        map.values().stream().forEach(System.out::println);

    }
}
