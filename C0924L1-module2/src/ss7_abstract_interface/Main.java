package ss7_abstract_interface;

import ss7_abstract_interface.code_gym.Circle;
import ss7_abstract_interface.code_gym.Square;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle.toString());
        Square square = new Square();
        System.out.println(square.toString());
    }
}
