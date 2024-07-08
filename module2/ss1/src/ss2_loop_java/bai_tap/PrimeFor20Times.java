package ss2_loop_java.bai_tap;

public class PrimeFor20Times {
    public static void main(String[] args) {
//        int count = 0;
//        int n = 0;
//        while (count < 20) {
//            boolean isPrime = true;
//
//            for (int j = 2; j <= Math.sqrt(n); j++) {
//                if (n == 0) {
//                    isPrime = false;
//                } else if (n % j == 0) {
//                    isPrime = false;
//                    break;
//                }
//
//            }
//            if (isPrime) {
//                System.out.println(n);
//                n++;
//                count++;
//            }
//            n++;
//        }
        int count = 0;
        int countDivisor = 0;
        int n = 0;
        System.out.println("----------------------------");

        while (count < 20) {
                countDivisor = 0;
                for (int j = 1; j <= n; j++) {
                    if (n % j == 0) {
                        countDivisor++;
                    }
                }
                if (countDivisor == 2) {
                    System.out.println(n);
                    count++;
                }
                n++;
        }
    }
}
