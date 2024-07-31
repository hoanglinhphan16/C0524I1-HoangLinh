package ss19_string_regex.bai_tap;

import java.util.regex.Pattern;

public class ValidatePhoneNumber {
    public static void main(String[] args) {
        String regex = "^\\(84\\)-\\(0\\d{9}\\)$";
        Pattern pattern = Pattern.compile(regex);

        String[] testNumbers = {
                "(84)-(0123456789)",
                "(84)-(0987654321)",
                "(85)-(0123456789)",
                "(84)-(123456789)",
                "(84)-(012345678)"
        };

        for (String phoneNumber : testNumbers) {
            boolean isValid = pattern.matcher(phoneNumber).matches();
            System.out.println(phoneNumber + " is valid: " + isValid);
        }
    }
}
