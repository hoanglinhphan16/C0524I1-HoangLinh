package ss3_array.bai_tap;

import java.util.Scanner;

public class SumDuongCheoMaTranVuong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao do dai ma trang vuong muon tao:");
        int length = sc.nextInt();

        int[][] array = new int[length][length];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.println("Nhap vao vi tri " + i + " x " + j + ":");
                array[i][j] = sc.nextInt();
            }
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == j) {
                    sum += array[i][j];
                }
            }
        }

        System.out.println("Tong duong cheo chinh la: "+sum);
    }
}
