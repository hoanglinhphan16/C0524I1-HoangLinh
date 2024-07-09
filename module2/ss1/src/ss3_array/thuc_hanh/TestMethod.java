package ss3_array.thuc_hanh;

public class TestMethod {
    public static void main(String[] args) {
        int result = countChar("Phan Thanh Hoang Linh", 'a');
        System.out.println(result);
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

