package case_study.model;

public abstract class Vehicle {
    private String plate;
    private String author;
    private int year;
    private String name;

    public Vehicle(String plate, String author, int year, String name) {
        this.plate = plate;
        this.author = author;
        this.year = year;
        this.name = name;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "plate='" + plate + '\'' +
                ", author='" + author + '\'' +
                ", year='" + year + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
