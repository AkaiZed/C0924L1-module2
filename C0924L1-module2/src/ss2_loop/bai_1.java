package ss2_loop;

import java.util.Scanner;

public class bai_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println("-----------------------------");
            System.out.println("1. Print the rectangle");
            System.out.println("2. Print the square triangle");
            System.out.println("3. Print isosceles triangle");
            System.out.println("4. Exit");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    while (true) {
                        System.out.print("Enter the length of the rectangle: ");
                        int length = Integer.parseInt(sc.nextLine());
                        System.out.print("Enter the width of the rectangle: ");
                        int width = Integer.parseInt(sc.nextLine());
                        if (length < width) {
                            System.out.println("Error");
                        } else {
                            for (int i = 0; i < width; i++) {
                                for (int j = 0; j < length; j++) {
                                    System.out.print("* ");
                                }
                                System.out.printf("\n");
                            }
                        }
                        break;
                    }
                    break;
                case 2:
                    System.out.println("Square in botton-left");
                    for (int i = 1; i <= 5; i++) {
                        for (int j = 1; j <= i; j++) {
                            System.out.print("* ");
                        }
                        System.out.printf("\n");
                    }
                    System.out.println("Square in top-left");
                    for (int i = 5; i >= 1; i--) {
                        for (int j = 1; j <= i; j++) {
                            System.out.print("* ");
                        }
                        System.out.printf("\n");
                    }
                    break;
                case 3:
                    System.out.println("Isosceles triangle");
                    for (int i = 1; i <= 5; i++) {
                        for (int j = 1; j <= 5 - i; j++) {
                            System.out.print(" ");
                        }
                        for (int k = 1; k <= i; k++) {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                    break;
                case 4:
                    System.out.printf("Exitting...");
                    System.exit(0);
                default:
                    System.out.println("Error syntax, please try again");
            }
        }
    }
}
