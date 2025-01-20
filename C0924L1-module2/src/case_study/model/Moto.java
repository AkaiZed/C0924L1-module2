package case_study.model;

public class Moto extends Vehicle {
    private float capacity;

    public Moto(String plate, String author, int year, String name, float capacity) {
        super(plate, author, year, name);
        this.capacity = capacity;
    }

    public float getCapacity() {
        return capacity;
    }

    public void setCapacity(float capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Moto{" +
                "plate='" + getPlate() + '\'' +
                ", author='" + getAuthor() + '\'' +
                ", year=" + getYear() +
                ", name='" + getName() + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
