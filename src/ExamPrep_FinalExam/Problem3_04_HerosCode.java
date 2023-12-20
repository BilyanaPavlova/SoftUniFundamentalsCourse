package ExamPrep_FinalExam;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem3_04_HerosCode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Integer> heroHP = new LinkedHashMap<>();
        Map<String, Integer> heroMP = new LinkedHashMap<>();

        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String in = sc.nextLine();
            String hero = in.split(" ")[0];
            int hp = Integer.parseInt(in.split(" ")[1]);
            int mp = Integer.parseInt(in.split(" ")[2]);

            heroHP.put(hero, hp);
            heroMP.put(hero,mp);
        }

        String com = sc.nextLine();
        while(!com.equals("End")){

            String command = com.split(" - ")[0];
            String heroName = com.split(" - ")[1];


            switch (command){
                case "CastSpell":
                    int mpNeeded = Integer.parseInt(com.split(" - ")[2]);
                    int currentMP = heroMP.get(heroName);
                    if (currentMP >= mpNeeded){
                        heroMP.put(heroName, currentMP - mpNeeded);
                        System.out.printf("%s has successfully cast %s and now has %d MP!\n",
                                heroName, com.split(" - ")[3], heroMP.get(heroName) );
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!\n",
                                heroName, com.split(" - ")[3]);
                    }

                    break;

                case "TakeDamage":
                    int damage = Integer.parseInt(com.split(" - ")[2]);
                    int currentHP = heroHP.get(heroName);
                    String attacker = com.split(" - ")[3];
                    heroHP.put(heroName, currentHP - damage);
                        if (heroHP.get(heroName) > 0){
                            System.out.printf("%s was hit for %d HP by %s and now has %d HP left!\n",
                                    heroName, damage, attacker, heroHP.get(heroName) );
                        } else {
                            System.out.printf("%s has been killed by %s!\n",
                                    heroName, attacker);
                            heroMP.remove(heroName);
                            heroHP.remove(heroName);
                        }


                    break;

                case "Recharge":
                    int amount = Integer.parseInt(com.split(" - ")[2]);
                    currentMP = heroMP.get(heroName);
                    if(currentMP + amount > 200){
                        heroMP.put(heroName, 200);
                        System.out.printf("%s recharged for %d MP!\n", heroName, 200 - currentMP);
                    } else {
                        heroMP.put(heroName, currentMP + amount);
                        System.out.printf("%s recharged for %d MP!\n", heroName, amount);
                    }


                    break;

                case "Heal":
                    amount = Integer.parseInt(com.split(" - ")[2]);
                    currentHP = heroHP.get(heroName);
                    if(currentHP + amount > 100){
                        heroHP.put(heroName, 100);
                        System.out.printf("%s healed for %d HP!\n", heroName, 100 - currentHP);
                    } else {
                        heroHP.put(heroName, currentHP + amount);

                        System.out.printf("%s healed for %d HP!\n", heroName, amount);
                    }
                    break;
            }

            com = sc.nextLine();
        }

        heroHP.entrySet().forEach(entry -> {
            System.out.println(entry.getKey());
            System.out.println("  HP: " + entry.getValue());
            System.out.println("  MP: " + heroMP.get(entry.getKey()));
        });
    }
}
