package DefiningClasses.Lecture;

public class ConsturctorChaining {

    String brand;
    String model;
    int horsePower;

    //Винаги викаме констр с повече параметри в конструктора спо-малко параметри. Така не повтаряме код.

    public ConsturctorChaining(String brand, String model, int horsePower){
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
    }

    public ConsturctorChaining(String brand, String model){
        this(brand, model, 0); // подаваме параметрите като аргументи на извикания конструктор. задаваме стойност за третия, може 0 като дефолт
    }
}
