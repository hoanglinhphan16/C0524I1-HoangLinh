package ss2_loop_java.bai_tap;

public class PrimeLessThan100 {
    public static void main(String[] args) {
        int n = 0;

        while (n <= 100) {
            boolean isPrime = true;
            if (n<2) {
                isPrime = false;
            }
            for (int i = 2; i <= Math.sqrt(n); i++) {

                if (n % i == 0) {
                    isPrime = false;
                }
            }
            if (isPrime) {
                System.out.println(n);
            }
            n++;
        }
    }
}
