package Sets_And_Maps.problems;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P05_FixEmails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, String> phonebook = new LinkedHashMap<>();

        String name = sc.nextLine();
        String email = null;

        while(!name.equals("stop")){

            email = sc.nextLine();
            if (phonebook.containsKey(name)) {
                if (!email.equals(phonebook.get(name))) {
                    phonebook.put(name, email);
                }
            } else {
                phonebook.putIfAbsent(name, email);
            }

            name = sc.nextLine();
            }


//            Pattern pattern = Pattern.compile("\\.com$|\\.uk$|\\.us$");
//            for (Map.Entry<String, String> entry :phonebook.entrySet()) {
//                Matcher matcher = pattern.matcher(entry.getValue());
//                if (matcher.find()) {
//                    phonebook.remove(entry.getKey());
//                }
//            }

        // using the iterator avoids concurrent modification exception when using the foreach above
        Pattern pattern = Pattern.compile("\\.com$|\\.uk$|\\.us$");
        Iterator<Map.Entry<String, String>> iterator = phonebook.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            Matcher matcher = pattern.matcher(entry.getValue());
            if (matcher.find()) {
                iterator.remove(); // Removes the current entry from the map
            }
        }

        for (Map.Entry<String, String> entry :phonebook.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

    }


}
