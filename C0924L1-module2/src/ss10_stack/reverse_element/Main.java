package ss10_stack.reverse_element;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        int element = checkInt("Enter the element of array: ");
        int[] arr = new int[element];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = checkInt("Enter the value of the " + (i + 1) + " element: ");
        }
        System.out.print("The current array is: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "    ");
            stack.push(arr[i]);
        }
        System.out.print("\nThe array after reverse is: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(stack.pop() + "    ");
        }
    }

    public static int checkInt(String mess) {
        int number = 0;
        while (true) {
            System.out.print(mess);
            try {
                String input = sc.nextLine().trim();
                if (input.isEmpty()) {
                    throw new NumberFormatException("Input cannot be empty.");
                }
                number = Integer.parseInt(input);
                if (number < 0) {
                    throw new NumberFormatException("Number cannot be negative.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
        return number;
    }
}
