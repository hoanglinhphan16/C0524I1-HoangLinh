package ss3_array.bai_tap;

import java.util.Arrays;

public class MaxInMatrix {
    public static void main(String[] args) {
        int[][] arr = {{10, 9, 8, 7, 6, 5, 4, 3, 2, 1}, {11, 12, 13, 45, 15, 78, 88, 45, 99, 16}, {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, {10, 9, 8, 7, 6, 5, 4, 3, 2, 1}};

        int max = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
            }
        }

        int[] a = new int[10];
        System.out.println(Arrays.toString(a));

        System.out.println(max);
    }
}
