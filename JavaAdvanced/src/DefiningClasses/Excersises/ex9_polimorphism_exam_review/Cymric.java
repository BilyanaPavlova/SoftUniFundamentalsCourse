package DefiningClasses.Excersises.ex9_polimorphism_exam_review;

public class Cymric extends Cat{

    private double furLength;

    public Cymric(String name, String breed, double furLength) {
        super(name, breed);
        this.furLength = furLength;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f", super.toString(), this.furLength);
    }

    public double getFurLength() {
        return furLength;
    }
}
