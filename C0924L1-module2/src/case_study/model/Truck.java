package case_study.model;

public class Truck extends Vehicle {
    private float weight;

    public Truck(String plate, String author, int year, String name, float weight) {
        super(plate, author, year, name);
        this.weight = weight;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "plate='" + getPlate() + '\'' +
                ", author='" + getAuthor() + '\'' +
                ", year=" + getYear() +
                ", name='" + getName() + '\'' +
                ", weight=" + weight +
                '}';
    }
}
