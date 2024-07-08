package ss1_introduction_java.bai_tap;

public class NumberToWords {
    // Arrays for number words
    private static final String[] units = {
            "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
    };
    private static final String[] teens = {
            "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen",
            "sixteen", "seventeen", "eighteen", "nineteen"
    };
    private static final String[] tens = {
            "", "", "twenty", "thirty", "forty", "fifty",
            "sixty", "seventy", "eighty", "ninety"
    };
    private static final String[] thousands = {
            "", "thousand", "million", "billion"
    };

    // Main function to convert a number to words
    public static String convert(int n) {
        if (n == 0) {
            return "zero";
        }

        String words = "";
        int thousandCounter = 0;

        // Process each group of three digits
        while (n > 0) {
            if (n % 1000 != 0) {
                words = convertLessThanOneThousand(n % 1000) + " " + thousands[thousandCounter] + " " + words;
            }
            n /= 1000;
            thousandCounter++;
        }

        return words.trim();
    }

    // Helper function to convert numbers less than 1000
    private static String convertLessThanOneThousand(int num) {
        if (num < 10) {
            return units[num];
        } else if (num < 20) {
            return teens[num - 10];
        } else if (num < 100) {
            return tens[num / 10] + (num % 10 != 0 ? " " + units[num % 10] : "");
        } else {
            return units[num / 100] + " hundred" + (num % 100 != 0 ? " and " + convertLessThanOneHundred(num % 100) : "");
        }
    }

    // Helper function to convert numbers less than 100
    private static String convertLessThanOneHundred(int num) {
        if (num < 10) {
            return units[num];
        } else if (num < 20) {
            return teens[num - 10];
        } else {
            return tens[num / 10] + (num % 10 != 0 ? " " + units[num % 10] : "");
        }
    }

    // Main method to test the conversion
    public static void main(String[] args) {
        System.out.println(convert(123456789));  // Output: "one hundred and twenty-three million four hundred and fifty-six thousand seven hundred and eighty-nine"
    }
}
