package ss13_algorithm.thuc_hanh;

public class BinarySearch {
    static int binarySearch(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;

        while(end >= start) {
            int mid = (start + end) / 2;
            if (target == mid) {
                return mid;
            } else if (target > mid) {
                start = mid + 1;
            } else if (target < mid) {
                end = mid - 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] list = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};

        System.out.println(binarySearch(list, 4));

    }


}
