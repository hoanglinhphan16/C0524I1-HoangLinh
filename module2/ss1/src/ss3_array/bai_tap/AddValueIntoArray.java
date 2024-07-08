package ss3_array.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class AddValueIntoArray {
    public static void main(String[] args) {
        System.out.println("Nhap vao do dai mang");
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] array = new int[length];
        int[] newArray = new int[array.length + 1];

        for (int i = 0; i < array.length; i++) {
            System.out.println("Nhap vao phan tu thu " + (i + 1));
            array[i] = sc.nextInt();
        }

        System.out.println("Nhap vao gia tri can chen");
        int value = sc.nextInt();

        System.out.println("Nhap vao vi tri can chen");
        int index = sc.nextInt();

        if (index <= -1 || index >= array.length - 1) {
            System.out.println("Ko chen duoc phan tu vao mang");
        } else {
            for (int i = 0; i < index; i++) {
                newArray[i] = array[i];
            }
            newArray[index] = value;
            for (int i = index; i < array.length; i++) {
                newArray[i+1] = array[i];
            }
        }

        System.out.println(Arrays.toString(newArray));
    }
}
