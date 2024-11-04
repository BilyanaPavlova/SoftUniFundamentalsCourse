package DefiningClasses.Excersises.ex9_polimorphism_exam_review;

public class Siamese extends Cat{

    private double earSize;

    public Siamese(String name, String breed, double earSize) {
        super(name, breed);
        this.earSize = earSize;
    }

    public double getEarSize() {
        return earSize;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f", super.toString(), this.earSize);
    }

}
