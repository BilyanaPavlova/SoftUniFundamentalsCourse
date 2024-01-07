package resources.IMPORTANT;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RULES_Strings {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // convert char array to string and vice versa
        String str = new String(new char[]{'s', 't', 'r'});
        char[] charArr = str.toCharArray();

        System.out.println(str);
        System.out.println(charArr);

        char [] charact = new char[]{'a', 'b','c'};
        String myString = new String(charact);
        System.out.println(myString);

        // concatenate
        String greet = "Hello, ";
        String name = "John";
        String result = greet.concat(name);
        System.out.println(result); // "Hello, John"

        String t = String.join("", "con", "ca", "ten", "ate");
// "concatenate"

//        Or an array/list of strings
//▪ Useful for repeating a string

        String s = "abc";
        String[] arr = new String[3];
        for (int i = 0; i < arr.length; i++) { arr[i] = s; }
        String repeated = String.join("", arr); // "abcabcabc"

        // repeat strings
        String[] words = sc.nextLine().split(" ");
        List<String> result1 = new ArrayList<>();
        for (String word : words) {
            result1.add(repeat(word, word.length()));
        }

        System.out.println(String.join("", result));

        //    substring(int startidx, int endidx)

        String card = "10C";
        String power = card.substring(0, 2);
        System.out.println(power); // 10

//        substring (int startidx)
        String text = "My name is John";
        String extractWord = text.substring(11);
        System.out.println(extractWord); // John

//        searching
//        indexOf() - returns the first match index or -1
        String fruits = "banana, apple, kiwi, banana, apple";
        System.out.println(fruits.indexOf("banana")); // 0
        System.out.println(fruits.indexOf("orange")); // -1

//        lastIndexOf() - finds the last occurrence
        String fruits1 = "banana, apple, kiwi, banana, apple";
        System.out.println(fruits1.lastIndexOf("banana")); // 21
        System.out.println(fruits1.lastIndexOf("orange")); // -1

//      contains() - checks whether one string contains another

        String text1 = "I love fruits.";
        System.out.println(text1.contains("fruits"));// true
        System.out.println(text1.contains("banana"));// false

//        splitting by a given patern
        String text2 = "Hello, john@softuni.bg, you have been using john@softuni.bg in your registration";
        String[] words3 = text.split(", ");
// words[]: "Hello", "john@softuni.bg","you have been…"

//        splitting by multiple separators
        String text4 = "Hello, I am John.";
        String[] words4 = text.split("[, .]+"); //by all , and .
// "Hello", "I", "am", "John"

//        replace(match, replacement) - replaces all occurrences
//          The result is a new string (strings are immutable)

        String text6 = "Hello, john@softuni.bg, you have been using john@softuni.bg in your registration.";
        String replacedText = text
                .replace("john@softuni.bg", "john@softuni.com");
        System.out.println(replacedText);
// Hello, john@softuni.com, you have been using john@softuni.com in your registration.


//        String Builder uses a buffer capacity and do not use so much memory as when creating new and new immutable strings

        StringBuilder sb = new StringBuilder();
        sb.append("Hello, ");
        sb.append("John! ");
        sb.append("I sent you an email.");
        System.out.println(sb.toString());

// Hello, John! I sent you an email.

        sb.insert(0, "John");  // "John" is inserted in the beginning of the sb

    }

    static String repeat(String s, int repeatCount) {
        String[] repeatArr = new String[repeatCount];
        for (int i = 0; i < repeatCount; i++) {
            repeatArr[i] = s;
        }
        return String.join("", repeatArr);
    }



//    -----



}
