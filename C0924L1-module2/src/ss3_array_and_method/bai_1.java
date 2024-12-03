package ss3_array_and_method;

import java.util.Scanner;

public class bai_1 {
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
        System.out.println("The array you was inserted is: ");
        for (int value : a) {
            System.out.print(value + " ");
        }
        System.out.println();
        int x;
        while (true) {
            System.out.printf("Enter the index of the element you want to delete: ", n - 1);
            x = Integer.parseInt(sc.nextLine());
            if (x < 0 || x >= n) {
                System.out.println("Invalid index. Please try again.");
            } else {
                break;
            }
        }
        for (int i = x-1; i < n - 1; i++) {
            a[i] = a[i + 1];
        }
        a[n - 1] = 0;
        System.out.println("The array after deletion is: ");
        for (int value : a) {
            System.out.print(value + " ");
        }
    }
}
