package ss19_string_regex.thuc_hanh;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Practice {
    public static void main(String[] args) {
        String text1 = "Hello java regex 2-12-2018, hello world 12/12/2018";

        Pattern pattern = Pattern.compile("\\\\d{1,2}[-|/]\\\\d{1,2}[-|/]\\\\d{4}");
        Matcher matcher = pattern.matcher(text1);
        System.out.println("Ngày tháng trong chuỗi text1: " + text1);
        while (matcher.find()) {
            System.out.println("matcher.group()" + matcher.group());
            System.out.println(text1.substring(matcher.start(), matcher.end()));
        }

        String text2 = "2/12/2018";

        String text3 = "12/12/aaaa";

        pattern = Pattern.compile("^\\d{1,2}[-|/]\\d{1,2}[-|/]\\d{4}$");

        System.out.println("\nChuỗi " + text2 + " có định dạng ngày tháng: " + pattern.matcher(text2).matches());

        System.out.println("Chuỗi " + text3 + " có định dạng ngày tháng: " + pattern.matcher(text3).matches());

        System.out.println("Javaqzzce Javazzz Javavcxvcxv".replaceAll("v\\w*", "wi"));
        System.out.println("Java Java Java".replaceFirst("v\\w", "wi"));
    }
}
