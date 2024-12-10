package ss6_inheritance.circle_cylinder;

public class Cylinder extends Circle {
    private double height;

    public Cylinder() {
    }

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        return Math.PI * Math.pow(height, 2);
    }

    @Override
    public String toString() {
//        return super.toString() + "\nHeight: " + height + "\nVolume: " + getVolume();
        return "Cylinder{" +
                "radius=" + getRadius() +
                ", color=" + getColor() +
                ", area=" + getArea() +
                ", height=" + height +
                ", volume=" + getVolume() +
                '}';
    }
}
