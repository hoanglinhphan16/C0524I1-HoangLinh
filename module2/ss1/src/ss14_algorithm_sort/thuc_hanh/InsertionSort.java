package ss14_algorithm_sort.thuc_hanh;

import java.util.Arrays;

public class InsertionSort {
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            // Di chuyển các phần tử của arr[0..i-1] lớn hơn key một vị trí về phía sau
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
                System.out.println(j);
                System.out.println(Arrays.toString(arr));
            }
            arr[j + 1] = key;
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6};
        System.out.println("Mảng ban đầu:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        insertionSort(arr);

        System.out.println("Mảng sau khi sắp xếp:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}