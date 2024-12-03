package ss3_array_and_method;

import java.util.Scanner;

public class bai_3 {

    public static void main(String[] args) {
        int[] a1 = new int[4];
        int[] a2 = new int[5];
        System.out.println("Please input the value in the a1 (4 elements)");
        for (int i = 0; i < a1.length; i++) {
            System.out.print("Please input the element " + (i + 1) + ": ");
            a1[i] = Integer.parseInt((new Scanner(System.in)).nextLine());
        }

        System.out.println("\nPlease input the value in the a2 (5 elements)");
        for (int i = 0; i < a2.length; i++) {
            System.out.print("Please input the element " + (i + 1) + ": ");
            a2[i] = Integer.parseInt((new Scanner(System.in)).nextLine());
        }

        int[] a3 = new int[a1.length + a2.length];
        for (int i = 0; i < a1.length; i++) {
            a3[i] = a1[i];
        }
        for (int i = 0; i < a2.length; i++) {
            a3[a1.length + i] = a2[i];
        }

        System.out.printf("The third array is: ");
        for (int i = 0; i < a3.length; i++) {
            System.out.print(a3[i] + " ");
        }
    }
}
