package ManageCodeGym.util;

import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    private static Pattern pattern;
    private static Matcher matcher;

    private static final String ID_REGEX = "^\\d+$";
    private static final String NAME_REGEX = "^[a-zA-Z ]{4,30}$";
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private static final String PHONENUMBER_REGEX = "^(\\+84|090|093)\\d{7}$";
    private static final String CLASSNAME_REGEX = "^C\\d{4}([GILHK])\\d$";
    private static final String LEVEL_REGEX = "^[a-zA-Z]{4,}$";

    public static String validateEmail(Scanner scanner) {
        String email = null;
        boolean validFormat;
        do {
            System.out.println("Enter student email: ");
            email = scanner.nextLine();
            validFormat = email.matches(EMAIL_REGEX);
            if (!validFormat) {
                System.out.println("Invalid email format");
            }
        } while (!validFormat);

        return email;
    }

    public static LocalDate validateDateOfBirth(Scanner scanner) {
        LocalDate birthDate = null;
        boolean validFormat = false;

        while (!validFormat) {
            System.out.println("Enter student birth date (format dd/MM/yyyy): ");
            String temp = scanner.nextLine();
            try {
                birthDate = LocalDate.parse(temp);
                validFormat = true;
            } catch (DateTimeException e) {
                System.out.println("Wrong format. Please enter the date in YYYY-MM-DD format.");
            }
        }
        return birthDate;
    }

    public static String validateName(Scanner scanner) {
        String name = null;
        boolean validFormat = false;

        while (!validFormat) {
            System.out.println("Enter student name: ");
            name = scanner.nextLine();
            validFormat = name.matches(NAME_REGEX);
            if (!validFormat) {
                System.out.println("Invalid name format");
            }
        }
        return name;
    }
    
    public static String validatePhoneNumber(Scanner scanner) {
        String phoneNumber = null;
        boolean validFormat = false;
        
        while (!validFormat) {
            System.out.println("Enter student phone number: ");
            phoneNumber = scanner.nextLine();
            validFormat = phoneNumber.matches(PHONENUMBER_REGEX);
            if (!validFormat) {
                System.out.println("Invalid phone number format");
            }
        }
        return phoneNumber;
    }

    public static String validateClassName(Scanner scanner) {
        String className = null;
        boolean validFormat = false;
        while (!validFormat) {
            System.out.println("Enter student class name: ");
            className = scanner.nextLine();
            validFormat = className.matches(CLASSNAME_REGEX);
            if (!validFormat) {
                System.out.println("Invalid class name format");
            }
        }

        return className;
    }

    public static String validateId(Scanner scanner) {
        String id = null;
        boolean validFormat = false;
        while (!validFormat) {
            System.out.println("Enter student id: ");
            id = scanner.nextLine();
            validFormat = id.matches(ID_REGEX);
            if (!validFormat) {
                System.out.println("Invalid student id format. Must be a number, cannot be duplicate");
            }
        }
        return id;
    }

    public static String validateLevel(Scanner scanner) {
        String level = null;
        boolean validFormat = false;
        while (!validFormat) {
            System.out.println("Enter student class name: ");
            level = scanner.nextLine();
            validFormat = level.matches(LEVEL_REGEX);
            if (!validFormat) {
                System.out.println("Invalid class name format");
            }
        }
        return level;
    }
}
