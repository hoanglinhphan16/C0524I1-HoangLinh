package ss1_introduction_java.bai_tap;

import java.util.Scanner;

public class ChangeMoney {
    public static void main(String[] args) {
        long rate = 23000;

        System.out.println("Nhap vao so USD muon chuyen doi");
        Scanner sc = new Scanner(System.in);

        int valueUSD = sc.nextInt();
        long result = valueUSD * rate;

        System.out.println(valueUSD + "-->" + result);
        System.out.println(61/10);
    }
}
