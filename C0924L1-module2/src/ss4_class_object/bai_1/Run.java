package ss4_class_object.bai_1;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        double a = Double.parseDouble(sc.nextLine());
        System.out.print("Enter the second number: ");
        double b = Double.parseDouble(sc.nextLine());
        System.out.print("Enter the third number: ");
        double c = Double.parseDouble(sc.nextLine());

        QuadraticEquation qe = new QuadraticEquation(a, b, c);
        System.out.println(qe.getResult());
    }
}
