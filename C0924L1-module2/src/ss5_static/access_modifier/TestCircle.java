package ss5_static.access_modifier;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle.getArea());
        Circle circle2 = new Circle(3);
        System.out.println(circle2.getRadius());
        System.out.println(circle2.getArea());
    }
}
