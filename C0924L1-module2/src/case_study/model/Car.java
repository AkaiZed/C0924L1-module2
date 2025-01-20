package case_study.model;

public class Car extends Vehicle {
    private int seatCount;
    private String type;

    public Car(String plate, String author, int year, String name, String type, int seatCount) {
        super(plate, author, year, name);
        this.seatCount = seatCount;
        this.type = type;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Car{" +
                "plate='" + getPlate() + '\'' +
                ", author='" + getAuthor() + '\'' +
                ", year=" + getYear() +
                ", name='" + getName() + '\'' +
                ", seatCount=" + seatCount +
                ", type='" + type + '\'' +
                '}';
    }
}
