package ss10_stack.coefficient_conversion;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static int checkIntPositive(String mess) {
        Scanner sc = new Scanner(System.in);
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

    public static void main(String[] args) {
        int decimal = checkIntPositive("Enter the decimal number: ");
        Stack<Integer> stack = new Stack<>();
        while (decimal != 0) {
            stack.push(decimal % 2);
            decimal = decimal / 2;
        }
        System.out.print("Binary number: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
