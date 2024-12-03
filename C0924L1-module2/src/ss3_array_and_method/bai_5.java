package ss3_array_and_method;

import java.util.Scanner;

public class bai_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        while (true) {
            System.out.printf("Enter the elements of the array: ");
            n = Integer.parseInt(sc.nextLine());
            if (n <= 0) {
                System.out.println("Invalid input");
            } else {
                break;
            }
        }
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            System.out.print("Please enter the value of the " + (i + 1) + " element: ");
            a[i] = Integer.parseInt(sc.nextLine());
        }
        int result = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < result) {
                result = a[i];
            }
        }
        System.out.print("The smallest value in the array is: " + result);
    }
}
