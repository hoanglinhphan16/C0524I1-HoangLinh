package ss3_array.thuc_hanh;

import java.util.Arrays;

public class TestMethod {
    public static void main(String[] args) {
//        int result = countChar("Phan Thanh Hoang Linh", 'a');
//        System.out.println(result);

        int[] a = {1,2,3,4,5,6,7,8,9},b = new int[3];
        System.out.println(Arrays.toString(b));
        a[9] = b[0];

        System.out.println(a[9]);
    }

    public static int countChar(String str, char c) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }
}

