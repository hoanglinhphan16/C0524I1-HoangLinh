package ManageCodeGym.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidate {
    private static Pattern pattern;
    private static Matcher matcher;

    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";

    public static boolean validate(String email) {
        pattern = Pattern.compile(EMAIL_REGEX);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
