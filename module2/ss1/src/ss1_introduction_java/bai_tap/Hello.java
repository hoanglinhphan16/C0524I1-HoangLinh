package ss1_introduction_java.bai_tap;

import java.util.Scanner;

public class Hello {
    public static void main(String[] args) {
        System.out.println("Nhập vào tên của bạn");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println("Hello " + str);
    }
}
