package ss1_introduce_to_java.bai_tap;

import java.util.Scanner;

public class bai_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Please input USD:");
        double usd = Double.parseDouble(sc.nextLine());
        if (usd < 0) {
            System.out.println("Invalid USD");
        } else {
            double vnd = usd * 23000;
            System.out.println(usd + " USD = " + vnd + " VND");
        }
    }
}
