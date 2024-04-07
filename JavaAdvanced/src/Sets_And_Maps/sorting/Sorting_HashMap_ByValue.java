package Sets_And_Maps.sorting;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Sorting_HashMap_ByValue {
    public static void main(String[] args) {
        Map<String, Integer> mp = new HashMap<>();
        mp.put("Aries", 1);
        mp.put("Taurus", 2);
        mp.put("Gemini", 3);

        //sorting ascending
//        Map<String, Integer> resultMap = mp.entrySet()
//                .stream()
//                .sorted(Map.Entry.<String, Integer>comparingByValue())
//                .collect(Collectors.toMap(Map.Entry::getKey,
//                        Map.Entry::getValue,(e1, e2) -> e1, LinkedHashMap::new));
    }
}
