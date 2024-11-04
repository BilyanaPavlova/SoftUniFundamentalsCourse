package DefiningClasses.Lecture;

public class StaticFieldAndMethods {

    private static int nextID = 1; //принадлежи на класа  и асайнатата му стойност ще важи за всички инстанциирани обекти. променя се с конструктора
    private static double interestRate = 0.02;
    private int id;
    private double balance;

    public StaticFieldAndMethods(){
            this.id = nextID;
            nextID++;
    } // при всяка инстанция на нов обект се променя статичното поле, но инстанцията е с нов номер (ID)

    public static void setInterestRate(double interestRate){
        StaticFieldAndMethods.interestRate = interestRate;
        // когато инициализираме статично поле не го викаме с this.
        // защото this. е обекта, за който ще се отнася, а го викаме с името на класа
    }
}
