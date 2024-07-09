package ss3_array.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class DeleteElementInArray {
    public static void main(String[] args) {
        System.out.println("Nhap vao do dai mang: ");
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            System.out.println("Nhap vao phan thu thu " + (i + 1));
            array[i] = sc.nextInt();
        }

        int index_del = 0;
        boolean isExist = false;
        System.out.println(Arrays.toString(array));
        System.out.println("Nhap vao phan tu muon xoa: ");
        int value = sc.nextInt();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                isExist = true;
                for (int j = i; j < array.length - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[array.length - 1] = 0;
                i--;
            }
        }
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] == value) {
//                array[i] = 0;
//                index_del = i;
//                isExist = true;
//            }
//        }

        if (isExist) {
            System.out.println("Da xoa");
            System.out.println(Arrays.toString(array));
        } else {
            System.out.println("Ko co phan tu nay de xoa");
        }
    }
}
