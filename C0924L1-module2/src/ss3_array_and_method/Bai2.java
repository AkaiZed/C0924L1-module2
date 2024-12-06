package ss3_array_and_method;

import java.util.Scanner;

public class Bai2 {
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
        int[] a = new int[n + 1];
        for (int i = 0; i < n; i++) {
            System.out.print("Please enter the value of element " + (i + 1) + ": ");
            a[i] = Integer.parseInt(sc.nextLine());
        }
        int x, newValue;
        while (true) {
            System.out.print("Enter the index where you want to insert a new value (0 to " + n + "): ");
            x = Integer.parseInt(sc.nextLine());
            if (x < 0 || x > n) {
                System.out.println("Invalid index. Please try again.");
            } else {
                break;
            }
        }
        System.out.print("Enter the value to insert: ");
        newValue = Integer.parseInt(sc.nextLine());
        for (int i = n; i > x; i--) {
            a[i] = a[i - 1];
        }
        a[x] = newValue;
        System.out.println("The array after insertion is:");
        for (int i = 0; i <= n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
