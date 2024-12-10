package ss6_inheritance.point_move;

public class Main {
    public static void main(String[] args) {
        Point p1 = new Point(1, 2);
        System.out.println(p1.toString());
        MoveablePoint m1= new MoveablePoint(1,2,3,4);
        m1.move();
        System.out.println(m1.toString());
    }
}
