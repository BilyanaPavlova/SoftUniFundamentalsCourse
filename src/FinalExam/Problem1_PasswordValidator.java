package FinalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem1_PasswordValidator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pass = sc.nextLine();


        String command = sc.nextLine();
        while(!command.equals("Complete")){

            if(command.contains("Make Upper")){
                int idx = Integer.parseInt(command.split(" ")[2]);
                if(idx >= 0 && idx < pass.length()) {
                    char newChar = Character.toUpperCase(pass.charAt(idx));
                    String left = pass.substring(0,idx);
                    String right = pass.substring(idx + 1);
                    pass = left + newChar + right;
                    System.out.println(pass);
                }

            }

            if(command.contains("Make Lower")){
                int idx = Integer.parseInt(command.split(" ")[2]);
                if(idx >= 0 && idx < pass.length()) {
                    char newChar = Character.toLowerCase(pass.charAt(idx));
                    String left = pass.substring(0,idx);
                    String right = pass.substring(idx + 1);
                    pass = left + newChar + right;
                    System.out.println(pass);
                }
            }

            if(command.contains("Insert")){
                int idx = Integer.parseInt(command.split(" ")[1]);
                String ch = command.split(" ")[2];
                if(idx >= 0 && idx <= pass.length()) {   // could be == length
                    String left = pass.substring(0,idx);
                    String right = pass.substring(idx);
                    pass = left + ch + right;
                    System.out.println(pass);
                }

            }

            if(command.contains("Replace")){
                String ch = command.split(" ")[1];
                int value = Integer.parseInt(command.split(" ")[2]);
                if (pass.contains(ch)) {
                    char cha = ch.charAt(0);
                    String newChar = String.valueOf((char) ((int)cha + value));

                    String escapedChar = Pattern.quote(String.valueOf(cha));  // Escape the metacharacter
                    int charValue = (int) cha;
                    int newCharValue = (charValue + value) % 128;
                    char newChar1 = (char) newCharValue;


                    // Use regex to replace all occurrences of the escaped character:
//                    pass = pass.replaceAll(escapedChar, Matcher.quoteReplacement(String.valueOf(newChar1)));
//
//                    or use the matcher.replaceAll
                    String replacementChar = Matcher.quoteReplacement(String.valueOf(newChar1));

                    Pattern pattern = Pattern.compile(escapedChar);
                    Matcher matcher = pattern.matcher(pass);
                    if(matcher.find()) {
                        pass = matcher.replaceAll(replacementChar);

                        System.out.println(pass);
                    }
                }

//                    String regex = "[^a-zA-Z0-9\\s]"; // all special characters
//                    Pattern pattern = Pattern.compile(regex);
//                    Matcher matcher = pattern.matcher(pass);

//                    Matcher matcher1 = pattern.matcher(String.valueOf(newChar));
//
//                    if (matcher.find()) {
//                        String escapedCharToReplace = Pattern.quote(String.valueOf(cha));
//                        if (matcher1.find()) {
//                            String newEscapedCharToReplace = Pattern.quote(String.valueOf(newChar));
//                            pass = pass.replaceAll(escapedCharToReplace, newEscapedCharToReplace);
//                            System.out.println(pass);
//                        } else {
//                            pass = pass.replaceAll(escapedCharToReplace, newChar);
//                            System.out.println(pass);
//                        }
//                    } else {
//                        pass = pass.replaceAll(ch, newChar);
//                        System.out.println(pass);
//                    }

                }


            }



            if(command.contains("Validation")){
                if (pass.length() <  8){
                    System.out.println("Password must be at least 8 characters long!");
                }

                Pattern pattern = Pattern.compile("\\w+");
                Matcher matcher = pattern.matcher(pass);
                if(!matcher.find()){
                    System.out.println("Password must consist only of letters, digits and _!");
                }

                pattern = Pattern.compile("[A-Z]+");
                matcher = pattern.matcher(pass);
                if(!matcher.find()){
                    System.out.println("Password must consist at least one uppercase letter!");
                }

                pattern = Pattern.compile("[a-z]+");
                matcher = pattern.matcher(pass);
                if(!matcher.find()){
                    System.out.println("Password must consist at least one lowercase letter!");
                }

                pattern = Pattern.compile("[0-9]+");
                matcher = pattern.matcher(pass);
                if(!matcher.find()){
                    System.out.println("Password must consist at least one digit!");
                }




            }



                command = sc.nextLine();
        }
    }

