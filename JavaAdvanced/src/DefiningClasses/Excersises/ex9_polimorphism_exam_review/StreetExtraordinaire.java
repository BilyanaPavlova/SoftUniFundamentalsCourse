package DefiningClasses.Excersises.ex9_polimorphism_exam_review;

public class StreetExtraordinaire extends Cat{

        private double decibelsOfMeows;

        public StreetExtraordinaire(String name, String breed, double decibelsOfMeows) {
            super(name, breed);
            this.decibelsOfMeows = decibelsOfMeows;
        }

    public double getDecibelsOfMeows() {
        return decibelsOfMeows;
    }

    @Override
        public String toString() {
            return String.format("%s %.2f", super.toString(), this.decibelsOfMeows);
        }
}
