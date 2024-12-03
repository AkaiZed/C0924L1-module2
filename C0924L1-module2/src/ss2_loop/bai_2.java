package ss2_loop;

public class bai_2 {
    public static void main(String[] args) {
        int count = 0;
        int num = 2;
        System.out.print("First 20 prime numbers are: ");
        while (count < 20) {
            boolean isPrime = true;

            for (int i = 2; i < num / 2; i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.print(num + " ");
                count++;
            }
            num++;
        }
    }
}
