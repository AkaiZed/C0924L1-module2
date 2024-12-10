package ss6_inheritance.circle_cylinder;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle.toString());
        Cylinder cylinder = new Cylinder();
        cylinder.setColor("white");
        cylinder.setHeight(5);
        System.out.println(cylinder.toString());
    }
}
