package ss2_loop;

public class Bai3 {
    public static void main(String[] args) {

        int num = 2;
        System.out.print("Display prime numbers less than 100: ");
        while (num < 100) {
            boolean isPrime = true;

            for (int i = 2; i < num / 2; i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.print(num + " ");
            }
            num++;
        }

    }
}
