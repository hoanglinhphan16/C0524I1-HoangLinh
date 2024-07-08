package ss2_loop_java.thuc_hanh;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = sc.nextInt();

        if (n < 2) {
            System.out.println("Not a prime number");
        } else {
            int i = 2;
            boolean check = true;
            while (i <= Math.sqrt(n)) {
                if (n % i == 0) {
                    check = false;
                    break;
                }
            }

            if (check) {
                System.out.println("Prime number");
            } else System.out.println("Not a prime number");
        }
    }
}
