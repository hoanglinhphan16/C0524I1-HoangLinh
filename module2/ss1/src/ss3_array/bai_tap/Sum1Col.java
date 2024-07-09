package ss3_array.bai_tap;

import java.util.Scanner;

public class Sum1Col {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao so hang:");
        int rows = sc.nextInt();
        System.out.println("Nhap vao so cot:");
        int cols = sc.nextInt();

        int[][] arr = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.println("Nhap vao phan tu o dia chi " + i + " " + j);
                arr[i][j] = sc.nextInt();
            }
        }

        int col;
        do {
            System.out.println("Nhap vao cot muon tinh tong:");
            col = sc.nextInt();
        } while (col > rows);

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i][col];
        }

        System.out.println(sum);

    }

}
