package ss19_string_regex.bai_tap;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatenNameClass {
    private static Matcher matcher;
    private static final String NAME_CLASS_REGEX = "^[CAP]\\d{4}[GHIK]$";

    public static boolean validate(String className) {
        Pattern pattern = Pattern.compile(NAME_CLASS_REGEX);
        matcher = pattern.matcher(className);
        return matcher.matches();
    }

    public static void main(String[] args) {
        String[] testClasses = {"C1234G", "A5678H", "P9101I", "X1234G", "C12345G", "C1234A", "C0223G", "A0323K", "M0318G", "P0323A"};

        for (String className : testClasses) {
            boolean isValid = validate(className);
            System.out.println(className + " is valid: " + isValid);
        }
    }
}
