package ss13_algorithm.bai_tap;

public class BinarySearch {
    public static int binarySearch(int[] array, int left, int right , int value) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (array[mid] == value) {
            return mid;
        } else if (value < array[mid]) {
            return binarySearch(array, left, mid - 1, value);
        } else {
            return binarySearch(array, mid + 1, right, value);
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(binarySearch(array, 0, array.length - 1, 10));
    }
}
