package ss3_array.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class CountChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = "Phan Thanh Hoang Linh";

        System.out.println("Nhap vao ky tu muon tim kiem");
        char c = sc.next().charAt(0);
        int count = 0;
        int[] array = new int[str.length()];

        for (int i = 0, k = 0; i < str.length(); i++) {
//            System.out.println(i + " : " + str.charAt(i));
            if (str.charAt(i) == c) {
                count++;
                array[k++] = i;
            }
        }
        System.out.println("Ky tu " + c + " xuat hien " + count + " lan o cac vi tri "+ Arrays.toString(array) );


    }
}
