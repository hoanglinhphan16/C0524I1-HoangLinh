package ss14_algorithm_sort.thuc_hanh;

import java.util.Arrays;

public class SelectionSort {
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            // Giả sử phần tử đầu tiên của phần chưa được sắp xếp là nhỏ nhất
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                // Tìm phần tử nhỏ nhất trong phần chưa được sắp xếp
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            System.out.println(Arrays.toString(arr));
            // Hoán đổi phần tử nhỏ nhất với phần tử đầu tiên của phần chưa được sắp xếp
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;

            System.out.println(Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        System.out.println("Mảng ban đầu:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        selectionSort(arr);

        System.out.println("Mảng sau khi sắp xếp:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
