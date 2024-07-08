package ss3_array.thuc_hanh;

import java.util.Arrays;
import java.util.Scanner;

public class CheckTest {
    public static void main(String[] args) {
//        System.out.println("Nhap vao do dai cua mang");
//        Scanner sc = new Scanner(System.in);
//        int length = sc.nextInt();
//        int[] array = new int[length];
//
//        for (int i = 0; i < array.length; i++) {
//            System.out.println("Nhap vao phan tu thu " + (i + 1));
//            array[i] = sc.nextInt();
//        }
//
//        System.out.println(Arrays.toString(array));

        System.out.println("Nhap vao so hang");
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        System.out.println("Nhap vao so cot");
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.println("Nhap vao vi tri " + i + " " + j);
                matrix[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(Arrays.deepToString(matrix));
    }
}
